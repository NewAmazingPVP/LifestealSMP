package newamazingpvp.lifestealsmp.game;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerRespawnEvent;
import org.bukkit.scheduler.BukkitRunnable;

import static newamazingpvp.lifestealsmp.LifestealSMP.lifestealSmp;

public class RandomSpawn implements Listener {

    @EventHandler
    public void onJoin(PlayerJoinEvent event) {
        if (!event.getPlayer().hasPlayedBefore()){
            event.getPlayer().teleport(getRandomSpawnLocation());
            final int[] i = {0};
            new BukkitRunnable() {
                @Override
                public void run() {
                    event.getPlayer().setInvulnerable(true);
                    i[0]++;
                    //task running 20 ticks times 15 so >15 seconds
                    if (i[0] > 15){
                        event.getPlayer().setInvulnerable(false);
                        this.cancel();
                    }
                }
            }.runTaskTimer(lifestealSmp, 0, 20);
        }
    }

    @EventHandler
    public void onPlayerRepsawn(PlayerRespawnEvent event) {
        if (!event.isBedSpawn() && !event.isAnchorSpawn()) {
            Bukkit.getScheduler().runTaskLater(lifestealSmp, () -> {
                event.getPlayer().teleport(getRandomSpawnLocation());
                final int[] i = {0};
                new BukkitRunnable() {
                    @Override
                    public void run() {
                        event.getPlayer().setInvulnerable(true);
                        i[0]++;
                        if (i[0] > 15){
                            event.getPlayer().setInvulnerable(false);
                            this.cancel();
                        }
                    }
                }.runTaskTimer(lifestealSmp, 0, 20);
            }, 1);
        }
    }


    public Location getRandomSpawnLocation() {
        double coord = (Bukkit.getWorld("world").getWorldBorder().getSize() - 10) / 2;
        return new Location(Bukkit.getWorld("world"), Math.random() * coord, 325, Math.random() * coord);
    }

}
