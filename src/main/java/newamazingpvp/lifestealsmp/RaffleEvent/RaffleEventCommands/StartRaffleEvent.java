package newamazingpvp.lifestealsmp.RaffleEvent.RaffleEventCommands;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import static newamazingpvp.lifestealsmp.RaffleEvent.RaffleMain.isRaffleEventRunning;
import static newamazingpvp.lifestealsmp.RaffleEvent.RaffleMain.startRaffleEvent;

public class StartRaffleEvent implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if (sender instanceof Player){

            Player player = (Player) sender;

            if(!isRaffleEventRunning){
                isRaffleEventRunning = true;
                player.sendMessage(ChatColor.GREEN + "" + ChatColor.BOLD + "Starting raffle event" );
                startRaffleEvent(player);
            }else{
                player.sendMessage(ChatColor.DARK_RED + "" + ChatColor.BOLD + "Event is already toggled on you fucking idiot!" );
            }


        }



        return true;
    }


}
