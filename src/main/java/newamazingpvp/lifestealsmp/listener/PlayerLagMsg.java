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

public class PlayerLagMsg implements Listener {
    @EventHandler
    public void playerChat(AsyncPlayerChatEvent event) {
        if ((event.getMessage().contains("lag") || event.getMessage().contains("tps")) &&
                !(
                        event.getMessage().contains("not lagging") ||
                                event.getMessage().contains("not laggy") ||
                                event.getMessage().contains("didnt lag") ||
                                event.getMessage().contains("llager") ||
                                event.getMessage().contains("https")
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
                    if (finalTps > 19.93) {
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
    }
}
