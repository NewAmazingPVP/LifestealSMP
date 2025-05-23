package newamazingpvp.lifestealsmp.command;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class NonVanillaMechanics implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (sender instanceof Player player) {

            nonVanillaMechanics(player);
        }

        return true;
    }

    public static void nonVanillaMechanics(Player player){
        player.sendMessage(ChatColor.DARK_AQUA + "======== " + ChatColor.AQUA + "Non-Vanilla Mechanics" + ChatColor.DARK_AQUA + " ========");
        player.sendMessage(ChatColor.GOLD + "1. " + ChatColor.YELLOW + "Infinite Storage System: " + ChatColor.WHITE + "You can place shulker boxes inside shulker boxes.");
        player.sendMessage(ChatColor.GOLD + "2. " + ChatColor.YELLOW + "Cheaper Item Renaming: " + ChatColor.WHITE + "Renaming items only costs 1 XP regardless of enchantments.");
        player.sendMessage(ChatColor.GOLD + "3. " + ChatColor.YELLOW + "Item Nerfs: " + ChatColor.WHITE + "Vanilla items like maces, crystals, respawn anchors, beds, TNT minecarts, and harming pots/arrows deal reduced damage for balance.");
        player.sendMessage(ChatColor.GOLD + "4. " + ChatColor.YELLOW + "Disenchanting: " + ChatColor.WHITE + "Transfer enchantments from items to books! Left-click the enchanted item on a physical anvil (don’t open the GUI), then left-click with a book on the anvil within 10 seconds. Its no exp cost!");
        player.sendMessage(ChatColor.GOLD + "5. " + ChatColor.YELLOW + "And more: " + ChatColor.WHITE + "Discover more custom mechanics as you play! Do " + ChatColor.AQUA + "/help" + ChatColor.WHITE + " to see custom items, runes and more!");
        player.sendMessage(ChatColor.DARK_AQUA + "======================================");
    }
}
