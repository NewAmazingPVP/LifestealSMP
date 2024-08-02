package newamazingpvp.lifestealsmp.events;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;

import java.time.ZonedDateTime;

import static newamazingpvp.lifestealsmp.customitems.item.HeartItems.heartMultipliers;
import static newamazingpvp.lifestealsmp.discord.DiscordBot.sendDiscordNewsMessage;
import static newamazingpvp.lifestealsmp.events.TimeManager.eventRole;
import static newamazingpvp.lifestealsmp.events.TimeManager.formatDuration;
import static newamazingpvp.lifestealsmp.runes.RuneHandler.runeMultiplier;

public class DropMultiplier extends BaseEvent {
    private final double multiplier;

    public DropMultiplier(ZonedDateTime startTime, double multiply) {
        super(startTime, startTime.plusDays(1));
        multiplier = multiply;
    }

    @Override
    public void onEventStart() {
        Bukkit.getServer().broadcastMessage(ChatColor.DARK_PURPLE + "All custom drop multiplier event starting now, Check announcements /discord");
        sendDiscordNewsMessage(eventRole + " All custom drop (heart,rune,etc) multiplier event is now active, with a multiplier of " + (multiplier - 1) * 100 + "%. The custom drops (heart, rune, etc.) be dropped more frequently from mobs!", "1032411739351941120");
        runeMultiplier = multiplier;
        heartMultipliers = multiplier;
    }

    @Override
    public void onEventEnd() {
        Bukkit.getServer().broadcastMessage(ChatColor.DARK_PURPLE + "All custom drop multiplier (heart, rune, etc.) event is now over, Check announcements");
        sendDiscordNewsMessage("All custom drop (heart, rune, etc.) multiplier event is now over", "1032411739351941120");
        runeMultiplier = 1;
        heartMultipliers = 1;
    }

    @Override
    public void doWarning() {
        Bukkit.getServer().broadcastMessage(ChatColor.DARK_PURPLE + "All custom drop (heart, rune, etc.) multiplier event happening in " + formatDuration(startTime) + "! Check announcements /discord");
        sendDiscordNewsMessage(eventRole + " In " + formatDuration(startTime) + ", the custom drop (heart, rune, etc.) multiplier event will start with a multiplier of " + (multiplier - 1) * 100 + "%. The custom drops (heart, rune, etc.)  be dropped more frequently from mobs!", "1032411739351941120");
    }

    @Override
    public EventType getType() {
        return EventType.DAY;
    }

    @Override
    public void runContinuously() {
        runeMultiplier = multiplier;
        heartMultipliers = multiplier;
        Bukkit.getServer().broadcastMessage(ChatColor.DARK_PURPLE + "All custom drop multiplier event is happening, Check announcements /discord");
        getCooldownManager().setCooldown(1000);
    }
}