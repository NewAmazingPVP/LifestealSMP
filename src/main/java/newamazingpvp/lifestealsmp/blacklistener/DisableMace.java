package newamazingpvp.lifestealsmp.blacklistener;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.CraftItemEvent;

public class DisableMace implements Listener {
    @EventHandler
    public void onCraftItem(CraftItemEvent event) {
        if (event.getCurrentItem() != null && event.getCurrentItem().getType() == Material.MACE) {
            //         event.setCancelled(true);
            event.getWhoClicked().sendMessage(ChatColor.RED + "The mace is allowed but is nerfed in PVP for balance. Please refer to /rules for more information.");
            Player player = (Player) event.getView().getPlayer();
            player.sendTitle(ChatColor.RED + "WARNING!", "The mace is allowed but is nerfed in PVP for balance.");
        }
    }
}
