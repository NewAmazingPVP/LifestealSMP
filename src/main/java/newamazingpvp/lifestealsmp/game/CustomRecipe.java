package newamazingpvp.lifestealsmp.game;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.attribute.Attribute;
import org.bukkit.attribute.AttributeModifier;
import org.bukkit.inventory.*;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import static newamazingpvp.lifestealsmp.LifestealSMP.lifestealSmp;

public class CustomRecipe {
    public static void registerCustomRecipes() {
        ItemStack shulker = new ItemStack(Material.SHULKER_BOX);
        ShapedRecipe shulkerRecipe = new ShapedRecipe(new NamespacedKey(lifestealSmp, "shulker_recipe"), shulker);
        shulkerRecipe.shape("DDD", "DCD", "DDD");
        shulkerRecipe.setIngredient('C', Material.CHEST);
        shulkerRecipe.setIngredient('D', Material.DIAMOND);
        Bukkit.addRecipe(shulkerRecipe);

        ItemStack endStone = new ItemStack(Material.END_STONE);
        ShapedRecipe endStoneRecipe = new ShapedRecipe(new NamespacedKey(lifestealSmp, "end_stone_recipe"), endStone);
        endStoneRecipe.shape("DNE");
        endStoneRecipe.setIngredient('D', Material.DIRT);
        endStoneRecipe.setIngredient('N', Material.NETHERRACK);
        endStoneRecipe.setIngredient('E', Material.COBBLESTONE);
        Bukkit.addRecipe(endStoneRecipe);

        ItemStack purpleBlock = new ItemStack(Material.PURPUR_BLOCK);
        ShapedRecipe purpleBlockRecipe = new ShapedRecipe(new NamespacedKey(lifestealSmp, "purple_block_recipe"), purpleBlock);
        purpleBlockRecipe.shape("NS");
        purpleBlockRecipe.setIngredient('N', Material.NETHER_BRICKS);
        purpleBlockRecipe.setIngredient('S', Material.STONE_BRICKS);
        Bukkit.addRecipe(purpleBlockRecipe);

        NamespacedKey recipeKey = new NamespacedKey(lifestealSmp, "teleporting_bow");
        ShapelessRecipe customBowRecipe = new ShapelessRecipe(recipeKey, createCustomBow());
        customBowRecipe.addIngredient(1, Material.ENDER_PEARL);
        customBowRecipe.addIngredient(1, Material.NETHERITE_BLOCK);
        customBowRecipe.addIngredient(1, Material.BOW);
        Bukkit.addRecipe(customBowRecipe);

        NamespacedKey tntBow = new NamespacedKey(lifestealSmp, "tnt_bow");
        ShapelessRecipe tntBowRecipe = new ShapelessRecipe(tntBow, createTNTBow());
        customBowRecipe.addIngredient(1, Material.TNT);
        customBowRecipe.addIngredient(1, Material.NETHERITE_BLOCK);
        customBowRecipe.addIngredient(1, Material.BOW);
        Bukkit.addRecipe(tntBowRecipe);

        NamespacedKey featherSword = new NamespacedKey(lifestealSmp, "tnt_bow");
        ShapelessRecipe featherSwordRecipe = new ShapelessRecipe(featherSword, createFeatherSword());
        customBowRecipe.addIngredient(1, Material.FEATHER);
        customBowRecipe.addIngredient(1, Material.NETHERITE_BLOCK);
        customBowRecipe.addIngredient(1, Material.DIAMOND_SWORD);
        Bukkit.addRecipe(featherSwordRecipe);
    }

    private static ItemStack createCustomBow() {
        ItemStack customBow = new ItemStack(Material.BOW);

        ItemMeta meta = customBow.getItemMeta();
        //meta.setDisplayName(ChatColor.LIGHT_PURPLE + "Teleporting Bow");
        meta.setDisplayName(ChatColor.MAGIC + "Teleporting Bow");
        List<String> DEFL = new ArrayList<>();
        DEFL.add(ChatColor.GOLD + "Special Ability: " + ChatColor.DARK_PURPLE + "Shoot to teleport!");
        meta.setLore(DEFL);
        meta.addItemFlags(ItemFlag.HIDE_ITEM_SPECIFICS);
        meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);

        customBow.setItemMeta(meta);

        return customBow;
    }

    private static ItemStack createTNTBow() {
        ItemStack customBow = new ItemStack(Material.BOW);

        ItemMeta meta = customBow.getItemMeta();
        //meta.setDisplayName(ChatColor.LIGHT_PURPLE + "Teleporting Bow");
        meta.setDisplayName(ChatColor.GOLD + "TNT Bow");
        List<String> DEFL = new ArrayList<>();
        DEFL.add(ChatColor.GOLD + "Special Ability: " + ChatColor.DARK_PURPLE + "TNT Shooter!");
        meta.setLore(DEFL);
        meta.addItemFlags(ItemFlag.HIDE_ITEM_SPECIFICS);
        meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);

        customBow.setItemMeta(meta);

        return customBow;
    }

    private static ItemStack createFeatherSword() {
        ItemStack customBow = new ItemStack(Material.DIAMOND_SWORD);

        ItemMeta meta = customBow.getItemMeta();
        meta.setDisplayName(ChatColor.AQUA + "Feather Sword");
        List<String> DEFL = new ArrayList<>();
        DEFL.add(ChatColor.GOLD + "Special Ability: " + ChatColor.DARK_PURPLE + "Right click to launch yourself");
        DEFL.add(ChatColor.LIGHT_PURPLE + "Permanent speed 2 while holding");
        meta.setLore(DEFL);
        //meta.addItemFlags(ItemFlag.HIDE_ITEM_SPECIFICS);
        AttributeModifier attackDamageModifier = new AttributeModifier(
                UUID.randomUUID(),
                "generic.attackDamage",
                6,
                AttributeModifier.Operation.ADD_NUMBER,
                EquipmentSlot.HAND
        );
        meta.addAttributeModifier(Attribute.GENERIC_ATTACK_DAMAGE, attackDamageModifier);

        customBow.setItemMeta(meta);

        return customBow;
    }
}
