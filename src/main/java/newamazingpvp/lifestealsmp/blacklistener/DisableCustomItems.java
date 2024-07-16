package newamazingpvp.lifestealsmp.blacklistener;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.CraftItemEvent;

import static newamazingpvp.lifestealsmp.customitems.utils.GUI.basicItems;
import static newamazingpvp.lifestealsmp.customitems.utils.GUI.customItems;
import static newamazingpvp.lifestealsmp.events.TimeManager.CUSTOM_ITEMS_AND_RUNES;
import static newamazingpvp.lifestealsmp.events.TimeManager.formatDuration;

public class DisableCustomItems implements Listener {
    @EventHandler
    public void onCraftItem(CraftItemEvent event) {
        if (event.getCurrentItem() != null && customItems.contains(event.getCurrentItem()) && !basicItems.contains(event.getCurrentItem())) {
            event.getWhoClicked().sendMessage(ChatColor.RED + "This custom item is not enabled yet. It will enable in " + formatDuration(CUSTOM_ITEMS_AND_RUNES));
            Player player = (Player) event.getView().getPlayer();
            player.sendTitle(ChatColor.RED + "WARNING!", ChatColor.YELLOW + "This custom item is not enabled yet. It will enable in " + formatDuration(CUSTOM_ITEMS_AND_RUNES));
            event.setCancelled(true);
        }
    }
}
