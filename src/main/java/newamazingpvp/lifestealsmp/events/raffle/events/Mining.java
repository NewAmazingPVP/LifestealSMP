package newamazingpvp.lifestealsmp.events.raffle.events;

import org.bukkit.Location;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;

import static newamazingpvp.lifestealsmp.events.raffle.RaffleMain.isRaffleEventRunning;
import static newamazingpvp.lifestealsmp.events.raffle.functions.NormalMining.playerMineRaffleNormal;

public class Mining implements Listener {

    @EventHandler
    public void playerBreakBlock(BlockBreakEvent e) {

        if (isRaffleEventRunning) {

            Player player = e.getPlayer();
            Block block = e.getBlock();
            Location loc = block.getLocation();


            playerMineRaffleNormal(player, loc);


        }


    }

}
