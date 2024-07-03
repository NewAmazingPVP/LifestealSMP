package newamazingpvp.lifestealsmp.discord;

import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

import static newamazingpvp.lifestealsmp.discord.DiscordBot.sendDiscordMessage;

public class IPClass extends ListenerAdapter {
    public void onMessageReceived(MessageReceivedEvent event) {
        if (event.getAuthor().isBot() || event.isWebhookMessage()) {
            return;
        }
        String messageContent = event.getMessage().getContentRaw();
        if (messageContent.startsWith("!ip")) {
            sendDiscordMessage("**JAVA:** NapPixel.tk Port: 25565\n**BEDROCK:** NapPixel.tk Port: 19132", event.getChannel().getId());
        }
    }
}
