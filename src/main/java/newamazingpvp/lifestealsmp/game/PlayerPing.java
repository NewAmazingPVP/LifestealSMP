package newamazingpvp.lifestealsmp.game;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;

import java.awt.*;
import java.util.HashMap;
import java.util.Map;

import static newamazingpvp.lifestealsmp.game.CombatLog.cancelCombatData;
import static newamazingpvp.lifestealsmp.game.CombatLog.isInCombat;
import static newamazingpvp.lifestealsmp.utility.DiscordBot.sendDiscordEmbedPlayer;
import static org.bukkit.Bukkit.getServer;

public class PlayerPing {
    public static Map<Player, Integer> playerPingMap = new HashMap<>();
    private final String discordChannelId = "1136029534341312542";

    public static int getPlayerPing(Player player) {
        return player.getPing();
    }

    public static void monitorPlayerPings() {
        for (Player player : getServer().getOnlinePlayers()) {
            int currentPing = getPlayerPing(player);
            Integer lastPing = playerPingMap.get(player);

            if (lastPing != null) {
                double percentIncrease = (currentPing - lastPing) * 100.0 / lastPing;
                if (percentIncrease >= 50 && currentPing > 20 && !(lastPing < 2)) {
                    //String pingInfo = getPingModifier(percentIncrease) + player.getName() + "'s ping has increased by " + String.format("%.2f", percentIncrease) + "% to " + currentPing + " ms!!!";
                    String pingMessage = ChatColor.YELLOW + "Your ping has increased by " + ChatColor.RED + String.format("%.2f", percentIncrease) + "%" + ChatColor.YELLOW + "!!! Its recommended that you be careful as your client might lag";
                    player.sendMessage(pingMessage);
                    if (percentIncrease >= 75) {
                        player.sendMessage(pingMessage);
                    }
                    if (percentIncrease >= 100) {
                        player.sendMessage(pingMessage + " and maybe anticheat can false detect you");
                        player.sendMessage(pingMessage + " and maybe anticheat can false detect you");
                    }
                    //TextChannel channel = jda.getTextChannelById(discordChannelId);
                    //if (channel != null) {
                    //    channel.sendMessage(pingInfo).queue();
                    //} else {
                    //    getLogger().warning("Discord channel not found!");
                    //}
                }
                if (player.getPing() > 999) {
                    if (isInCombat(player)) {
                        cancelCombatData(player);
                        sendDiscordEmbedPlayer("High ping during combat! Untagging player and kicking them!", Color.RED, "", player.getName());
                    }
                    player.kickPlayer(ChatColor.RED + "Your ping is too high! You are disconnected for your own safety!");
                    String s = player.getName() + " got kicked for high ping! NO PING SPOOFING!!!";
                    getServer().broadcastMessage(s);
                    sendDiscordEmbedPlayer(s, Color.RED, "", player.getName());
                }
            }
            playerPingMap.put(player, currentPing);
        }
    }
}
