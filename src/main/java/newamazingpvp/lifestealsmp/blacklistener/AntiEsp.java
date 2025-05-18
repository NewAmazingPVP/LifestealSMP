package newamazingpvp.lifestealsmp.blacklistener;

import it.unimi.dsi.fastutil.longs.Long2ObjectOpenHashMap;
import org.bukkit.*;
import org.bukkit.block.BlockState;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.event.world.ChunkLoadEvent;
import org.bukkit.event.world.ChunkUnloadEvent;
import org.bukkit.util.RayTraceResult;
import org.bukkit.util.Vector;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;


public class AntiEsp implements Listener {

    private static final int REVEAL_RADIUS = 20;
    private static final int CHUNK_RADIUS  = 7;


    private final Map<UUID, Long2ObjectOpenHashMap<List<Location>>> chunkCache = new ConcurrentHashMap<>();

    private final Map<Player, Set<Location>> playerVisible = new WeakHashMap<>();


    public AntiEsp() {
        for (World w : Bukkit.getWorlds()) {
            Long2ObjectOpenHashMap<List<Location>> worldMap =
                    chunkCache.computeIfAbsent(w.getUID(), __ -> new Long2ObjectOpenHashMap<>());
            for (Chunk c : w.getLoadedChunks()) cacheChunk(c, worldMap);
        }
    }


    @EventHandler public void onChunkLoad(ChunkLoadEvent e)   { cacheChunk(e.getChunk());    }
    @EventHandler public void onChunkUnload(ChunkUnloadEvent e){
        Long2ObjectOpenHashMap<List<Location>> map = chunkCache.get(e.getWorld().getUID());
        if (map != null) map.remove(chunkKey(e.getChunk().getX(), e.getChunk().getZ()));
    }

    @EventHandler public void onPlayerJoin(PlayerJoinEvent e){ updatePlayer(e.getPlayer()); }

    @EventHandler public void onPlayerMove(PlayerMoveEvent e){
        if (e.getFrom().getBlockX()!=e.getTo().getBlockX()
                || e.getFrom().getBlockY()!=e.getTo().getBlockY()
                || e.getFrom().getBlockZ()!=e.getTo().getBlockZ())
            updatePlayer(e.getPlayer());
    }

    private void updatePlayer(Player p){
        Location eye = p.getEyeLocation();
        World w     = eye.getWorld();
        if (w == null) return;

        double maxDistSq = REVEAL_RADIUS * REVEAL_RADIUS;

        Set<Location> nowVisible = new HashSet<>();

        for (Location loc : nearby(eye)){
            if (loc.distanceSquared(eye) <= maxDistSq && hasSight(w, eye, loc))
                nowVisible.add(loc);
        }

        Set<Location> prev = playerVisible.computeIfAbsent(p, __ -> new HashSet<>());

        for (Location loc : nowVisible) {
            if (prev.add(loc)) p.sendBlockChange(loc, loc.getBlock().getBlockData());
        }

        for (Iterator<Location> it = prev.iterator(); it.hasNext();){
            Location loc = it.next();
            if (!nowVisible.contains(loc)){
                p.sendBlockChange(loc, Material.AIR.createBlockData());
                it.remove();
            }
        }
    }

    private boolean hasSight(World w, Location eye, Location loc){
        Vector dir  = loc.clone().add(0.5,0.5,0.5).toVector().subtract(eye.toVector());
        double len  = dir.length() - 0.75; 
        RayTraceResult r = w.rayTraceBlocks(eye, dir, len, FluidCollisionMode.NEVER, true);
        return r == null || r.getHitBlock() == null;
    }


