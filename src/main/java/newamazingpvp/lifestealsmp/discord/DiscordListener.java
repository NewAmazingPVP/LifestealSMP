package newamazingpvp.lifestealsmp.discord;

import com.destroystokyo.paper.event.player.PlayerAdvancementCriterionGrantEvent;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.event.inventory.CraftItemEvent;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import org.bukkit.event.player.PlayerAdvancementDoneEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.plugin.Plugin;

import java.awt.*;
import java.lang.reflect.Method;

import static newamazingpvp.lifestealsmp.LifestealSMP.lifestealSmp;
import static newamazingpvp.lifestealsmp.utility.DiscordBot.*;

public class DiscordListener implements Listener {
    @EventHandler
    public void messageSent(AsyncPlayerChatEvent event) {
        if(!event.isCancelled()){
            sendWebhook(event.getPlayer(), event.getMessage());
        }
    }

    @EventHandler
    public void playerJoin(PlayerJoinEvent event) {
        if(isVanished(event.getPlayer())) return;
        Player p = event.getPlayer();
        if(p.hasPlayedBefore()) {
            String joinMessage = event.getJoinMessage();
            if (joinMessage != null && !joinMessage.isEmpty()) {
                String s = p.getName() + " joined the SMP server";
                sendDiscordEmbedPlayer(s, Color.GREEN, channelId, event.getPlayer().getName());
            }
        } else {
            String s = p.getName() + " joined the SMP server for the first time";
            sendDiscordEmbedPlayer(s, Color.CYAN, channelId, event.getPlayer().getName());
        }
    }

    @EventHandler
    public void playerLeave(PlayerQuitEvent event) {
        if(isVanished(event.getPlayer())) return;
        String s = event.getPlayer().getName() + " left the SMP server";
        sendDiscordEmbedPlayer(s, Color.RED, channelId, event.getPlayer().getName());
    }

    @EventHandler
    public void onAchievement(PlayerAdvancementCriterionGrantEvent event) {
        if(isVanished(event.getPlayer())) return;
        if(event.getCriterion().contains("has") || event.getCriterion().contains("minecraft:")) return;
        String s = event.getPlayer().getName() + " has made the advancement " + event.getCriterion();
        sendDiscordEmbedPlayer(s, Color.ORANGE, channelId, event.getPlayer().getName());
    }

    @EventHandler
    public void onPlayerDeath(PlayerDeathEvent event) {
        if(isVanished(event.getPlayer())) return;
        String s = event.getDeathMessage();
        sendDiscordEmbedPlayer(s, Color.BLACK, channelId, event.getPlayer().getName());
    }

    public static boolean isVanished(Player player) {
        try {
            Plugin essentials = Bukkit.getPluginManager().getPlugin("Essentials");
            Method getUser = essentials.getClass().getMethod("getUser", String.class);
            Object essentialsPlayer = getUser.invoke(essentials, player.getName());
            if (essentialsPlayer != null) {
                Method isVanished = essentialsPlayer.getClass().getMethod("isVanished");
                return (boolean) isVanished.invoke(essentialsPlayer);
            }
        } catch (Exception ignored) {
        }
        return false;
    }

}
