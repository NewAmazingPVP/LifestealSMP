package newamazingpvp.lifestealsmp.discord;

import net.dv8tion.jda.api.entities.Message;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Sound;

import static newamazingpvp.lifestealsmp.LifestealSMP.lifestealSmp;
import static newamazingpvp.lifestealsmp.blacklistener.ChatFilter.*;
import static newamazingpvp.lifestealsmp.discord.DiscordBot.jda;
import static newamazingpvp.lifestealsmp.discord.DiscordBot.sendDiscordMessage;

public class Moderation extends ListenerAdapter {
    @Override
    public void onMessageReceived(MessageReceivedEvent event) {
        if (event.getAuthor().isBot()){
            return;
        }
        String messageContent = event.getMessage().getContentRaw();
        String censoredMessage = censorBlacklistedWords(messageContent);

        if (!messageContent.equals(censoredMessage)) {
            event.getMessage().delete().queue();
            sendDiscordMessage(event.getAuthor().getName() + "tried saying something bad. Here is the moderated language **" + messageContent + "**", "1019965981025652738");
        }
        if (isFlaggedByModeration(messageContent)) {
            event.getMessage().delete().queue();
            sendDiscordMessage(event.getAuthor().getName() + "tried saying something bad. Here is the moderated language **" + messageContent + "**", "1019965981025652738");
        }
        for (Message.Attachment attachment : event.getMessage().getAttachments()) {
            if (attachment.isImage() && isFlaggedByImageModeration(attachment.getUrl())) {
                event.getMessage().delete().queue();
                sendDiscordMessage(event.getAuthor().getName() + " tried sending a flagged image: " + attachment.getUrl(), "1019965981025652738");
                return;
            }
        }
    }
}