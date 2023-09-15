package newamazingpvp.lifestealsmp.listener;

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
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.HashMap;
import java.util.UUID;

public class TntBow implements Listener {
    private HashMap<UUID, ItemStack> playerHeldItems = new HashMap<>();

    @EventHandler
    public void onProjectileLaunch(ProjectileLaunchEvent event) {
        if (event.getEntityType() == EntityType.ARROW && event.getEntity().getShooter() instanceof Player) {
            Player shooter = (Player) event.getEntity().getShooter();
            ItemStack mainHandItem = shooter.getInventory().getItemInMainHand();

            if (isBow(mainHandItem)) {
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
                Location arrowLocation = arrow.getLocation();
                spawnIgnitedTNT(arrowLocation);
                ItemStack item = playerHeldItems.get(shooter.getUniqueId());
                shooter.setCooldown(item.getType(), 20*15);
                playerHeldItems.remove(shooter.getUniqueId());

            }
        }
    }

    public void spawnIgnitedTNT(Location location) {
        Block block = location.getBlock();
        block.setType(Material.TNT);

        TNTPrimed tnt = (TNTPrimed) location.getWorld().spawnEntity(location, EntityType.PRIMED_TNT);

        tnt.setFuseTicks(40);
    }

    private boolean isBow(ItemStack item) {
        ItemMeta meta = item.getItemMeta();
        return item.getType() == Material.BOW && meta.getLore().toString().contains("TNT Shooter!");
    }
}
