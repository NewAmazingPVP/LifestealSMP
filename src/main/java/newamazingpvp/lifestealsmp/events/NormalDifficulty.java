package newamazingpvp.lifestealsmp.events;

import org.bukkit.*;

import java.time.Duration;
import java.time.ZoneId;
import java.time.ZonedDateTime;

import static newamazingpvp.lifestealsmp.LifestealSMP.lifestealSmp;
import static newamazingpvp.lifestealsmp.discord.DiscordBot.sendDiscordNewsMessage;
import static newamazingpvp.lifestealsmp.utility.TimeManager.*;
import static newamazingpvp.lifestealsmp.utility.TimeManager.formatDuration;
import static org.bukkit.Bukkit.getServer;

public class NormalDifficulty extends BaseEvent {
    public NormalDifficulty(ZonedDateTime time) {
        super(time, time.plusHours(2));
    }

    @Override
    public void onEventStart() {
        for (World w : Bukkit.getWorlds()) {
            w.setDifficulty(Difficulty.NORMAL);
        }
        sendDiscordNewsMessage(mcServer + "Server is now set to normal difficulty.", "1032411739351941120");
    }

    @Override
    public void onEventEnd() {

    }

    @Override
    public void doWarning() {
        Bukkit.getServer().broadcastMessage(ChatColor.DARK_PURPLE + "Server will be made normal difficulty in " + formatDuration(startTime) + ". Check announcements");
        //sendDiscordNewsEmbedTitle("Custom items and runes!", Color.GREEN, "1032411739351941120");
        sendDiscordNewsMessage(" In " + formatDuration(startTime) + ", server will be made normal difficulty.", "1032411739351941120");
    }

    @Override
    public EventType getType() {
        return EventType.ONETIME;
    }

    @Override
    public void runContinuously(){

    }
}
