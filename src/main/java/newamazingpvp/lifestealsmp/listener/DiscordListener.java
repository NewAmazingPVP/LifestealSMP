package newamazingpvp.lifestealsmp.listener;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.CraftItemEvent;
import org.bukkit.event.player.AsyncPlayerChatEvent;

import static newamazingpvp.lifestealsmp.utility.DiscordBot.sendWebhook;

public class DiscordListener implements Listener {
    @EventHandler
    public void messageSent(AsyncPlayerChatEvent event) {
        if(!event.isCancelled()){
            sendWebhook(event.getPlayer(), event.getMessage());
        }
    }

    @EventHandler
    public void onAchievement(Advan event) {
        if(!event.isCancelled()){
            sendWebhook(event.getPlayer(), event.getMessage());
        }
    }
}
