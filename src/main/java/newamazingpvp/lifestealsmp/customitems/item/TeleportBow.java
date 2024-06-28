package newamazingpvp.lifestealsmp.customitems.item;

import newamazingpvp.lifestealsmp.utility.CooldownManager;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.Arrow;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
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
import static org.bukkit.Bukkit.getServer;

public class TeleportBow implements Listener {
    private final Map<UUID, ItemStack> playerHeldItems = new HashMap<>();
    private final Map<Player, CooldownManager> teleportCooldowns = new HashMap<>();
    private final int teleportCooldownDuration = 10; // Cooldown time in seconds

    @EventHandler
    public void onPlayerUseBow(PlayerInteractEvent event) {
        if (event.getAction() != Action.LEFT_CLICK_AIR &&
                event.getAction() != Action.LEFT_CLICK_BLOCK &&
                event.getAction() != Action.RIGHT_CLICK_AIR &&
                event.getAction() != Action.RIGHT_CLICK_BLOCK) {
            return;
        }

        Player shooter = event.getPlayer();
        ItemStack mainHandItem = shooter.getInventory().getItemInMainHand();
        ItemStack offHandItem = shooter.getInventory().getItemInOffHand();

        if (isTeleportBow(mainHandItem) || isTeleportBow(offHandItem)) {
            CooldownManager cooldown = teleportCooldowns.getOrDefault(shooter, new CooldownManager());
            if (cooldown.isOnCooldown()) {
                event.setCancelled(true);
                shooter.sendMessage(ChatColor.RED + "You must wait " + cooldown.getRemainingSeconds() + " seconds before using the Teleport Bow again.");
            }
        }
    }

    @EventHandler
    public void onProjectileLaunch(ProjectileLaunchEvent event) {
        if (event.getEntityType() == EntityType.ARROW && event.getEntity().getShooter() instanceof Player) {
            Player shooter = (Player) event.getEntity().getShooter();
            ItemStack mainHandItem = shooter.getInventory().getItemInMainHand();
            ItemStack offHandItem = shooter.getInventory().getItemInOffHand();

            if (isTeleportBow(mainHandItem) || isTeleportBow(offHandItem)) {
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
                CooldownManager cooldown = teleportCooldowns.getOrDefault(shooter, new CooldownManager());

                if (!cooldown.isOnCooldown()) {
                    Location arrowLocation = arrow.getLocation();
                    arrowLocation.setPitch(shooter.getLocation().getPitch());
                    arrowLocation.setYaw(shooter.getLocation().getYaw());

                    shooter.teleport(arrowLocation);
                    playerHeldItems.remove(shooter.getUniqueId());
                    cooldown.setCooldown(teleportCooldownDuration);
                    getServer().getScheduler().runTaskLater(lifestealSmp, () -> shooter.setCooldown(Material.BOW, teleportCooldownDuration*20), 1);
                    teleportCooldowns.put(shooter, cooldown);
                } else {
                    shooter.sendMessage(ChatColor.RED + "You must wait " + cooldown.getRemainingSeconds() + " seconds before using the Teleport Bow again.");
                }
            }
        }
    }

    private boolean isTeleportBow(ItemStack item) {
        if (item != null && item.getType() == Material.BOW) {
            ItemMeta meta = item.getItemMeta();
            if (meta != null && meta.hasLore()) {
                return meta.getLore().toString().contains("Shoot to teleport!");
            }
        }
        return false;
    }
}
