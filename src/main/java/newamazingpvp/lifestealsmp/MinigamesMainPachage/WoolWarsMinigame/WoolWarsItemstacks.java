package newamazingpvp.lifestealsmp.MinigamesMainPachage.WoolWarsMinigame;

import org.bukkit.ChatColor;
import org.bukkit.Color;
import org.bukkit.Material;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.LeatherArmorMeta;

import java.util.ArrayList;
import java.util.List;

public class WoolWarsItemstacks {

    public static ItemStack blueTeamChestplate() {

        ItemStack chestplate = new ItemStack(Material.LEATHER_CHESTPLATE);
        LeatherArmorMeta chestplateMeta = (LeatherArmorMeta) chestplate.getItemMeta();
        chestplateMeta.setDisplayName(ChatColor.DARK_BLUE + "" + ChatColor.BOLD + "Blue Team Armor");
        chestplateMeta.setColor(Color.fromRGB(0, 0, 255));
        chestplateMeta.setUnbreakable(true);
        List<String> CHESTPLATELORE = new ArrayList<>();
        CHESTPLATELORE.add(ChatColor.DARK_RED + "Given to hackers");
        chestplateMeta.setLore(CHESTPLATELORE);
        chestplateMeta.addItemFlags(ItemFlag.HIDE_DYE);
        chestplateMeta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
        chestplateMeta.addItemFlags(ItemFlag.HIDE_UNBREAKABLE);
        chestplate.setItemMeta(chestplateMeta);

        return chestplate;
    }

    public static ItemStack blueTeamLeggings() {

        ItemStack leggings = new ItemStack(Material.LEATHER_LEGGINGS);
        LeatherArmorMeta leggingsMeta = (LeatherArmorMeta) leggings.getItemMeta();
        leggingsMeta.setDisplayName(ChatColor.DARK_BLUE + "" + ChatColor.BOLD + "Blue Team Armor");
        leggingsMeta.setColor(Color.fromRGB(0, 0, 255));
        leggingsMeta.setUnbreakable(true);
        List<String> LEGGINGSLORE = new ArrayList<>();
        leggingsMeta.setLore(LEGGINGSLORE);
        leggingsMeta.addItemFlags(ItemFlag.HIDE_DYE);
        leggingsMeta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
        leggingsMeta.addItemFlags(ItemFlag.HIDE_UNBREAKABLE);
        leggings.setItemMeta(leggingsMeta);

        return leggings;
    }

    public static ItemStack blueTeamBoots() {

        ItemStack boots = new ItemStack(Material.LEATHER_BOOTS);
        LeatherArmorMeta bootsMeta = (LeatherArmorMeta) boots.getItemMeta();
        bootsMeta.setDisplayName(ChatColor.DARK_BLUE + "" + ChatColor.BOLD + "Blue Team Armor");
        bootsMeta.setColor(Color.fromRGB(0, 0, 255));
        bootsMeta.setUnbreakable(true);
        List<String> BOOTSLORE = new ArrayList<>();
        bootsMeta.setLore(BOOTSLORE);
        bootsMeta.addItemFlags(ItemFlag.HIDE_DYE);
        bootsMeta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
        bootsMeta.addItemFlags(ItemFlag.HIDE_UNBREAKABLE);
        boots.setItemMeta(bootsMeta);

        return boots;
    }

    public static ItemStack redTeamChestplate() {

        ItemStack chestplate = new ItemStack(Material.LEATHER_CHESTPLATE);
        LeatherArmorMeta chestplateMeta = (LeatherArmorMeta) chestplate.getItemMeta();
        chestplateMeta.setDisplayName(ChatColor.DARK_RED + "" + ChatColor.BOLD + "Red Team Armor");
        chestplateMeta.setColor(Color.fromRGB(255, 0, 0));
        chestplateMeta.setUnbreakable(true);
        List<String> CHESTPLATELORE = new ArrayList<>();
        CHESTPLATELORE.add(ChatColor.DARK_RED + "Given to hackers");
        chestplateMeta.setLore(CHESTPLATELORE);
        chestplateMeta.addItemFlags(ItemFlag.HIDE_DYE);
        chestplateMeta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
        chestplateMeta.addItemFlags(ItemFlag.HIDE_UNBREAKABLE);
        chestplate.setItemMeta(chestplateMeta);

        return chestplate;
    }

    public static ItemStack redTeamLeggings() {

        ItemStack leggings = new ItemStack(Material.LEATHER_LEGGINGS);
        LeatherArmorMeta leggingsMeta = (LeatherArmorMeta) leggings.getItemMeta();
        leggingsMeta.setDisplayName(ChatColor.DARK_RED + "" + ChatColor.BOLD + "Red Team Armor");
        leggingsMeta.setColor(Color.fromRGB(255, 0, 0));
        leggingsMeta.setUnbreakable(true);
        List<String> LEGGINGSLORE = new ArrayList<>();
        leggingsMeta.setLore(LEGGINGSLORE);
        leggingsMeta.addItemFlags(ItemFlag.HIDE_DYE);
        leggingsMeta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
        leggingsMeta.addItemFlags(ItemFlag.HIDE_UNBREAKABLE);
        leggings.setItemMeta(leggingsMeta);

        return leggings;
    }

    public static ItemStack redTeamBoots() {

        ItemStack boots = new ItemStack(Material.LEATHER_BOOTS);
        LeatherArmorMeta bootsMeta = (LeatherArmorMeta) boots.getItemMeta();
        bootsMeta.setDisplayName(ChatColor.DARK_RED + "" + ChatColor.BOLD + "Red Team Armor");
        bootsMeta.setColor(Color.fromRGB(255, 0, 0));
        bootsMeta.setUnbreakable(true);
        List<String> BOOTSLORE = new ArrayList<>();
        bootsMeta.setLore(BOOTSLORE);
        bootsMeta.addItemFlags(ItemFlag.HIDE_DYE);
        bootsMeta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
        bootsMeta.addItemFlags(ItemFlag.HIDE_UNBREAKABLE);
        boots.setItemMeta(bootsMeta);

        return boots;
    }

}
