package newamazingpvp.lifestealsmp.listener;

import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.Arrow;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.entity.TNTPrimed;
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
import java.util.Map;
import java.util.UUID;

public class TeleportBow implements Listener {
    private HashMap<UUID, ItemStack> playerHeldItems = new HashMap<>();
    private final Map<Player, Long> teleportCooldowns = new HashMap<>();
    private final long teleportCooldownDuration = 30000;

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
                if (isTeleportCooldownExpired(shooter)) {
                    // Calculate the location where the arrow lands
                    Location arrowLocation = arrow.getLocation();
                    //Vector arrowVelocity = arrow.getVelocity();
                    //double arrowSpeed = arrowVelocity.length();
                    //double airTime = arrowLocation.distance(arrowLocation.getWorld().getHighestBlockAt(arrowLocation).getLocation()) / arrowSpeed;

                    // Use the arrow's velocity to estimate the landing location
                    //Location landingLocation = arrowLocation.clone().add(arrowVelocity.multiply(airTime));

                    // Teleport the player slightly in the direction they were looking when they shot the arrow
                    //Location teleportLocation = landingLocation.clone();
                    arrowLocation.setPitch(shooter.getLocation().getPitch());
                    arrowLocation.setYaw(shooter.getLocation().getYaw());

                    shooter.teleport(arrowLocation);
                    ItemStack item = playerHeldItems.get(shooter.getUniqueId());
                    playerHeldItems.remove(shooter.getUniqueId());
                    setTeleportCooldown(shooter);
                } else {
                    shooter.sendMessage(ChatColor.RED + "You must wait "+ cooldownRemainingTime(shooter) + " for the cooldown to finish before teleporting again.");
                }
            }
        }
    }

    private boolean isBow(ItemStack item) {
        ItemMeta meta = item.getItemMeta();
        return item.getType() == Material.BOW && meta.getLore().toString().contains("Shoot to teleport!");

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
        if (teleportCooldowns.containsKey(player)) {
            long lastTeleportTime = teleportCooldowns.get(player);
            long currentTime = System.currentTimeMillis();
            long remainingCooldown = teleportCooldownDuration - (currentTime - lastTeleportTime);

            if (remainingCooldown <= 0) {
                return "Cooldown is over.";
            }

            int seconds = (int) (remainingCooldown / 1000);
            int minutes = seconds / 60;
            seconds %= 60;

            return String.format("%d:%02d", minutes, seconds);
        }

        return "Cooldown is over.";
    }
}
