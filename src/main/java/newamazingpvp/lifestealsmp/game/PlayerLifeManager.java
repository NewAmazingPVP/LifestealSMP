package newamazingpvp.lifestealsmp.game;

import newamazingpvp.lifestealsmp.utility.DataBaseHelper;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.OfflinePlayer;
import org.bukkit.entity.Player;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

import static newamazingpvp.lifestealsmp.LifestealSMP.lifestealSmp;

public class PlayerLifeManager {
    public static DataBaseHelper dataBaseHelper;

    public static void eliminatePlayer(Player p) throws IOException {
        //dataBaseHelper = new DataBaseHelper(lifestealSmp.getDataFolder().getAbsolutePath() + File.separator + "eliminated.db");

        //dataBaseHelper.createTable("player_data", "player_name TEXT");

        //dataBaseHelper.insertData("player_data", "player_name", p.getName());
        PrintWriter output = new PrintWriter(lifestealSmp.getDataFolder().getAbsolutePath() + File.separator + "friends.txt");
        output.println(p.getName());
        output.close();

        p.banPlayer(ChatColor.RED + "You were eliminated! Ask someone to use a revive beacon to revive you!");
    }

    public static boolean revivePlayer(OfflinePlayer p, Player sender) throws SQLException, IOException {
        /*dataBaseHelper = new DataBaseHelper(lifestealSmp.getDataFolder().getAbsolutePath() + File.separator + "eliminated.db");

        dataBaseHelper.createTable("player_data", "player_name TEXT");

        if (dataBaseHelper.doesPlayerExist(p.getName())) {
            Bukkit.getServer().getBanList(org.bukkit.BanList.Type.NAME).pardon(p.getName());
            dataBaseHelper.deletePlayer(p.getName());
            sender.sendMessage(ChatColor.GOLD + "Successfully revived " + p.getName());
            return true;
        } else {
            sender.sendMessage(ChatColor.RED + "This player is not eliminated! Enter the right name again");
            return false;
        }*/
        File file = new File(lifestealSmp.getDataFolder().getAbsolutePath() + File.separator + "friends.txt");
        Scanner input = new Scanner(file);
        ArrayList<String> names = new ArrayList<>();
        boolean flag = false;
        while (input.hasNext()) {
            String name = input.nextLine();
            if (!name.equals(p.getName())) {
                names.add(name);
            } else {
                flag = true;
            }
        }
        if (!flag) {
            sender.sendMessage(ChatColor.RED + "This player is not eliminated! Enter the right name again");
            return false;
        }
        file.delete();
        File outputFIle = new File(lifestealSmp.getDataFolder().getAbsolutePath() + File.separator + "friends.txt");
        PrintWriter output = new PrintWriter(outputFIle);
        for (String n : names) {
            output.println(n);
        }
        output.close();
        input.close();
        Bukkit.getServer().getBanList(org.bukkit.BanList.Type.NAME).pardon(p.getName());
        sender.sendMessage(ChatColor.GOLD + "Successfully revived " + p.getName());
        return true;
    }
}
