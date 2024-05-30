package newamazingpvp.lifestealsmp.MinecraftBINGO.BingoChallengeListeners;

import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDeathEvent;
import org.bukkit.event.player.PlayerInteractEvent;

import static newamazingpvp.lifestealsmp.MinecraftBINGO.ToggleBingoListeners.toggleKillEnderdragon;

public class BingoKillEnderdragonListener implements Listener {

    @EventHandler
    public void playerKill(EntityDeathEvent e) {

        Player player = e.getEntity().getKiller();
        EntityType entityType = e.getEntity().getType();


        if(toggleKillEnderdragon == true){
            if(entityType == EntityType.ENDER_DRAGON){

                //TODO: <<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<


            }
        }
    }
}
