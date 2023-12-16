package newamazingpvp.lifestealsmp.command;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class HelpCommand implements CommandExecutor {

    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (sender instanceof Player) {
            Player p = (Player) sender;
            p.sendMessage("/rules for the rules of the SMP" +
                    "\n/discord for the discord link" +
                    "\n/recipes for the recipes of custom items on this SMP" +
                    "\n/track to track players on the server" +
                    "\n/vision to toggle permanent full brightness " +
                    "\n/trade to trade with other players!" +
                    "\n/team create -- /team invite -- /team help for teams" +
                    "\n/stats to see player stats on the server" +
                    "\n/voicechat for the voicechat ingame with mod");
        }
        return true;
    }
}
