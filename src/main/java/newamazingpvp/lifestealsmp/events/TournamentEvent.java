package newamazingpvp.lifestealsmp.events;

import org.bukkit.*;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.plugin.java.JavaPlugin;

import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import static newamazingpvp.lifestealsmp.events.TimeManager.formatDuration;

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
        Bukkit.getServer().broadcastMessage(ChatColor.GOLD + "The tournament event is starting now! Check announcements /discord");
        createTournamentWorld();
        startTournament();
        isTournamentEvent = true;
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
            currentMatchPlayer1 = participants.remove(0);
            currentMatchPlayer2 = participants.remove(0);
            startMatch(currentMatchPlayer1, currentMatchPlayer2);
        } else if (participants.size() == 1) {
            UUID champion = participants.get(0);
            Player player = Bukkit.getPlayer(champion);
            if (player != null) {
                Bukkit.getServer().broadcastMessage(ChatColor.GOLD + player.getName() + " is the tournament champion!");
            }
        }
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
    }

    @Override
    public void doWarning() {
        Bukkit.getServer().broadcastMessage(ChatColor.GOLD + "The tournament event is happening in " + formatDuration(startTime) + "! Register now!");
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