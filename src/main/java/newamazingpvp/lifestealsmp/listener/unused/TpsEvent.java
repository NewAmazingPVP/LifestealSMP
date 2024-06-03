package newamazingpvp.lifestealsmp.listener.unused;

import newamazingpvp.lifestealsmp.game.TpsChangeEvent;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.scheduler.BukkitRunnable;

import java.util.Arrays;
import java.util.OptionalDouble;

import static newamazingpvp.lifestealsmp.LifestealSMP.lifestealSmp;
import static org.bukkit.Bukkit.getServer;

public class TpsEvent implements Listener {

    private static double lastTps = 20;

    public static void checkTps() {
        BukkitRunnable broadcastShopTask = new BukkitRunnable() {
            @Override
            public void run() {
                double[] tps = getServer().getTPS();

                OptionalDouble finalTps = Arrays.stream(tps).findFirst();
                double ticks = finalTps.orElse(20.0);
                if (ticks > 20.0) {
                    ticks = 20.0;
                }
                if ((ticks - lastTps) < -0.2) {
                    TpsChangeEvent event = new TpsChangeEvent(ticks);
                    getServer().getPluginManager().callEvent(event);
                    lastTps = ticks;
                } else {
                    for (Player p : Bukkit.getOnlinePlayers()) {
                        p.setViewDistance(p.getViewDistance() + 1);
                        p.sendMessage("increase render");
                    }
                }
            }
        };


        broadcastShopTask.runTaskTimer(lifestealSmp, 0, 20);
    }

    @EventHandler
    public void tpsChange(TpsChangeEvent e) {
        for (Player p : Bukkit.getOnlinePlayers()) {
            p.setViewDistance(p.getViewDistance() - 1);
            p.sendMessage("Decrease render");
        }
    }
}
