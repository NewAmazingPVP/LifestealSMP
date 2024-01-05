package newamazingpvp.lifestealsmp.discord;

import net.dv8tion.jda.api.entities.Member;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import net.md_5.bungee.api.ChatColor;

import static newamazingpvp.lifestealsmp.LifestealSMP.lifestealSmp;
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

        net.md_5.bungee.api.ChatColor rolecolor;
        if(member.getRoles().get(0).getColor() != null) {
            rolecolor = net.md_5.bungee.api.ChatColor.of("#" + Integer.toHexString(member.getRoles().get(0).getColor().getRGB()).substring(2));
        }
        else {
            rolecolor = ChatColor.WHITE;
        }


        lifestealSmp.getServer().broadcastMessage(net.md_5.bungee.api.ChatColor.AQUA + "[Discord | " + rolecolor + highestRole + "] " + net.md_5.bungee.api.ChatColor.RESET + username + ": " + message);
    }

}
