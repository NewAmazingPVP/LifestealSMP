package newamazingpvp.lifestealsmp.events;

import org.bukkit.event.Listener;
import org.bukkit.scheduler.BukkitRunnable;
import newamazingpvp.lifestealsmp.utility.CooldownManager;

import java.util.ArrayList;
import java.util.List;

import static newamazingpvp.lifestealsmp.LifestealSMP.lifestealSmp;
import static newamazingpvp.lifestealsmp.utility.TimeManager.*;

public class EventsHandler implements Listener {
    public static final List<Event> events = new ArrayList<>();

    public EventsHandler() {
        // events.add(new CustomItemsAndRunes());
        // events.add(new TrackingDay(SEASON_START_TIME.plusDays(2), 1));
        // events.add(new UHCPvPEvent(SEASON_START_TIME.plusDays(19).plusHours(5).plusMinutes(1)));
        events.add(new FinalFight(SEASON_START_TIME.plusDays(21).plusHours(2)));
        new BukkitRunnable() {
            @Override
            public void run() {
                for (Event e : events) {
                    CooldownManager eventCooldown = e.getCooldownManager();

                    if (eventCooldown.isOnCooldown()) {
                        continue;
                    }

                    if (isEventInProgress(e)) {
                        e.runContinuously();
                        eventCooldown.setCooldown(70);
                    } else if (isTimePassed(e.getStartTime().minusDays(3)) &&
                            !isTimePassed(e.getStartTime().minusDays(2).minusHours(23).minusMinutes(59))) {
                        e.doWarning();
                        eventCooldown.setCooldown(70);
                    } else if (isTimePassed(e.getStartTime().minusDays(1)) &&
                            !isTimePassed(e.getStartTime().minusHours(23).minusMinutes(59))) {
                        e.doWarning();
                        eventCooldown.setCooldown(70);
                    } else if (isTimePassed(e.getStartTime().minusHours(4)) &&
                            !isTimePassed(e.getStartTime().minusHours(3).minusMinutes(59))) {
                        e.doWarning();
                        eventCooldown.setCooldown(70);
                    } else if (isTimePassed(e.getStartTime().minusHours(1)) &&
                            !isTimePassed(e.getStartTime().minusHours(0).minusMinutes(59))) {
                        e.doWarning();
                        eventCooldown.setCooldown(70);
                    } else if (isTimePassed(e.getStartTime().minusMinutes(10)) &&
                            !isTimePassed(e.getStartTime().minusMinutes(9))) {
                        e.doWarning();
                        eventCooldown.setCooldown(70);
                    } else if (isTimePassed(e.getStartTime()) &&
                            !isTimePassed(e.getStartTime().plusMinutes(2))) {
                        e.onEventStart();
                        eventCooldown.setCooldown(120);
                    } else if (isTimePassed(e.getEndTime()) &&
                            !isTimePassed(e.getEndTime().plusMinutes(2))) {
                        if (!(e.getType() == EventType.ONETIME)) {
                            e.onEventEnd();
                            eventCooldown.setCooldown(120);
                        }
                    }
                }
            }
        }.runTaskTimer(lifestealSmp, 20L, 20L);
    }

    public boolean isEventInProgress(Event e) {
        return isTimePassed(e.getStartTime()) && !isTimePassed(e.getEndTime());
    }
}
