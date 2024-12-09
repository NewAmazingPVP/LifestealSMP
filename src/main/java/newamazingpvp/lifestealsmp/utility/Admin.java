package newamazingpvp.lifestealsmp.utility;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Admin {
    public static final Set<String> admins = new HashSet<>(Arrays.asList("NewAmazingPVP", "Comet99", "Adamktheweirdguy", "Zinpaii"));

    public static void sendAdminMessage(String s) {
        for (Player onlinePlayer : Bukkit.getOnlinePlayers()) {
            if (admins.contains(onlinePlayer.getName())) {
                onlinePlayer.sendMessage(ChatColor.DARK_PURPLE + "" + ChatColor.BOLD + "[Admin Chat] " + s);
            }
        }
    }
}
