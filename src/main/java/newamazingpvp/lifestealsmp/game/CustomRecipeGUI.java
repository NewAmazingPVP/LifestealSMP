package newamazingpvp.lifestealsmp.game;

import org.bukkit.*;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.inventory.*;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.LeatherArmorMeta;
import org.bukkit.inventory.meta.SkullMeta;
import org.bukkit.profile.PlayerProfile;
import org.bukkit.profile.PlayerTextures;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.*;

import static newamazingpvp.lifestealsmp.LifestealSMP.lifestealSmp;

public class CustomRecipeGUI {
    public static final Map<ItemStack, ShapedRecipe> shapedRecipes = new HashMap<>();
    public static final Map<ItemStack, ShapelessRecipe> shapelessRecipes = new HashMap<>();

    public static final List<ItemStack> customItems = new ArrayList<>();
    public static void openRecipesGUI(Player player) {
        Inventory gui = Bukkit.createInventory(null, 27, ChatColor.GOLD + "Custom Recipes");

        for (int i = 0; i < customItems.size() && i < 45; i++) {
            gui.setItem(i, customItems.get(i));
        }

        player.openInventory(gui);
        Bukkit.getScheduler().runTaskLater(lifestealSmp, () -> player.playSound(player.getLocation(), Sound.BLOCK_NOTE_BLOCK_PLING, 1.0f, 0.0f), 3);
    }
    public static void openRecipeDetailGUI(Player player, ItemStack item) {
        Inventory gui = Bukkit.createInventory(null, 27, ChatColor.GOLD + "Recipe for " + item.getItemMeta().getDisplayName());

        int[] slots = {0, 1, 2, 9, 10, 11, 18, 19, 20};
        int slotIndex = 0;

        if (shapedRecipes.containsKey(item)) {
            ShapedRecipe recipe = shapedRecipes.get(item);
            String[] shape = recipe.getShape();
            Map<Character, ItemStack> ingredients = recipe.getIngredientMap();

            for (int row = 0; row < shape.length; row++) {
                String rowShape = shape[row];
                for (int col = 0; col < rowShape.length(); col++) {
                    if (slotIndex >= slots.length) {
                        break;
                    }
                    char ingredientChar = rowShape.charAt(col);
                    ItemStack ingredient = ingredients.get(ingredientChar);
                    if (ingredient != null) {
                        gui.setItem(slots[slotIndex], ingredient);
                    }
                    slotIndex++;
                }
            }
            ItemStack recipeType = new ItemStack(Material.RED_STAINED_GLASS_PANE);
            recipeType.setDisplayName(ChatColor.RED + "This is a shaped recipe");
            gui.setItem(4, recipeType);

        } else if (shapelessRecipes.containsKey(item)) {
            ShapelessRecipe recipe = shapelessRecipes.get(item);
            List<ItemStack> ingredients = recipe.getIngredientList();

            for (int i = 0; i < ingredients.size(); i++) {
                if (slotIndex >= slots.length) {
                    break;
                }
                ItemStack ingredient = ingredients.get(i);
                if (ingredient != null) {
                    gui.setItem(slots[slotIndex], ingredient);
                }
                slotIndex++;
            }
            ItemStack recipeType = new ItemStack(Material.GREEN_STAINED_GLASS_PANE);
            recipeType.setDisplayName(ChatColor.GREEN + "This is a shapeless recipe");
            gui.setItem(4, recipeType);

        }
        ItemStack backButton = new ItemStack(Material.BARRIER);
        backButton.setDisplayName(ChatColor.YELLOW + "Back Button");
        gui.setItem(26, backButton);
        gui.setItem(13, item);

        player.openInventory(gui);
        Bukkit.getScheduler().runTaskLater(lifestealSmp, () -> player.playSound(player.getLocation(), Sound.BLOCK_NOTE_BLOCK_PLING, 1.0f, 0.0f), 3);
    }



    public static ItemStack createNethScarps() {
        ItemStack customBow = new ItemStack(Material.NETHERITE_SCRAP, 4);
        return customBow;
    }





}
