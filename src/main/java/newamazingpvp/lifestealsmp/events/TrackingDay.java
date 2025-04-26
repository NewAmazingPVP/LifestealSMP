package newamazingpvp.lifestealsmp.events;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;

import java.time.ZonedDateTime;

import static newamazingpvp.lifestealsmp.discord.DiscordBot.sendDiscordNewsMessage;
import static newamazingpvp.lifestealsmp.events.TimeManager.eventRole;
import static newamazingpvp.lifestealsmp.events.TimeManager.formatDuration;
import static newamazingpvp.lifestealsmp.game.Compass.trackingDist;

public class TrackingDay extends BaseEvent {

    private final int blocks;

    public TrackingDay(ZonedDateTime startTime, int blocks) {
        super(startTime, startTime.plusDays(1));
        this.blocks = blocks;
    }

    @Override
    public void onEventStart() {
        Bukkit.getServer().broadcastMessage(ChatColor.DARK_PURPLE + "Exact block /track day happening, Check announcements /discord");
        sendDiscordNewsMessage(eventRole + " /track will now show exact blocks away, for a day, therefore be careful of surroundings....", "1032411739351941120");
        trackingDist = blocks;
    }

    @Override
    public void onEventEnd() {
        Bukkit.getServer().broadcastMessage(ChatColor.DARK_PURPLE + "Exact block /track day is now over, Check announcements");
        sendDiscordNewsMessage("Exact block /track day is now over", "1032411739351941120");
        trackingDist = 500;
    }

    @Override
    public void doWarning() {
        Bukkit.getServer().broadcastMessage(ChatColor.DARK_PURPLE + "Exact block /track day happening in " + formatDuration(startTime) + "! Check announcements /discord");
        //sendDiscordNewsEmbedTitle("Custom items and runes!", Color.GREEN, "1032411739351941120");
        sendDiscordNewsMessage(eventRole + " In " + formatDuration(startTime) + ", /track will be made to show exact blocks away, for a day.", "1032411739351941120");
    }

    @Override
    public EventType getType() {
        return EventType.DAY;
    }

    @Override
    public void runContinuously() {
        trackingDist = blocks;
        Bukkit.getServer().broadcastMessage(ChatColor.DARK_PURPLE + "Exact block /track day happening, Check announcements /discord");
        getCooldownManager().setCooldown(1000);
    }

}
