package newamazingpvp.lifestealsmp.unused.customrunes;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import static newamazingpvp.lifestealsmp.utility.Utils.isRuneInInventory;

public class AquaRune implements Listener {

    @EventHandler
    public void playerMove(PlayerMoveEvent e) {


        //AQUA RUNE
        PotionEffect effect = new PotionEffect(PotionEffectType.DOLPHINS_GRACE, 100, 4); //change if needed

        Player player = e.getPlayer();
        if (isRuneInInventory(player, "aqua rune")) {
            if (e.getPlayer().getLocation().getBlock().getType() == Material.WATER) {
                player.addPotionEffect(effect);
            }
        }
    }
}
