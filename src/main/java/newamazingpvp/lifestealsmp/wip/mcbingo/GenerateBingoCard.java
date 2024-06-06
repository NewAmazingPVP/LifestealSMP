package newamazingpvp.lifestealsmp.wip.mcbingo;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import static newamazingpvp.lifestealsmp.wip.mcbingo.gui.BingoGUIItems.noChallengeGenerated;

public class GenerateBingoCard {

    //bingo challenge GUI items for card ==================================


    public static ItemStack KillEnderDragBingoCard() {
        ItemStack ITEM = new ItemStack(Material.DRAGON_EGG);
        ItemMeta meta = ITEM.getItemMeta();
        meta.setDisplayName(ChatColor.DARK_PURPLE + "" + ChatColor.BOLD + "Kill The Ender Dragon");
        meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
        ITEM.setItemMeta(meta);
        return ITEM;
    }

    public static ItemStack KillWitherBingoCard() {
        ItemStack ITEM = new ItemStack(Material.WITHER_SKELETON_SKULL);
        ItemMeta meta = ITEM.getItemMeta();
        meta.setDisplayName(ChatColor.DARK_PURPLE + "" + ChatColor.BOLD + "Kill The Wither");
        meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
        ITEM.setItemMeta(meta);
        return ITEM;
    }

    public static ItemStack Walk50000BlocksBingoCard() {
        ItemStack ITEM = new ItemStack(Material.COMPASS);
        ItemMeta meta = ITEM.getItemMeta();
        meta.setDisplayName(ChatColor.GREEN + "" + ChatColor.BOLD + "Walk 50,000 Blocks");
        meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
        ITEM.setItemMeta(meta);
        return ITEM;
    }

    public static ItemStack BreakADiamondChestplateBingoCard() {
        ItemStack ITEM = new ItemStack(Material.DIAMOND_CHESTPLATE);
        ItemMeta meta = ITEM.getItemMeta();
        meta.setDisplayName(ChatColor.AQUA + "" + ChatColor.BOLD + "Break A Diamond Chestplate");
        meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
        ITEM.setItemMeta(meta);
        return ITEM;
    }

    public static ItemStack OnlyUseLeatherArmorFor2HBingoCard() {
        ItemStack ITEM = new ItemStack(Material.LEATHER_HELMET);
        ItemMeta meta = ITEM.getItemMeta();
        meta.setDisplayName(ChatColor.RED + "" + ChatColor.BOLD + "Only Use Leather Armor For 2 Hours");
        meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
        ITEM.setItemMeta(meta);
        return ITEM;
    }

    public static ItemStack Eat2GodApplesBingoCard() {
        ItemStack ITEM = new ItemStack(Material.ENCHANTED_GOLDEN_APPLE);
        ItemMeta meta = ITEM.getItemMeta();
        meta.setDisplayName(ChatColor.GOLD + "" + ChatColor.BOLD + "Eat 2 God Apples");
        meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
        ITEM.setItemMeta(meta);
        return ITEM;
    }

    public static ItemStack BreakAnElytraBingoCard() {
        ItemStack ITEM = new ItemStack(Material.ELYTRA);
        ItemMeta meta = ITEM.getItemMeta();
        meta.setDisplayName(ChatColor.DARK_AQUA + "" + ChatColor.BOLD + "Break An Elytra");
        meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
        ITEM.setItemMeta(meta);
        return ITEM;
    }

    public static ItemStack PutOnCurseOfBindingCard() {
        ItemStack ITEM = new ItemStack(Material.NETHERITE_HELMET);
        ItemMeta meta = ITEM.getItemMeta();
        meta.addEnchant(Enchantment.BINDING_CURSE, 1, false);
        meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        meta.setDisplayName(ChatColor.DARK_RED + "" + ChatColor.BOLD + "Put On A Full Set Of Curse Of Binding Armor");
        meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
        ITEM.setItemMeta(meta);
        return ITEM;
    }

    public static ItemStack Use10TotemsOfUndyingBingoCard() {
        ItemStack ITEM = new ItemStack(Material.TOTEM_OF_UNDYING);
        ItemMeta meta = ITEM.getItemMeta();
        meta.setDisplayName(ChatColor.GOLD + "" + ChatColor.BOLD + "Use 10 Totems Of Undying");
        meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
        ITEM.setItemMeta(meta);
        return ITEM;
    }

