package newamazingpvp.lifestealsmp.RaffleEvent.RaffleEvents;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

import static newamazingpvp.lifestealsmp.RaffleEvent.RaffleMain.isRaffleEventRunning;
import static newamazingpvp.lifestealsmp.RaffleEvent.RaffleMain.raffleTimerBossBar;

public class RaffleAddPlayersToBossBar implements Listener {

    @EventHandler
    public void playerJoin(PlayerJoinEvent e){
        Player player = e.getPlayer();

        raffleTimerBossBar.addPlayer(player);

        if(!isRaffleEventRunning) {
            raffleTimerBossBar.setVisible(false);
        }

    }

}
