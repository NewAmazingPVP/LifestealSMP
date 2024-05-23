package newamazingpvp.lifestealsmp.MinecraftBINGO;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;
import java.util.List;

public class BingoCardListener implements Listener {

    public static ItemStack BingoCard(){
        ItemStack ITEM = new ItemStack(Material.PAINTING);
        ItemMeta meta = ITEM.getItemMeta();
        meta.addEnchant(Enchantment.DURABILITY, 1, false);
        meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        meta.setDisplayName(ChatColor.GOLD + "" + ChatColor.BOLD + "Bingo Card");
        meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
        List<String> LORE = new ArrayList<>();
        LORE.add(ChatColor.YELLOW + "" + ChatColor.BOLD + "RIGHT CLICK:");
        LORE.add(ChatColor.LIGHT_PURPLE + "Open Bingo Card");
        meta.setLore(LORE);
        ITEM.setItemMeta(meta);
        return ITEM;
    }

    @EventHandler
    public void playerOpenBINOCard(PlayerInteractEvent e) {
        Player player = e.getPlayer();
        ItemMeta meta = e.getItem().getItemMeta();

        if ((e.getAction() == Action.RIGHT_CLICK_AIR || e.getAction() == Action.RIGHT_CLICK_BLOCK) &&
                e.hasItem() && e.getItem().getType() == Material.PAINTING) {

            if (meta.getLore() == null){
                return;
            }

            if (meta.getLore().toString().toLowerCase().contains("Open Bingo Card")){

                e.setCancelled(true);

                player.playSound(player.getLocation(), Sound.BLOCK_NOTE_BLOCK_PLING, 1.0f, 1.0f);

                Inventory alter = Bukkit.createInventory(player, 54, ChatColor.GOLD + "" + ChatColor.BOLD + "Bingo Card");



            }
        }
    }
}
