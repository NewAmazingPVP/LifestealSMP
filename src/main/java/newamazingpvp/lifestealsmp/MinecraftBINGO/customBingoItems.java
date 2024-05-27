package newamazingpvp.lifestealsmp.MinecraftBINGO;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;
import java.util.List;

public class customBingoItems {

    public static ItemStack BingoCard(){
        ItemStack ITEM = new ItemStack(Material.PAINTING);
        ItemMeta meta = ITEM.getItemMeta();
        meta.addEnchant(Enchantment.DURABILITY, 1, false);
        meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        meta.setDisplayName(ChatColor.GOLD + "" + ChatColor.BOLD + "Bingo Card");
        meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
        List<String> LORE = new ArrayList<>();
        LORE.add(ChatColor.YELLOW + "" + ChatColor.BOLD + "RIGHT CLICK:");
        LORE.add(ChatColor.LIGHT_PURPLE + "Open Bingo Card");
        meta.setLore(LORE);
        ITEM.setItemMeta(meta);
        return ITEM;
    }

    public static ItemStack BingoPickaxe(){
        ItemStack ITEM = new ItemStack(Material.IRON_PICKAXE);
        ItemMeta meta = ITEM.getItemMeta();
        meta.addEnchant(Enchantment.DURABILITY, 1, false);
        meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        meta.setUnbreakable(true);
        meta.addItemFlags(ItemFlag.HIDE_UNBREAKABLE);
        meta.setDisplayName(ChatColor.RED + "" + ChatColor.BOLD + "Bingo Pickaxe");
        meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
        List<String> LORE = new ArrayList<>();
        LORE.add(ChatColor.LIGHT_PURPLE + "Use this pickaxe to do");
        LORE.add(ChatColor.LIGHT_PURPLE + "challenges that require");
        LORE.add(ChatColor.LIGHT_PURPLE + "you to break blocks.");
        LORE.add(ChatColor.DARK_RED + "" + ChatColor.BOLD +  "ALL BLOCKS BROKEN WILL BE DELETED!");
        meta.setLore(LORE);
        ITEM.setItemMeta(meta);
        return ITEM;
    }


    //TODO: list of challenge ideas
    //kill end dragon
    //kill wither
    //kill a player who is standing on X block TODO:make icon
    //kill a player in X armor TODO:make icon
    //kill 500 amount of X mob TODO:make icon
    //eat X amount of X food TODO:make icon
    //travel 50,000 total blocks
    //get X potion effect  TODO:make icon
    //break a diamond chestplate
    //only use leather armor for 2h
    //break X amount of X block with bingo pick TODO:make icon
    //break X amount of any block with bingo pick TODO:make icon
    //eat 2 god apples
    //craft X amount of something TODO:make icon
    //break a elytra
    //breed X amount of X mod TODO:make icon
    //get X amount of XP levels at the same time TODO:make icon
    //kill a player in X armor with a crossbow TODO:make icon
    //put a full set of curse of binding armor on
    //harvest X amount of X crop TODO:make icon
    //use 10 totems of un dyeing
    //find X mob head TODO:make icon
    //kill X amount of enderman in leather armor TODO:make icon
    //kill ender dragon in X armor TODO:make icon

}
