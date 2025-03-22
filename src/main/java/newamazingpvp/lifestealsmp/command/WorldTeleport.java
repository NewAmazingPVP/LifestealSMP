package newamazingpvp.lifestealsmp.command;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

public class WorldTeleport implements CommandExecutor, TabCompleter {


    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (!(sender instanceof Player player)) {
            sender.sendMessage("Only players can use this command.");
            return true;
        }

        if (args.length < 1) {
            player.sendMessage("Usage: /teleport <worldName>");
            return false;
        }

        String worldName = args[0];
        World world = Bukkit.getWorld(worldName);

        if (world == null) {
            player.sendMessage("World '" + worldName + "' does not exist.");
            return true;
        }

        player.teleportAsync(new Location(world, 0, 100, 0));

        player.sendMessage("Teleported to world '" + worldName + "'.");
        return true;
    }

    @Override
    public List<String> onTabComplete(CommandSender sender, Command command, String alias, String[] args) {
        List<String> completions = new ArrayList<>();

        Optional.ofNullable(Bukkit.getWorlds())
                .ifPresent(worlds -> {
                    if (args.length == 1) {
                        completions.addAll(worlds.stream()
                                .filter(Objects::nonNull)
                                .map(World::getName)
                                .collect(Collectors.toList()));
                    }
                });

        return completions;
    }
}
