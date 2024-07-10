package newamazingpvp.lifestealsmp.events;

import newamazingpvp.lifestealsmp.events.Event;

import java.time.Duration;
import java.time.ZonedDateTime;

public abstract class BaseEvent implements Event {
    public final ZonedDateTime startTime;
    public final ZonedDateTime endTime;

    public BaseEvent(ZonedDateTime startTime, ZonedDateTime endTime) {
        this.startTime = startTime;
        this.endTime = endTime;
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
}
