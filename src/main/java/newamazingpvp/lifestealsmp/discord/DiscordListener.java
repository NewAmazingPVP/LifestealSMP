package newamazingpvp.lifestealsmp.discord;

import com.destroystokyo.paper.event.player.PlayerAdvancementCriterionGrantEvent;
import com.google.common.collect.Iterables;
import com.google.common.io.ByteArrayDataOutput;
import com.google.common.io.ByteStreams;
import io.sentry.util.Objects;
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
import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.serializer.plain.PlainTextComponentSerializer;
import org.json.simple.JSONObject;

import java.awt.*;
import java.lang.reflect.Method;

import static newamazingpvp.lifestealsmp.LifestealSMP.lifestealSmp;
import static newamazingpvp.lifestealsmp.utility.DiscordBot.*;

public class DiscordListener implements Listener {
    @EventHandler
    public void messageSent(AsyncPlayerChatEvent event) {
        if(!event.isCancelled()){
            if(event.getFormat().toLowerCase().contains("team")) return;
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

    /*@EventHandler
    public void onAchievement(PlayerAdvancementCriterionGrantEvent event) {
        if(isVanished(event.getPlayer())) return;
        if(event.getCriterion().contains("has") || event.getCriterion().contains("minecraft:")) return;
        String s = event.getPlayer().getName() + " has made the advancement " + event.getCriterion();
        sendDiscordEmbedPlayer(s, Color.ORANGE, channelId, event.getPlayer().getName());
    }*/

    @EventHandler
    public void onAdvancement(PlayerAdvancementDoneEvent event) {
        var component = event.message();
        if (component == null) {
            return;
        }

        var advancement = event.getAdvancement().getDisplay();

        if (advancement == null) return;

        var title = getComponentText(advancement.title());
        var description = getComponentText(advancement.description());

        ByteArrayDataOutput out = ByteStreams.newDataOutput();
        out.writeUTF("Server");
        // + "|" + description
        JSONObject dataObject = new JSONObject();
        dataObject.put("message", event.getPlayer().getName() + " has made the advancement " + title + "!");
        dataObject.put("category", "advancement");
        dataObject.put("playerName", event.getPlayer().getName());

        out.writeUTF(dataObject.toJSONString());

        Player pl = Iterables.getFirst(Bukkit.getOnlinePlayers(), null);

        if (pl != null) {
            pl.sendPluginMessage(lifestealSmp, "BungeeCord", out.toByteArray());
        }

    }

    private String getComponentText(Component component) {
        return PlainTextComponentSerializer.plainText().serialize((component));
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
