package newamazingpvp.lifestealsmp.customitems.utils;

import org.bukkit.ChatColor;
import org.bukkit.Color;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.LeatherArmorMeta;

import java.util.ArrayList;
import java.util.List;

public class ItemStacks {

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

    public static ItemStack corruptedMobSoul() {

        ItemStack corruptedMobSoul = new ItemStack(Material.ECHO_SHARD);
        ItemMeta soulM = corruptedMobSoul.getItemMeta();
        soulM.addEnchant(Enchantment.DURABILITY, 1, false);
        soulM.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        soulM.setDisplayName(ChatColor.LIGHT_PURPLE + "" + ChatColor.MAGIC + "LL" + ChatColor.DARK_PURPLE + ChatColor.BOLD + "Co" + ChatColor.MAGIC + "r" + ChatColor.DARK_PURPLE + ChatColor.BOLD + "rupted Mob Soul" + ChatColor.LIGHT_PURPLE + ChatColor.MAGIC + "LL");
        soulM.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
        List<String> soulL = new ArrayList<>();
        soulL.add(ChatColor.AQUA + "U$e To Cr" + ChatColor.MAGIC + "a" + ChatColor.AQUA + "ft Extra Hearts!" + ChatColor.MAGIC + "L");
        soulL.add(ChatColor.LIGHT_PURPLE + "Rare Drop From Mobs!");
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
        heartL.add(ChatColor.LIGHT_PURPLE + "Very Rare Drop From Mobs!");
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

    public static ItemStack lightFeather() {

        ItemStack SpeedFeather = new ItemStack(Material.FEATHER);
        ItemMeta SI = SpeedFeather.getItemMeta();
        SI.addEnchant(Enchantment.DURABILITY, 1, false);
        SI.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        SI.setDisplayName(ChatColor.GOLD + "" + ChatColor.BOLD + "Light Feather");
        SI.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
        List<String> BL = new ArrayList<>();
        BL.add(ChatColor.GOLD + "" + ChatColor.BOLD + "Right Click:");
        BL.add(ChatColor.DARK_PURPLE + "Get speed and jump boost for a few sec!");
        BL.add(ChatColor.RED + "One time use!");
        SI.setLore(BL);
        SpeedFeather.setItemMeta(SI);

        return SpeedFeather;
    }

    public static ItemStack InstaBoomTNT() {

        ItemStack InstaBoomTNT = new ItemStack(Material.TNT);
        ItemMeta SI = InstaBoomTNT.getItemMeta();
        SI.addEnchant(Enchantment.DURABILITY, 1, false);
        SI.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        SI.setDisplayName(ChatColor.GOLD + "" + ChatColor.BOLD + "InstaBoom TNT");
        SI.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
        List<String> BL = new ArrayList<>();
        BL.add(ChatColor.GOLD + "" + ChatColor.BOLD + "Place:");
        BL.add(ChatColor.DARK_PURPLE + "All players within a radius");
        BL.add(ChatColor.DARK_PURPLE + "of 3 blocks from where it is");
        BL.add(ChatColor.DARK_PURPLE + "placed will be pushed away!");
        BL.add(ChatColor.RED + "One Time Use!");
        BL.add(ChatColor.RED + "10s cooldown!");
        SI.setLore(BL);
        SI.addItemFlags(ItemFlag.HIDE_UNBREAKABLE);
        InstaBoomTNT.setItemMeta(SI);

        return InstaBoomTNT;
    }

    public static ItemStack LifestealStick() {

        ItemStack InstaBoomTNT = new ItemStack(Material.STICK);
        ItemMeta SI = InstaBoomTNT.getItemMeta();
        SI.setDisplayName(ChatColor.GOLD + "" + ChatColor.BOLD + "Lifesteal Stick");
        SI.addEnchant(Enchantment.DURABILITY, 1, false);
        SI.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        List<String> BL = new ArrayList<>();
        BL.add(ChatColor.GOLD + "" + ChatColor.BOLD + "Ability:");
        BL.add(ChatColor.DARK_PURPLE + "When you hit a player");
        BL.add(ChatColor.DARK_PURPLE + "You will heal " + ChatColor.RED + "1❤");
        BL.add(ChatColor.RED + "2s Cooldown!");
        SI.setLore(BL);
        InstaBoomTNT.setItemMeta(SI);

        return InstaBoomTNT;
    }

    public static ItemStack powerStick() {

        ItemStack powerStick = new ItemStack(Material.STICK);
        ItemMeta SI = powerStick.getItemMeta();
        SI.addEnchant(Enchantment.DURABILITY, 1, false);
        SI.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        SI.setDisplayName(ChatColor.GOLD + "" + ChatColor.BOLD + "Power Stick");
        SI.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
        List<String> BL = new ArrayList<>();
        BL.add(ChatColor.DARK_PURPLE + "Used For Crafting");
        SI.setLore(BL);
        SI.addItemFlags(ItemFlag.HIDE_UNBREAKABLE);
        powerStick.setItemMeta(SI);

        return powerStick;
    }


    public static ItemStack heavyNetherStar() {

        ItemStack powerStick = new ItemStack(Material.NETHER_STAR);
        ItemMeta SI = powerStick.getItemMeta();
        SI.addEnchant(Enchantment.DURABILITY, 1, false);
        SI.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        SI.setDisplayName(ChatColor.GOLD + "" + ChatColor.BOLD + "Heavy Nether Star");
        SI.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
        List<String> BL = new ArrayList<>();
        BL.add(ChatColor.DARK_PURPLE + "Used For Crafting");
        SI.setLore(BL);
        SI.addItemFlags(ItemFlag.HIDE_UNBREAKABLE);
        powerStick.setItemMeta(SI);

        return powerStick;
    }


    public static ItemStack QuarryArmor_CP() {
        ItemStack StarDustMineChest = new ItemStack(Material.LEATHER_CHESTPLATE);
        LeatherArmorMeta chest = (LeatherArmorMeta) StarDustMineChest.getItemMeta();
        chest.setColor(Color.BLUE);
        chest.addEnchant(Enchantment.DURABILITY, 3, true);
        chest.setDisplayName(ChatColor.GOLD + "" + ChatColor.BOLD + "Quarry Chestplate");
        List<String> SCL = new ArrayList<>();
        SCL.add(" ");
        SCL.add(ChatColor.GOLD + "" + ChatColor.BOLD + "Full Set Bonus:");
        SCL.add(ChatColor.DARK_PURPLE + "Gain +1 extra of any ore you mine.");
        SCL.add(ChatColor.DARK_PURPLE + "You also have unlimited haste 3.");
        SCL.add(" ");
        chest.setLore(SCL);
        chest.addItemFlags(ItemFlag.HIDE_DYE);
        StarDustMineChest.setItemMeta(chest);

        return StarDustMineChest;
    }


    public static ItemStack QuarryArmor_LEGS() {
        ItemStack StarDustMineChest = new ItemStack(Material.LEATHER_LEGGINGS);
        LeatherArmorMeta chest = (LeatherArmorMeta) StarDustMineChest.getItemMeta();
        chest.setColor(Color.BLUE);
        chest.addEnchant(Enchantment.DURABILITY, 3, true);
        chest.setDisplayName(ChatColor.GOLD + "" + ChatColor.BOLD + "Quarry Leggings");
        List<String> SCL = new ArrayList<>();
        SCL.add(" ");
        SCL.add(ChatColor.GOLD + "" + ChatColor.BOLD + "Full Set Bonus:");
        SCL.add(ChatColor.DARK_PURPLE + "Gain +1 extra of any ore you mine.");
        SCL.add(ChatColor.DARK_PURPLE + "You also have unlimited haste 3.");
        SCL.add(" ");
        chest.setLore(SCL);
        chest.addItemFlags(ItemFlag.HIDE_DYE);
        StarDustMineChest.setItemMeta(chest);

        return StarDustMineChest;
    }

    public static ItemStack QuarryArmor_HELM() {
        ItemStack StarDustMineChest = new ItemStack(Material.LEATHER_HELMET);
        LeatherArmorMeta chest = (LeatherArmorMeta) StarDustMineChest.getItemMeta();
        chest.setColor(Color.BLUE);
        chest.addEnchant(Enchantment.DURABILITY, 3, true);
        chest.setDisplayName(ChatColor.GOLD + "" + ChatColor.BOLD + "Quarry Helmet");
        List<String> SCL = new ArrayList<>();
        SCL.add(" ");
        SCL.add(ChatColor.GOLD + "" + ChatColor.BOLD + "Full Set Bonus:");
        SCL.add(ChatColor.DARK_PURPLE + "Gain +1 extra of any ore you mine.");
        SCL.add(ChatColor.DARK_PURPLE + "You also have unlimited haste 3.");
        SCL.add(" ");
        chest.setLore(SCL);
        chest.addItemFlags(ItemFlag.HIDE_DYE);
        StarDustMineChest.setItemMeta(chest);

        return StarDustMineChest;
    }

    public static ItemStack QuarryArmor_BOOTS() {
        ItemStack StarDustMineChest = new ItemStack(Material.LEATHER_BOOTS);
        LeatherArmorMeta chest = (LeatherArmorMeta) StarDustMineChest.getItemMeta();
        chest.setColor(Color.BLUE);
        chest.addEnchant(Enchantment.DURABILITY, 3, true);
        chest.setDisplayName(ChatColor.GOLD + "" + ChatColor.BOLD + "Quarry Boots");
        List<String> SCL = new ArrayList<>();
        SCL.add(" ");
        SCL.add(ChatColor.GOLD + "" + ChatColor.BOLD + "Full Set Bonus:");
        SCL.add(ChatColor.DARK_PURPLE + "Gain +1 extra of any ore you mine.");
        SCL.add(ChatColor.DARK_PURPLE + "You also have unlimited haste 3.");
        SCL.add(" ");
        chest.setLore(SCL);
        chest.addItemFlags(ItemFlag.HIDE_DYE);
        StarDustMineChest.setItemMeta(chest);

        return StarDustMineChest;
    }

    public static ItemStack somberCrystal() {

        ItemStack powerStick = new ItemStack(Material.ECHO_SHARD);
        ItemMeta SI = powerStick.getItemMeta();
        SI.addEnchant(Enchantment.DURABILITY, 1, false);
        SI.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        SI.setDisplayName(ChatColor.GOLD + "" + ChatColor.BOLD + "Somber Crystal");
        SI.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
        List<String> BL = new ArrayList<>();
        BL.add(ChatColor.GOLD + "" + ChatColor.BOLD + "Hit A Player:");
        BL.add(ChatColor.DARK_PURPLE + "Disables totems of undying on someone for 2min");
        BL.add(ChatColor.RED + "One time use!");
        SI.setLore(BL);
        SI.addItemFlags(ItemFlag.HIDE_UNBREAKABLE);
        powerStick.setItemMeta(SI);

        return powerStick;
    }


    public static ItemStack musicBox() {

        ItemStack powerStick = new ItemStack(Material.NOTE_BLOCK);
        ItemMeta SI = powerStick.getItemMeta();
        SI.addEnchant(Enchantment.DURABILITY, 1, false);
        SI.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        SI.setDisplayName(ChatColor.GOLD + "" + ChatColor.BOLD + "Music Box");
        List<String> BL = new ArrayList<>();
        BL.add(ChatColor.GOLD + "" + ChatColor.BOLD + "Right Click:");
        BL.add(ChatColor.DARK_PURPLE + "Lets you play any music disc.");
        SI.setLore(BL);
        SI.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
        SI.addItemFlags(ItemFlag.HIDE_UNBREAKABLE);
        powerStick.setItemMeta(SI);

        return powerStick;
    }

    public static ItemStack magicStaff() {

        ItemStack powerStick = new ItemStack(Material.STICK);
        ItemMeta SI = powerStick.getItemMeta();
        SI.addEnchant(Enchantment.DURABILITY, 1, false);
        SI.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        SI.setDisplayName(ChatColor.GOLD + "" + ChatColor.BOLD + "Magic Staff");
        List<String> BL = new ArrayList<>();
        BL.add(ChatColor.GOLD + "" + ChatColor.BOLD + "Left Click:");
        BL.add(ChatColor.DARK_PURPLE + "Shoots a beam of power dealing " + ChatColor.RED + "1❤");
        BL.add(ChatColor.RED + "3s cooldown!");
        SI.setLore(BL);
        SI.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
        SI.addItemFlags(ItemFlag.HIDE_UNBREAKABLE);
        powerStick.setItemMeta(SI);

        return powerStick;
    }



}
