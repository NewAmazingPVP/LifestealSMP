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

    @EventHandler
    public void onInventoryClick(InventoryClickEvent event) {
        Inventory inventory = event.getInventory();
        Player player = (Player) event.getWhoClicked();

        if (TradeManager.isTradeInventory(inventory)) {
            int slot = event.getSlot();
            Inventory clickedInventory = event.getClickedInventory();

            if (slot == 45 || slot == 53) {
                event.setCancelled(true);
            }
            if (event.isShiftClick()) {
                event.setCancelled(true);
                return;
            }


            if(!(event.getAction() == InventoryAction.MOVE_TO_OTHER_INVENTORY)) {
                event.setCancelled(true);
            }


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
                if (slot == 45) {
                    if(event.getCurrentItem().getType() == Material.RED_STAINED_GLASS_PANE) {
                        if (event.getCurrentItem().getItemMeta().getDisplayName().contains("Player 1") && TradeManager.getOtherPlayer(player) != null) {
                            TradeManager.handleTradeAcceptance(player);
                            inventory.setItem(45, new ItemStack(Material.GREEN_STAINED_GLASS_PANE));
                        }
                    } else {
                        TradeManager.handleTradeCancellation(player);
                    }
                }
                if (slot == 53) {
                    if(event.getCurrentItem().getType() == Material.RED_STAINED_GLASS_PANE) {
                        if (event.getCurrentItem().getItemMeta().getDisplayName().contains("Player 2") && TradeManager.getOtherPlayer(player) != null) {
                            TradeManager.handleTradeAcceptance(player);
                            inventory.setItem(53, new ItemStack(Material.GREEN_STAINED_GLASS_PANE));
                        }
                    } else {
                        TradeManager.handleTradeCancellation(player);
                    }
                }
            }
        }
    }

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
    }

    @EventHandler
    public void onInv(InventoryInteractEvent e){
        if(TradeManager.isTradeInventory(e.getInventory())){
            e.setCancelled(true);
        }
    }

   /* @EventHandler
    public void onInve(InventoryMoveItemEvent e){
        if(TradeManager.isTradeInventory(e.)){
            e.setCancelled(true);
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
