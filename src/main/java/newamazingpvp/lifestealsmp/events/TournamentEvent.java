package newamazingpvp.lifestealsmp.events;

import org.bukkit.*;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.event.player.PlayerKickEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.plugin.java.JavaPlugin;

import java.awt.Color;
import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import static newamazingpvp.lifestealsmp.LifestealSMP.lifestealSmp;
import static newamazingpvp.lifestealsmp.discord.DiscordBot.*;
import static newamazingpvp.lifestealsmp.events.TimeManager.*;

public class TournamentEvent extends BaseEvent implements Listener {
    private static final List<UUID> participants = new ArrayList<>();
    private World tournamentWorld;
    private UUID currentMatchPlayer1;
    private UUID currentMatchPlayer2;
    public static boolean isTournamentEvent = false;

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
        Bukkit.getServer().broadcastMessage(ChatColor.GOLD + "The tournament event is starting soon! Check announcements /discord and /register for event");
        createTournamentWorld();
        sendDiscordMessage( mcServer + "The tournament event is starting soon! Please /register for event. \n**If not enough players are registered, the event will be cancelled!**", "");
        //after creating the world, wait until its not null then do the things
        Bukkit.getScheduler().runTaskLater(lifestealSmp, () -> {
            tournamentWorld.setGameRule(GameRule.DO_MOB_SPAWNING, false);
            tournamentWorld.setGameRule(GameRule.KEEP_INVENTORY, true);
            startTournament();
            isTournamentEvent = true;
        }, 200L);
    }

    private void createTournamentWorld() {
        tournamentWorld = Bukkit.createWorld(new WorldCreator("tournament_world"));
    }

    private void startTournament() {
        if (participants.size() < 2) {
            Bukkit.getServer().broadcastMessage(ChatColor.RED + "Not enough participants for the tournament!");
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
                Bukkit.getServer().broadcastMessage(ChatColor.GOLD + player.getName() + " is the tournament champion!");
                sendDiscordEmbedPlayer("Tournament Champion", Color.magenta, "", player.getName());
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
            Location loc1 = new Location(tournamentWorld, 0, 100, 0);
            Location loc2 = new Location(tournamentWorld, 10, 100, 10);
            p1.teleport(loc1);
            p2.teleport(loc2);

            Bukkit.getServer().broadcastMessage(ChatColor.GOLD + p1.getName() + " vs " + p2.getName() + " - Fight!");
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
        if (player.getWorld().equals(tournamentWorld)) {
            player.setHealth(0);
            player.setKiller(player.getUniqueId() == currentMatchPlayer1 ? Bukkit.getPlayer(currentMatchPlayer2) : Bukkit.getPlayer(currentMatchPlayer1));
        }
    }

    @EventHandler
    public void onPlayerKick(PlayerKickEvent event) {
        Player player = event.getPlayer();
        if (player.getWorld().equals(tournamentWorld)) {
            player.setHealth(0);
            player.setKiller(player.getUniqueId() == currentMatchPlayer1 ? Bukkit.getPlayer(currentMatchPlayer2) : Bukkit.getPlayer(currentMatchPlayer1));
        }
    }

    @EventHandler
    public void onPlayerDeath(PlayerDeathEvent event) {
        Player player = event.getEntity();
        UUID playerId = player.getUniqueId();

        if (playerId.equals(currentMatchPlayer1) || playerId.equals(currentMatchPlayer2)) {
            UUID winner = playerId.equals(currentMatchPlayer1) ? currentMatchPlayer2 : currentMatchPlayer1;
            participants.add(winner);
            Bukkit.broadcastMessage(ChatColor.GOLD + Bukkit.getPlayer(winner).getName() + " has won the match! claiming victory over " + player.getName() + "!");
            scheduleNextMatch();
        }
    }

    @Override
    public void onEventEnd() {
        Bukkit.getServer().broadcastMessage(ChatColor.GOLD + "The tournament event is now over! Check announcements /discord");
        if (tournamentWorld != null) {
            Bukkit.unloadWorld(tournamentWorld, false);
        }
        isTournamentEvent = false;
        sendDiscordMessage("The tournament event is now over! Congratulations to the winners!", "");
    }


    @Override
    public void doWarning() {
        Bukkit.getServer().broadcastMessage(ChatColor.GOLD + "The 1v1 tournament event is happening in " + formatDuration(startTime) + "! /Register to participate on the day of the event! \n**Make sure to /register before the event starts or else you won't be able to play!**");
        sendDiscordMessage(eventRole + " The 1v1 tournament event is happening in " + formatDuration(startTime) + "! /Register to participate on the day of the event! \n**Make sure to /register before the event starts or else you won't be able to play!**", "");
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