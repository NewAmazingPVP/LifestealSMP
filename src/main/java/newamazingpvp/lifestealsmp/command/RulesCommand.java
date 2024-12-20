package newamazingpvp.lifestealsmp.command;

import org.bukkit.ChatColor;
import org.bukkit.Sound;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class RulesCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (sender instanceof Player player) {

            player.sendMessage(ChatColor.GOLD + "Rules for this SMP Season:");
            player.sendMessage(ChatColor.WHITE + "- End Crystals/Respawn Anchors/Beds/Minecarts/Instant Harming Pots and Arrows are allowed but are nerfed in PVP for balance");
            player.sendMessage(ChatColor.WHITE + "- The mace is allowed but is nerfed in PVP for balance");
            player.sendMessage(ChatColor.WHITE + "- Hacking or cheating not allowed");
            player.sendMessage(ChatColor.WHITE + "- Xraying not allowed");
            player.sendMessage(ChatColor.WHITE + "- No spawn and bed killing/camping");
            player.sendMessage(ChatColor.WHITE + "- No heart farming");
            player.sendMessage(ChatColor.WHITE + "- No alts");
            player.sendMessage(ChatColor.WHITE + "- Respect players");
            player.sendMessage(ChatColor.WHITE + "- No exploiting bugs/glitches");
            player.sendMessage(ChatColor.WHITE + "- Anything that gives an advantage is not allowed (with the exception of some mods in ⁠❓info-faq) such as minimap");
            player.sendMessage(ChatColor.WHITE + "- However do not use replay mod or minimap mods to find underground bases");
            player.sendMessage(ChatColor.WHITE + "- No lag farms/builds");
            player.sendMessage(ChatColor.WHITE + "- No toxicity");
            //player.sendMessage(ChatColor.WHITE + "- Do not trick or manipulate new players to hit you for hearts");
            player.sendMessage(ChatColor.WHITE + "- Netherite armor and tools are allowed.");
            player.sendMessage(ChatColor.WHITE + "- Do not lava cast, trap, or grief in the vicinity of spawn.");
            // TODO: make it so lava bucket auto enforced AND REMOVE DEATH PROT PROTECTIONM ONLY HEART PROT
            // so then we can remove this rule
            // player.sendMessage(ChatColor.WHITE + "- Do not use the lava bucket or any bypass to kill newbies or respawns as long as they have their newbie or death protection.");
            // so then only newbie prot abuse banned (remove respawns)
            player.sendMessage(ChatColor.WHITE + "- Using newbie to grief/steal/abuse etc is not allowed.");
            player.sendMessage(ChatColor.WHITE + "- No offensive/abusive behavior/builds in-game");
            player.sendMessage(ChatColor.WHITE + "- No offensive language/skins/names");
            player.sendMessage(ChatColor.WHITE + "- No advertising");
            player.sendMessage(ChatColor.WHITE + "- No rollbacks for bugs or lag, except if caused by admins or a major server-wide issue.");
            player.sendMessage(ChatColor.WHITE + "- No rollbacks for any reasons unless there's proof of hacking (e.g., video footage of PvP hacking).");
            player.sendMessage(ChatColor.WHITE + "- Do not start arguments or instigate old dramas");
            player.sendMessage(ChatColor.WHITE + "- Do not bring any drama from other servers into this server");
            player.sendMessage(ChatColor.WHITE + "- No bedrock invis skin bug abusing");
            player.sendMessage(ChatColor.WHITE + "- No spamming");
            player.sendMessage(ChatColor.WHITE + "- Do not ask admins to give back your stuff when you die");
            player.sendMessage(ChatColor.WHITE + "- Don't ask admins to tp you somewhere");
            player.sendMessage(ChatColor.WHITE + "- Any kind of trash talking is not allowed");
            player.sendMessage(ChatColor.WHITE + "- Use common sense");
            player.sendMessage(ChatColor.GOLD + "Your presence in this SMP implies accepting these rules, including all further changes. These changes might be done at any time without notice; it is your responsibility to check for them.");
            player.playSound(player.getLocation(), Sound.BLOCK_NOTE_BLOCK_PLING, 1.0f, 2.0f);
        }
        return true;
    }
}
