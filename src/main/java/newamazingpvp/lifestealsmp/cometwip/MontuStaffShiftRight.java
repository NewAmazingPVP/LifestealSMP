package newamazingpvp.lifestealsmp.cometwip;

import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.FallingBlock;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;

import java.util.Random;

public class MontuStaffShiftRight implements Listener {

    @EventHandler
    public void onPlayerInteract(PlayerInteractEvent event) {
        if (event.getAction().isRightClick()) {
            Player player = event.getPlayer();
            if (player.isSneaking()) {
                ItemStack itemInHand = player.getInventory().getItemInMainHand();
                if (itemInHand != null && itemInHand.getType() == Material.STICK && itemInHand.hasItemMeta() && itemInHand.getItemMeta().hasDisplayName() && itemInHand.getItemMeta().getDisplayName().equals(ChatColor.GOLD + "" + ChatColor.BOLD + "Montu's Staff")) {

                    player.playSound(player.getLocation(), Sound.ENTITY_GENERIC_EXPLODE, 1.0f, 0.0f);
                    player.playSound(player.getLocation(), Sound.ENTITY_GENERIC_EXPLODE, 1.0f, 1.0f);
                    Random random = new Random();
                    Location playerLocation = player.getLocation();

                    for (int i = 0; i < 10; i++) {
                        // Create a new FallingBlock entity
                        FallingBlock fallingBlock = player.getWorld().spawnFallingBlock(playerLocation, Material.BLACK_CONCRETE, (byte) 0);

                        // Set the falling block to disappear when it hits the ground
                        fallingBlock.setDropItem(false);

                        // Move the falling block to a random location around the player
                        int x = random.nextInt(2) - 5;
                        int y = random.nextInt(2) - 5;
                        int z = random.nextInt(2) - 5;
                        fallingBlock.teleport(playerLocation.add(x, y, z));

                        // Create another FallingBlock entity with the same properties
                        fallingBlock = player.getWorld().spawnFallingBlock(playerLocation, Material.PURPLE_CONCRETE, (byte) 0);
                        fallingBlock.setDropItem(false);
                        fallingBlock.teleport(playerLocation.add(x, y, z));
                    }
                }
            }
        }
    }
}
