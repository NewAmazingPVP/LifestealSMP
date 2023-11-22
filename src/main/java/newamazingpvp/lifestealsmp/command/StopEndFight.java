package newamazingpvp.lifestealsmp.command;

import org.bukkit.ChatColor;
import org.bukkit.WorldBorder;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

import static newamazingpvp.lifestealsmp.variables.Misc.endFightParticipants;
import static newamazingpvp.lifestealsmp.variables.Misc.isEndFightEnabled;
import static org.bukkit.Bukkit.getServer;

public class StopEndFight implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        isEndFightEnabled = false;
        endFightParticipants.clear();
        return true;
    }
}
