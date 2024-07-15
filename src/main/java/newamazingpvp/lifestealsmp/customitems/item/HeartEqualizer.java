package newamazingpvp.lifestealsmp.customitems.item;

import org.bukkit.Bukkit;
import org.bukkit.entity.*;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;

import static newamazingpvp.lifestealsmp.customitems.utils.ItemStacks.createHeartEqualizer;
import static newamazingpvp.lifestealsmp.utility.Utils.returnPlayerDamager;

public class HeartEqualizer implements Listener {
    @EventHandler
    public void onDamage(EntityDamageByEntityEvent event) {
        if (event.getEntity() instanceof Player) {
            Player damager = returnPlayerDamager(event.getDamager());
            if(damager == null) return;
            Player damagedPlayer = (Player) event.getEntity();
            if (damagedPlayer.getInventory().contains(createHeartEqualizer())) {
                double dmg = event.getFinalDamage();
                double finalDmg = dmg * Math.min(1, (damagedPlayer.getMaxHealth() / damager.getMaxHealth()));

                event.setDamage(finalDmg);
            }
        }
    }
}
