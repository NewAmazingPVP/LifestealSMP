package newamazingpvp.lifestealsmp.command;

import newamazingpvp.lifestealsmp.runes.Rune;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;

import static newamazingpvp.lifestealsmp.runes.RuneHandler.createRuneItem;
import static newamazingpvp.lifestealsmp.runes.RuneHandler.runes;

public class AdminRunes implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (sender instanceof Player) {
            Player p = (Player) sender;
            Inventory inv = Bukkit.createInventory(null, 54, ChatColor.GOLD + "Admin");
            for (Rune r : runes) {
                inv.addItem(createRuneItem(r));
            }
            p.openInventory(inv);
            return true;
        }
        return false;
    }
}
