package newamazingpvp.lifestealsmp.customitems.utils;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.ShapedRecipe;
import org.bukkit.inventory.ShapelessRecipe;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;
import java.util.List;

import static newamazingpvp.lifestealsmp.LifestealSMP.lifestealSmp;
import static newamazingpvp.lifestealsmp.customitems.utils.GUI.*;
import static newamazingpvp.lifestealsmp.customitems.utils.ItemStacks.*;
import static newamazingpvp.lifestealsmp.customitems.utils.ItemStacks.lightFeather;

public class Recipes {
    public static void registerCustomRecipes() {

        /*ItemStack VWH = new ItemStack(VoidWalkerHEALM());
        ShapedRecipe VWHR = new ShapedRecipe(new NamespacedKey(lifestealSmp, "VoidWalkerHealmR"), VWH);
        VWHR.shape("DAD", "BXB", "TNT");
        VWHR.setIngredient('D', Material.DIAMOND_BLOCK, 5);
        VWHR.setIngredient('N', Material.NETHERITE_INGOT, 3);
        VWHR.setIngredient('B', Material.BEACON);
        VWHR.setIngredient('X', Material.DRAGON_HEAD);
        VWHR.setIngredient('T', Material.DRAGON_BREATH);
        VWHR.setIngredient('A', antimatterVile());

        Bukkit.addRecipe(VWHR);*/

        ItemStack extraHeart = new ItemStack(extraHeart());
        ShapedRecipe extraHeartRecipe = new ShapedRecipe(new NamespacedKey(lifestealSmp, "extra_heart"), extraHeart);
        extraHeartRecipe.shape("CXC", "DSD", "XNX");
        extraHeartRecipe.setIngredient('D', Material.DIAMOND_BLOCK);
        extraHeartRecipe.setIngredient('N', Material.NETHERITE_INGOT);
        extraHeartRecipe.setIngredient('C', corruptedMobSoul());
        extraHeartRecipe.setIngredient('S', severedMobHeart());
        extraHeartRecipe.setIngredient('X', Material.AIR);
        customItems.add(extraHeart);
        shapedRecipes.put(extraHeart, extraHeartRecipe);
        Bukkit.addRecipe(extraHeartRecipe);

        ItemStack shulker = new ItemStack(Material.SHULKER_BOX);
        ShapedRecipe shulkerRecipe = new ShapedRecipe(new NamespacedKey(lifestealSmp, "shulker_recipe"), shulker);
        shulkerRecipe.shape("DDD", "DCD", "DDD");
        shulkerRecipe.setIngredient('C', Material.CHEST);
        shulkerRecipe.setIngredient('D', Material.DIAMOND);
        customItems.add(shulker);
        shapedRecipes.put(shulker, shulkerRecipe);
        Bukkit.addRecipe(shulkerRecipe);

        ItemStack endStone = new ItemStack(Material.END_STONE);
        ShapedRecipe endStoneRecipe = new ShapedRecipe(new NamespacedKey(lifestealSmp, "end_stone_recipe"), endStone);
        endStoneRecipe.shape("DNE");
        endStoneRecipe.setIngredient('D', Material.DIRT);
        endStoneRecipe.setIngredient('N', Material.NETHERRACK);
        endStoneRecipe.setIngredient('E', Material.COBBLESTONE);
        customItems.add(endStone);
        shapedRecipes.put(endStone, endStoneRecipe);
        Bukkit.addRecipe(endStoneRecipe);

        ItemStack purpleBlock = new ItemStack(Material.PURPUR_BLOCK);
        ShapedRecipe purpleBlockRecipe = new ShapedRecipe(new NamespacedKey(lifestealSmp, "purple_block_recipe"), purpleBlock);
        purpleBlockRecipe.shape("NS");
        purpleBlockRecipe.setIngredient('N', Material.NETHER_BRICKS);
        purpleBlockRecipe.setIngredient('S', Material.STONE_BRICKS);
        customItems.add(purpleBlock);
        shapedRecipes.put(purpleBlock, purpleBlockRecipe);
        Bukkit.addRecipe(purpleBlockRecipe);

        NamespacedKey recipeKey = new NamespacedKey(lifestealSmp, "teleporting_bow");
        ShapelessRecipe customBowRecipe = new ShapelessRecipe(recipeKey, createCustomBow());
        customBowRecipe.addIngredient(2, Material.ENDER_PEARL);
        customBowRecipe.addIngredient(1, Material.NETHERITE_INGOT);
        customBowRecipe.addIngredient(1, Material.BOW);
        customBowRecipe.addIngredient(1, Material.NETHER_STAR);
        customBowRecipe.addIngredient(2, Material.DIAMOND);
        customItems.add(createCustomBow());
        shapelessRecipes.put(createCustomBow(), customBowRecipe);
        Bukkit.addRecipe(customBowRecipe);

        NamespacedKey tntBow = new NamespacedKey(lifestealSmp, "tnt_bow");
        ShapelessRecipe tntBowRecipe = new ShapelessRecipe(tntBow, createTNTBow());
        tntBowRecipe.addIngredient(2, Material.TNT);
        tntBowRecipe.addIngredient(2, Material.NETHERITE_INGOT);
        tntBowRecipe.addIngredient(1, Material.BOW);
        tntBowRecipe.addIngredient(1, Material.END_CRYSTAL);
        tntBowRecipe.addIngredient(1, Material.NETHER_STAR);
        customItems.add(createTNTBow());
        shapelessRecipes.put(createTNTBow(), tntBowRecipe);
        Bukkit.addRecipe(tntBowRecipe);

        NamespacedKey featherSword = new NamespacedKey(lifestealSmp, "feather_sword");
        ShapelessRecipe featherSwordRecipe = new ShapelessRecipe(featherSword, createFeatherSword());
        featherSwordRecipe.addIngredient(2, Material.FEATHER);
        featherSwordRecipe.addIngredient(2, Material.NETHERITE_INGOT);
        featherSwordRecipe.addIngredient(1, Material.DIAMOND_SWORD);
        featherSwordRecipe.addIngredient(2, Material.TOTEM_OF_UNDYING);
        featherSwordRecipe.addIngredient(2, Material.NETHER_STAR);
        customItems.add(createFeatherSword());
        shapelessRecipes.put(createFeatherSword(), featherSwordRecipe);
        Bukkit.addRecipe(featherSwordRecipe);

        NamespacedKey tropChopAxe = new NamespacedKey(lifestealSmp, "trop_chop_axe");
        ShapelessRecipe tropChopAxeRecipe = new ShapelessRecipe(tropChopAxe, createCustomAxe());
        tropChopAxeRecipe.addIngredient(1, Material.STICK);
        tropChopAxeRecipe.addIngredient(1, Material.NETHERITE_INGOT);
        tropChopAxeRecipe.addIngredient(3, Material.DIAMOND_AXE);
        customItems.add(createCustomAxe());
        shapelessRecipes.put(createCustomAxe(), tropChopAxeRecipe);
        Bukkit.addRecipe(tropChopAxeRecipe);

        NamespacedKey opPickaxe = new NamespacedKey(lifestealSmp, "op_pickaxe");
        ShapelessRecipe opPickaxeRecipe = new ShapelessRecipe(opPickaxe, createOpPickaxe());
        opPickaxeRecipe.addIngredient(2, Material.DIAMOND_BLOCK);
        opPickaxeRecipe.addIngredient(1, Material.GOLD_BLOCK);
        opPickaxeRecipe.addIngredient(5, Material.NETHERITE_INGOT);
        opPickaxeRecipe.addIngredient(1, Material.DIAMOND_PICKAXE);
        customItems.add(createOpPickaxe());
        shapelessRecipes.put(createOpPickaxe(), opPickaxeRecipe);
        Bukkit.addRecipe(opPickaxeRecipe);

        NamespacedKey nethScraps = new NamespacedKey(lifestealSmp, "neth_scraps");
        ShapelessRecipe nethScrapsRecipe = new ShapelessRecipe(nethScraps, createNethScarps());
        nethScrapsRecipe.addIngredient(1, Material.NETHERITE_INGOT);
        customItems.add(createNethScarps());
        shapelessRecipes.put(createNethScarps(), nethScrapsRecipe);
        Bukkit.addRecipe(nethScrapsRecipe);

        NamespacedKey homingBow = new NamespacedKey(lifestealSmp, "homing_bow");
        ShapelessRecipe homingBowRecipe = new ShapelessRecipe(homingBow, createHomingBow());
        homingBowRecipe.addIngredient(1, Material.BOW);
        homingBowRecipe.addIngredient(2, Material.NETHERITE_INGOT);
        homingBowRecipe.addIngredient(2, Material.DIAMOND_BLOCK);
        homingBowRecipe.addIngredient(1, Material.NETHER_STAR);
        homingBowRecipe.addIngredient(2, Material.COMPASS);
        customItems.add(createHomingBow());
        shapelessRecipes.put(createHomingBow(), homingBowRecipe);
        Bukkit.addRecipe(homingBowRecipe);

        NamespacedKey reviveBeacon = new NamespacedKey(lifestealSmp, "revive_beacon");
        ShapelessRecipe reviveBeaconRecipe = new ShapelessRecipe(reviveBeacon, createReviveBeacon());
        reviveBeaconRecipe.addIngredient(1, Material.BEACON);
        reviveBeaconRecipe.addIngredient(4, Material.DIAMOND_BLOCK);
        reviveBeaconRecipe.addIngredient(1, Material.NETHERITE_BLOCK);
        reviveBeaconRecipe.addIngredient(2, Material.TOTEM_OF_UNDYING);
        reviveBeaconRecipe.addIngredient(1, Material.GOLDEN_APPLE);
        customItems.add(createReviveBeacon());
        shapelessRecipes.put(createReviveBeacon(), reviveBeaconRecipe);
        Bukkit.addRecipe(reviveBeaconRecipe);

        //YAY UPDATE =D

        ItemStack lightFeather = new ItemStack(lightFeather());
        ShapedRecipe lightFeatherRecipe = new ShapedRecipe(new NamespacedKey(lifestealSmp, "lightFeather"), lightFeather);
        lightFeatherRecipe.shape("FSF", "SFS", "FSF");
        lightFeatherRecipe.setIngredient('F', Material.FEATHER);
        lightFeatherRecipe.setIngredient('S', Material.SUGAR);
        shapedRecipes.put(lightFeather, lightFeatherRecipe);
        customItems.add(lightFeather());
        Bukkit.addRecipe(lightFeatherRecipe);

        ItemStack instaboomTNT = new ItemStack(InstaBoomTNT());
        ShapedRecipe instaboomTNTRecipe = new ShapedRecipe(new NamespacedKey(lifestealSmp, "instaboomTNT"), instaboomTNT);
        instaboomTNTRecipe.shape("TDT", "TET", "TTT");
        instaboomTNTRecipe.setIngredient('T', Material.TNT);
        instaboomTNTRecipe.setIngredient('E', Material.END_CRYSTAL);
        instaboomTNTRecipe.setIngredient('D', Material.DIAMOND);
        shapedRecipes.put(instaboomTNT, instaboomTNTRecipe);
        customItems.add(InstaBoomTNT());
        Bukkit.addRecipe(instaboomTNTRecipe);

        ItemStack LifestealSword = new ItemStack(LifestealStick());
        ShapedRecipe LifestealSwordRecipe = new ShapedRecipe(new NamespacedKey(lifestealSmp, "LifestealSword"), LifestealSword);
        LifestealSwordRecipe.shape("WHW", "WFW", "NSN");
        LifestealSwordRecipe.setIngredient('H', extraHeart());
        LifestealSwordRecipe.setIngredient('F', heavyNetherStar());
        LifestealSwordRecipe.setIngredient('S', powerStick());
        LifestealSwordRecipe.setIngredient('N', Material.NETHERITE_INGOT);
        LifestealSwordRecipe.setIngredient('W', Material.WITHER_SKELETON_SKULL);
        shapedRecipes.put(LifestealSword, LifestealSwordRecipe);
        customItems.add(LifestealStick());
        Bukkit.addRecipe(LifestealSwordRecipe);

        ItemStack heavyNetherStar = new ItemStack(heavyNetherStar());
        ShapedRecipe heavyNetherStarRecipe = new ShapedRecipe(new NamespacedKey(lifestealSmp, "heavyNetherStar"), heavyNetherStar);
        heavyNetherStarRecipe.shape("NNN", "NSN", "NNN");
        heavyNetherStarRecipe.setIngredient('N', Material.NETHER_STAR);
        heavyNetherStarRecipe.setIngredient('S', Material.NETHERITE_SCRAP);
        shapedRecipes.put(heavyNetherStar, heavyNetherStarRecipe);
        customItems.add(heavyNetherStar());
        Bukkit.addRecipe(heavyNetherStarRecipe);


        ItemStack musicBox = new ItemStack(musicBox());
        ShapedRecipe musicBoxRecipe = new ShapedRecipe(new NamespacedKey(lifestealSmp, "musicBox"), musicBox);
        musicBoxRecipe.shape("FPF", "DJD", "FOF");
        musicBoxRecipe.setIngredient('P', Material.MUSIC_DISC_PIGSTEP);
        musicBoxRecipe.setIngredient('O', Material.MUSIC_DISC_OTHERSIDE);
        musicBoxRecipe.setIngredient('F', Material.DISC_FRAGMENT_5);
        musicBoxRecipe.setIngredient('D', Material.DIAMOND);
        musicBoxRecipe.setIngredient('J', Material.JUKEBOX);
        shapedRecipes.put(musicBox, musicBoxRecipe);
        customItems.add(musicBox());
        Bukkit.addRecipe(musicBoxRecipe);

        ItemStack somberCrystal = new ItemStack(somberCrystal());
        ShapedRecipe somberCrystalRecipe = new ShapedRecipe(new NamespacedKey(lifestealSmp, "somberCrystal"), somberCrystal);
        somberCrystalRecipe.shape("NNN", "NED", "DDD");
        somberCrystalRecipe.setIngredient('D', Material.DIAMOND_BLOCK);
        somberCrystalRecipe.setIngredient('E', Material.ECHO_SHARD);
        somberCrystalRecipe.setIngredient('N', Material.NETHER_STAR);
        shapedRecipes.put(somberCrystal, somberCrystalRecipe);
        customItems.add(somberCrystal()); 
        Bukkit.addRecipe(somberCrystalRecipe);


    }
}
