package newamazingpvp.lifestealsmp.listener;

import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.entity.Arrow;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.event.entity.EntityDamageByEntityEvent;

public class SpawnProtection implements Listener {

    private final int spawnRadius = 60;

    @EventHandler
    public void onEntityDamageByEntity(EntityDamageByEntityEvent event) {
        if (event.getEntity() instanceof Player) {
            Player damaged = (Player) event.getEntity();

            if (event.getDamager() instanceof Player || event.getDamager() instanceof Arrow) {
                if (event.getDamager() instanceof Player) {
                    Player damager = (Player) event.getDamager();

                    if (isWithinSpawnRadius(damaged.getLocation())) {
                        event.setCancelled(true);
                        damager.sendMessage(ChatColor.RED + "You cannot damage players within the spawn protection area!");
                    }
                } else if (event.getDamager() instanceof Arrow) {
                    Arrow arrow = (Arrow) event.getDamager();
                    if (arrow.getShooter() instanceof Player) {
                        Player shooter = (Player) arrow.getShooter();

                        if (isWithinSpawnRadius(damaged.getLocation())) {
                            event.setCancelled(true);
                            shooter.sendMessage(ChatColor.RED + "You cannot shoot players within the spawn protection area!");
                        }
                    }
                }
            }
        }
    }



    @EventHandler
    public void spawnBlockBreak(BlockBreakEvent event) {
        if (isWithinSpawnRadius(event.getBlock().getLocation())) {
            event.setCancelled(true);
            event.getPlayer().sendMessage(ChatColor.RED + "You cannot break blocks within the spawn area. Go around 50 blocks away to be able to break");
        }
    }

    @EventHandler
    public void spawnBlockPlace(BlockPlaceEvent event) {
        if (isWithinSpawnRadius(event.getBlock().getLocation())) {
            event.setCancelled(true);
            event.getPlayer().sendMessage(ChatColor.RED + "You cannot place blocks within the spawn area. Go around 50 blocks away to be able to place");
        }
    }


    private boolean isWithinSpawnRadius(Location location) {
        Location spawnLocation = location.getWorld().getSpawnLocation();
        World.Environment spawnEnvironment = location.getWorld().getEnvironment();
        if(spawnEnvironment != World.Environment.NORMAL){
            return false;
        }
        return location.distanceSquared(spawnLocation) <= spawnRadius * spawnRadius;
    }
}
