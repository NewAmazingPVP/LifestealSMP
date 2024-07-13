package newamazingpvp.lifestealsmp.blacklistener;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.CraftItemEvent;

public class EndCrystalWarning implements Listener {

    @EventHandler
    public void onCraftItem(CraftItemEvent event) {
        if (event.getCurrentItem() != null && event.getCurrentItem().getType() == Material.END_CRYSTAL) {
            event.getWhoClicked().sendMessage(ChatColor.RED + "End crystals are allowed for PvP but are nerfed for balance. You can also use them to respawn the dragon.");
            Player player = (Player) event.getView().getPlayer();
            player.sendTitle(ChatColor.RED + "WARNING!", "End crystals are allowed but are nerfed in PVP for balance.");
        }
    }

    @EventHandler
    public void onDangerousCraft(CraftItemEvent event) {
        if (event.getCurrentItem() != null &&
                (event.getCurrentItem().getType() == Material.RESPAWN_ANCHOR || event.getCurrentItem().getType() == Material.TNT_MINECART)) {

            event.getWhoClicked().sendMessage(ChatColor.RED + "This item is allowed but is nerfed in PVP for balance. Check /rules for more information.");
            Player player = (Player) event.getView().getPlayer();
            player.sendTitle(ChatColor.RED + "WARNING!", "This item is allowed but is nerfed in PVP for balance.");
        }
    }
}
