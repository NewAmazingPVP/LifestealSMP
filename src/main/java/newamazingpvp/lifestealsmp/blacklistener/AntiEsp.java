package newamazingpvp.lifestealsmp.blacklistener;

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
    private static final int CHUNK_RADIUS = 7;

    private final Map<Chunk, List<Location>> cache = new ConcurrentHashMap<>();

    public AntiEsp() {
        for (World w : Bukkit.getWorlds())
            for (Chunk c : w.getLoadedChunks())
                cacheChunk(c);
    }

    @EventHandler public void onChunkLoad(ChunkLoadEvent e){ cacheChunk(e.getChunk()); }
    @EventHandler public void onChunkUnload(ChunkUnloadEvent e){ cache.remove(e.getChunk()); }
    @EventHandler public void onPlayerJoin(PlayerJoinEvent e){ updatePlayer(e.getPlayer()); }

    @EventHandler public void onPlayerMove(PlayerMoveEvent e){
        if(e.getFrom().getBlockX()!=e.getTo().getBlockX()||e.getFrom().getBlockY()!=e.getTo().getBlockY()||e.getFrom().getBlockZ()!=e.getTo().getBlockZ())
            updatePlayer(e.getPlayer());
    }

    private void updatePlayer(Player p){
        Location eye = p.getEyeLocation();
        double max = REVEAL_RADIUS*REVEAL_RADIUS;
        for(Location loc : nearby(eye)){
            boolean visible = loc.distanceSquared(eye)<=max && hasSight(p.getWorld(), eye, loc);
            p.sendBlockChange(loc, visible?loc.getBlock().getBlockData():Material.AIR.createBlockData());
        }
    }

    private boolean hasSight(World w, Location eye, Location loc){
        Vector dir = loc.clone().add(0.5,0.5,0.5).toVector().subtract(eye.toVector());
        double len = dir.length() - 0.75;
        RayTraceResult r = w.rayTraceBlocks(eye, dir, len, FluidCollisionMode.NEVER, true);
        return r == null || r.getHitBlock() == null;
    }

    private List<Location> nearby(Location centre){
        List<Location> out = new ArrayList<>();
        World w = centre.getWorld();
        Chunk c = centre.getChunk(); int bx=c.getX(), bz=c.getZ();
        for(int dx=-CHUNK_RADIUS; dx<=CHUNK_RADIUS; dx++)
            for(int dz=-CHUNK_RADIUS; dz<=CHUNK_RADIUS; dz++){
                List<Location> l = cache.get(w.getChunkAt(bx+dx,bz+dz));
                if(l!=null) out.addAll(l);
            }
        return out;
    }

    private void cacheChunk(Chunk c){
        List<Location> list = new ArrayList<>();
        for(BlockState s : c.getTileEntities()) if(ESP_BLOCKS.contains(s.getType())) list.add(s.getLocation());
        cache.put(c,list);
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
            Material.BROWN_BED, Material.GREEN_BED, Material.RED_BED
    );
}
