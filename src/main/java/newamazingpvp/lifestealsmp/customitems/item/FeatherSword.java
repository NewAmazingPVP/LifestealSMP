package newamazingpvp.lifestealsmp.customitems.item;

import newamazingpvp.lifestealsmp.utility.CooldownManager;
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

import java.util.HashMap;
import java.util.Map;

import static newamazingpvp.lifestealsmp.LifestealSMP.lifestealSmp;
import static org.bukkit.Bukkit.getServer;

public class FeatherSword implements Listener {
    private final Map<Player, CooldownManager> teleportCooldowns = new HashMap<>();
    private final int teleportCooldownDuration = 5;

    @EventHandler
    public void onPlayerItemHeld(PlayerItemHeldEvent event) {
        Player player = event.getPlayer();

        ItemStack mainHandItem = player.getInventory().getItem(event.getNewSlot());
        ItemStack offHandItem = player.getInventory().getItemInOffHand();

        if (isPermanentSpeedSword(mainHandItem) || isPermanentSpeedSword(offHandItem)) {
            //player.setWalkSpeed(0.3f);
            player.setWalkSpeed(0.24f);
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
                event.hasItem() && event.getItem().getType() == Material.NETHERITE_SWORD) {
            ItemMeta meta = event.getItem().getItemMeta();
            if (meta.getLore() == null) return;
            if(player.hasPotionEffect(PotionEffectType.SLOW_FALLING)) {
                player.sendMessage(ChatColor.RED + "You cannot use feather sword with slow falling");
            }
            if (meta.getLore().toString().toLowerCase().contains("permanent speed")
                    && !player.getInventory().getItemInOffHand().toString().toLowerCase().contains("shield")) {

                CooldownManager cooldownManager = teleportCooldowns.getOrDefault(player, new CooldownManager());

                if (!cooldownManager.isOnCooldown()) {
                    player.getLocation().getWorld().spawnParticle(Particle.CLOUD, player.getLocation(), 10);
                    player.playSound(player.getLocation(), Sound.ENTITY_BLAZE_SHOOT, 5.0f, 2.0f);
                    Vector velocity = player.getLocation().getDirection().multiply(3);
                    /*double maxHeight = 1.0;
                    if (velocity.getY() > maxHeight) {
                        velocity.setY(maxHeight);
                    }*/
                    player.setVelocity(velocity);
                    cooldownManager.setCooldown(teleportCooldownDuration);
                    getServer().getScheduler().runTaskLater(lifestealSmp, () -> event.getPlayer().setCooldown(event.getItem().getType(), teleportCooldownDuration * 20), 1);
                    teleportCooldowns.put(player, cooldownManager);
                } else {
                    player.sendMessage(ChatColor.RED + "You must wait " + cooldownManager.getRemainingSeconds() + " seconds for the cooldown to finish before teleporting again.");
                }
            }
        }
    }

    private boolean isSafeLocation(Location location) {
        Block block = location.getBlock();
        return block.isEmpty() && block.getRelative(BlockFace.UP).isEmpty();
    }

    private void giveSpeed(Player player) {
        player.addPotionEffect(new PotionEffect(PotionEffectType.SPEED, Integer.MAX_VALUE, 1, true, false));
    }

    private void removeSpeed(Player player) {
        player.removePotionEffect(PotionEffectType.SPEED);
    }
}
