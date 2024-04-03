package newamazingpvp.lifestealsmp.game;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.OfflinePlayer;
import org.bukkit.Particle;
import org.bukkit.entity.Player;
import org.bukkit.scoreboard.Scoreboard;
import org.bukkit.scoreboard.Team;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.UUID;

import static newamazingpvp.lifestealsmp.game.TeamsManager.*;

public class AlliesManager {

    private static ArrayList<AllyClass> allAllies = new ArrayList<>();
    private static HashMap<Team, Team> wantedAllies = new HashMap<>();
    public static List<UUID> playerAlliesChat = new ArrayList<>();

    public static void addAlly(Team t, Team invited) {
        if(getAllyClasIndex(t, invited) != -1){
            int index = getAllyClasIndex(t, invited);
            allAllies.get(index).addAlly(t);
            allAllies.get(index).addAlly(invited);
        } else {
            allAllies.add(new AllyClass(t, invited));
        }
    }

    public static void wantedAlly(Team t, Team invited){
        wantedAllies.put(t, invited);
        sendTeamMessage(t, ChatColor.LIGHT_PURPLE + "Team " + invited.getName() + " has received your ally request");
        sendTeamMessage(invited, ChatColor.LIGHT_PURPLE + "Team " + invited.getName() + " has invited to ally with them. Do /ally accept");
    }

    public static boolean isWantedAlly(Team t){
        return (wantedAllies.containsKey(t) || wantedAllies.containsValue(t));
    }

    public static void allyWantedTeam(Team t){
        if(wantedAllies.containsKey(t)){
            addAlly(t, wantedAllies.get(t));
            sendTeamMessage(t, ChatColor.LIGHT_PURPLE + "Now allied with " + wantedAllies.get(t));
            sendTeamMessage(wantedAllies.get(t), ChatColor.LIGHT_PURPLE + "Now allied with " + t.getName());
            wantedAllies.remove(t);
        } else {
            for (Team allyTeam : wantedAllies.keySet()) {
                if (wantedAllies.get(allyTeam).equals(t)) {
                    addAlly(t, allyTeam);
                    sendTeamMessage(t, ChatColor.LIGHT_PURPLE + "Now allied with " + allyTeam.getName());
                    sendTeamMessage(allyTeam, ChatColor.LIGHT_PURPLE + "Now allied with " + t.getName());
                    wantedAllies.remove(allyTeam);
                }
            }
        }
    }

    public static void sendAllyMessage(Player p, String msg){
        if(getPlayerTeam(p) == null) return;
        int index = getAllyClasIndex(getPlayerTeam(p));
        if(index != -1){
            allAllies.get(index).sendAllyMessage(msg);
        }

    }

    public static void allyChatMode(Player p)
    {
        if(!playerAlliesChat.contains(p.getUniqueId())) {
            playerAlliesChat.add(p.getUniqueId());
            playerTeamChat.remove(p.getUniqueId());
            p.sendMessage(ChatColor.LIGHT_PURPLE + "Your messages now go to ally chat!");
        } else {
            playerAlliesChat.remove(p.getUniqueId());
            p.sendMessage(ChatColor.GOLD + "Your messages now go to global chat!");
        }
    }

    public static int getAllyClasIndex(Team t, Team inv){
        for(int i = 0; i < allAllies.size(); i++){
            if(allAllies.get(i).hasTeam(t) || allAllies.get(i).hasTeam(inv)){
                return i;
            }
        }
        return -1;
    }

    public static int getAllyClasIndex(Team t){
        for(int i = 0; i < allAllies.size(); i++){
            if(allAllies.get(i).hasTeam(t)){
                return i;
            }
        }
        return -1;
    }


    public static boolean isPlayerInAllyChat(Player p){
        return playerAlliesChat.contains(p.getUniqueId());
    }

    public static void leaveAlly(Player p){
        if(getPlayerTeam(p) != null){
            int index = getAllyClasIndex(getPlayerTeam(p));
            allAllies.get(index).removeAlly(getPlayerTeam(p));
        }
    }


}
