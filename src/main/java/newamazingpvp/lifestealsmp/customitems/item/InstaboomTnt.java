package newamazingpvp.lifestealsmp.customitems.item;

import newamazingpvp.lifestealsmp.utility.CooldownManager;
import org.bukkit.*;
import org.bukkit.entity.Entity;
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

import static newamazingpvp.lifestealsmp.LifestealSMP.lifestealSmp;
import static org.bukkit.Bukkit.getServer;

public class InstaboomTnt implements Listener {

    private final Map<Player, CooldownManager> tntCooldowns = new HashMap<>();
    private final int tntCooldownTime = 10;

    @EventHandler
    public void onBlockPlace(BlockPlaceEvent event) {
        Player player = event.getPlayer();
        ItemStack itemInMainHand = player.getInventory().getItemInMainHand();
        ItemMeta meta = itemInMainHand.getItemMeta();
        Location location = event.getBlock().getLocation();

        if (isInstaBoomTNT(meta)) {
            event.setCancelled(true);

            CooldownManager cooldown = tntCooldowns.get(player);
            if (cooldown == null) {
                cooldown = new CooldownManager();
                tntCooldowns.put(player, cooldown);
                cooldown = tntCooldowns.get(player);
            }

            if (!cooldown.isOnCooldown()) {
                triggerInstaBoom(player, location);
                triggerInstaBoomNONPLAYER(location);
                cooldown.setCooldown(tntCooldownTime);
                getServer().getScheduler().runTaskLater(lifestealSmp, () -> event.getPlayer().setCooldown(itemInMainHand.getType(), tntCooldownTime * 20), 1);
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
        return meta != null && meta.hasDisplayName() && meta.toString().contains("InstaBoom TNT");
    }

    private void triggerInstaBoom(Player player, Location location) {
        World world = location.getWorld();
        if (world != null) {
            world.spawnParticle(Particle.EXPLOSION, location, 10);
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

    //TODO:This works but the entity never stops flying
    public void triggerInstaBoomNONPLAYER(Location location) {
        World world = location.getWorld();
        if (world != null) {

            for (Entity onlineEntity : world.getEntities()) {

                //world.getNearbyEntities(location, 3);

                List<Entity> nearbyEntitys = (List<Entity>) world.getNearbyEntities(location, 3, 3, 3);
                for (Entity nearbyEntity : nearbyEntitys) {

                    if (!(nearbyEntity instanceof Player)) {
                        Vector direction = nearbyEntity.getLocation().toVector().subtract(location.toVector()).normalize();
                        Vector velocity = direction.multiply(5);
                        if (velocity.getY() > 1.0) {
                            velocity.setY(1.0);
                        }
                        nearbyEntity.setVelocity(velocity);
                    }


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
