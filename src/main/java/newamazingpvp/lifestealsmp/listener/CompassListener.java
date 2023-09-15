package newamazingpvp.lifestealsmp.listener;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.event.player.PlayerPortalEvent;
import org.bukkit.event.player.PlayerQuitEvent;

import static newamazingpvp.lifestealsmp.game.Compass.lastPortalLocations;
import static newamazingpvp.lifestealsmp.game.Compass.trackingPlayers;

public class CompassListener implements Listener{
    @EventHandler
    public void onPlayerPortalEvent(PlayerPortalEvent event) {
        lastPortalLocations.put(event.getPlayer().getUniqueId(), event.getFrom());
    }

    @EventHandler
    public void onPlayerQuit(PlayerQuitEvent event) {
        trackingPlayers.remove(event.getPlayer().getUniqueId());
    }

    @EventHandler
    private void onPlayerDeath(PlayerDeathEvent e){
        Player player = e.getEntity();
        trackingPlayers.remove(player.getUniqueId());
    }

}
