package newamazingpvp.lifestealsmp.command;

import org.bukkit.ChatColor;
import org.bukkit.Material;
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

public class GiveMontuStaffSetADMINONLY implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (!(sender instanceof Player)) {
            sender.sendMessage(ChatColor.RED + "This command can only be executed by players.");
            return true;
        }

        Player player = (Player) sender;
        ItemStack StickOfPower  = new ItemStack(Material.STICK);
        ItemMeta SOPM = StickOfPower.getItemMeta();
        SOPM.setDisplayName(ChatColor.GOLD + "" + ChatColor.BOLD + "Montu's Staff" + ChatColor.DARK_AQUA + " [Wand]");
        List<String> SOPL = new ArrayList<>();
        SOPL.add(" ");
        SOPL.add(ChatColor.DARK_BLUE + "Only works if you have full lapis armor on!");
        SOPL.add(ChatColor.DARK_PURPLE + "" + ChatColor.BOLD + "-------------------------------------");
        SOPL.add(ChatColor.YELLOW + "" + ChatColor.BOLD + "Right Click" + ChatColor.DARK_AQUA + " (7sec Cooldown)");
        SOPL.add(ChatColor.GREEN + "Warp 5 blocks where you are looking!");
        SOPL.add(ChatColor.DARK_PURPLE + "" + ChatColor.BOLD + "-------------------------------------");
        SOPL.add(ChatColor.YELLOW + "" + ChatColor.BOLD + "Shift Right Click" + ChatColor.DARK_AQUA + " (10sec Cooldown)");
        SOPL.add(ChatColor.GREEN + "Spawn a sonic wave that will");
        SOPL.add(ChatColor.GREEN + "damage any mob in its range!" + ChatColor.RED + " 3 Damage");
        SOPL.add(ChatColor.DARK_PURPLE + "" + ChatColor.BOLD + "-------------------------------------");
        SOPL.add(ChatColor.YELLOW + "" + ChatColor.BOLD + "Left Click" + ChatColor.DARK_AQUA + " (Very small cooldown)");
        SOPL.add(ChatColor.GREEN + "Shoots a beam 15 blocks out that deals damage!" + ChatColor.RED + " 2 Damage");
        SOPL.add(ChatColor.DARK_PURPLE + "" + ChatColor.BOLD + "-------------------------------------");
        SOPL.add(ChatColor.YELLOW + "" + ChatColor.BOLD + "Shift Left Click" + ChatColor.DARK_AQUA + " (30sec Cooldown)");
        SOPL.add(ChatColor.GREEN + "Spawn a comet wave that will hit the ground");
        SOPL.add(ChatColor.GREEN + "and damage any mob in its range!" + ChatColor.RED + " 7 Damage");
        SOPL.add(ChatColor.DARK_PURPLE + "" + ChatColor.BOLD + "-------------------------------------");
        SOPM.setLore(SOPL);
        SOPM.addEnchant(Enchantment.DURABILITY, 1, false);
        SOPM.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        StickOfPower.setItemMeta(SOPM);

        player.getInventory().addItem(StickOfPower);
        return true;
    }
}
