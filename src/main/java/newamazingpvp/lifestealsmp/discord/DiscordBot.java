package newamazingpvp.lifestealsmp.discord;

import club.minnced.discord.webhook.WebhookClient;
import club.minnced.discord.webhook.WebhookClientBuilder;
import club.minnced.discord.webhook.send.WebhookMessageBuilder;
import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.entities.channel.concrete.NewsChannel;
import net.dv8tion.jda.api.entities.channel.concrete.TextChannel;
import net.dv8tion.jda.api.requests.GatewayIntent;
import newamazingpvp.lifestealsmp.events.TimeManager;
import newamazingpvp.lifestealsmp.utility.CooldownManager;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;

import java.awt.*;
import java.util.EnumSet;

import static newamazingpvp.lifestealsmp.LifestealSMP.lifestealSmp;
import static newamazingpvp.lifestealsmp.events.TimeManager.eventRole;

public class DiscordBot {
    public static JDA jda;
    public static TextChannel channel;
    public static WebhookClient client;
    public static String channelId;
    private static final CooldownManager eventRoleCooldown = new CooldownManager();
    private static final CooldownManager mcServerCooldown = new CooldownManager();

    public static String consoleChannel = lifestealSmp.getConfig().getString("Discord.ConsoleChannel");

    public static void intializeBot() {
        String token = lifestealSmp.getConfig().getString("Discord.BotToken");
        channelId = lifestealSmp.getConfig().getString("Discord.Channel");
        EnumSet<GatewayIntent> allIntents = EnumSet.allOf(GatewayIntent.class);

        JDABuilder jdaBuilder = JDABuilder.createDefault(token);
        jdaBuilder.enableIntents(allIntents);
        jda = jdaBuilder.build();
        jda.updateCommands().addCommands(Stats.getSlashCommandData()).queue();
        jda.addEventListener((new Stats()));
        jda.addEventListener((new PlayerList()));
        jda.addEventListener((new MessageEvent()));
        jda.addEventListener((new Status()));
        jda.addEventListener((new ConsoleCommand()));
        jda.addEventListener((new IPClass()));
        jda.addEventListener((new Moderation()));
        new BukkitRunnable() {
            @Override
            public void run() {
                if (jda.getTextChannelById(channelId) != null) {
                    channel = jda.getTextChannelById(channelId);
                    sendDiscordEmbedTitle("Bot intialized", Color.MAGENTA, "");
                    sendDiscordMessage("The server has started✅", "");
                    this.cancel();
                }
            }
        }.runTaskTimer(lifestealSmp, 0, 1);
    }

    public static void sendDiscordMessage(String msg, String channelID) {
        if (jda == null) return;
        if (channelID.isEmpty()) {
            channel.sendMessage(msg);
        } else {
            TextChannel tempChannel = jda.getTextChannelById(channelID);
            if (tempChannel != null) {
                tempChannel.sendMessage(msg).queue();
            }
        }
    }

    public static void sendDiscordNewsMessage(String msg, String channelID) {
        if (jda == null) return;
        if (msg.contains(eventRole) && !msg.contains(eventRole + " ⬆️")) {
            if (!eventRoleCooldown.isOnCooldown()) {
                eventRoleCooldown.setCooldown(30);
                if (!msg.toLowerCase().contains("10 minute") && !msg.toLowerCase().contains("5 hour")) {
                    Bukkit.getScheduler().runTaskLaterAsynchronously(lifestealSmp, () -> sendDiscordNewsMessage(eventRole + " ⬆️", ""), 30 * 20);
                }
            }
        }
        if (!msg.contains(eventRole + " ⬆️")) {
            msg = msg.replace(eventRole + " ", "");
        }
        String mcServer = TimeManager.mcServer;
        if (msg.contains(mcServer)) {
            if (mcServerCooldown.isOnCooldown()) {
                //msg = msg.replace(mcServer + " ", "");
                return;
            } else {
                mcServerCooldown.setCooldown(30);
            }
        }

        if (channelID.isEmpty()) {
            //channel.sendMessage(msg);
            NewsChannel tempChannel = jda.getNewsChannelById("1032411739351941120");
            if (tempChannel != null) {
                tempChannel.sendMessage(msg).queue();
            }
        } else {
            NewsChannel tempChannel = jda.getNewsChannelById(channelID);
            if (tempChannel != null) {
                tempChannel.sendMessage(msg).queue();
            }
        }
    }


    public static void sendDiscordEmbedTitle(String msg, Color c, String channelID) {
        if (jda == null) return;
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

    public static void sendDiscordNewsEmbedTitle(String msg, Color c, String channelID) {
        if (jda == null) return;
        EmbedBuilder eb = new EmbedBuilder();
        eb.setTitle(msg);
        eb.setColor(c);
        if (channelID.isEmpty()) {
            //channel.sendMessageEmbeds(eb.build()).queue();
            NewsChannel tempChannel = jda.getNewsChannelById("1032411739351941120");
            if (tempChannel != null) {
                tempChannel.sendMessageEmbeds(eb.build()).queue();
            }
        } else {
            NewsChannel tempChannel = jda.getNewsChannelById(channelID);
            if (tempChannel != null) {
                tempChannel.sendMessageEmbeds(eb.build()).queue();
            }
        }
    }

    public static void sendDiscordEmbedStats(String msg, Color c, String channelID, String name) {
        if (jda == null) return;
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
        if (jda == null) return;
        p = "https://minotar.net/helm/" + p;
        EmbedBuilder eb = new EmbedBuilder();
        eb.setAuthor(msg, "https://www.nappixel.tk/", p);
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

    public static void sendDiscordNewsEmbedPlayer(String msg, Color c, String channelID, String p) {
        if (jda == null) return;
        p = "https://minotar.net/helm/" + p;
        EmbedBuilder eb = new EmbedBuilder();
        eb.setAuthor(msg, "https://www.nappixel.tk/", p);
        eb.setColor(c);
        if (channelID.isEmpty()) {
            //channel.sendMessageEmbeds(eb.build()).queue();
            NewsChannel tempChannel = jda.getNewsChannelById("1032411739351941120");
            if (tempChannel != null) {
                tempChannel.sendMessageEmbeds(eb.build()).queue();
            }
        } else {
            NewsChannel tempChannel = jda.getNewsChannelById(channelID);
            if (tempChannel != null) {
                tempChannel.sendMessageEmbeds(eb.build()).queue();
            }
        }
    }

    public static void webHookClient() {
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

    public static void sendWebhook(Player p, String msg) {
        String avatar = "https://minotar.net/helm/" + p.getName();
        WebhookMessageBuilder builder = new WebhookMessageBuilder();
        builder.setUsername(p.getName());
        builder.setAvatarUrl(avatar);
        builder.setContent(msg);
        client.send(builder.build());
    }


}
