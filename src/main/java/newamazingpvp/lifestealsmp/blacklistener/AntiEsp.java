package newamazingpvp.lifestealsmp.blacklistener;

import org.bukkit.Bukkit;
import org.bukkit.Chunk;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.BlockState;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.CreatureSpawnEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.world.ChunkLoadEvent;
import org.bukkit.event.world.ChunkUnloadEvent;
import org.bukkit.scheduler.BukkitTask;

import java.util.ArrayList;
import java.util.EnumSet;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import static newamazingpvp.lifestealsmp.LifestealSMP.lifestealSmp;

public class AntiEsp implements Listener {
    private static final int REVEAL_RADIUS = 5;
    private static final int CHUNK_RADIUS = 1;
    private final Map<Chunk, List<Location>> containerCache = new ConcurrentHashMap<>();
    private final BukkitTask asyncTask;

    public AntiEsp() {
        Bukkit.getWorlds().forEach(world -> {
            for (Chunk chunk : world.getLoadedChunks()) {
                cacheChunk(chunk);
            }
        });
        asyncTask = Bukkit.getScheduler().runTaskTimerAsynchronously(
                lifestealSmp,
                this::processPlayersAsync,
                0L,
                10L
        );
    }

    @EventHandler
    public void onChunkLoad(ChunkLoadEvent e) {
        cacheChunk(e.getChunk());
        for (Player p : Bukkit.getOnlinePlayers()) {
            for (Location loc : containerCache.get(e.getChunk())) {
                if (loc.distanceSquared(p.getLocation()) > REVEAL_RADIUS * REVEAL_RADIUS) {
                    p.sendBlockChange(loc, Material.AIR.createBlockData());
                }
            }
        }
    }


    @EventHandler
    public void onChunkUnload(ChunkUnloadEvent e) {
        containerCache.remove(e.getChunk());
    }

    @EventHandler
    public void onCreatureSpawn(CreatureSpawnEvent e) {
        LivingEntity ent = e.getEntity();
        ent.setGlowing(false);
    }

    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent e) {
        e.getPlayer().setGlowing(false);
        Player player = e.getPlayer();
        player.setGlowing(false);
        hideAllOutsideRadius(player);
    }

    private void cacheChunk(Chunk chunk) {
        List<Location> locs = new ArrayList<>();
        for (BlockState state : chunk.getTileEntities()) {
            Material mat = state.getType();
            if (isEspBlock(mat)) {
                locs.add(state.getLocation());
            }
        }
        containerCache.put(chunk, locs);
    }

    private void processPlayersAsync() {
        for (Player player : Bukkit.getOnlinePlayers()) {
            Location ploc = player.getLocation();
            int cx = ploc.getChunk().getX(), cz = ploc.getChunk().getZ();
            for (int dx = -CHUNK_RADIUS; dx <= CHUNK_RADIUS; dx++) {
                for (int dz = -CHUNK_RADIUS; dz <= CHUNK_RADIUS; dz++) {
                    Chunk chunk = player.getWorld().getChunkAt(cx + dx, cz + dz);
                    List<Location> blockList = containerCache.get(chunk);
                    if (blockList == null || blockList.isEmpty()) continue;

                    for (Location bloc : blockList) {
                        double distSq = bloc.distanceSquared(ploc);
                        boolean hide = distSq > (REVEAL_RADIUS * REVEAL_RADIUS);

                        Bukkit.getScheduler().runTask(lifestealSmp, () -> {
                            if (player.isOnline()) {
                                if (hide) {
                                    player.sendBlockChange(bloc, Material.AIR.createBlockData());
                                } else {
                                    player.sendBlockChange(bloc, bloc.getBlock().getBlockData());
                                }
                            }
                        });
                    }
                }
            }
        }
    }


    private void hideAllOutsideRadius(Player player) {
        Location ploc = player.getLocation();
        double radiusSq = REVEAL_RADIUS * REVEAL_RADIUS;
        for (List<Location> locs : containerCache.values()) {
            for (Location loc : locs) {
                if (loc.distanceSquared(ploc) > radiusSq) {
                    player.sendBlockChange(loc, Material.AIR.createBlockData());
                }
            }
        }
    }

    private boolean isEspBlock(Material mat) {
        return EnumSet.of(
                Material.CHEST, Material.TRAPPED_CHEST, Material.ENDER_CHEST,
                Material.BARREL, Material.HOPPER,
                Material.FURNACE, Material.BLAST_FURNACE, Material.SMOKER,
                Material.DISPENSER, Material.DROPPER,
                Material.CHEST_MINECART, Material.FURNACE_MINECART, Material.HOPPER_MINECART, Material.TNT_MINECART,
                Material.OAK_CHEST_BOAT, Material.SPRUCE_CHEST_BOAT, Material.BIRCH_CHEST_BOAT,
                Material.JUNGLE_CHEST_BOAT, Material.ACACIA_CHEST_BOAT, Material.DARK_OAK_CHEST_BOAT, Material.CHERRY_CHEST_BOAT,
                Material.WHITE_SHULKER_BOX, Material.ORANGE_SHULKER_BOX, Material.MAGENTA_SHULKER_BOX,
                Material.LIGHT_BLUE_SHULKER_BOX, Material.YELLOW_SHULKER_BOX, Material.LIME_SHULKER_BOX,
                Material.PINK_SHULKER_BOX, Material.GRAY_SHULKER_BOX, Material.LIGHT_GRAY_SHULKER_BOX,
                Material.CYAN_SHULKER_BOX, Material.PURPLE_SHULKER_BOX, Material.BLUE_SHULKER_BOX,
                Material.BROWN_SHULKER_BOX, Material.GREEN_SHULKER_BOX, Material.RED_SHULKER_BOX,
                Material.BLACK_SHULKER_BOX,
                Material.OAK_SIGN, Material.SPRUCE_SIGN, Material.BIRCH_SIGN,
                Material.ACACIA_SIGN, Material.JUNGLE_SIGN, Material.DARK_OAK_SIGN,
                Material.WHITE_BED, Material.ORANGE_BED, Material.MAGENTA_BED,
                Material.LIGHT_BLUE_BED, Material.YELLOW_BED, Material.LIME_BED,
                Material.PINK_BED, Material.GRAY_BED, Material.LIGHT_GRAY_BED,
                Material.CYAN_BED, Material.PURPLE_BED, Material.BLUE_BED,
                Material.BROWN_BED, Material.GREEN_BED, Material.RED_BED
        ).contains(mat);
    }
}
