package newamazingpvp.lifestealsmp.listener;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.inventory.ItemStack;

public class DragonEggPerk implements Listener {
    @EventHandler
    public void onDamaged(EntityDamageEvent e) {
        if (e.getEntity() instanceof Player p) {
            for (ItemStack item : p.getInventory().getContents()) {
                if (item != null && item.getType() == Material.DRAGON_EGG) {
                    //e.setDamage(e.getFinalDamage() * 0.85);
                    e.setDamage(e.getDamage() * 0.90);
                }
            }
        }
    }
}
