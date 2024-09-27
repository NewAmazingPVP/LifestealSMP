package newamazingpvp.lifestealsmp.events;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

import java.time.ZonedDateTime;

public class TournamentRegister implements CommandExecutor {
    private TournamentEvent tournamentEvent;


    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (command.getName().equalsIgnoreCase("register")) {
            if (sender instanceof Player) {
                Player player = (Player) sender;
                tournamentEvent.registerPlayer(player);
                return true;
            }
        }
        return false;
    }
}