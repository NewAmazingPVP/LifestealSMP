package newamazingpvp.lifestealsmp.MinecraftBINGO;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;
import java.util.List;

public class GenerateBingoCard {

    //bingo challenge GUI items for card

    public static ItemStack KillEnderDragBingoCard(){
        ItemStack ITEM = new ItemStack(Material.DRAGON_EGG);
        ItemMeta meta = ITEM.getItemMeta();
        meta.setDisplayName(ChatColor.DARK_PURPLE + "" + ChatColor.BOLD + "Kill The Ender Dragon");
        meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
        ITEM.setItemMeta(meta);
        return ITEM;
    }

    public static ItemStack KillWitherBingoCard(){
        ItemStack ITEM = new ItemStack(Material.WITHER_SKELETON_SKULL);
        ItemMeta meta = ITEM.getItemMeta();
        meta.setDisplayName(ChatColor.DARK_PURPLE + "" + ChatColor.BOLD + "Kill The Wither");
        meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
        ITEM.setItemMeta(meta);
        return ITEM;
    }

    public static ItemStack Walk50000BlocksBingoCard(){
        ItemStack ITEM = new ItemStack(Material.COMPASS);
        ItemMeta meta = ITEM.getItemMeta();
        meta.setDisplayName(ChatColor.GREEN + "" + ChatColor.BOLD + "Walk 50,000 Blocks");
        meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
        ITEM.setItemMeta(meta);
        return ITEM;
    }

    public static ItemStack BreakADiamondChestplateBingoCard(){
        ItemStack ITEM = new ItemStack(Material.DIAMOND_CHESTPLATE);
        ItemMeta meta = ITEM.getItemMeta();
        meta.setDisplayName(ChatColor.AQUA + "" + ChatColor.BOLD + "Break A Diamond Chestplate");
        meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
        ITEM.setItemMeta(meta);
        return ITEM;
    }

    public static ItemStack OnlyUseLeatherArmorFor2HBingoCard(){
        ItemStack ITEM = new ItemStack(Material.LEATHER_HELMET);
        ItemMeta meta = ITEM.getItemMeta();
        meta.setDisplayName(ChatColor.RED + "" + ChatColor.BOLD + "Only Use Leather Armor For 2 Hours");
        meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
        ITEM.setItemMeta(meta);
        return ITEM;
    }

    public static ItemStack Eat2GodApplesBingoCard(){
        ItemStack ITEM = new ItemStack(Material.ENCHANTED_GOLDEN_APPLE);
        ItemMeta meta = ITEM.getItemMeta();
        meta.setDisplayName(ChatColor.GOLD + "" + ChatColor.BOLD + "Eat 2 God Apples");
        meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
        ITEM.setItemMeta(meta);
        return ITEM;
    }

    public static ItemStack BreakAnElytraBingoCard(){
        ItemStack ITEM = new ItemStack(Material.ELYTRA);
        ItemMeta meta = ITEM.getItemMeta();
        meta.setDisplayName(ChatColor.DARK_AQUA + "" + ChatColor.BOLD + "Break An Elytra");
        meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
        ITEM.setItemMeta(meta);
        return ITEM;
    }

    public static ItemStack PutOnCurseOfBindingCard(){
        ItemStack ITEM = new ItemStack(Material.NETHERITE_HELMET);
        ItemMeta meta = ITEM.getItemMeta();
        meta.addEnchant(Enchantment.BINDING_CURSE, 1, false);
        meta.setDisplayName(ChatColor.DARK_RED + "" + ChatColor.BOLD + "Put On A Full Set Of Curse Of Binding Armor");
        meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
        ITEM.setItemMeta(meta);
        return ITEM;
    }

    public static ItemStack Use10TotemsOfUndyingBingoCard(){
        ItemStack ITEM = new ItemStack(Material.TOTEM_OF_UNDYING);
        ItemMeta meta = ITEM.getItemMeta();
        meta.setDisplayName(ChatColor.GOLD + "" + ChatColor.BOLD + "Use 10 Totem Of Undying");
        meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
        ITEM.setItemMeta(meta);
        return ITEM;
    }









    //helps find random blocks and mobs

    String BlockToKillPlayerOn;
    String KillAPlayerInXArmor;
    String MobToKill500Of;
    String EatXAmountOffFoodType; int FoodAmount;
    String GetXPotionEffect;
    String BlockToBreakXAmountOf; int BlockAmountToBreak;
    int BreakAnyBlockTypeNum;
    String ThingToCraftXAmountOf; int AmountToCraft;
    String MobToBreadXAmountOf; int AmountOfMobToBread;
    int AmountOfXPLevelsToGet;
    String ArmorYouKillPlayerInWithCrossbow;
    String CropToHarvest; int AmountOfCrop;
    String MobHeadToFind;
    int NumberOfEndermanToKill;




    //generates new card also this should add it to a YML and the thing that makes the bingo card GUI should look at the YML to set what there should be
    public static void genBingoCard() {

        String newBingoChallenge = null;

        for (int i = 0; i < 25; i++) {



        }

    }

}
