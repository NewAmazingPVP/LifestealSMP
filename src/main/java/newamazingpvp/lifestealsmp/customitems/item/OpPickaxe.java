package newamazingpvp.lifestealsmp.customitems.item;

import newamazingpvp.lifestealsmp.utility.CooldownManager;
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

import java.util.*;

import static newamazingpvp.lifestealsmp.LifestealSMP.lifestealSmp;
import static org.bukkit.Bukkit.getServer;

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

    private HashMap<UUID, CooldownManager> playerCooldowns = new HashMap<>();

    @EventHandler
    public void onBlockBreak(BlockBreakEvent event) {
        Player player = event.getPlayer();
        ItemStack item = player.getInventory().getItemInMainHand();
        if (player.isSneaking()) return;
        if(playerCooldowns.get(player.getUniqueId()) == null){
            playerCooldowns.put(player.getUniqueId(), new CooldownManager());
        }
        if (item.getType() == Material.NETHERITE_PICKAXE) {
            if (hasLore(item)) {
                if(playerCooldowns.get(player.getUniqueId()).isOnCooldown()){
                    player.sendMessage(ChatColor.RED + "You must wait " + playerCooldowns.get(player.getUniqueId()).getRemainingSeconds() + " seconds for the cooldown to finish before using the op pickaxe ability again.");
                    return;
                }
                Block block = event.getBlock();
                if (blackList.contains(block.getType()) || block.getType().toString().toLowerCase().contains("shulker_box"))
                    return;
                breakBlocksAround(block, item);
                item.setDurability((short) (item.getDurability() + 1));
                event.setCancelled(true);
                CooldownManager cooldown = playerCooldowns.get(player.getUniqueId());
                cooldown.setCooldown(3.0);
                getServer().getScheduler().runTaskLater(lifestealSmp, () -> event.getPlayer().setCooldown(item.getType(), 60), 1);
                playerCooldowns.put(player.getUniqueId(), cooldown);
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
                            if (!(blackList.contains(targetBlock.getType()) || targetBlock.getType().toString().toLowerCase().contains("shulker_box"))
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
                if (!(blackList.contains(centerBlock.getType()) || centerBlock.getType().toString().toLowerCase().contains("shulker_box"))) {
                    Collection<ItemStack> centerDrops = centerBlock.getDrops(item);

                    for (ItemStack drop : centerDrops) {
                        Bukkit.getScheduler().runTask(lifestealSmp, () -> centerBlock.getWorld().dropItem(centerBlock.getLocation(), drop));
                    }

                    Bukkit.getScheduler().runTask(lifestealSmp, () -> centerBlock.setType(Material.AIR));
                }

            }
        }.runTaskAsynchronously(lifestealSmp);
    }

}
