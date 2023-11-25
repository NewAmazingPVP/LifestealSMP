package newamazingpvp.lifestealsmp.game;

import org.bukkit.*;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.*;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.LeatherArmorMeta;
import org.bukkit.inventory.meta.SkullMeta;
import org.bukkit.profile.PlayerProfile;

import java.util.ArrayList;
import java.util.List;

import static newamazingpvp.lifestealsmp.LifestealSMP.lifestealSmp;
import static newamazingpvp.lifestealsmp.command.GiveSekhmetSetADMINONLY.getProfile;

public class CustomRecipe {
    public static void registerCustomRecipes() {

        /*ItemStack SekhmetSTAFF = new ItemStack(extraHeart());
        ShapedRecipe SekhmetSTAFFR = new ShapedRecipe(new NamespacedKey(lifestealSmp, "SekhmetSTAFF"), SekhmetSTAFF);
        SekhmetSTAFFR.shape("CXC", "DSD", "XNX");
        SekhmetSTAFFR.setIngredient('D', Material.DIAMOND_BLOCK);
        SekhmetSTAFFR.setIngredient('N', Material.NETHERITE_INGOT);
        SekhmetSTAFFR.setIngredient('C', corruptedMobSoul());
        SekhmetSTAFFR.setIngredient('S', severedMobHeart());
        SekhmetSTAFFR.setIngredient('X', Material.AIR);
        Bukkit.addRecipe(SekhmetSTAFFR);*/

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

        NamespacedKey homingBow = new NamespacedKey(lifestealSmp, "homing_bow");
        ShapelessRecipe homingBowRecipe = new ShapelessRecipe(homingBow, createHomingBow());
        homingBowRecipe.addIngredient(1, Material.ARROW);
        homingBowRecipe.addIngredient(1, Material.NETHERITE_INGOT);
        homingBowRecipe.addIngredient(1, Material.BOW);
        Bukkit.addRecipe(homingBowRecipe);
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

    private static ItemStack createHomingBow() {
        ItemStack customBow = new ItemStack(Material.BOW);

        ItemMeta meta = customBow.getItemMeta();
        //meta.setDisplayName(ChatColor.LIGHT_PURPLE + "Teleporting Bow");
        meta.setDisplayName(ChatColor.GOLD + "Homing Bow");
        List<String> DEFL = new ArrayList<>();
        DEFL.add(ChatColor.GOLD + "Special Ability: " + ChatColor.DARK_PURPLE + "Homing Arrows!");
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
        EheartL.add(ChatColor.YELLOW + "" + ChatColor.BOLD + "Right Click:" + ChatColor.DARK_PURPLE + " For +1 Heart!");
        EheartL.add(ChatColor.GRAY + "(max 20 hearts)");
        EheartM.setLore(EheartL);
        extraHeart.setItemMeta(EheartM);

        return extraHeart;
    }

    public static ItemStack ancientSpellScroll() {

        ItemStack ancientSpellScroll = new ItemStack(Material.SILENCE_ARMOR_TRIM_SMITHING_TEMPLATE);
        ItemMeta ASM = ancientSpellScroll.getItemMeta();
        ASM.addEnchant(Enchantment.DURABILITY, 1, false);
        ASM.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        ASM.setDisplayName(ChatColor.LIGHT_PURPLE + "" + ChatColor.BOLD + "Ancient Spell Scroll");
        ASM.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
        ASM.addItemFlags(ItemFlag.HIDE_ITEM_SPECIFICS);
        List<String> MSL = new ArrayList<>();
        MSL.add(ChatColor.AQUA + "Used To Craft Sekhmet's Staff");
        ASM.setLore(MSL);
        ancientSpellScroll.setItemMeta(ASM);

        return ancientSpellScroll;
    }

    public static ItemStack montuHelm() {

        PlayerProfile profile = getProfile("https://textures.minecraft.net/texture/3070fad4da430fc24141542918ca184803d7f50a8a8e263d0331e3fd62029336");
        ItemStack montuHelm = new ItemStack(Material.PLAYER_HEAD);
        SkullMeta meta = (SkullMeta) montuHelm.getItemMeta();
        meta.setDisplayName(ChatColor.GOLD + "" + ChatColor.BOLD + "Sekhmet's Helmet");
        List<String> SOPL = new ArrayList<>();
        SOPL.add(ChatColor.DARK_PURPLE + "" + ChatColor.BOLD + "Required for Sekhmet's staff");
        meta.setLore(SOPL);
        meta.setOwnerProfile(profile);
        montuHelm.setItemMeta(meta);

        return montuHelm;
    }

    public static ItemStack SekhmetCHEST1() {

        ItemStack SekhmetCHEST1 = new ItemStack(Material.LEATHER_CHESTPLATE);
        LeatherArmorMeta SVCM = (LeatherArmorMeta) SekhmetCHEST1.getItemMeta();
        SVCM.setDisplayName(ChatColor.LIGHT_PURPLE + "" + ChatColor.BOLD + "Sekhmet's Chestplate");
        List<String> SVCL = new ArrayList<>();
        SVCL.add(ChatColor.YELLOW + "" + ChatColor.BOLD + "Full Set Bonus:");
        SVCL.add(ChatColor.DARK_PURPLE + "Lets you use the Sekhmet's Staff!");
        SVCL.add(ChatColor.DARK_PURPLE + "Unlocks abilities that are more for");
        SVCL.add(ChatColor.DARK_PURPLE + "movement and quick attacks.");
        SVCM.setLore(SVCL);
        SVCM.setUnbreakable(true);
        SVCM.addItemFlags(ItemFlag.HIDE_DYE);
        //SVCM.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
        SVCM.setColor(Color.fromRGB(0, 0, 255));
        SekhmetCHEST1.setItemMeta(SVCM);

        return SekhmetCHEST1;
    }

    public static ItemStack SekhmetLEG1() {

        ItemStack SekhmetLEG1 = new ItemStack(Material.LEATHER_LEGGINGS);
        LeatherArmorMeta SVLM = (LeatherArmorMeta) SekhmetLEG1.getItemMeta();
        SVLM.setDisplayName(ChatColor.LIGHT_PURPLE + "" + ChatColor.BOLD + "Sekhmet's Leggings");
        List<String> SVLL = new ArrayList<>();
        SVLL.add(ChatColor.YELLOW + "" + ChatColor.BOLD + "Full Set Bonus:");
        SVLL.add(ChatColor.DARK_PURPLE + "Lets you use the Sekhmet's Staff!");
        SVLL.add(ChatColor.DARK_PURPLE + "Unlocks abilities that are more for");
        SVLL.add(ChatColor.DARK_PURPLE + "movement and quick attacks.");
        SVLM.setLore(SVLL);
        SVLM.setUnbreakable(true);
        SVLM.addItemFlags(ItemFlag.HIDE_DYE);
        //SVLM.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
        SVLM.setColor(Color.fromRGB(0, 0, 255));
        SekhmetLEG1.setItemMeta(SVLM);

        return SekhmetLEG1;
    }

    public static ItemStack SekhmetBOOT1() {

        ItemStack SekhmetBOOT1 = new ItemStack(Material.LEATHER_BOOTS);
        LeatherArmorMeta SVBM = (LeatherArmorMeta) SekhmetBOOT1.getItemMeta();
        SVBM.setDisplayName(ChatColor.LIGHT_PURPLE + "" + ChatColor.BOLD + "Sekhmet's Boots");
        List<String> SVBL = new ArrayList<>();
        SVBL.add(ChatColor.YELLOW + "" + ChatColor.BOLD + "Full Set Bonus:");
        SVBL.add(ChatColor.DARK_PURPLE + "Lets you use the Sekhmet's Staff!");
        SVBL.add(ChatColor.DARK_PURPLE + "Unlocks abilities that are more for");
        SVBL.add(ChatColor.DARK_PURPLE + "movement and quick attacks.");
        SVBM.setLore(SVBL);
        SVBM.setUnbreakable(true);
        SVBM.addItemFlags(ItemFlag.HIDE_DYE);
        //SVBM.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
        SVBM.setColor(Color.fromRGB(0, 0, 255));
        SekhmetBOOT1.setItemMeta(SVBM);

        return SekhmetBOOT1;
    }

    public static ItemStack SekhmetCHEST2() {

        ItemStack SekhmetCHEST2 = new ItemStack(Material.GOLDEN_CHESTPLATE);
        ItemMeta ASM = SekhmetCHEST2.getItemMeta();
        ASM.setDisplayName(ChatColor.GOLD + "" + ChatColor.BOLD + "Sekhmet's Chestplate");
        List<String> MSL = new ArrayList<>();
        MSL.add(ChatColor.YELLOW + "" + ChatColor.BOLD + "Full Set Bonus:");
        MSL.add(ChatColor.DARK_PURPLE + "Lets you use the Sekhmet's Staff!");
        MSL.add(ChatColor.DARK_PURPLE + "Unlocks abilities that are slower");
        MSL.add(ChatColor.DARK_PURPLE + "but deal large amounts of damage.");
        ASM.setLore(MSL);
        ASM.setUnbreakable(true);
        SekhmetCHEST2.setItemMeta(ASM);

        return SekhmetCHEST2;
    }

    public static ItemStack SekhmetLEG2() {

        ItemStack SekhmetLEG2 = new ItemStack(Material.GOLDEN_LEGGINGS);
        ItemMeta ASM = SekhmetLEG2.getItemMeta();
        ASM.setDisplayName(ChatColor.GOLD + "" + ChatColor.BOLD + "Sekhmet's Leggings");
        List<String> MSL = new ArrayList<>();
        MSL.add(ChatColor.YELLOW + "" + ChatColor.BOLD + "Full Set Bonus:");
        MSL.add(ChatColor.DARK_PURPLE + "Lets you use the Sekhmet's Staff!");
        MSL.add(ChatColor.DARK_PURPLE + "Unlocks abilities that are slower");
        MSL.add(ChatColor.DARK_PURPLE + "but deal large amounts of damage.");
        ASM.setLore(MSL);
        ASM.setUnbreakable(true);
        SekhmetLEG2.setItemMeta(ASM);

        return SekhmetLEG2;
    }

    public static ItemStack SekhmetBOOT2() {

        ItemStack SekhmetBOOT2 = new ItemStack(Material.GOLDEN_BOOTS);
        ItemMeta ASM = SekhmetBOOT2.getItemMeta();
        ASM.setDisplayName(ChatColor.GOLD + "" + ChatColor.BOLD + "Sekhmet's Boots");
        List<String> MSL = new ArrayList<>();
        MSL.add(ChatColor.YELLOW + "" + ChatColor.BOLD + "Full Set Bonus:");
        MSL.add(ChatColor.DARK_PURPLE + "Lets you use the Sekhmet's Staff!");
        MSL.add(ChatColor.DARK_PURPLE + "Unlocks abilities that are slower");
        MSL.add(ChatColor.DARK_PURPLE + "but deal large amounts of damage.");
        ASM.setLore(MSL);
        ASM.setUnbreakable(true);
        SekhmetBOOT2.setItemMeta(ASM);

        return SekhmetBOOT2;
    }

    public static ItemStack SekhmetSTAFF1() {

        ItemStack SekhmetSTAFF1  = new ItemStack(Material.STICK);
        ItemMeta SOPM = SekhmetSTAFF1.getItemMeta();
        SOPM.setDisplayName(ChatColor.DARK_RED + "" + ChatColor.BOLD + "Sekhmet's Staff");
        List<String> SOPL = new ArrayList<>();
        SOPL.add(" ");
        SOPL.add(ChatColor.LIGHT_PURPLE + "" + ChatColor.BOLD + "Abilities change depending on special armor set");
        SOPL.add(ChatColor.RED + "Requires Sekhmet's helmet to use!");
        SOPL.add(ChatColor.DARK_PURPLE + "" + ChatColor.BOLD + "-------------------------------------");
        SOPL.add(ChatColor.YELLOW + "" + ChatColor.BOLD + "Right Click:");
        SOPL.add(ChatColor.DARK_RED + "Use a full set bonus to get abilities");
        SOPL.add(ChatColor.LIGHT_PURPLE + "Teleports you to where you are looking.");
        SOPL.add(ChatColor.DARK_PURPLE + "" + ChatColor.BOLD + "-------------------------------------");
        SOPL.add(ChatColor.YELLOW + "" + ChatColor.BOLD + "Shift Right Click:");
        SOPL.add(ChatColor.DARK_RED + "Use a full set bonus to get abilities");
        SOPL.add(ChatColor.LIGHT_PURPLE + "Makes a area around you where players will get poisoned.");
        SOPL.add(ChatColor.DARK_PURPLE + "" + ChatColor.BOLD + "-------------------------------------");
        SOPL.add(ChatColor.YELLOW + "" + ChatColor.BOLD + "Left Click:");
        SOPL.add(ChatColor.DARK_RED + "Use a full set bonus to get abilities");
        SOPL.add(ChatColor.LIGHT_PURPLE + "Shoots a beam of energy.");
        SOPL.add(ChatColor.DARK_PURPLE + "" + ChatColor.BOLD + "-------------------------------------");
        SOPL.add(ChatColor.YELLOW + "" + ChatColor.BOLD + "Shift Left Click:");
        SOPL.add(ChatColor.DARK_RED + "Use a full set bonus to get abilities");
        SOPL.add(ChatColor.LIGHT_PURPLE + "Makes a shock wave around you ripping the lad apart.");
        SOPL.add(ChatColor.DARK_PURPLE + "" + ChatColor.BOLD + "-------------------------------------");
        SOPM.setLore(SOPL);
        SOPM.addEnchant(Enchantment.DURABILITY, 1, false);
        SOPM.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        SekhmetSTAFF1.setItemMeta(SOPM);

        return SekhmetSTAFF1;
    }

    public static ItemStack SekhmetSTAFF2() {

        ItemStack SekhmetSTAFF2  = new ItemStack(Material.STICK);
        ItemMeta SOPM = SekhmetSTAFF2.getItemMeta();
        SOPM.setDisplayName(ChatColor.DARK_BLUE + "" + ChatColor.BOLD + "Sekhmet's Staff");
        List<String> SOPL = new ArrayList<>();
        SOPL.add(" ");
        SOPL.add(ChatColor.LIGHT_PURPLE + "" + ChatColor.BOLD + "Abilities change depending on special armor set");
        SOPL.add(ChatColor.RED + "Requires Sekhmet's helmet to use!");
        SOPL.add(ChatColor.DARK_PURPLE + "" + ChatColor.BOLD + "-------------------------------------");
        SOPL.add(ChatColor.YELLOW + "" + ChatColor.BOLD + "Right Click:");
        SOPL.add(ChatColor.DARK_RED + "Use a full set bonus to get abilities");
        SOPL.add(ChatColor.LIGHT_PURPLE + "Teleports you to where you are looking.");
        SOPL.add(ChatColor.DARK_PURPLE + "" + ChatColor.BOLD + "-------------------------------------");
        SOPL.add(ChatColor.YELLOW + "" + ChatColor.BOLD + "Shift Right Click:");
        SOPL.add(ChatColor.DARK_RED + "Use a full set bonus to get abilities");
        SOPL.add(ChatColor.LIGHT_PURPLE + "Makes a area around you where players will get poisoned.");
        SOPL.add(ChatColor.DARK_PURPLE + "" + ChatColor.BOLD + "-------------------------------------");
        SOPL.add(ChatColor.YELLOW + "" + ChatColor.BOLD + "Left Click:");
        SOPL.add(ChatColor.DARK_RED + "Use a full set bonus to get abilities");
        SOPL.add(ChatColor.LIGHT_PURPLE + "Shoots a beam of energy.");
        SOPL.add(ChatColor.DARK_PURPLE + "" + ChatColor.BOLD + "-------------------------------------");
        SOPL.add(ChatColor.YELLOW + "" + ChatColor.BOLD + "Shift Left Click:");
        SOPL.add(ChatColor.DARK_RED + "Use a full set bonus to get abilities");
        SOPL.add(ChatColor.LIGHT_PURPLE + "Makes a shock wave around you ripping the lad apart.");
        SOPL.add(ChatColor.DARK_PURPLE + "" + ChatColor.BOLD + "-------------------------------------");
        SOPM.setLore(SOPL);
        SOPM.addEnchant(Enchantment.DURABILITY, 1, false);
        SOPM.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        SekhmetSTAFF2.setItemMeta(SOPM);

        return SekhmetSTAFF2;
    }

    public static ItemStack SekhmetSTAFF3() {

        ItemStack SekhmetSTAFF3  = new ItemStack(Material.STICK);
        ItemMeta SOPM = SekhmetSTAFF3.getItemMeta();
        SOPM.setDisplayName(ChatColor.GOLD + "" + ChatColor.BOLD + "Sekhmet's Staff");
        List<String> SOPL = new ArrayList<>();
        SOPL.add(" ");
        SOPL.add(ChatColor.LIGHT_PURPLE + "" + ChatColor.BOLD + "Abilities change depending on special armor set");
        SOPL.add(ChatColor.RED + "Requires Sekhmet's helmet to use!");
        SOPL.add(ChatColor.DARK_PURPLE + "" + ChatColor.BOLD + "-------------------------------------");
        SOPL.add(ChatColor.YELLOW + "" + ChatColor.BOLD + "Right Click:");
        SOPL.add(ChatColor.DARK_RED + "Use a full set bonus to get abilities");
        SOPL.add(ChatColor.LIGHT_PURPLE + "Teleports you to where you are looking.");
        SOPL.add(ChatColor.DARK_PURPLE + "" + ChatColor.BOLD + "-------------------------------------");
        SOPL.add(ChatColor.YELLOW + "" + ChatColor.BOLD + "Shift Right Click:");
        SOPL.add(ChatColor.DARK_RED + "Use a full set bonus to get abilities");
        SOPL.add(ChatColor.LIGHT_PURPLE + "Makes a area around you where players will get poisoned.");
        SOPL.add(ChatColor.DARK_PURPLE + "" + ChatColor.BOLD + "-------------------------------------");
        SOPL.add(ChatColor.YELLOW + "" + ChatColor.BOLD + "Left Click:");
        SOPL.add(ChatColor.DARK_RED + "Use a full set bonus to get abilities");
        SOPL.add(ChatColor.LIGHT_PURPLE + "Shoots a beam of energy.");
        SOPL.add(ChatColor.DARK_PURPLE + "" + ChatColor.BOLD + "-------------------------------------");
        SOPL.add(ChatColor.YELLOW + "" + ChatColor.BOLD + "Shift Left Click:");
        SOPL.add(ChatColor.DARK_RED + "Use a full set bonus to get abilities");
        SOPL.add(ChatColor.LIGHT_PURPLE + "Makes a shock wave around you ripping the lad apart.");
        SOPL.add(ChatColor.DARK_PURPLE + "" + ChatColor.BOLD + "-------------------------------------");
        SOPM.setLore(SOPL);
        SOPM.addEnchant(Enchantment.DURABILITY, 1, false);
        SOPM.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        SekhmetSTAFF3.setItemMeta(SOPM);

        return SekhmetSTAFF3;
    }

    public static ItemStack AimingBow() {

        ItemStack AimingBow  = new ItemStack(Material.BOW);
        ItemMeta SOPM = AimingBow.getItemMeta();
        SOPM.setDisplayName(ChatColor.GOLD + "" + ChatColor.BOLD + "Sekhmet's Staff");
        List<String> SOPL = new ArrayList<>();
        SOPL.add(ChatColor.YELLOW + "" + ChatColor.BOLD + "Item Ability:");
        SOPL.add(ChatColor.DARK_PURPLE + "All arrows will auto aim to players.");
        SOPM.setLore(SOPL);
        SOPM.setUnbreakable(true);
        AimingBow.setItemMeta(SOPM);

        return AimingBow;
    }
}
