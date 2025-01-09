package newamazingpvp.lifestealsmp.events;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Difficulty;
import org.bukkit.World;

import java.time.ZonedDateTime;

import static newamazingpvp.lifestealsmp.discord.DiscordBot.sendDiscordNewsMessage;
import static newamazingpvp.lifestealsmp.events.TimeManager.*;

public class BorderExpand extends BaseEvent {
    private final int size ;
    public BorderExpand(ZonedDateTime time, int size) {
        super(time, time.plusHours(2));
        this.size = size;
    }

    @Override
    public void onEventStart() {
        for (World w : Bukkit.getWorlds()) {
            w.getWorldBorder().setSize(size);
        }
        sendDiscordNewsMessage(eventRole + " Border is now " + size + " blocks wide.", "1032411739351941120");
        Bukkit.getServer().broadcastMessage(ChatColor.DARK_PURPLE + "Border is now " + size + " blocks wide. Check /discord announcements");
    }

    @Override
    public void onEventEnd() {

    }

    @Override
    public void doWarning() {
        Bukkit.getServer().broadcastMessage(ChatColor.DARK_PURPLE + "Border will be expanded to " + size + " blocks wide in " + formatDuration(startTime) + ". Check /discord announcements");
        sendDiscordNewsMessage(" In " + formatDuration(startTime) + ", border will be expanded to " + size + " blocks wide.", "1032411739351941120");
    }

    @Override
    public EventType getType() {
        return EventType.ONETIME;
    }

    @Override
    public void runContinuously() {

    }
}
