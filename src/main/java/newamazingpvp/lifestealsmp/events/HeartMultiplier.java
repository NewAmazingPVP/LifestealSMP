package newamazingpvp.lifestealsmp.events;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;

import java.time.ZonedDateTime;

import static newamazingpvp.lifestealsmp.customitems.item.HeartItems.heartMultipliers;
import static newamazingpvp.lifestealsmp.discord.DiscordBot.sendDiscordNewsMessage;
import static newamazingpvp.lifestealsmp.events.TimeManager.eventRole;
import static newamazingpvp.lifestealsmp.events.TimeManager.formatDuration;

public class HeartMultiplier extends BaseEvent {
    private final double multiplier;

    public HeartMultiplier(ZonedDateTime startTime, double multiply) {
        super(startTime, startTime.plusDays(1));
        this.multiplier = multiply;
    }

    @Override
    public void onEventStart() {
        Bukkit.getServer().broadcastMessage(ChatColor.DARK_PURPLE + "Heart multiplier event starting now, Check announcements /discord");
        sendDiscordNewsMessage(eventRole + " Heart multiplier event is now active, with a multiplier boost of " + (multiplier - 1) * 100 + "%. The mob soul (aka used to craft hearts /recipes) will be dropped more frequently from mobs!", "1032411739351941120");
        heartMultipliers = multiplier;
    }

    @Override
    public void onEventEnd() {
        Bukkit.getServer().broadcastMessage(ChatColor.DARK_PURPLE + "Heart multiplier event is now over, Check /discord announcements");
        sendDiscordNewsMessage("Heart multiplier event is now over", "1032411739351941120");
        heartMultipliers = 1;
    }

    @Override
    public void doWarning() {
        Bukkit.getServer().broadcastMessage(ChatColor.DARK_PURPLE + "Heart multiplier event happening in " + formatDuration(startTime) + "! Check announcements /discord");
        sendDiscordNewsMessage(eventRole + " In " + formatDuration(startTime) + ", the heart multiplier event will start with a multiplier of " + (multiplier - 1) * 100 + "%. The mob soul (aka used to craft hearts /recipes) will be dropped more frequently from mobs!", "1032411739351941120");
    }

    @Override
    public EventType getType() {
        return EventType.DAY;
    }

    @Override
    public void runContinuously() {
        heartMultipliers = multiplier;
        Bukkit.getServer().broadcastMessage(ChatColor.DARK_PURPLE + "Heart multiplier event is happening, Check announcements /discord");
        getCooldownManager().setCooldown(1000);
    }
}
