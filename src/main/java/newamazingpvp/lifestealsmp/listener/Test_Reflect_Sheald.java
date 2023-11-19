package newamazingpvp.lifestealsmp.listener;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;

public class Test_Reflect_Sheald implements Listener {

    public void onPlayerUseShield(PlayerInteractEvent event) {

        Player player = event.getPlayer();

        ItemStack item = player.getInventory().getItemInMainHand();
        if (event.getAction() == Action.RIGHT_CLICK_AIR || event.getAction() == Action.RIGHT_CLICK_BLOCK) {
            if (item.getType() == Material.FEATHER && item.hasItemMeta() && item.getItemMeta().hasDisplayName()
                    && item.getItemMeta().getDisplayName().equals(ChatColor.GREEN + "Reflect Sheald")) {

            }
        }
    }
}
