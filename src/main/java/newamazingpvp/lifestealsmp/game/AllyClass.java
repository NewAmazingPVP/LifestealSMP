package newamazingpvp.lifestealsmp.game;

import org.bukkit.OfflinePlayer;
import org.bukkit.entity.Player;
import org.bukkit.scoreboard.Team;

import java.util.ArrayList;
import java.util.HashSet;

public class AllyClass {
    HashSet<Team> allies;
    public AllyClass (Team t){
        allies = new HashSet<>();
        allies.add(t);
    }

    public AllyClass (Team t, Team inv){
        allies = new HashSet<>();
        allies.add(t);
        allies.add(inv);
    }

    public AllyClass (){
        allies = new HashSet<>();
    }

    public void addAlly(Team t){
        allies.add(t);
    }

    public void removeAlly(Team t){
        allies.remove(t);
    }

    public HashSet<Team> getAllies(){
        return allies;
    }

    public boolean hasTeam(Team t){
        return allies.contains(t);
    }

    public void sendAllyMessage(String msg){
        for(Player p: getOnlineMembers()){
            p.sendMessage(msg);
        }
    }

    public ArrayList<OfflinePlayer> getMembers(){
        ArrayList<OfflinePlayer> players = new ArrayList<>();
        for(Team t: allies) {
            for (OfflinePlayer teamMate : t.getPlayers()) {
                players.add(teamMate);
            }
        }
        return players;
    }

    public ArrayList<Player> getOnlineMembers() {
        ArrayList<Player> players = new ArrayList<>();
        for(Team t: allies) {
            for (OfflinePlayer teamMate : t.getPlayers()) {
                if(teamMate.isOnline()) {
                    players.add((Player)teamMate);
                }
            }
        }
        return  players;
    }


}
