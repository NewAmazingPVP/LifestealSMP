package newamazingpvp.lifestealsmp.listener;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.PrepareAnvilEvent;
import org.bukkit.inventory.AnvilInventory;

public class OneExpRename implements Listener {
    @EventHandler
    public void onAnvilPrepare(PrepareAnvilEvent event) {
        AnvilInventory anvilInventory = event.getInventory();
        if ((!(anvilInventory.getRenameText() == null)) && anvilInventory.getSecondItem() == null) {
            event.getInventory().setRepairCost(1);
        }
    }
}
