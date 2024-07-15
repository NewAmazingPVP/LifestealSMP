package newamazingpvp.lifestealsmp.allyteams;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

import java.util.concurrent.ConcurrentHashMap;

import static newamazingpvp.lifestealsmp.LifestealSMP.essentials;
import static newamazingpvp.lifestealsmp.allyteams.AlliesManager.isPlayerInAllyChat;
import static newamazingpvp.lifestealsmp.allyteams.AlliesManager.sendAllyMessage;
import static newamazingpvp.lifestealsmp.allyteams.TeamsManager.isPlayerInTeamChat;
import static newamazingpvp.lifestealsmp.allyteams.TeamsManager.sendTeamMessage;

public class TeamListener implements Listener {
    private final ConcurrentHashMap<Player, String> avoidSpamMessage = new ConcurrentHashMap<>();
    private final ConcurrentHashMap<Player, Long> avoidSpamTimestamp = new ConcurrentHashMap<>();

    @EventHandler(priority = EventPriority.LOW)
    public void teamChatEvent(AsyncPlayerChatEvent event) {
        Player p = event.getPlayer();
        if (isPlayerInTeamChat(p)) {
            event.setCancelled(true);
            sendTeamMessage(p, event.getMessage());
        } else if (isPlayerInAllyChat(p)) {
            event.setCancelled(true);
            sendAllyMessage(p, event.getMessage());
        } else {
            if (!potentialSpam(p, event.getMessage())) {
                if (essentials.getUser(p.getUniqueId()).getNickname() != null) {
                    event.setFormat(essentials.getUser(p.getUniqueId()).getNickname() + ChatColor.WHITE + ": " + event.getMessage());
                }
                avoidSpamMessage.put(p, event.getMessage());
                avoidSpamTimestamp.put(p, System.currentTimeMillis());
            } else {
                event.setCancelled(true);
                p.sendMessage(ChatColor.RED + "Potential spam detected! Do /rules");
            }
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

    public boolean potentialSpam(Player p, String s) {
        String lastMessage = avoidSpamMessage.get(p);
        if (lastMessage == null || !lastMessage.equalsIgnoreCase(s)) return false;
        long lastMessageTime = avoidSpamTimestamp.get(p);
        return (System.currentTimeMillis() - lastMessageTime) < 2000;
    }
}
