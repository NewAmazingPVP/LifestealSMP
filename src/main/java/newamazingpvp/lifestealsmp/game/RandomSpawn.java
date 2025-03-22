package newamazingpvp.lifestealsmp.game;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerRespawnEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.scheduler.BukkitRunnable;

import static newamazingpvp.lifestealsmp.LifestealSMP.lifestealSmp;
import static newamazingpvp.lifestealsmp.utility.Utils.addItemOrDrop;

public class RandomSpawn implements Listener {

    @EventHandler
    public void onJoin(PlayerJoinEvent event) {
        if (!event.getPlayer().hasPlayedBefore()){
            event.getPlayer().teleportAsync(getRandomSpawnLocation()).thenAccept(success -> {
                if(success) {
                    final int[] i = {0};
                    new BukkitRunnable() {
                        @Override
                        public void run() {
                            event.getPlayer().setInvulnerable(true);
                            i[0]++;
                            // task running 20 ticks times 15 so >15 seconds
                            if (i[0] > 45){
                                event.getPlayer().setInvulnerable(false);
                                this.cancel();
                            }
                        }
                    }.runTaskTimer(lifestealSmp, 0, 20);
                }
            });
        }
    }

    @EventHandler
    public void onPlayerRepsawn(PlayerRespawnEvent event) {
        if (!event.isBedSpawn() && !event.isAnchorSpawn()) {
            Bukkit.getScheduler().runTaskLater(lifestealSmp, () -> {
                event.getPlayer().teleportAsync(getRandomSpawnLocation()).thenAccept(success -> {
                    if(success) {
                        final int[] i = {0};
                        addItemOrDrop(event.getPlayer(), new ItemStack(Material.DARK_OAK_LOG, 8), "");
                        new BukkitRunnable() {
                            @Override
                            public void run() {
                                event.getPlayer().setInvulnerable(true);
                                i[0]++;
                                if (i[0] > 30){
                                    event.getPlayer().setInvulnerable(false);
                                    this.cancel();
                                }
                            }
                        }.runTaskTimer(lifestealSmp, 0, 20);
                    }
                });
            }, 1);
        }
    }

    public Location getRandomSpawnLocation() {
        double coord = (Bukkit.getWorld("world").getWorldBorder().getSize() - 10);
        return new Location(Bukkit.getWorld("world"), (Math.random() - 0.5) * coord, 325, (Math.random() - 0.5) * coord);
    }
}
