package newamazingpvp.lifestealsmp.custommobs;

import newamazingpvp.lifestealsmp.custommobs.mobs.Shadow.SpawningShadow.SpawnShadow;
import org.bukkit.Location;
import org.bukkit.command.*;
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
        new SpawnShadow(location);

        return true;


    }
}

