package newamazingpvp.lifestealsmp.command;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Sound;
import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class CustomDistance implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (cmd.getName().equalsIgnoreCase("setview")) {
            if (args.length == 1 && args[0].equalsIgnoreCase("get")) {
                for (World world : Bukkit.getWorlds()) {
                    sender.sendMessage(ChatColor.GREEN + "World: " + world.getName() +
                            ChatColor.WHITE + " - Render Distance: " + world.getViewDistance() +
                            ", Simulation Distance: " + world.getSimulationDistance());
                }
                return true;
            }

            if (args.length != 2 && args.length != 3) {
                sender.sendMessage("Usage: /setview <render_distance> <simulation_distance> [world]");
                return true;
            }

            int renderDistance;
            int simulationDistance;
            try {
                renderDistance = Integer.parseInt(args[0]);
                simulationDistance = Integer.parseInt(args[1]);

                if (renderDistance < 1 || renderDistance > 32 || simulationDistance < 1 || simulationDistance > 32) {
                    sender.sendMessage("Render and simulation distances should be integers in the range [1, 32].");
                    return true;
                }
            } catch (Exception e) {
                sender.sendMessage("An error occurred while setting the distances. Render and simulation distances should be integers in the range [1, 32]. Please try again.");
                return true;
            }

            if (args.length == 3) {
                String worldName = args[2].toLowerCase();
                World world = Bukkit.getWorld(worldName);
                if (world == null) {
                    sender.sendMessage("World '" + args[2] + "' not found.");
                    return true;
                }

                world.setViewDistance(renderDistance);
                world.setSimulationDistance(simulationDistance);
                sender.sendMessage("Render distance has been set to " + ChatColor.AQUA + renderDistance + ChatColor.WHITE + " and simulation distance to " + ChatColor.AQUA + simulationDistance + ChatColor.WHITE + " for world " + ChatColor.GOLD + world.getName() + ChatColor.WHITE + ".");
            } else {
                for (World world : Bukkit.getWorlds()) {
                    world.setViewDistance(renderDistance);
                    world.setSimulationDistance(simulationDistance);
                }
                sender.sendMessage("Render distance has been set to " + ChatColor.AQUA + renderDistance + ChatColor.WHITE + " and simulation distance to " + ChatColor.AQUA + simulationDistance + ChatColor.WHITE + " for all worlds.");
            }

            if (sender instanceof Player) {
                Player player = (Player) sender;
                player.playSound(player.getLocation(), Sound.BLOCK_NOTE_BLOCK_PLING, 1.0f, 2.0f);
            }
            return true;
        }
        return false;
    }
}
