package newamazingpvp.lifestealsmp.MinecraftBINGO.BingoGUI;

import org.bukkit.ChatColor;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.ItemStack;

public class BingoInvintoryProt implements Listener {

    //TODO: ig this is not needed so its disabled

    @EventHandler
    public void onMenuClick(InventoryClickEvent event) {

        if (event.getCurrentItem() == null) {
            return;
        }

        ItemStack clickedItem = event.getCurrentItem();



        if (event.getView().getTitle().equalsIgnoreCase(" ")) {
            event.getWhoClicked().getInventory().removeItem(clickedItem);
        }

        if (event.getView().getTitle().equalsIgnoreCase(ChatColor.DARK_RED + "" + ChatColor.BOLD + "No Challenge Generated!")) {
            event.getWhoClicked().getInventory().removeItem(clickedItem);
        }




            event.setCancelled(true);


    }
}
