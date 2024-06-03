package newamazingpvp.lifestealsmp.wipcomet99;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;
import java.util.List;

public class REMOVE_THIS_COMMAND_GIVE_ICE implements CommandExecutor {

    public static ItemStack IceCube() {

        ItemStack IceCube = new ItemStack(Material.ICE);
        ItemMeta SI = IceCube.getItemMeta();
        SI.addEnchant(Enchantment.DURABILITY, 1, false);
        SI.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        SI.setDisplayName(ChatColor.AQUA + "" + ChatColor.BOLD + "Ice Cube");
        SI.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
        List<String> BL = new ArrayList<>();
        BL.add(ChatColor.GOLD + "Special Ability:" + ChatColor.DARK_PURPLE + " Freeze,");
        BL.add(ChatColor.DARK_PURPLE + "Freezes the closest player");
        BL.add(ChatColor.DARK_PURPLE + "by them from moving.");
        BL.add(ChatColor.DARK_PURPLE + "Freeze lasts 5 sec.");
        BL.add(ChatColor.RED + "Player can not be damaged when frozen.");
        BL.add(ChatColor.RED + "One time use and can freeze you!");
        SI.setLore(BL);
        IceCube.setItemMeta(SI);

        return IceCube;
    }


    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (sender instanceof Player) {
            Player player = (Player) sender;
            player.getInventory().addItem(IceCube());
            player.playSound(player.getLocation(), Sound.BLOCK_NOTE_BLOCK_PLING, 1.0f, 2.0f);

        } else {
            sender.sendMessage("This command can only be executed by a player.");
        }
        return true;
    }
}
