package newamazingpvp.lifestealsmp.listener;

import org.bukkit.Difficulty;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;

import static newamazingpvp.lifestealsmp.game.Compass.getPlaytime;

public class NewbieProgression implements Listener {
    @EventHandler
    public void onPlayerDamageByMob(EntityDamageByEntityEvent event) {
        if (event.getEntity().getWorld().getDifficulty() != Difficulty.EASY) {
            if (event.getEntity() instanceof Player && !(event.getDamager() instanceof Player)) {
                Player p = (Player) event.getEntity();
                if (getPlaytime(p) < 3 * 60 * 60 * 20) {
                    double dmg = event.getFinalDamage();
                    double finalDmg = Math.max(dmg / 4, dmg * (getPlaytime(p) / (3 * 60 * 60 * 20.0)));
                    event.setDamage(finalDmg);
                }
            }
        }
    }
}
