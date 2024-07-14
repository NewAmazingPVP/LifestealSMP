package newamazingpvp.lifestealsmp.customitems.utils;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.ShapedRecipe;
import org.bukkit.inventory.ShapelessRecipe;

import java.util.Map;

import static newamazingpvp.lifestealsmp.LifestealSMP.lifestealSmp;
import static newamazingpvp.lifestealsmp.customitems.utils.GUI.*;
import static newamazingpvp.lifestealsmp.customitems.utils.ItemStacks.*;
import static newamazingpvp.lifestealsmp.utility.TimeManager.CUSTOM_ITEMS_AND_RUNES;
import static newamazingpvp.lifestealsmp.utility.TimeManager.isTimePassed;

public class Recipes {

    /*public static void addRecipes(){
        if(!isTimePassed(CUSTOM_ITEMS_AND_RUNES)) return;
        for(Map.Entry<ItemStack, ShapedRecipe> e : shapedRecipes.entrySet()){
            if(Bukkit.getRecipe(e.getValue().getKey()) == null) {
                Bukkit.addRecipe(e.getValue());
            }
        }
        for(Map.Entry<ItemStack, ShapelessRecipe> e : shapelessRecipes.entrySet()){
            if(Bukkit.getRecipe(e.getValue().getKey()) == null) {
                Bukkit.addRecipe(e.getValue());
            }
        }
    }*/

    public static void registerBasicRecipes() {
        ItemStack extraHeart = new ItemStack(extraHeart());
        ShapedRecipe extraHeartRecipe = new ShapedRecipe(new NamespacedKey(lifestealSmp, "extra_heart"), extraHeart);
        extraHeartRecipe.shape("C C", "DSD", " N ");
        extraHeartRecipe.setIngredient('D', Material.DIAMOND_BLOCK);
        extraHeartRecipe.setIngredient('N', Material.NETHERITE_INGOT);
        extraHeartRecipe.setIngredient('C', corruptedMobSoul());
        extraHeartRecipe.setIngredient('S', severedMobHeart());
        customItems.add(extraHeart);
        basicItems.add(extraHeart);
        shapedRecipes.put(extraHeart, extraHeartRecipe);
        Bukkit.addRecipe(extraHeartRecipe);

        ItemStack shulker = new ItemStack(Material.SHULKER_BOX);
        ShapedRecipe shulkerRecipe = new ShapedRecipe(new NamespacedKey(lifestealSmp, "shulker_recipe"), shulker);
        shulkerRecipe.shape("DDD", "DCD", "DDD");
        shulkerRecipe.setIngredient('C', Material.CHEST);
        shulkerRecipe.setIngredient('D', Material.DIAMOND);
        customItems.add(shulker);
        basicItems.add(shulker);
        shapedRecipes.put(shulker, shulkerRecipe);
        Bukkit.addRecipe(shulkerRecipe);

        ItemStack endStone = new ItemStack(Material.END_STONE);
        ShapedRecipe endStoneRecipe = new ShapedRecipe(new NamespacedKey(lifestealSmp, "end_stone_recipe"), endStone);
        endStoneRecipe.shape("DNE");
        endStoneRecipe.setIngredient('D', Material.DIRT);
        endStoneRecipe.setIngredient('N', Material.NETHERRACK);
        endStoneRecipe.setIngredient('E', Material.COBBLESTONE);
        customItems.add(endStone);
        basicItems.add(endStone);
        shapedRecipes.put(endStone, endStoneRecipe);
        Bukkit.addRecipe(endStoneRecipe);

        ItemStack purpleBlock = new ItemStack(Material.PURPUR_BLOCK);
        ShapedRecipe purpleBlockRecipe = new ShapedRecipe(new NamespacedKey(lifestealSmp, "purple_block_recipe"), purpleBlock);
        purpleBlockRecipe.shape("NS");
        purpleBlockRecipe.setIngredient('N', Material.NETHER_BRICKS);
        purpleBlockRecipe.setIngredient('S', Material.STONE_BRICKS);
        customItems.add(purpleBlock);
        basicItems.add(purpleBlock);
        shapedRecipes.put(purpleBlock, purpleBlockRecipe);
        Bukkit.addRecipe(purpleBlockRecipe);

        NamespacedKey nethScraps = new NamespacedKey(lifestealSmp, "neth_scraps");
        ShapelessRecipe nethScrapsRecipe = new ShapelessRecipe(nethScraps, createNethScarps());
        nethScrapsRecipe.addIngredient(1, Material.NETHERITE_INGOT);
        customItems.add(createNethScarps());
        basicItems.add(createNethScarps());
        shapelessRecipes.put(createNethScarps(), nethScrapsRecipe);
        Bukkit.addRecipe(nethScrapsRecipe);

        NamespacedKey reviveBeacon = new NamespacedKey(lifestealSmp, "revive_beacon");
        ShapelessRecipe reviveBeaconRecipe = new ShapelessRecipe(reviveBeacon, createReviveBeacon());
        reviveBeaconRecipe.addIngredient(1, Material.BEACON);
        reviveBeaconRecipe.addIngredient(4, Material.DIAMOND_BLOCK);
        reviveBeaconRecipe.addIngredient(1, Material.NETHERITE_BLOCK);
        reviveBeaconRecipe.addIngredient(2, Material.TOTEM_OF_UNDYING);
        reviveBeaconRecipe.addIngredient(1, Material.GOLDEN_APPLE);
        customItems.add(createReviveBeacon());
        basicItems.add(createReviveBeacon());
        shapelessRecipes.put(createReviveBeacon(), reviveBeaconRecipe);
        Bukkit.addRecipe(reviveBeaconRecipe);
    }

