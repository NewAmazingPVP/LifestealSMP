package newamazingpvp.lifestealsmp.listener;

import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.Arrow;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.ProjectileHitEvent;
import org.bukkit.event.entity.ProjectileLaunchEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import static newamazingpvp.lifestealsmp.listener.FeatherSword.getString;

public class TeleportBow implements Listener {
    private final HashMap<UUID, ItemStack> playerHeldItems = new HashMap<>();
    private final Map<Player, Long> teleportCooldowns = new HashMap<>();
    private final long teleportCooldownDuration = 10000;

    @EventHandler
    public void onProjectileLaunch(ProjectileLaunchEvent event) {
        if (event.getEntityType() == EntityType.ARROW && event.getEntity().getShooter() instanceof Player) {
            Player shooter = (Player) event.getEntity().getShooter();
            ItemStack mainHandItem = shooter.getInventory().getItemInMainHand();
            ItemStack offHandItem = shooter.getInventory().getItemInMainHand();

            // Check if the player is holding a bow when they shoot the arrow
            if (isBow(mainHandItem) || isBow(offHandItem)) {
                playerHeldItems.put(shooter.getUniqueId(), mainHandItem);
            } else {
                // Remove the player from the map if they switched to a non-bow item
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
                    arrowLocation.setPitch(shooter.getLocation().getPitch());
                    arrowLocation.setYaw(shooter.getLocation().getYaw());

                    shooter.teleport(arrowLocation);
                    ItemStack item = playerHeldItems.get(shooter.getUniqueId());
                    playerHeldItems.remove(shooter.getUniqueId());
                    setTeleportCooldown(shooter);
                } else {
                    shooter.sendMessage(ChatColor.RED + "You must wait " + cooldownRemainingTime(shooter) + " for the cooldown to finish before teleporting again.");
                }
            }
        }
    }

    private boolean isBow(ItemStack item) {
        ItemMeta meta = item.getItemMeta();
        return item.getType() == Material.BOW && meta.getLore() != null && meta.getLore().toString().contains("Shoot to teleport!");

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
