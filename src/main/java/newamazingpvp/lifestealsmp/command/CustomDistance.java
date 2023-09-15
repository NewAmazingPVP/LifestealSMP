package newamazingpvp.lifestealsmp.command;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.logging.Level;

public class CustomDistance implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (!(sender instanceof Player)) {
            sender.sendMessage("This command can only be used by players.");
            return true;
        }

        Player player = (Player) sender;
        if (cmd.getName().equalsIgnoreCase("setview")) {
            if (args.length != 2) {
                player.sendMessage("Usage: /setview <render_distance> <simulation_distance>");
                return true;
            }

            if (!player.hasPermission("customview.set")) {
                player.sendMessage("You don't have permission to use this command.");
                return true;
            }

            int renderDistance;
            int simulationDistance;
            try {
                renderDistance = Integer.parseInt(args[0]);
                simulationDistance = Integer.parseInt(args[1]);

                if (renderDistance < 0 || renderDistance > 33 || simulationDistance < 0 || simulationDistance > 33) {
                    player.sendMessage("Render and simulation distances should be integers in the range [1, 32].");
                    return true;
                }
            } catch (Exception e) {
                player.sendMessage("An error occurred while setting the distances. Render and simulation distances should be integers in the range [1, 32]. Please try again.");
                return true;
            }

            player.setViewDistance(renderDistance);
            player.setSimulationDistance(simulationDistance);
            player.sendMessage("Your render distance has been set to " + ChatColor.AQUA + renderDistance + ChatColor.WHITE + " and simulation distance to " + ChatColor.AQUA + simulationDistance + ChatColor.WHITE + ".");

            return true;
        }
        return false;
    }
}
