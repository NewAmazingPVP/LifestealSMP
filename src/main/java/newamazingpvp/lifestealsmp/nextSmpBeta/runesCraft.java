package newamazingpvp.lifestealsmp.nextSmpBeta;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.CraftItemEvent;
import org.bukkit.event.inventory.PrepareAnvilEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.ShapelessRecipe;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.Collections;

import static newamazingpvp.lifestealsmp.LifestealSMP.lifestealSmp;
import static newamazingpvp.lifestealsmp.nextSmpBeta.runesDrops.witherRune;

public class runesCraft implements Listener{

    public static void registerCustomRecipesRunes() {

        NamespacedKey opPickaxe = new NamespacedKey(lifestealSmp, "op_pickaxe");
        ShapelessRecipe opPickaxeRecipe = new ShapelessRecipe(opPickaxe, witherRune());
        opPickaxeRecipe.addIngredient(2, Material.DIAMOND_BLOCK);
        opPickaxeRecipe.addIngredient(1, Material.GOLD_BLOCK);
        opPickaxeRecipe.addIngredient(5, Material.NETHERITE_INGOT);
        opPickaxeRecipe.addIngredient(1, Material.DIAMOND_PICKAXE);
        Bukkit.addRecipe(opPickaxeRecipe);

    }

    @EventHandler
    public void onCraft(CraftItemEvent event) {
        ItemStack result = event.getRecipe().getResult();
        if (isSwordOrTool(result)) {
            ItemMeta meta = result.getItemMeta();
            if (meta.hasLore()) {
                meta.getLore().add("lololol");
            } else {
                meta.setLore(Collections.singletonList("lololol"));
            }
            result.setItemMeta(meta);
            event.setCurrentItem(result);
        }
    }

    private boolean isSwordOrTool(ItemStack item) {
        Material type = item.getType();
        return type.name().endsWith("_SWORD") || type.name().endsWith("_AXE") || type.name().endsWith("_PICKAXE");
    }


}

