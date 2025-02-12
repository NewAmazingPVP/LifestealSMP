package newamazingpvp.lifestealsmp.discord;

import net.dv8tion.jda.api.entities.Message;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

import static newamazingpvp.lifestealsmp.blacklistener.ChatFilter.*;
import static newamazingpvp.lifestealsmp.discord.DiscordBot.sendDiscordMessage;

public class Moderation extends ListenerAdapter {
    @Override
    public void onMessageReceived(MessageReceivedEvent event) {
        if (event.getAuthor().isBot() || event.isWebhookMessage() || event.getAuthor().isSystem()){
            return;
        }
        String messageContent = event.getMessage().getContentRaw();
        String censoredMessage = censorBlacklistedWordsNonLinks(messageContent);
        if (shouldBeWarned(messageContent)) {
            sendDiscordMessage(event.getAuthor().getName() + " possibly tried saying something bad. Here is the flagged language " + messageContent, "1339042765425610803");
        }
        if (!messageContent.equals(censoredMessage)) {
            event.getMessage().delete().queue();
            sendDiscordMessage(event.getAuthor().getName() + " said something bad. Here is the moderated language **" + messageContent + "**", "1019965981025652738");
        }
        if (isFlaggedByModeration(messageContent)) {
            event.getMessage().delete().queue();
            sendDiscordMessage(event.getAuthor().getName() + " said something bad. Here is the moderated language **" + messageContent + "**", "1019965981025652738");
        }
        for (Message.Attachment attachment : event.getMessage().getAttachments()) {
            if (attachment.isImage() && isFlaggedByImageModeration(attachment.getUrl())) {
                event.getMessage().delete().queue();
                sendDiscordMessage(event.getAuthor().getName() + " tried sending a flagged image: " + attachment.getUrl(), "1019965981025652738");
                return;
            }
            if (attachment.isVideo() || attachment.isImage()){
                if (attachment.getFileExtension() != null && attachment.getFileExtension().equalsIgnoreCase("gif")) {
                    // add gif/video moderation if we need it
                    // we can use JCodec, TwelveMonkeys ImageIO, or GifDecoder/Encoder
                }
            }
        }
    }
}