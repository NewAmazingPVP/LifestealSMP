package newamazingpvp.lifestealsmp.customitems.itemlisteners;

import newamazingpvp.lifestealsmp.customitems.utils.Recipes;
import org.bukkit.*;
import org.bukkit.block.Block;
import org.bukkit.block.BlockFace;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerItemHeldEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.util.Vector;
import org.jetbrains.annotations.NotNull;

import java.util.HashMap;
import java.util.Map;

public class FeatherSword implements Listener {
    private final Map<Player, Long> teleportCooldowns = new HashMap<>();
    private final long teleportCooldownDuration = 5000;

    @EventHandler
    public void onPlayerItemHeld(PlayerItemHeldEvent event) {
        Player player = event.getPlayer();

        ItemStack mainHandItem = player.getInventory().getItem(event.getNewSlot());
        ItemStack offHandItem = player.getInventory().getItemInOffHand();

        if (isPermanentSpeedSword(mainHandItem) || isPermanentSpeedSword(offHandItem)) {
            player.setWalkSpeed(0.3f);
            //giveSpeed(player);
        } else {
            player.setWalkSpeed(0.2f);
            //removeSpeed(player);
        }
    }

    private boolean isPermanentSpeedSword(ItemStack item) {
        if (item != null && item.getType() == Material.NETHERITE_SWORD) {
            ItemMeta meta = item.getItemMeta();
            return meta.getLore() != null && meta.getLore().toString().toLowerCase().contains("permanent speed");
        }
        return false;
    }

    @EventHandler
    public void onPlayerRightClick(PlayerInteractEvent event) {
        Player player = event.getPlayer();
        if ((event.getAction() == Action.RIGHT_CLICK_AIR || event.getAction() == Action.RIGHT_CLICK_BLOCK) &&
                event.hasItem() && event.hasItem() && event.getItem().getType() == Material.NETHERITE_SWORD) {
            ItemMeta meta = event.getItem().getItemMeta();
            if (meta.getLore() == null) return;
            if (meta.getLore().toString().toLowerCase().contains("permanent speed")
                    && !player.getInventory().getItemInOffHand().toString().toLowerCase().contains("shield")) {
                if (isTeleportCooldownExpired(player)) {
                    //Vector direction = player.getLocation().getDirection();
                    //direction.multiply(new Vector(10, 10, 10));
                    //Location targetLocation = player.getLocation().add(direction);


                    //player.getLocation().getWorld().spawnParticle(Particle.EXPLOSION_NORMAL, player.getLocation(), 10);
                    player.playSound(player.getLocation(), Sound.ENTITY_BLAZE_SHOOT, 5.0f, 2.0f);
                    Vector velocity = player.getLocation().getDirection().multiply(3);
                    double maxHeight = 1.0;
                    if (velocity.getY() > maxHeight) {
                        velocity.setY(maxHeight);
                    }
                    player.setVelocity(velocity);
                    setTeleportCooldown(player);

                    //if (isSafeLocation(targetLocation)) {
                    //    player.teleport(targetLocation);
                    //    setTeleportCooldown(player);
                    //} else {
                    //    player.sendMessage(ChatColor.RED + "Teleport destination is blocked.");
                    //    player.playSound(player.getLocation(), Sound.ENTITY_ENDERMAN_TELEPORT, 2.0f, 0.0f);
                    //}
                } else {
                    player.sendMessage(ChatColor.RED + "You must wait " + cooldownRemainingTime(player) + " for the cooldown to finish before teleporting again.");
                }
            }
        }
    }


    private boolean isSafeLocation(Location location) {
        Block block = location.getBlock();
        return block.isEmpty() && block.getRelative(BlockFace.UP).isEmpty();
    }

    private boolean isTeleportCooldownExpired(Player player) {
        if (teleportCooldowns.containsKey(player)) {
            long lastTeleportTime = teleportCooldowns.get(player);
            long currentTime = System.currentTimeMillis();
            return currentTime - lastTeleportTime >= teleportCooldownDuration;
        }
        return true;
    }

    private String cooldownRemainingTime(Player player) {
        return getString(player, teleportCooldowns, teleportCooldownDuration);
    }

    @NotNull
    public static String getString(Player player, Map<Player, Long> teleportCooldowns, long teleportCooldownDuration) {
        if (teleportCooldowns.containsKey(player)) {
            long lastTeleportTime = teleportCooldowns.get(player);
            long currentTime = System.currentTimeMillis();
            long remainingCooldown = teleportCooldownDuration - (currentTime - lastTeleportTime);

            if (remainingCooldown <= 0) {
                return "Cooldown is over.";
            }

            int seconds = (int) (remainingCooldown / 1000);
            return seconds + " seconds";
        }

        return "Cooldown is over.";
    }


    private void setTeleportCooldown(Player player) {
        teleportCooldowns.put(player, System.currentTimeMillis());
    }

    private void giveSpeed(Player player) {
        player.addPotionEffect(new PotionEffect(PotionEffectType.SPEED, Integer.MAX_VALUE, 1, true, false));
    }

    private void removeSpeed(Player player) {
        player.removePotionEffect(PotionEffectType.SPEED);
    }


}
