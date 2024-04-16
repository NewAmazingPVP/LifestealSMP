package newamazingpvp.lifestealsmp.listener;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.scheduler.BukkitTask;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

import static newamazingpvp.lifestealsmp.LifestealSMP.lifestealSmp;

public class AntiPieRay implements Listener {
    private final double SPAWN_CHANCE = 10;
    private final int MAX_CHESTS_PER_PLAYER = 20;
    private final int MAX_CHESTS = 5;
    private final Map<Block, BukkitTask> chestTasks = new HashMap<>();
    private final Map<Player, Integer> playerChestCounts = new HashMap<>();

    @EventHandler
    public void onPlayerMove(PlayerMoveEvent event) {
        Player player = event.getPlayer();
        if (event.getFrom().getBlockX() != event.getTo().getBlockX()
                || event.getFrom().getBlockZ() != event.getTo().getBlockZ()) {
            spawnChests(player);
        }
    }

    private void spawnChests(Player player) {
        if (!playerChestCounts.containsKey(player)) {
            playerChestCounts.put(player, 0);
        }
        int currentChestCount = playerChestCounts.get(player);
        if (currentChestCount >= MAX_CHESTS_PER_PLAYER) {
            return;
        }

        World world = player.getWorld();
        Random random = new Random();
        int viewDistance = player.getClientViewDistance();
        int chestsToSpawn = Math.min(MAX_CHESTS, MAX_CHESTS_PER_PLAYER - currentChestCount);
        for (int i = 0; i < chestsToSpawn; i++) {
            int x = player.getLocation().getBlockX() + random.nextInt(viewDistance * 2) - viewDistance;
            int z = player.getLocation().getBlockZ() + random.nextInt(viewDistance * 2) - viewDistance;
            int y = (int) (player.getLocation().getY() + viewDistance * 16);
            if (y > 320) {
                y = 320;
            }
            Block block = world.getBlockAt(x, y, z);
            block.setType(Material.CHEST);
            player.sendMessage("Chest spawned at " + block.getX() + ", " + block.getY() + ", " + block.getZ());
            scheduleChestRemoval(block);
            playerChestCounts.put(player, currentChestCount + 1);
        }
    }

    private void scheduleChestRemoval(Block block) {
        BukkitTask task = Bukkit.getScheduler().runTaskLater(lifestealSmp, () -> {
            block.setType(Material.AIR);
            chestTasks.remove(block);
            for (Map.Entry<Player, Integer> entry : playerChestCounts.entrySet()) {
                if (entry.getValue() > 0) {
                    entry.setValue(entry.getValue() - 1);
                }
            }
        }, 100L);
        chestTasks.put(block, task);
    }

}
