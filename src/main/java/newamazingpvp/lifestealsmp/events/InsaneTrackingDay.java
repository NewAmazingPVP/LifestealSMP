package newamazingpvp.lifestealsmp.events;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;

import java.time.ZonedDateTime;

import static newamazingpvp.lifestealsmp.discord.DiscordBot.sendDiscordNewsMessage;
import static newamazingpvp.lifestealsmp.events.TimeManager.eventRole;
import static newamazingpvp.lifestealsmp.events.TimeManager.formatDuration;
import static newamazingpvp.lifestealsmp.game.Compass.*;

public class InsaneTrackingDay extends BaseEvent {

    private final double timeDelay;

    public InsaneTrackingDay(ZonedDateTime startTime, double timeDelay) {
        super(startTime, startTime.plusDays(1));
        this.timeDelay = timeDelay;
    }

    @Override
    public void onEventStart() {
        Bukkit.getServer().broadcastMessage(ChatColor.DARK_PURPLE + "Insane /track day happening, Check announcements /discord");
        sendDiscordNewsMessage(eventRole + "/track will now show exact blocks away and update with no delay, for a day. **It is not advisable to stay at your bases today for that reason....**", "1032411739351941120");
        trackingDist = 1;
        delayDuration = timeDelay;
        resetCompass();
        compassUpdate();
    }

    @Override
    public void onEventEnd() {
        Bukkit.getServer().broadcastMessage(ChatColor.DARK_PURPLE + "Insane /track day is now over, Check /discord announcements");
        sendDiscordNewsMessage("Insane /track day is now over", "1032411739351941120");
        trackingDist = 250;
        delayDuration = 45;
        resetCompass();
        compassUpdate();
    }

    @Override
    public void doWarning() {
        Bukkit.getServer().broadcastMessage(ChatColor.DARK_PURPLE + "Insane /track day happening in " + formatDuration(startTime) + "! Check announcements /discord");
        //sendDiscordNewsEmbedTitle("Custom items and runes!", Color.GREEN, "1032411739351941120");
        sendDiscordNewsMessage(eventRole + " In " + formatDuration(startTime) + ", /track will be made to show exact blocks away with no delay cooldown (aka insane op tracking), for a day.", "1032411739351941120");
    }

    @Override
    public EventType getType() {
        return EventType.DAY;
    }

    @Override
    public void runContinuously() {
        trackingDist = 1;
        delayDuration = timeDelay;
        resetCompass();
        compassUpdate();
        Bukkit.getServer().broadcastMessage(ChatColor.DARK_PURPLE + "Insane /track day happening, Check announcements /discord. Protect yourself from hunters and use invisible potions to make yourself untrackable");
        getCooldownManager().setCooldown(1000);
    }
}
