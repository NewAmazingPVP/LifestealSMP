package newamazingpvp.lifestealsmp.customitems;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.PluginManager;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class voidBoots implements Listener {


    @EventHandler
    public void playerMove(PlayerMoveEvent e) {

        Player player = e.getPlayer();
        Block block = player.getLocation().getBlock();

        for (ItemStack item : player.getInventory().getArmorContents()) {
            if (item != null && item.getType() == Material.LEATHER_BOOTS && item.getItemMeta().hasDisplayName() && item.getItemMeta().getDisplayName().equals(ChatColor.BLACK + "" + ChatColor.BOLD + "Void Boots")) {


                if (!block.getType().equals(Material.AIR)) {
                    // Change the block texture to diamond
                    block.setBlockData(block.getBlockData()); // This line might need adjustment based on actual implementation

                    // Schedule the block to revert back after a few seconds
                    Bukkit.getScheduler().runTaskLater(this, () -> {
                        // Restore the original block type
                        block.setType(Material.GRASS); // Replace GRASS with the original material
                    }, 20L * 10); // 10 seconds delay
                }
            }
        }
    }
}

