package newamazingpvp.lifestealsmp.game;

import org.bukkit.*;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.ShapedRecipe;
import org.bukkit.inventory.ShapelessRecipe;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.LeatherArmorMeta;
import org.bukkit.inventory.meta.SkullMeta;
import org.bukkit.profile.PlayerProfile;
import org.bukkit.profile.PlayerTextures;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import static newamazingpvp.lifestealsmp.LifestealSMP.lifestealSmp;

public class CustomRecipe {
    public static void registerCustomRecipes() {

        /*ItemStack VWH = new ItemStack(VoidWalkerHEALM());
        ShapedRecipe VWHR = new ShapedRecipe(new NamespacedKey(lifestealSmp, "VoidWalkerHealmR"), VWH);
        VWHR.shape("DAD", "BXB", "TNT");
        VWHR.setIngredient('D', Material.DIAMOND_BLOCK, 5);
        VWHR.setIngredient('N', Material.NETHERITE_INGOT, 3);
        VWHR.setIngredient('B', Material.BEACON);
        VWHR.setIngredient('X', Material.DRAGON_HEAD);
        VWHR.setIngredient('T', Material.DRAGON_BREATH);
        VWHR.setIngredient('A', antimatterVile());

        Bukkit.addRecipe(VWHR);*/

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

        /*NamespacedKey recipeKey = new NamespacedKey(lifestealSmp, "teleporting_bow");
        ShapelessRecipe customBowRecipe = new ShapelessRecipe(recipeKey, createCustomBow());
        customBowRecipe.addIngredient(2, Material.ENDER_PEARL);
        customBowRecipe.addIngredient(1, Material.NETHERITE_INGOT);
        customBowRecipe.addIngredient(1, Material.BOW);
        customBowRecipe.addIngredient(1, Material.NETHER_STAR);
        customBowRecipe.addIngredient(2, Material.DIAMOND);
        Bukkit.addRecipe(customBowRecipe);

        NamespacedKey tntBow = new NamespacedKey(lifestealSmp, "tnt_bow");
        ShapelessRecipe tntBowRecipe = new ShapelessRecipe(tntBow, createTNTBow());
        tntBowRecipe.addIngredient(2, Material.TNT);
        tntBowRecipe.addIngredient(2, Material.NETHERITE_INGOT);
        tntBowRecipe.addIngredient(1, Material.BOW);
        tntBowRecipe.addIngredient(1, Material.END_CRYSTAL);
        tntBowRecipe.addIngredient(1, Material.NETHER_STAR);
        Bukkit.addRecipe(tntBowRecipe);

        NamespacedKey featherSword = new NamespacedKey(lifestealSmp, "feather_sword");
        ShapelessRecipe featherSwordRecipe = new ShapelessRecipe(featherSword, createFeatherSword());
        featherSwordRecipe.addIngredient(2, Material.FEATHER);
        featherSwordRecipe.addIngredient(2, Material.NETHERITE_INGOT);
        featherSwordRecipe.addIngredient(1, Material.DIAMOND_SWORD);
        featherSwordRecipe.addIngredient(2, Material.TOTEM_OF_UNDYING);
        featherSwordRecipe.addIngredient(2, Material.NETHER_STAR);
        Bukkit.addRecipe(featherSwordRecipe);

        NamespacedKey tropChopAxe = new NamespacedKey(lifestealSmp, "trop_chop_axe");
        ShapelessRecipe tropChopAxeRecipe = new ShapelessRecipe(tropChopAxe, createCustomAxe());
        tropChopAxeRecipe.addIngredient(1, Material.STICK);
        tropChopAxeRecipe.addIngredient(1, Material.NETHERITE_INGOT);
        tropChopAxeRecipe.addIngredient(3, Material.DIAMOND_AXE);
        Bukkit.addRecipe(tropChopAxeRecipe);

        NamespacedKey opPickaxe = new NamespacedKey(lifestealSmp, "op_pickaxe");
        ShapelessRecipe opPickaxeRecipe = new ShapelessRecipe(opPickaxe, createOpPickaxe());
        opPickaxeRecipe.addIngredient(2, Material.DIAMOND_BLOCK);
        opPickaxeRecipe.addIngredient(1, Material.GOLD_BLOCK);
        opPickaxeRecipe.addIngredient(5, Material.NETHERITE_INGOT);
        opPickaxeRecipe.addIngredient(1, Material.DIAMOND_PICKAXE);
        Bukkit.addRecipe(opPickaxeRecipe);*/

        NamespacedKey nethScraps = new NamespacedKey(lifestealSmp, "neth_scraps");
        ShapelessRecipe nethScrapsRecipe = new ShapelessRecipe(nethScraps, createNethScarps());
        nethScrapsRecipe.addIngredient(1, Material.NETHERITE_INGOT);
        Bukkit.addRecipe(nethScrapsRecipe);

        /*NamespacedKey homingBow = new NamespacedKey(lifestealSmp, "homing_bow");
        ShapelessRecipe homingBowRecipe = new ShapelessRecipe(homingBow, createHomingBow());
        homingBowRecipe.addIngredient(1, Material.BOW);
        homingBowRecipe.addIngredient(2, Material.NETHERITE_INGOT);
        homingBowRecipe.addIngredient(2, Material.DIAMOND_BLOCK);
        homingBowRecipe.addIngredient(1, Material.NETHER_STAR);
        homingBowRecipe.addIngredient(2, Material.COMPASS);
        Bukkit.addRecipe(homingBowRecipe);*/

        NamespacedKey reviveBeacon = new NamespacedKey(lifestealSmp, "revive_beacon");
        ShapelessRecipe reviveBeaconRecipe = new ShapelessRecipe(reviveBeacon, createReviveBeacon());
        reviveBeaconRecipe.addIngredient(1, Material.BEACON);
        reviveBeaconRecipe.addIngredient(4, Material.DIAMOND_BLOCK);
        reviveBeaconRecipe.addIngredient(1, Material.NETHERITE_BLOCK);
        reviveBeaconRecipe.addIngredient(2, Material.TOTEM_OF_UNDYING);
        reviveBeaconRecipe.addIngredient(1, Material.GOLDEN_APPLE);
        Bukkit.addRecipe(reviveBeaconRecipe);
    }

