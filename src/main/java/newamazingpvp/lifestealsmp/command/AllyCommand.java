package newamazingpvp.lifestealsmp.command;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.OfflinePlayer;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;
import org.bukkit.entity.Player;
import org.bukkit.scoreboard.Team;

import java.util.ArrayList;
import java.util.List;

import static newamazingpvp.lifestealsmp.game.AlliesManager.*;
import static newamazingpvp.lifestealsmp.game.TeamsManager.*;

public class AllyCommand implements CommandExecutor, TabCompleter {

    private final ArrayList<String> allyFirstIndex = new ArrayList<>(List.of("invite", "accept", "chat", "kick", "leave", "list", "members"));
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        Player p = (Player) sender;
        if(args.length == 0 || (args.length == 1 && args[0].equals("help"))){
            p.sendMessage(ChatColor.GOLD +
                    "\n/ally accept" +
                    "\n/ally invite" +
                    "\n/ally leave" +
                    "\n/ally chat" +
                    "\n/ally kick" +
                    "\n/ally list" +
                    "\n/ally members");
        } else if (args.length == 1) {
            if(args[0].equals("leave")) {
                leaveAlly(p);
            } else if(args[0].equals("chat")){
                allyChatMode(p);
            } else if (args[0].equals("invite")) {
                p.sendMessage(ChatColor.RED + "Incorrect command usage. Type /ally invite [teamName]");
            } else if (args[0].equals("kick")) {
                p.sendMessage(ChatColor.RED + "Incorrect command usage. Type /ally kick [teamName]");
            } else if (args[0].equals("list")) {
                p.sendMessage(ChatColor.GOLD + "List of all the allied teams in the alliance!");
                for(String s: getAllianceTeams(p)){
                    p.sendMessage(ChatColor.LIGHT_PURPLE + s);
                }
            } else if (args[0].equals("members")) {
                p.sendMessage(ChatColor.DARK_PURPLE + "Here are your alliance members:");
                for(String s: getAllianceMembers(p)){
                    p.sendMessage(ChatColor.DARK_BLUE + s);
                }
            }  else if (args[0].equals("accept")){
                allyWantedTeam(getPlayerTeam(p));
            }
        } else if (args.length == 2) {
            if (args[0].equals("invite")) {
                wantedAlly(p, args[1]);
            } else if(args[0].equals("chat")){
                sendAllyMessage(p, args[1]);
            } else if(args[0].equals("kick")){
                removeAlly(p, getTeam(args[1]));
            } else if (args[0].equals("leave")) {
                removeTeam(getPlayerTeam(p));
            }
        }
        return true;
    }


    @Override
    public List<String> onTabComplete(CommandSender sender, Command command, String alias, String[] args) {
        Player p = (Player) sender;
        if (args.length == 1) {
            return allyFirstIndex;
        } else if(args.length == 2) {
            if (args[0].equals("invite")) {
                ArrayList<String> teamNames = new ArrayList<>();
                for (Team t : Bukkit.getScoreboardManager().getMainScoreboard().getTeams()) {
                    teamNames.add(t.getName());
                }
                return teamNames;
            } else if(args[0].equals("kick")){
                return getAllianceTeams(p);
            }
        }
        return null;
    }
}
