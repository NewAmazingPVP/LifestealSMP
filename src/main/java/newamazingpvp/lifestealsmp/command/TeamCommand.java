package newamazingpvp.lifestealsmp.command;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;
import org.bukkit.entity.Player;
import org.bukkit.scoreboard.Team;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static newamazingpvp.lifestealsmp.game.AlliesManager.*;
import static newamazingpvp.lifestealsmp.game.TeamsManager.*;

public class TeamCommand  implements CommandExecutor, TabCompleter {
    private final ArrayList<String> teamFirstIndex = new ArrayList<>(List.of("join", "leave", "create", "invite", "chat", "kick", "list", "members", "ally"));
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        Player p = (Player) sender;
        if(args.length == 0 || (args.length == 1 && args[0].equals("help"))){
            p.sendMessage(ChatColor.GOLD + "/team create" +
                    "\n/team join" +
                    "\n/team invite" +
                    "\n/team leave" +
                    "\n/team chat" +
                    "\n/team kick" +
                    "\n/team list" +
                    "\n/team members");
        } else if (args.length == 1) {
            if(args[0].equals("leave")) {
                leaveTeam(p);
            } else if(args[0].equals("chat")){
                teamChatMode(p);
            } else if (args[0].equals("create")) {
                p.sendMessage(ChatColor.RED + "Incorrect command usage. Type /team create [teamName]");
            } else if (args[0].equals("join")) {
                p.sendMessage(ChatColor.RED + "Incorrect command usage. Type /team join [teamName]");
            }  else if (args[0].equals("invite")) {
                p.sendMessage(ChatColor.RED + "Incorrect command usage. Type /team invite [playerName]");
            } else if (args[0].equals("kick")) {
                p.sendMessage(ChatColor.RED + "Incorrect command usage. Type /team kick [playerName]");
            } else if (args[0].equals("list")) {
                p.sendMessage(ChatColor.GOLD + "List of all the teams in this server!");
                for(String s: getAllTeams()){
                    p.sendMessage(ChatColor.AQUA + s);
                }
            } else if (args[0].equals("members")) {
                p.sendMessage(ChatColor.DARK_PURPLE + "Here are your team members:");
                for(String s: getTeamMembers(p)){
                    p.sendMessage(ChatColor.DARK_BLUE + s);
                }
            }
        } else if (args.length == 2) {
            if (args[0].equals("create")) {
                createTeam(p, args[1]);
            } else if (args[0].equals("join")) {
                joinTeam(p, args[1]);
            } else if (args[0].equals("invite")) {
                inviteToTeam(p, Bukkit.getPlayer(args[1]));
            } else if(args[0].equals("chat")){
                sendTeamMessage(p, args[1]);
            } else if(args[0].equals("kick")){
                kickPlayer(p, Bukkit.getOfflinePlayer((args[1])));
            } else if (args[0].equals("ally") && args[1].equals("accept")){
                allyWantedTeam(getPlayerTeam(p));
            } else if (args[0].equals("ally") && args[1].equals("chat")){
                allyChatMode(p);
            } else if (args[0].equals("ally")) {
                wantedAlly(getPlayerTeam(p), Bukkit.getScoreboardManager().getMainScoreboard().getTeam(args[1]));
            }
        }
        return true;
    }

    @Override
    public List<String> onTabComplete(CommandSender sender, Command command, String alias, String[] args) {
        Player p = (Player) sender;
        if (args.length == 1) {
            return teamFirstIndex;
        } else if(args.length == 2) {
            if (args[0].equals("create") || args[0].equals("join") || args[0].equals("list") || args[0].equals("ally")) {
                ArrayList<String> teamNames = new ArrayList<>();
                for (Team t : Bukkit.getScoreboardManager().getMainScoreboard().getTeams()) {
                    teamNames.add(t.getName());
                }
                return teamNames;
            } else if(args[0].equals("kick")){
                return getTeamMembers(p);
            }
        }
        return null;
    }
}
