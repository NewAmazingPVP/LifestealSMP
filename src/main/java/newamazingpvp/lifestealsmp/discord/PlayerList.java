package newamazingpvp.lifestealsmp.discord;

import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

public class PlayerList extends ListenerAdapter {
    @Override
    public void onMessageReceived(MessageReceivedEvent event) {
        if (event.getAuthor().isBot()) {
            return;
        }
        String messageContent = event.getMessage().getContentRaw();
        if (messageContent.equalsIgnoreCase("playerlist")) {
            StringBuilder s = new StringBuilder("```\n");
            for(Player p: Bukkit.getOnlinePlayers()){
                s.append(p.getName()).append(", ");
            }
            s.delete(s.length() -2, s.length());
            s.append("\n```");
            event.getChannel().sendMessage(s).queue();
        }
    }
}
