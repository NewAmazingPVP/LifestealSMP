package newamazingpvp.lifestealsmp.customitems.utils;

import org.bukkit.ChatColor;
import org.bukkit.Color;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.LeatherArmorMeta;

import java.util.ArrayList;
import java.util.List;

public class ItemStacks {

    public static ItemStack createReviveBeacon() {
        ItemStack reviveBeacon = new ItemStack(Material.BEACON);
        ItemMeta meta = reviveBeacon.getItemMeta();
        meta.setDisplayName(ChatColor.DARK_PURPLE + "Revive Beacon");
        List<String> lore = new ArrayList<>();
        lore.add(ChatColor.GOLD + "Use to revive eliminated players!");
        meta.setLore(lore);
        reviveBeacon.setItemMeta(meta);
        return reviveBeacon;
    }

    public static ItemStack createCustomBow() {
        ItemStack customBow = new ItemStack(Material.BOW);
        ItemMeta meta = customBow.getItemMeta();
        meta.setDisplayName(ChatColor.MAGIC + "Teleporting Bow");
        List<String> lore = new ArrayList<>();
        lore.add(ChatColor.GOLD + "Special Ability: " + ChatColor.DARK_PURPLE + "Shoot to teleport!");
        meta.setLore(lore);
        //meta.addItemFlags(ItemFlag.HIDE_ITEM_SPECIFICS, ItemFlag.HIDE_ATTRIBUTES);
        customBow.setItemMeta(meta);
        return customBow;
    }

    public static ItemStack createCustomAxe() {
        ItemStack customAxe = new ItemStack(Material.NETHERITE_AXE);
        ItemMeta meta = customAxe.getItemMeta();
        meta.setDisplayName(ChatColor.AQUA + "Tree Chopping Axe");
        List<String> lore = new ArrayList<>();
        lore.add(ChatColor.GOLD + "Special Ability: " + ChatColor.DARK_PURPLE + "Breaks whole tree down with one chop!");
        meta.setLore(lore);
        customAxe.setItemMeta(meta);
        return customAxe;
    }

    public static ItemStack createTNTBow() {
        ItemStack tntBow = new ItemStack(Material.BOW);
        ItemMeta meta = tntBow.getItemMeta();
        meta.setDisplayName(ChatColor.GOLD + "TNT Bow");
        List<String> lore = new ArrayList<>();
        lore.add(ChatColor.GOLD + "Special Ability: " + ChatColor.DARK_PURPLE + "TNT Shooter!");
        meta.setLore(lore);
        //meta.addItemFlags(ItemFlag.HIDE_ITEM_SPECIFICS, ItemFlag.HIDE_ATTRIBUTES);
        tntBow.setItemMeta(meta);
        return tntBow;
    }

    public static ItemStack createHomingBow() {
        ItemStack homingBow = new ItemStack(Material.BOW);
        ItemMeta meta = homingBow.getItemMeta();
        meta.setDisplayName(ChatColor.GOLD + "Homing Bow");
        List<String> lore = new ArrayList<>();
        lore.add(ChatColor.GOLD + "Special Ability: " + ChatColor.DARK_PURPLE + "Homing Arrows!");
        meta.setLore(lore);
        //meta.addItemFlags(ItemFlag.HIDE_ITEM_SPECIFICS, ItemFlag.HIDE_ATTRIBUTES);
        homingBow.setItemMeta(meta);
        return homingBow;
    }

    public static ItemStack createFeatherSword() {
        ItemStack featherSword = new ItemStack(Material.NETHERITE_SWORD);
        ItemMeta meta = featherSword.getItemMeta();
        meta.setDisplayName(ChatColor.AQUA + "Feather Sword");
        List<String> lore = new ArrayList<>();
        lore.add(ChatColor.GOLD + "Special Ability: " + ChatColor.DARK_PURPLE + "Right click to launch yourself");
        lore.add(ChatColor.LIGHT_PURPLE + "Permanent speed while holding");
        meta.setLore(lore);
        featherSword.setItemMeta(meta);
        return featherSword;
    }

    public static ItemStack createOpPickaxe() {
        ItemStack opPickaxe = new ItemStack(Material.NETHERITE_PICKAXE);
        ItemMeta meta = opPickaxe.getItemMeta();
        meta.setDisplayName(ChatColor.GOLD + "God Pickaxe");
        List<String> lore = new ArrayList<>();
        lore.add(ChatColor.GOLD + "Special Ability: " + ChatColor.DARK_PURPLE + "Mine to break 3x3!");
        meta.setLore(lore);
        opPickaxe.setItemMeta(meta);
        return opPickaxe;
    }

