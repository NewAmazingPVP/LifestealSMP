package newamazingpvp.lifestealsmp.events;

import org.bukkit.*;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.event.player.PlayerKickEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.scheduler.BukkitRunnable;

import java.awt.Color;
import java.time.ZonedDateTime;
import java.util.*;

import static newamazingpvp.lifestealsmp.LifestealSMP.lifestealSmp;
import static newamazingpvp.lifestealsmp.discord.DiscordBot.*;
import static newamazingpvp.lifestealsmp.events.TimeManager.*;
import static org.bukkit.Bukkit.getServer;

public class TournamentEvent extends BaseEvent implements Listener {
    private static final List<UUID> participants = new ArrayList<>();
    private World tournamentWorld;
    private UUID currentMatchPlayer1;
    private UUID currentMatchPlayer2;
    public static boolean isTournamentEvent = false;
    private Map<UUID, Location> playersLastLocation = new HashMap<>(); //players in the tournament

    public TournamentEvent(ZonedDateTime startTime) {
        super(startTime, startTime.plusDays(1));
    }

    public static void registerPlayer(Player player) {
        if (!participants.contains(player.getUniqueId())) {
            participants.add(player.getUniqueId());
            player.sendMessage(ChatColor.GREEN + "You have been registered for the tournament!");
        } else {
            player.sendMessage(ChatColor.RED + "You are already registered for the tournament!");
        }
    }

    @Override
    public void onEventStart() {
        getServer().broadcastMessage(ChatColor.GOLD + "The tournament event is starting soon! Check announcements /discord and /register for event");
        getServer().broadcastMessage(ChatColor.GOLD + "You will not lose stuff in this tournament event");
        createTournamentWorld();
        sendDiscordNewsMessage( mcServer + " The tournament event is starting soon! Please /register for event. \n**If not enough players are registered, the event will be cancelled!**", "1032411739351941120");
        sendDiscordNewsMessage( "You will not lose stuff in this tournament event...", "1032411739351941120");
        //after creating the world, wait until its not null then do the things
        new BukkitRunnable() {
            @Override
            public void run() {
                if (tournamentWorld == null || Bukkit.getWorld("tournament_world") == null) {
                    return;
                }
                tournamentWorld.setGameRule(GameRule.DO_MOB_SPAWNING, false);
                tournamentWorld.setGameRule(GameRule.KEEP_INVENTORY, true);
                WorldBorder worldBorder = tournamentWorld.getWorldBorder();
                worldBorder.setCenter(0, 0);
                worldBorder.setSize(100);
                startTournament();
                isTournamentEvent = true;
                this.cancel();
        }
        }.runTaskTimer(lifestealSmp, 0, 20);
    }

    private void createTournamentWorld() {
        tournamentWorld = Bukkit.createWorld(new WorldCreator("tournament_world").type(WorldType.AMPLIFIED).environment(World.Environment.NORMAL));
    }

    private void startTournament() {
        if (participants.size() < 2) {
            getServer().broadcastMessage(ChatColor.RED + "Not enough participants for the tournament!");
            return;
        }

        scheduleNextMatch();
    }

    private void scheduleNextMatch() {
        if (participants.size() > 1) {
            currentMatchPlayer1 = getValidPlayer();
            currentMatchPlayer2 = getValidPlayer();

            startMatch(currentMatchPlayer1, currentMatchPlayer2);
        } else if (participants.size() == 1) {
            UUID champion = participants.get(0);
            Player player = Bukkit.getPlayer(champion);
            if (player != null) {
                //new branch testing
                getServer().broadcastMessage(ChatColor.GOLD + player.getName() + " is the tournament champion!");
                sendDiscordEmbedPlayer("Tournament Champion", Color.magenta, "", player.getName());
                player.removePotionEffect(PotionEffectType.GLOWING);
                onEventEnd();
            }
        }
    }

    //return a valid player who is online and can be used for the match
    public UUID getValidPlayer() {
        for(UUID player : participants) {
            Player p = Bukkit.getPlayer(player);
            if(p != null) {
                participants.remove(player);
                return player;
            }
        }
        return null;
    }

