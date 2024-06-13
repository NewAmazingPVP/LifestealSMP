package newamazingpvp.lifestealsmp.customitems.itemlisteners;

import org.bukkit.GameMode;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.Arrays;
import java.util.HashSet;

public class TreeChopAxe implements Listener {
    public static HashSet<Material> validLogMaterials = new HashSet<>(Arrays.asList(
            Material.LEGACY_LOG, Material.LEGACY_LOG_2,
            Material.ACACIA_LOG, Material.BIRCH_LOG, Material.DARK_OAK_LOG, Material.JUNGLE_LOG,
            Material.OAK_LOG, Material.SPRUCE_LOG, Material.CRIMSON_STEM, Material.WARPED_STEM));

    @EventHandler
    public void onBlockBreak(BlockBreakEvent e) {
        Player player = e.getPlayer();
        ItemStack handStack = player.getInventory().getItemInMainHand();
        ItemMeta meta = handStack.getItemMeta();
        if (player.isSneaking()) return;
        if (meta == null || !meta.hasLore()) return;
        if (meta.getLore().toString().toLowerCase().contains("tree")) {
            Block block = e.getBlock();
            if (block.getType().toString().toLowerCase().contains("log") || block.getType().toString().toLowerCase().contains("stem"))
                cutDownTree(block.getLocation(), (player.getGameMode() == GameMode.CREATIVE) ? handStack.clone() : handStack);
            handStack.setDurability((short) (handStack.getDurability() + 1));
        }
    }


    private void cutDownTree(Location location, ItemStack handStack) {
        //validLogMaterials.contains(location.getBlock().getType()
        if (location.getBlock().getType().toString().toLowerCase().contains("log") || location.getBlock().getType().toString().toLowerCase().contains("stem")) {
            location.getBlock().breakNaturally(handStack);
            for (int x = -1; x <= 1; x++) {
                for (int y = -1; y <= 1; y++) {
                    for (int z = -1; z <= 1; z++) {
                        Location neighborLocation = location.clone().add(x, y, z);
                        if (neighborLocation.getBlock().getType() != Material.AIR) {
                            cutDownTree(neighborLocation, handStack);
                        }
                    }
                }
            }
        }
    }
}