    public static ItemStack corruptedMobSoul() {
        ItemStack corruptedMobSoul = new ItemStack(Material.ECHO_SHARD);
        ItemMeta meta = corruptedMobSoul.getItemMeta();
        meta.addEnchant(Enchantment.DURABILITY, 1, false);
        //meta.addItemFlags(ItemFlag.HIDE_ENCHANTS, ItemFlag.HIDE_ATTRIBUTES);
        meta.setDisplayName(ChatColor.LIGHT_PURPLE + "" + ChatColor.MAGIC + "LL" + ChatColor.DARK_PURPLE + ChatColor.BOLD + "Corrupted Mob Soul" + ChatColor.LIGHT_PURPLE + ChatColor.MAGIC + "LL");
        List<String> lore = new ArrayList<>();
        lore.add(ChatColor.AQUA + "U$e To Cr" + ChatColor.MAGIC + "a" + ChatColor.AQUA + "ft Extra Hearts!" + ChatColor.MAGIC + "L");
        lore.add(ChatColor.LIGHT_PURPLE + "Rare Drop From Mobs!");
        meta.setLore(lore);
        corruptedMobSoul.setItemMeta(meta);
        return corruptedMobSoul;
    }

    public static ItemStack severedMobHeart() {
        ItemStack severedMobHeart = new ItemStack(Material.BEETROOT);
        ItemMeta meta = severedMobHeart.getItemMeta();
        meta.addEnchant(Enchantment.DURABILITY, 1, false);
        //meta.addItemFlags(ItemFlag.HIDE_ENCHANTS, ItemFlag.HIDE_ATTRIBUTES);
        meta.setDisplayName(ChatColor.DARK_RED + "" + ChatColor.BOLD + "Severed Mob Heart");
        List<String> lore = new ArrayList<>();
        lore.add(ChatColor.AQUA + "Use To Craft Extra Hearts!");
        lore.add(ChatColor.LIGHT_PURPLE + "Very Rare Drop From Mobs!");
        meta.setLore(lore);
        severedMobHeart.setItemMeta(meta);
        return severedMobHeart;
    }

    public static ItemStack extraHeart() {
        ItemStack extraHeart = new ItemStack(Material.RED_DYE);
        ItemMeta meta = extraHeart.getItemMeta();
        meta.addEnchant(Enchantment.DURABILITY, 1, false);
        //meta.addItemFlags(ItemFlag.HIDE_ENCHANTS, ItemFlag.HIDE_ATTRIBUTES);
        meta.setDisplayName(ChatColor.LIGHT_PURPLE + "" + ChatColor.MAGIC + "LL" + ChatColor.DARK_RED + ChatColor.BOLD + "Extra Heart" + ChatColor.LIGHT_PURPLE + ChatColor.MAGIC + "LL");
        List<String> lore = new ArrayList<>();
        lore.add(ChatColor.YELLOW + "" + ChatColor.BOLD + "Right Click:" + ChatColor.DARK_PURPLE + " For +1 Heart!");
        lore.add(ChatColor.GRAY + "(max 20 hearts)");
        meta.setLore(lore);
        extraHeart.setItemMeta(meta);
        return extraHeart;
    }

    public static ItemStack lightFeather() {
        ItemStack lightFeather = new ItemStack(Material.FEATHER);
        ItemMeta meta = lightFeather.getItemMeta();
        meta.addEnchant(Enchantment.DURABILITY, 1, false);
        //meta.addItemFlags(ItemFlag.HIDE_ENCHANTS, ItemFlag.HIDE_ATTRIBUTES);
        meta.setDisplayName(ChatColor.GOLD + "" + ChatColor.BOLD + "Light Feather");
        List<String> lore = new ArrayList<>();
        lore.add(ChatColor.GOLD + "" + ChatColor.BOLD + "Right Click:");
        lore.add(ChatColor.DARK_PURPLE + "Get speed and jump boost for a few sec!");
        lore.add(ChatColor.RED + "One time use!");
        meta.setLore(lore);
        lightFeather.setItemMeta(meta);
        return lightFeather;
    }

    public static ItemStack InstaBoomTNT() {
        ItemStack instaboomTNT = new ItemStack(Material.TNT);
        ItemMeta meta = instaboomTNT.getItemMeta();
        meta.addEnchant(Enchantment.DURABILITY, 1, false);
        //meta.addItemFlags(ItemFlag.HIDE_ENCHANTS, ItemFlag.HIDE_ATTRIBUTES, ItemFlag.HIDE_UNBREAKABLE);
        meta.setDisplayName(ChatColor.GOLD + "" + ChatColor.BOLD + "InstaBoom TNT");
        List<String> lore = new ArrayList<>();
        lore.add(ChatColor.GOLD + "" + ChatColor.BOLD + "Place:");
        lore.add(ChatColor.DARK_PURPLE + "All players within a radius");
        lore.add(ChatColor.DARK_PURPLE + "of 3 blocks from where it is");
        lore.add(ChatColor.DARK_PURPLE + "placed will be pushed away!");
        lore.add(ChatColor.RED + "One Time Use!");
        lore.add(ChatColor.RED + "10s cooldown!");
        meta.setLore(lore);
        instaboomTNT.setItemMeta(meta);
        return instaboomTNT;
    }

