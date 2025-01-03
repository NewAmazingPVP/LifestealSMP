package newamazingpvp.lifestealsmp.events;

import org.bukkit.*;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockPlaceEvent;

import java.time.ZonedDateTime;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import static newamazingpvp.lifestealsmp.LifestealSMP.lifestealSmp;
import static newamazingpvp.lifestealsmp.discord.DiscordBot.sendDiscordNewsMessage;
import static newamazingpvp.lifestealsmp.events.TimeManager.eventRole;
import static newamazingpvp.lifestealsmp.events.TimeManager.formatDuration;
import static org.bukkit.Bukkit.getServer;

public class UHCPvPEvent extends BaseEvent implements Listener {
    public static final Map<UUID, Location> playerOriginalWorlds = new HashMap<>();
    private static World pvpWorld = null;
    public static boolean isUhcEvent = false;

    public UHCPvPEvent(ZonedDateTime startTime) {
        super(startTime, startTime.plusHours(3));
    }

    @Override
    public void onEventStart() {
        pvpWorld = Bukkit.createWorld(new WorldCreator("uhcpvp_world").type(WorldType.FLAT));
        Bukkit.getServer().broadcastMessage(ChatColor.RED + "UHC PvP event starting now! Type /tpuhc to join the PvP world. Check announcements /discord");
        getServer().getScheduler().runTaskLater(lifestealSmp, () -> sendDiscordNewsMessage(eventRole + " UHC PvP event is now active. Type /tpuhc to join the PvP world! May the best win!", "1032411739351941120"), 1200);
        isUhcEvent = true;
        pvpWorld.getWorldBorder().setSize(250);
        //pvpWorld.getWorldBorder().setDamageBuffer(0);
        //pvpWorld.getWorldBorder().setDamageAmount(4);
        //pvpWorld.getWorldBorder().setWarningDistance(50);
        pvpWorld.setGameRule(GameRule.DO_MOB_SPAWNING, false);
    }

    @Override
    public void onEventEnd() {
        Bukkit.getServer().broadcastMessage(ChatColor.RED + "UHC PvP event is now over. Returning players to the original world.");
        sendDiscordNewsMessage("UHC PvP event is now over. Returning players to the original world.", "1032411739351941120");

        for (UUID playerUUID : playerOriginalWorlds.keySet()) {
            if (Bukkit.getPlayer(playerUUID) == null) continue;
            Player player = Bukkit.getPlayer(playerUUID);
            player.teleport(playerOriginalWorlds.get(player.getUniqueId()));
        }
        playerOriginalWorlds.clear();
        Bukkit.unloadWorld(pvpWorld, false);
        isUhcEvent = false;
    }

    @Override
    public void doWarning() {
        Bukkit.getServer().broadcastMessage(ChatColor.RED + "UHC PvP event happening in " + formatDuration(startTime) + "! Check announcements /discord");
        sendDiscordNewsMessage(eventRole + " In " + formatDuration(startTime) + ", the UHC PvP event will start. Type /tpuhc to join the PvP world!", "1032411739351941120");
    }

    @Override
    public EventType getType() {
        return EventType.HOUR;
    }

    @Override
    public void runContinuously() {
        Bukkit.getServer().broadcastMessage(ChatColor.DARK_PURPLE + "UHC PvP event is going on! Do '/tpuhc' to be in the event and '/tpuhc back' to return!");
        isUhcEvent = true;
        if (Bukkit.getWorld("uhcpvp_world") == null) {
            pvpWorld = Bukkit.createWorld(new WorldCreator("uhcpvp_world").type(WorldType.LARGE_BIOMES));
            pvpWorld.setGameRule(GameRule.DO_MOB_SPAWNING, false);
        }
    }

    public static void teleportToPvPWorld(Player player) {
        if (player.getWorld().getName().equalsIgnoreCase("uhcpvp_world")) {
            player.sendMessage("You are already in PVP world!");
            return;
        }
        if (Bukkit.getWorld("uhcpvp_world") == null) {
            pvpWorld = Bukkit.createWorld(new WorldCreator("uhcpvp_world").type(WorldType.FLAT));
            pvpWorld.setGameRule(GameRule.DO_MOB_SPAWNING, false);
        }
        playerOriginalWorlds.put(player.getUniqueId(), player.getLocation());
        player.teleport(pvpWorld.getSpawnLocation());
        player.sendMessage(ChatColor.GREEN + "You have been teleported to the PvP world! You can go back by doing /tpuhc back");
        Bukkit.broadcastMessage(ChatColor.AQUA + player.getName() + " teleported to uhc pvp world! If you want to fight them there do /tpuhc!");
    }

    public static void teleportBack(Player player) {
        if (playerOriginalWorlds.containsKey(player.getUniqueId())) {
            player.teleport(playerOriginalWorlds.get(player.getUniqueId()));
            playerOriginalWorlds.remove(player.getUniqueId());
            player.sendMessage(ChatColor.GREEN + "You have been teleported back to your original world!");
        } else if (player.getWorld().getName().equalsIgnoreCase("uhcpvp_world")) {
            player.teleport(Bukkit.getWorld("world").getSpawnLocation());
            player.sendMessage(ChatColor.GREEN + "You have been teleported back to the overworld spawn since unfortunately your original location was lost.");
        } else {
            player.sendMessage(ChatColor.RED + "You have not used /tpuhc to pvp world!");
        }
    }

    /*@EventHandler
    public void onPlayerJoin(PlayerLoginEvent event){
        if(isTimePassed(startTime) && !isTimePassed(endTime)){
            Bukkit.getScheduler().runTaskLater(lifestealSmp, () -> teleportBack(event.getPlayer()), 20);
        }
    }

    @EventHandler(priority = EventPriority.LOW)
    public void onPlayerLeave(PlayerQuitEvent event){
        if(isTimePassed(startTime) && !isTimePassed(endTime) && !isInCombat(event.getPlayer())){
            teleportBack(event.getPlayer());
        }
    }

    @EventHandler(priority = EventPriority.LOW)
    public void onPlayerKick(PlayerKickEvent e) {
        if(isTimePassed(startTime) && !isTimePassed(endTime) && !isInCombat(e.getPlayer())){
            teleportBack(e.getPlayer());
        }
    }*/

    //so i was bored and i did this
    @EventHandler
    public void onPlayerPlaceBed(BlockPlaceEvent e) {
        if (!e.getPlayer().getWorld().getName().equals("uhcpvp_world")) return;
        if (e.getBlock().getType().toString().toLowerCase().contains("bed") ||
                e.getBlockPlaced().getType().toString().toLowerCase().contains("bed") ||
                e.getBlockReplacedState().getBlock().getType().toString().toLowerCase().contains("bed") ||
                e.getItemInHand().getType().toString().toLowerCase().contains("bed") ||
                e.getPlayer().getInventory().getItemInMainHand().getType().toString().toLowerCase().contains("bed") ||
                e.getPlayer().getInventory().getItemInOffHand().getType().toString().toLowerCase().contains("bed")) {
            e.setCancelled(true);
        }
    }
}
