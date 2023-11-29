package newamazingpvp.lifestealsmp.utility;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;

import java.util.*;

public class Admin {
    public static final Set<String> admins = new HashSet<>(Arrays.asList("NewAmazingPVP", "Comet99", "Adamktheweirdguy"));

    public static void sendAdminMessage(String s) {
        Collection<? extends Player> onlinePlayers = Bukkit.getOnlinePlayers();

        for (Player onlinePlayer : onlinePlayers) {
            if (admins.contains(onlinePlayer.getName())) {
                onlinePlayer.sendMessage(ChatColor.DARK_PURPLE + "" + ChatColor.BOLD + "[Admin Chat] " + s);
            }
        }
    }
}
