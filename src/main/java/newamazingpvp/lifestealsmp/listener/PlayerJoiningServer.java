package newamazingpvp.lifestealsmp.listener;

import org.bukkit.ChatColor;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class PlayerJoiningServer implements Listener {

    @EventHandler
    public void onJoin(PlayerJoinEvent e) {

        Player player = e.getPlayer();

        player.sendMessage(ChatColor.DARK_PURPLE + "" + ChatColor.BOLD + "=============== [Welcome] ===============");
        player.sendMessage(ChatColor.AQUA + "Use" + ChatColor.RED + " /guide" + ChatColor.AQUA + " For info book.");
        //player.sendMessage(ChatColor.AQUA + "Use" + ChatColor.RED + " /IPHelp" + ChatColor.AQUA + " For info on how to get more then one account on the same IP.");
        player.sendMessage(ChatColor.AQUA + "Use" + ChatColor.RED + " /recipes" + ChatColor.AQUA + " For recipe info.");
        player.sendMessage(ChatColor.AQUA + "Use" + ChatColor.RED + " /discord" + ChatColor.AQUA + " For the discord link.");
        player.sendMessage(ChatColor.GRAY + "(also how you send appeals and reports)");
        //player.sendMessage(ChatColor.AQUA + "Use" + ChatColor.RED + " /easyprefix" + ChatColor.AQUA + " To change your name prefix");
        player.sendMessage(ChatColor.DARK_PURPLE + "" + ChatColor.BOLD + "=========================================");

        player.playSound(player.getLocation(), Sound.ENTITY_PLAYER_LEVELUP, 1.0f, 1.0f);
        player.sendTitle(ChatColor.DARK_GREEN + "Welcome!", "", 0, 70, 20);
    }
}
