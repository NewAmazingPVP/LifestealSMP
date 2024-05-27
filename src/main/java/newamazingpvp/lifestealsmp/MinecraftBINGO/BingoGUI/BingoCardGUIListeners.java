package newamazingpvp.lifestealsmp.MinecraftBINGO.BingoGUI;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.ItemStack;

import static newamazingpvp.lifestealsmp.MinecraftBINGO.BingoGUI.BingoCardGUI.OpenTheBingoCardGUI;
import static newamazingpvp.lifestealsmp.MinecraftBINGO.BingoGUI.BingoCardGUIs.*;
import static newamazingpvp.lifestealsmp.MinecraftBINGO.BingoGUI.BingoGUIItems.BingoPickaxeGUI;

public class BingoCardGUIListeners implements Listener {


    @EventHandler
    public void onMenuClick(InventoryClickEvent event) {

        ItemStack itemInHand = event.getCurrentItem();
        Player player = (Player) event.getWhoClicked();

        if (event.getView().getTitle().equalsIgnoreCase(ChatColor.GOLD + "" + ChatColor.BOLD + "Bingo Card") || event.getView().getTitle().equalsIgnoreCase(ChatColor.GOLD + "" + ChatColor.BOLD + "Bingo") || event.getView().getTitle().equalsIgnoreCase(ChatColor.GOLD + "" + ChatColor.BOLD + "Bingo Pickaxe Recipe")) {


            if (event.getCurrentItem() == null) {
                return;
            }


            if (itemInHand != null && itemInHand.getType() == Material.BARRIER && itemInHand.hasItemMeta() && itemInHand.getItemMeta().hasDisplayName() && itemInHand.getItemMeta().getDisplayName().equals(ChatColor.RED + "" + ChatColor.BOLD + "Close")) {
                player.playSound(player.getLocation(), Sound.BLOCK_STONE_BUTTON_CLICK_OFF, 2.0f, 2.0f);
                player.closeInventory();
            }

            if (itemInHand != null && itemInHand.getType() == Material.ARROW && itemInHand.hasItemMeta() && itemInHand.getItemMeta().hasDisplayName() && itemInHand.getItemMeta().getDisplayName().equals(ChatColor.GREEN + "" + ChatColor.BOLD + "Go Back")) {
                player.playSound(player.getLocation(), Sound.BLOCK_STONE_BUTTON_CLICK_OFF, 2.0f, 2.0f);
                BingoMainMenu(player);
            }


            event.setCancelled(true);


        }


        if (event.getView().getTitle().equalsIgnoreCase(ChatColor.GOLD + "" + ChatColor.BOLD + "Bingo")) {


            if (event.getCurrentItem() == null) {
                return;
            }

            if (itemInHand != null && itemInHand.getType() == Material.PAINTING && itemInHand.hasItemMeta() && itemInHand.getItemMeta().hasDisplayName() && itemInHand.getItemMeta().getDisplayName().equals(ChatColor.LIGHT_PURPLE + "" + ChatColor.BOLD + "Open Bingo Card")) {
                player.playSound(player.getLocation(), Sound.BLOCK_STONE_BUTTON_CLICK_OFF, 2.0f, 2.0f);
                OpenTheBingoCardGUI(player);

            }

            if (itemInHand != null && itemInHand.getType() == Material.IRON_PICKAXE && itemInHand.hasItemMeta() && itemInHand.getItemMeta().hasDisplayName() && itemInHand.getItemMeta().getDisplayName().equals(ChatColor.GOLD + "" + ChatColor.BOLD + "Bingo Pickaxe")) {
                player.playSound(player.getLocation(), Sound.BLOCK_STONE_BUTTON_CLICK_OFF, 2.0f, 2.0f);
                BingoPickaxeRecipeGUI(player);
            }
        }





    }





}
