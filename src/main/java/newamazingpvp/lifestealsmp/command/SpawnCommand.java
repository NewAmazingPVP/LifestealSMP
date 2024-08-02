package newamazingpvp.lifestealsmp.command;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import static newamazingpvp.lifestealsmp.listener.SpawnProtection.isWithinSpawnRadius;

public class SpawnCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (sender instanceof Player player) {
            if (player.getWorld().getName().equalsIgnoreCase("uhcpvp_world")) return false;
            if (isWithinSpawnRadius(player.getLocation())) {
                player.teleport(Bukkit.getWorld("world").getSpawnLocation());
                return true;
            } else {
                sender.sendMessage("Only players near overworld spawn can use this command.");
                return false;
            }
        }
        return false;
    }
}
