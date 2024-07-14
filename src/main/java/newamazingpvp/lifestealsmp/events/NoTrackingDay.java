package newamazingpvp.lifestealsmp.events;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;

import java.time.ZonedDateTime;

import static newamazingpvp.lifestealsmp.LifestealSMP.lifestealSmp;
import static newamazingpvp.lifestealsmp.discord.DiscordBot.sendDiscordNewsMessage;
import static newamazingpvp.lifestealsmp.game.Compass.noTrackingDay;
import static newamazingpvp.lifestealsmp.utility.TimeManager.eventRole;
import static newamazingpvp.lifestealsmp.utility.TimeManager.formatDuration;
import static org.bukkit.Bukkit.getServer;

public class NoTrackingDay extends BaseEvent {

    public NoTrackingDay(ZonedDateTime startTime) {
        super(startTime, startTime.plusHours(1));
    }

    @Override
    public void onEventStart() {
        Bukkit.getServer().broadcastMessage(ChatColor.DARK_PURPLE + "No Tracking Day: Tracking is disabled. Check announcements on Discord.");
        getServer().getScheduler().runTaskLater(lifestealSmp, () -> sendDiscordNewsMessage(eventRole + " /track will be disabled for a day.", "1032411739351941120"), 1200);
        noTrackingDay = true;
    }

    @Override
    public void onEventEnd() {
        Bukkit.getServer().broadcastMessage(ChatColor.DARK_PURPLE + "No Tracking Day is over: Tracking is enabled again. Check announcements on Discord.");
        sendDiscordNewsMessage("No Tracking Day is now over. You can do /track", "1032411739351941120");
        noTrackingDay = false;
    }

    @Override
    public void doWarning() {
        Bukkit.getServer().broadcastMessage(ChatColor.DARK_PURPLE + "No Tracking Day starting in " + formatDuration(startTime) + "! Check announcements on Discord.");
        sendDiscordNewsMessage(eventRole + " In " + formatDuration(startTime) + ", /track will be disabled for an entire day.", "1032411739351941120");
    }

    @Override
    public EventType getType() {
        return EventType.DAY;
    }

    @Override
    public void runContinuously() {
        noTrackingDay = true;
    }
}