    public static void registerCustomRecipes() {
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
        featherSwordRecipe.addIngredient(1, Material.NETHERITE_SWORD);
        featherSwordRecipe.addIngredient(2, Material.TOTEM_OF_UNDYING);
        featherSwordRecipe.addIngredient(2, Material.NETHER_STAR);
        customItems.add(createFeatherSword());
        shapelessRecipes.put(createFeatherSword(), featherSwordRecipe);
        Bukkit.addRecipe(featherSwordRecipe);

        NamespacedKey tropChopAxe = new NamespacedKey(lifestealSmp, "trop_chop_axe");
        ShapelessRecipe tropChopAxeRecipe = new ShapelessRecipe(tropChopAxe, createCustomAxe());
        tropChopAxeRecipe.addIngredient(1, Material.STICK);
        tropChopAxeRecipe.addIngredient(1, Material.NETHERITE_INGOT);
        tropChopAxeRecipe.addIngredient(2, Material.NETHERITE_AXE);
        customItems.add(createCustomAxe());
        shapelessRecipes.put(createCustomAxe(), tropChopAxeRecipe);
        Bukkit.addRecipe(tropChopAxeRecipe);

        NamespacedKey opPickaxe = new NamespacedKey(lifestealSmp, "op_pickaxe");
        ShapelessRecipe opPickaxeRecipe = new ShapelessRecipe(opPickaxe, createOpPickaxe());
        opPickaxeRecipe.addIngredient(2, Material.DIAMOND_BLOCK);
        opPickaxeRecipe.addIngredient(1, Material.GOLD_BLOCK);
        opPickaxeRecipe.addIngredient(5, Material.NETHERITE_INGOT);
        opPickaxeRecipe.addIngredient(1, Material.NETHERITE_PICKAXE);
        customItems.add(createOpPickaxe());
        shapelessRecipes.put(createOpPickaxe(), opPickaxeRecipe);
        Bukkit.addRecipe(opPickaxeRecipe);

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

        ItemStack lightFeather = new ItemStack(lightFeather());
        ShapedRecipe lightFeatherRecipe = new ShapedRecipe(new NamespacedKey(lifestealSmp, "light_feather"), lightFeather);
        lightFeatherRecipe.shape("FSF", "SFS", "FSF");
        lightFeatherRecipe.setIngredient('F', Material.FEATHER);
        lightFeatherRecipe.setIngredient('S', Material.SUGAR);
        customItems.add(lightFeather);
        shapedRecipes.put(lightFeather, lightFeatherRecipe);
        Bukkit.addRecipe(lightFeatherRecipe);

        ItemStack instaboomTNT = new ItemStack(InstaBoomTNT());
        ShapedRecipe instaboomTNTRecipe = new ShapedRecipe(new NamespacedKey(lifestealSmp, "instaboom_tnt"), instaboomTNT);
        instaboomTNTRecipe.shape("TDT", "TET", "TTT");
        instaboomTNTRecipe.setIngredient('T', Material.TNT);
        instaboomTNTRecipe.setIngredient('E', Material.END_CRYSTAL);
        instaboomTNTRecipe.setIngredient('D', Material.DIAMOND);
        customItems.add(instaboomTNT);
        shapedRecipes.put(instaboomTNT, instaboomTNTRecipe);
        Bukkit.addRecipe(instaboomTNTRecipe);

        ItemStack lifestealSword = new ItemStack(lifestealStick());
        ShapedRecipe lifestealSwordRecipe = new ShapedRecipe(new NamespacedKey(lifestealSmp, "lifesteal_sword"), lifestealSword);
        lifestealSwordRecipe.shape("WHW", "WFW", "NSN");
        lifestealSwordRecipe.setIngredient('H', extraHeart());
        lifestealSwordRecipe.setIngredient('F', heavyNetherStar());
        lifestealSwordRecipe.setIngredient('S', powerStick());
        lifestealSwordRecipe.setIngredient('N', Material.NETHERITE_INGOT);
        lifestealSwordRecipe.setIngredient('W', Material.WITHER_SKELETON_SKULL);
        customItems.add(lifestealSword);
        shapedRecipes.put(lifestealSword, lifestealSwordRecipe);
        Bukkit.addRecipe(lifestealSwordRecipe);

        ItemStack heavyNetherStar = new ItemStack(heavyNetherStar());
        ShapedRecipe heavyNetherStarRecipe = new ShapedRecipe(new NamespacedKey(lifestealSmp, "heavy_nether_star"), heavyNetherStar);
        heavyNetherStarRecipe.shape("NNN", "NSN", "NNN");
        heavyNetherStarRecipe.setIngredient('N', Material.NETHER_STAR);
        heavyNetherStarRecipe.setIngredient('S', Material.NETHERITE_SCRAP);
        customItems.add(heavyNetherStar);
        shapedRecipes.put(heavyNetherStar, heavyNetherStarRecipe);
        Bukkit.addRecipe(heavyNetherStarRecipe);

        ItemStack musicBox = new ItemStack(musicBox());
        ShapedRecipe musicBoxRecipe = new ShapedRecipe(new NamespacedKey(lifestealSmp, "music_box"), musicBox);
        musicBoxRecipe.shape("FPF", "DJD", "FOF");
        musicBoxRecipe.setIngredient('P', Material.MUSIC_DISC_PIGSTEP);
        musicBoxRecipe.setIngredient('O', Material.MUSIC_DISC_OTHERSIDE);
        musicBoxRecipe.setIngredient('F', Material.DISC_FRAGMENT_5);
        musicBoxRecipe.setIngredient('D', Material.DIAMOND);
        musicBoxRecipe.setIngredient('J', Material.JUKEBOX);
        customItems.add(musicBox);
        shapedRecipes.put(musicBox, musicBoxRecipe);
        Bukkit.addRecipe(musicBoxRecipe);

        ItemStack somberCrystal = somberCrystal();
        ShapedRecipe somberCrystalRecipe = new ShapedRecipe(new NamespacedKey(lifestealSmp, "somber_crystal"), somberCrystal);
        somberCrystalRecipe.shape("NNN", "NED", "DDD");
        somberCrystalRecipe.setIngredient('D', Material.DIAMOND_BLOCK);
        somberCrystalRecipe.setIngredient('E', Material.ECHO_SHARD);
        somberCrystalRecipe.setIngredient('N', Material.NETHER_STAR);
        Bukkit.addRecipe(somberCrystalRecipe);
        customItems.add(somberCrystal);
        shapedRecipes.put(somberCrystal, somberCrystalRecipe);

        ItemStack heartEqualizer = createHeartEqualizer();
        ShapedRecipe heartEqualizerRecipe = new ShapedRecipe(new NamespacedKey(lifestealSmp, "heart_equalizer"), heartEqualizer);
        heartEqualizerRecipe.shape("NNN", "DED", "DID");
        heartEqualizerRecipe.setIngredient('D', Material.DIAMOND_BLOCK);
        heartEqualizerRecipe.setIngredient('E', Material.HEART_OF_THE_SEA);
        heartEqualizerRecipe.setIngredient('N', Material.NETHER_STAR);
        heartEqualizerRecipe.setIngredient('I', Material.NETHERITE_INGOT);
        Bukkit.addRecipe(heartEqualizerRecipe);
        customItems.add(heartEqualizer);
        shapedRecipes.put(heartEqualizer, heartEqualizerRecipe);

        ItemStack runePouch = createRunePouch();
        ShapedRecipe runePouchRecipe = new ShapedRecipe(new NamespacedKey(lifestealSmp, "rune_pouch"), runePouch);
        runePouchRecipe.shape("NNN", "DED", "DID");
        runePouchRecipe.setIngredient('D', Material.DIAMOND);
        runePouchRecipe.setIngredient('E', Material.GOLDEN_APPLE);
        runePouchRecipe.setIngredient('N', Material.SHULKER_BOX);
        runePouchRecipe.setIngredient('I', Material.NETHERITE_INGOT);
        Bukkit.addRecipe(runePouchRecipe);
        customItems.add(runePouch);
        shapedRecipes.put(runePouch, runePouchRecipe);

        //addRecipes();
    }
}
