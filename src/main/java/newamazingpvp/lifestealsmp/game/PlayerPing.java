package newamazingpvp.lifestealsmp.game;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;

import java.util.HashMap;
import java.util.Map;

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
            }
            playerPingMap.put(player, currentPing);
        }
    }
}
