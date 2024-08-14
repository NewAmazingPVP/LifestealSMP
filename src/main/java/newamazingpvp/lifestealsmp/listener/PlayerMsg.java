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
        if ((event.getMessage().toLowerCase().contains("lag") || event.getMessage().toLowerCase().contains("tps")) &&
                !(
                        event.getMessage().toLowerCase().contains("not lagging") ||
                                event.getMessage().toLowerCase().contains("not laggy") ||
                                event.getMessage().toLowerCase().contains("didnt lag") ||
                                event.getMessage().toLowerCase().contains("llage") ||
                                event.getMessage().toLowerCase().contains("https")
                )) {
            OptionalDouble tpsTest = Arrays.stream(getServer().getTPS()).findFirst();
            double tps = tpsTest.orElse(20.0);
            if (tps > 20.0) {
                tps = 20.0;
            }
            DecimalFormat decimalFormat = new DecimalFormat("#.##");
            double finalTps = Double.parseDouble(decimalFormat.format(tps));
            Bukkit.getScheduler().runTaskLater(lifestealSmp, new Runnable() {
                @Override
                public void run() {
                    if (finalTps > 18.00) {
                        for (Player p : Bukkit.getServer().getOnlinePlayers()) {
                            p.sendMessage("The server currently has " + ChatColor.AQUA + finalTps + ChatColor.WHITE + " tps and is not lagging.");
                        }
                    } else {
                        for (Player p : Bukkit.getServer().getOnlinePlayers()) {
                            p.sendMessage("The server currently has " + ChatColor.RED + finalTps + "tps and could be lagging");
                        }
                    }
                }
            }, 20);
        }
        if ((event.getMessage().toLowerCase().contains("tp") || (event.getMessage().toLowerCase().contains("teleport") && !event.getMessage().toLowerCase().contains("tps"))) && !event.getMessage().toLowerCase().contains("outpost")) {
            Bukkit.getScheduler().runTaskLater(lifestealSmp, new Runnable() {
                @Override
                public void run() {
                    for (Player p : Bukkit.getServer().getOnlinePlayers()) {
                        p.sendMessage(ChatColor.RED + "This server does not have tp and you should not ask admins to teleport you (do /rules) " + ChatColor.YELLOW + event.getPlayer().getName());

                    }
                }
            }, 20);
        }
        if (event.getMessage().toLowerCase().contains("hit me")) {
            Bukkit.getScheduler().runTaskLater(lifestealSmp, new Runnable() {
                @Override
                public void run() {
                    for (Player p : Bukkit.getServer().getOnlinePlayers()) {
                        p.sendMessage(ChatColor.RED + "Be careful as " + ChatColor.YELLOW + event.getPlayer().getName() + ChatColor.DARK_RED + " might be trying to get rid of newbie protection of newbies by asking to hit them");
                    }
                }
            }, 20);
        }
        if (event.getMessage().toLowerCase().contains("stuck") ||
                event.getMessage().toLowerCase().contains("trap") ||
                event.getMessage().toLowerCase().contains("hole")) {
            Bukkit.getScheduler().runTaskLater(lifestealSmp, new Runnable() {
                @Override
                public void run() {
                    for (Player p : Bukkit.getServer().getOnlinePlayers()) {
                        p.sendMessage(ChatColor.RED + "If you are stuck " + ChatColor.YELLOW + event.getPlayer().getName() + ChatColor.DARK_RED + " at vicinity of spawn, then do " + ChatColor.AQUA + "/spawn" + ChatColor.DARK_RED + " to get out");
                    }
                }
            }, 20);
        }
        if (event.getMessage().toLowerCase().contains("item") ||
                event.getMessage().toLowerCase().contains("custom") ||
                event.getMessage().toLowerCase().contains("heart") ||
                event.getMessage().toLowerCase().contains("recipe") ||
                event.getMessage().toLowerCase().contains("craft")) {
            Bukkit.getScheduler().runTaskLater(lifestealSmp, new Runnable() {
                @Override
                public void run() {
                    for (Player p : Bukkit.getServer().getOnlinePlayers()) {
                        p.sendMessage(ChatColor.AQUA + "Do /recipes " + ChatColor.YELLOW + event.getPlayer().getName() + ChatColor.GREEN + " to see how to craft hearts and other custom items!");
                    }
                }
            }, 20);
        }
        if (event.getMessage().toLowerCase().contains("lose") ||
                event.getMessage().toLowerCase().contains("lost") ||
                event.getMessage().toLowerCase().contains("heart") ||
                event.getMessage().toLowerCase().contains("lifesteal")){
            Bukkit.getScheduler().runTaskLater(lifestealSmp, new Runnable() {
                @Override
                public void run() {
                    for (Player p : Bukkit.getServer().getOnlinePlayers()) {
                        p.sendMessage(ChatColor.AQUA + "In this lifesteal server, hearts are only lost when killed by a player and not by environmental causes. However you could also get killed by player during your newbie or death protection and still not lose heart if you had the protection");
                    }
                }
            }, 20);
        }
        if (event.getMessage().toLowerCase().contains("runes") ||
                event.getMessage().toLowerCase().contains("rune")) {
            Bukkit.getScheduler().runTaskLater(lifestealSmp, new Runnable() {
                @Override
                public void run() {
                    for (Player p : Bukkit.getServer().getOnlinePlayers()) {
                        p.sendMessage(ChatColor.AQUA + "Do /runes to learn about runes!");
                    }
                }
            }, 20);
        }
        if (event.getMessage().toLowerCase().contains("cap") ||
                event.getMessage().toLowerCase().contains("limit")) {
            Bukkit.getScheduler().runTaskLater(lifestealSmp, new Runnable() {
                @Override
                public void run() {
                    for (Player p : Bukkit.getServer().getOnlinePlayers()) {
                        p.sendMessage(ChatColor.AQUA + "You can go above heart cap by using health and absorption runes. Do /runes to learn about runes!");
                    }
                }
            }, 20);
        }
        if (event.getMessage().toLowerCase().contains("prot")) {
            Bukkit.getScheduler().runTaskLater(lifestealSmp, new Runnable() {
                @Override
                public void run() {
                    for (Player p : Bukkit.getServer().getOnlinePlayers()) {
                        p.sendMessage(ChatColor.AQUA + "The server has newbie prot for 2 hours of playtime for each player and death prot for 15 minutes after your death. During the prot, you are immune to damage from other players unless you hit them back, but even if killed during the prot, you will not lose any hearts.");
                    }
                }
            }, 20);
        }
    }
}
