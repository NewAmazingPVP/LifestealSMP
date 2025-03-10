package newamazingpvp.lifestealsmp.blacklistener;

import org.bukkit.Bukkit;
import org.bukkit.Chunk;
import org.bukkit.block.BlockState;
import org.bukkit.block.Container;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Item;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.PlayerInventory;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import static newamazingpvp.lifestealsmp.LifestealSMP.unbanChunkBan;
import static newamazingpvp.lifestealsmp.discord.DiscordBot.sendDiscordMessage;

public class AntiChunkBan implements Listener {
    private static final Logger logger = Bukkit.getLogger();

    private static final int MAX_INVENTORY_ITEM_METADATA = 10240;
    private static final int MAX_BLOCK_METADATA = 51200;
    private static final int MAX_GROUND_ITEM_METADATA = 10240;

    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent event) {
        Player player = event.getPlayer();
        // doing this to reduce spam and save performance, and nobody really gets chunk banned i mean yes but we can type "unbanchunkban" cmd in disc to unban them
        if (unbanChunkBan) {

            cleanPlayerInventory(player);

            cleanContainersAroundPlayer(player);

            cleanGroundItemsAroundPlayer(player);
        }
    }

    private void cleanPlayerInventory(Player player) {
        PlayerInventory inventory = player.getInventory();
        for (ItemStack item : inventory.getContents()) {
            if (item != null && hasExcessiveMetadata(item, MAX_INVENTORY_ITEM_METADATA)) {
                if (unbanChunkBan) {
                    inventory.remove(item);
                    sendDiscordMessage(player.getName() + " chunk ban item removed", "1136353329488875531");
                }
                sendDiscordMessage(player.getName() + " might possibly have a chunk ban item", "1136353329488875531");
            }
        }
    }

    private void cleanContainersAroundPlayer(Player player) {
        List<Chunk> playerChunks = getChunksAroundPlayer(player);
        for (Chunk chunk : playerChunks) {
            for (BlockState blockState : chunk.getTileEntities()) {
                if (blockState instanceof Container container) {
                    cleanContainer(container, player);
                }
            }
        }
    }

    private void cleanContainer(Container container, Player player) {
        Inventory inventory = container.getInventory();
        for (ItemStack item : inventory.getContents()) {
            if (item != null && hasExcessiveMetadata(item, MAX_BLOCK_METADATA / inventory.getSize())) {
                if (unbanChunkBan) {
                    inventory.remove(item);
                    sendDiscordMessage(player.getName() + " is now freed from chunk ban. Removed item with excessive metadata from container at " + container.getLocation(), "1136353329488875531");
                }
                sendDiscordMessage(player.getName() + " might possibly be surrounded by chunk ban container", "1136353329488875531");
            }
        }
    }

    private void cleanGroundItemsAroundPlayer(Player player) {
        for (Entity entity : player.getWorld().getNearbyEntities(player.getLocation(), Bukkit.getServer().getViewDistance() * 16, 256, Bukkit.getServer().getViewDistance() * 16)) {
            if (entity instanceof Item groundItem) {
                if (hasExcessiveMetadata(groundItem.getItemStack(), MAX_GROUND_ITEM_METADATA)) {
                    if (unbanChunkBan) {
                        groundItem.remove();
                        sendDiscordMessage(player.getName() + " is now free from chunk ban items on ground. Removed ground item with excessive metadata at location: " + groundItem.getLocation(), "1136353329488875531");
                    }
                    sendDiscordMessage(player.getName() + " might possibly be surrounded by chunk ban items on ground", "1136353329488875531");
                }
            }
        }
    }

    private List<Chunk> getChunksAroundPlayer(Player player) {
        List<Chunk> chunks = new ArrayList<>();
        Chunk currentChunk = player.getLocation().getChunk();
        int viewDistance = Bukkit.getServer().getViewDistance();

        for (int x = currentChunk.getX() - viewDistance; x <= currentChunk.getX() + viewDistance; x++) {
            for (int z = currentChunk.getZ() - viewDistance; z <= currentChunk.getZ() + viewDistance; z++) {
                Chunk chunk = player.getWorld().getChunkAt(x, z);
                if (!chunks.contains(chunk)) {
                    chunks.add(chunk);
                }
            }
        }
        return chunks;
    }

    private boolean hasExcessiveMetadata(ItemStack item, int maxMetadataSize) {
        if (item.hasItemMeta()) {
            int metadataSize = item.getItemMeta().toString().codePoints().map(cp -> cp <= 2047 ? (cp <= 127 ? 1 : 2) : (cp <= 65535 ? 3 : 4)).sum();
            return metadataSize >= maxMetadataSize;
        }
        return false;
    }
}
