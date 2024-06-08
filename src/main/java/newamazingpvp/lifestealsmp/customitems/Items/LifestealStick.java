package newamazingpvp.lifestealsmp.customitems.Items;

import org.bukkit.ChatColor;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class LifestealStick implements Listener {

    @EventHandler
    public void playerHitPlayer(EntityDamageByEntityEvent e) {

        Entity damagedPlayer = e.getEntity();

        if (e.getDamager() instanceof Player) {
            Player player = (Player) e.getDamager();
            ItemStack itemInHand = player.getItemInHand();
            ItemMeta meta = itemInHand.getItemMeta();
            if (meta != null && meta.getLore() != null && meta.getLore().toString().contains("You will heal " + ChatColor.RED + "1❤")) {
                if(damagedPlayer instanceof Player){

                    player.setHealth(player.getHealth() + 1);

                }




            }
        }
    }
}


