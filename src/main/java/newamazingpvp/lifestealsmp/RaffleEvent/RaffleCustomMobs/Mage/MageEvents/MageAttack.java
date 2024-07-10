package newamazingpvp.lifestealsmp.RaffleEvent.RaffleCustomMobs.Mage.MageEvents;

import org.bukkit.Location;
import org.bukkit.entity.Entity;
import org.bukkit.entity.LivingEntity;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.scheduler.BukkitRunnable;

public class MageAttack implements Listener {


    @EventHandler
    public void whenPlayerHit(EntityDamageByEntityEvent e) {

        Entity attacker = e.getDamager();
        Entity damagedEntity = e.getEntity();
        Location loc = e.getEntity().getLocation();

        if (attacker instanceof LivingEntity) {

            if (attacker.hasMetadata("mage_mob")) {



            }
        }
    }



}



