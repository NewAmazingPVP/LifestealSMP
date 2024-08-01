package newamazingpvp.lifestealsmp.unused.events.raffle.events;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

import static newamazingpvp.lifestealsmp.unused.events.raffle.RaffleMain.isRaffleEventRunning;
import static newamazingpvp.lifestealsmp.unused.events.raffle.RaffleMain.raffleTimerBossBar;

public class PlayerBossBar implements Listener {

    @EventHandler
    public void playerJoin(PlayerJoinEvent e) {
        Player player = e.getPlayer();

        raffleTimerBossBar.addPlayer(player);

        if (!isRaffleEventRunning) {
            raffleTimerBossBar.setVisible(false);
        }

    }

}
