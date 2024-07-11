package newamazingpvp.lifestealsmp.utility;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Difficulty;
import org.bukkit.World;

import java.awt.*;
import java.time.Duration;
import java.time.ZoneId;
import java.time.ZonedDateTime;

import static newamazingpvp.lifestealsmp.LifestealSMP.*;
import static newamazingpvp.lifestealsmp.discord.DiscordBot.sendDiscordNewsEmbedTitle;
import static newamazingpvp.lifestealsmp.discord.DiscordBot.sendDiscordNewsMessage;
import static org.bukkit.Bukkit.getServer;


public class TimeManager {
    //TODO: ALWAYS KEEP THIS A SATURDAY IF POSSIBLE (START SEASONS ON SATURDAY)
    public static final ZonedDateTime SEASON_START_TIME = ZonedDateTime.of(
            2024, 6, 22, 12, 0, 0, 0, ZoneId.of("America/New_York")
    );

    public static final ZonedDateTime END_OPEN_TIME = SEASON_START_TIME.plusDays(14).plusHours(2);
    public static final ZonedDateTime FINAL_FIGHT = SEASON_START_TIME.plusDays(21).plusHours(2);

    //this is because season starts 12pm est auto restart at 3am Saturday morning
    public static final ZonedDateTime CUSTOM_ITEMS_AND_RUNES = SEASON_START_TIME.plusDays(6).plusHours(14);

    public static final CooldownManager eventCooldown = new CooldownManager();
    public static String eventRole = "<@&1259526654204575896>";
    public static String mcServer = "<@&1047168915500966048>";


    //TODO: ADD EVENTS like
    // Exact tracking days, no tracking days
    // Rune and heart multiplier days
    // Pvp events uhc optional, custom boss raffle ticket (comet working)

    public static void doEvents() {
        if (!isSmp) return;
        ZonedDateTime currentTime = ZonedDateTime.now(ZoneId.of("America/New_York"));

        long weeksPassed = getWeeksPassed(SEASON_START_TIME, currentTime);
        if (isTimePassed(CUSTOM_ITEMS_AND_RUNES)) {
            registerCustomItemsAndRunes();
        }

        if (isTimePassed(SEASON_START_TIME, currentTime, 3, 14, 0, 0) &&
                !isTimePassed(SEASON_START_TIME, currentTime, 3, 16, 0, 0)) {
            for (World w : Bukkit.getWorlds()) {
                w.setDifficulty(Difficulty.NORMAL);
            }
            getServer().getScheduler().runTaskLater(lifestealSmp, () -> sendDiscordNewsMessage("Difficulty on SMP now set to normal!", "1032411739351941120"), 1200);
        }

        if (isTimePassed(SEASON_START_TIME, currentTime, 10, 0, 0, 0)) {

        }

        if (isTimePassed(SEASON_START_TIME, currentTime, 0, 5, 0, 0)) {

        }

        if (isTimePassed(SEASON_START_TIME, currentTime, 0, 0, 30, 0)) {

        }
    }

