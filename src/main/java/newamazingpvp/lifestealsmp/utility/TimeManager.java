package newamazingpvp.lifestealsmp.utility;

import org.bukkit.Bukkit;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;

import static newamazingpvp.lifestealsmp.customitems.utils.Recipes.registerCustomRecipes;
import static newamazingpvp.lifestealsmp.discord.DiscordBot.sendDiscordMessage;
import static org.bukkit.Bukkit.getServer;


public class TimeManager {
    //TODO: ALWAYS KEEP THIS A SATURDAY EVEN IF YOU STARTED ON SUNDAY
    public static final ZonedDateTime SEASON_START_TIME = ZonedDateTime.of(
            2024, 6, 23, 12, 0, 0, 0, ZoneId.of("America/New_York")
    );

    public static void doEvents() {
        ZonedDateTime currentTime = ZonedDateTime.now(ZoneId.of("America/New_York"));

        long weeksPassed = getWeeksPassed(SEASON_START_TIME, currentTime);
        if (isTimePassed(SEASON_START_TIME, currentTime, 6, 14, 0, 0)) {
            registerCustomRecipes();
        }



        if (isTimePassed(SEASON_START_TIME, currentTime, 6, 14, 0, 0) &&
                ! isTimePassed(SEASON_START_TIME, currentTime, 6, 16, 0, 0)) {
            registerCustomRecipes();
            getServer().dispatchCommand(getServer().getConsoleSender(), "worldborder set 25000");
            sendDiscordMessage("Custom items have now been enabled! Map size expanded to 25k by 25k", "1032411739351941120");
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

        if (isWeekPassed(2, weeksPassed)) {

            Bukkit.getServer().spigot().restart();
        }
    }

    public static long getWeeksPassed(ZonedDateTime startTime, ZonedDateTime currentTime) {
        Duration duration = Duration.between(startTime, currentTime);
        return duration.toDays() / 7;
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
