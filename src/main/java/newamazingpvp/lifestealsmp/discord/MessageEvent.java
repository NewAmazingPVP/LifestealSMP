package newamazingpvp.lifestealsmp.discord;

import net.dv8tion.jda.api.entities.Member;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import org.bukkit.ChatColor;

import static newamazingpvp.lifestealsmp.utility.DiscordBot.channelId;
import static org.bukkit.Bukkit.getServer;

public class MessageEvent extends ListenerAdapter {
    @Override
    public void onMessageReceived(MessageReceivedEvent event) {
        if (!event.getChannel().getId().equals(channelId) || event.getAuthor().isBot() || event.isWebhookMessage()) {
            return;
        }


        String message = event.getMessage().getContentRaw();

        Member member = event.getMember();
        String username = member != null ? member.getEffectiveName() : event.getAuthor().getName();

        String highestRole = member != null ? member.getRoles().get(0).getName() : "No Role";

        ChatColor discordColor = getChatColorFromDiscordColor(member != null ? member.getRoles().get(0).getColor().getRGB() : 0);

        getServer().broadcastMessage(ChatColor.AQUA + "[Discord | " + discordColor + highestRole + "] " + ChatColor.RESET + username + ": " + message);
    }

    private ChatColor getChatColorFromDiscordColor(int rgb) {
        ChatColor[] colors = ChatColor.values();
        return colors[Math.abs(rgb) % colors.length];
    }

}