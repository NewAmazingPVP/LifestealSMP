package newamazingpvp.lifestealsmp.listener;

import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.inventory.ItemStack;

public class OpPickaxe implements Listener {

    @EventHandler
    public void onBlockBreak(BlockBreakEvent event) {
        Player player = event.getPlayer();
        ItemStack item = player.getInventory().getItemInMainHand();

        if (item.getType() == Material.NETHERITE_PICKAXE) {
            if (hasLore(item)) {
                Block block = event.getBlock();
                if (player.isSneaking()) return;
                breakBlocksAround(block);
                item.setDurability((short) (item.getDurability() + 1));
            }
        }
    }

    private boolean hasLore(ItemStack item) {
        if (item.hasItemMeta() && item.getItemMeta().hasLore()) {
            for (String lore : item.getItemMeta().getLore()) {
                if (lore.contains("Mine to break 3x3!")) {
                    return true;
                }
            }
        }
        return false;
    }

    private void breakBlocksAround(Block centerBlock) {
        for (int x = -1; x <= 1; x++) {
            for (int y = -1; y <= 1; y++) {
                for (int z = -1; z <= 1; z++) {
                    Block targetBlock = centerBlock.getRelative(x, y, z);
                    if ((targetBlock.getType() != Material.BEDROCK) && (targetBlock.getType() != Material.END_PORTAL_FRAME) && (targetBlock.getType() != Material.END_PORTAL)) {
                        targetBlock.breakNaturally();
                    }
                }
            }
        }
    }
}
