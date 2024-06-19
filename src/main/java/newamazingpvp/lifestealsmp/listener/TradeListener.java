package newamazingpvp.lifestealsmp.listener;

import newamazingpvp.lifestealsmp.utility.TradeManager;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.*;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

import java.util.HashMap;
import java.util.UUID;

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
            }


            if (traders.containsKey(player)) {
                if (!(lastFourColumns.contains(slot)) && clickedInventory != player.getInventory()) {
                    event.setCancelled(true);
                    player.sendMessage(ChatColor.LIGHT_PURPLE + "You cannot place items in other player's reserved slots, place it bottom/top/right/left wherever your reserved spot is and it allows you to");
                    return;
                }
            } else if (traders.containsValue(player)) {
                if (!(firstFourColumns.contains(slot)) && clickedInventory != player.getInventory()) {
                    event.setCancelled(true);
                    player.sendMessage(ChatColor.LIGHT_PURPLE + "You cannot place items in other player's reserved slots, place it bottom/top/right/left wherever your reserved spot is and it allows you to");
                    return;
                }
            }


            if (slot == 45 || slot == 53) {
                if (slot == 45) {
                    if (inventory.getItem(45).getType() == Material.RED_STAINED_GLASS_PANE) {
                        TradeManager.handleTradeAcceptance(player);
                        inventory.setItem(45, new ItemStack(Material.GREEN_STAINED_GLASS_PANE));
                    } else {
                        TradeManager.handleTradeCancellation(player);
                        inventory.setItem(45, new ItemStack(Material.RED_STAINED_GLASS_PANE));
                    }
                }
                if (slot == 53) {
                    if (inventory.getItem(53).getType() == Material.RED_STAINED_GLASS_PANE) {
                        TradeManager.handleTradeAcceptance(player);
                        inventory.setItem(53, new ItemStack(Material.GREEN_STAINED_GLASS_PANE));
                    } else {
                        TradeManager.handleTradeCancellation(player);
                        inventory.setItem(53, new ItemStack(Material.RED_STAINED_GLASS_PANE));
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
    public void onInv(InventoryInteractEvent e) {
        if (TradeManager.isTradeInventory(e.getInventory())) {
            e.setCancelled(true);
        }
    }

    @EventHandler
    public void onInve(InventoryMoveItemEvent e) {
        if (TradeManager.isTradeInventory(e.getInitiator()) && TradeManager.isTradeInventory(e.getDestination())) {
            e.setCancelled(true);
        }
    }

    @EventHandler
    public void onInventoryClose(InventoryCloseEvent event) {
        Inventory inventory = event.getInventory();
        Player player = (Player) event.getPlayer();

        if (TradeManager.isTradeInventory(inventory)) {
            TradeManager.cancelTrade(player);
        }
    }
}
