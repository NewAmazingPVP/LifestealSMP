package newamazingpvp.lifestealsmp.unused.mcbingo;

import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.meta.ItemMeta;

import static newamazingpvp.lifestealsmp.unused.mcbingo.gui.BingoCardGUIs.BingoMainMenu;

public class BingoCardListener implements Listener {


    @EventHandler
    public void playerOpenBINOCard(PlayerInteractEvent e) {
        Player player = e.getPlayer();
        ItemMeta meta = e.getItem().getItemMeta();

        if ((e.getAction() == Action.RIGHT_CLICK_AIR || e.getAction() == Action.RIGHT_CLICK_BLOCK) &&
                e.hasItem() && e.getItem().getType() == Material.PAINTING) {

            if (meta.getLore() == null) {
                return;
            }

            if (meta.getLore().toString().contains("Open Bingo Card")) {

                e.setCancelled(true);

                player.playSound(player.getLocation(), Sound.BLOCK_STONE_BUTTON_CLICK_OFF, 2.0f, 2.0f);

                BingoMainMenu(player);


            }
        }
    }
}

