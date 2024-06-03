package newamazingpvp.lifestealsmp.discord;

import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import org.bukkit.OfflinePlayer;
import org.bukkit.Statistic;

import java.awt.*;

import static newamazingpvp.lifestealsmp.LifestealSMP.lifestealSmp;
import static newamazingpvp.lifestealsmp.discord.DiscordBot.sendDiscordEmbedStats;

public class Stats extends ListenerAdapter {
    @Override
    public void onMessageReceived(MessageReceivedEvent event) {
        if (event.getAuthor().isBot() || event.isWebhookMessage()) {
            return;
        }
        String messageContent = event.getMessage().getContentRaw();
        if (messageContent.startsWith("!stats ")) {
            String playerName = messageContent.substring("!stats ".length());
            OfflinePlayer fPlayer = lifestealSmp.getServer().getOfflinePlayer(playerName);
            int kills = fPlayer.getStatistic(Statistic.PLAYER_KILLS);
            int deaths = fPlayer.getStatistic(Statistic.DEATHS);
            //int walk = fPlayer.getStatistic(Statistic.WALK_ONE_CM) / 100;
            //int swim = fPlayer.getStatistic(Statistic.SWIM_ONE_CM) / 100;
            int walk = fPlayer.getStatistic(Statistic.WALK_ONE_CM);
            int swim = fPlayer.getStatistic(Statistic.SWIM_ONE_CM);
            int fly = fPlayer.getStatistic(Statistic.FLY_ONE_CM);
            int aviate = fPlayer.getStatistic(Statistic.AVIATE_ONE_CM);
            int boat = fPlayer.getStatistic(Statistic.BOAT_ONE_CM);
            int climb = fPlayer.getStatistic(Statistic.CLIMB_ONE_CM);
            int crouch = fPlayer.getStatistic(Statistic.CROUCH_ONE_CM);
            int fall = fPlayer.getStatistic(Statistic.FALL_ONE_CM);
            int horse = fPlayer.getStatistic(Statistic.HORSE_ONE_CM);
            int minecart = fPlayer.getStatistic(Statistic.MINECART_ONE_CM);
            int pig = fPlayer.getStatistic(Statistic.PIG_ONE_CM);
            int sprint = fPlayer.getStatistic(Statistic.SPRINT_ONE_CM);
            int strider = fPlayer.getStatistic(Statistic.STRIDER_ONE_CM);
            int under = fPlayer.getStatistic(Statistic.WALK_ON_WATER_ONE_CM);
            int over = fPlayer.getStatistic(Statistic.FLY_ONE_CM);
            int final1 = (walk + swim + fly + aviate + boat + climb + crouch + fall + horse + minecart + pig + sprint + strider + under + over) / 100;
            int dealt = fPlayer.getStatistic(Statistic.DAMAGE_DEALT) / 10;
            int absorbed = fPlayer.getStatistic(Statistic.DAMAGE_TAKEN) / 10;
            int playTime = fPlayer.getStatistic(Statistic.PLAY_ONE_MINUTE);
            int play = playTime / 20;
            int hours = play / 3600;
            int mins = (play % 3600) / 60;
            int seconds = play % 60;
            double kdr = (double) kills / deaths;
            String kd = String.format("%.2f", kdr);
            double dar = (double) dealt / absorbed;
            double deal = (double) dealt / 2.0;
            //Player p = (Player) fPlayer;
            /*sendDiscordEmbedTitle("Kills: " + kills + "\nDeaths: " +
                    deaths + "\nKill/Death Ratio: " + kdr + "\nDistance travelled: " + walk
                    + "\nDistance Swam: " + swim + "\nDamage Dealt: " + dealt +
                    "\nDamage Absorbed: " + absorbed + "\nDealt/Absorbed Ratio: " + dar +
                     "\n Time Played: " + hours + " hours " + mins + " minutes", Color.BLUE, event.getChannel().getId());*/
            sendDiscordEmbedStats("Kills: " + kills + " ⚔️\nDeaths: " +
                    deaths + "\nK/D: " + kd + "\nTotal Distance: " + final1
                    + " blocks\nDamage Dealt: " + deal +
                    "❤️\nTime Played: " + hours + " hours " + mins + " minutes", Color.BLUE, event.getChannel().getId(), playerName);
        }
    }
}