    private List<Location> nearby(Location centre){
        World w = Objects.requireNonNull(centre.getWorld());
        Long2ObjectOpenHashMap<List<Location>> worldMap = chunkCache.get(w.getUID());
        if (worldMap == null || worldMap.isEmpty()) return Collections.emptyList();

        List<Location> out = new ArrayList<>();

        int baseX = centre.getBlockX() >> 4;
        int baseZ = centre.getBlockZ() >> 4;

        for (int dx = -CHUNK_RADIUS; dx <= CHUNK_RADIUS; dx++){
            int cx = baseX + dx;
            for (int dz = -CHUNK_RADIUS; dz <= CHUNK_RADIUS; dz++){
                long key = chunkKey(cx, baseZ + dz);
                List<Location> list = worldMap.get(key);
                if (list != null) out.addAll(list);
            }
        }
        return out;
    }


    private void cacheChunk(Chunk c){
        Long2ObjectOpenHashMap<List<Location>> worldMap =
                chunkCache.computeIfAbsent(c.getWorld().getUID(), __ -> new Long2ObjectOpenHashMap<>());
        cacheChunk(c, worldMap);
    }

    private void cacheChunk(Chunk c, Long2ObjectOpenHashMap<List<Location>> worldMap){
        List<Location> list = new ArrayList<>();
        for (BlockState s : c.getTileEntities())
            if (ESP_BLOCKS.contains(s.getType()))
                list.add(s.getLocation().clone());
        worldMap.put(chunkKey(c.getX(), c.getZ()), list);
    }

    private static long chunkKey(int x, int z){
        return ((long)x & 0xffffffffL) << 32 | ((long)z & 0xffffffffL);
    }

    private static final Set<Material> ESP_BLOCKS = EnumSet.of(
            Material.CHEST, Material.TRAPPED_CHEST, Material.ENDER_CHEST, Material.BARREL, Material.HOPPER,
            Material.FURNACE, Material.BLAST_FURNACE, Material.SMOKER, Material.DISPENSER, Material.DROPPER,
            Material.CHEST_MINECART, Material.FURNACE_MINECART, Material.HOPPER_MINECART, Material.TNT_MINECART, Material.MINECART,
            Material.OAK_CHEST_BOAT, Material.SPRUCE_CHEST_BOAT, Material.BIRCH_CHEST_BOAT,
            Material.JUNGLE_CHEST_BOAT, Material.ACACIA_CHEST_BOAT, Material.DARK_OAK_CHEST_BOAT, Material.CHERRY_CHEST_BOAT,
            Material.WHITE_SHULKER_BOX, Material.ORANGE_SHULKER_BOX, Material.MAGENTA_SHULKER_BOX,
            Material.LIGHT_BLUE_SHULKER_BOX, Material.YELLOW_SHULKER_BOX, Material.LIME_SHULKER_BOX,
            Material.PINK_SHULKER_BOX, Material.GRAY_SHULKER_BOX, Material.LIGHT_GRAY_SHULKER_BOX,
            Material.CYAN_SHULKER_BOX, Material.PURPLE_SHULKER_BOX, Material.BLUE_SHULKER_BOX,
            Material.BROWN_SHULKER_BOX, Material.GREEN_SHULKER_BOX, Material.RED_SHULKER_BOX,
            Material.BLACK_SHULKER_BOX, Material.OAK_SIGN, Material.SPRUCE_SIGN, Material.BIRCH_SIGN,
            Material.JUNGLE_SIGN, Material.ACACIA_SIGN, Material.DARK_OAK_SIGN,
            Material.WHITE_BED, Material.ORANGE_BED, Material.MAGENTA_BED,
            Material.LIGHT_BLUE_BED, Material.YELLOW_BED, Material.LIME_BED,
            Material.PINK_BED, Material.GRAY_BED, Material.LIGHT_GRAY_BED,
            Material.CYAN_BED, Material.PURPLE_BED, Material.BLUE_BED,
            Material.BROWN_BED, Material.GREEN_BED, Material.RED_BED,
            Material.STONECUTTER, Material.LECTERN, Material.FLETCHING_TABLE, Material.BREWING_STAND,
            Material.ANVIL, Material.COMPOSTER
    );
}
