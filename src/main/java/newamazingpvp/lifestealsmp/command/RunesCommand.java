package newamazingpvp.lifestealsmp.command;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import static newamazingpvp.lifestealsmp.runes.RuneHandler.inv;
import static newamazingpvp.lifestealsmp.utility.TimeManager.*;
import static newamazingpvp.lifestealsmp.utility.TimeManager.CUSTOM_ITEMS_AND_RUNES;

public class RunesCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (sender instanceof Player) {
            Player p = (Player) sender;
            p.openInventory(inv);
            p.sendMessage(ChatColor.AQUA + "Runes are rare drop from mobs and give permanent effect while in inventory!");
            if(!isTimePassed(CUSTOM_ITEMS_AND_RUNES)){
                p.sendMessage(ChatColor.YELLOW + "Runes are not enabled yet. They will enable in " + formatDuration(CUSTOM_ITEMS_AND_RUNES));
            }
            return true;
        }
        return false;
    }
}
