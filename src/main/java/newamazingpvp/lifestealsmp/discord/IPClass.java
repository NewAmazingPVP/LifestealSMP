package newamazingpvp.lifestealsmp.discord;

import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import org.bukkit.event.Listener;

import static newamazingpvp.lifestealsmp.utility.DiscordBot.sendDiscordMessage;

public class IPClass extends ListenerAdapter {
    public void onMessageReceived(MessageReceivedEvent event) {
        if (event.getAuthor().isBot() || event.isWebhookMessage()) {
            return;
        }
        String messageContent = event.getMessage().getContentRaw();
        if (messageContent.startsWith("!ip")) {
            sendDiscordMessage("**JAVA:** join.NapPixel.tk\n**BEDROCK:** join.NapPixel.tk", event.getChannel().getId());
        }
    }
}
