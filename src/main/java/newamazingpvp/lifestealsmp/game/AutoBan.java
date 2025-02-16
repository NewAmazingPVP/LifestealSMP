package newamazingpvp.lifestealsmp.game;

import newamazingpvp.lifestealsmp.utility.DataBaseHelper;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerKickEvent;

import java.util.List;
import java.util.Map;

import static newamazingpvp.lifestealsmp.LifestealSMP.lifestealSmp;

public class AutoBan implements Listener {
    public static final DataBaseHelper autoBanDb;
    static {
        autoBanDb = new DataBaseHelper("autoban.db");
        autoBanDb.createTable("player_data", "player_uuid TEXT PRIMARY KEY, ban_count INTEGER, first_kick INTEGER");
    }

    @EventHandler
    public void onPlayerKick(PlayerKickEvent event) {
        String reason = event.getReason();
        if (!reason.toLowerCase().contains("hacking")) {
            return;
        }

        String playerUuid = event.getPlayer().getUniqueId().toString();
        String playerName = event.getPlayer().getName();
        long currentTime = System.currentTimeMillis();
        final long THREE_DAYS = 3 * 24 * 60 * 60 * 1000L;

        List<Map<String, Object>> data = autoBanDb.getData("player_data", "player_uuid = ?", playerUuid);
        int banCount;
        long firstKickTime;

        if (data.isEmpty()) {
            autoBanDb.insertData("player_data", new String[]{"player_uuid", "ban_count", "first_kick"}, playerUuid, 1, currentTime);
            banCount = 1;
            firstKickTime = currentTime;
        } else {
            Map<String, Object> playerData = data.get(0);
            banCount = (int) playerData.get("ban_count");
            firstKickTime = (long) playerData.get("first_kick");

            if (currentTime - firstKickTime > THREE_DAYS) {
                banCount = 1;
                firstKickTime = currentTime;
            } else {
                banCount++;
            }
            autoBanDb.updateData("player_data", Map.of("ban_count", banCount, "first_kick", firstKickTime), "player_uuid = ?", playerUuid);
        }

        if (banCount >= 2 && (currentTime - firstKickTime) <= THREE_DAYS) {
            lifestealSmp.getServer().dispatchCommand(lifestealSmp.getServer().getConsoleSender(), "betterban " + playerName);
        }
    }
}
