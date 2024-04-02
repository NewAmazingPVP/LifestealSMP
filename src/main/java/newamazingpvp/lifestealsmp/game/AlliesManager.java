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

import static newamazingpvp.lifestealsmp.game.TeamsManager.playerTeamChat;
import static newamazingpvp.lifestealsmp.game.TeamsManager.sendTeamMessage;

public class AlliesManager {
    private static HashMap<Team, ArrayList<Team>> allies = new HashMap<>();

    private static HashMap<Team, Team> wantedAllies = new HashMap<>();
    public static List<UUID> playerAlliesChat = new ArrayList<>();

    public static void addAlly(Team t, Team invited) {
        if (allies.containsKey(t)) {
            ArrayList<Team> currentAllies = allies.get(t);
            if (allies.containsKey(invited)) {
                currentAllies.addAll(allies.get(invited));
                allies.remove(invited);
            } else {
                currentAllies.add(invited);
            }
            allies.put(t, currentAllies);
        } else {
            ArrayList<Team> currentAllies = new ArrayList<>();
            if (allies.containsKey(invited)) {
                currentAllies.addAll(allies.get(invited));
                allies.remove(invited);
            } else {
                currentAllies.add(invited);
            }
            allies.put(t, currentAllies);
        }
    }

    public static void wantedAlly(Team t, Team invited){
        wantedAllies.put(t, invited);
        sendTeamMessage(t, ChatColor.LIGHT_PURPLE + "Team " + invited.getName() + " has received your ally request");
        sendTeamMessage(invited, ChatColor.LIGHT_PURPLE + "Team " + invited.getName() + " has invited to ally with them. Do /team ally accept");
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

        Scoreboard scoreboard = Bukkit.getScoreboardManager().getMainScoreboard();
        Team team = scoreboard.getPlayerTeam(p);
        if(team == null) return;

        if(allies.containsKey(team)){
            for(Team t: allies.get(team)){
                for(OfflinePlayer teamMate : t.getPlayers()) {
                    if(teamMate.isOnline()) {
                        Player player = (Player) teamMate;
                        player.sendMessage(ChatColor.LIGHT_PURPLE + "Ally: " + ChatColor.RESET + "<" + p.getName() + "> " + msg);
                    }
                }
            }
            sendTeamMessage(team, ChatColor.LIGHT_PURPLE + "Ally: " + ChatColor.RESET + "<" + p.getName() + "> " + msg);
        } else{
            for (Team allyTeam : allies.keySet()) {
                if (allies.get(allyTeam).contains(team)) {
                    for (OfflinePlayer teamMate : allyTeam.getPlayers()) {
                        if (teamMate.isOnline()) {
                            Player player = (Player) teamMate;
                            player.sendMessage(ChatColor.LIGHT_PURPLE + "Ally: " + ChatColor.RESET + "<" + p.getName() + "> " + msg);
                        }
                    }
                    sendTeamMessage(team, ChatColor.LIGHT_PURPLE + "Ally: " + ChatColor.RESET + "<" + p.getName() + "> " + msg);
                    break;
                }
            }
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

    public static boolean isPlayerInAllyChat(Player p){
        return playerAlliesChat.contains(p.getUniqueId());
    }
}
