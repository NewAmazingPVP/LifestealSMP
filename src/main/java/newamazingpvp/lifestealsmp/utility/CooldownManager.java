package newamazingpvp.lifestealsmp.utility;

/**
 * Manages cooldown periods for actions.
 */
public class CooldownManager {
    private long cooldownEndTime;

    /**
     * Creates a CooldownManager with a specified cooldown period in seconds.
     *
     * @param seconds the cooldown period in seconds
     */
    public CooldownManager(double seconds) {
        setCooldown(seconds);
    }

    /**
     * Creates a CooldownManager with no initial cooldown.
     */
    public CooldownManager() {
        this.cooldownEndTime = System.currentTimeMillis();
    }

    /**
     * Checks if the cooldown period is still active.
     *
     * @return true if still on cooldown, false otherwise
     */
    public boolean isOnCooldown() {
        return System.currentTimeMillis() < cooldownEndTime;
    }

    /**
     * Sets a new cooldown period in seconds from the current time.
     *
     * @param seconds the new cooldown period in seconds
     */
    public void setCooldown(double seconds) {
        this.cooldownEndTime = System.currentTimeMillis() + (long) (seconds * 1000);
    }

    public int getRemainingSeconds() {
        return (int) ((cooldownEndTime - System.currentTimeMillis()) / 1000) + 1;
    }
}
