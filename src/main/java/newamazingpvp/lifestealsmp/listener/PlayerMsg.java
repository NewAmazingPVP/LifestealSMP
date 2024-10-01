package newamazingpvp.lifestealsmp.listener;

import net.md_5.bungee.api.ChatColor;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

import java.text.DecimalFormat;
import java.util.Arrays;
import java.util.OptionalDouble;

import static newamazingpvp.lifestealsmp.LifestealSMP.lifestealSmp;
import static org.bukkit.Bukkit.getServer;

public class PlayerMsg implements Listener {

    @EventHandler
    public void playerChat(AsyncPlayerChatEvent event) {
        String message = event.getMessage().toLowerCase();
        Player player = event.getPlayer();

        if (containsAny(message, "lag", "tps") && !containsAny(message, "not lagging", "not laggy", "didnt lag", "llage", "https")) {
            handleTpsChat();
        }

        if (containsAny(message, "tp", "teleport") && !containsAny(message, "tps", "outpost")) {
            broadcastMessage(ChatColor.RED + "This server does not have tp and you should not ask admins to teleport you (do /rules) " + ChatColor.YELLOW + player.getName(), player);
        }

        if (containsAny(message, "hit me", "damage me", "kill me")) {
            broadcastMessage(ChatColor.RED + "Be careful as " + ChatColor.YELLOW + player.getName() + ChatColor.DARK_RED + " might be trying to get rid of newbie protection by asking to hit them.", player);
        }

        if (containsAny(message, "stuck", "trap", "hole")) {
            broadcastMessage(ChatColor.RED + "If you are stuck " + ChatColor.YELLOW + player.getName() + ChatColor.DARK_RED + " near spawn, do " + ChatColor.AQUA + "/spawn" + ChatColor.DARK_RED + " to get out.", player);
        }

        if (containsAny(message, "item", "custom", "heart", "recipe", "craft")) {
            broadcastMessage(ChatColor.AQUA + "Do /recipes " + ChatColor.YELLOW + player.getName() + ChatColor.GREEN + " to see how to craft hearts and other custom items!", player);
        }

        if (containsAny(message, "lose", "lost", "heart", "lifesteal")) {
            broadcastMessage(ChatColor.AQUA + "In this lifesteal server, hearts are only lost when killed by a player, not by environmental causes. You won't lose hearts during newbie or death protection even if killed by another player.", player);
        }

        if (containsAny(message, "runes", "rune")) {
            broadcastMessage(ChatColor.AQUA + "Do /runes to learn about runes!", player);
        }

        /*if (containsAny(message, "cap", "limit")) {
            broadcastMessage(ChatColor.AQUA + "You can go above heart cap using health and absorption runes. Do /runes to learn about runes!");
        }*/

        if (message.contains("prot")) {
            broadcastMessage(ChatColor.AQUA + "The server provides newbie protection for 2 hours and death protection for 15 minutes after a death. During this time, you cannot lose hearts from PvP damage.", player);
        }

        if (message.contains("discord")) {
            Bukkit.getScheduler().runTaskLater(lifestealSmp, () -> getServer().dispatchCommand(getServer().getConsoleSender(), "sudo ** discord"), 20);
        }

        if (message.contains("track")) {
            broadcastMessage(ChatColor.AQUA + "The server has a tracking feature. You can track nearby players using " + ChatColor.GREEN + "/track [playerName]", player);
        }
    }

    private boolean containsAny(String message, String... keywords) {
        return Arrays.stream(keywords).anyMatch(message::contains);
    }

    private void handleTpsChat() {
        OptionalDouble tpsTest = Arrays.stream(getServer().getTPS()).findFirst();
        double tps = tpsTest.orElse(20.0);
        tps = Math.min(tps, 20.0);

        DecimalFormat decimalFormat = new DecimalFormat("#.##");
        String finalTps = decimalFormat.format(tps);

        String tpsMessage = Double.parseDouble(finalTps) > 18.0
                ? ChatColor.AQUA + finalTps + ChatColor.WHITE + " tps and is not lagging."
                : ChatColor.RED + finalTps + ChatColor.WHITE + " tps and could be lagging.";

        broadcastMessage("The server currently has " + tpsMessage);
    }


    private void broadcastMessage(String message, Player player) {
        Bukkit.getScheduler().runTaskLater(lifestealSmp, () -> {
            //for (Player player : Bukkit.getServer().getOnlinePlayers()) {
            player.sendMessage(message);
            //}
        }, 20);
    }

    private void broadcastMessage(String message) {
        Bukkit.getScheduler().runTaskLater(lifestealSmp, () -> {
            for (Player player : Bukkit.getServer().getOnlinePlayers()) {
                player.sendMessage(message);
            }
        }, 20);
    }
}
