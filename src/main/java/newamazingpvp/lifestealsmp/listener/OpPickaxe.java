package com.example.pickaxeplugin;

import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.java.JavaPlugin;

public class OpPickaxe implements Listener {

    @EventHandler
    public void onBlockBreak(BlockBreakEvent event) {
        Player player = event.getPlayer();
        ItemStack item = player.getInventory().getItemInMainHand();

        if (item != null && item.getType() == Material.NETHERITE_PICKAXE) {
            if (hasLore(item, "Mine to break 3x3!")) {
                Block block = event.getBlock();
                breakBlocksAround(player, block);
            }
        }
    }

    private boolean hasLore(ItemStack item, String loreToCheck) {
        if (item.hasItemMeta() && item.getItemMeta().hasLore()) {
            for (String lore : item.getItemMeta().getLore()) {
                if (lore.contains(loreToCheck)) {
                    return true;
                }
            }
        }
        return false;
    }

    private void breakBlocksAround(Player player, Block centerBlock) {
        for (int x = -1; x <= 1; x++) {
            for (int y = -1; y <= 1; y++) {
                for (int z = -1; z <= 1; z++) {
                    Block targetBlock = centerBlock.getRelative(x, y, z);
                    if (targetBlock.getType() != Material.BEDROCK) {
                        targetBlock.breakNaturally();
                    }
                }
            }
        }
    }
}
