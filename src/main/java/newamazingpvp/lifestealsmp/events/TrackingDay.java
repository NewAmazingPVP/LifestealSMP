package newamazingpvp.lifestealsmp.events;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;

import java.time.Duration;
import java.time.ZoneId;
import java.time.ZonedDateTime;

import static newamazingpvp.lifestealsmp.LifestealSMP.lifestealSmp;
import static newamazingpvp.lifestealsmp.discord.DiscordBot.sendDiscordNewsMessage;
import static newamazingpvp.lifestealsmp.game.Compass.trackingDist;
import static newamazingpvp.lifestealsmp.utility.TimeManager.*;
import static newamazingpvp.lifestealsmp.utility.TimeManager.CUSTOM_ITEMS_AND_RUNES;
import static org.bukkit.Bukkit.getServer;

public class TrackingDay extends BaseEvent {

    private final int blocks;
    //TODO: CHANGE WORDING FROM EXACT BLOCKS TO WHATERVER BLOCKS ANMD SEPARSAE FOR NO TRACKING DAY

    public TrackingDay(ZonedDateTime startTime, int blocks) {
        super(startTime, startTime.plusDays(1));
        this.blocks = blocks;
    }

    @Override
    public void onEventStart() {
        Bukkit.getServer().broadcastMessage(ChatColor.DARK_PURPLE + "Exact block /track day happening, Check announcements /discord");
        getServer().getScheduler().runTaskLater(lifestealSmp, () -> sendDiscordNewsMessage(eventRole + "/track will now show exact blocks away, for a day.", "1032411739351941120"), 1200);
        trackingDist = blocks;
    }

    @Override
    public void onEventEnd() {
        Bukkit.getServer().broadcastMessage(ChatColor.DARK_PURPLE + "Exact block /track day is now over, Check announcements");
        sendDiscordNewsMessage("Exact block /track day is now over", "1032411739351941120");
        trackingDist = 250;
    }

    @Override
    public void doWarning() {
        Bukkit.getServer().broadcastMessage(ChatColor.DARK_PURPLE + "Exact block /track day happening in " + formatDuration(startTime) + " hours! Check announcements /discord");
        //sendDiscordNewsEmbedTitle("Custom items and runes!", Color.GREEN, "1032411739351941120");
        sendDiscordNewsMessage(eventRole + " In " + formatDuration(startTime) + ", /track will be made to show exact blocks away, for a day.", "1032411739351941120");
    }

    @Override
    public EventType getType() {
        return EventType.DAY;
    }
    @Override
    public void runContinuously(){
        trackingDist = blocks;
    }

}
