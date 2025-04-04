package newamazingpvp.lifestealsmp.events;

import org.bukkit.Bukkit;
import org.bukkit.Difficulty;
import org.bukkit.Location;
import org.bukkit.World;

import java.awt.*;
import java.time.ZonedDateTime;

import static newamazingpvp.lifestealsmp.discord.DiscordBot.sendDiscordNewsEmbedTitle;
import static newamazingpvp.lifestealsmp.discord.DiscordBot.sendDiscordNewsMessage;
import static newamazingpvp.lifestealsmp.events.TimeManager.formatDuration;
import static newamazingpvp.lifestealsmp.events.TimeManager.mcServer;
import static org.bukkit.Bukkit.getServer;

public class ServerOpening extends BaseEvent {
    public ServerOpening(ZonedDateTime startTime) {
        super(startTime, startTime.plusMinutes(10));
    }

    @Override
    public void onEventStart() {
        getServer().dispatchCommand(getServer().getConsoleSender(), "whitelist off");
        getServer().dispatchCommand(getServer().getConsoleSender(), "gamerule playersSleepingPercentage 1");
        getServer().dispatchCommand(getServer().getConsoleSender(), "gamerule doImmediateRespawn true");
        getServer().dispatchCommand(getServer().getConsoleSender(), "unbanall");
        Bukkit.getWorld("world").setTime(1000);
        for (World w : Bukkit.getWorlds()) {
            w.setDifficulty(Difficulty.EASY);
            w.getWorldBorder().setCenter(new Location(w, 0, 0, 0));
            // was 10000
            w.getWorldBorder().setSize(4000);
            //w.getWorldBorder().setDamageBuffer(0);
            //w.getWorldBorder().setDamageAmount(4);
            //w.getWorldBorder().setWarningDistance(50);
        }
        sendDiscordNewsEmbedTitle("New season has started!!", Color.GREEN, "1032411739351941120");
        sendDiscordNewsMessage(mcServer + " The server has opened!\n" +
                "\n" +
                "**Rules and Info**\n" +
                "- The end will open in 2 weeks\n" +
                "- 4k by 4k starting map size (will be expanded to 25k by 25k next weekend)\n" +
                "- Custom items /recipes and runes /runes will be enabled next weekend\n" +
                "- Current difficulty easy, will be set to normal on Wednesday and hard next weekend\n" +
                "- Combat logging (90 seconds)\n" +
                "- [/prefix for custom prefix with rgb colors](https://www.birdflop.com/resources/rgb/) \n" +
                "- Do /help /rules in game for more\n" +
                "\n" +
                "Java IP is **NapPixel.tk** and port is **25565** if needed.\n" +
                "For bedrock its **NapPixel.tk** and port is **19132** if needed.\n" +
                "**1.21** is the recommended version, but it is compatible with **1.7-1.21**\n" +
                "\n" +
                "**NOTE**\n" +
                "Each person will have their own individual newbie and tracking protection for a hour of playtime. \n" +
                "\n" +
                "Anyways goodluck! And fyi if you don't want to be tracked you and use an invis potion!", "1032411739351941120");
    }

    @Override
    public void onEventEnd() {

    }

    @Override
    public void doWarning() {
        sendDiscordNewsMessage(mcServer + " The new **Lifesteal** season will be released in " + formatDuration(startTime) + " exactly!!!", "1032411739351941120");
        //sendDiscordNewsMessage("## End fight fixed, runes nerfed, tournament event fully added!", "1032411739351941120");
        Bukkit.getWorld("world").setSpawnLocation(0, 320, 0);
    }

    @Override
    public EventType getType() {
        return EventType.ONETIME;
    }

    @Override
    public void runContinuously() {

    }
}
