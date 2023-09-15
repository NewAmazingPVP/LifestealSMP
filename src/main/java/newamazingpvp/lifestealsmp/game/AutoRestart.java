package newamazingpvp.lifestealsmp.game;

import org.bukkit.ChatColor;
import org.bukkit.scheduler.BukkitRunnable;

import java.util.Calendar;
import java.util.TimeZone;

import static newamazingpvp.lifestealsmp.LifestealSMP.lifestealSmp;

public class AutoRestart {
    private final long[] warningTimes = {10, 7, 5, 3, 2, 1};
    private final String[] warningMessages = {
            "Server will restart in 10 minutes!",
            "Server will restart in 7 minutes!",
            "Server will restart in 5 minutes!",
            "Server will restart in 3 minutes!",
            "Server will restart in 2 minutes!",
            "Server will restart in 1 minute!",
    };
    private void scheduleRestart() {
        Calendar now = Calendar.getInstance(TimeZone.getTimeZone("America/New_York"));
        Calendar restartTime = Calendar.getInstance(TimeZone.getTimeZone("America/New_York"));
        restartTime.set(Calendar.HOUR_OF_DAY, 3);
        restartTime.set(Calendar.MINUTE, 0);
        restartTime.set(Calendar.SECOND, 0);

        if (now.after(restartTime)) {
            restartTime.add(Calendar.DAY_OF_MONTH, 1);
        }

        long initialDelay = restartTime.getTimeInMillis() - now.getTimeInMillis();

        for (int i = 0; i < warningTimes.length; i++) {
            long warningDelay = initialDelay - (warningTimes[i] * 60 * 1000);
            scheduleWarning(warningDelay, warningMessages[i]);
        }

        new BukkitRunnable() {
            @Override
            public void run() {
                restartServer();
            }
        }.runTaskLater(lifestealSmp, initialDelay / 50L);
    }

    private void scheduleWarning(long delay, String message) {
        new BukkitRunnable() {
            @Override
            public void run() {
                broadcastWarning(message);
            }
        }.runTaskLater(lifestealSmp, delay / 50L);
    }

    private void broadcastWarning(String message) {
        lifestealSmp.getServer().broadcastMessage(ChatColor.RED + message);
    }

    private void restartServer() {
        lifestealSmp.getServer().broadcastMessage(ChatColor.AQUA + "Restarting the server...");
        lifestealSmp.getServer().spigot().restart();
    }
}