    public static ItemStack LifestealStick() {
        ItemStack lifestealStick = new ItemStack(Material.STICK);
        ItemMeta meta = lifestealStick.getItemMeta();
        meta.addEnchant(Enchantment.DURABILITY, 1, false);
        //meta.addItemFlags(ItemFlag.HIDE_ENCHANTS, ItemFlag.HIDE_ATTRIBUTES);
        meta.setDisplayName(ChatColor.GOLD + "" + ChatColor.BOLD + "Lifesteal Stick");
        List<String> lore = new ArrayList<>();
        lore.add(ChatColor.GOLD + "" + ChatColor.BOLD + "Ability:");
        lore.add(ChatColor.DARK_PURPLE + "When you hit a player");
        lore.add(ChatColor.DARK_PURPLE + "You will heal " + ChatColor.RED + "1❤");
        lore.add(ChatColor.RED + "2s Cooldown!");
        meta.setLore(lore);
        lifestealStick.setItemMeta(meta);
        return lifestealStick;
    }

    public static ItemStack powerStick() {
        ItemStack powerStick = new ItemStack(Material.STICK);
        ItemMeta meta = powerStick.getItemMeta();
        meta.addEnchant(Enchantment.DURABILITY, 1, false);
        //meta.addItemFlags(ItemFlag.HIDE_ENCHANTS, ItemFlag.HIDE_ATTRIBUTES, ItemFlag.HIDE_UNBREAKABLE);
        meta.setDisplayName(ChatColor.GOLD + "" + ChatColor.BOLD + "Power Stick");
        List<String> lore = new ArrayList<>();
        lore.add(ChatColor.DARK_PURPLE + "Used For Crafting");
        meta.setLore(lore);
        powerStick.setItemMeta(meta);
        return powerStick;
    }

    public static ItemStack heavyNetherStar() {
        ItemStack heavyNetherStar = new ItemStack(Material.NETHER_STAR);
        ItemMeta meta = heavyNetherStar.getItemMeta();
        meta.addEnchant(Enchantment.DURABILITY, 1, false);
        //meta.addItemFlags(ItemFlag.HIDE_ENCHANTS, ItemFlag.HIDE_ATTRIBUTES, ItemFlag.HIDE_UNBREAKABLE);
        meta.setDisplayName(ChatColor.GOLD + "" + ChatColor.BOLD + "Heavy Nether Star");
        List<String> lore = new ArrayList<>();
        lore.add(ChatColor.DARK_PURPLE + "Used For Crafting");
        meta.setLore(lore);
        heavyNetherStar.setItemMeta(meta);
        return heavyNetherStar;
    }

    public static ItemStack QuarryArmor_CP() {
        ItemStack chestplate = new ItemStack(Material.LEATHER_CHESTPLATE);
        LeatherArmorMeta meta = (LeatherArmorMeta) chestplate.getItemMeta();
        meta.setColor(Color.BLUE);
        meta.addEnchant(Enchantment.DURABILITY, 3, true);
        meta.setDisplayName(ChatColor.GOLD + "" + ChatColor.BOLD + "Quarry Chestplate");
        List<String> lore = new ArrayList<>();
        lore.add(" ");
        lore.add(ChatColor.GOLD + "" + ChatColor.BOLD + "Full Set Bonus:");
        lore.add(ChatColor.DARK_PURPLE + "Gain +1 extra of any ore you mine.");
        lore.add(ChatColor.DARK_PURPLE + "You also have unlimited haste 3.");
        lore.add(" ");
        meta.setLore(lore);
        //meta.addItemFlags(ItemFlag.HIDE_DYE);
        chestplate.setItemMeta(meta);
        return chestplate;
    }

