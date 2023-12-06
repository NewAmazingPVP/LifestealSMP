package newamazingpvp.lifestealsmp.command;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.OfflinePlayer;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class CustomPrefixAdmin implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (args.length == 2) {
            Player p = Bukkit.getPlayer(args[0]);
            String prefix = args[1];
            p.setDisplayName(ChatColor.translateAlternateColorCodes('&', prefix) + " " + p.getName());
        }
        return true;
    }
}