    public static void timeBasedEvents() {
        if (!isSmp) return;
        if (isTimePassed(FINAL_FIGHT.minusDays(3))
                && !isTimePassed(FINAL_FIGHT.minusDays(2).minusHours(23).minusMinutes(59))) {
            if (eventCooldown.isOnCooldown()) return;
            sendDiscordNewsMessage(eventRole + " The final fight event to conclude the season will be on Saturday, in " + formatDuration(Duration.between(FINAL_FIGHT, ZonedDateTime.now(ZoneId.of("America/New_York")))) + " exactly!", "1032411739351941120");
            eventCooldown.setCooldown(70);
        }

        if (isTimePassed(FINAL_FIGHT.minusDays(1))
                && !isTimePassed(FINAL_FIGHT.minusHours(23).minusMinutes(59))) {
            if (eventCooldown.isOnCooldown()) return;
            sendDiscordNewsMessage(mcServer + " Final fight in exactly 24 hours! Be prepared, the last one standing will be the winner of this season!", "1032411739351941120");
            eventCooldown.setCooldown(70);
        }

        if (isTimePassed(FINAL_FIGHT.minusHours(4))
                && !isTimePassed(FINAL_FIGHT.minusHours(3).minusMinutes(59))) {
            if (eventCooldown.isOnCooldown()) return;
            sendDiscordNewsMessage(eventRole + " Final fight in " + formatDuration(Duration.between(FINAL_FIGHT, ZonedDateTime.now(ZoneId.of("America/New_York"))))  + " exactly!", "1032411739351941120");
            eventCooldown.setCooldown(70);
        }

        if (isTimePassed(FINAL_FIGHT.minusHours(1))
                && !isTimePassed(FINAL_FIGHT.minusMinutes(59))) {
            if (eventCooldown.isOnCooldown()) return;
            sendDiscordNewsMessage(mcServer + " Final fight in " + formatDuration(Duration.between(FINAL_FIGHT, ZonedDateTime.now(ZoneId.of("America/New_York"))))  + " exactly!", "1032411739351941120");
            eventCooldown.setCooldown(70);
        }

        if (isTimePassed(FINAL_FIGHT.minusMinutes(10))
                && !isTimePassed(FINAL_FIGHT.minusMinutes(9))) {
            if (eventCooldown.isOnCooldown()) return;
            sendDiscordNewsMessage(mcServer + " Final fight is in 10 minutes! Be ready, you will be teleported in-game", "1032411739351941120");
            eventCooldown.setCooldown(70);
        }

        if (isTimePassed(FINAL_FIGHT)
                && !isTimePassed(END_OPEN_TIME.plusMinutes(1))) {
            if (eventCooldown.isOnCooldown()) return;
            Bukkit.getServer().broadcastMessage(ChatColor.DARK_PURPLE + "Final fight is starting!");
            sendDiscordNewsEmbedTitle("Final fight is on!", Color.GREEN, "1032411739351941120");
            sendDiscordNewsMessage(mcServer + " Final fight has begun! May the best win goodluck!", "1032411739351941120");
            getServer().dispatchCommand(getServer().getConsoleSender(), "startendfight");
            eventCooldown.setCooldown(70);
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

    public static boolean isTimePassed(ZonedDateTime startTime, ZonedDateTime currentTime, int days, int hours, int minutes, int seconds) {
        Duration duration = Duration.between(startTime, currentTime);
        Duration targetDuration = Duration.ofDays(days).plusHours(hours).plusMinutes(minutes).plusSeconds(seconds);
        return duration.compareTo(targetDuration) >= 0;
    }

    public static boolean isTimePassed(ZonedDateTime time) {
        return ZonedDateTime.now(ZoneId.of("America/New_York")).compareTo(time) >= 0;
    }

    public static String formatDuration(ZonedDateTime time){
        return formatDuration(Duration.between(time, ZonedDateTime.now(ZoneId.of("America/New_York"))));
    }


    public static String formatDuration(Duration duration) {
        long days = duration.toDays();
        long hours = duration.toHours() % 24;
        long minutes = duration.toMinutes() % 60;
        long seconds = duration.getSeconds() % 60;

        StringBuilder formattedDuration = new StringBuilder();

        if (days != 0) {
            formattedDuration.append(days).append(" day").append(days > 1 ? "s" : "");
        }

        if (hours != 0) {
            if (formattedDuration.length() > 0) {
                formattedDuration.append(", ");
            }
            formattedDuration.append(hours).append(" hour").append(hours > 1 ? "s" : "");
        }

        if (minutes != 0) {
            if (formattedDuration.length() > 0) {
                formattedDuration.append(", ");
            }
            formattedDuration.append(minutes).append(" minute").append(minutes > 1 ? "s" : "");
        }

        if (seconds != 0) {
            if (formattedDuration.length() > 0) {
                formattedDuration.append(", ");
            }
            formattedDuration.append(seconds).append(" second").append(seconds > 1 ? "s" : "");
        }

        return formattedDuration.toString().replace("-", "");
    }

}
