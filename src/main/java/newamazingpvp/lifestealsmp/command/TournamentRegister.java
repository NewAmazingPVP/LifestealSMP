package newamazingpvp.lifestealsmp.command;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

import java.time.ZonedDateTime;

import static newamazingpvp.lifestealsmp.events.TournamentEvent.isTournamentEvent;
import static newamazingpvp.lifestealsmp.events.TournamentEvent.registerPlayer;
import static newamazingpvp.lifestealsmp.events.UHCPvPEvent.isUhcEvent;

public class TournamentRegister implements CommandExecutor {


    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (isTournamentEvent) {
            if (sender instanceof Player player) {
                registerPlayer(player);
                return true;
            }
        }
        return false;
    }
}