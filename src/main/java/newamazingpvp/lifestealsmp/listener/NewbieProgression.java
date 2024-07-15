package newamazingpvp.lifestealsmp.listener;

import org.bukkit.Difficulty;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;

import static newamazingpvp.lifestealsmp.game.Compass.getPlaytime;
import static newamazingpvp.lifestealsmp.utility.Utils.returnPlayerDamager;

public class NewbieProgression implements Listener {
    @EventHandler
    public void onPlayerDamageByMob(EntityDamageByEntityEvent event) {
        if (event.getEntity().getWorld().getDifficulty() != Difficulty.EASY) {
            if (event.getEntity() instanceof Player damagedPlayer && !(event.getDamager() instanceof Player)) {
                if (getPlaytime(damagedPlayer) < 3 * 60 * 60 * 20) {
                    double dmg = event.getFinalDamage();
                    double finalDmg = Math.max(dmg / 4, dmg * (getPlaytime(damagedPlayer) / (3 * 60 * 60 * 20.0)));

                    if (returnPlayerDamager(event.getDamager()) != null) return;

                    event.setDamage(finalDmg);
                }
            }
        }
    }

    @EventHandler
    public void onBedrockPlayerDamageByMob(EntityDamageByEntityEvent event) {
        if (event.getEntity() instanceof Player damagedPlayer && !(event.getDamager() instanceof Player)) {
            if (damagedPlayer.getName().startsWith(".")) {
                double dmg = event.getFinalDamage();
                double finalDmg = dmg * 0.7;

                if (returnPlayerDamager(event.getDamager()) != null) return;

                event.setDamage(finalDmg);
            }
        }
    }
}
