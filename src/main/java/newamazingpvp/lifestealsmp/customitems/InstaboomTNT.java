package newamazingpvp.lifestealsmp.customitems;

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

import java.util.List;

public class InstaboomTNT implements Listener {


    @EventHandler
    public void playerPlaceBlock(BlockPlaceEvent e) {

        Player player = e.getPlayer();
        ItemStack item = e.getItemInHand();
        ItemMeta meta = item.getItemMeta();
        Location location = e.getBlock().getLocation();

        if (meta != null && meta.hasDisplayName() && meta.getDisplayName().equals(ChatColor.GOLD + "" + ChatColor.BOLD + "InstaBoom TNT")) {
            location.getWorld().spawnParticle(Particle.EXPLOSION_LARGE, location, 10);
            e.setCancelled(true);
            for (Player onlineplayer : Bukkit.getOnlinePlayers()) {
                onlineplayer.playSound(location, Sound.ENTITY_GENERIC_EXPLODE, 5.0f, 1.0f);
                onlineplayer.playSound(location, Sound.ENTITY_ELDER_GUARDIAN_CURSE, 5.0f, 2.0f);
                List<Player> nearbyPlayers = (List<Player>) location.getWorld().getNearbyPlayers(location, 3);
                for (Player playernear : nearbyPlayers) {
                    playernear.addPotionEffect(new PotionEffect(PotionEffectType.DARKNESS, 20, 1));
                    Vector direction = player.getLocation().toVector().subtract(location.toVector()).normalize();
                    player.setVelocity(direction.multiply(10));

                }
            }
            if (item.getAmount() > 1) {
                item.setAmount(item.getAmount() - 1);
                player.getInventory().setItemInMainHand(item);
            } else {
                player.getInventory().setItemInMainHand(null);
            }
        }
    }
}