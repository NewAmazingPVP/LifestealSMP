package newamazingpvp.lifestealsmp.command;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.Statistic;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class StatisticManager implements CommandExecutor, TabCompleter {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (args.length < 4 || args.length > 5) {
            sender.sendMessage("Usage: /stat <player> <statistic> <increment/decrement/set> <value> [material/entity]");
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

        if (args.length == 5) {
            String materialOrEntity = args[4].toUpperCase();
            try {
                Material material = Material.valueOf(materialOrEntity);
                performStatisticOperation(targetPlayer, statistic, operation, value, material);
            } catch (IllegalArgumentException e1) {
                try {
                    EntityType entityType = EntityType.valueOf(materialOrEntity);
                    performStatisticOperation(targetPlayer, statistic, operation, value, entityType);
                } catch (IllegalArgumentException e2) {
                    sender.sendMessage("Invalid material or entity type.");
                    return false;
                }
            }
        } else {
            performStatisticOperation(targetPlayer, statistic, operation, value, null);
        }
        try {
            sender.sendMessage("Successfully updated " + targetPlayer.getName() + "'s " + statistic.name() + " to " + targetPlayer.getStatistic(statistic));
            return true;
        } catch (Exception e){
            sender.sendMessage("Successfully updated " + targetPlayer.getName() + "'s " + statistic.name());
            return true;
        }
    }

    private void performStatisticOperation(Player player, Statistic statistic, String operation, int value, Object extra) {
        if (extra instanceof Material) {
            Material material = (Material) extra;
            switch (operation) {
                case "increment":
                    player.incrementStatistic(statistic, material, value);
                    break;
                case "decrement":
                    player.decrementStatistic(statistic, material, value);
                    break;
                case "set":
                    player.setStatistic(statistic, material, value);
                    break;
            }
        } else if (extra instanceof EntityType) {
            EntityType entityType = (EntityType) extra;
            switch (operation) {
                case "increment":
                    player.incrementStatistic(statistic, entityType, value);
                    break;
                case "decrement":
                    player.decrementStatistic(statistic, entityType, value);
                    break;
                case "set":
                    player.setStatistic(statistic, entityType, value);
                    break;
            }
        } else {
            switch (operation) {
                case "increment":
                    player.incrementStatistic(statistic, value);
                    break;
                case "decrement":
                    player.decrementStatistic(statistic, value);
                    break;
                case "set":
                    player.setStatistic(statistic, value);
                    break;
            }
        }
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
        } else if (args.length == 5) {
            List<String> materialTypes = Arrays.stream(Material.values()).map(Material::name).map(String::toLowerCase).collect(Collectors.toList());
            List<String> entityTypes = Arrays.stream(EntityType.values()).map(EntityType::name).map(String::toLowerCase).collect(Collectors.toList());
            materialTypes.addAll(entityTypes);
            return materialTypes;
        }
        return null;
    }
}
