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

        if (e.getDamager() instanceof Player) {
            Player player = (Player) e.getDamager();
            ItemStack itemInHand = player.getItemInHand();
            ItemMeta meta = itemInHand.getItemMeta();
            if (meta != null && meta.getLore() != null && meta.getLore().toString().contains("You will heal " + ChatColor.RED + "1❤")){

                player.sendMessage("test 123");
                player.setHealth(player.getHealth()+1);

            }
        }
    }
}

