package newamazingpvp.lifestealsmp.discord;

import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import org.bukkit.Bukkit;

import static newamazingpvp.lifestealsmp.LifestealSMP.*;
import static newamazingpvp.lifestealsmp.discord.DiscordBot.consoleChannel;
import static org.bukkit.Bukkit.getServer;

public class ConsoleCommand extends ListenerAdapter {
    @Override
    public void onMessageReceived(MessageReceivedEvent event) {
        if (event.getAuthor().isBot() || event.isWebhookMessage()) {
            return;
        }
        if (!event.getChannel().getId().equals(consoleChannel)) return;
        String messageContent = event.getMessage().getContentRaw();
        Bukkit.getScheduler().runTask(lifestealSmp, () -> {
            getServer().dispatchCommand(getServer().getConsoleSender(), messageContent);
        });
        if (messageContent.toLowerCase().contains("silent")) {
            silentMode = !silentMode;
        }
        if (messageContent.toLowerCase().contains("unbanchunkban")) {
            unbanChunkBan = !unbanChunkBan;
        }
    }
}
