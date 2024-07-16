package newamazingpvp.lifestealsmp.events;

import newamazingpvp.lifestealsmp.utility.CooldownManager;
import org.bukkit.event.Listener;
import org.bukkit.scheduler.BukkitRunnable;

import java.util.ArrayList;
import java.util.List;

import static newamazingpvp.lifestealsmp.LifestealSMP.isSmp;
import static newamazingpvp.lifestealsmp.LifestealSMP.lifestealSmp;
import static newamazingpvp.lifestealsmp.events.TimeManager.*;

public class EventsHandler implements Listener {
    public static final List<Event> events = new ArrayList<>();

    public EventsHandler() {
        // events.add(new TrackingDay(SEASON_START_TIME.plusDays(2), 1));
        // events.add(new UHCPvPEvent(SEASON_START_TIME.plusDays(19).plusHours(5).plusMinutes(1)));
        // TODO: ADD ALL EVENTS decide all days timeline
        events.add(new ServerOpening(SEASON_START_TIME));
        events.add(new NormalDifficulty(SEASON_START_TIME.plusDays(4)));
        events.add(new HeartMultiplier(SEASON_START_TIME.plusDays(5), 1.5));
        events.add(new CustomItemsAndRunes(CUSTOM_ITEMS_AND_RUNES));
        events.add(new UHCPvPEvent(CUSTOM_ITEMS_AND_RUNES.plusDays(1)));
        events.add(new TrackingDay(CUSTOM_ITEMS_AND_RUNES.plusDays(3), 1));
        events.add(new RuneMultiplier(CUSTOM_ITEMS_AND_RUNES.plusDays(5), 1));
        events.add(new EndOpeningEvent(END_OPEN_TIME));
        events.add(new NoTrackingDay(END_OPEN_TIME.plusDays(1)));
        //events.add(new HeartAndRuneMultiplier(END_OPEN_TIME.plusDays(4)));
        //add comet's events once done (like +2 events)
        events.add(new UHCPvPEvent(END_OPEN_TIME.plusWeeks(1)));
        events.add(new TrackingDay(END_OPEN_TIME.plusWeeks(1).plusDays(3), 1));
        events.add(new FinalFight(FINAL_FIGHT));
        new BukkitRunnable() {
            @Override
            public void run() {
                if (!isSmp) return;
                for (Event e : events) {
                    CooldownManager eventCooldown = e.getCooldownManager();

                    if (eventCooldown.isOnCooldown()) {
                        continue;
                    }

                    if (isTimePassed(e.getStartTime().minusDays(3)) &&
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
                            !isTimePassed(e.getStartTime().plusMinutes(3))) {
                        e.onEventStart();
                        eventCooldown.setCooldown(180);
                    } else if (isEventInProgress(e)) {
                        e.runContinuously();
                        eventCooldown.setCooldown(70);
                    } else if (isTimePassed(e.getEndTime()) &&
                            !isTimePassed(e.getEndTime().plusMinutes(3))) {
                        if (!(e.getType() == EventType.ONETIME)) {
                            e.onEventEnd();
                            eventCooldown.setCooldown(180);
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
