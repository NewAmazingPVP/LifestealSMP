package newamazingpvp.lifestealsmp.MinecraftBINGO.BingoGUI;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.ItemStack;

import static newamazingpvp.lifestealsmp.MinecraftBINGO.BingoGUI.BingoCardGUI.OpenTheBingoCardGUI;

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
                OpenTheBingoCardGUI(player);
            }


        }




    }





}