    public static ItemStack Kill2000EndermanInLeatherArmorBingoCard() {
        ItemStack ITEM = new ItemStack(Material.ENDERMAN_SPAWN_EGG);
        ItemMeta meta = ITEM.getItemMeta();
        meta.setDisplayName(ChatColor.DARK_PURPLE + "" + ChatColor.BOLD + "Kill 2,000 Enderman While In Leather Armor");
        meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
        ITEM.setItemMeta(meta);
        return ITEM;
    }


    //these item stacks have variables in them

    public static ItemStack KillAPlayerStandingOnXBlockBingoCard() {
        ItemStack ITEM = new ItemStack(Material.REDSTONE_BLOCK);
        ItemMeta meta = ITEM.getItemMeta();
        meta.setDisplayName(ChatColor.RED + "" + ChatColor.BOLD + "Kill A Player Who Is Standing On " + BlockToKillPlayerOn);
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
        meta.setDisplayName(ChatColor.DARK_BLUE + "" + ChatColor.BOLD + "Mine " + BlockAmountToBreak + " Of " + BlockToBreakXAmountOf + " With Bingo Pickaxe");
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
        ItemStack ITEM = new ItemStack(Material.CROSSBOW);
        ItemMeta meta = ITEM.getItemMeta();
        meta.setDisplayName(ChatColor.DARK_PURPLE + "" + ChatColor.BOLD + "Kill A Player Who Has " + ArmorYouKillPlayerInWithCrossbow + " On From At Most 10 Blocks Away With A Crossbow");
        meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
        ITEM.setItemMeta(meta);
        return ITEM;
    }

