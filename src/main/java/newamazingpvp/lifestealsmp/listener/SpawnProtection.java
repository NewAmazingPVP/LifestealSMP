package newamazingpvp.lifestealsmp.listener;

import com.destroystokyo.paper.event.entity.PreCreatureSpawnEvent;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.event.block.BlockSpreadEvent;
import org.bukkit.event.block.TNTPrimeEvent;
import org.bukkit.event.entity.EntityChangeBlockEvent;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.entity.EntityExplodeEvent;
import org.bukkit.event.player.PlayerInteractEvent;

import static newamazingpvp.lifestealsmp.discord.DiscordListener.isVanished;
import static newamazingpvp.lifestealsmp.utility.Utils.returnPlayerDamager;
import static newamazingpvp.lifestealsmp.variables.Loc.spawnLoc1;
import static newamazingpvp.lifestealsmp.variables.Loc.spawnLoc2;
import static newamazingpvp.lifestealsmp.variables.Misc.isEndFightEnabled;


public class SpawnProtection implements Listener {

    private static final int spawnRadius = 60;

    @EventHandler(priority = EventPriority.LOW)
    public void onEntityDamageByEntity(EntityDamageByEntityEvent event) {
        if (event.getEntity() instanceof Player damaged) {
            Player damager = returnPlayerDamager(event.getDamager());
            if (damager == null) return;
            Location original = damaged.getLocation();
            Location expanded = new Location(original.getWorld(), original.getX() / 2, original.getY(), original.getZ() / 2);
            Location fake = new Location(original.getWorld(), original.getX() * 10, original.getY(), original.getZ() * 10);
            if (original.getWorld().getName().equals("world")) {
                if (isWithinSpawnRadius(expanded)) {
                    //if (isInCombat(damager) && isInCombat(damaged)) return;
                    event.setCancelled(true);
                    damager.sendMessage(ChatColor.RED + "You cannot damage players within the vicinity spawn protection area, go away from spawn to be able to!");
                }
            } else {
                if (isWithinSpawnRadius(fake) && !isEndFightEnabled && !damaged.getWorld().getName().equals("end_fight_world") && !damaged.getWorld().getName().equals("tournament_world")) {
                    //if (isInCombat(damager) && isInCombat(damaged)) return;
                    event.setCancelled(true);
                    damager.sendMessage(ChatColor.RED + "You cannot damage players within the vicinity spawn protection area of PVP world (0,0), go +-100 x or z coords blocks away to be able to!");
                }
            }
        }
    }

    public static boolean isWithinSpawnRadiusWorld(Location location) {
        if (!location.getWorld().getName().equals("world")) {
            return false;
        }
        //if (inLocation(location, spawnLoc1, spawnLoc2)) return true;
        //return inLocation(location, signLoc1, signLoc2);
        return inLocation(location, spawnLoc1, spawnLoc2);
    }


    @EventHandler
    public void spawnBlockBreak(BlockBreakEvent event) {
        if (isWithinSpawnRadiusWorld(event.getBlock().getLocation())) {
            if (isVanished(event.getPlayer())) return;
            event.setCancelled(true);
            event.getPlayer().sendMessage(ChatColor.RED + "You cannot break blocks within the spawn area (0,0), go +-100 x or z coords blocks away to be able to");
        }
    }

    @EventHandler
    public void spawnBlockPlace(BlockPlaceEvent event) {
        if (isWithinSpawnRadiusWorld(event.getBlock().getLocation())) {
            if (isVanished(event.getPlayer())) return;
            event.setCancelled(true);
            event.getPlayer().sendMessage(ChatColor.RED + "You cannot place blocks within the spawn area (0,0), go +-100 x or z coords blocks away to be able to");
        }
    }

    /*@EventHandler(priority = EventPriority.HIGH)
    public void onPvpNearSpawn(EntityDamageByEntityEvent event) {
        World.Environment spawnEnvironment = event.getEntity().getWorld().getEnvironment();
        if (spawnEnvironment != World.Environment.NORMAL) {
            return;
        }
        if (event.getEntity() instanceof Player damaged) {
            Player damager = returnPlayerDamager(event.getDamager());
            if (damager == null) return;
            if (event.isCancelled()) return;
            if (getPlaytime(damager) < 12000 && !newbieViolate.contains(damager.getName())) {
                newbieViolate.add(damager.getName());
                event.setCancelled(true);
                damager.sendMessage(ChatColor.RED + "You tried attacking someone and have temporarily lost newbie protection");
                new BukkitRunnable() {
                    @Override
                    public void run() {
                        newbieViolate.remove(damager.getName());
                    }
                }.runTaskLater(lifestealSmp, 20 * 60 * 5);
            }
            if (invincibilityPlayers.contains(damager.getName())) {
                event.setCancelled(true);
                damager.sendMessage(ChatColor.RED + "You tried attacking someone and have lost death protection");
                invincibilityPlayers.remove(damager.getName());
            }
            vicinityPvp(event, damaged, damager);
        }
    }

    private void vicinityPvp(EntityDamageByEntityEvent event, Player damaged, Player damager) {
        if (damaged.getLocation().distance(Bukkit.getWorld("world").getSpawnLocation()) < 500 ||
                damager.getLocation().distance(Bukkit.getWorld("world").getSpawnLocation()) < 500) {
            damaged.sendMessage(ChatColor.RED + "PVP near the vicinity of spawn is discouraged, thus therefore both of you will take " + ChatColor.DARK_RED + ChatColor.BOLD + "SAME DAMAGE" + ChatColor.RED + " regardless of your gear");
            damager.sendMessage(ChatColor.RED + "PVP near the vicinity of spawn is discouraged, thus therefore both of you will take " + ChatColor.DARK_RED + ChatColor.BOLD + "SAME DAMAGE" + ChatColor.RED + " regardless of your gear");
            event.setDamage(0.0);
            damaged.setHealth(Math.max(0, damaged.getHealth() - 1.0));
        }
    }*/

