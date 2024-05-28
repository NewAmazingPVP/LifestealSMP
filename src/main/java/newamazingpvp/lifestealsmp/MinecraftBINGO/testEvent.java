package newamazingpvp.lifestealsmp.MinecraftBINGO;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.player.PlayerInteractEvent;

import static newamazingpvp.lifestealsmp.MinecraftBINGO.BingoMessageEvents.bingoChallengeDone;

public class testEvent implements Listener {

    @EventHandler
    public void testEvent(BlockBreakEvent e) {

        Player player = e.getPlayer();

        String challengeName = "Test Event";

        bingoChallengeDone(player,challengeName);

    }
}
