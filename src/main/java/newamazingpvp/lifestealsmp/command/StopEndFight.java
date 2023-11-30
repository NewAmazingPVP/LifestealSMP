package newamazingpvp.lifestealsmp.command;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

import static newamazingpvp.lifestealsmp.variables.Misc.endFightParticipants;
import static newamazingpvp.lifestealsmp.variables.Misc.isEndFightEnabled;

public class StopEndFight implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        isEndFightEnabled = false;
        endFightParticipants.clear();
        return true;
    }
}
