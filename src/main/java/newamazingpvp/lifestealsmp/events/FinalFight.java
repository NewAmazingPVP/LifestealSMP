package newamazingpvp.lifestealsmp.events;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;

import java.awt.*;
import java.time.ZonedDateTime;

import static newamazingpvp.lifestealsmp.discord.DiscordBot.sendDiscordNewsEmbedTitle;
import static newamazingpvp.lifestealsmp.discord.DiscordBot.sendDiscordNewsMessage;
import static newamazingpvp.lifestealsmp.utility.TimeManager.*;
import static org.bukkit.Bukkit.getServer;

public class FinalFight extends BaseEvent{
    public FinalFight(ZonedDateTime startTime) {
        super(startTime, startTime.plusHours(1));
    }

    @Override
    public void onEventStart() {
        Bukkit.getServer().broadcastMessage(ChatColor.DARK_PURPLE + "Final fight is starting!");
        sendDiscordNewsEmbedTitle("Final fight is on!", Color.GREEN, "1032411739351941120");
        sendDiscordNewsMessage(mcServer + " Final fight has begun! May the best win goodluck!", "1032411739351941120");
        getServer().dispatchCommand(getServer().getConsoleSender(), "startendfight");
    }

    @Override
    public void onEventEnd() {
        Bukkit.getServer().broadcastMessage(ChatColor.DARK_PURPLE + "This season has concluded. Thank you for participating! Next season will start in 1 week");
        sendDiscordNewsMessage("The next season will start in a week!", "1032411739351941120");
    }

    @Override
    public void doWarning() {
        sendDiscordNewsMessage(eventRole + " Final fight in exactly " + formatDuration(startTime) + "! Be prepared, for this fight you will be teleported automatically in-game and the last one standing will be the winner of this season!", "1032411739351941120");
    }

    @Override
    public EventType getType() {
        return EventType.HOUR;
    }

    @Override
    public void runContinuously() {
        Bukkit.getServer().broadcastMessage(ChatColor.DARK_PURPLE + "Final fight event is happening! May the best win this season!");
    }
}
