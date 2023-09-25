package newamazingpvp.lifestealsmp.command;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class RulesCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (sender instanceof Player) {
            Player player = (Player) sender;
            player.sendMessage(ChatColor.GOLD + "Rules for this SMP Season:");
            player.sendMessage(ChatColor.WHITE + "- Elytras are disabled (can be obtained but cannot be used)");
            player.sendMessage(ChatColor.WHITE + "- End Crystals not allowed for PVP (only allowed to respawn dragon)");
            player.sendMessage(ChatColor.WHITE + "- Hacking or cheating not allowed");
            player.sendMessage(ChatColor.WHITE + "- No spawn killing/camping");
            player.sendMessage(ChatColor.WHITE + "- No repeated killing");
            player.sendMessage(ChatColor.WHITE + "- No farming alts for hearts");
            player.sendMessage(ChatColor.WHITE + "- Respect players");
            player.sendMessage(ChatColor.WHITE + "- No exploiting bugs/glitches");
            player.sendMessage(ChatColor.WHITE + "- Anything that gives advantage not allowed (with exception of some mods in ⁠❓info-faq)");
            player.sendMessage(ChatColor.WHITE + "- No lag farms/builds");
            player.sendMessage(ChatColor.WHITE + "- Harming pots and arrows are now banned.");
            player.sendMessage(ChatColor.WHITE + "- Netherite armor is banned.");
            player.sendMessage(ChatColor.WHITE + "- Respawn anchors are also banned.");
            player.sendMessage(ChatColor.WHITE + "- No bed bombing");
            player.sendMessage(ChatColor.WHITE + "- No offensive/abusive behaviour/builds in game");
            player.sendMessage(ChatColor.WHITE + "- No offensive language/skins/names");
            player.sendMessage(ChatColor.WHITE + "- No advertising");
            player.sendMessage(ChatColor.WHITE + "- No spamming");
            player.sendMessage(ChatColor.WHITE + "- Not asking admins to give back your stuff when you die");
            player.sendMessage(ChatColor.WHITE + "- Don't ask admins to tp to somewhere");
            player.sendMessage(ChatColor.WHITE + "- Any kind of trash talking is not allowed");
            player.sendMessage(ChatColor.WHITE + "- Use common sense");
            player.sendMessage(ChatColor.GOLD + "Your presence in this SMP implies accepting these rules, including all further changes. These changes might be done at any time without notice; it is your responsibility to check for them.");
        }
        return true;
    }


}