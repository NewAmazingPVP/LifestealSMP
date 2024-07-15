package newamazingpvp.lifestealsmp.listener.unused;

import com.destroystokyo.paper.event.block.BeaconEffectEvent;
import org.bukkit.block.Beacon;
import org.bukkit.block.Block;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class BeaconInvis implements Listener {
    @EventHandler
    public void onPlayerBeaconEffect(BeaconEffectEvent event) {
        Block block = event.getBlock();

        if (block.getState() instanceof Beacon beacon) {

            if (beacon.getTier() == 4) {
                event.getPlayer().addPotionEffect(new PotionEffect(PotionEffectType.INVISIBILITY, 17 * 20, 0, true, false));
            }
        }
    }
}