    public static ItemStack createReviveBeacon() {
        ItemStack reviveBeacon = new ItemStack(Material.BEACON);

        ItemMeta meta = reviveBeacon.getItemMeta();
        meta.setDisplayName(ChatColor.DARK_PURPLE + "Revive Beacon");
        List<String> DEFL = new ArrayList<>();
        DEFL.add(ChatColor.GOLD + "Use to revive eliminated players!");
        meta.setLore(DEFL);

        reviveBeacon.setItemMeta(meta);

        return reviveBeacon;
    }

    public static ItemStack createCustomBow() {
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

    public static ItemStack createCustomAxe() {
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

    public static ItemStack createTNTBow() {
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

    public static ItemStack createHomingBow() {
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

    public static ItemStack createFeatherSword() {
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

    public static ItemStack createOpPickaxe() {
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
        soulM.setDisplayName(ChatColor.LIGHT_PURPLE + "" + ChatColor.MAGIC + "LL" + ChatColor.DARK_PURPLE + ChatColor.BOLD + "Co" + ChatColor.MAGIC + "r" + ChatColor.DARK_PURPLE + ChatColor.BOLD + "rupted Mob Soul" + ChatColor.LIGHT_PURPLE + ChatColor.MAGIC + "LL");
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
        EheartM.setDisplayName(ChatColor.LIGHT_PURPLE + "" + ChatColor.MAGIC + "LL" + ChatColor.DARK_RED + ChatColor.BOLD + "Extra Heart" + ChatColor.LIGHT_PURPLE + ChatColor.MAGIC + "LL");
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
        SOPL.add(ChatColor.LIGHT_PURPLE + "" + ChatColor.BOLD + "Required for Ancient Wand");
        meta.setLore(SOPL);
        meta.setOwnerProfile(profile);
        montuHelm.setItemMeta(meta);

        return montuHelm;
    }

    public static ItemStack AquaHealm() {

        PlayerProfile profileaqua = getProfile("http://textures.minecraft.net/texture/7b40b3f16a2dc24106780090f485c9b5866d66e77e6f900292a0527b60d174f2");
        ItemStack AquaHealm = new ItemStack(Material.PLAYER_HEAD);
        SkullMeta meta = (SkullMeta) AquaHealm.getItemMeta();
        meta.setDisplayName(ChatColor.GOLD + "" + ChatColor.BOLD + "Diver Helmet");
        List<String> SOPL = new ArrayList<>();
        SOPL.add(ChatColor.LIGHT_PURPLE + "" + ChatColor.BOLD + "Required for Aqua Wand");
        meta.setLore(SOPL);
        meta.setOwnerProfile(profileaqua);
        AquaHealm.setItemMeta(meta);

        return AquaHealm;
    }

    private static final UUID RANDOM_UUID = UUID.fromString("92864445-51c5-4c3b-9039-517c9927d1c7"); // We reuse the same "random" UUID all the time

    public static PlayerProfile getProfile(String url) {
        PlayerProfile profileVOID = Bukkit.createPlayerProfile(RANDOM_UUID); // Get a new player profile
        PlayerTextures textures = profileVOID.getTextures();
        URL urlObject;
        try {
            urlObject = new URL(url); // The URL to the skin
        } catch (MalformedURLException exception) {
            throw new RuntimeException("Invalid URL", exception);
        }
        textures.setSkin(urlObject); // Set the skin of the player profile to the URL
        profileVOID.setTextures(textures); // Set the textures back to the profile
        return profileVOID;
    }

    public static ItemStack VoidWalkerHEALM() {

        PlayerProfile profileVOID = getProfile("http://textures.minecraft.net/texture/d3530b3109d80796035d3cff3973b70e2cb73b925389f06cd4314a76099ba1d");
        ItemStack VoidWalkerHEALM = new ItemStack(Material.PLAYER_HEAD);
        SkullMeta meta = (SkullMeta) VoidWalkerHEALM.getItemMeta();
        meta.setDisplayName(ChatColor.LIGHT_PURPLE + "" + ChatColor.MAGIC + "LL " + ChatColor.DARK_RED + ChatColor.BOLD + "Void Walker Helmet" + ChatColor.LIGHT_PURPLE + ChatColor.MAGIC + " LL");
        List<String> SOPL = new ArrayList<>();
        SOPL.add(ChatColor.GOLD + "" + ChatColor.BOLD + "Item Ability:");
        SOPL.add(ChatColor.DARK_PURPLE + "When in the end, you will gain");
        SOPL.add(ChatColor.DARK_PURPLE + "unlimited resistance 2, jump boost 2,");
        SOPL.add(ChatColor.DARK_PURPLE + "and strength 2!");
        SOPL.add(ChatColor.GOLD + "" + ChatColor.BOLD + "Item Ability #2:");
        SOPL.add(ChatColor.DARK_PURPLE + "If crouching, when you place");
        SOPL.add(ChatColor.DARK_PURPLE + "obsidian a unstable Enderman");
        SOPL.add(ChatColor.DARK_PURPLE + "that will fight for you!");
        SOPL.add(ChatColor.GRAY + "(one at a time)");
        meta.setLore(SOPL);
        meta.setOwnerProfile(profileVOID);
        VoidWalkerHEALM.setItemMeta(meta);

        return VoidWalkerHEALM;
    }


    public static ItemStack SekhmetCHEST1() {

        ItemStack SekhmetCHEST1 = new ItemStack(Material.LEATHER_CHESTPLATE);
        LeatherArmorMeta SVCM = (LeatherArmorMeta) SekhmetCHEST1.getItemMeta();
        SVCM.setDisplayName(ChatColor.LIGHT_PURPLE + "" + ChatColor.BOLD + "Sekhmet's Chestplate");
        List<String> SVCL = new ArrayList<>();
        SVCL.add(ChatColor.GOLD + "" + ChatColor.BOLD + "Full Set Bonus:");
        SVCL.add(ChatColor.DARK_PURPLE + "If you are holding Sekhmet's Staff");
        SVCL.add(ChatColor.DARK_PURPLE + "You will have unlimited speed 3.");
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
        SVLL.add(ChatColor.GOLD + "" + ChatColor.BOLD + "Full Set Bonus:");
        SVLL.add(ChatColor.DARK_PURPLE + "If you are holding Sekhmet's Staff");
        SVLL.add(ChatColor.DARK_PURPLE + "You will have unlimited speed 3.");
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
        SVBL.add(ChatColor.GOLD + "" + ChatColor.BOLD + "Full Set Bonus:");
        SVBL.add(ChatColor.DARK_PURPLE + "If you are holding Sekhmet's Staff");
        SVBL.add(ChatColor.DARK_PURPLE + "You will have unlimited speed 3.");
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
        MSL.add(ChatColor.GOLD + "" + ChatColor.BOLD + "Full Set Bonus:");
        MSL.add(ChatColor.DARK_PURPLE + "If you are holding Sekhmet's Staff");
        MSL.add(ChatColor.DARK_PURPLE + "you will have unlimited resistance 1.");
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
        MSL.add(ChatColor.GOLD + "" + ChatColor.BOLD + "Full Set Bonus:");
        MSL.add(ChatColor.DARK_PURPLE + "If you are holding Sekhmet's Staff");
        MSL.add(ChatColor.DARK_PURPLE + "you will have unlimited resistance 1.");
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
        MSL.add(ChatColor.GOLD + "" + ChatColor.BOLD + "Full Set Bonus:");
        MSL.add(ChatColor.DARK_PURPLE + "If you are holding Sekhmet's Staff");
        MSL.add(ChatColor.DARK_PURPLE + "you will have unlimited resistance 1.");
        ASM.setLore(MSL);
        ASM.setUnbreakable(true);
        SekhmetBOOT2.setItemMeta(ASM);

        return SekhmetBOOT2;
    }

    public static ItemStack SekhmetSTAFF1() {

        ItemStack SekhmetSTAFF1 = new ItemStack(Material.STICK);
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

        ItemStack SekhmetSTAFF2 = new ItemStack(Material.STICK);
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

        ItemStack SekhmetSTAFF3 = new ItemStack(Material.STICK);
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

        ItemStack AimingBow = new ItemStack(Material.BOW);
        ItemMeta SOPM = AimingBow.getItemMeta();
        SOPM.setDisplayName(ChatColor.GOLD + "" + ChatColor.BOLD + "Heat Seeking Bow");
        List<String> SOPL = new ArrayList<>();
        SOPL.add(ChatColor.YELLOW + "" + ChatColor.BOLD + "Item Ability:");
        SOPL.add(ChatColor.DARK_PURPLE + "All arrows will auto aim to players.");
        SOPM.setLore(SOPL);
        SOPM.setUnbreakable(true);
        AimingBow.setItemMeta(SOPM);

        return AimingBow;
    }

    public static ItemStack antimatterVile() {

        ItemStack antimatterVile = new ItemStack(Material.ECHO_SHARD);
        ItemMeta SOPM = antimatterVile.getItemMeta();
        SOPM.addEnchant(Enchantment.DURABILITY, 1, false);
        SOPM.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        SOPM.setDisplayName(ChatColor.BLACK + "" + ChatColor.BOLD + "Antimatter Vile");
        List<String> SOPL = new ArrayList<>();
        SOPL.add(ChatColor.AQUA + "Used to craft the" + ChatColor.BLACK + " Void Walker" + ChatColor.AQUA + " helmet.");
        SOPM.setLore(SOPL);
        antimatterVile.setItemMeta(SOPM);

        return antimatterVile;
    }
}
