package newamazingpvp.lifestealsmp.events;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.WorldCreator;
import org.bukkit.WorldType;
import org.bukkit.World;
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
    private final Map<Player, World> playerOriginalWorlds = new HashMap<>();
    private final World pvpWorld;

    public UHCPvPEvent(ZonedDateTime startTime) {
        super(startTime, startTime.plusHours(1));
        pvpWorld = Bukkit.createWorld(new WorldCreator("uhcpvp_world").type(WorldType.FLAT));
    }

    @Override
    public void onEventStart() {
        Bukkit.getServer().broadcastMessage(ChatColor.RED + "UHC PvP event starting now! Type /teleportworld to join the PvP world. Check announcements /discord");
        getServer().getScheduler().runTaskLater(lifestealSmp, () -> sendDiscordNewsMessage(eventRole + " UHC PvP event is now active. Type /teleportworld to join the PvP world! May the best win!", "1032411739351941120"), 1200);
    }

    @Override
    public void onEventEnd() {
        Bukkit.getServer().broadcastMessage(ChatColor.RED + "UHC PvP event is now over. Returning players to the original world.");
        sendDiscordNewsMessage("UHC PvP event is now over. Returning players to the original world.", "1032411739351941120");

        for (Player player : playerOriginalWorlds.keySet()) {
            player.teleport(playerOriginalWorlds.get(player).getSpawnLocation());
        }
        playerOriginalWorlds.clear();
        Bukkit.unloadWorld(pvpWorld, false);
    }

    @Override
    public void doWarning() {
        Bukkit.getServer().broadcastMessage(ChatColor.RED + "UHC PvP event happening in " + formatDuration(Duration.between(CUSTOM_ITEMS_AND_RUNES, ZonedDateTime.now(ZoneId.of("America/New_York")))) + " hours! Check announcements /discord");
        sendDiscordNewsMessage(eventRole + " In " + formatDuration(Duration.between(startTime, ZonedDateTime.now(ZoneId.of("America/New_York")))) + ", the UHC PvP event will start. Type /teleportworld to join the PvP world!", "1032411739351941120");
    }

    @Override
    public EventType getType() {
        return EventType.HOUR;
    }

    @Override
    public void runContinuously() {
        Bukkit.getServer().broadcastMessage(ChatColor.DARK_PURPLE + "UHC PvP event is going on! Do /teleportworld to be in the event and /teleportback to return!");
    }

    public void teleportToPvPWorld(Player player) {
        if (!playerOriginalWorlds.containsKey(player)) {
            playerOriginalWorlds.put(player, player.getWorld());
            player.teleport(pvpWorld.getSpawnLocation());
            player.sendMessage(ChatColor.GREEN + "You have been teleported to the PvP world!");
        } else {
            player.sendMessage(ChatColor.RED + "You are already in the PvP world!");
        }
    }

    public void teleportBack(Player player) {
        if (playerOriginalWorlds.containsKey(player)) {
            player.teleport(playerOriginalWorlds.get(player).getSpawnLocation());
            playerOriginalWorlds.remove(player);
            player.sendMessage(ChatColor.GREEN + "You have been teleported back to your original world!");
        } else {
            player.sendMessage(ChatColor.RED + "You are not in the PvP world!");
        }
    }
}
