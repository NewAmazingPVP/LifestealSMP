package newamazingpvp.lifestealsmp.blacklistener;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.*;

public class DisableEnderDragonEgg implements Listener {

    private final String message = ChatColor.RED + "You can't take the egg off your inventory";

    @EventHandler
    public void onInventoryClick(InventoryClickEvent event) {
        if (event.getAction() == InventoryAction.MOVE_TO_OTHER_INVENTORY) {
            if (event.getCurrentItem() != null &&
                    event.getCurrentItem().getType() == Material.DRAGON_EGG) {
                if (event.getClickedInventory().getType() != InventoryType.PLAYER) {
                    event.setCancelled(true);
                    event.getWhoClicked().sendMessage(message);
                }
                //event.getWhoClicked().closeInventory();
            }
        }
    }

    @EventHandler
    public void onInventoryDrag(InventoryDragEvent event) {
        if (event.getOldCursor().getType() == Material.DRAGON_EGG) {
            event.setCancelled(true);
            event.getWhoClicked().sendMessage(message);
            //event.getWhoClicked().closeInventory();
        }
    }

    @EventHandler
    public void onInventoryDrag(InventoryMoveItemEvent event) {
        if (event.getItem().getType().equals(Material.DRAGON_EGG) && !event.getDestination().getType().equals(InventoryType.PLAYER)) {
            event.setCancelled(true);
        }
    }

    @EventHandler
    public void onInventoryDrag(InventoryPickupItemEvent event) {
        if (event.getItem().getItemStack().getType().equals(Material.DRAGON_EGG) && !event.getInventory().getType().equals(InventoryType.PLAYER)) {
            event.setCancelled(true);
        }
    }

}
