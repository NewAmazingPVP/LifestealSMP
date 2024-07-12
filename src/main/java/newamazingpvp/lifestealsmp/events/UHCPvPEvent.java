package newamazingpvp.lifestealsmp.events;

import org.bukkit.*;
import org.bukkit.entity.Player;

import java.time.Duration;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.HashMap;
import java.util.Map;

import static newamazingpvp.lifestealsmp.LifestealSMP.lifestealSmp;
import static newamazingpvp.lifestealsmp.discord.DiscordBot.sendDiscordNewsMessage;
import static newamazingpvp.lifestealsmp.utility.TimeManager.*;
import static org.bukkit.Bukkit.getServer;

public class UHCPvPEvent extends BaseEvent {
    public static final Map<Player, Location> playerOriginalWorlds = new HashMap<>();
    private static World pvpWorld = null;
    public static boolean isUhcEvent = false;

    public UHCPvPEvent(ZonedDateTime startTime) {
        super(startTime, startTime.plusHours(1));
        pvpWorld = Bukkit.createWorld(new WorldCreator("uhcpvp_world").type(WorldType.FLAT));
    }

    @Override
    public void onEventStart() {
        Bukkit.getServer().broadcastMessage(ChatColor.RED + "UHC PvP event starting now! Type /teleport to join the PvP world. Check announcements /discord");
        getServer().getScheduler().runTaskLater(lifestealSmp, () -> sendDiscordNewsMessage(eventRole + " UHC PvP event is now active. Type /teleport to join the PvP world! May the best win!", "1032411739351941120"), 1200);
        isUhcEvent = true;
        Bukkit.getWorld("uhcpvp_world").getWorldBorder().setSize(500);
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
        Bukkit.getServer().broadcastMessage(ChatColor.RED + "UHC PvP event happening in " + formatDuration(startTime) + " hours! Check announcements /discord");
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
}
