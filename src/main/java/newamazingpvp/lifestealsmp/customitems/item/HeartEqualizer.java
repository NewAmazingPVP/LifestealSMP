package newamazingpvp.lifestealsmp.customitems.item;

import org.bukkit.Bukkit;
import org.bukkit.entity.*;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;

import static newamazingpvp.lifestealsmp.customitems.utils.ItemStacks.createHeartEqualizer;

public class HeartEqualizer implements Listener {
    @EventHandler
    public void onDamage(EntityDamageByEntityEvent event) {
        if (event.getEntity() instanceof Player) {
            Player damager = null;
            boolean isEnemyPlayer = event.getDamager() instanceof Player;
            if (!isEnemyPlayer) {
                if (event.getDamager() instanceof Arrow) {
                    Arrow arrow = (Arrow) event.getDamager();
                    if (arrow.getShooter() instanceof Player) {
                        isEnemyPlayer = true;
                        damager = (Player) arrow.getShooter();
                    }
                } else if (event.getDamager() instanceof TNTPrimed) {
                    TNTPrimed tnt = (TNTPrimed) event.getDamager();
                    if (tnt.getSource() instanceof Player) {
                        isEnemyPlayer = true;
                        damager = (Player) tnt.getSource();
                    }
                } else if (event.getDamager() instanceof ThrownPotion) {
                    ThrownPotion potion = (ThrownPotion) event.getDamager();
                    if (potion.getShooter() instanceof Player) {
                        isEnemyPlayer = true;
                        damager = (Player) potion.getShooter();
                    }
                } else if (event.getDamager() instanceof Trident) {
                    Trident trident = (Trident) event.getDamager();
                    if (trident.getShooter() instanceof Player) {
                        isEnemyPlayer = true;
                        damager = (Player) trident.getShooter();
                    }
                }
            } else {
                damager = (Player) event.getDamager();
            }
            Player damagedPlayer = (Player) event.getEntity();
            if (isEnemyPlayer && damagedPlayer.getInventory().contains(createHeartEqualizer())) {
                double dmg = event.getFinalDamage();
                double finalDmg = dmg * Math.min(1, (damagedPlayer.getMaxHealth() / damager.getMaxHealth()));

                event.setDamage(finalDmg);
            }
        }
    }
}
