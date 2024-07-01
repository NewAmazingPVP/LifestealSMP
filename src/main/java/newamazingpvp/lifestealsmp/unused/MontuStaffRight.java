package newamazingpvp.lifestealsmp.unused;

import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.util.Vector;

public class MontuStaffRight implements Listener {

    @EventHandler
    public void onPlayerInteract(PlayerInteractEvent event) {
        // Check if the player is sneaking (crouching)
        Player player = event.getPlayer();
        if (event.getPlayer().isSneaking()) {
            return;
        }

        // Check if the player is right-clicking
        if (event.getAction() == Action.RIGHT_CLICK_AIR || event.getAction() == Action.RIGHT_CLICK_BLOCK) {
            // Get the item in the player's hand
            ItemStack item = event.getItem();

            // Check if the item is a stick and is named "1111111111111111"
            if (item != null && item.getType() == Material.STICK && item.hasItemMeta() && item.getItemMeta().hasDisplayName() && item.getItemMeta().getDisplayName().equals(ChatColor.GOLD + "" + ChatColor.BOLD + "Montu's Staff")) {
                // Send a message to the player

                player.playSound(player.getLocation(), Sound.ENTITY_ENDERMAN_TELEPORT, 999999999999.0f, 2.0f);

                //player.getWorld().spawnParticle(Particle.REDSTONE , player.getLocation(), 10, 0.6, 0.6, 0.6, new Particle.DustOptions(Color.BLACK, 2));
                //player.getWorld().spawnParticle(Particle.REDSTONE, player.getLocation(), 10, 0.6, 0.6, 0.6, new Particle.DustOptions(Color.BLACK, 2));
                //player.getWorld().spawnParticle(Particle.REDSTONE, player.getLocation(), 10, 0.6, 0.6, 0.6, new Particle.DustOptions(Color.BLACK, 2));
                //player.getWorld().spawnParticle(Particle.REDSTONE, player.getLocation(), 10, 0.6, 0.6, 0.6, new Particle.DustOptions(Color.PURPLE, 1));
                //player.getWorld().spawnParticle(Particle.REDSTONE, player.getLocation(), 10, 0.6, 0.6, 0.6, new Particle.DustOptions(Color.PURPLE, 1));
                //player.getWorld().spawnParticle(Particle.REDSTONE, player.getLocation(), 10, 0.6, 0.6, 0.6, new Particle.DustOptions(Color.PURPLE, 1));

                Location playerLocation = player.getLocation();
                Vector direction = playerLocation.getDirection().normalize().multiply(5); // Multiply by 5 to teleport 5 blocks
                Location destination = playerLocation.add(direction);

                // Check if the destination is a solid block
                if (destination.getBlock().getType().isSolid()) {
                    // Teleport to the nearest block that is not solid
                    destination.setY(destination.getY() + 1);
                    while (destination.getBlock().getType().isSolid()) {
                        destination.setY(destination.getY() + 1);


                    }
                }
                player.teleport(destination);
            }
        }
    }
}
