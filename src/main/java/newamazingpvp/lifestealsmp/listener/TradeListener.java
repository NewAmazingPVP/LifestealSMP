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

import java.util.HashMap;
import java.util.UUID;

import static newamazingpvp.lifestealsmp.utility.TradeManager.*;

public class TradeListener implements Listener {
    private final HashMap<UUID, Long> lastInteractionTime = new HashMap<>();

    @EventHandler
    public void onInventoryClick(InventoryClickEvent event) {
        Inventory inventory = event.getInventory();
        Player player = (Player) event.getWhoClicked();
        UUID playerUUID = player.getUniqueId();
        long currentTime = System.currentTimeMillis();

        if (TradeManager.isTradeInventory(inventory)) {
            /*if(event.getClickedInventory().equals(inventory)){
                event.setCancelled(true);
                return;
            }*/
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
                        return;
                    }
                } else if (traders.containsValue(player)) {
                    if (!(firstFourColumns.contains(slot)) && clickedInventory != player.getInventory()) {
                        event.setCancelled(true);
                        return;
                    }
                }


            //}
            if (slot == 45 || slot == 53) {
                if (lastInteractionTime.containsKey(playerUUID) && (currentTime - lastInteractionTime.get(playerUUID)) < 50) {
                    event.setCancelled(true);
                    return;
                }

                lastInteractionTime.put(playerUUID, currentTime);
                if (slot == 45) {
                    //player.sendMessage(inventory.getItem(45).getType().toString().toLowerCase());
                    //player.sendMessage(String.valueOf(inventory.getItem(45).getType().toString().toLowerCase().contains("red")));
                    if(inventory.getItem(45).getType().toString().toLowerCase().contains("red")) {
                            TradeManager.handleTradeAcceptance(player);
                            inventory.setItem(45, new ItemStack(Material.GREEN_STAINED_GLASS_PANE));
                    } else {
                        TradeManager.handleTradeCancellation(player);
                        inventory.setItem(45, new ItemStack(Material.RED_STAINED_GLASS_PANE));
                    }
                }
                if (slot == 53) {
                    //player.sendMessage(inventory.getItem(53).getType().toString().toLowerCase());
                    //player.sendMessage(String.valueOf(inventory.getItem(53).getType().toString().toLowerCase().contains("red")));
                    if (inventory.getItem(53).getType().toString().toLowerCase().contains("red")) {
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
    public void onInv(InventoryInteractEvent e){
        if(TradeManager.isTradeInventory(e.getInventory())){
            e.setCancelled(true);
        }
    }

    @EventHandler
    public void onInve(InventoryMoveItemEvent e){
        if(TradeManager.isTradeInventory(e.getInitiator()) && TradeManager.isTradeInventory(e.getDestination())){
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
