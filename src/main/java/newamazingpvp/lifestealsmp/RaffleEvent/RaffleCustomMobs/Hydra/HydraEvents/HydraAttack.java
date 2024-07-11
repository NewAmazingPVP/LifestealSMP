package newamazingpvp.lifestealsmp.RaffleEvent.RaffleCustomMobs.Hydra.HydraEvents;

import org.bukkit.Location;
import org.bukkit.entity.Entity;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.metadata.FixedMetadataValue;
import org.bukkit.metadata.MetadataValue;
import org.bukkit.plugin.Plugin;
import org.bukkit.util.Vector;

import static newamazingpvp.lifestealsmp.LifestealSMP.lifestealSmp;
import static newamazingpvp.lifestealsmp.RaffleEvent.RaffleCustomMobs.Hydra.SpawnHydra.SpawnHydra.*;

public class HydraAttack implements Listener {

    public void whenPlayerHit(EntityDamageByEntityEvent e) {

        Entity attacker = e.getDamager();
        Player damagedEntity = (Player) e.getEntity();
        //Location loc = e.getEntity().getLocation();




        if (attacker instanceof LivingEntity) {

            if (attacker.hasMetadata("enigma_mob_charged")) {

                attacker.removeMetadata(customTag, (Plugin) customTagValue);
                ((LivingEntity) attacker).getEquipment().setItemInMainHand((NOTHING_ITEM)); 

                //Vector velocity = damagedEntity.getLocation().getDirection().multiply(1);

                double randomX = Math.random() * 2 - 1; // Random value between -1 and 1
                double randomZ = Math.random() * 2 - 1; // Random value between -1 and 1

                for (int i = 0; i < 7; i++) {

                    damagedEntity.damage(1);
                    Vector randomDirection = new Vector(randomX, 0, randomZ);
                    randomDirection.normalize();
                    Vector velocity = randomDirection.multiply(2); // Speed of 1
                    damagedEntity.setVelocity(velocity);

                }


            }
        }
    }
}
