package newamazingpvp.lifestealsmp.unused.endfight.bosscommands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import static newamazingpvp.lifestealsmp.unused.endfight.bossevents.DeathBeaconEvent.deathBeaconWarnTitle;
import static newamazingpvp.lifestealsmp.unused.endfight.bossevents.DeathBeaconEvent.runDeathBeaconTimer;


public class BeaconTestCMD implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {


        if (sender instanceof Player player) {


            runDeathBeaconTimer(player);
            deathBeaconWarnTitle();


        }


        return true;
    }


}
