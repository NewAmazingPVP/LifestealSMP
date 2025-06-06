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

import static newamazingpvp.lifestealsmp.utility.TradeManager.*;

public class TradeListener implements Listener {

    @EventHandler
    public void onInventoryClick(InventoryClickEvent event) {
        Inventory inventory = event.getInventory();
        Player player = (Player) event.getWhoClicked();

        if (TradeManager.isTradeInventory(inventory)) {

            if (event.getClick() == ClickType.DOUBLE_CLICK) {
                int slot = event.getSlot();
                boolean allowedDoubleClick = false;
/*                if (traders.containsKey(player)) {
                    allowedDoubleClick = lastFourColumns.contains(slot);
                } else if (traders.containsValue(player)) {
                    allowedDoubleClick = firstFourColumns.contains(slot);
                }*/
                if (!allowedDoubleClick) {
                    event.setCancelled(true);
//                    TradeManager.cancelTrade(player);
//                    //TradeManager.handleTradeCancellation(getOtherPlayer(player));
//                    //inventory.setItem(45, new ItemStack(Material.RED_STAINED_GLASS_PANE));
//                    //inventory.setItem(53, new ItemStack(Material.RED_STAINED_GLASS_PANE));
//                    player.sendMessage(ChatColor.LIGHT_PURPLE + "You cannot double click items.");
//                    //getOtherPlayer(player).sendMessage(ChatColor.LIGHT_PURPLE + "Trade was cancelled, maybe send a request again?");
//                    return;
                }
            }


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
                    ItemStack stack45 = inventory.getItem(45);
                    if (stack45 != null && stack45.getType() == Material.RED_STAINED_GLASS_PANE) {
                        TradeManager.handleTradeAcceptance(player);
                        inventory.setItem(45, new ItemStack(Material.GREEN_STAINED_GLASS_PANE));
                    } else {
                        TradeManager.handleTradeCancellation(player);
                        inventory.setItem(45, new ItemStack(Material.RED_STAINED_GLASS_PANE));
                    }
                }
                if (slot == 53) {
                    ItemStack stack53 = inventory.getItem(53);
                    if (stack53 != null && stack53.getType() == Material.RED_STAINED_GLASS_PANE) {
                        TradeManager.handleTradeAcceptance(player);
                        inventory.setItem(53, new ItemStack(Material.GREEN_STAINED_GLASS_PANE));
                    } else {
                        TradeManager.handleTradeCancellation(player);
                        inventory.setItem(53, new ItemStack(Material.RED_STAINED_GLASS_PANE));
                    }
                }
            } else {
                if (clickedInventory != player.getInventory()) {
                    TradeManager.handleTradeCancellation(player);
                    TradeManager.handleTradeCancellation(getOtherPlayer(player));
                    inventory.setItem(45, new ItemStack(Material.RED_STAINED_GLASS_PANE));
                    inventory.setItem(53, new ItemStack(Material.RED_STAINED_GLASS_PANE));
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
