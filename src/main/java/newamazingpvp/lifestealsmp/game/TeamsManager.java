package newamazingpvp.lifestealsmp.game;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.OfflinePlayer;
import org.bukkit.entity.Player;
import org.bukkit.scoreboard.Scoreboard;
import org.bukkit.scoreboard.ScoreboardManager;
import org.bukkit.scoreboard.Team;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.UUID;

import static newamazingpvp.lifestealsmp.game.AlliesManager.playerAlliesChat;

public class TeamsManager {
    private static final HashMap<String, Team> teamInvites = new HashMap<>();
    public static List<UUID> playerTeamChat = new ArrayList<>();

    public static void joinTeam(Player p, String teamName) {
        if (teamInvites.containsKey(p.getName())) {
            if (getPlayerTeam(p) != null) {
                p.sendMessage(ChatColor.RED + "You have to leave your current team (/team leave) before joining a new one!");
                return;
            }
            ScoreboardManager scoreboardManager = Bukkit.getScoreboardManager();
            Scoreboard scoreboard = scoreboardManager.getMainScoreboard();
            Team team = (scoreboard.getTeam(teamName) != null) ? scoreboard.getTeam(teamName) : null;
            if (team == null) {
                p.sendMessage(ChatColor.RED + "This team does not exist!");
                return;
            }
            team.addEntry(p.getName());

            sendTeamMessage(p, "I have joined the team!");
            teamInvites.remove(p.getName());
        } else {
            p.sendMessage(ChatColor.RED + "Invalid team invite. Ask someone to send you an invite again.");
        }
    }

    public static void sendTeamMessage(Player p, String msg) {

        Scoreboard scoreboard = Bukkit.getScoreboardManager().getMainScoreboard();
        Team team = scoreboard.getPlayerTeam(p);
        if (team == null) return;

        for (OfflinePlayer teamMate : team.getPlayers()) {
            if (teamMate.isOnline()) {
                Player player = (Player) teamMate;
                player.sendMessage(ChatColor.AQUA + "Team: " + ChatColor.RESET + "<" + p.getName() + "> " + msg);
            }
        }
    }

    public static void sendTeamMessage(Team t, String msg) {
        for (OfflinePlayer teamMate : t.getPlayers()) {
            if (teamMate.isOnline()) {
                Player player = (Player) teamMate;
                player.sendMessage(msg);
            }
        }
    }

    public static void teamChatMode(Player p) {
        if (!playerTeamChat.contains(p.getUniqueId())) {
            playerTeamChat.add(p.getUniqueId());
            playerAlliesChat.remove(p.getUniqueId());
            p.sendMessage(ChatColor.AQUA + "Your messages now go to team chat!");
        } else {
            playerTeamChat.remove(p.getUniqueId());
            p.sendMessage(ChatColor.GOLD + "Your messages now go to global chat!");
        }
    }

    public static List<String> getTeamMembers(Player p) {
        Scoreboard scoreboard = Bukkit.getScoreboardManager().getMainScoreboard();
        Team team = scoreboard.getPlayerTeam(p);
        if (team == null) return null;
        List<String> names = new ArrayList<>();
        for (OfflinePlayer teamMate : team.getPlayers()) {
            names.add(teamMate.getName());
        }
        return names;
    }

    public static boolean isPlayerInTeamChat(Player p) {
        return playerTeamChat.contains(p.getUniqueId());
    }

    public static boolean onSameTeam(Player p, Player t) {
        if (getPlayerTeam(p) != null && getPlayerTeam(t) != null) {
            return getPlayerTeam(p).equals(getPlayerTeam(t));
        }
        return false;
    }

    public static List<String> getAllTeams() {
        List<String> teams = new ArrayList<>();
        for (Team t : Bukkit.getScoreboardManager().getMainScoreboard().getTeams()) {
            teams.add(t.getName());
        }
        return teams;
    }

    public static void createTeam(Player p, String teamName) {
        if (getPlayerTeam(p) != null) {
            p.sendMessage("You are already in a team! /team leave before making a new one!");
            return;
        }
        Scoreboard scoreboard = Bukkit.getScoreboardManager().getMainScoreboard();
        Team team = (scoreboard.getTeam(teamName) != null) ? null : scoreboard.registerNewTeam(teamName);
        if (team == null) {
            p.sendMessage(ChatColor.RED + "Team with this name already exists!");
        } else {
            teamInvites.put(p.getName(), team);
            joinTeam(p, team.getName());
            p.sendMessage(ChatColor.DARK_PURPLE + "You have created the team named " + team.getName() + "! Invite others to your team doing /team invite [username]");
        }
    }

    public static Team getPlayerTeam(Player p) {
        return Bukkit.getScoreboardManager().getMainScoreboard().getPlayerTeam(p);
    }

    public static void leaveTeam(Player p) {
        if (getPlayerTeam(p) != null) {
            Bukkit.getScoreboardManager().getMainScoreboard().getPlayerTeam(p).removePlayer(p);
            p.sendMessage(ChatColor.BLUE + "You left the team!");
        }
    }

    public static void kickPlayer(Player t, OfflinePlayer p) {
        if (Bukkit.getScoreboardManager().getMainScoreboard().getPlayerTeam(p).equals(Bukkit.getScoreboardManager().getMainScoreboard().getPlayerTeam(t))) {
            Bukkit.getScoreboardManager().getMainScoreboard().getPlayerTeam(p).removePlayer(p);
            t.sendMessage(ChatColor.DARK_RED + "You kicked " + p.getName() + " from your team!");
            if (p.isOnline()) {
                Player player = (Player) p;
                player.sendMessage(ChatColor.RED + "You were kicked out of the team!");
            }
        }
    }

    public static void inviteToTeam(Player p, Player targetP) {
        Team team = (getPlayerTeam(p) == null) ? null : getPlayerTeam(p);
        if (team == null) {
            p.sendMessage(ChatColor.RED + "You are in an invalid team. Are you in a team before inviting??");
        } else {
            targetP.sendMessage(ChatColor.GREEN + p.getName() + " have invited you to their team! Type /team join " + team.getName());
            teamInvites.put(targetP.getName(), team);
            p.sendMessage(ChatColor.DARK_GREEN + "Invite sent to " + targetP.getName());
        }
    }

    public static Team getTeam(String s) {
        return Bukkit.getScoreboardManager().getMainScoreboard().getTeam(s);
    }

}
