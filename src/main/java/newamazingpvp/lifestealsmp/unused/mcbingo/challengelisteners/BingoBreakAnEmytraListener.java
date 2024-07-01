package newamazingpvp.lifestealsmp.unused.mcbingo.challengelisteners;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerItemBreakEvent;
import org.bukkit.inventory.ItemStack;

import static newamazingpvp.lifestealsmp.unused.mcbingo.ToggleBingoListeners.toggleBreakAnElytra;

public class BingoBreakAnEmytraListener implements Listener {

    @EventHandler
    public void itemBreak(PlayerItemBreakEvent e) {

        Player player = e.getPlayer();
        ItemStack brokenItem = e.getBrokenItem();

        if (toggleBreakAnElytra) {
            if (brokenItem != null && brokenItem.getType() == Material.ELYTRA) {

                //TODO: <<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<


            }
        }
    }
}
