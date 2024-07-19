package newamazingpvp.lifestealsmp.events;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;

import java.awt.*;
import java.time.ZonedDateTime;

import static newamazingpvp.lifestealsmp.discord.DiscordBot.sendDiscordNewsEmbedTitle;
import static newamazingpvp.lifestealsmp.discord.DiscordBot.sendDiscordNewsMessage;
import static newamazingpvp.lifestealsmp.events.TimeManager.*;

public class EndOpeningEvent extends BaseEvent {

    public EndOpeningEvent(ZonedDateTime startTime) {
        super(startTime, startTime.plusHours(1));
    }

    @Override
    public void onEventStart() {
        Bukkit.getServer().broadcastMessage(ChatColor.DARK_PURPLE + "End has now opened!");
        sendDiscordNewsEmbedTitle("End has opened!", Color.GREEN, "1032411739351941120");
        sendDiscordNewsMessage(mcServer + " The end has opened!", "1032411739351941120");
    }

    @Override
    public void onEventEnd() {

    }

    @Override
    public void doWarning() {
        if (!isTimePassed(startTime.minusHours(25))) {
            sendDiscordNewsMessage(eventRole + " End will be opening in " + formatDuration(startTime) + " exactly! Be prepared by **finding a stronghold/portal** to enter for the fight, whoever has the dragon egg in their inventory will get a perk! Furthermore dragon will drop 1 and only dragon rune and custom lifesteal stick when killed!", "1032411739351941120");
        } else {
            sendDiscordNewsMessage(mcServer + " End will be opening in " + formatDuration(startTime) + " exactly! Be prepared by **finding a stronghold/portal** to enter for the fight, whoever has the dragon egg in their inventory will get a perk! Furthermore dragon will drop 1 and only dragon rune and custom lifesteal stick when killed!", "1032411739351941120");
        }
        Bukkit.getServer().broadcastMessage(ChatColor.DARK_PURPLE + "End is opening in " + formatDuration(startTime) + "! Check /discord announcements");
    }

    @Override
    public EventType getType() {
        return EventType.HOUR;
    }

    @Override
    public void runContinuously() {
        Bukkit.getServer().broadcastMessage(ChatColor.DARK_PURPLE + "End has opened! Find a stronghold to enter!");
    }
}
