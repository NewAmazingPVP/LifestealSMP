package newamazingpvp.lifestealsmp.util;

import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.entities.TextChannel;
import net.dv8tion.jda.api.entities.Webhook;

import javax.security.auth.login.LoginException;

public class DiscordBot {
    private JDA jda;

public DiscordBot() throws LoginException {
    jda = JDABuilder.createDefault("").build();
    TextChannel channel = jda.getTextChannelById("");
    channel.sendMessage("Lmfao noob");
    Webhook lol = (Webhook) jda.retrieveWebhookById("lol");

}
}
