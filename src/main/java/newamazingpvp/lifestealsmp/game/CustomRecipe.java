package newamazingpvp.lifestealsmp.game;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.*;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;
import java.util.List;

import static newamazingpvp.lifestealsmp.LifestealSMP.lifestealSmp;

public class CustomRecipe {
    public static void registerCustomRecipes() {

        ItemStack extraHeart = new ItemStack(extraHeart());
        ShapedRecipe extraHeartRecipe = new ShapedRecipe(new NamespacedKey(lifestealSmp, "extra_heart"), extraHeart);
        extraHeartRecipe.shape("CXC", "DSD", "XNX");
        extraHeartRecipe.setIngredient('D', Material.DIAMOND_BLOCK);
        extraHeartRecipe.setIngredient('N', Material.NETHERITE_INGOT);
        extraHeartRecipe.setIngredient('C', corruptedMobSoul());
        extraHeartRecipe.setIngredient('S', severedMobHeart());
        extraHeartRecipe.setIngredient('X', Material.AIR);
        Bukkit.addRecipe(extraHeartRecipe);

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
        customBowRecipe.addIngredient(1, Material.NETHERITE_INGOT);
        customBowRecipe.addIngredient(1, Material.BOW);
        Bukkit.addRecipe(customBowRecipe);

        NamespacedKey tntBow = new NamespacedKey(lifestealSmp, "tnt_bow");
        ShapelessRecipe tntBowRecipe = new ShapelessRecipe(tntBow, createTNTBow());
        tntBowRecipe.addIngredient(1, Material.TNT);
        tntBowRecipe.addIngredient(1, Material.NETHERITE_INGOT);
        tntBowRecipe.addIngredient(1, Material.BOW);
        Bukkit.addRecipe(tntBowRecipe);

        NamespacedKey featherSword = new NamespacedKey(lifestealSmp, "feather_sword");
        ShapelessRecipe featherSwordRecipe = new ShapelessRecipe(featherSword, createFeatherSword());
        featherSwordRecipe.addIngredient(1, Material.FEATHER);
        featherSwordRecipe.addIngredient(1, Material.NETHERITE_INGOT);
        featherSwordRecipe.addIngredient(1, Material.DIAMOND_SWORD);
        featherSwordRecipe.addIngredient(1, Material.GOLD_BLOCK);
        featherSwordRecipe.addIngredient(1, Material.IRON_BLOCK);
        featherSwordRecipe.addIngredient(1, Material.DIAMOND_BLOCK);
        Bukkit.addRecipe(featherSwordRecipe);

        NamespacedKey tropChopAxe = new NamespacedKey(lifestealSmp, "trop_chop_axe");
        ShapelessRecipe tropChopAxeRecipe = new ShapelessRecipe(tropChopAxe, createCustomAxe());
        tropChopAxeRecipe.addIngredient(1, Material.TNT);
        tropChopAxeRecipe.addIngredient(1, Material.DIAMOND_BLOCK);
        tropChopAxeRecipe.addIngredient(1, Material.GOLD_BLOCK);
        tropChopAxeRecipe.addIngredient(1, Material.IRON_BLOCK);
        tropChopAxeRecipe.addIngredient(1, Material.NETHERITE_INGOT);
        tropChopAxeRecipe.addIngredient(1, Material.DIAMOND_AXE);
        Bukkit.addRecipe(tropChopAxeRecipe);

        NamespacedKey opPickaxe = new NamespacedKey(lifestealSmp, "op_pickaxe");
        ShapelessRecipe opPickaxeRecipe = new ShapelessRecipe(opPickaxe, createOpPickaxe());
        opPickaxeRecipe.addIngredient(1, Material.TNT);
        opPickaxeRecipe.addIngredient(1, Material.DIAMOND_BLOCK);
        opPickaxeRecipe.addIngredient(1, Material.GOLD_BLOCK);
        opPickaxeRecipe.addIngredient(1, Material.IRON_BLOCK);
        opPickaxeRecipe.addIngredient(1, Material.NETHERITE_INGOT);
        opPickaxeRecipe.addIngredient(1, Material.DIAMOND_PICKAXE);
        Bukkit.addRecipe(opPickaxeRecipe);

        NamespacedKey nethScraps = new NamespacedKey(lifestealSmp, "neth_scraps");
        ShapelessRecipe nethScrapsRecipe = new ShapelessRecipe(nethScraps, createNethScarps());
        nethScrapsRecipe.addIngredient(1, Material.NETHERITE_INGOT);
        Bukkit.addRecipe(nethScrapsRecipe);

        NamespacedKey diamondHorse = new NamespacedKey(lifestealSmp, "horse_armor_diamond");
        ItemStack horseArmor = new ItemStack(Material.DIAMOND_HORSE_ARMOR, 2);
        ShapelessRecipe diamondHorseArmor = new ShapelessRecipe(diamondHorse, horseArmor);
        diamondHorseArmor.addIngredient(7, Material.DIAMOND);
        diamondHorseArmor.addIngredient(1, Material.LEATHER_HORSE_ARMOR);
        Bukkit.addRecipe(diamondHorseArmor);

        // Craftable Items
// 1. Quartz Block into Quartz
        ShapelessRecipe quartzRecipe = new ShapelessRecipe(new NamespacedKey(lifestealSmp, "quartz_block_to_quartz"), new ItemStack(Material.QUARTZ, 9));
        quartzRecipe.addIngredient(1, Material.QUARTZ_BLOCK);
        Bukkit.addRecipe(quartzRecipe);

// 2. Honeycomb Block into Honeycomb
        ShapelessRecipe honeycombRecipe = new ShapelessRecipe(new NamespacedKey(lifestealSmp, "honeycomb_block_to_honeycomb"), new ItemStack(Material.HONEYCOMB, 4));
        honeycombRecipe.addIngredient(1, Material.HONEYCOMB_BLOCK);
        Bukkit.addRecipe(honeycombRecipe);

// 3. Totem Recipe
        //ShapedRecipe totemRecipe = new ShapedRecipe(new NamespacedKey(lifestealSmp, "totem_recipe"), new ItemStack(Material.TOTEM_OF_UNDYING));
        //totemRecipe.shape("GGG", "GEG", "GBG");
        //totemRecipe.setIngredient('G', Material.GOLD_BLOCK);
        //totemRecipe.setIngredient('E', Material.EMERALD);
        //totemRecipe.setIngredient('B', Material.EXPERIENCE_BOTTLE);
        //Bukkit.addRecipe(totemRecipe);

// 4. Blaze Rod Recipe
        //ShapelessRecipe blazeRodRecipe = new ShapelessRecipe(new NamespacedKey(lifestealSmp, "blaze_rod_recipe"), new ItemStack(Material.BLAZE_ROD));
        //blazeRodRecipe.addIngredient(2, Material.BLAZE_POWDER);
        //blazeRodRecipe.addIngredient(2, Material.GOLD_INGOT); // You can choose between gold or iron
        //Bukkit.addRecipe(blazeRodRecipe);

// 5. Shroomlight Recipe
// Option 1: Glowstone in the corners with any mushroom in the rest (3x3)
        ShapedRecipe shroomlightRecipe1 = new ShapedRecipe(new NamespacedKey(lifestealSmp, "shroomlight_recipe_1"), new ItemStack(Material.SHROOMLIGHT, 4));
        shroomlightRecipe1.shape("GMG", "MNM", "GMG");
        shroomlightRecipe1.setIngredient('G', Material.GLOWSTONE);
        shroomlightRecipe1.setIngredient('M', Material.BROWN_MUSHROOM); // Any mushroom
        shroomlightRecipe1.setIngredient('N', Material.NETHER_BRICK);
        Bukkit.addRecipe(shroomlightRecipe1);

// Option 2: Mushroom blocks in the corners with glowstone dust filling the rest (3x3)
        ShapedRecipe shroomlightRecipe2 = new ShapedRecipe(new NamespacedKey(lifestealSmp, "shroomlight_recipe_2"), new ItemStack(Material.SHROOMLIGHT, 4));
        shroomlightRecipe2.shape("MGD", "GNG", "DGM");
        shroomlightRecipe2.setIngredient('M', Material.BROWN_MUSHROOM_BLOCK); // Any mushroom block
        shroomlightRecipe2.setIngredient('G', Material.GLOWSTONE_DUST);
        shroomlightRecipe2.setIngredient('D', Material.NETHER_BRICK);
        shroomlightRecipe2.setIngredient('N', Material.NETHER_WART_BLOCK);
        Bukkit.addRecipe(shroomlightRecipe2);

// 6. Nylium Recipes
// Crimson Nylium
        ShapedRecipe crimsonNyliumRecipe = new ShapedRecipe(new NamespacedKey(lifestealSmp, "crimson_nylium_recipe"), new ItemStack(Material.CRIMSON_NYLIUM, 2));
        crimsonNyliumRecipe.shape("WW", "WB");
        crimsonNyliumRecipe.setIngredient('W', Material.NETHER_WART_BLOCK);
        crimsonNyliumRecipe.setIngredient('B', Material.NETHERRACK);
        Bukkit.addRecipe(crimsonNyliumRecipe);

// Warped Nylium
        ShapedRecipe warpedNyliumRecipe = new ShapedRecipe(new NamespacedKey(lifestealSmp, "warped_nylium_recipe"), new ItemStack(Material.WARPED_NYLIUM, 2));
        warpedNyliumRecipe.shape("WW", "WB");
        warpedNyliumRecipe.setIngredient('W', Material.WARPED_WART_BLOCK);
        warpedNyliumRecipe.setIngredient('B', Material.NETHERRACK);
        Bukkit.addRecipe(warpedNyliumRecipe);

// 7. Soul Sand Recipes
// Crafting Soul Sand
        ShapedRecipe soulSandRecipe1 = new ShapedRecipe(new NamespacedKey(lifestealSmp, "soul_sand_crafting_recipe"), new ItemStack(Material.SOUL_SAND));
        soulSandRecipe1.shape("DD", "DD");
        soulSandRecipe1.setIngredient('D', Material.DIRT);
        Bukkit.addRecipe(soulSandRecipe1);

// Smelting Soul Soil into Soul Sand
        FurnaceRecipe soulSandRecipe2 = new FurnaceRecipe(new NamespacedKey(lifestealSmp, "soul_soil_to_soul_sand_recipe"), new ItemStack(Material.SOUL_SAND), Material.SOUL_SOIL, 0.7f, 200);
        Bukkit.addRecipe(soulSandRecipe2);

// 8. Mycelium Recipe
        ShapedRecipe myceliumRecipe = new ShapedRecipe(new NamespacedKey(lifestealSmp, "mycelium_recipe"), new ItemStack(Material.MYCELIUM));
        myceliumRecipe.shape("PPP", "PDP", "PPP");
        myceliumRecipe.setIngredient('P', Material.PODZOL);
        myceliumRecipe.setIngredient('D', Material.BROWN_MUSHROOM_BLOCK); // Any mushroom block
        Bukkit.addRecipe(myceliumRecipe);

// 9. Cherry Petals Recipe
        ShapelessRecipe cherryPetalsRecipe = new ShapelessRecipe(new NamespacedKey(lifestealSmp, "cherry_petals_recipe"), new ItemStack(Material.PINK_DYE, 9));
        cherryPetalsRecipe.addIngredient(1, Material.CHERRY_LEAVES);
        Bukkit.addRecipe(cherryPetalsRecipe);

// 10. Flowering Azalea Bush Recipe
        ShapelessRecipe floweringAzaleaBushRecipe = new ShapelessRecipe(new NamespacedKey(lifestealSmp, "flowering_azalea_bush_recipe"), new ItemStack(Material.AZALEA));
        floweringAzaleaBushRecipe.addIngredient(1, Material.AZALEA);
        floweringAzaleaBushRecipe.addIngredient(1, Material.BONE_MEAL);
        Bukkit.addRecipe(floweringAzaleaBushRecipe);

// 11. Cobweb Recipes
// Crafting Cobweb from String
        ShapedRecipe cobwebRecipe1 = new ShapedRecipe(new NamespacedKey(lifestealSmp, "cobweb_recipe_1"), new ItemStack(Material.COBWEB));
        cobwebRecipe1.shape("SSS", "SSS", "SSS");
        cobwebRecipe1.setIngredient('S', Material.STRING);
        Bukkit.addRecipe(cobwebRecipe1);
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

    private static ItemStack createCustomAxe() {
        ItemStack customBow = new ItemStack(Material.NETHERITE_AXE);

        ItemMeta meta = customBow.getItemMeta();
        //meta.setDisplayName(ChatColor.LIGHT_PURPLE + "Teleporting Bow");
        meta.setDisplayName(ChatColor.AQUA + "Tree chopping axe");
        List<String> DEFL = new ArrayList<>();
        DEFL.add(ChatColor.GOLD + "Special Ability: " + ChatColor.DARK_PURPLE + "Breaks whole tree down with one chop!");
        meta.setLore(DEFL);

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
        ItemStack customBow = new ItemStack(Material.NETHERITE_SWORD);

        ItemMeta meta = customBow.getItemMeta();
        meta.setDisplayName(ChatColor.AQUA + "Feather Sword");
        List<String> DEFL = new ArrayList<>();
        DEFL.add(ChatColor.GOLD + "Special Ability: " + ChatColor.DARK_PURPLE + "Right click to launch yourself");
        DEFL.add(ChatColor.LIGHT_PURPLE + "Permanent speed while holding");
        meta.setLore(DEFL);
        //meta.addItemFlags(ItemFlag.HIDE_ITEM_SPECIFICS);
        /*AttributeModifier attackSpeedModifier = new AttributeModifier(
                UUID.randomUUID(),
                "generic.attackSpeed",
                -2.4,
                AttributeModifier.Operation.ADD_NUMBER,
                EquipmentSlot.HAND
        );
        meta.addAttributeModifier(Attribute.GENERIC_ATTACK_SPEED, attackSpeedModifier);

        AttributeModifier attackDamageModifier = new AttributeModifier(
                UUID.randomUUID(),
                "generic.attackDamage",
                6,
                AttributeModifier.Operation.ADD_NUMBER,
                EquipmentSlot.HAND
        );
        meta.addAttributeModifier(Attribute.GENERIC_ATTACK_DAMAGE, attackDamageModifier);*/

        customBow.setItemMeta(meta);

        return customBow;
    }

    private static ItemStack createOpPickaxe() {
        ItemStack customBow = new ItemStack(Material.NETHERITE_PICKAXE);

        ItemMeta meta = customBow.getItemMeta();
        //meta.setDisplayName(ChatColor.LIGHT_PURPLE + "Teleporting Bow");
        meta.setDisplayName(ChatColor.GOLD + "God Pickaxe");
        List<String> DEFL = new ArrayList<>();
        DEFL.add(ChatColor.GOLD + "Special Ability: " + ChatColor.DARK_PURPLE + "Mine to break 3x3!");
        meta.setLore(DEFL);

        customBow.setItemMeta(meta);

        return customBow;
    }

    private static ItemStack createNethScarps() {
        ItemStack customBow = new ItemStack(Material.NETHERITE_SCRAP, 4);
        return customBow;
    }

    public static ItemStack corruptedMobSoul() {

        ItemStack corruptedMobSoul = new ItemStack(Material.ECHO_SHARD);
        ItemMeta soulM = corruptedMobSoul.getItemMeta();
        soulM.addEnchant(Enchantment.DURABILITY, 1, false);
        soulM.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        soulM.setDisplayName(ChatColor.LIGHT_PURPLE + "" + ChatColor.MAGIC + "LL" + ChatColor.DARK_PURPLE + "" + ChatColor.BOLD + "Co" + ChatColor.MAGIC + "r" + ChatColor.DARK_PURPLE + "" + ChatColor.BOLD + "rupted Mob Soul" + ChatColor.LIGHT_PURPLE + "" + ChatColor.MAGIC + "LL");
        soulM.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
        List<String> soulL = new ArrayList<>();
        soulL.add(ChatColor.AQUA + "U$e To Cr" + ChatColor.MAGIC + "a" + ChatColor.AQUA + "ft Extra Hearts!" + ChatColor.MAGIC + "L");
        soulM.setLore(soulL);
        corruptedMobSoul.setItemMeta(soulM);

        return corruptedMobSoul;
    }

    public static ItemStack severedMobHeart() {

        ItemStack severedMobHeart = new ItemStack(Material.BEETROOT);
        ItemMeta heartM = severedMobHeart.getItemMeta();
        heartM.addEnchant(Enchantment.DURABILITY, 1, false);
        heartM.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        heartM.setDisplayName(ChatColor.DARK_RED + "" + ChatColor.BOLD + "Severed Mob Heart");
        heartM.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
        List<String> heartL = new ArrayList<>();
        heartL.add(ChatColor.AQUA + "Use To Craft Extra Hearts!");
        heartM.setLore(heartL);
        severedMobHeart.setItemMeta(heartM);

        return severedMobHeart;
    }

    public static ItemStack extraHeart() {

        ItemStack extraHeart = new ItemStack(Material.RED_DYE);
        ItemMeta EheartM = extraHeart.getItemMeta();
        EheartM.addEnchant(Enchantment.DURABILITY, 1, false);
        EheartM.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        EheartM.setDisplayName(ChatColor.LIGHT_PURPLE + "" + ChatColor.MAGIC + "LL" + ChatColor.DARK_RED + ChatColor.BOLD + "Extra Heart" + ChatColor.LIGHT_PURPLE + "" + ChatColor.MAGIC + "LL");
        EheartM.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
        List<String> EheartL = new ArrayList<>();
        EheartL.add(ChatColor.YELLOW + "" + ChatColor.BOLD + "Right Click:" + ChatColor.DARK_PURPLE + " for +1 heart!");
        EheartL.add(ChatColor.GRAY + "(max 20 hearts)");
        EheartM.setLore(EheartL);
        extraHeart.setItemMeta(EheartM);

        return extraHeart;
    }
}
