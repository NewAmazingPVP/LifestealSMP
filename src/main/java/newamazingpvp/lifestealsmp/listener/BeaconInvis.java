package newamazingpvp.lifestealsmp.listener;

import com.destroystokyo.paper.event.block.BeaconEffectEvent;
import io.papermc.paper.event.block.BeaconDeactivatedEvent;
import org.bukkit.Location;
import org.bukkit.block.Beacon;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import static newamazingpvp.lifestealsmp.LifestealSMP.lifestealSmp;
import static org.bukkit.Bukkit.getServer;

public class BeaconInvis implements Listener {
    @EventHandler
    public void onPlayerBeaconEffect(BeaconEffectEvent event) {
        Block block = event.getBlock();

        if (block.getState() instanceof Beacon) {
            Beacon beacon = (Beacon) block.getState();

            if (beacon.getTier() == 4) {
                event.getPlayer().addPotionEffect(new PotionEffect(PotionEffectType.INVISIBILITY, 17 * 20, 0, true, false));
            }
        }
    }
}
