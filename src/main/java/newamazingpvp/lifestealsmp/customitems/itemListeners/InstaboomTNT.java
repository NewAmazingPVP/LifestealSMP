package newamazingpvp.lifestealsmp.customitems.itemlisteners;

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
import org.jetbrains.annotations.NotNull;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static newamazingpvp.lifestealsmp.customitems.itemlisteners.FeatherSword.getString;

public class InstaboomTNT implements Listener {


    private final Map<Player, Long> tntCooldowns = new HashMap<>();
    private final double tntCooldownTime = 10000;

    @EventHandler
    public void playerPlaceBlock(BlockPlaceEvent e) {

        Player player = e.getPlayer();
        ItemStack item = player.getInventory().getItemInMainHand();
        ItemMeta meta = item.getItemMeta();
        Location location = e.getBlock().getLocation();



                if (meta != null && meta.hasDisplayName() && meta.getDisplayName().equals(ChatColor.GOLD + "" + ChatColor.BOLD + "InstaBoom TNT")) {
                    e.setCancelled(true);
                    if (isTeleportCooldownExpired(player)) {
                        setTeleportCooldown(player);
                        location.getWorld().spawnParticle(Particle.EXPLOSION_HUGE, location, 10);
                        for (Player onlineplayer : Bukkit.getOnlinePlayers()) {
                            onlineplayer.playSound(location, Sound.ENTITY_GENERIC_EXPLODE, 5.0f, 1.0f);
                            onlineplayer.playSound(location, Sound.ENTITY_ELDER_GUARDIAN_CURSE, 5.0f, 2.0f);
                            List<Player> nearbyPlayers = (List<Player>) location.getWorld().getNearbyPlayers(location, 3);
                            for (Player playernear : nearbyPlayers) {
                                playernear.addPotionEffect(new PotionEffect(PotionEffectType.DARKNESS, 20, 1));
                                Vector direction = playernear.getLocation().toVector().subtract(location.toVector()).normalize();
                                Vector velocity = direction.multiply(20);
                                double maxHeight = 1.0;
                                if (velocity.getY() > maxHeight) {
                                    velocity.setY(maxHeight);
                                }
                                playernear.setVelocity(velocity);

                            }
                        }
                        if (item.getAmount() > 1) {
                            item.setAmount(item.getAmount() - 1);
                            player.getInventory().setItemInMainHand(item);
                        } else {
                            player.getInventory().setItemInMainHand(null);
                        }
                }else{
                        player.sendMessage(ChatColor.RED + "You must wait " + cooldownRemainingTime(player) + " for the cooldown to finish before using instaboom tnt again.");
                    }

        }
    }

    private boolean isTeleportCooldownExpired(Player player) {
        if (tntCooldowns.containsKey(player)) {
            long lastTeleportTime = tntCooldowns.get(player);
            long currentTime = System.currentTimeMillis();
            return currentTime - lastTeleportTime >= tntCooldownTime;
        }
        return true;
    }


    private void setTeleportCooldown(Player player) {
        tntCooldowns.put(player, System.currentTimeMillis());
    }

    private String cooldownRemainingTime(Player player) {
        return getString(player, tntCooldowns, (long) tntCooldownTime);
    }



}
