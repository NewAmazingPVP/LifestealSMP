package newamazingpvp.lifestealsmp.CustomMobs;

import newamazingpvp.lifestealsmp.CustomMobs.Mobs.LightningZombie.SpawnLightningZombie;
import newamazingpvp.lifestealsmp.CustomMobs.Mobs.DeadMiner.SpawnDeadMiner;
import org.bukkit.Location;
import org.bukkit.command.*;
import org.bukkit.entity.Player;

public class SpawnCustomMobCommand implements CommandExecutor {


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

        new SpawnLightningZombie(location);
        new SpawnDeadMiner(location);

        return true;


    }
}

