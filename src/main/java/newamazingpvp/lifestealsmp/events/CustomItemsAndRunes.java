package newamazingpvp.lifestealsmp.events;

import org.bukkit.*;

import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.Duration;

import static newamazingpvp.lifestealsmp.LifestealSMP.lifestealSmp;
import static newamazingpvp.lifestealsmp.discord.DiscordBot.sendDiscordNewsMessage;
import static newamazingpvp.lifestealsmp.utility.TimeManager.*;
import static org.bukkit.Bukkit.getServer;

public class CustomItemsAndRunes extends BaseEvent {
    public CustomItemsAndRunes() {
        super(SEASON_START_TIME.plusHours(6).plusHours(14), SEASON_START_TIME.plusHours(6).plusHours(16));
    }

    @Override
    public void onEventStart() {
        for (World w : Bukkit.getWorlds()) {
            w.setDifficulty(Difficulty.HARD);
            w.getWorldBorder().setCenter(new Location(w, 0, 0, 0));
            w.getWorldBorder().setSize(25000);
        }
        getServer().getScheduler().runTaskLater(lifestealSmp, () -> sendDiscordNewsMessage(mcServer + " Custom items and runes are now available! Map size expanded to 25k by 25k and difficulty set to hard. " +
                "Runes give permanent effects while in inventory and custom items has special abilities. " +
                "Various buffs/nerfs have been made so do /runes /recipes for more info! " +
                "\n\n**End will open next weekend in " + formatDuration(Duration.between(ZonedDateTime.now(ZoneId.of("America/New_York")), SEASON_START_TIME.plusDays(14).plusHours(2))) + "**", "1032411739351941120"), 1200);
    }

    @Override
    public void onEventEnd() {

    }

    @Override
    public void doWarning() {
        Bukkit.getServer().broadcastMessage(ChatColor.DARK_PURPLE + "Custom items releasing in " + formatDuration(startTime) + " hours! Check announcements");
        //sendDiscordNewsEmbedTitle("Custom items and runes!", Color.GREEN, "1032411739351941120");
        sendDiscordNewsMessage(eventRole + " In " + formatDuration(startTime) + ", custom items /recipes and runes /runes are going to be available! Map size will be expanded to 25k by 25k and difficulty will be set to hard.", "1032411739351941120");
    }

    @Override
    public EventType getType() {
        return EventType.ONETIME;
    }

    @Override
    public void runContinuously(){

    }
}
