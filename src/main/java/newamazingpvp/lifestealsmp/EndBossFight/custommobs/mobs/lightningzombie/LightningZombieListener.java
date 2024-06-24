package newamazingpvp.lifestealsmp.EndBossFight.custommobs.mobs.lightningzombie;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Sound;
import org.bukkit.entity.Entity;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;

public class LightningZombieListener implements Listener {

    @EventHandler
    public void whenPlayerHit(EntityDamageByEntityEvent e) {

        Entity attacker = e.getDamager();
        Entity damagedEntity = e.getEntity();
        Location loc = e.getEntity().getLocation();

        if (attacker instanceof LivingEntity) {

            if (attacker.hasMetadata("electric_zombie")) {

                damagedEntity.getWorld().strikeLightningEffect(loc);
                ((LivingEntity) damagedEntity).damage(5);
                for (Player onlinePlayer : Bukkit.getOnlinePlayers()) {
                    onlinePlayer.playSound(loc, Sound.ENTITY_GENERIC_EXPLODE, 1.0f, 1.0f);
                    onlinePlayer.playSound(loc, Sound.ENTITY_FIREWORK_ROCKET_TWINKLE, 1.0f, 2.0f);

                }
            }
        }
    }
}

