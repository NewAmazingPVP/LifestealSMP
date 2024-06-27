package newamazingpvp.lifestealsmp.runes.customrunes;


import com.destroystokyo.paper.event.player.PlayerJumpEvent;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.util.Vector;

import java.util.HashMap;
import java.util.UUID;

public class AirRune implements Listener {

    private final HashMap<UUID, Integer> jumpCount = new HashMap<>();

    @EventHandler
    public void onPlayerJump(PlayerJumpEvent event) {
        Player player = event.getPlayer();
        UUID playerId = player.getUniqueId();

        if (!jumpCount.containsKey(playerId)) {
            jumpCount.put(playerId, 0);
        }

        int currentJumpCount = jumpCount.get(playerId);
        if (currentJumpCount < 1) {
            jumpCount.put(playerId, currentJumpCount + 1);
        } else if (currentJumpCount == 1) {
            // Double jump logic here
            // For example, you can increase the player's jump velocity
            player.setVelocity(player.getVelocity().add(new Vector(0, 20, 0)));
            jumpCount.put(playerId, 0); // Reset the jump count
        }
    }
}

