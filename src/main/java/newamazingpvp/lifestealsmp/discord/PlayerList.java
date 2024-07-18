package newamazingpvp.lifestealsmp.discord;

import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.List;

import static newamazingpvp.lifestealsmp.LifestealSMP.isSmp;
import static newamazingpvp.lifestealsmp.discord.DiscordListener.isVanished;
import static newamazingpvp.lifestealsmp.events.TimeManager.*;

public class PlayerList extends ListenerAdapter {
    @Override
    public void onMessageReceived(MessageReceivedEvent event) {
        if (event.getAuthor().isBot() || event.isWebhookMessage()) {
            return;
        }
        if (!isSmp) return;

        String messageContent = event.getMessage().getContentRaw();
        if (messageContent.equalsIgnoreCase("playerlist")) {
            if(!isTimePassed(SEASON_START_TIME)){
                event.getChannel().sendMessage("Next season opening in " + formatDuration(SEASON_START_TIME)).queue();
                return;
            }
            List<String> playerNames = new ArrayList<>();
            int size = 0;

            for (Player p : Bukkit.getOnlinePlayers()) {
                if (isVanished(p)) continue;
                playerNames.add(p.getName());
                size++;
            }

            if (size > 0) {
                String playerList = String.join(", ", playerNames);
                String message = String.format("**Online players: %d**\n```\n%s\n```", size, playerList);
                event.getChannel().sendMessage(message).queue();
            } else {
                event.getChannel().sendMessage("No players online.").queue();
            }
        }
    }
}
