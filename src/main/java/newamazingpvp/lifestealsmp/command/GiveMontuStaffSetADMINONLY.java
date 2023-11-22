package newamazingpvp.lifestealsmp.command;

import org.bukkit.ChatColor;
import org.bukkit.Color;
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
import org.bukkit.inventory.meta.LeatherArmorMeta;

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
        SOPM.setDisplayName(ChatColor.GOLD + "" + ChatColor.BOLD + "Montu's Staff");
        List<String> SOPL = new ArrayList<>();
        SOPL.add(" ");
        SOPL.add(ChatColor.LIGHT_PURPLE + "" + ChatColor.BOLD + "Abilities change depending on special armor set");
        SOPL.add(ChatColor.RED + "Requires montu helmet to use!");
        SOPL.add(ChatColor.DARK_PURPLE + "" + ChatColor.BOLD + "-------------------------------------");
        SOPL.add(ChatColor.YELLOW + "" + ChatColor.BOLD + "Right Click:");
        SOPL.add(ChatColor.DARK_RED + "Use a full set bonus to get abilities");
        SOPL.add(ChatColor.DARK_PURPLE + "" + ChatColor.BOLD + "-------------------------------------");
        SOPL.add(ChatColor.YELLOW + "" + ChatColor.BOLD + "Shift Right Click:");
        SOPL.add(ChatColor.DARK_RED + "Use a full set bonus to get abilities");
        SOPL.add(ChatColor.DARK_PURPLE + "" + ChatColor.BOLD + "-------------------------------------");
        SOPL.add(ChatColor.YELLOW + "" + ChatColor.BOLD + "Left Click:");
        SOPL.add(ChatColor.DARK_RED + "Use a full set bonus to get abilities");
        SOPL.add(ChatColor.DARK_PURPLE + "" + ChatColor.BOLD + "-------------------------------------");
        SOPL.add(ChatColor.YELLOW + "" + ChatColor.BOLD + "Shift Left Click:");
        SOPL.add(ChatColor.DARK_RED + "Use a full set bonus to get abilities");
        SOPL.add(ChatColor.DARK_PURPLE + "" + ChatColor.BOLD + "-------------------------------------");
        SOPM.setLore(SOPL);
        SOPM.addEnchant(Enchantment.DURABILITY, 1, false);
        SOPM.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        StickOfPower.setItemMeta(SOPM);

        player.getInventory().addItem(StickOfPower);


        ItemStack MontuCP = new ItemStack(Material.LEATHER_CHESTPLATE);
        LeatherArmorMeta SVCM = (LeatherArmorMeta) MontuCP.getItemMeta();
        SVCM.setDisplayName(ChatColor.LIGHT_PURPLE + "" + ChatColor.BOLD + "Montu Chestplate");
        List<String> SVCL = new ArrayList<>();
        SVCL.add(ChatColor.YELLOW + "" + ChatColor.BOLD + "Full Set Bonus:");
        SVCL.add(ChatColor.DARK_PURPLE + "Lets you use the Montu Staff!");
        SVCM.setLore(SVCL);
        SVCM.setUnbreakable(true);
        SVCM.addItemFlags(ItemFlag.HIDE_DYE);
        //SVCM.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
        SVCM.setColor(Color.fromRGB(0, 0, 255));
        MontuCP.setItemMeta(SVCM);

        ItemStack MontuLEG = new ItemStack(Material.LEATHER_LEGGINGS);
        LeatherArmorMeta SVLM = (LeatherArmorMeta) MontuLEG.getItemMeta();
        SVLM.setDisplayName(ChatColor.LIGHT_PURPLE + "" + ChatColor.BOLD + "Montu Leggings");
        List<String> SVLL = new ArrayList<>();
        SVLL.add(ChatColor.YELLOW + "" + ChatColor.BOLD + "Full Set Bonus:");
        SVLL.add(ChatColor.DARK_PURPLE + "Lets you use the Montu Staff!");
        SVLM.setLore(SVLL);
        SVLM.setUnbreakable(true);
        SVLM.addItemFlags(ItemFlag.HIDE_DYE);
        //SVLM.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
        SVLM.setColor(Color.fromRGB(0, 0, 255));
        MontuLEG.setItemMeta(SVLM);

        ItemStack MontuBOOT = new ItemStack(Material.LEATHER_BOOTS);
        LeatherArmorMeta SVBM = (LeatherArmorMeta) MontuBOOT.getItemMeta();
        SVBM.setDisplayName(ChatColor.LIGHT_PURPLE + "" + ChatColor.BOLD + "Montu Boots");
        List<String> SVBL = new ArrayList<>();
        SVBL.add(ChatColor.YELLOW + "" + ChatColor.BOLD + "Full Set Bonus:");
        SVBL.add(ChatColor.DARK_PURPLE + "Lets you use the Montu Staff!");
        SVBM.setLore(SVBL);
        SVBM.setUnbreakable(true);
        SVBM.addItemFlags(ItemFlag.HIDE_DYE);
        //SVBM.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
        SVBM.setColor(Color.fromRGB(0, 0, 255));
        MontuBOOT.setItemMeta(SVBM);

        player.getInventory().addItem(MontuCP);
        player.getInventory().addItem(MontuLEG);
        player.getInventory().addItem(MontuBOOT);

        player.playSound(player.getLocation(), Sound.BLOCK_NOTE_BLOCK_PLING, 1.0f, 2.0f);
        return true;
    }
}
