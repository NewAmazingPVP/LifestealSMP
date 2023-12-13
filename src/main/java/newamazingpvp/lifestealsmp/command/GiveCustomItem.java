package newamazingpvp.lifestealsmp.command;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static newamazingpvp.lifestealsmp.game.CustomRecipe.createFeatherSword;

public class GiveCustomItem implements CommandExecutor, TabCompleter {

    private ArrayList<String> subcommands = new ArrayList<>(List.of("feathersword", "lol", "xd"));
    private ArrayList<ItemStack> subItems = new ArrayList<>(List.of(createFeatherSword()));
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if(args.length == 1){
            for(String s : subcommands){
                if(args[0].equalsIgnoreCase(s)){
                    Player p = (Player) sender;
                    p.getInventory().addItem(subItems.get(subcommands.indexOf(s)));
                }
            }
        } else if (args.length == 2){{
            for(String s : subcommands) {
                if (args[1].equalsIgnoreCase(s)) {
                    Player p = Bukkit.getPlayer(args[0]);
                    if (p == null) return false;
                    p.getInventory().addItem(subItems.get(subcommands.indexOf(s)));
                }
            }
            }
        }
        return true;
    }

    @Override
    public List<String> onTabComplete(CommandSender sender, Command command, String alias, String[] args) {
        if (args.length == 1) {
            return subcommands;
        }
        return null;
    }
}
