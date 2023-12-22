package newamazingpvp.lifestealsmp.listener;

import com.destroystokyo.paper.event.player.PlayerAdvancementCriterionGrantEvent;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.event.inventory.CraftItemEvent;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import org.bukkit.event.player.PlayerAdvancementDoneEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;

import java.awt.*;

import static newamazingpvp.lifestealsmp.utility.DiscordBot.sendDiscordEmbedPlayer;
import static newamazingpvp.lifestealsmp.utility.DiscordBot.sendWebhook;

public class DiscordListener implements Listener {
    @EventHandler
    public void messageSent(AsyncPlayerChatEvent event) {
        if(!event.isCancelled()){
            sendWebhook(event.getPlayer(), event.getMessage());
        }
    }

    @EventHandler
    public void playerJoin(PlayerJoinEvent event) {
        Player p = event.getPlayer();
        if(p.hasPlayedBefore()) {
            String s = p.getName() + " joined the SMP server";
            sendDiscordEmbedPlayer(s, Color.GREEN, "", event.getPlayer().getName());
        } else {
            String s = p.getName() + " joined the SMP server for the first time";
            sendDiscordEmbedPlayer(s, Color.CYAN, "", event.getPlayer().getName());
        }
    }

    @EventHandler
    public void playerLeave(PlayerQuitEvent event) {
        String s = event.getPlayer().getName() + " left the SMP server";
        sendDiscordEmbedPlayer(s, Color.RED, "", event.getPlayer().getName());
    }

    @EventHandler
    public void onAchievement(PlayerAdvancementDoneEvent event) {
        String s = event.getPlayer().getName() + " has made the advancement " + event.getAdvancement().getKey().getKey();
        sendDiscordEmbedPlayer(s, Color.ORANGE, "", event.getPlayer().getName());
    }

    @EventHandler
    public void onPlayerDeath(PlayerDeathEvent event) {
        String s = event.getDeathMessage();
        sendDiscordEmbedPlayer(s, Color.BLACK, "", event.getPlayer().getName());
    }

}
