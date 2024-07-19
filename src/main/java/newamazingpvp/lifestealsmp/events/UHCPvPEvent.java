package newamazingpvp.lifestealsmp.events;

import org.bukkit.*;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerKickEvent;
import org.bukkit.event.player.PlayerLoginEvent;
import org.bukkit.event.player.PlayerQuitEvent;

import java.time.ZonedDateTime;
import java.util.HashMap;
import java.util.Map;

import static newamazingpvp.lifestealsmp.LifestealSMP.lifestealSmp;
import static newamazingpvp.lifestealsmp.discord.DiscordBot.sendDiscordNewsMessage;
import static newamazingpvp.lifestealsmp.events.TimeManager.*;
import static newamazingpvp.lifestealsmp.game.CombatLog.*;
import static newamazingpvp.lifestealsmp.variables.Loc.endSpawn;
import static org.bukkit.Bukkit.getServer;

public class UHCPvPEvent extends BaseEvent implements Listener {
    public static final Map<Player, Location> playerOriginalWorlds = new HashMap<>();
    private static World pvpWorld = null;
    public static boolean isUhcEvent = false;

    public UHCPvPEvent(ZonedDateTime startTime) {
        super(startTime, startTime.plusHours(1));
    }

    @Override
    public void onEventStart() {
        pvpWorld = Bukkit.createWorld(new WorldCreator("uhcpvp_world").type(WorldType.FLAT));
        Bukkit.getServer().broadcastMessage(ChatColor.RED + "UHC PvP event starting now! Type /teleport to join the PvP world. Check announcements /discord");
        getServer().getScheduler().runTaskLater(lifestealSmp, () -> sendDiscordNewsMessage(eventRole + " UHC PvP event is now active. Type /teleport to join the PvP world! May the best win!", "1032411739351941120"), 1200);
        isUhcEvent = true;
        pvpWorld.getWorldBorder().setSize(500);
    }

    @Override
    public void onEventEnd() {
        Bukkit.getServer().broadcastMessage(ChatColor.RED + "UHC PvP event is now over. Returning players to the original world.");
        sendDiscordNewsMessage("UHC PvP event is now over. Returning players to the original world.", "1032411739351941120");

        for (Player player : playerOriginalWorlds.keySet()) {
            player.teleport(playerOriginalWorlds.get(player));
        }
        playerOriginalWorlds.clear();
        Bukkit.unloadWorld(pvpWorld, false);
        isUhcEvent = false;
    }

    @Override
    public void doWarning() {
        Bukkit.getServer().broadcastMessage(ChatColor.RED + "UHC PvP event happening in " + formatDuration(startTime) + "! Check announcements /discord");
        sendDiscordNewsMessage(eventRole + " In " + formatDuration(startTime) + ", the UHC PvP event will start. Type /teleport to join the PvP world!", "1032411739351941120");
    }

    @Override
    public EventType getType() {
        return EventType.HOUR;
    }

    @Override
    public void runContinuously() {
        Bukkit.getServer().broadcastMessage(ChatColor.DARK_PURPLE + "UHC PvP event is going on! Do '/teleport' to be in the event and '/teleport back' to return!");
        isUhcEvent = true;
    }

    public static void teleportToPvPWorld(Player player) {
        if (!playerOriginalWorlds.containsKey(player)) {
            playerOriginalWorlds.put(player, player.getLocation());
            player.teleport(pvpWorld.getSpawnLocation());
            player.sendMessage(ChatColor.GREEN + "You have been teleported to the PvP world!");
        } else {
            player.sendMessage(ChatColor.RED + "You are already in the PvP world!");
        }
    }

    public static void teleportBack(Player player) {
        if (playerOriginalWorlds.containsKey(player)) {
            player.teleport(playerOriginalWorlds.get(player));
            playerOriginalWorlds.remove(player);
            player.sendMessage(ChatColor.GREEN + "You have been teleported back to your original world!");
        } else {
            player.sendMessage(ChatColor.RED + "You are not in the PvP world!");
        }
    }

    @EventHandler
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
    }
}
