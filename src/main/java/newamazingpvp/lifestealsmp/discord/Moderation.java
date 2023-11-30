package newamazingpvp.lifestealsmp.discord;

import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

import static newamazingpvp.lifestealsmp.listener.ChatFilter.censorBlacklistedWords;
import static newamazingpvp.lifestealsmp.utility.DiscordBot.sendDiscordMessage;

public class Moderation extends ListenerAdapter {
    @Override
    public void onMessageReceived(MessageReceivedEvent event) {
        String messageContent = event.getMessage().getContentRaw();
        String censoredMessage = censorBlacklistedWords(messageContent);
        if (!messageContent.equals(censoredMessage)) {
            event.getMessage().delete();
            sendDiscordMessage(event.getAuthor().getName() + "tried saying something bad. Here is the moderated language **" + messageContent + "**", "1019965981025652738");
        }}
}