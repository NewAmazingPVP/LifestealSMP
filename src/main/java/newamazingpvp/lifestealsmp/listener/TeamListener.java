package newamazingpvp.lifestealsmp.listener;

import com.earth2me.essentials.Essentials;
import com.google.common.collect.Iterables;
import com.google.common.io.ByteArrayDataOutput;
import com.google.common.io.ByteStreams;
import io.papermc.paper.event.player.AsyncChatEvent;
import io.papermc.paper.event.player.ChatEvent;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import org.json.simple.JSONObject;

import static newamazingpvp.lifestealsmp.LifestealSMP.essentials;
import static newamazingpvp.lifestealsmp.LifestealSMP.lifestealSmp;
import static newamazingpvp.lifestealsmp.game.AlliesManager.isPlayerInAllyChat;
import static newamazingpvp.lifestealsmp.game.AlliesManager.sendAllyMessage;
import static newamazingpvp.lifestealsmp.game.TeamsManager.isPlayerInTeamChat;
import static newamazingpvp.lifestealsmp.game.TeamsManager.sendTeamMessage;

public class TeamListener implements Listener {

    @EventHandler
    public void teamChatEvent(AsyncPlayerChatEvent event) {
        Player p = event.getPlayer();
        if(isPlayerInTeamChat(p)){
            event.setCancelled(true);
            sendTeamMessage(p, event.getMessage());
        } else if(isPlayerInAllyChat(p)) {
            event.setCancelled(true);
            sendAllyMessage(p, event.getMessage());
        } else {
            event.setFormat(essentials.getUser(p.getUniqueId()).getNickname() + ChatColor.WHITE + ": " + event.getMessage());



            /*
            ByteArrayDataOutput out = ByteStreams.newDataOutput();
            out.writeUTF("Server");

            JSONObject dataObject = new JSONObject();
            dataObject.put("message", event.getMessage());
            dataObject.put("category", "chat");
            dataObject.put("playerName", p.getName());

            out.writeUTF(dataObject.toJSONString());

            if (p != null) {
                p.sendPluginMessage(lifestealSmp, "BungeeCord", out.toByteArray());
            }*/
        }
    }


}
