package newamazingpvp.lifestealsmp.RaffleEvent.RaffleEventCommands;

import newamazingpvp.lifestealsmp.RaffleEvent.RaffleCustomMobs.Enigma.SpawnEnigma.SpawnEnigma;
import newamazingpvp.lifestealsmp.RaffleEvent.RaffleCustomMobs.Mage.SpawnMage.SpawnMage;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import static newamazingpvp.lifestealsmp.RaffleEvent.RaffleCustomMobs.Enigma.EnigmaEvents.EnigmaGUI.startEnigmaMobPuzzle;
import static newamazingpvp.lifestealsmp.RaffleEvent.RaffleMain.*;

public class StopRaffleEvent implements CommandExecutor {


    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        Player player = (Player) sender;

        if(isRaffleEventRunning){
            player.sendMessage(ChatColor.GREEN + "" + ChatColor.BOLD + "Stopping raffle event" );
            Bukkit.broadcastMessage(ChatColor.DARK_RED + "" + ChatColor.BOLD + "Event was stopped!");
            endRaffleEvent();
        }else{
            player.sendMessage(ChatColor.DARK_RED + "" + ChatColor.BOLD + "Event is already toggled off you fucking idiot!" );
        }



        return true;
    }




}
