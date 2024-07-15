package newamazingpvp.lifestealsmp.events;

import newamazingpvp.lifestealsmp.utility.CooldownManager;

import java.time.ZonedDateTime;

public interface Event {
    ZonedDateTime getStartTime();

    ZonedDateTime getEndTime();

    EventType getType();

    void onEventStart();

    void onEventEnd();

    void doWarning();

    void runContinuously();

    CooldownManager getCooldownManager();
}
