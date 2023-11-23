package newamazingpvp.lifestealsmp.StaffListeners;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryInteractEvent;
import org.bukkit.event.inventory.InventoryType;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.InventoryView;
import org.bukkit.inventory.ItemStack;

public class DetectArmorSrtBonus implements Listener {

    @EventHandler
    public void onPlayerChangeInvintory(InventoryClickEvent event) {

        Player player = (Player) event.getWhoClicked();
        InventoryView view = event.getView();
        if (view.getType() == InventoryType.PLAYER) {
            ItemStack clickedItem = event.getCurrentItem();
            if (clickedItem != null && clickedItem.hasItemMeta() && clickedItem.getItemMeta().hasDisplayName()) {
                String itemName = clickedItem.getItemMeta().getDisplayName();
                if (itemName.equals(ChatColor.LIGHT_PURPLE + "" + ChatColor.MAGIC + "LL" + ChatColor.DARK_RED + ChatColor.BOLD + "Extra Heart" + ChatColor.LIGHT_PURPLE + "" + ChatColor.MAGIC + "LL")) {
                    player.sendMessage(ChatColor.GREEN + "Hello");
                }
            }
        }
    }
}
