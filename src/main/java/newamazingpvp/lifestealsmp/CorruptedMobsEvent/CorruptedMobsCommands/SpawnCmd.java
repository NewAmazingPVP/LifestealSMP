package newamazingpvp.lifestealsmp.CorruptedMobsEvent.CorruptedMobsCommands;

import newamazingpvp.lifestealsmp.CorruptedMobsEvent.EventMobs.Bomber.SpawnBomber.SpawnBomber;
import newamazingpvp.lifestealsmp.CorruptedMobsEvent.EventMobs.Enigma.SpawnEnigma.SpawnEnigma;
import newamazingpvp.lifestealsmp.CorruptedMobsEvent.EventMobs.Hydra.SpawnHydra.SpawnHydra;
import newamazingpvp.lifestealsmp.CorruptedMobsEvent.EventMobs.Mage.SpawnMage.SpawnMage;
import org.bukkit.Location;
import org.bukkit.command.BlockCommandSender;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;
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

        if (sender instanceof Player) {
            Player player = (Player) sender;
            location = player.getLocation();
        } else if (sender instanceof BlockCommandSender) {
            BlockCommandSender blockCommandSender = (BlockCommandSender) sender;
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
