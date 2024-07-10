package newamazingpvp.lifestealsmp.events;

import java.time.ZonedDateTime;

import static newamazingpvp.lifestealsmp.runes.RuneHandler.runeMultiplier;

public class RuneMultiplier extends BaseEvent {
    private double multiplier;

    public RuneMultiplier(ZonedDateTime startTime, double multiply) {
        super(startTime, startTime.plusDays(1));
        multiplier = multiply;
    }

    @Override
    public void onEventStart() {

    }

    @Override
    public void onEventEnd() {

    }

    @Override
    public void doWarning() {

    }

    @Override
    public EventType getType() {
        return EventType.DAY;
    }

    @Override
    public void runContinuously() {
        runeMultiplier = multiplier;
    }
}
