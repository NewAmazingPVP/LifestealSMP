package newamazingpvp.lifestealsmp.utility;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Difficulty;
import org.bukkit.World;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;

import java.awt.*;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;

import static newamazingpvp.lifestealsmp.customitems.utils.Recipes.registerCustomRecipes;
import static newamazingpvp.lifestealsmp.discord.DiscordBot.*;
import static org.bukkit.Bukkit.getServer;


public class TimeManager {
    //TODO: ALWAYS KEEP THIS A SATURDAY IF POSSIBLE (START SEASONS ON SATURDAY)
    public static final ZonedDateTime SEASON_START_TIME = ZonedDateTime.of(
            2024, 6, 22, 12, 0, 0, 0, ZoneId.of("America/New_York")
    );

    //TODO: FINISH AND CALL THIS TO INIT
    public static void doEvents() {
        ZonedDateTime currentTime = ZonedDateTime.now(ZoneId.of("America/New_York"));

        long weeksPassed = getWeeksPassed(SEASON_START_TIME, currentTime);
        if (isTimePassed(SEASON_START_TIME, currentTime, 6, 14, 0, 0)) {
            registerCustomRecipes();
        }



        if (isTimePassed(SEASON_START_TIME, currentTime, 6, 14, 0, 0) &&
                ! isTimePassed(SEASON_START_TIME, currentTime, 6, 16, 0, 0)) {
            registerCustomRecipes();
            Bukkit.getWorld("world").getWorldBorder().setSize(25000);
            for(World w : Bukkit.getWorlds()){
                w.setDifficulty(Difficulty.HARD);
            }
            sendDiscordMessage("Custom items have now been enabled! Map size expanded to 25k by 25k and difficulty set to hard.", "1032411739351941120");
        }

        if (isTimePassed(SEASON_START_TIME, currentTime, 3, 14, 0, 0) &&
                ! isTimePassed(SEASON_START_TIME, currentTime, 3, 16, 0, 0)) {
            for(World w : Bukkit.getWorlds()){
                w.setDifficulty(Difficulty.NORMAL);
            }
            sendDiscordMessage("Difficulty on SMP now set to normal!", "1032411739351941120");
        }

        if (isTimePassed(SEASON_START_TIME, currentTime, 10, 0, 0, 0)) {

        }

        if (isTimePassed(SEASON_START_TIME, currentTime, 0, 5, 0, 0)) {

        }

        if (isTimePassed(SEASON_START_TIME, currentTime, 0, 0, 30, 0)) {

        }
    }

    public static void timeBasedEvents(){
        ZonedDateTime currentTime = ZonedDateTime.now(ZoneId.of("America/New_York"));
        long weeksPassed = getWeeksPassed(SEASON_START_TIME, currentTime);

        if(isTimePassed(SEASON_START_TIME, currentTime, 0, 0, 0, 1) &&
        ! isTimePassed(SEASON_START_TIME, currentTime, 0, 0, 0, 2)){
            getServer().dispatchCommand(getServer().getConsoleSender(), "whitelist off");
            getServer().dispatchCommand(getServer().getConsoleSender(), "gamerule playersSleepingPercentage 1");
            sendDiscordEmbedTitle("New season has started!!", Color.GREEN, "1032411739351941120");
            sendDiscordMessage("<@&1047168915500966048> New season has opened!", "1032411739351941120");
        }

        if (isWeekPassed(2, weeksPassed) && !isTimePassed(SEASON_START_TIME, currentTime, 14, 0, 0, 1)) {
            Bukkit.getServer().broadcastMessage(ChatColor.DARK_PURPLE + "End has now opened!");
            sendDiscordEmbedTitle("End has opened!", Color.GREEN, "1032411739351941120");

            sendDiscordMessage("<@&1047168915500966048> The end has opened!", "1032411739351941120");
        }
    }

    public static long getWeeksPassed(ZonedDateTime startTime, ZonedDateTime currentTime) {
        Duration duration = Duration.between(startTime, currentTime);
        return duration.toDays() / 7;
    }

    public static long getDaysPassed(ZonedDateTime startTime, ZonedDateTime currentTime) {
        Duration duration = Duration.between(startTime, currentTime);
        return duration.toHours() / 24;
    }

    public static boolean isWeekPassed(int weekNum, long weeksPassed) {
        return weeksPassed >= weekNum;
    }

    private static boolean isTimePassed(ZonedDateTime startTime, ZonedDateTime currentTime, int days, int hours, int minutes, int seconds) {
        Duration duration = Duration.between(startTime, currentTime);
        Duration targetDuration = Duration.ofDays(days).plusHours(hours).plusMinutes(minutes).plusSeconds(seconds);
        return duration.compareTo(targetDuration) >= 0;
    }

    public static String formatDuration(Duration duration) {
        long days = duration.toDays();
        long hours = duration.toHours() % 24;
        long minutes = duration.toMinutes() % 60;
        long seconds = duration.getSeconds() % 60;

        return String.format("%d days, %d hours, %d minutes, %d seconds", days, hours, minutes, seconds);
    }
}
