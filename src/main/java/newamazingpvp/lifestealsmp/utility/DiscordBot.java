package newamazingpvp.lifestealsmp.utility;

import club.minnced.discord.webhook.WebhookClient;
import club.minnced.discord.webhook.WebhookClientBuilder;
import club.minnced.discord.webhook.send.WebhookMessageBuilder;
import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.entities.channel.concrete.TextChannel;
import net.dv8tion.jda.api.requests.GatewayIntent;
import newamazingpvp.lifestealsmp.discord.MessageEvent;
import newamazingpvp.lifestealsmp.discord.PlayerList;
import newamazingpvp.lifestealsmp.discord.Stats;
import newamazingpvp.lifestealsmp.discord.Status;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;

import java.awt.*;
import java.util.EnumSet;

import static newamazingpvp.lifestealsmp.LifestealSMP.lifestealSmp;

public class DiscordBot {
    public static JDA jda;
    public static TextChannel channel;
    public static WebhookClient client;

    public static void intializeBot() {
        String token = lifestealSmp.getConfig().getString("Discord.BotToken");
        String channelId = lifestealSmp.getConfig().getString("Discord.Channel");
        EnumSet<GatewayIntent> allIntents = EnumSet.allOf(GatewayIntent.class);

        JDABuilder jdaBuilder = JDABuilder.createDefault(token);
        jdaBuilder.enableIntents(allIntents);
        jda = jdaBuilder.build();
        jda.addEventListener((new Stats()));
        jda.addEventListener((new PlayerList()));
        jda.addEventListener((new MessageEvent()));
        //jda.addEventListener((new Status()));
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

    public static void sendDiscordEmbedStats(String msg, Color c, String channelID, String name) {
        EmbedBuilder eb = new EmbedBuilder();
        eb.setTitle(msg);
        eb.setColor(c);
        eb.setThumbnail("https://minotar.net/armor/body/" + name + "/100.png");
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
        eb.setAuthor(msg, "https://shop.nappixel.tk/", p);
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
    public static void webHookClient(){
        WebhookClientBuilder builder = new WebhookClientBuilder(lifestealSmp.getConfig().getString("Discord.Webhook"));
        builder.setThreadFactory((job) -> {
            Thread thread = new Thread(job);
            thread.setName("E");
            thread.setDaemon(true);
            return thread;
        });
        builder.setWait(true);
        client = builder.build();
    }

    public static void sendWebhook(Player p, String msg){
        String avatar = "https://minotar.net/helm/" + p.getName();
        WebhookMessageBuilder builder = new WebhookMessageBuilder();
        builder.setUsername(p.getName());
        builder.setAvatarUrl(avatar);
        builder.setContent(msg);
        client.send(builder.build());
    }


}
