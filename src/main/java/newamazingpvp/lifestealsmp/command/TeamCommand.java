package newamazingpvp.lifestealsmp.command;

import org.bukkit.Bukkit;
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

import static newamazingpvp.lifestealsmp.game.TeamsManager.*;

public class TeamCommand  implements CommandExecutor, TabCompleter {
    private final ArrayList<String> teamFirstIndex = new ArrayList<>(List.of("join", "leave", "create", "invite"));
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        Player p = (Player) sender;
        if(args.length == 0){
            p.sendMessage("/team create" +
                    "\n/team join" +
                    "\n/team invite" +
                    "\n/team leave" +
                    "\n/team chat");
        } else if (args.length == 1) {
            if (args[0].equals("create")) {
                p.sendMessage("Incorrect command usage. Type /team create [teamName]");
            } else if (args[0].equals("join")) {
                p.sendMessage("Incorrect command usage. Type /team join [teamName]");
            }  else if (args[0].equals("invite")) {
                p.sendMessage("Incorrect command usage. Type /team invite [playerName]");
            } else if (args[0].equals("leave")) {
                leaveTeam(p);
            }
        } else if (args.length == 2) {
            if (args[0].equals("create")) {
                createTeam(p, args[1]);
            } else if (args[0].equals("join")) {
                joinTeam(p, args[1]);
            } else if (args[0].equals("invite")) {
                inviteToTeam(p, Bukkit.getPlayer(args[1]));
            }
        }
        return true;
    }

    @Override
    public List<String> onTabComplete(CommandSender sender, Command command, String alias, String[] args) {
        if (args.length == 1) {
            return teamFirstIndex;
        } else if(args.length == 2) {
            if (args[0].equals("create") || args[0].equals("join")) {
                ArrayList<String> teamNames = new ArrayList<>();
                for (Team t : Bukkit.getScoreboardManager().getMainScoreboard().getTeams()) {
                    teamNames.add(t.getName());
                }
                return teamNames;
            }
        }
        return null;
    }
}
