package newamazingpvp.lifestealsmp.events.raffle.events;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryInteractEvent;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;
import java.util.List;

import static newamazingpvp.lifestealsmp.events.raffle.RaffleMain.currentRaffleEventID;

public class ClearOldBingoTags implements Listener {

    private static final List<ItemStack> itemsToRemove = new ArrayList<>();


    @EventHandler
    public void onPlayerMove(PlayerMoveEvent e) {

        Player player = e.getPlayer();
        clearOldBingoTickets(player);

    }

    @EventHandler
    public void inventoryInteract(InventoryInteractEvent e) {

        Player player = (Player) e.getWhoClicked();
        clearOldBingoTickets(player);

    }


    private static void clearOldBingoTickets(Player player) {

        Inventory inventory = player.getInventory();

        for (ItemStack item : inventory.getContents()) {
            if (item != null && item.getType() != Material.AIR) {
                ItemMeta meta = item.getItemMeta();
                if (item.getType() == Material.PAPER) {
                    if (meta.getLore().toString().contains("Right click within 150 blocks")) {

                        if (!(meta.getLore().toString().contains("E " + currentRaffleEventID))) {
                            itemsToRemove.add(item);
                        }
                    }
                }
            }
        }

        for (ItemStack item : itemsToRemove) {
            inventory.removeItem(item);
        }


    }


}
