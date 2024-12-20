package newamazingpvp.lifestealsmp.game;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.EnchantmentStorageMeta;
import org.bukkit.scheduler.BukkitRunnable;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import static newamazingpvp.lifestealsmp.LifestealSMP.lifestealSmp;
import static newamazingpvp.lifestealsmp.utility.Utils.addItemOrDrop;

public class Disenchant implements Listener {
    private final Map<UUID, ItemStack> pendingTransfers = new HashMap<>();
    private final int TRANSFER_TIMEOUT = 200;


    @EventHandler
    public void onInventoryClick(InventoryClickEvent event) {
        if (event.getWhoClicked() instanceof Player player) {
            if (pendingTransfers.containsKey(player.getUniqueId())) {
                pendingTransfers.remove(player.getUniqueId());
                player.sendMessage(ChatColor.RED + "Enchantment transfer cancelled due to item movement.");
            }
        }
    }

    @EventHandler
    public void onAnvilInteract(PlayerInteractEvent event) {
        if (event.getClickedBlock() != null && (event.getClickedBlock().getType() == Material.ANVIL || event.getClickedBlock().getType() == Material.DAMAGED_ANVIL
                || event.getClickedBlock().getType() == Material.CHIPPED_ANVIL || event.getClickedBlock().getType() == Material.LEGACY_ANVIL)) {
            Player player = event.getPlayer();
            ItemStack itemInHand = player.getInventory().getItemInMainHand();

            if (itemInHand == null) return;
            if (event.getAction() != Action.LEFT_CLICK_BLOCK) return;

            if (itemInHand.getItemMeta().hasEnchants()) {
                pendingTransfers.put(player.getUniqueId(), itemInHand);
                player.sendMessage(ChatColor.GREEN + "Left-click an empty book onto anvil within 10 seconds to transfer enchantments from the item.");

                new BukkitRunnable() {
                    @Override
                    public void run() {
                        pendingTransfers.remove(player.getUniqueId());
                    }
                }.runTaskLater(lifestealSmp, TRANSFER_TIMEOUT);
            } else {
                UUID playerId = player.getUniqueId();

                if (pendingTransfers.containsKey(playerId) && itemInHand.getType() == Material.BOOK) {
                    ItemStack enchantedItem = pendingTransfers.remove(playerId);
                    Map<Enchantment, Integer> enchantments = enchantedItem.getEnchantments();
                    ItemStack enchantedBook = new ItemStack(Material.ENCHANTED_BOOK);
                    EnchantmentStorageMeta bookMeta = (EnchantmentStorageMeta) enchantedBook.getItemMeta();

                    for (Map.Entry<Enchantment, Integer> entry : enchantments.entrySet()) {
                        bookMeta.addStoredEnchant(entry.getKey(), entry.getValue(), true);
                        enchantedItem.removeEnchantment(entry.getKey());
                    }
                    enchantedBook.setItemMeta(bookMeta);
                    //player.getInventory().removeItem(itemInHand);
                    if (itemInHand.getAmount() > 1) {
                        itemInHand.setAmount(itemInHand.getAmount() - 1);
                    } else {
                        player.getInventory().setItemInMainHand(null);
                    }
                    addItemOrDrop(player, enchantedBook, ChatColor.LIGHT_PURPLE + "Inventory was full and book was dropped");
                    player.sendMessage(ChatColor.AQUA + "Enchantments transferred to a book!");
                }
            }
        }
    }
}
