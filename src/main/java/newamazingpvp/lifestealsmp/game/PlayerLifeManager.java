package newamazingpvp.lifestealsmp.game;

import newamazingpvp.lifestealsmp.utility.DataBaseHelper;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.OfflinePlayer;
import org.bukkit.entity.Player;

import java.io.File;
import java.sql.SQLException;

import static newamazingpvp.lifestealsmp.LifestealSMP.lifestealSmp;

public class PlayerLifeManager {
    public static DataBaseHelper dataBaseHelper;
    public static void eliminatePlayer(Player p){
        dataBaseHelper = new DataBaseHelper(lifestealSmp.getDataFolder().getAbsolutePath() + File.separator + "eliminated.db");

        dataBaseHelper.createTable("player_data", "player_name TEXT");

        dataBaseHelper.insertData("player_data", "player_name", p.getName());

        p.banPlayer(ChatColor.RED + "You were eliminated! Ask someone to use a revive beacon to revive you!");
    }

    public static boolean revivePlayer(OfflinePlayer p, Player sender) throws SQLException {
        dataBaseHelper = new DataBaseHelper(lifestealSmp.getDataFolder().getAbsolutePath() + File.separator + "eliminated.db");

        dataBaseHelper.createTable("player_data", "player_name TEXT");

        if(dataBaseHelper.doesPlayerExist(p.getName())){
            Bukkit.getServer().getBanList(org.bukkit.BanList.Type.NAME).pardon(p.getName());
            dataBaseHelper.deletePlayer(p.getName());
            sender.sendMessage(ChatColor.GOLD + "Successfully revived " + p.getName());
            return true;
        } else {
            sender.sendMessage(ChatColor.RED + "This player is not eliminated! Enter the right name again");
            return false;
        }
    }
}
