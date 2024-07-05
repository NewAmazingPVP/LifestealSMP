package newamazingpvp.lifestealsmp.RaffleEvent.RaffleEvents;

import newamazingpvp.lifestealsmp.RaffleEvent.RaffleFunctions.BlockPlaceTracker;
import org.bukkit.Location;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;

import java.util.UUID;

import static newamazingpvp.lifestealsmp.RaffleEvent.RaffleFunctions.RaffleNormalMining.playerMineRaffleNormal;

public class RaffleMiningEvent implements Listener {

    @EventHandler
    public void playerBreakBlock(BlockBreakEvent e){

        Player player = e.getPlayer();
        Block block = e.getBlock();
        Location loc = block.getLocation();



        playerMineRaffleNormal(player, loc);

    }

}
