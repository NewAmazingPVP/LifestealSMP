package newamazingpvp.lifestealsmp.events;

import org.bukkit.*;

import java.time.ZonedDateTime;

import static newamazingpvp.lifestealsmp.discord.DiscordBot.sendDiscordNewsMessage;
import static newamazingpvp.lifestealsmp.events.TimeManager.*;

public class CustomItemsAndRunes extends BaseEvent {
    public CustomItemsAndRunes(ZonedDateTime time) {
        super(time, time.plusHours(2));
    }

    @Override
    public void onEventStart() {
        for (World w : Bukkit.getWorlds()) {
            w.setDifficulty(Difficulty.HARD);
            w.getWorldBorder().setCenter(new Location(w, 0, 0, 0));
            w.getWorldBorder().setSize(25000);
            //w.getWorldBorder().setDamageBuffer(0);
            //w.getWorldBorder().setDamageAmount(4);
            //w.getWorldBorder().setWarningDistance(50);
        }
        sendDiscordNewsMessage(mcServer + " Custom items and runes are now available! Map size expanded to 25k by 25k and difficulty set to hard. " +
                "Runes give permanent effects while in inventory and custom items has special abilities. " +
                "Various buffs/nerfs have been made so do /runes /recipes for more info! " +
                "\n\n**End will open in " + formatDuration(END_OPEN_TIME) + "**", "1032411739351941120");
        Bukkit.getServer().broadcastMessage(ChatColor.DARK_PURPLE + "Custom items and runes released! +(25k by 25k map and hard difficulty) Check /discord announcements");
    }

    @Override
    public void onEventEnd() {

    }

    @Override
    public void doWarning() {
        Bukkit.getServer().broadcastMessage(ChatColor.DARK_PURPLE + "Custom items releasing in " + formatDuration(startTime) + "! Check /discord announcements");
        //sendDiscordNewsEmbedTitle("Custom items and runes!", Color.GREEN, "1032411739351941120");
        sendDiscordNewsMessage(eventRole + " In " + formatDuration(startTime) + ", custom items /recipes and runes /runes are going to be available! Map size will be expanded to 25k by 25k and difficulty will be set to hard.", "1032411739351941120");
    }

    @Override
    public EventType getType() {
        return EventType.ONETIME;
    }

    @Override
    public void runContinuously() {

    }
}
