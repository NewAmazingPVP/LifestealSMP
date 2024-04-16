package newamazingpvp.lifestealsmp.runes;


import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;
import java.util.HashMap;
import java.util.UUID;

public class AirRune implements Listener {

    private final HashMap<UUID, Integer> jumpCount = new HashMap<>();

    @EventHandler
    public void onPlayerMove(PlayerMoveEvent event) {
        Player player = event.getPlayer();
        UUID playerId = player.getUniqueId();

        if (player.isOnGround()) {
            jumpCount.put(playerId, 0); // Reset jump count when player is on the ground
        } else if (jumpCount.getOrDefault(playerId, 0) < 1) {
            jumpCount.put(playerId, jumpCount.getOrDefault(playerId, 0) + 1); // Increment jump count
        } else {
            event.setCancelled(true); // Cancel the event if the player has already jumped once
        }
    }
}

