package newamazingpvp.lifestealsmp.listener;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.Arrow;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.ProjectileHitEvent;
import org.bukkit.event.entity.ProjectileLaunchEvent;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.util.Vector;

import java.util.HashMap;
import java.util.UUID;

public class TeleportBow implements Listener {
    private HashMap<UUID, ItemStack> playerHeldItems = new HashMap<>();

    @EventHandler
    public void onProjectileLaunch(ProjectileLaunchEvent event) {
        if (event.getEntityType() == EntityType.ARROW && event.getEntity().getShooter() instanceof Player) {
            Player shooter = (Player) event.getEntity().getShooter();
            ItemStack mainHandItem = shooter.getInventory().getItemInMainHand();

            // Check if the player is holding a bow when they shoot the arrow
            if (isBow(mainHandItem)) {
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

            // Check if the player has a bow in the map (i.e., they shot the arrow with a bow)
            if (playerHeldItems.containsKey(shooter.getUniqueId())) {
                // Calculate the location where the arrow lands
                Location arrowLocation = arrow.getLocation();
                Vector arrowVelocity = arrow.getVelocity();
                double arrowSpeed = arrowVelocity.length();
                double airTime = arrowLocation.distance(arrowLocation.getWorld().getHighestBlockAt(arrowLocation).getLocation()) / arrowSpeed;

                // Use the arrow's velocity to estimate the landing location
                Location landingLocation = arrowLocation.clone().add(arrowVelocity.multiply(airTime));

                // Teleport the player slightly in the direction they were looking when they shot the arrow
                Location teleportLocation = landingLocation.clone();
                teleportLocation.setPitch(shooter.getLocation().getPitch());
                teleportLocation.setYaw(shooter.getLocation().getYaw());

                shooter.teleport(teleportLocation);

                // Remove the player from the map to prevent multiple teleports
                playerHeldItems.remove(shooter.getUniqueId());
            }
        }
    }

    // Helper method to check if an item is a bow
    private boolean isBow(ItemStack item) {
        ItemMeta meta = item.getItemMeta();
        return item != null && item.getType() == Material.BOW;

    }
}