    private void startMatch(UUID player1, UUID player2) {
        Player p1 = Bukkit.getPlayer(player1);
        Player p2 = Bukkit.getPlayer(player2);

        if (p1 != null && p2 != null) {
            playersLastLocation.put(player1, p1.getLocation());
            playersLastLocation.put(player2, p2.getLocation());
            Location loc1 = new Location(tournamentWorld, 0, 100, 0);
            Location loc2 = new Location(tournamentWorld, 10, 100, 10);
            p1.setInvulnerable(true);
            p2.setInvulnerable(true);
            p1.teleport(loc1);
            p2.teleport(loc2);
            p1.addPotionEffect(new PotionEffect(PotionEffectType.GLOWING, Integer.MAX_VALUE, 1));
            p2.addPotionEffect(new PotionEffect(PotionEffectType.GLOWING, Integer.MAX_VALUE, 1));
            getServer().getScheduler().runTaskLater(lifestealSmp, () -> {
                p1.setInvulnerable(false);
                p2.setInvulnerable(false);
            }, 20 * 5);

            getServer().broadcastMessage(ChatColor.GOLD + p1.getName() + " vs " + p2.getName() + " - Fight!");
        } else {
            if (p1 != null) participants.add(player1);
            if (p2 != null) participants.add(player2);
            scheduleNextMatch();
        }
    }

    //gamerule keep inventory true
    //gamerule do mob spawning false
    // and then basically kill anyone instantly who lives the event world
    @EventHandler
    public void onPlayerQuit(PlayerQuitEvent event) {
        Player player = event.getPlayer();
        if(!isTournamentEvent) return;
        if (player.getWorld().equals(tournamentWorld)) {
            player.setHealth(0);
            player.setKiller(player.getUniqueId() == currentMatchPlayer1 ? Bukkit.getPlayer(currentMatchPlayer2) : Bukkit.getPlayer(currentMatchPlayer1));
        }
    }

    @EventHandler
    public void onPlayerKick(PlayerKickEvent event) {
        Player player = event.getPlayer();
        if(!isTournamentEvent) return;
        if (player.getWorld().equals(tournamentWorld)) {
            player.setHealth(0);
            player.setKiller(player.getUniqueId() == currentMatchPlayer1 ? Bukkit.getPlayer(currentMatchPlayer2) : Bukkit.getPlayer(currentMatchPlayer1));
        }
    }

    @EventHandler
    public void onPlayerDeath(PlayerDeathEvent event) {
        Player player = event.getEntity();
        UUID playerId = player.getUniqueId();
        if(!isTournamentEvent) return;
        if (playerId.equals(currentMatchPlayer1) || playerId.equals(currentMatchPlayer2)) {
            UUID winner = playerId.equals(currentMatchPlayer1) ? currentMatchPlayer2 : currentMatchPlayer1;
            participants.add(winner);
            Bukkit.broadcastMessage(ChatColor.GOLD + Bukkit.getPlayer(winner).getName() + " has won the match! claiming victory over " + player.getName() + "!");
            scheduleNextMatch();
        }
    }

    @Override
    public void onEventEnd() {
        getServer().broadcastMessage(ChatColor.GOLD + "The tournament event is now over! Check announcements /discord");
        for (UUID player : playersLastLocation.keySet()) {
            Player p = Bukkit.getPlayer(player);
            if (p != null && p.getWorld().equals(tournamentWorld)) {
                p.teleport(playersLastLocation.get(player));
            }
        }
        if (tournamentWorld != null) {
            Bukkit.unloadWorld(tournamentWorld, false);
        }

        participants.clear();
        playersLastLocation.clear();
        currentMatchPlayer1 = null;
        currentMatchPlayer2 = null;
        isTournamentEvent = false;

        sendDiscordNewsMessage("The tournament event is now over! Congratulations to the winners!", "1032411739351941120");
    }



    @Override
    public void doWarning() {
        getServer().broadcastMessage(ChatColor.GOLD + "The 1v1 tournament event is happening in " + formatDuration(startTime) + "! /Register to participate on the day of the event! \n**Make sure to /register before the event starts or else you won't be able to play!**");
        //add discord notif
        sendDiscordNewsMessage(eventRole + " The 1v1 tournament event is happening in " + formatDuration(startTime) + "! /Register on the day of the event to participate! \n**Make sure to /register before the event starts or else you won't be able to play!**", "1032411739351941120");
        sendDiscordNewsMessage("You will not lose stuff in this tournament event...", "1032411739351941120");
    }

    @Override
    public EventType getType() {
        return EventType.MULTIHOUR;
    }

    @Override
    public void runContinuously() {
        isTournamentEvent = true;
    }
}