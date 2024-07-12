package newamazingpvp.lifestealsmp.CorruptedMobsEvent.EventMobs.Mage.MageEvents;

import org.bukkit.*;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.EntityDeathEvent;

import static newamazingpvp.lifestealsmp.RaffleEvent.RaffleItemStacks.raffleTicket;
import static newamazingpvp.lifestealsmp.RaffleEvent.RaffleMain.currentRaffleEventID;

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

        if (damagedEntity.getLastDamageCause() instanceof EntityDamageByEntityEvent) {
            EntityDamageByEntityEvent damageEvent = (EntityDamageByEntityEvent) damagedEntity.getLastDamageCause();


            if (damageEvent.getDamager() instanceof Player) {
                Player killer = (Player) damageEvent.getDamager();

                if (damagedEntity.hasMetadata("mage_mob")) {
                    killer.playSound(killer.getLocation(), Sound.ENTITY_ELDER_GUARDIAN_CURSE, 2.0f, 2.0f);



                }
            }
        }
    }





}



