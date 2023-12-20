package newamazingpvp.lifestealsmp.game;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.OfflinePlayer;
import org.bukkit.entity.Player;
import org.bukkit.scoreboard.Scoreboard;
import org.bukkit.scoreboard.ScoreboardManager;
import org.bukkit.scoreboard.Team;

public class TeamsManager {
    public void joinTeam(Player p, String teamName){
        Player player = Bukkit.getPlayer(p.getName());
        if (player == null) {
            p.sendMessage("Player not found.");
            return;
        }

        ScoreboardManager scoreboardManager = Bukkit.getScoreboardManager();
        Scoreboard scoreboard = scoreboardManager.getMainScoreboard();
        Team team = (scoreboard.getTeam(teamName) != null) ? scoreboard.getTeam(teamName) : null;
        if(team == null){
            p.sendMessage(ChatColor.RED + "This team does not exist!");
            return;
        }
        team.addEntry(player.getName());

        sendTeamMessage(p, " I have joined the team!" , team);
    }

    public void sendTeamMessage(Player p, String msg, Team t){

        ScoreboardManager scoreboardManager = Bukkit.getScoreboardManager();
        Scoreboard scoreboard = scoreboardManager.getMainScoreboard();
        Team team = scoreboard.getTeam(t.getName());

        for(OfflinePlayer teamMate : team.getPlayers()){
            if(teamMate.isOnline()){
                Player player = (Player) teamMate;
                player.sendMessage(ChatColor.AQUA + "Team: " + ChatColor.RESET + "<" + p.getName() + "> " + msg);
            }
        }
    }

    public void createTeam(Player p, String teamName){
        ScoreboardManager scoreboardManager = Bukkit.getScoreboardManager();
        Scoreboard scoreboard = scoreboardManager.getMainScoreboard();
        Team team = (scoreboard.getTeam(teamName) != null) ? null : scoreboard.registerNewTeam(teamName);;
        if (team == null) {
            p.sendMessage(ChatColor.RED + "Team with this name already exists!");
        } else {
            joinTeam(p, team.getName());
        }
    }

    public void inviteToTeam(Player p, Player targetP, String teamName){
        
    }

}
