package newamazingpvp.lifestealsmp.listener;

import net.md_5.bungee.api.ChatColor;
import org.bukkit.Bukkit;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

import java.text.DecimalFormat;
import java.util.Arrays;
import java.util.OptionalDouble;

import static newamazingpvp.lifestealsmp.LifestealSMP.lifestealSmp;
import static org.bukkit.Bukkit.getServer;

public class PlayerLagMsg implements Listener {
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
                    if (finalTps > 19.01) {
                        for (Player p : Bukkit.getServer().getOnlinePlayers()) {
                            p.sendMessage("The server currently has " + ChatColor.AQUA + finalTps + ChatColor.WHITE + " tps and is not lagging. Check your wifi/ping instead " + ChatColor.YELLOW + event.getPlayer().getName() + ChatColor.WHITE + ". Decrease your render/simulation distance and its recommended for you to use fabously optimized modpack for more performance and less client lag.");
                        }
                    } else {
                        for (Player p : Bukkit.getServer().getOnlinePlayers()) {
                            p.sendMessage("The server currently has " + ChatColor.RED + finalTps + "tps and could be lagging");
                        }
                    }
                }
            }, 20);
        }
        if ((event.getMessage().toLowerCase().contains("tp") || (event.getMessage().toLowerCase().contains("teleport") && !event.getMessage().toLowerCase().contains("tps"))) && !event.getMessage().toLowerCase().contains("outpost")){
            Bukkit.getScheduler().runTaskLater(lifestealSmp, new Runnable() {
                @Override
                public void run() {
                    for (Player p : Bukkit.getServer().getOnlinePlayers()) {
                        p.sendMessage(ChatColor.RED + "This server does not have tp and you should not ask admins to teleport you (do /rules) " + ChatColor.YELLOW + event.getPlayer().getName());

                    }
                }
            }, 20);
        }
    }
}
