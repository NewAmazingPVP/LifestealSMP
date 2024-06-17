package newamazingpvp.lifestealsmp.listener;

import newamazingpvp.lifestealsmp.utility.TradeManager;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.*;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

import static newamazingpvp.lifestealsmp.utility.TradeManager.*;

public class TradeListener implements Listener {

    @EventHandler(priority = EventPriority.HIGHEST)
    public void onInventoryClick(InventoryClickEvent event) {
        Inventory inventory = event.getInventory();
        Player player = (Player) event.getWhoClicked();

        if (TradeManager.isTradeInventory(inventory)) {
            int slot = event.getSlot();
            Inventory clickedInventory = event.getClickedInventory();

            // Prevent any form of item movement for accept buttons
            if (slot == 45 || slot == 53) {
                event.setCancelled(true);
            }
            if (event.isShiftClick()) {
                event.setCancelled(true);
                return;
            }


            // Prevent shift-clicking and specific item actions across columns
         /*   if (event.isShiftClick() ||
                    event.getAction() == InventoryAction.PLACE_ALL ||
                    event.getAction() == InventoryAction.PLACE_ONE ||
                    event.getAction() == InventoryAction.PLACE_SOME ||
                    event.getAction() == InventoryAction.SWAP_WITH_CURSOR ||
                    event.getAction() == InventoryAction.COLLECT_TO_CURSOR ||
                    event.getAction() == InventoryAction.MOVE_TO_OTHER_INVENTORY) {

*/
                if (traders.containsKey(player)) {
                    if (!(lastFourColumns.contains(slot)) && clickedInventory != player.getInventory()) {
                        event.setCancelled(true);
                        return;
                    }
                } else if (traders.containsValue(player)) {
                    if (!(firstFourColumns.contains(slot)) && clickedInventory != player.getInventory()) {
                        event.setCancelled(true);
                        return;
                    }
                }


            //}

            // Handle accept button clicks
            if (event.getCurrentItem() != null) {
                if (slot == 45 && event.getCurrentItem().getType() == Material.RED_STAINED_GLASS_PANE) {
                    if (event.getCurrentItem().getItemMeta().getDisplayName().contains("Player 1") && TradeManager.getOtherPlayer(player) != null) {
                        TradeManager.handleTradeAcceptance(player);
                        inventory.setItem(45, new ItemStack(Material.GREEN_STAINED_GLASS_PANE));
                    }
                }
                if (slot == 53 && event.getCurrentItem().getType() == Material.GREEN_STAINED_GLASS_PANE) {
                    if (event.getCurrentItem().getItemMeta().getDisplayName().contains("Player 2") && TradeManager.getOtherPlayer(player) != null) {
                        TradeManager.handleTradeAcceptance(player);
                        inventory.setItem(53, new ItemStack(Material.GREEN_STAINED_GLASS_PANE));
                    }
                }
            }
        }
    }
/*
    @EventHandler
    public void onInventoryDrag(InventoryDragEvent event) {
        Inventory inventory = event.getInventory();
        Player player = (Player) event.getWhoClicked();

        if (TradeManager.isTradeInventory(inventory)) {
            event.setCancelled(true);
            for (int slot : event.getRawSlots()) {
                if (slot < inventory.getSize()) {
                    if (traders.containsKey(player)) {
                        if (!(firstFourColumns.contains(slot))) {
                            event.setCancelled(true);
                            return;
                        }
                    } else if (traders.containsValue(player)) {
                        if (!(lastFourColumns.contains(slot))) {
                            event.setCancelled(true);
                            return;
                        }
                    }
                }
            }
        }
    }*/

    @EventHandler
    public void onInventoryClose(InventoryCloseEvent event) {
        Inventory inventory = event.getInventory();
        Player player = (Player) event.getPlayer();

        if (TradeManager.isTradeInventory(inventory)) {
            TradeManager.cancelTrade(player);
        }
    }
}
