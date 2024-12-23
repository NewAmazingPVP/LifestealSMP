package newamazingpvp.lifestealsmp.TrimsUpdate.TrimsListeners;

import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.inventory.meta.ArmorMeta;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.trim.TrimPattern;

import static newamazingpvp.lifestealsmp.TrimsUpdate.TrimsListeners.Utils.GetArmorTrimSet.getArmorTrimSet;

public class SentryTrim implements Listener {


    @EventHandler
    public void onEntityDamage(EntityDamageByEntityEvent event) {
        Entity damager = event.getDamager();

        if (damager instanceof Player attacker) {
            attacker.sendMessage("test1");

            if (getArmorTrimSet(attacker, TrimPattern.SENTRY)) {
                attacker.sendMessage("Hello World");
            }
        }
    }


}
