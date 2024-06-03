package newamazingpvp.lifestealsmp.customitems;

import org.bukkit.ChatColor;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class LifestealSword implements Listener {

    @EventHandler
    public void playerHitPlayer(EntityDamageByEntityEvent e) {

        Player player = (Player) e.getDamager();
        Entity hitPlayer = e.getEntity();
        ItemStack itemInHand = player.getItemInHand();
        ItemMeta meta = itemInHand.getItemMeta();

        if (hitPlayer instanceof Player) {

            if (meta.getLore().toString().contains("you will heal 1hp")){

                player.sendMessage("test 123");

            }
        }
    }
}
