package newamazingpvp.lifestealsmp.command;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.OfflinePlayer;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

import static newamazingpvp.lifestealsmp.command.DiscordLink.discordURL;

public class BetterBan implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (args.length == 1) {
            OfflinePlayer player = Bukkit.getOfflinePlayer(args[0]);
            player.banPlayer(ChatColor.RED + "You were banned for breaking a rule. If you feel you were unfairly banned make an appeal in discord. " + ChatColor.AQUA + discordURL);
        }
        return true;
    }
}
