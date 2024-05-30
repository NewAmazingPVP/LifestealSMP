package newamazingpvp.lifestealsmp.MinecraftBINGO;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.ShapedRecipe;

import static newamazingpvp.lifestealsmp.LifestealSMP.lifestealSmp;
import static newamazingpvp.lifestealsmp.MinecraftBINGO.customBingoItems.BingoCard;
import static newamazingpvp.lifestealsmp.MinecraftBINGO.customBingoItems.BingoPickaxe;

public class BingoRecipes {

    public static void registerBingoRecipes(){

        ItemStack bingoPic = new ItemStack(BingoPickaxe());
        ShapedRecipe bingoPicRecipe = new ShapedRecipe(new NamespacedKey(lifestealSmp, "bingo_pic"), bingoPic);
        bingoPicRecipe.shape("CCC", "ASA", "ASA");
        bingoPicRecipe.setIngredient('S', Material.STICK);
        bingoPicRecipe.setIngredient('A', Material.AIR);
        bingoPicRecipe.setIngredient('C', Material.COPPER_BLOCK);
        Bukkit.addRecipe(bingoPicRecipe);


        ItemStack bingoCard = new ItemStack(BingoCard());
        ShapedRecipe bingoCardR = new ShapedRecipe(new NamespacedKey(lifestealSmp, "bingo_card"), bingoCard);
        bingoCardR.shape("OOO", "OOO", "OOO");
        bingoCardR.setIngredient('O', Material.OAK_PLANKS);
        Bukkit.addRecipe(bingoCardR);



    }


}
