package newamazingpvp.lifestealsmp.endfight.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import static newamazingpvp.lifestealsmp.endfight.bossevents.DeathBeaconEvent.deathBeaconWarnTitle;
import static newamazingpvp.lifestealsmp.endfight.bossevents.DeathBeaconEvent.runDeathBeaconTimer;


public class BeaconTestCMD implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {


        if (sender instanceof Player) {
            Player player = (Player) sender;


            runDeathBeaconTimer(player);
            deathBeaconWarnTitle();


        }


        return true;
    }


}
