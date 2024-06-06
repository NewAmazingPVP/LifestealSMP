package newamazingpvp.lifestealsmp.wip.mcbingo.challengelisteners;

import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDeathEvent;

import static newamazingpvp.lifestealsmp.wip.mcbingo.ToggleBingoListeners.toggleKillWither;

public class BingoKillWitherListener implements Listener {

    @EventHandler
    public void playerKill(EntityDeathEvent e) {

        Player player = e.getEntity().getKiller();
        EntityType entityType = e.getEntity().getType();


        if (toggleKillWither) {
            if (entityType == EntityType.WITHER) {

                //TODO: <<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<


            }
        }
    }
}

