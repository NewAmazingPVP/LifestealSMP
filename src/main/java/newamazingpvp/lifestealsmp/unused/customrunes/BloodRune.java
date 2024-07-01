package newamazingpvp.lifestealsmp.unused.customrunes;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDeathEvent;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import static newamazingpvp.lifestealsmp.utility.Utils.isRuneInInventory;

public class BloodRune implements Listener {


    @EventHandler
    public void playerAttack(EntityDeathEvent e) {

        Player killer = e.getEntity().getKiller();
        if (killer == null) return;
        PotionEffect effect = new PotionEffect(PotionEffectType.STRENGTH, 20 * 5, 4); //change if needed

        if (isRuneInInventory(killer, "blood rune")) {
            killer.addPotionEffect(effect);
        }
    }
}

