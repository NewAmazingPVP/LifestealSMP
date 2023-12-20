package newamazingpvp.lifestealsmp.game;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.OfflinePlayer;
import org.bukkit.entity.Player;
import org.bukkit.scoreboard.Scoreboard;
import org.bukkit.scoreboard.ScoreboardManager;
import org.bukkit.scoreboard.Team;

import java.util.HashMap;

public class TeamsManager {
    private static HashMap<String, Team> teamInvites = new HashMap<>();
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

            sendTeamMessage(p, " I have joined the team!", team);
            teamInvites.remove(p.getName());
        } else {
            p.sendMessage(ChatColor.RED + "Invalid team invite. Ask someone to send you an invite again.");
        }
    }

    public static void sendTeamMessage(Player p, String msg, Team t){

        Scoreboard scoreboard = Bukkit.getScoreboardManager().getMainScoreboard();
        Team team = scoreboard.getTeam(t.getName());

        for(OfflinePlayer teamMate : team.getPlayers()){
            if(teamMate.isOnline()){
                Player player = (Player) teamMate;
                player.sendMessage(ChatColor.AQUA + "Team: " + ChatColor.RESET + "<" + p.getName() + "> " + msg);
            }
        }
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
