package newamazingpvp.lifestealsmp.blacklistener;

import org.bukkit.ChatColor;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryType;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.InventoryView;
import org.bukkit.inventory.ItemStack;

public class AnvilMenuListener implements Listener {



    @EventHandler
    public void onInventoryClick(InventoryClickEvent event) {
        Player player = (Player) event.getWhoClicked();
        InventoryType inv = event.getInventory().getType();
        InventoryType clickInv = null;
        if(event.getClickedInventory() != null){
            clickInv = event.getClickedInventory().getType();
        }
        InventoryView view = event.getView();
        if (view.getType() == InventoryType.ANVIL || inv == InventoryType.ANVIL || clickInv == InventoryType.ANVIL) {
            ItemStack clickedItem = event.getCurrentItem();
            if (clickedItem != null && clickedItem.hasItemMeta() && clickedItem.getItemMeta().hasDisplayName()) {
                String itemName = clickedItem.getItemMeta().getDisplayName();
                if (itemName.toLowerCase().contains("extra heart")) {
                    event.setCancelled(true);
                }
                if (itemName.toLowerCase().contains("severed mob heart")) {
                    event.setCancelled(true);
                }
                if (itemName.contains("rupted Mob Soul")) {
                    event.setCancelled(true);
                }
                if (itemName.equals(ChatColor.GOLD + "" + ChatColor.BOLD + "Montu's Staff")) {
                    event.setCancelled(true);
                    player.sendMessage(ChatColor.RED + "This item can't be put in an anvil!");
                    player.playSound(player.getLocation(), Sound.ENTITY_ENDERMAN_TELEPORT, 1.0f, 2.0f);
                }
                if (itemName.equals(ChatColor.LIGHT_PURPLE + "" + ChatColor.BOLD + "Montu Helmet")) {
                    event.setCancelled(true);
                    player.sendMessage(ChatColor.RED + "This item can't be put in an anvil!");
                    player.playSound(player.getLocation(), Sound.ENTITY_ENDERMAN_TELEPORT, 1.0f, 2.0f);
                }
                if (itemName.equals(ChatColor.LIGHT_PURPLE + "" + ChatColor.BOLD + "Montu Chestplate")) {
                    event.setCancelled(true);
                    player.sendMessage(ChatColor.RED + "This item can't be put in an anvil!");
                    player.playSound(player.getLocation(), Sound.ENTITY_ENDERMAN_TELEPORT, 1.0f, 2.0f);
                }
                if (itemName.equals(ChatColor.LIGHT_PURPLE + "" + ChatColor.BOLD + "Montu Leggings")) {
                    event.setCancelled(true);
                    player.sendMessage(ChatColor.RED + "This item can't be put in an anvil!");
                    player.playSound(player.getLocation(), Sound.ENTITY_ENDERMAN_TELEPORT, 1.0f, 2.0f);
                }
                if (itemName.equals(ChatColor.LIGHT_PURPLE + "" + ChatColor.BOLD + "Montu Boots")) {
                    event.setCancelled(true);
                    player.sendMessage(ChatColor.RED + "This item can't be put in an anvil!");
                    player.playSound(player.getLocation(), Sound.ENTITY_ENDERMAN_TELEPORT, 1.0f, 2.0f);
                }
                if(itemName.toLowerCase().contains("rune")){
                    event.setCancelled(true);
                    player.sendMessage(ChatColor.RED + "This item can't be put in an anvil!");
                    player.playSound(player.getLocation(), Sound.ENTITY_ENDERMAN_TELEPORT, 1.0f, 2.0f);
                }
            }
        }
    }
}
