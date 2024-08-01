package newamazingpvp.lifestealsmp.unused.events.corruptedmobs.commands;

import newamazingpvp.lifestealsmp.unused.events.corruptedmobs.mobs.bomber.spawn.SpawnBomber;
import newamazingpvp.lifestealsmp.unused.events.corruptedmobs.mobs.engima.spawn.SpawnEnigma;
import newamazingpvp.lifestealsmp.unused.events.corruptedmobs.mobs.hydra.spawn.SpawnHydra;
import newamazingpvp.lifestealsmp.unused.events.corruptedmobs.mobs.mage.spawn.SpawnMage;
import org.bukkit.Location;
import org.bukkit.command.*;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.List;

public class SpawnCmd implements CommandExecutor, TabCompleter {

    private final ArrayList<String> subcommands = new ArrayList<>(List.of("mage", "hydra", "enigma", "detonator"));

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (args.length == 0) {
            sender.sendMessage("Please specify a mob to spawn.");
            return false;
        }

        Location location = null;

        if (sender instanceof Player player) {
            location = player.getLocation();
        } else if (sender instanceof BlockCommandSender blockCommandSender) {
            location = blockCommandSender.getBlock().getLocation();
        }

        if (location == null) {
            sender.sendMessage("Could not determine location to spawn mob.");
            return false;
        }

        switch (args[0].toLowerCase()) {
            case "mage":
                new SpawnMage(location);
                break;
            case "hydra":
                new SpawnHydra(location);
                break;
            case "enigma":
                new SpawnEnigma(location);
                break;
            case "detonator":
                new SpawnBomber(location);
                break;
            default:
                sender.sendMessage("Unknown mob type.");
                return false;
        }

        return true;
    }

    @Override
    public List<String> onTabComplete(CommandSender sender, Command command, String alias, String[] args) {
        if (args.length == 1) {
            List<String> completions = new ArrayList<>();
            for (String subcommand : subcommands) {
                if (subcommand.startsWith(args[0].toLowerCase())) {
                    completions.add(subcommand);
                }
            }
            return completions;
        }
        return null;
    }
}
