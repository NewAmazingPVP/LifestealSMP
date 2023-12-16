package newamazingpvp.lifestealsmp.listener;

import org.bukkit.Location;
import org.bukkit.block.Beacon;
import org.bukkit.entity.Entity;
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

public class BeaconInvis implements Listener {

    private final Map<UUID, Beacon> playersInBeaconRange = new HashMap<>();

    @EventHandler
    public void onPlayerMove(PlayerMoveEvent event) {
        Player player = event.getPlayer();
        Location playerLocation = player.getLocation();

        Beacon beacon = getFullyPoweredBeaconInRange(playerLocation);
        if (beacon != null) {
            if (!playersInBeaconRange.containsKey(player.getUniqueId())) {
                player.addPotionEffect(new PotionEffect(PotionEffectType.INVISIBILITY, Integer.MAX_VALUE, 0, true, false));
                playersInBeaconRange.put(player.getUniqueId(), beacon);
            }
        } else {
            if (playersInBeaconRange.containsKey(player.getUniqueId())) {
                player.removePotionEffect(PotionEffectType.INVISIBILITY);
                playersInBeaconRange.remove(player.getUniqueId());
            }
        }
    }

    @EventHandler
    public void onPlayerQuit(PlayerQuitEvent event) {
        playersInBeaconRange.remove(event.getPlayer().getUniqueId());
    }

    private Beacon getFullyPoweredBeaconInRange(Location playerLocation) {
        double beaconRange = 50;

        for (Entity entity : playerLocation.getWorld().getNearbyEntities(playerLocation, beaconRange, 384, beaconRange)) {
            if (entity instanceof Beacon) {
                Beacon beacon = (Beacon) entity;
                if (playerLocation.distanceSquared(beacon.getLocation()) <= beaconRange * beaconRange && beacon.getTier() == 4) {
                    return beacon;
                }
            }
        }
        return null;
    }
}
