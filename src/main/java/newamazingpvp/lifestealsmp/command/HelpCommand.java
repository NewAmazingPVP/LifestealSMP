package newamazingpvp.lifestealsmp.command;

import net.md_5.bungee.api.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class HelpCommand implements CommandExecutor {

    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (sender instanceof Player p) {
            p.sendMessage(ChatColor.GOLD + "/rules " + ChatColor.WHITE + "for the rules of the SMP" +
                    "\n" + ChatColor.GOLD + "/discord " + ChatColor.WHITE + "for the discord link" +
                    "\n" + ChatColor.GOLD + "/recipes " + ChatColor.WHITE + "for the recipes of custom items on this SMP" +
                    "\n" + ChatColor.GOLD + "/runes " + ChatColor.WHITE + "for the custom runes on this SMP" +
                    "\n" + ChatColor.GOLD + "/track " + ChatColor.WHITE + "to track players on the server" +
                    "\n" + ChatColor.GOLD + "/prefix " + ChatColor.WHITE + "to set your custom prefix on the server" +
                    "\n" + ChatColor.GOLD + "/vision " + ChatColor.WHITE + "to toggle permanent full brightness " +
                    "\n" + ChatColor.GOLD + "/trade " + ChatColor.WHITE + "to trade with other players!" +
                    "\n" + ChatColor.GOLD + "/team create -- /team invite -- /team help " + ChatColor.WHITE + "for teams" +
                    "\n" + ChatColor.GOLD + "/stats " + ChatColor.WHITE + "to see player stats on the server" +
                    "\n" + ChatColor.GOLD + "/voicechat " + ChatColor.WHITE + "for the voicechat in-game with mod" +
                    "\n" + ChatColor.GOLD + "/ally help " + ChatColor.WHITE + "for allying with other teams" +
                    "\n" + ChatColor.GOLD + "/skin help " + ChatColor.WHITE + "for changing your skins on the server" +
                    "\n" + ChatColor.GOLD + "/guide " + ChatColor.WHITE + "for guide book on how to play the server");
        }
        return true;
    }
}
