package newamazingpvp.lifestealsmp.listener;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerChatEvent;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

import static newamazingpvp.lifestealsmp.LifestealSMP.lifestealSmp;

public class ServerAge implements Listener {
    private final LocalDateTime serverStartTime = LocalDateTime.of(2023, 12, 9, 11, 30);

    @EventHandler
    public void playerServerAge(PlayerChatEvent event) {
        String message = event.getMessage().toLowerCase(); // Convert to lowercase
        List<String> phrasesToMatch = Arrays.asList(
                "how old is the server",
                "when did the server start",
                "how long has the server been",
                "what's the server's age",
                "since when has the server been running",
                "tell me the server's age",
                "from when has the server been active",
                "when was this server created",
                "how much time has the server been online",
                "when was the server initiated",
                "for how long has the server been live",
                "what is the server's founding date",
                "how much time has passed since the server's beginning",
                "when was this server brought into being",
                "when did the server first become active",
                "from what time has the server been up",
                "when did this server open up",
                "how old is server",
                "how long has the server been",
                "how old server",
                "how old is this server",
                "when did server start",
                "server runtime",
                "what is server age",
                "server age"
        );

        for (String phrase : phrasesToMatch) {
            if (message.contains(phrase)) {
                LocalDateTime currentTime = LocalDateTime.now();
                Duration duration = Duration.between(serverStartTime, currentTime);
                long days = duration.toDays();
                long hours = duration.toHoursPart();
                long minutes = duration.toMinutesPart();

                String uptimeMessage = String.format(
                        "The server started on" + ChatColor.AQUA + " 12/9/23 11:30am est" + ChatColor.WHITE + " and has been up for" + ChatColor.GOLD + " %d days, %d hours, and %d minutes.",
                        days, hours, minutes
                );

                Bukkit.getScheduler().runTaskLater(lifestealSmp, new Runnable() {
                    @Override
                    public void run() {
                        for (Player p : Bukkit.getServer().getOnlinePlayers()) {
                            p.sendMessage(uptimeMessage);
                        }
                    }
                }, 20);
                break;
            }
        }
    }
}
