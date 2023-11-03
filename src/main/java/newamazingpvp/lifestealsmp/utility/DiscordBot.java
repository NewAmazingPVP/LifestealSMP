package newamazingpvp.lifestealsmp.utility;

import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.entities.channel.concrete.TextChannel;
import newamazingpvp.lifestealsmp.dccommands.Stats;
import org.bukkit.scheduler.BukkitRunnable;

import java.awt.*;

import static newamazingpvp.lifestealsmp.LifestealSMP.lifestealSmp;

public class DiscordBot {
    public static JDA jda;
    public static TextChannel channel;

    public static void intializeBot() {
        String token = lifestealSmp.getConfig().getString("Discord.BotToken");
        String channelId = lifestealSmp.getConfig().getString("Discord.Channel");
        jda = JDABuilder.createDefault(token).build();
        jda.addEventListener((new Stats()));
        new BukkitRunnable() {
            @Override
            public void run() {
                channel = jda.getTextChannelById(channelId);
                /*if (channel != null) {
                    channel.sendMessage("Hi test").queue();
                } else {
                    getLogger().warning("Discord channel not found!");
                }*/
            }
        }.runTaskLater(lifestealSmp, 100);
    }

    public static void sendDiscordMessage(String msg, String channelID) {
        if (channelID.isEmpty()) {
            channel.sendMessage(msg);
        } else {
            TextChannel tempChannel = jda.getTextChannelById(channelID);
            if (tempChannel != null) {
                tempChannel.sendMessage(msg).queue();
            }
        }
    }

    public static void sendDiscordEmbedTitle(String msg, Color c, String channelID) {
        EmbedBuilder eb = new EmbedBuilder();
        eb.setTitle(msg);
        eb.setColor(c);
        if (channelID.isEmpty()) {
            channel.sendMessageEmbeds(eb.build()).queue();
        } else {
            TextChannel tempChannel = jda.getTextChannelById(channelID);
            if (tempChannel != null) {
                tempChannel.sendMessageEmbeds(eb.build()).queue();
            }
        }
    }

    public static void sendDiscordEmbedPlayer(String msg, Color c, String channelID, String p) {
        p = "https://minotar.net/helm/" + p;
        EmbedBuilder eb = new EmbedBuilder();
        eb.setAuthor(msg, "https://you.net", p);
        eb.setColor(c);
        if (channelID.isEmpty()) {
            channel.sendMessageEmbeds(eb.build()).queue();
        } else {
            TextChannel tempChannel = jda.getTextChannelById(channelID);
            if (tempChannel != null) {
                tempChannel.sendMessageEmbeds(eb.build()).queue();
            }
        }
    }

}