    public static ItemStack HarvestXAmountOfXCropBingoCard() {
        ItemStack ITEM = new ItemStack(Material.WHEAT_SEEDS);
        ItemMeta meta = ITEM.getItemMeta();
        meta.setDisplayName(ChatColor.GREEN + "" + ChatColor.BOLD + "Farm " + AmountOfCrop + " Of " + CropToHarvest);
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
    static String EatXAmountOffFoodType;
    static int FoodAmount;
    static String GetXPotionEffect;
    static String BlockToBreakXAmountOf;
    static int BlockAmountToBreak;
    static int BreakAnyBlockTypeNum;
    static String ThingToCraftXAmountOf;
    static int AmountToCraft;
    static String MobToBreadXAmountOf;
    static int AmountOfMobToBread;
    static int AmountOfXPLevelsToGet;
    static String ArmorYouKillPlayerInWithCrossbow;
    static String CropToHarvest;
    static int AmountOfCrop;
    static String MobHeadToFind;


    /*public static ItemStack bingo1 = noChallengeGenerated();
    public static ItemStack bingo2 = noChallengeGenerated();
    public static ItemStack bingo3 = noChallengeGenerated();
    public static ItemStack bingo4 = noChallengeGenerated();
    public static ItemStack bingo5 = noChallengeGenerated();
    public static ItemStack bingo6 = noChallengeGenerated();
    public static ItemStack bingo7 = noChallengeGenerated();
    public static ItemStack bingo8 = noChallengeGenerated();
    public static ItemStack bingo9 = noChallengeGenerated();
    public static ItemStack bingo10 = noChallengeGenerated();
    public static ItemStack bingo11 = noChallengeGenerated();
    public static ItemStack bingo12 = noChallengeGenerated();
    public static ItemStack bingo13 = noChallengeGenerated();
    public static ItemStack bingo14 = noChallengeGenerated();
    public static ItemStack bingo15 = noChallengeGenerated();
    public static ItemStack bingo16 = noChallengeGenerated();
    public static ItemStack bingo17 = noChallengeGenerated();
    public static ItemStack bingo18 = noChallengeGenerated();
    public static ItemStack bingo19 = noChallengeGenerated();
    public static ItemStack bingo20 = noChallengeGenerated();
    public static ItemStack bingo21 = noChallengeGenerated();
    public static ItemStack bingo22 = noChallengeGenerated();
    public static ItemStack bingo23 = noChallengeGenerated();
    public static ItemStack bingo24 = noChallengeGenerated();
    public static ItemStack bingo25 = noChallengeGenerated();*/


    public static List<ItemStack> cardGenList = new ArrayList<>();

    public static List<ItemStack> generatedChallenges = new ArrayList<>();


    //generates new card also this should add it to a YML and the thing that makes the bingo card GUI should look at the YML to set what there should be
    public static void genBingoCard(Player player) {

        Bukkit.broadcastMessage(ChatColor.GOLD + "" + ChatColor.BOLD + "NEW BINGO EVENT GENERATING!");
        Bukkit.broadcastMessage(ChatColor.GRAY + "Loading...");

        cardGenList.add(KillEnderDragBingoCard());
        cardGenList.add(KillWitherBingoCard());
        cardGenList.add(CraftXAmountOfXBingoCard()); //TODO: MAKE EVENT
        cardGenList.add(BreakAnElytraBingoCard());
        cardGenList.add(BreedXAmountOfXMobBingoCard()); //TODO: MAKE EVENT
        cardGenList.add(Eat2GodApplesBingoCard()); //TODO: MAKE EVENT
        cardGenList.add(PutOnCurseOfBindingCard()); //TODO: MAKE EVENT
        cardGenList.add(OnlyUseLeatherArmorFor2HBingoCard()); //TODO: MAKE EVENT
        cardGenList.add(KillAPlayerInXArmorBingoCard()); //TODO: MAKE EVENT
        cardGenList.add(BreakADiamondChestplateBingoCard()); //TODO: MAKE EVENT
        cardGenList.add(BreakXAmountOfAnyBlockBingoCard()); //TODO: MAKE EVENT
        cardGenList.add(BreakXAmountOfXBlockWithBingoPickBingoCard()); //TODO: MAKE EVENT
        cardGenList.add(EatXAmountOfXFoodBingoCard()); //TODO: MAKE EVENT
        cardGenList.add(FindXMobHeadBingoCard()); //TODO: MAKE EVENT
        cardGenList.add(GetToXAmountOfXPLevelsBingoCard()); //TODO: MAKE EVENT
        cardGenList.add(GetXPotionEffectBingoCard()); //TODO: MAKE EVENT
        cardGenList.add(Kill1500OfXMobBingoCard()); //TODO: MAKE EVENT
        cardGenList.add(Kill2000EndermanInLeatherArmorBingoCard()); //TODO: MAKE EVENT
        cardGenList.add(HarvestXAmountOfXCropBingoCard()); //TODO: MAKE EVENT
        cardGenList.add(KillAPlayerStandingOnXBlockBingoCard()); //TODO: MAKE EVENT
        cardGenList.add(KillAPlayerThatIsInXArmorFromAtMost10BlocksAwayBingoCard()); //TODO: MAKE EVENT
        cardGenList.add(Use10TotemsOfUndyingBingoCard()); //TODO: MAKE EVENT
        cardGenList.add(Walk50000BlocksBingoCard()); //TODO: MAKE EVENT


        generatedChallenges.add(noChallengeGenerated());
        generatedChallenges.add(noChallengeGenerated());
        generatedChallenges.add(noChallengeGenerated());
        generatedChallenges.add(noChallengeGenerated());
        generatedChallenges.add(noChallengeGenerated());
        generatedChallenges.add(noChallengeGenerated());
        generatedChallenges.add(noChallengeGenerated());
        generatedChallenges.add(noChallengeGenerated());
        generatedChallenges.add(noChallengeGenerated());
        generatedChallenges.add(noChallengeGenerated());
        generatedChallenges.add(noChallengeGenerated());
        generatedChallenges.add(noChallengeGenerated());
        generatedChallenges.add(noChallengeGenerated());
        generatedChallenges.add(noChallengeGenerated());
        generatedChallenges.add(noChallengeGenerated());
        generatedChallenges.add(noChallengeGenerated());
        generatedChallenges.add(noChallengeGenerated());
        generatedChallenges.add(noChallengeGenerated());
        generatedChallenges.add(noChallengeGenerated());
        generatedChallenges.add(noChallengeGenerated());
        generatedChallenges.add(noChallengeGenerated());
        generatedChallenges.add(noChallengeGenerated());
        generatedChallenges.add(noChallengeGenerated());
        generatedChallenges.add(noChallengeGenerated());
        generatedChallenges.add(noChallengeGenerated());


        Random rand = new Random();

        for (int i = 0; i < 25; i++) {

            int randomIndex = rand.nextInt(cardGenList.size());
            ItemStack randomItem = cardGenList.get(randomIndex);
            generatedChallenges.set(i, randomItem);
        }

        Bukkit.broadcastMessage(ChatColor.GRAY + "Generated Successfully!");


    }

}


