package newamazingpvp.lifestealsmp.listener;

import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.entity.Arrow;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.event.block.TNTPrimeEvent;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;

import static newamazingpvp.lifestealsmp.game.CombatLog.isInCombat;
import static newamazingpvp.lifestealsmp.variables.Loc.spawnLoc1;
import static newamazingpvp.lifestealsmp.variables.Loc.spawnLoc2;


public class SpawnProtection implements Listener {

    private static final int spawnRadius = 60;

    @EventHandler
    public void onEntityDamageByEntity(EntityDamageByEntityEvent event) {
        if (event.getEntity() instanceof Player) {
            Player damaged = (Player) event.getEntity();

            if (event.getDamager() instanceof Player || event.getDamager() instanceof Arrow) {
                if (event.getDamager() instanceof Player) {
                    Player damager = (Player) event.getDamager();

                    if (isWithinSpawnRadius(damaged.getLocation())) {
                        //if (isInCombat(damager) && isInCombat(damaged)) return;
                        event.setCancelled(true);
                        damager.sendMessage(ChatColor.RED + "You cannot damage players within the spawn protection area!");
                    }
                } else if (event.getDamager() instanceof Arrow) {
                    Arrow arrow = (Arrow) event.getDamager();
                    if (arrow.getShooter() instanceof Player) {
                        Player shooter = (Player) arrow.getShooter();

                        if (isWithinSpawnRadius(damaged.getLocation())) {
                            //if (isInCombat(shooter) && isInCombat(damaged)) return;
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
            //if(event.getPlayer().getName().equalsIgnoreCase("newamazingpvp")) return;
            event.setCancelled(true);
            event.getPlayer().sendMessage(ChatColor.RED + "You cannot break blocks within the spawn area. Go around 50 blocks away to be able to break");
        }
    }

    @EventHandler
    public void spawnBlockPlace(BlockPlaceEvent event) {
        if (isWithinSpawnRadius(event.getBlock().getLocation())) {
            //if(event.getPlayer().getName().equalsIgnoreCase("newamazingpvp")) return;
            event.setCancelled(true);
            event.getPlayer().sendMessage(ChatColor.RED + "You cannot place blocks within the spawn area. Go around 50 blocks away to be able to place");
        }
    }

    @EventHandler
    public void spawnBlockPlace(PlayerInteractEvent event) {
        if (isWithinSpawnRadius(event.getPlayer().getLocation())) {
            if (event.getPlayer().getInventory().getItemInMainHand().getType() == Material.LAVA_BUCKET
                    || event.getPlayer().getInventory().getItemInMainHand().getType() == Material.FIRE_CHARGE
                    || event.getPlayer().getInventory().getItemInMainHand().getType() == Material.FLINT_AND_STEEL
                    || event.getPlayer().getInventory().getItemInMainHand().getType() == Material.WATER_BUCKET
                    || event.getPlayer().getInventory().getItemInMainHand().getType() == Material.BOW) {
                event.setCancelled(true);
                event.getPlayer().sendMessage(ChatColor.RED + "You cannot interact within the spawn area. Go around 50 blocks away to be able to interact");
            }
        }
    }

    @EventHandler
    public void spawnTNT(TNTPrimeEvent e) {
        if (isWithinSpawnRadius(e.getBlock().getLocation()) || isWithinSpawnRadius(e.getBlock().getLocation())) {
            e.setCancelled(true);
        }
    }

    public static boolean isWithinSpawnRadius(Location location) {
        Location spawnLocation = location.getWorld().getSpawnLocation();
        World.Environment spawnEnvironment = location.getWorld().getEnvironment();
        if (spawnEnvironment != World.Environment.NORMAL) {
            return false;
        }
        if(location.x() > spawnLoc1.x() && location.x() < spawnLoc2.x()){
            if(location.y() > spawnLoc1.y() && location.y() < spawnLoc2.y()){
                if(location.z() > spawnLoc1.z() && location.z() < spawnLoc2.z()){
                    return true;
                }
            }
        }
        return false;
    }


}
