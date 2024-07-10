package newamazingpvp.lifestealsmp.RaffleEvent.RaffleCustomMobs.Mage.MageEvents;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDeathEvent;
import org.bukkit.metadata.MetadataValue;

import static newamazingpvp.lifestealsmp.LifestealSMP.lifestealSmp;
import static newamazingpvp.lifestealsmp.RaffleEvent.RaffleCustomMobs.Mage.SpawnMage.SpawnMage.mageMobAttackRate;

public class MageDeathListener implements Listener {
    @EventHandler
    public void onMageDeath(EntityDeathEvent event) {
        if (event.getEntity().hasMetadata("mage_mob")) {
            for (MetadataValue value : event.getEntity().getMetadata("mage_mob")) {
                if (value.getOwningPlugin() == lifestealSmp) {
                    if (mageMobAttackRate != null) {
                        mageMobAttackRate.cancel();
                    }
                    break;
                }
            }
        }
    }
}
