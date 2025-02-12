package newamazingpvp.lifestealsmp.customitems.item;

import newamazingpvp.lifestealsmp.utility.CooldownManager;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.*;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.entity.ProjectileHitEvent;
import org.bukkit.event.entity.ProjectileLaunchEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import static newamazingpvp.lifestealsmp.LifestealSMP.lifestealSmp;
import static newamazingpvp.lifestealsmp.listener.SpawnProtection.isWithinSpawnRadius;
import static org.bukkit.Bukkit.getServer;

public class TntBow implements Listener {
    private final HashMap<UUID, ItemStack> playerHeldItems = new HashMap<>();
    private final Map<Player, CooldownManager> teleportCooldowns = new HashMap<>();

    @EventHandler
    public void onPlayerUseBow(PlayerInteractEvent event) {
        if (!(event.getAction() == Action.LEFT_CLICK_AIR
                || event.getAction() == Action.LEFT_CLICK_BLOCK
                || event.getAction() == Action.RIGHT_CLICK_AIR
                || event.getAction() == Action.RIGHT_CLICK_BLOCK)) {
            return;
        }
        Player shooter = event.getPlayer();
        ItemStack mainHandItem = shooter.getInventory().getItemInMainHand();
        ItemStack offHandItem = shooter.getInventory().getItemInOffHand();
        if (isBow(mainHandItem) || isBow(offHandItem)) {
            if (teleportCooldowns.get(shooter) != null && teleportCooldowns.get(shooter).isOnCooldown()) {
                event.setCancelled(true);
                shooter.sendMessage(ChatColor.RED + "You must wait " + teleportCooldowns.get(shooter).getRemainingSeconds() + " seconds for the cooldown to finish before using the TNT bow again.");
            }
        }
    }

    @EventHandler
    public void onProjectileLaunch(ProjectileLaunchEvent event) {
        if (event.getEntityType() == EntityType.ARROW && event.getEntity().getShooter() instanceof Player shooter) {
            ItemStack mainHandItem = shooter.getInventory().getItemInMainHand();
            ItemStack offHandItem = shooter.getInventory().getItemInOffHand();

            if (isBow(mainHandItem) || isBow(offHandItem)) {
                playerHeldItems.put(shooter.getUniqueId(), mainHandItem);
            } else {
                playerHeldItems.remove(shooter.getUniqueId());
            }
        }
    }

    @EventHandler
    public void onProjectileHit(ProjectileHitEvent event) {
        if (event.getEntityType() == EntityType.ARROW && event.getEntity().getShooter() instanceof Player) {
            Arrow arrow = (Arrow) event.getEntity();
            Player shooter = (Player) arrow.getShooter();

            if (playerHeldItems.containsKey(shooter.getUniqueId())) {
                if (!teleportCooldowns.containsKey(shooter) || !teleportCooldowns.get(shooter).isOnCooldown()) {
                    Location arrowLocation = arrow.getLocation();
                    spawnIgnitedTNT(arrowLocation, shooter);
                    ItemStack item = playerHeldItems.get(shooter.getUniqueId());
                    playerHeldItems.remove(shooter.getUniqueId());
                    if (!teleportCooldowns.containsKey(shooter)) {
                        teleportCooldowns.put(shooter, new CooldownManager());
                    } else {
                        teleportCooldowns.get(shooter).setCooldown(5);
                        getServer().getScheduler().runTaskLater(lifestealSmp, () -> shooter.setCooldown(Material.BOW, 5 * 20), 1);
                    }
                } else {
                    shooter.sendMessage(ChatColor.RED + "You must wait " + teleportCooldowns.get(shooter).getRemainingSeconds() + " for the cooldown to finish before using the TNT again.");
                }
            }
        }
    }

    public static void spawnIgnitedTNT(Location location, Entity p) {
        if (isWithinSpawnRadius(location)) return;
        TNTPrimed tnt = (TNTPrimed) location.getWorld().spawnEntity(location, EntityType.TNT);

        tnt.setFuseTicks(60);
        tnt.setSource(p);
    }

    private boolean isBow(ItemStack item) {
        ItemMeta meta = item.getItemMeta();
        return item.getType() == Material.BOW && meta != null && meta.hasLore() && meta.getLore() != null && meta.getLore().toString().contains("TNT Shooter!");
    }

}
