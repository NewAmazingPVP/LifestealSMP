package newamazingpvp.lifestealsmp.customitems.utils;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.ShapedRecipe;
import org.bukkit.inventory.ShapelessRecipe;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static newamazingpvp.lifestealsmp.LifestealSMP.lifestealSmp;

public class GUI {
    public static final Map<ItemStack, ShapedRecipe> shapedRecipes = new HashMap<>();
    public static final Map<ItemStack, ShapelessRecipe> shapelessRecipes = new HashMap<>();
    public static final List<ItemStack> customItems = new ArrayList<>();

    public static void openRecipesGUI(Player player) {
        Inventory gui = Bukkit.createInventory(null, 27, ChatColor.GOLD + "Custom Recipes");

        for (int i = 0; i < customItems.size(); i++) {
            gui.setItem(i, customItems.get(i));
        }

        player.openInventory(gui);
        Bukkit.getScheduler().runTaskLater(lifestealSmp, () -> player.playSound(player.getLocation(), Sound.BLOCK_NOTE_BLOCK_PLING, 1.0f, 0.0f), 3);
    }

    public static void openRecipeDetailGUI(Player player, ItemStack item) {
        String name = item.getItemMeta().getDisplayName();
        if (name.isEmpty()) {
            name = item.getDisplayName();
        }
        if (name.isEmpty()) {
            name = item.getType().name();
        }
        Inventory gui = Bukkit.createInventory(null, 27, ChatColor.GOLD + "Recipe for " + name);

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
                    ItemStack ingredient = getIngredientItem(ingredients.get(ingredientChar));
                    gui.setItem(slots[slotIndex], ingredient);
                    slotIndex++;
                }
            }
            ItemStack recipeType = new ItemStack(Material.RED_STAINED_GLASS_PANE);
            ItemMeta meta = recipeType.getItemMeta();
            meta.setDisplayName(ChatColor.RED + "This is a shaped recipe");
            recipeType.setItemMeta(meta);
            gui.setItem(4, recipeType);

        } else if (shapelessRecipes.containsKey(item)) {
            ShapelessRecipe recipe = shapelessRecipes.get(item);
            List<ItemStack> ingredients = recipe.getIngredientList();

            for (ItemStack ingredient : ingredients) {
                if (slotIndex >= slots.length) {
                    break;
                }
                ItemStack ingredientItem = getIngredientItem(ingredient);
                gui.setItem(slots[slotIndex], ingredientItem);
                slotIndex++;
            }
            ItemStack recipeType = new ItemStack(Material.GREEN_STAINED_GLASS_PANE);
            ItemMeta meta = recipeType.getItemMeta();
            meta.setDisplayName(ChatColor.GREEN + "This is a shapeless recipe");
            recipeType.setItemMeta(meta);
            gui.setItem(4, recipeType);
        }

        ItemStack backButton = new ItemStack(Material.BARRIER);
        ItemMeta backMeta = backButton.getItemMeta();
        backMeta.setDisplayName(ChatColor.YELLOW + "Back Button");
        backButton.setItemMeta(backMeta);
        gui.setItem(26, backButton);
        gui.setItem(13, item);

        player.openInventory(gui);
        Bukkit.getScheduler().runTaskLater(lifestealSmp, () -> player.playSound(player.getLocation(), Sound.BLOCK_NOTE_BLOCK_PLING, 1.0f, 0.0f), 3);
    }

    private static ItemStack getIngredientItem(ItemStack item) {
        if (item == null) {
            return new ItemStack(Material.AIR);
        }
        return item.clone();
    }
}
