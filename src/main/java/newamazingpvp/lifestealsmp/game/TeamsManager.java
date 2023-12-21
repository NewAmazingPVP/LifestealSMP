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

public class TeamsManager {
    private static HashMap<String, Team> teamInvites = new HashMap<>();
    private static List<UUID> playerTeamChat;
    public static void joinTeam(Player p, String teamName){
        if(teamInvites.containsKey(p.getName())) {
            ScoreboardManager scoreboardManager = Bukkit.getScoreboardManager();
            Scoreboard scoreboard = scoreboardManager.getMainScoreboard();
            Team team = (scoreboard.getTeam(teamName) != null) ? scoreboard.getTeam(teamName) : null;
            if (team == null) {
                p.sendMessage(ChatColor.RED + "This team does not exist!");
                return;
            }
            team.addEntry(p.getName());

            sendTeamMessage(p, " I have joined the team!");
            teamInvites.remove(p.getName());
        } else {
            p.sendMessage(ChatColor.RED + "Invalid team invite. Ask someone to send you an invite again.");
        }
    }

    public static void sendTeamMessage(Player p, String msg){

        Scoreboard scoreboard = Bukkit.getScoreboardManager().getMainScoreboard();
        Team team = scoreboard.getPlayerTeam(p);
        if(team == null) return;

        for(OfflinePlayer teamMate : team.getPlayers()){
            if(teamMate.isOnline()){
                Player player = (Player) teamMate;
                player.sendMessage(ChatColor.AQUA + "Team: " + ChatColor.RESET + "<" + p.getName() + "> " + msg);
            }
        }
    }

    public static void teamChatMode(Player p)
    {
        if(playerTeamChat.contains(p.getUniqueId())) {
            playerTeamChat.add(p.getUniqueId());
            p.sendMessage("Your messages now go to team chat!");
        } else {
            playerTeamChat.remove(p.getUniqueId());
            p.sendMessage("Your messages now go to global chat!");
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

    public static boolean isPlayerInTeamChat(Player p){
        return playerTeamChat.contains(p.getUniqueId());
    }

    public static boolean onSameTeam(Player p, Player t){
        return getPlayerTeam(p).equals(getPlayerTeam(t));
    }


    public static void createTeam(Player p, String teamName){
        if(getPlayerTeam(p) != null)
        {
            p.sendMessage("You are already in a team! /team leave before making a new one!");
            return;
        }
        Scoreboard scoreboard = Bukkit.getScoreboardManager().getMainScoreboard();
        Team team = (scoreboard.getTeam(teamName) != null) ? null : scoreboard.registerNewTeam(teamName);;
        if (team == null) {
            p.sendMessage(ChatColor.RED + "Team with this name already exists!");
        } else {
            teamInvites.put(p.getName(), team);
            joinTeam(p, team.getName());
        }
    }

    public static Team getPlayerTeam(Player p){
        return Bukkit.getScoreboardManager().getMainScoreboard().getPlayerTeam(p);
    }

    public static void leaveTeam(Player p){
        if(getPlayerTeam(p) != null) {
            Bukkit.getScoreboardManager().getMainScoreboard().getPlayerTeam(p).removePlayer(p);
            p.sendMessage(ChatColor.BLUE + "You left the team!");
        }
    }

    public static void kickPlayer(OfflinePlayer p){
        if(Bukkit.getScoreboardManager().getMainScoreboard().getPlayerTeam(p) != null) {
            Bukkit.getScoreboardManager().getMainScoreboard().getPlayerTeam(p).removePlayer(p);
        }
    }

    public static void inviteToTeam(Player p, Player targetP){
        Team team = (getPlayerTeam(p) == null) ? null : getPlayerTeam(p);;
        if (team == null) {
            p.sendMessage(ChatColor.RED + "You are in an invalid team. Are you in a team before inviting??");
        } else {
            targetP.sendMessage(p.getName() + " have invited you to their team! Type /team join " + team.getName());
            teamInvites.put(targetP.getName(), team);
        }
    }

}
