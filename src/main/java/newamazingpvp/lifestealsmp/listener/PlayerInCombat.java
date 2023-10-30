package newamazingpvp.lifestealsmp.listener;

import org.bukkit.entity.Player;
import org.bukkit.event.Listener;

import java.util.HashMap;

public class PlayerInCombat implements Listener {
    private final long cooldownTime = 60 * 20 * 50;
    private final HashMap<Player, Long> cooldowns = new HashMap<>();

    /*private boolean canPlayMusic(Player player) {
        long currentTime = System.currentTimeMillis();
        if (cooldowns.containsKey(player)) {
            long lastMusicTime = cooldowns.get(player);
            return (currentTime - lastMusicTime) >= cooldownTime;
        }
        return true;
    }

    @EventHandler
    private void onCombatTagged(PlayerTagEvent e) {
        Player p = e.getPlayer();
        if (canPlayMusic(p)) {
            p.playSound(p.getLocation(), Sound.MUSIC_DISC_5, 1.0f, 1.0f);
            cooldowns.put(p, System.currentTimeMillis());
        }
    }*/
}
