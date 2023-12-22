package newamazingpvp.lifestealsmp.customitems;

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

import static newamazingpvp.lifestealsmp.customitems.FeatherSword.getString;
import static newamazingpvp.lifestealsmp.listener.SpawnProtection.isWithinSpawnRadius;

public class TntBow implements Listener {
    private final HashMap<UUID, ItemStack> playerHeldItems = new HashMap<>();
    private final Map<Player, Long> teleportCooldowns = new HashMap<>();
    private final long teleportCooldownDuration = 5000;

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
            if (!isTeleportCooldownExpired(shooter)) {
                event.setCancelled(true);
                shooter.sendMessage(ChatColor.RED + "You must wait " + cooldownRemainingTime(shooter) + " for the cooldown to finish before using the TNT again.");
            }
        }
    }

    @EventHandler
    public void onProjectileLaunch(ProjectileLaunchEvent event) {
        if (event.getEntityType() == EntityType.ARROW && event.getEntity().getShooter() instanceof Player) {
            Player shooter = (Player) event.getEntity().getShooter();
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
                if (isTeleportCooldownExpired(shooter)) {
                    Location arrowLocation = arrow.getLocation();
                    spawnIgnitedTNT(arrowLocation, shooter);
                    ItemStack item = playerHeldItems.get(shooter.getUniqueId());
                    playerHeldItems.remove(shooter.getUniqueId());
                    setTeleportCooldown(shooter);
                } else {
                    shooter.sendMessage(ChatColor.RED + "You must wait " + cooldownRemainingTime(shooter) + " for the cooldown to finish before using the TNT again.");
                }
            }
        }
    }

    public static void spawnIgnitedTNT(Location location, Entity p) {
        if (isWithinSpawnRadius(location)) return;
        TNTPrimed tnt = (TNTPrimed) location.getWorld().spawnEntity(location, EntityType.PRIMED_TNT);

        tnt.setFuseTicks(80);
        tnt.setSource(p);
    }

    private boolean isBow(ItemStack item) {
        ItemMeta meta = item.getItemMeta();
        return item.getType() == Material.BOW && meta.getLore() != null && meta.getLore().toString().contains("TNT Shooter!");
    }

    private boolean isTeleportCooldownExpired(Player player) {
        if (teleportCooldowns.containsKey(player)) {
            long lastTeleportTime = teleportCooldowns.get(player);
            long currentTime = System.currentTimeMillis();
            return currentTime - lastTeleportTime >= teleportCooldownDuration;
        }
        return true;
    }

    private void setTeleportCooldown(Player player) {
        teleportCooldowns.put(player, System.currentTimeMillis());
    }

    private String cooldownRemainingTime(Player player) {
        return getString(player, teleportCooldowns, teleportCooldownDuration);
    }
}
