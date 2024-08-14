package newamazingpvp.lifestealsmp.unused.events.raffle.commands;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import static newamazingpvp.lifestealsmp.unused.events.raffle.RaffleMain.endRaffleEvent;
import static newamazingpvp.lifestealsmp.unused.events.raffle.RaffleMain.isRaffleEventRunning;

public class StopRaffleEvent implements CommandExecutor {


    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        Player player = (Player) sender;

        if (isRaffleEventRunning) {
            player.sendMessage(ChatColor.GREEN + "" + ChatColor.BOLD + "Stopping raffle event");
            Bukkit.broadcastMessage(ChatColor.DARK_RED + "" + ChatColor.BOLD + "Event was stopped!");
            endRaffleEvent();
        } else {
            player.sendMessage(ChatColor.DARK_RED + "" + ChatColor.BOLD + "Event is already toggled off");
        }


        return true;
    }


}
