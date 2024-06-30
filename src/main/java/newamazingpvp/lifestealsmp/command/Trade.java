package newamazingpvp.lifestealsmp.command;

import newamazingpvp.lifestealsmp.utility.TradeManager;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Trade implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (command.getName().equalsIgnoreCase("trade")) {
            if (sender instanceof Player) {
                Player player = (Player) sender;
                if (args.length != 1) {
                    player.sendMessage("Usage: /trade <player>");
                    return true;
                }

                Player target = Bukkit.getPlayer(args[0]);
                if (target == null || !target.isOnline()) {
                    player.sendMessage("Player not found or not online.");
                    return true;
                }

                if(target.getName().equals(player.getName())){
                    player.sendMessage("You cannot trade with yourself!");
                    return true;
                }

                TradeManager.initiateTrade(player, target);
                return true;
            }
        }
        return false;
    }
}
