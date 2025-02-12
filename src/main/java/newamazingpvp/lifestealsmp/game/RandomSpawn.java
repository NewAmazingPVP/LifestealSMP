package newamazingpvp.lifestealsmp.game;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerRespawnEvent;

import static newamazingpvp.lifestealsmp.LifestealSMP.lifestealSmp;

public class RandomSpawn implements Listener {

    @EventHandler
    public void onJoin(PlayerJoinEvent event) {
        if (!event.getPlayer().hasPlayedBefore()){
            event.getPlayer().teleport(getRandomSpawnLocation());
            event.getPlayer().setInvulnerable(true);
            Bukkit.getScheduler().runTaskLater(lifestealSmp, () -> {
                event.getPlayer().setInvulnerable(false);
            }, 600);
        }
    }

    @EventHandler
    public void onPlayerRepsawn(PlayerRespawnEvent event) {
        if (!event.isBedSpawn() && !event.isAnchorSpawn()) {
            Bukkit.getScheduler().runTaskLater(lifestealSmp, () -> {
                event.getPlayer().teleport(getRandomSpawnLocation());
                event.getPlayer().setInvulnerable(true);
                Bukkit.getScheduler().runTaskLater(lifestealSmp, () -> {
                    event.getPlayer().setInvulnerable(false);
                }, 600);
            }, 1);
        }
    }


    public Location getRandomSpawnLocation() {
        double coord = (Bukkit.getWorld("world").getWorldBorder().getSize() - 10) / 2;
        return new Location(Bukkit.getWorld("world"), Math.random() * coord, 330, Math.random() * coord);
    }

}
