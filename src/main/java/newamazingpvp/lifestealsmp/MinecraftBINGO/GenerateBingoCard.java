package newamazingpvp.lifestealsmp.MinecraftBINGO;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class GenerateBingoCard {

    //bingo challenge GUI items for card ==================================


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

    public static ItemStack Kill2000EndermanInLeatherArmorBingoCard(){
        ItemStack ITEM = new ItemStack(Material.ENDERMAN_SPAWN_EGG);
        ItemMeta meta = ITEM.getItemMeta();
        meta.setDisplayName(ChatColor.DARK_PURPLE + "" + ChatColor.BOLD + "Kill 2,000 Enderman While In Leather Armor");
        meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
        ITEM.setItemMeta(meta);
        return ITEM;
    }




    //these item stacks have variables in them

    public static ItemStack KillAPlayerStandingOnXBlockBingoCard(){
        ItemStack ITEM = new ItemStack(Material.END_GATEWAY);
        ItemMeta meta = ITEM.getItemMeta();
        meta.setDisplayName(ChatColor.RED + "" + ChatColor.BOLD + "Kill A Player Standing On " + BlockToKillPlayerOn);
        meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
        ITEM.setItemMeta(meta);
        return ITEM;
    }

    public static ItemStack KillAPlayerInXArmorBingoCard() {
        ItemStack ITEM = new ItemStack(Material.GOLDEN_CHESTPLATE);
        ItemMeta meta = ITEM.getItemMeta();
        meta.setDisplayName(ChatColor.LIGHT_PURPLE + "" + ChatColor.BOLD + "Kill A Player Who Has " + KillAPlayerInXArmor + " On");
        meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
        ITEM.setItemMeta(meta);
        return ITEM;
    }

    public static ItemStack Kill1500OfXMobBingoCard() {
        ItemStack ITEM = new ItemStack(Material.ZOMBIE_HEAD);
        ItemMeta meta = ITEM.getItemMeta();
        meta.setDisplayName(ChatColor.DARK_RED + "" + ChatColor.BOLD + "Kill 1,500 " + MobToKill1500Of);
        meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
        ITEM.setItemMeta(meta);
        return ITEM;
    }

    public static ItemStack EatXAmountOfXFoodBingoCard() {
        ItemStack ITEM = new ItemStack(Material.COOKED_BEEF);
        ItemMeta meta = ITEM.getItemMeta();
        meta.setDisplayName(ChatColor.DARK_GREEN + "" + ChatColor.BOLD + "Eat " + FoodAmount + " Of " + EatXAmountOffFoodType);
        meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
        ITEM.setItemMeta(meta);
        return ITEM;
    }

    public static ItemStack GetXPotionEffectBingoCard() {
        ItemStack ITEM = new ItemStack(Material.GLASS_BOTTLE);
        ItemMeta meta = ITEM.getItemMeta();
        meta.setDisplayName(ChatColor.AQUA + "" + ChatColor.BOLD + "Get " + GetXPotionEffect + " Potion Effect");
        meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
        ITEM.setItemMeta(meta);
        return ITEM;
    }

    public static ItemStack BreakXAmountOfXBlockWithBingoPickBingoCard() {
        ItemStack ITEM = new ItemStack(Material.IRON_PICKAXE);
        ItemMeta meta = ITEM.getItemMeta();
        meta.setDisplayName(ChatColor.DARK_BLUE + "" + ChatColor.BOLD + "Mine " + BlockToBreakXAmountOf + " Of " + BlockAmountToBreak + " With Bingo Pickaxe");
        meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
        ITEM.setItemMeta(meta);
        return ITEM;
    }

    public static ItemStack BreakXAmountOfAnyBlockBingoCard() {
        ItemStack ITEM = new ItemStack(Material.DIAMOND_BLOCK);
        ItemMeta meta = ITEM.getItemMeta();
        meta.setDisplayName(ChatColor.DARK_BLUE + "" + ChatColor.BOLD + "Mine " + BreakAnyBlockTypeNum + " Of Any Block With Bingo Pickaxe");
        meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
        ITEM.setItemMeta(meta);
        return ITEM;
    }

    public static ItemStack CraftXAmountOfXBingoCard() {
        ItemStack ITEM = new ItemStack(Material.CRAFTING_TABLE);
        ItemMeta meta = ITEM.getItemMeta();
        meta.setDisplayName(ChatColor.BLUE + "" + ChatColor.BOLD + "Craft " + AmountToCraft + " Of " + ThingToCraftXAmountOf);
        meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
        ITEM.setItemMeta(meta);
        return ITEM;
    }

    public static ItemStack BreedXAmountOfXMobBingoCard() {
        ItemStack ITEM = new ItemStack(Material.COW_SPAWN_EGG);
        ItemMeta meta = ITEM.getItemMeta();
        meta.setDisplayName(ChatColor.RED + "" + ChatColor.BOLD + "Breed " + AmountOfMobToBread + " Of " + MobToBreadXAmountOf);
        meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
        ITEM.setItemMeta(meta);
        return ITEM;
    }

    public static ItemStack GetToXAmountOfXPLevelsBingoCard() {
        ItemStack ITEM = new ItemStack(Material.EXPERIENCE_BOTTLE);
        ItemMeta meta = ITEM.getItemMeta();
        meta.setDisplayName(ChatColor.LIGHT_PURPLE + "" + ChatColor.BOLD + "Get To " + AmountOfXPLevelsToGet + " XP Levels");
        meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
        ITEM.setItemMeta(meta);
        return ITEM;
    }

    public static ItemStack KillAPlayerThatIsInXArmorFromAtMost10BlocksAwayBingoCard() {
        ItemStack ITEM = new ItemStack(Material.DIAMOND_HELMET);
        ItemMeta meta = ITEM.getItemMeta();
        meta.setDisplayName(ChatColor.DARK_PURPLE + "" + ChatColor.BOLD + "Kill A Player Who Has " + ArmorYouKillPlayerInWithCrossbow + " On From At Most 10 Blocks Away");
        meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
        ITEM.setItemMeta(meta);
        return ITEM;
    }

    public static ItemStack HarvestXAmountOfXCropBingoCard() {
        ItemStack ITEM = new ItemStack(Material.WHEAT_SEEDS);
        ItemMeta meta = ITEM.getItemMeta();
        meta.setDisplayName(ChatColor.GREEN + "" + ChatColor.BOLD + "Farm"  + CropToHarvest + " Of " + AmountOfCrop);
        meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
        ITEM.setItemMeta(meta);
        return ITEM;
    }

    public static ItemStack FindXMobHeadBingoCard() {
        ItemStack ITEM = new ItemStack(Material.SKELETON_SKULL);
        ItemMeta meta = ITEM.getItemMeta();
        meta.setDisplayName(ChatColor.RED + "" + ChatColor.BOLD + "Find A " + MobHeadToFind);
        meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
        ITEM.setItemMeta(meta);
        return ITEM;
    }







    //helps find random blocks and mobs ==================================


    //variables
    static String BlockToKillPlayerOn;
    static String KillAPlayerInXArmor;
    static String MobToKill1500Of;
    static String EatXAmountOffFoodType; static int FoodAmount;
    static String GetXPotionEffect;
    static String BlockToBreakXAmountOf; static int BlockAmountToBreak;
    static int BreakAnyBlockTypeNum;
    static String ThingToCraftXAmountOf; static int AmountToCraft;
    static String MobToBreadXAmountOf; static int AmountOfMobToBread;
    static int AmountOfXPLevelsToGet;
    static String ArmorYouKillPlayerInWithCrossbow;
    static String CropToHarvest; static int AmountOfCrop;
    static String MobHeadToFind;

    //idk def a better way to do this we should fix

    public static ItemStack bingo1 = null;
    public static ItemStack bingo2 = null;
    public static ItemStack bingo3 = null;
    public static ItemStack bingo4 = null;
    public static ItemStack bingo5 = null;
    public static ItemStack bingo6 = null;
    public static ItemStack bingo7 = null;
    public static ItemStack bingo8 = null;
    public static ItemStack bingo9 = null;
    public static ItemStack bingo10 = null;
    public static ItemStack bingo11 = null;
    public static ItemStack bingo12 = null;
    public static ItemStack bingo13 = null;
    public static ItemStack bingo14 = null;
    public static ItemStack bingo15 = null;
    public static ItemStack bingo16 = null;
    public static ItemStack bingo17 = null;
    public static ItemStack bingo18 = null;
    public static ItemStack bingo19 = null;
    public static ItemStack bingo20 = null;
    public static ItemStack bingo21 = null;
    public static ItemStack bingo22 = null;
    public static ItemStack bingo23 = null;
    public static ItemStack bingo24 = null;
    public static ItemStack bingo25 = null;


    //generates new card also this should add it to a YML and the thing that makes the bingo card GUI should look at the YML to set what there should be
    public static void genBingoCard() {

        Random random = new Random();

        String newBingoChallenge = null;

        for (int i = 0; i < 25; i++) {

            int randomNumber = random.nextInt(24);



        }

    }



}
