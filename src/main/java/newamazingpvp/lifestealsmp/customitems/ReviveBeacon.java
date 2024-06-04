package newamazingpvp.lifestealsmp.customitems;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.UUID;

import static newamazingpvp.lifestealsmp.game.PlayerLifeManager.revivePlayer;

public class ReviveBeacon implements Listener {

    private final ArrayList<UUID> lastInteractedPlayers = new ArrayList<>();

    @EventHandler
    public void onBeaconUse(PlayerInteractEvent e) {
        if (isReviveBeacon(e.getItem()) && (e.getAction() == Action.LEFT_CLICK_AIR ||
                e.getAction() == Action.LEFT_CLICK_BLOCK ||
                e.getAction() == Action.RIGHT_CLICK_AIR ||
                e.getAction() == Action.RIGHT_CLICK_BLOCK)) {
            e.setCancelled(true);
            Player p = e.getPlayer();
            p.sendMessage("Type the exact name of the player you want to revive! Make sure to put a \".\" in front of bedrock player names.");
            p.sendTitle(ChatColor.AQUA + "Check chat!", "Enter the player name in chat!");
            lastInteractedPlayers.add((p.getUniqueId()));
            e.getItem().setAmount(e.getItem().getAmount() - 1);
        }
    }

    private boolean isReviveBeacon(ItemStack item) {
        if (item != null && item.getType() == Material.BEACON) {
            ItemMeta meta = item.getItemMeta();
            return meta.getLore() != null && meta.getLore().toString().toLowerCase().contains("revive");
        }
        return false;
    }

    @EventHandler
    public void onPlayerChat(AsyncPlayerChatEvent e) throws SQLException, IOException {
        Player player = e.getPlayer();
        UUID playerUUID = player.getUniqueId();

        if (lastInteractedPlayers.contains(playerUUID)) {
            e.setCancelled(true);

            String revivedPlayerName = e.getMessage();

            if (revivePlayer(Bukkit.getOfflinePlayer(revivedPlayerName), player)) {
                lastInteractedPlayers.remove(playerUUID);
            }
        }
    }
}
