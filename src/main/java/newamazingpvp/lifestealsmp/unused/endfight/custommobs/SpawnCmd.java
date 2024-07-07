package newamazingpvp.lifestealsmp.unused.endfight.custommobs;

import newamazingpvp.lifestealsmp.unused.endfight.custommobs.mobs.minishadow.spawning.SpawnMiniShadow;
import org.bukkit.Location;
import org.bukkit.command.BlockCommandSender;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class SpawnCmd implements CommandExecutor {


    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        Location location = null;

        if (sender instanceof Player) {
            Player player = (Player) sender;
            location = player.getLocation();
        } else if (sender instanceof BlockCommandSender) {
            BlockCommandSender blockCommandSender = (BlockCommandSender) sender;
            location = blockCommandSender.getBlock().getLocation();
        }

        //new SpawnLightningZombie(location);
        //new SpawnDeadMiner(location);
        //new SpawnShadow(location);
        new SpawnMiniShadow(location);

        return true;


    }
}

