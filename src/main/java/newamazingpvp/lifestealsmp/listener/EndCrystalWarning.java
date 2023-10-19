package newamazingpvp.lifestealsmp.listener;

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
            event.getWhoClicked().sendMessage(ChatColor.RED + "You can only use crystals to respawn dragon and not for PVP!");
            Player player = (Player) event.getView().getPlayer();
            player.sendTitle(ChatColor.RED + "WARNING!", "You can only use crystals to respawn dragon and not for PVP!");
        }
    }

    @EventHandler
    public void onDangerousCraft(CraftItemEvent event) {
        if (event.getCurrentItem() != null && event.getCurrentItem().getType() == Material.RESPAWN_ANCHOR || event.getCurrentItem().getType() == Material.TNT_MINECART) {
            event.getWhoClicked().sendMessage(ChatColor.RED + "You cannot use this for PVP! Do /rules");
            Player player = (Player) event.getView().getPlayer();
            player.sendTitle(ChatColor.RED + "WARNING!", "You cannot use this for PVP! Do /rules");
        }
    }
}
