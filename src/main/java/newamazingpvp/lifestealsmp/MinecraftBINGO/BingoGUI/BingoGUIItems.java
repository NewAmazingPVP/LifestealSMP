package newamazingpvp.lifestealsmp.MinecraftBINGO.BingoGUI;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;
import java.util.List;

public class BingoGUIItems {

    public static ItemStack orangeGlassGUI(){
        ItemStack ITEM = new ItemStack(Material.ORANGE_STAINED_GLASS_PANE);
        ItemMeta META = ITEM.getItemMeta();
        META.setDisplayName(" ");
        ITEM.setItemMeta(META);
        return ITEM;
    }

    public static ItemStack noChallengeGenerated(){
        ItemStack ITEM = new ItemStack(Material.BARRIER);
        ItemMeta META = ITEM.getItemMeta();
        META.setDisplayName(ChatColor.DARK_RED + "" + ChatColor.BOLD + "No Challenge Generated!");
        ITEM.setItemMeta(META);
        return ITEM;
    }

    public static ItemStack openBingoCard(){
        ItemStack ITEM = new ItemStack(Material.PAINTING);
        ItemMeta meta = ITEM.getItemMeta();
        meta.addEnchant(Enchantment.DURABILITY, 1, false);
        meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        meta.setDisplayName(ChatColor.LIGHT_PURPLE + "" + ChatColor.BOLD + "Open Bingo Card");
        meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
        ITEM.setItemMeta(meta);
        return ITEM;
    }

    public static ItemStack BingoPickaxeGUI(){
        ItemStack ITEM = new ItemStack(Material.IRON_PICKAXE);
        ItemMeta meta = ITEM.getItemMeta();
        meta.addEnchant(Enchantment.DURABILITY, 1, false);
        meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        meta.setUnbreakable(true);
        meta.addItemFlags(ItemFlag.HIDE_UNBREAKABLE);
        meta.setDisplayName(ChatColor.GOLD + "" + ChatColor.BOLD + "Bingo Pickaxe");
        meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
        List<String> LORE = new ArrayList<>();
        LORE.add(ChatColor.YELLOW + "Click To View Recipe");
        meta.setLore(LORE);
        ITEM.setItemMeta(meta);
        return ITEM;
    }

    public static ItemStack BingoInfo(){
        ItemStack ITEM = new ItemStack(Material.REDSTONE_TORCH);
        ItemMeta meta = ITEM.getItemMeta();
        meta.addEnchant(Enchantment.DURABILITY, 1, false);
        meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        meta.setUnbreakable(true);
        meta.addItemFlags(ItemFlag.HIDE_UNBREAKABLE);
        meta.setDisplayName(ChatColor.BLUE + "" + ChatColor.BOLD + "Info");
        meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
        List<String> LORE = new ArrayList<>();
        LORE.add(ChatColor.LIGHT_PURPLE + "PUT INFO HERE");
        meta.setLore(LORE);
        ITEM.setItemMeta(meta);
        return ITEM;
    }

    public static ItemStack backGUI(){
        ItemStack ITEM = new ItemStack(Material.ARROW);
        ItemMeta META = ITEM.getItemMeta();
        META.setDisplayName(ChatColor.GREEN + "" + ChatColor.BOLD + "Go Back");
        ITEM.setItemMeta(META);
        return ITEM;
    }

    public static ItemStack closeGUI(){
        ItemStack ITEM = new ItemStack(Material.BARRIER);
        ItemMeta META = ITEM.getItemMeta();
        META.setDisplayName(ChatColor.RED + "" + ChatColor.BOLD + "Close");
        ITEM.setItemMeta(META);
        return ITEM;
    }

    public static ItemStack CopperIngotGUI(){
        ItemStack ITEM = new ItemStack(Material.COPPER_INGOT);
        return ITEM;
    }

    public static ItemStack StickGUI(){
        ItemStack ITEM = new ItemStack(Material.STICK);
        return ITEM;
    }

}
