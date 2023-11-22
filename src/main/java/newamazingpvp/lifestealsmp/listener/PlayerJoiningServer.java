package newamazingpvp.lifestealsmp.listener;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.event.player.PlayerJoinEvent;

public class PlayerJoiningServer implements Listener {

    @EventHandler
    public void onJoin(PlayerJoinEvent e) {

        Player player = e.getPlayer();

        player.sendMessage(ChatColor.DARK_PURPLE + "" + ChatColor.BOLD + "=============== [Welcome] ===============");
        player.sendMessage(ChatColor.AQUA + "Use" + ChatColor.RED + " /Info" + ChatColor.AQUA + " For info book.");
        player.sendMessage(ChatColor.AQUA + "Use" + ChatColor.RED + " /IPHelp" + ChatColor.AQUA + " For info on how to get more then one account on the same IP.");
        player.sendMessage(ChatColor.AQUA + "Use" + ChatColor.RED + " /recipes" + ChatColor.AQUA + " For recipe info.");
        player.sendMessage(ChatColor.AQUA + "Use" + ChatColor.RED + " /discord_link" + ChatColor.AQUA + " For the discord link.");
        player.sendMessage(ChatColor.GRAY + "(also how you send appeals and reports)");
        player.sendMessage(ChatColor.DARK_PURPLE + "" + ChatColor.BOLD + "=========================================");

    }
}
