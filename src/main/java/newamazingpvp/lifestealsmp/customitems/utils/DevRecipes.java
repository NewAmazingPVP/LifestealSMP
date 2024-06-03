package newamazingpvp.lifestealsmp.customitems.utils;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.ShapedRecipe;

import static newamazingpvp.lifestealsmp.LifestealSMP.lifestealSmp;
import static newamazingpvp.lifestealsmp.customitems.utils.ItemStacks.*;
import static newamazingpvp.lifestealsmp.customitems.utils.ItemStacks.powerStick;

public class DevRecipes {
    public static void registerCustomRecipesDev(){
        ItemStack lightFeather = new ItemStack(lightFeather());
        ShapedRecipe lightFeatherRecipe = new ShapedRecipe(new NamespacedKey(lifestealSmp, "lightFeather"), lightFeather);
        lightFeatherRecipe.shape("FSF","SFS","FSF");
        lightFeatherRecipe.setIngredient('F', Material.FEATHER);
        lightFeatherRecipe.setIngredient('S', Material.SUGAR);
        Bukkit.addRecipe(lightFeatherRecipe);

        ItemStack instaboomTNT = new ItemStack(InstaBoomTNT());
        ShapedRecipe instaboomTNTRecipe = new ShapedRecipe(new NamespacedKey(lifestealSmp, "instaboomTNT"), instaboomTNT);
        instaboomTNTRecipe.shape("TDT","TET","TTT");
        instaboomTNTRecipe.setIngredient('T', Material.TNT);
        instaboomTNTRecipe.setIngredient('D', Material.DIAMOND);
        instaboomTNTRecipe.setIngredient('E', Material.ECHO_SHARD);
        //customItems.add(instaboomTNT);
        //shapedRecipes.put(instaboomTNT, instaboomTNTRecipe);
        Bukkit.addRecipe(instaboomTNTRecipe);

        ItemStack LifestealSword = new ItemStack(LifestealSword());
        ShapedRecipe LifestealSwordRecipe = new ShapedRecipe(new NamespacedKey(lifestealSmp, "LifestealSword"), LifestealSword);
        LifestealSwordRecipe.shape("WHW","WFW","DSN");
        LifestealSwordRecipe.setIngredient('H', extraHeart());
        LifestealSwordRecipe.setIngredient('F', createFeatherSword());
        LifestealSwordRecipe.setIngredient('S', powerStick());
        LifestealSwordRecipe.setIngredient('N', Material.NETHERITE_BLOCK);
        LifestealSwordRecipe.setIngredient('D', Material.DIAMOND_BLOCK);
        LifestealSwordRecipe.setIngredient('W', Material.WITHER_SKELETON_SKULL);
        Bukkit.addRecipe(LifestealSwordRecipe);



    }
}
