package newamazingpvp.lifestealsmp.listener;

import newamazingpvp.lifestealsmp.utility.TradeManager;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryCloseEvent;
import org.bukkit.inventory.Inventory;

import java.util.Map;

import static newamazingpvp.lifestealsmp.utility.TradeManager.*;

public class TradeListener implements Listener {

    @EventHandler
    public void onInventoryClick(InventoryClickEvent event) {
        Inventory inventory = event.getInventory();
        Player player = (Player) event.getWhoClicked();

        if (TradeManager.isTradeInventory(inventory)) {
            int slot = event.getSlot();
            // Prevent item movement for accept buttons
            if (slot == 45 || slot == 53) {
                event.setCancelled(true);
            } else if (slot >= 0 && slot < 54) {
                // Allow item movement within the trade window
                // Ensure that clicks in the player's own inventory are cancelled to prevent taking out items
                /*if (event.getClickedInventory() != inventory) {
                    event.setCancelled(true);
                }*/
                if(traders.containsKey(player))
                    if(!(firstFourColumns.contains(slot))){
                        if(!event.getClickedInventory().equals(player.getInventory())) {
                            event.setCancelled(true);
                        }
                    }
                }
                if(traders.containsValue(player)){
                    if(!(lastFourColumns.contains(slot))){
                        if(!event.getClickedInventory().equals(player.getInventory())) {
                            event.setCancelled(true);
                        }
                    }
            }
            // Handle accept button clicks
            if (event.getCurrentItem() != null) {
                if (slot == 45 && event.getCurrentItem().getType() == Material.GREEN_STAINED_GLASS_PANE) {
                    if (event.getCurrentItem().getItemMeta().getDisplayName().contains("Player 1") && TradeManager.getOtherPlayer(player) != null) {
                        TradeManager.handleTradeAcceptance(player);
                    }
                }
                if (slot == 53 && event.getCurrentItem().getType() == Material.GREEN_STAINED_GLASS_PANE) {
                    if (event.getCurrentItem().getItemMeta().getDisplayName().contains("Player 2") && TradeManager.getOtherPlayer(player) != null) {
                        TradeManager.handleTradeAcceptance(player);
                    }
                }
            }
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
