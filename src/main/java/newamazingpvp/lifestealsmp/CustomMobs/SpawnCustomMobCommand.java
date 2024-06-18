package newamazingpvp.lifestealsmp.CustomMobs;

import newamazingpvp.lifestealsmp.CustomMobs.Mobs.lightningZombieCreate;
import newamazingpvp.lifestealsmp.CustomMobs.Mobs.spawnDeadMiner;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.command.*;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

import static newamazingpvp.lifestealsmp.customitems.utils.ItemStacks.*;
import static newamazingpvp.lifestealsmp.runes.RunesDrops.*;
import static newamazingpvp.lifestealsmp.runes.RunesDrops.airRune;

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

        //new lightningZombieCreate(location);
        new spawnDeadMiner(location);

        return true;


    }
}

