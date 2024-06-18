package newamazingpvp.lifestealsmp.CustomMobs.Mobs.LightningZombie;

import org.bukkit.entity.Entity;
import org.bukkit.entity.LivingEntity;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;

public class LightningZombieListener implements Listener {

    @EventHandler
    public void whenPlayerHit(EntityDamageByEntityEvent e) {

        Entity attacker = e.getDamager();
        Entity damagedEntity = e.getEntity();

        if (attacker instanceof LivingEntity) {

            if (attacker.hasMetadata("electric_zombie")) {

                damagedEntity.sendMessage("test lol");

            }
        }
    }
}
