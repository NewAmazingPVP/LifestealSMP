package newamazingpvp.lifestealsmp.unused.customrunes;

import org.bukkit.World;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import static newamazingpvp.lifestealsmp.utility.Utils.isRuneInInventory;

public class HellRune implements Listener {

    @EventHandler
    public void playerAttack(EntityDamageByEntityEvent e) {

        if (!(e.getDamager() instanceof Player)) return;
        Player attacker = (Player) e.getDamager();
        World world = attacker.getWorld();
        PotionEffect effect = new PotionEffect(PotionEffectType.DOLPHINS_GRACE, 100, 0); //change if needed

        if (isRuneInInventory(attacker, "hell rune")) {
            if (world.getEnvironment() == World.Environment.NETHER) {
                attacker.addPotionEffect(effect);
            }
        }
    }
}

