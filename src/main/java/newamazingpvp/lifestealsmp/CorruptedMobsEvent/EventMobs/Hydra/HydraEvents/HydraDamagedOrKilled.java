package newamazingpvp.lifestealsmp.CorruptedMobsEvent.EventMobs.Hydra.HydraEvents;

import org.bukkit.Location;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;

public class HydraDamagedOrKilled implements Listener {

    @EventHandler
    public void whenPlayerHit(EntityDamageByEntityEvent e) {


        Entity damagedEntity = e.getEntity();
        Location loc = damagedEntity.getLocation();
        Player player = (Player) e.getDamager();


        if (damagedEntity.hasMetadata("hydra_mob")) {



        }


    }
}