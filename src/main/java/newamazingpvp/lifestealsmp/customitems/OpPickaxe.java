package newamazingpvp.lifestealsmp.customitems;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.scheduler.BukkitRunnable;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;

import static newamazingpvp.lifestealsmp.LifestealSMP.lifestealSmp;
import static newamazingpvp.lifestealsmp.utility.DiscordBot.intializeBot;
import static newamazingpvp.lifestealsmp.utility.DiscordBot.webHookClient;

public class OpPickaxe implements Listener {
    private final ArrayList<Material> blackList = new ArrayList<>(List.of(
            Material.BEDROCK,
            Material.END_PORTAL_FRAME,
            Material.END_PORTAL,
            Material.SHULKER_BOX,
            Material.CHEST,
            Material.ENDER_CHEST,
            Material.BARREL,
            Material.CHEST_MINECART,
            Material.DISPENSER,
            Material.DROPPER,
            Material.HOPPER,
            Material.ITEM_FRAME,
            Material.FURNACE,
            Material.BLAST_FURNACE,
            Material.SMOKER,
            Material.BREWING_STAND,
            Material.LECTERN,
            Material.JUKEBOX,
            Material.COMPOSTER,
            Material.BEEHIVE,
            Material.BEE_NEST
    ));

    @EventHandler
    public void onBlockBreak(BlockBreakEvent event) {
        Player player = event.getPlayer();
        ItemStack item = player.getInventory().getItemInMainHand();

        if (item.getType() == Material.NETHERITE_PICKAXE) {
            if (hasLore(item)) {
                Block block = event.getBlock();
                if (player.isSneaking()) return;
                breakBlocksAround(block, item);
                item.setDurability((short) (item.getDurability() + 1));
                event.setCancelled(true);
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

    private void breakBlocksAround(Block centerBlock, ItemStack item) {
        new BukkitRunnable() {
            @Override
            public void run() {
                // Break blocks asynchronously
                for (int x = -1; x <= 1; x++) {
                    for (int y = -1; y <= 1; y++) {
                        for (int z = -1; z <= 1; z++) {
                            Block targetBlock = centerBlock.getRelative(x, y, z);
                            if (!blackList.contains(targetBlock.getType())
                                    && targetBlock.getType().toString().equalsIgnoreCase(centerBlock.getType().toString()) &&
                                    !(targetBlock.getLocation().getX() == centerBlock.getLocation().getX() && targetBlock.getLocation().getY() == centerBlock.getLocation().getY()
                                            && targetBlock.getLocation().getZ() == centerBlock.getLocation().getZ())) {
                                Collection<ItemStack> drops = targetBlock.getDrops(item);
                                //since all blocks are same types make more efficient by storing total drops and give alltogether at end instead of in loop
                                // make hasmap<itemstack, quantity> and then at end make Itemstack e = new ItemStack(Hashmap.getKey(), Hashmap.getValue(); then drop
                                for (ItemStack drop : drops) {
                                    Bukkit.getScheduler().runTask(lifestealSmp, () -> targetBlock.getWorld().dropItem(targetBlock.getLocation(), drop));
                                }

                                Bukkit.getScheduler().runTask(lifestealSmp, () -> targetBlock.setType(Material.AIR));

                            }
                        }
                    }
                }
                Collection<ItemStack> centerDrops = centerBlock.getDrops(item);

                for (ItemStack drop : centerDrops) {
                    Bukkit.getScheduler().runTask(lifestealSmp, () -> centerBlock.getWorld().dropItem(centerBlock.getLocation(), drop));
                }

                Bukkit.getScheduler().runTask(lifestealSmp, () -> centerBlock.setType(Material.AIR));

            }
        }.runTaskAsynchronously(lifestealSmp);
    }

}
