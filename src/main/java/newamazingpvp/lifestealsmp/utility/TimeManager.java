package newamazingpvp.lifestealsmp.utility;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;

public class TimeManager {
    private static final ZonedDateTime SEASON_START_TIME = ZonedDateTime.of(
            2024, 6, 23, 12, 0, 0, 0, ZoneId.of("America/New_York")
    );

    public static void doEvents() {
        ZonedDateTime currentTime = ZonedDateTime.now(ZoneId.of("America/New_York"));
        long weeksPassed = getWeeksPassed(SEASON_START_TIME, currentTime);

        if (isWeekPassed(1, weeksPassed)) {

        }

        if (isWeekPassed(2, weeksPassed)) {

        }

    }

    private static long getWeeksPassed(ZonedDateTime startTime, ZonedDateTime currentTime) {
        Duration duration = Duration.between(startTime, currentTime);
        return duration.toDays() / 7;
    }

    private static boolean isWeekPassed(int weekNum, long weeksPassed) {
        return weeksPassed >= weekNum;
    }

    public static void main(String[] args) {
        // Example to show how doEvents works
        doEvents();
    }
}
