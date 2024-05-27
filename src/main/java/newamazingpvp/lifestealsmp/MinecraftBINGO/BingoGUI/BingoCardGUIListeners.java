package newamazingpvp.lifestealsmp.MinecraftBINGO.BingoGUI;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

import static newamazingpvp.lifestealsmp.MinecraftBINGO.BingoGUI.BingoCardGUI.OpenTheBingoCardGUI;
import static newamazingpvp.lifestealsmp.MinecraftBINGO.BingoGUI.BingoGUIItems.BingoPickaxeGUI;

public class BingoCardGUIListeners implements Listener {


    @EventHandler
    public void onMenuClick(InventoryClickEvent event) {

        ItemStack itemInHand = event.getCurrentItem();
        Player player = (Player) event.getWhoClicked();

        if (event.getView().getTitle().equalsIgnoreCase(ChatColor.GOLD + "" + ChatColor.BOLD + "Bingo Card") || event.getView().getTitle().equalsIgnoreCase(ChatColor.GOLD + "" + ChatColor.BOLD + "Bingo")) {


            if (event.getCurrentItem() == null) {
                return;
            }

            event.setCancelled(true);


        }


        if (event.getView().getTitle().equalsIgnoreCase(ChatColor.GOLD + "" + ChatColor.BOLD + "Bingo")) {


            if (event.getCurrentItem() == null) {
                return;
            }

            if (itemInHand != null && itemInHand.getType() == Material.PAINTING && itemInHand.hasItemMeta() && itemInHand.getItemMeta().hasDisplayName() && itemInHand.getItemMeta().getDisplayName().equals(ChatColor.LIGHT_PURPLE + "" + ChatColor.BOLD + "Open Bingo Card")) {
                player.playSound(player.getLocation(), Sound.BLOCK_NOTE_BLOCK_PLING, 1.0f, 2.0f);
                OpenTheBingoCardGUI(player);

            }

            if (itemInHand != null && itemInHand.getType() == Material.IRON_PICKAXE && itemInHand.hasItemMeta() && itemInHand.getItemMeta().hasDisplayName() && itemInHand.getItemMeta().getDisplayName().equals(ChatColor.RED + "" + ChatColor.BOLD + "Bingo Pickaxe")) {
                player.playSound(player.getLocation(), Sound.BLOCK_NOTE_BLOCK_PLING, 1.0f, 2.0f);
                player.sendMessage(ChatColor.GOLD + "" + ChatColor.BOLD + "+1 ");
                player.getInventory().addItem(BingoPickaxeGUI());
            }


        }



    }





}
