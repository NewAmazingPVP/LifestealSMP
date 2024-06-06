package newamazingpvp.lifestealsmp.allyteams;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.OfflinePlayer;
import org.bukkit.entity.Player;
import org.bukkit.scoreboard.Team;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;

import static newamazingpvp.lifestealsmp.allyteams.TeamsManager.sendTeamMessage;

public class AllyClass implements Serializable {
    private static final long serialVersionUID = 1L;

    private HashSet<String> allyTeamNames;

    public AllyClass(Team t) {
        allyTeamNames = new HashSet<>();
        allyTeamNames.add(t.getName());
    }

    public AllyClass(Team t, Team inv) {
        allyTeamNames = new HashSet<>();
        allyTeamNames.add(t.getName());
        allyTeamNames.add(inv.getName());
    }

    public AllyClass() {
        allyTeamNames = new HashSet<>();
    }

    public void addAlly(Team t) {
        allyTeamNames.add(t.getName());
        sendAllyMessage(ChatColor.DARK_PURPLE + t.getName() + " has joined the alliance!");
    }

    public void removeAlly(Team t) {
        if (allyTeamNames.remove(t.getName())) {
            sendAllyMessage(ChatColor.RED + t.getName() + " has left the alliance");
            sendTeamMessage(t, ChatColor.RED + "Your team has left the alliance");
        }
    }

    public HashSet<Team> getAllies() {
        HashSet<Team> allies = new HashSet<>();
        for (String teamName : allyTeamNames) {
            Team t = Bukkit.getScoreboardManager().getMainScoreboard().getTeam(teamName);
            if (t != null) allies.add(t);
        }
        return allies;
    }

    public boolean hasTeam(Team t) {
        return allyTeamNames.contains(t.getName());
    }

    public void sendAllyMessage(String msg, Player player) {
        for (Player p : getOnlineMembers()) {
            p.sendMessage(ChatColor.LIGHT_PURPLE + "Ally: " + ChatColor.RESET + "<" + player.getName() + "> " + msg);
        }
    }

    public void sendAllyMessage(String msg) {
        for (Player p : getOnlineMembers()) {
            p.sendMessage(msg);
        }
    }

    public ArrayList<OfflinePlayer> getMembers() {
        ArrayList<OfflinePlayer> players = new ArrayList<>();
        for (Team t : getAllies()) {
            for (OfflinePlayer teamMate : t.getPlayers()) {
                players.add(teamMate);
            }
        }
        return players;
    }

    public ArrayList<Player> getOnlineMembers() {
        ArrayList<Player> players = new ArrayList<>();
        for (Team t : getAllies()) {
            for (OfflinePlayer teamMate : t.getPlayers()) {
                if (teamMate.isOnline()) {
                    players.add((Player) teamMate);
                }
            }
        }
        return players;
    }
}
