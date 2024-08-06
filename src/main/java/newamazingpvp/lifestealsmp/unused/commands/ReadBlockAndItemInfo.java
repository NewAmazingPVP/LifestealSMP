package newamazingpvp.lifestealsmp.unused.commands;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.persistence.PersistentDataContainer;

import java.util.ArrayList;
import java.util.List;


public class ReadBlockAndItemInfo implements CommandExecutor, TabCompleter {

    private final ArrayList<String> subcommands = new ArrayList<>(List.of("block", "item"));

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if (!(sender instanceof Player)) return true;

        if (args.length == 0) {
            sender.sendMessage(ChatColor.RED + "Please specify if you are reading a item or a block you are looking at.");
            return false;
        }


        switch (args[0].toLowerCase()) {
            case "item":

                getItemInHandData(sender);

                break;
            case "block":

                break;
            default:
                sender.sendMessage(ChatColor.RED + "Error: Unknown argument.");
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

    private static void getItemInHandData(CommandSender sender) {

        ItemStack item = ((Player) sender).getItemInHand();

        Material itemMaterial = null;
        String stringData = null;
        if (item != null && item.getType() != Material.AIR) {
            itemMaterial = item.getType();

            if (!item.getPersistentDataContainer().isEmpty()) {
                PersistentDataContainer container = (PersistentDataContainer) item.getPersistentDataContainer();
                stringData = container.toString();

            } else {
                stringData = (ChatColor.RED + "This item currently does not have any persistent data.");
            }


        } else {
            sender.sendMessage(ChatColor.RED + "Please hold an item.");
        }


        sender.sendMessage(ChatColor.DARK_GREEN + "" + ChatColor.BOLD + "Material: " + ChatColor.DARK_AQUA + itemMaterial);
        sender.sendMessage(ChatColor.DARK_GREEN + "" + ChatColor.BOLD + "Persistent Data: " + ChatColor.DARK_AQUA + stringData);


    }

    private static void getItemDataFromBlock(CommandSender sender) {

    }


}
