package newamazingpvp.lifestealsmp.unused.events.corruptedmobs.mobs.mage.events;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Particle;
import org.bukkit.Sound;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.EntityDeathEvent;

public class MageHitAndKilled implements Listener {


    @EventHandler
    public void whenPlayerHit(EntityDamageByEntityEvent e) {

        Entity damagedEntity = e.getEntity();
        Location loc = damagedEntity.getLocation();


        if (damagedEntity.hasMetadata("mage_mob")) {

            for (Player onlinePlayer : Bukkit.getOnlinePlayers()) {
                onlinePlayer.playSound(loc, Sound.ENTITY_ENDER_DRAGON_HURT, 1.0f, 1.0f);
                damagedEntity.getLocation().getWorld().spawnParticle(Particle.CLOUD, damagedEntity.getLocation(), 10);

            }
        }
    }

    @EventHandler
    public void whenPlayerHit(EntityDeathEvent e) {

        Entity damagedEntity = e.getEntity();

        if (damagedEntity.getLastDamageCause() instanceof EntityDamageByEntityEvent damageEvent) {


            if (damageEvent.getDamager() instanceof Player killer) {

                if (damagedEntity.hasMetadata("mage_mob")) {
                    killer.playSound(killer.getLocation(), Sound.ENTITY_ELDER_GUARDIAN_CURSE, 2.0f, 2.0f);


                }
            }
        }
    }


}



