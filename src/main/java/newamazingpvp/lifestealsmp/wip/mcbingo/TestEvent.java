package newamazingpvp.lifestealsmp.wip.mcbingo;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;

import static newamazingpvp.lifestealsmp.wip.mcbingo.BingoMessageEvents.bingoChallengeDone;

public class TestEvent implements Listener {

    @EventHandler
    public void testEvent(BlockBreakEvent e) {

        Player player = e.getPlayer();

        String challengeName = "Test Event";

        bingoChallengeDone(player, challengeName);

    }
}
