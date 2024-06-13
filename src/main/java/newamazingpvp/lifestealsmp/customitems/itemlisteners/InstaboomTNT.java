package newamazingpvp.lifestealsmp.customitems.itemlisteners;

import newamazingpvp.lifestealsmp.utility.CooldownManager;
import org.bukkit.*;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.util.Vector;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class InstaboomTNT implements Listener {

    private final Map<Player, CooldownManager> tntCooldowns = new HashMap<>();
    private final double tntCooldownTime = 10.0;

    @EventHandler
    public void onBlockPlace(BlockPlaceEvent event) {
        Player player = event.getPlayer();
        ItemStack itemInMainHand = player.getInventory().getItemInMainHand();
        ItemMeta meta = itemInMainHand.getItemMeta();
        Location location = event.getBlock().getLocation();

        if (isInstaBoomTNT(meta)) {
            event.setCancelled(true);
            CooldownManager cooldown = tntCooldowns.getOrDefault(player, new CooldownManager());

            if (!cooldown.isOnCooldown()) {
                triggerInstaBoom(player, location);
                cooldown.setCooldown(tntCooldownTime);
                tntCooldowns.put(player, cooldown);
                updateItemStack(player, itemInMainHand);
            } else {
                player.sendMessage(ChatColor.RED + "You must wait " + cooldown.getRemainingSeconds() + " seconds before using InstaBoom TNT again.");
            }
        } else if (isInstaBoomTNT(player.getInventory().getItemInOffHand().getItemMeta())) {
            event.setCancelled(true);
        }
    }

    private boolean isInstaBoomTNT(ItemMeta meta) {
        return meta != null && meta.hasDisplayName() && meta.getDisplayName().equals(ChatColor.GOLD + "" + ChatColor.BOLD + "InstaBoom TNT");
    }

    private void triggerInstaBoom(Player player, Location location) {
        World world = location.getWorld();
        if (world != null) {
            world.spawnParticle(Particle.EXPLOSION_HUGE, location, 10);
            for (Player onlinePlayer : Bukkit.getOnlinePlayers()) {
                onlinePlayer.playSound(location, Sound.ENTITY_GENERIC_EXPLODE, 5.0f, 1.0f);
                onlinePlayer.playSound(location, Sound.ENTITY_ELDER_GUARDIAN_CURSE, 5.0f, 2.0f);
                List<Player> nearbyPlayers = (List<Player>) world.getNearbyPlayers(location, 3);
                for (Player nearbyPlayer : nearbyPlayers) {
                    applyEffectsAndKnockback(nearbyPlayer, location);
                }
            }
        }
    }

    private void applyEffectsAndKnockback(Player player, Location explosionLocation) {
        player.addPotionEffect(new PotionEffect(PotionEffectType.DARKNESS, 20, 1));
        Vector direction = player.getLocation().toVector().subtract(explosionLocation.toVector()).normalize();
        Vector velocity = direction.multiply(20);
        if (velocity.getY() > 1.0) {
            velocity.setY(1.0);
        }
        player.setVelocity(velocity);
    }

    private void updateItemStack(Player player, ItemStack item) {
        if (item.getAmount() > 1) {
            item.setAmount(item.getAmount() - 1);
        } else {
            player.getInventory().setItemInMainHand(null);
        }
    }
}
