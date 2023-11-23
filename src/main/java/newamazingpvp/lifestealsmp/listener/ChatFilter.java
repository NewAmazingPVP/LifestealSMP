package newamazingpvp.lifestealsmp.listener;

import org.bukkit.ChatColor;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

public class ChatFilter implements Listener {

    @EventHandler
    public void onPlayerChat(AsyncPlayerChatEvent event) {
        String message = event.getMessage();
        Player player = event.getPlayer();
        if (message.contains("dick")) {
            event.setCancelled(true);
            player.sendMessage(ChatColor.RED + "You can not say inappropriate / offensive words in chat!");
            player.playSound(player.getLocation(), Sound.BLOCK_NOTE_BLOCK_PLING, 1.0f, 2.0f);
        }
        if (message.contains("kys")) {
            event.setCancelled(true);
            player.sendMessage(ChatColor.RED + "You can not say inappropriate / offensive words in chat!");
            player.playSound(player.getLocation(), Sound.BLOCK_NOTE_BLOCK_PLING, 1.0f, 2.0f);
        }
        if (message.contains("keep yourself safe")) {
            event.setCancelled(true);
            player.sendMessage(ChatColor.RED + "You can not say inappropriate / offensive words in chat!");
            player.playSound(player.getLocation(), Sound.BLOCK_NOTE_BLOCK_PLING, 1.0f, 2.0f);
        }
        if (message.contains("fag")) {
            event.setCancelled(true);
            player.sendMessage(ChatColor.RED + "You can not say inappropriate / offensive words in chat!");
            player.playSound(player.getLocation(), Sound.BLOCK_NOTE_BLOCK_PLING, 1.0f, 2.0f);
        }
        if (message.contains("nig")) {
            event.setCancelled(true);
            player.sendMessage(ChatColor.RED + "You can not say inappropriate / offensive words in chat!");
            player.playSound(player.getLocation(), Sound.BLOCK_NOTE_BLOCK_PLING, 1.0f, 2.0f);
        }
    }
}
