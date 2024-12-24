package newamazingpvp.lifestealsmp.events;

import java.time.Duration;
import java.time.ZoneId;
import java.time.ZonedDateTime;

import static newamazingpvp.lifestealsmp.LifestealSMP.isSmp;
import static newamazingpvp.lifestealsmp.utility.SeasonUtils.getSeasonStartTime;


public class TimeManager {
    //TODO: ALWAYS KEEP THIS A SATURDAY IF POSSIBLE (START SEASONS ON SATURDAY)
    public static final ZonedDateTime SEASON_START_TIME = getSeasonStartTime();

    public static final ZonedDateTime END_OPEN_TIME = SEASON_START_TIME.plusDays(14);
    public static final ZonedDateTime FINAL_FIGHT = SEASON_START_TIME.plusDays(28);

    //this is because season starts 12pm est auto restart at 3am Saturday morning
    public static final ZonedDateTime CUSTOM_ITEMS_AND_RUNES = SEASON_START_TIME.plusDays(7);

    public static String eventRole = "<@&1259526654204575896>";
    public static String mcServer = "<@&1047168915500966048>";


    public static void doEvents() {
        if (!isSmp) return;
        ZonedDateTime currentTime = ZonedDateTime.now(ZoneId.of("America/New_York"));

        if (isTimePassed(SEASON_START_TIME, currentTime, 3, 14, 0, 0) &&
                !isTimePassed(SEASON_START_TIME, currentTime, 3, 16, 0, 0)) {
            /*
            for (World w : Bukkit.getWorlds()) {
                w.setDifficulty(Difficulty.NORMAL);
            }
            getServer().getScheduler().runTaskLater(lifestealSmp, () -> sendDiscordNewsMessage("Difficulty on SMP now set to normal!", "1032411739351941120"), 1200);
            */

        }

        if (isTimePassed(SEASON_START_TIME, currentTime, 10, 0, 0, 0)) {

        }

        if (isTimePassed(SEASON_START_TIME, currentTime, 0, 5, 0, 0)) {

        }

        if (isTimePassed(SEASON_START_TIME, currentTime, 0, 0, 30, 0)) {

        }
    }

    public static void timeBasedEvents() {
        if (!isSmp) {
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

    public static String formatDuration(ZonedDateTime time) {
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