    @EventHandler
    public void spawnBlockPlace(PlayerInteractEvent event) {
        if (isWithinSpawnRadiusWorld(event.getPlayer().getLocation())) {
            if (isVanished(event.getPlayer())) return;
            if (event.getPlayer().getInventory().getItemInMainHand().getType() == Material.WRITTEN_BOOK) return;
            if (event.getPlayer().getInventory().getItemInMainHand().getType() == Material.COOKED_MUTTON) return;
            if (event.getPlayer().getInventory().getItemInMainHand().getType() == Material.COOKED_BEEF) return;
            if (event.getPlayer().getInventory().getItemInMainHand().getType() == Material.COOKED_CHICKEN) return;
            /*if (event.getPlayer().getInventory().getItemInMainHand().getType() == Material.LAVA_BUCKET
                    || event.getPlayer().getInventory().getItemInMainHand().getType() == Material.FIRE_CHARGE
                    || event.getPlayer().getInventory().getItemInMainHand().getType() == Material.FLINT_AND_STEEL
                    || event.getPlayer().getInventory().getItemInMainHand().getType() == Material.WATER_BUCKET
                    || event.getPlayer().getInventory().getItemInMainHand().getType() == Material.BOW) {*/
            event.setCancelled(true);
            event.getPlayer().sendMessage(ChatColor.RED + "You cannot interact within the spawn area (0,0), go +-100 x or z coords blocks away to be able to");
            //}
        }
    }

    @EventHandler
    public void entityDamage(EntityDamageEvent e) {
        if (e.getEntity() instanceof Player && isWithinSpawnRadiusWorld(e.getEntity().getLocation()) && !isEndFightEnabled && !e.getEntity().getWorld().getName().equals("end_fight_world") && !e.getEntity().getWorld().getName().equals("tournament_world")) {
            e.setCancelled(true);
        }
    }

    /*@EventHandler
    public void hungerLose(FoodLevelChangeEvent e) {
        if (e.getEntity() instanceof Player && isWithinSpawnRadius(e.getEntity().getLocation())) {
            e.setCancelled(true);
        }
    }*/

    @EventHandler
    public void spawnTNT(TNTPrimeEvent e) {
        if (isWithinSpawnRadiusWorld(e.getBlock().getLocation())) {
            e.setCancelled(true);
        }
    }

    @EventHandler
    public void mobSpawnEvent(PreCreatureSpawnEvent e) {
        if (isWithinSpawnRadiusWorld(e.getSpawnLocation())) {
            e.setCancelled(true);
        }
    }

    public static boolean isWithinSpawnRadius(Location location) {
        World.Environment spawnEnvironment = location.getWorld().getEnvironment();
        if (spawnEnvironment != World.Environment.NORMAL) {
            return false;
        }
        //if (inLocation(location, spawnLoc1, spawnLoc2)) return true;
        //return inLocation(location, signLoc1, signLoc2);
        return inLocation(location, spawnLoc1, spawnLoc2);
    }

    private static boolean inLocation(Location location, Location loc1, Location loc2) {
        if (location.x() > loc1.x() && location.x() < loc2.x()) {
            if (location.y() > loc1.y() && location.y() < loc2.y()) {
                return location.z() > loc1.z() && location.z() < loc2.z();
            }
        }
        return false;
    }

    @EventHandler
    public void preventFireSpread(BlockSpreadEvent event) {
        if (isWithinSpawnRadiusWorld(event.getBlock().getLocation())) {
            event.setCancelled(true);
        }
    }

    @EventHandler
    public void onEntityExplode(EntityExplodeEvent event) {
        if (isWithinSpawnRadiusWorld(event.getLocation())) {
            event.setCancelled(true);
            event.blockList().clear();
        }
    }

    @EventHandler
    public void preventEndermanGriefing(EntityChangeBlockEvent event) {
        if (isWithinSpawnRadiusWorld(event.getBlock().getLocation())) {
            event.setCancelled(true);
        }
    }


}
