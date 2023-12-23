package newamazingpvp.lifestealsmp.utility;

import net.dv8tion.jda.api.entities.channel.concrete.TextChannel;
import org.apache.logging.log4j.core.LogEvent;
import org.apache.logging.log4j.core.appender.AbstractAppender;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import static newamazingpvp.lifestealsmp.LifestealSMP.lifestealSmp;
import static newamazingpvp.lifestealsmp.utility.DiscordBot.jda;

public class LogAppender extends AbstractAppender {

    private SimpleDateFormat formatter;
    private static Map<String, String> discordMessageIds = new HashMap<>();
    String consoleChannel = lifestealSmp.getConfig().getString("Discord.ConsoleChannel");

    public LogAppender() {
        super("MyLogAppender", null, null);
        formatter = new SimpleDateFormat("[E yyyy.MM.dd HH:mm:ss]");
        start();
    }

    @Override
    public void append(LogEvent event) {
        LogEvent log = event.toImmutable();
        String message = log.getMessage().getFormattedMessage();
        sendDiscordMessage(getFormattedLogMessage(message), consoleChannel);
    }

    private String getFormattedLogMessage(String message) {
        Date now = new Date();
        return formatter.format(now) + " " + message.replaceAll("\n", "");
    }

    public void sendDiscordMessage(String msg, String channelID) {
        if (channelID.isEmpty()) {
            // channel.sendMessage(msg);
        } else {
            TextChannel tempChannel = jda.getTextChannelById(channelID);
            if (tempChannel != null) {

                if (discordMessageIds.containsKey(channelID)) {
                    String oldMessageId = discordMessageIds.get(channelID);

                    String oldMessageContent = tempChannel.retrieveMessageById(oldMessageId).complete().getContentRaw();

                    oldMessageContent = oldMessageContent.replaceAll("```", "");

                    if (oldMessageContent.length() >= 1998 || oldMessageContent.length() + msg.length() >= 1998) {
                        tempChannel.sendMessage("```\n" + msg + "\n```").queue(message -> {
                            discordMessageIds.put(channelID, message.getId());
                        });
                    } else {
                        String newMessage = "```\n" + oldMessageContent + msg + "\n```";

                        tempChannel.editMessageById(oldMessageId, newMessage).queue();
                    }
                } else {
                    tempChannel.sendMessage("```\n" + msg + "\n```").queue(message -> {
                        discordMessageIds.put(channelID, message.getId());
                    });
                }
            }
        }
    }
}
