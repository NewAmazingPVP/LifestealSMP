package newamazingpvp.lifestealsmp.listener;

import org.bukkit.ChatColor;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerKickEvent;
import org.bukkit.event.player.PlayerLoginEvent;

import static newamazingpvp.lifestealsmp.command.DiscordLink.discordURL;

public class PlayerBan implements Listener {
    @EventHandler
    public void onBan(PlayerKickEvent event){
        if(event.getCause() == PlayerKickEvent.Cause.BANNED){
            if(event.getReason().contains("appeal")) return;
            event.setReason(event.getReason() + "You were banned for breaking a rule. If you feel you were unfairly banned make an appeal in discord. " + ChatColor.AQUA + discordURL);
        }
    }

    @EventHandler
    public void onJoin(PlayerLoginEvent event){
        if(event.getResult() == PlayerLoginEvent.Result.KICK_BANNED){
            if(event.getKickMessage().contains("appeal")) return;
            event.setKickMessage(event.getKickMessage() + "You were banned for breaking a rule. If you feel you were unfairly banned make an appeal in discord. " + ChatColor.AQUA + discordURL);
        }
    }
}
