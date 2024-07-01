package newamazingpvp.lifestealsmp.unused.magicstaffs.utils;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;
import java.util.List;

public class Itemstacks {

    public static ItemStack magicStaffDefault() {

        ItemStack powerStick = new ItemStack(Material.STICK);
        ItemMeta SI = powerStick.getItemMeta();
        SI.addEnchant(Enchantment.UNBREAKING, 1, false);
        SI.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        SI.setDisplayName(ChatColor.GRAY + "" + ChatColor.BOLD + "Magic Staff");
        List<String> BL = new ArrayList<>();
        BL.add(ChatColor.GOLD + "" + ChatColor.BOLD + "Left Click:");
        BL.add(ChatColor.DARK_PURPLE + "Shoots a beam of power dealing " + ChatColor.RED + "1❤");
        BL.add(ChatColor.RED + "3s cooldown!");
        SI.setLore(BL);
        SI.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
        SI.addItemFlags(ItemFlag.HIDE_UNBREAKABLE);
        powerStick.setItemMeta(SI);

        return powerStick;
    }

    public static ItemStack magicStaffAir() {

        ItemStack powerStick = new ItemStack(Material.STICK);
        ItemMeta SI = powerStick.getItemMeta();
        SI.addEnchant(Enchantment.UNBREAKING, 1, false);
        SI.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        SI.setDisplayName(ChatColor.WHITE + "" + ChatColor.BOLD + "Air Magic Staff");
        List<String> BL = new ArrayList<>();
        BL.add(ChatColor.GOLD + "" + ChatColor.BOLD + "Left Click:");
        BL.add(ChatColor.DARK_PURPLE + "Shoots a beam of power pushing a player");
        BL.add(ChatColor.RED + "0.5s cooldown!");
        BL.add(ChatColor.RED + "Only Deals damage 30% of the time!");
        SI.setLore(BL);
        SI.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
        SI.addItemFlags(ItemFlag.HIDE_UNBREAKABLE);
        powerStick.setItemMeta(SI);

        return powerStick;
    }

    public static ItemStack magicStaffNetheriteSpeed() {

        ItemStack powerStick = new ItemStack(Material.STICK);
        ItemMeta SI = powerStick.getItemMeta();
        SI.addEnchant(Enchantment.UNBREAKING, 1, false);
        SI.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        SI.setDisplayName(ChatColor.WHITE + "" + ChatColor.BOLD + "Air Magic Staff");
        List<String> BL = new ArrayList<>();
        BL.add(ChatColor.GOLD + "" + ChatColor.BOLD + "Left Click:");
        BL.add(ChatColor.DARK_PURPLE + "Shoots a beam of power pushing a player");
        BL.add(ChatColor.RED + "0.5s cooldown!");
        BL.add(ChatColor.RED + "Only Deals damage 30% of the time!");
        SI.setLore(BL);
        SI.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
        SI.addItemFlags(ItemFlag.HIDE_UNBREAKABLE);
        powerStick.setItemMeta(SI);

        return powerStick;
    }

    public static ItemStack magicStaffComet() {

        ItemStack powerStick = new ItemStack(Material.STICK);
        ItemMeta SI = powerStick.getItemMeta();
        SI.addEnchant(Enchantment.UNBREAKING, 1, false);
        SI.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        SI.setDisplayName(ChatColor.WHITE + "" + ChatColor.BOLD + "Air Magic Staff");
        List<String> BL = new ArrayList<>();
        BL.add(ChatColor.GOLD + "" + ChatColor.BOLD + "Left Click:");
        BL.add(ChatColor.DARK_PURPLE + "Shoots a beam of power pushing a player");
        BL.add(ChatColor.RED + "0.5s cooldown!");
        BL.add(ChatColor.RED + "Only Deals damage 30% of the time!");
        SI.setLore(BL);
        SI.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
        SI.addItemFlags(ItemFlag.HIDE_UNBREAKABLE);
        powerStick.setItemMeta(SI);

        return powerStick;
    }

}
