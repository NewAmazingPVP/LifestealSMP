package newamazingpvp.lifestealsmp.RaffleEvent.RaffleEventCommands;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import static newamazingpvp.lifestealsmp.RaffleEvent.RaffleMain.isRaffleEventRunning;
import static newamazingpvp.lifestealsmp.RaffleEvent.RaffleMain.killRaffleBossBar;

public class StopRaffleEvent implements CommandExecutor {


    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        Player player = (Player) sender;

        if(isRaffleEventRunning){
            isRaffleEventRunning = false;
            player.sendMessage(ChatColor.GREEN + "" + ChatColor.BOLD + "Stopping raffle event" );
            killRaffleBossBar();
            Bukkit.broadcastMessage(ChatColor.DARK_RED + "" + ChatColor.BOLD + "Event was stopped!");
        }else{
            player.sendMessage(ChatColor.DARK_RED + "" + ChatColor.BOLD + "Event is already toggled off you fucking idiot!" );
        }


        return true;
    }


}
