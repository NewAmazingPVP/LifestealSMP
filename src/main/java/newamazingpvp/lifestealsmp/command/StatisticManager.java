package newamazingpvp.lifestealsmp.command;

import org.bukkit.Bukkit;
import org.bukkit.Statistic;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;
import org.bukkit.entity.Player;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class StatisticManager implements CommandExecutor, TabCompleter {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (args.length < 4) {
            sender.sendMessage("Usage: /stat <player> <statistic> <increment/decrement/set> <value>");
            return false;
        }

        Player targetPlayer = Bukkit.getPlayer(args[0]);
        if (targetPlayer == null) {
            sender.sendMessage("Player not found.");
            return false;
        }

        Statistic statistic;
        try {
            statistic = Statistic.valueOf(args[1].toUpperCase());
        } catch (IllegalArgumentException e) {
            sender.sendMessage("Invalid statistic.");
            return false;
        }

        // Extract and validate the operation
        String operation = args[2].toLowerCase();
        if (!operation.equals("increment") && !operation.equals("decrement") && !operation.equals("set")) {
            sender.sendMessage("Operation must be 'increment', 'decrement', or 'set'.");
            return false;
        }

        int value;
        try {
            value = Integer.parseInt(args[3]);
        } catch (NumberFormatException e) {
            sender.sendMessage("Value must be a number.");
            return false;
        }

        if (operation.equals("increment")) {
            targetPlayer.incrementStatistic(statistic, value);
        } else if (operation.equals("decrement")) {
            targetPlayer.decrementStatistic(statistic, value);
        } else if (operation.equals("set")) {
            targetPlayer.setStatistic(statistic, value);
        }

        sender.sendMessage("Successfully updated " + targetPlayer.getName() + "'s " + statistic.name() + " to " + targetPlayer.getStatistic(statistic));
        return true;
    }

    @Override
    public List<String> onTabComplete(CommandSender sender, Command command, String alias, String[] args) {
        if (args.length == 1) {
            return Bukkit.getOnlinePlayers().stream().map(Player::getName).collect(Collectors.toList());
        } else if (args.length == 2) {
            return Arrays.stream(Statistic.values()).map(Statistic::name).map(String::toLowerCase).collect(Collectors.toList());
        } else if (args.length == 3) {
            return Arrays.asList("increment", "decrement", "set");
        } else if (args.length == 4) {
            return null;
        }
        return null;
    }
}
