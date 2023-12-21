package newamazingpvp.lifestealsmp.listener;

import io.papermc.paper.event.player.AsyncChatEvent;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.player.AsyncPlayerChatEvent;

import static newamazingpvp.lifestealsmp.game.TeamsManager.isPlayerInTeamChat;
import static newamazingpvp.lifestealsmp.game.TeamsManager.sendTeamMessage;

public class TeamListener implements Listener {

    @EventHandler
    public void teamChatEvent(AsyncPlayerChatEvent event) {
        Player p = event.getPlayer();
        if(isPlayerInTeamChat(p)){
            event.setCancelled(true);
            sendTeamMessage(p, event.getMessage());
        }
    }


}
