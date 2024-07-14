package newamazingpvp.lifestealsmp.listener;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerLoginEvent;

import java.time.Duration;
import java.time.ZoneId;
import java.time.ZonedDateTime;

import static newamazingpvp.lifestealsmp.utility.TimeManager.SEASON_START_TIME;
import static newamazingpvp.lifestealsmp.utility.TimeManager.formatDuration;

public class ServerOpening implements Listener {
    @EventHandler
    public void onJoin(PlayerLoginEvent event) {
        ZonedDateTime now = ZonedDateTime.now(ZoneId.of("America/New_York"));
        if (Bukkit.getWhitelistedPlayers().contains(event.getPlayer())) {
            return;
        }
        if (now.isBefore(SEASON_START_TIME)) {
            Duration duration = Duration.between(now, SEASON_START_TIME);
            String timeRemaining = formatDuration(duration);
            event.disallow(PlayerLoginEvent.Result.KICK_OTHER, ChatColor.GREEN + "New Lifesteal season is starting in " + timeRemaining + ChatColor.AQUA + " Join discord https://discord.gg/PN8egFY3ap for more info!");
        }
    }
}
