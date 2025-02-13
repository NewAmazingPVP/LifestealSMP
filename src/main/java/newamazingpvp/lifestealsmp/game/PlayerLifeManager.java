package newamazingpvp.lifestealsmp.game;

import newamazingpvp.lifestealsmp.utility.DataBaseHelper;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.OfflinePlayer;
import org.bukkit.entity.Player;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import static newamazingpvp.lifestealsmp.LifestealSMP.lifestealSmp;

public class PlayerLifeManager {
    public static DataBaseHelper dataBaseHelper;

    public static void eliminatePlayer(Player p){
        dataBaseHelper = new DataBaseHelper("eliminated.db");
        dataBaseHelper.createTable("player_data", "player_name TEXT PRIMARY KEY");
        dataBaseHelper.insertData("player_data", new String[]{"player_name"}, p.getName());
        p.banPlayer(ChatColor.RED + "You were eliminated! Ask someone to use a revive beacon to revive you!");
    }

    public static void clearEliminatedPlayers() {
        dataBaseHelper = new DataBaseHelper("eliminated.db");
        dataBaseHelper.deleteData("player_data", "1=1");
    }

    public static boolean revivePlayer(OfflinePlayer p, Player sender) {
        dataBaseHelper = new DataBaseHelper("eliminated.db");
        dataBaseHelper.createTable("player_data", "player_name TEXT PRIMARY KEY");
        List<Map<String, Object>> results = dataBaseHelper.getData("player_data", "player_name = ?", p.getName());
        if (!results.isEmpty()) {
            Bukkit.getServer().getBanList(org.bukkit.BanList.Type.NAME).pardon(p.getName());
            dataBaseHelper.deleteData("player_data", "player_name = ?", p.getName());
            sender.sendMessage(ChatColor.GOLD + "Successfully revived " + p.getName());
            return true;
        } else {
            sender.sendMessage(ChatColor.RED + "This player is not eliminated! Enter the right name again");
            return false;
        }
    }

    public static boolean isEliminated(OfflinePlayer p) {
        dataBaseHelper = new DataBaseHelper("eliminated.db");
        dataBaseHelper.createTable("player_data", "player_name TEXT PRIMARY KEY");
        List<Map<String, Object>> results = dataBaseHelper.getData("player_data", "player_name = ?", p.getName());
        return !results.isEmpty();
    }
}
