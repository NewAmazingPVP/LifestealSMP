package newamazingpvp.lifestealsmp.listener;

import org.bukkit.Difficulty;
import org.bukkit.entity.Arrow;
import org.bukkit.entity.Player;
import org.bukkit.entity.TNTPrimed;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;

import static newamazingpvp.lifestealsmp.game.Compass.getPlaytime;

public class NewbieProgression implements Listener {
    @EventHandler
    public void onPlayerDamageByMob(EntityDamageByEntityEvent event) {
        if (event.getEntity().getWorld().getDifficulty() != Difficulty.EASY) {
            if (event.getEntity() instanceof Player && !(event.getDamager() instanceof Player)) {
                Player damagedPlayer = (Player) event.getEntity();
                if (getPlaytime(damagedPlayer) < 3 * 60 * 60 * 20) {
                    double dmg = event.getFinalDamage();
                    double finalDmg = Math.max(dmg / 4, dmg * (getPlaytime(damagedPlayer) / (3 * 60 * 60 * 20.0)));

                    if (event.getDamager() instanceof Arrow) {
                        Arrow arrow = (Arrow) event.getDamager();
                        if (arrow.getShooter() instanceof Player) {
                            return;
                        }
                    }
                    if (event.getDamager() instanceof TNTPrimed) {
                        TNTPrimed tnt = (TNTPrimed) event.getDamager();
                        if (tnt.getSource() instanceof Player) {
                            return;
                        }
                    }

                    event.setDamage(finalDmg);
                }
            }
        }
    }

    @EventHandler
    public void onBedrockPlayerDamageByMob(EntityDamageByEntityEvent event) {
        if (event.getEntity() instanceof Player && !(event.getDamager() instanceof Player)) {
            Player damagedPlayer = (Player) event.getEntity();
            if (damagedPlayer.getName().startsWith(".")) {
                double dmg = event.getFinalDamage();
                double finalDmg = dmg * 0.7;

                if (event.getDamager() instanceof Arrow) {
                    Arrow arrow = (Arrow) event.getDamager();
                    if (arrow.getShooter() instanceof Player) {
                        return;
                    }
                }
                if (event.getDamager() instanceof TNTPrimed) {
                    TNTPrimed tnt = (TNTPrimed) event.getDamager();
                    if (tnt.getSource() instanceof Player) {
                        return;
                    }
                }

                event.setDamage(finalDmg);
            }
        }
    }
}
