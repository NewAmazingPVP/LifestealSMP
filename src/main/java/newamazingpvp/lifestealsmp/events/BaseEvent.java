package newamazingpvp.lifestealsmp.events;

import newamazingpvp.lifestealsmp.utility.CooldownManager;

import java.time.ZonedDateTime;

public abstract class BaseEvent implements Event {
    public final ZonedDateTime startTime;
    public final ZonedDateTime endTime;
    private final CooldownManager cooldownManager;

    public BaseEvent(ZonedDateTime startTime, ZonedDateTime endTime) {
        this.startTime = startTime;
        this.endTime = endTime;
        this.cooldownManager = new CooldownManager();
    }

    @Override
    public ZonedDateTime getStartTime() {
        return startTime;
    }

    @Override
    public ZonedDateTime getEndTime() {
        return endTime;
    }

    @Override
    public abstract void onEventStart();

    @Override
    public abstract void onEventEnd();

    @Override
    public abstract void doWarning();

    @Override
    public abstract EventType getType();

    @Override
    public abstract void runContinuously();

    @Override
    public CooldownManager getCooldownManager() {
        return cooldownManager;
    }
}
