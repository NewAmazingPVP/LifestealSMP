package newamazingpvp.lifestealsmp.events.corruptedmobs.utilities;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryType;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class AntiItemUse implements Listener {

    @EventHandler
    public void blockPlace(BlockPlaceEvent e) {

        Player player = e.getPlayer();
        ItemStack item = player.getInventory().getItemInMainHand();
        ItemMeta meta = item.getItemMeta();


        if (meta.getLore().toString().contains("When you kill a mob you have a")) {
            e.setCancelled(true);
        }
    }

    @EventHandler
    public void inventoryInteract(InventoryClickEvent e) {

        Player player = (Player) e.getWhoClicked();
        ItemStack item = player.getInventory().getItemInMainHand();
        ItemMeta meta = item.getItemMeta();
        Inventory menu = player.getInventory();

        if (meta.getLore().toString().contains("When you kill a mob you have a") && menu.getType() == InventoryType.ANVIL) {
            e.setCancelled(true);
        }

    }


}
