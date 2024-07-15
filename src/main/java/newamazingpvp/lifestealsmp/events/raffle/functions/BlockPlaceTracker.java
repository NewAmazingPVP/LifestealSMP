package newamazingpvp.lifestealsmp.events.raffle.functions;

import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockPlaceEvent;

import java.util.HashMap;
import java.util.UUID;

public class BlockPlaceTracker implements Listener {

    private static final HashMap<Location, UUID> placedBlocks = new HashMap<>();

    public static void registerBlockPlacement(Location blockLocation, Player player) {
        placedBlocks.put(blockLocation, player.getUniqueId());
    }

    public static boolean hasPlayerPlacedBlock(Location blockLocation, UUID playerUUID) {
        return placedBlocks.containsKey(blockLocation) && placedBlocks.get(blockLocation).equals(playerUUID);
    }


    @EventHandler
    public void onBlockPlace(BlockPlaceEvent event) {
        BlockPlaceTracker.registerBlockPlacement(event.getBlock().getLocation(), event.getPlayer());
    }


}


