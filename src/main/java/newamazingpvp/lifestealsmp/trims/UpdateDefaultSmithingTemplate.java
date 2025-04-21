package newamazingpvp.lifestealsmp.trims;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.ItemStack;

import static newamazingpvp.lifestealsmp.trims.TrimsItemstacks.sentryTrimArmor;

public class UpdateDefaultSmithingTemplate implements Listener {

    @EventHandler
    public void onPlayerRightClick(InventoryClickEvent e) {

        Player player = (Player) e.getWhoClicked();
        updateInventoryToRemoveSmithingTeplate(player);

    }


    private void updateInventoryToRemoveSmithingTeplate(Player player) {

        for (int i = 0; i < player.getInventory().getSize(); i++) {
            ItemStack item = player.getInventory().getItem(i);
            if (item != null) {

                if (item.getType().equals(Material.SENTRY_ARMOR_TRIM_SMITHING_TEMPLATE)) {

                    for (int x = 0; i < item.getAmount(); x++) {
                        player.getInventory().setItem(i, sentryTrimArmor());
                    }


                }

            }
        }

    }


}
