package newamazingpvp.lifestealsmp.customitems.utils;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.ShapedRecipe;

import static newamazingpvp.lifestealsmp.LifestealSMP.lifestealSmp;
import static newamazingpvp.lifestealsmp.customitems.utils.ItemStacks.*;
import static newamazingpvp.lifestealsmp.customitems.utils.ItemStacks.somberCrystal;

public class DevRecipes {
    public static void registerCustomRecipesDev() {
        ItemStack lightFeather = new ItemStack(lightFeather());
        ShapedRecipe lightFeatherRecipe = new ShapedRecipe(new NamespacedKey(lifestealSmp, "lightFeather"), lightFeather);
        lightFeatherRecipe.shape("FSF", "SFS", "FSF");
        lightFeatherRecipe.setIngredient('F', Material.FEATHER);
        lightFeatherRecipe.setIngredient('S', Material.SUGAR);
        Bukkit.addRecipe(lightFeatherRecipe);

        ItemStack instaboomTNT = new ItemStack(InstaBoomTNT());
        ShapedRecipe instaboomTNTRecipe = new ShapedRecipe(new NamespacedKey(lifestealSmp, "instaboomTNT"), instaboomTNT);
        instaboomTNTRecipe.shape("TDT", "TET", "TTT");
        instaboomTNTRecipe.setIngredient('T', Material.TNT);
        instaboomTNTRecipe.setIngredient('E', Material.END_CRYSTAL);
        instaboomTNTRecipe.setIngredient('D', Material.DIAMOND);

        //customItems.add(instaboomTNT);
        //shapedRecipes.put(instaboomTNT, instaboomTNTRecipe);
        Bukkit.addRecipe(instaboomTNTRecipe);

        ItemStack LifestealSword = new ItemStack(LifestealStick());
        ShapedRecipe LifestealSwordRecipe = new ShapedRecipe(new NamespacedKey(lifestealSmp, "LifestealSword"), LifestealSword);
        LifestealSwordRecipe.shape("WHW", "WFW", "NSN");
        LifestealSwordRecipe.setIngredient('H', extraHeart());
        LifestealSwordRecipe.setIngredient('F', heavyNetherStar());
        LifestealSwordRecipe.setIngredient('S', powerStick());
        LifestealSwordRecipe.setIngredient('N', Material.NETHERITE_INGOT);
        LifestealSwordRecipe.setIngredient('W', Material.WITHER_SKELETON_SKULL);
        Bukkit.addRecipe(LifestealSwordRecipe);

        ItemStack heavyNetherStar = new ItemStack(heavyNetherStar());
        ShapedRecipe heavyNetherStarRecipe = new ShapedRecipe(new NamespacedKey(lifestealSmp, "heavyNetherStar"), heavyNetherStar);
        heavyNetherStarRecipe.shape("NNN", "NSN", "NNN");
        heavyNetherStarRecipe.setIngredient('N', Material.NETHER_STAR);
        heavyNetherStarRecipe.setIngredient('S', Material.NETHERITE_SCRAP);
        Bukkit.addRecipe(heavyNetherStarRecipe);


        ItemStack musicBox = new ItemStack(musicBox());
        ShapedRecipe musicBoxRecipe = new ShapedRecipe(new NamespacedKey(lifestealSmp, "musicBox"), musicBox);
        musicBoxRecipe.shape("FPF", "DJD", "FOF");
        musicBoxRecipe.setIngredient('P', Material.MUSIC_DISC_PIGSTEP);
        musicBoxRecipe.setIngredient('O', Material.MUSIC_DISC_OTHERSIDE);
        musicBoxRecipe.setIngredient('F', Material.DISC_FRAGMENT_5);
        musicBoxRecipe.setIngredient('D', Material.DIAMOND);
        musicBoxRecipe.setIngredient('J', Material.JUKEBOX);
        Bukkit.addRecipe(musicBoxRecipe);

        ItemStack somberCrystal = new ItemStack(somberCrystal());
        ShapedRecipe somberCrystalRecipe = new ShapedRecipe(new NamespacedKey(lifestealSmp, "somberCrystal"), somberCrystal);
        somberCrystalRecipe.shape("NNN", "NED", "DDD");
        somberCrystalRecipe.setIngredient('D', Material.DIAMOND_BLOCK);
        somberCrystalRecipe.setIngredient('E', Material.ECHO_SHARD);
        somberCrystalRecipe.setIngredient('N', Material.NETHER_STAR);
        Bukkit.addRecipe(somberCrystalRecipe);


    }
}
