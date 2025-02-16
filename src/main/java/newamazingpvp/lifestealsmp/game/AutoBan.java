package newamazingpvp.lifestealsmp.game;

import newamazingpvp.lifestealsmp.utility.DataBaseHelper;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerKickEvent;

import java.util.List;
import java.util.Map;

import static newamazingpvp.lifestealsmp.LifestealSMP.lifestealSmp;

public class AutoBan implements Listener {
    public static final DataBaseHelper maceDb;
    static {
        maceDb = new DataBaseHelper("autoban.db");
        maceDb.createTable("player_data", "player_uuid TEXT PRIMARY KEY, ban_count INTEGER");
    }

    @EventHandler
    public void onPlayerKick(PlayerKickEvent event) {
        String reason = event.getReason();
        if (!reason.toLowerCase().contains("was punished")) {
            return;
        }

        String playerUuid = event.getPlayer().getUniqueId().toString();
        String playerName = event.getPlayer().getName();
        int banCount;

        List<Map<String, Object>> data = maceDb.getData("player_data", "player_uuid = ?", playerUuid);
        if (data.isEmpty()) {
            maceDb.insertData("player_data", new String[]{"player_uuid", "ban_count"}, playerUuid, 1);
            banCount = 1;
        } else {
            banCount = (int) data.get(0).get("ban_count") + 1;
            maceDb.updateData("player_data", Map.of("ban_count", banCount), "player_uuid = ?", playerUuid);
        }

        if (banCount >= 2) {
            lifestealSmp.getServer().dispatchCommand(lifestealSmp.getServer().getConsoleSender(), "betterban " + playerName);
        }
    }
}
