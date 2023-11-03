package newamazingpvp.lifestealsmp.dccommands;

import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import org.bukkit.OfflinePlayer;
import org.bukkit.Statistic;
import org.bukkit.entity.Player;

import java.awt.*;

import static newamazingpvp.lifestealsmp.LifestealSMP.lifestealSmp;
import static newamazingpvp.lifestealsmp.utility.DiscordBot.sendDiscordEmbedTitle;

public class Stats extends ListenerAdapter {
    @Override
    public void onMessageReceived(MessageReceivedEvent event) {
        if (event.getAuthor().isBot()) {
            return;
        }
        String messageContent = event.getMessage().getContentRaw();
        if (messageContent.startsWith("!stats ")) {
            String playerName = messageContent.substring("!stats ".length());
            System.out.println("Player Name: " + playerName);
            OfflinePlayer fPlayer = lifestealSmp.getServer().getOfflinePlayer(playerName);
            int kills = fPlayer.getStatistic(Statistic.PLAYER_KILLS);
            int deaths = fPlayer.getStatistic(Statistic.DEATHS);
            int walk = fPlayer.getStatistic(Statistic.WALK_ONE_CM);
            int swim = fPlayer.getStatistic(Statistic.SWIM_ONE_CM);
            int dealt = fPlayer.getStatistic(Statistic.DAMAGE_DEALT);
            int absorbed = fPlayer.getStatistic(Statistic.DAMAGE_ABSORBED);
            int playTime = fPlayer.getStatistic(Statistic.PLAY_ONE_MINUTE);
            int hours = playTime / 3600;
            int mins = (playTime % 3600) / 60;
            int seconds = playTime % 60;
            double kdr = (double) kills / deaths;
            double dar = (double) dealt / absorbed;
            Player p = (Player) fPlayer;
            sendDiscordEmbedTitle("Kills: " + kills + "\nDeaths: " +
                    deaths + "\nKill/Death Ratio: " + kdr + "\nDistance travelled: " + walk
                    + "\nDistance Swam: " + swim + "\nDamage Dealt: " + dealt +
                    "\nDamage Absorbed: " + absorbed + "\nDealt/Absorbed Ratio: " + dar + "\nHearts: " +
                    p.getMaxHealth() + "\n Time Played: " + hours + " hours " + mins + " minutes", Color.BLUE, event.getChannel().getId());
        }
    }
}