    public static ItemStack QuarryArmor_LEGS() {
        ItemStack leggings = new ItemStack(Material.LEATHER_LEGGINGS);
        LeatherArmorMeta meta = (LeatherArmorMeta) leggings.getItemMeta();
        meta.setColor(Color.BLUE);
        meta.addEnchant(Enchantment.DURABILITY, 3, true);
        meta.setDisplayName(ChatColor.GOLD + "" + ChatColor.BOLD + "Quarry Leggings");
        List<String> lore = new ArrayList<>();
        lore.add(" ");
        lore.add(ChatColor.GOLD + "" + ChatColor.BOLD + "Full Set Bonus:");
        lore.add(ChatColor.DARK_PURPLE + "Gain +1 extra of any ore you mine.");
        lore.add(ChatColor.DARK_PURPLE + "You also have unlimited haste 3.");
        lore.add(" ");
        meta.setLore(lore);
        //meta.addItemFlags(ItemFlag.HIDE_DYE);
        leggings.setItemMeta(meta);
        return leggings;
    }

    public static ItemStack QuarryArmor_HELM() {
        ItemStack helmet = new ItemStack(Material.LEATHER_HELMET);
        LeatherArmorMeta meta = (LeatherArmorMeta) helmet.getItemMeta();
        meta.setColor(Color.BLUE);
        meta.addEnchant(Enchantment.DURABILITY, 3, true);
        meta.setDisplayName(ChatColor.GOLD + "" + ChatColor.BOLD + "Quarry Helmet");
        List<String> lore = new ArrayList<>();
        lore.add(" ");
        lore.add(ChatColor.GOLD + "" + ChatColor.BOLD + "Full Set Bonus:");
        lore.add(ChatColor.DARK_PURPLE + "Gain +1 extra of any ore you mine.");
        lore.add(ChatColor.DARK_PURPLE + "You also have unlimited haste 3.");
        lore.add(" ");
        meta.setLore(lore);
        //meta.addItemFlags(ItemFlag.HIDE_DYE);
        helmet.setItemMeta(meta);
        return helmet;
    }

    public static ItemStack QuarryArmor_BOOTS() {
        ItemStack boots = new ItemStack(Material.LEATHER_BOOTS);
        LeatherArmorMeta meta = (LeatherArmorMeta) boots.getItemMeta();
        meta.setColor(Color.BLUE);
        meta.addEnchant(Enchantment.DURABILITY, 3, true);
        meta.setDisplayName(ChatColor.GOLD + "" + ChatColor.BOLD + "Quarry Boots");
        List<String> lore = new ArrayList<>();
        lore.add(" ");
        lore.add(ChatColor.GOLD + "" + ChatColor.BOLD + "Full Set Bonus:");
        lore.add(ChatColor.DARK_PURPLE + "Gain +1 extra of any ore you mine.");
        lore.add(ChatColor.DARK_PURPLE + "You also have unlimited haste 3.");
        lore.add(" ");
        meta.setLore(lore);
        //meta.addItemFlags(ItemFlag.HIDE_DYE);
        boots.setItemMeta(meta);
        return boots;
    }

    public static ItemStack somberCrystal() {
        ItemStack somberCrystal = new ItemStack(Material.ECHO_SHARD);
        ItemMeta meta = somberCrystal.getItemMeta();
        meta.addEnchant(Enchantment.DURABILITY, 1, false);
        //meta.addItemFlags(ItemFlag.HIDE_ENCHANTS, ItemFlag.HIDE_ATTRIBUTES, ItemFlag.HIDE_UNBREAKABLE);
        meta.setDisplayName(ChatColor.GOLD + "" + ChatColor.BOLD + "Somber Crystal");
        List<String> lore = new ArrayList<>();
        lore.add(ChatColor.GOLD + "" + ChatColor.BOLD + "Hit A Player:");
        lore.add(ChatColor.DARK_PURPLE + "Disables totems of undying on someone for 2min");
        lore.add(ChatColor.RED + "One time use!");
        meta.setLore(lore);
        somberCrystal.setItemMeta(meta);
        return somberCrystal;
    }

    public static ItemStack musicBox() {
        ItemStack musicBox = new ItemStack(Material.NOTE_BLOCK);
        ItemMeta meta = musicBox.getItemMeta();
        meta.addEnchant(Enchantment.DURABILITY, 1, false);
        //meta.addItemFlags(ItemFlag.HIDE_ENCHANTS, ItemFlag.HIDE_ATTRIBUTES, ItemFlag.HIDE_UNBREAKABLE);
        meta.setDisplayName(ChatColor.GOLD + "" + ChatColor.BOLD + "Music Box");
        List<String> lore = new ArrayList<>();
        lore.add(ChatColor.GOLD + "" + ChatColor.BOLD + "Right Click:");
        lore.add(ChatColor.DARK_PURPLE + "Lets you play any music disc.");
        meta.setLore(lore);
        musicBox.setItemMeta(meta);
        return musicBox;
    }

    public static ItemStack createNethScarps() {
        ItemStack customBow = new ItemStack(Material.NETHERITE_SCRAP, 4);
        return customBow;
    }
}
