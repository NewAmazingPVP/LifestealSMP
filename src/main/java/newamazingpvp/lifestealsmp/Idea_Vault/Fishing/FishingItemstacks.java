package newamazingpvp.lifestealsmp.Idea_Vault.Fishing;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.block.Biome;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;
import java.util.List;

public class FishingItemstacks {



























    //This item when fished up generates into a item you can fish up (gives better control over fishing odds) there may be a better way to do this

    //TODO: Ima def not use this
    public static ItemStack generateNewFishItem(Biome b){
        ItemStack item = new ItemStack(Material.AIR); //TODO: AIR may not work (game sometimes treats it as NULL)
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName(ChatColor.DARK_RED + "GENERATE_NEW_FISH_ITEM");
        List<String> lore = new ArrayList<>();
        lore.add(ChatColor.DARK_RED + "You should not have this item");
        lore.add(ChatColor.DARK_RED + "If you have this, report to Comet99 or NAP");
        lore.add(""+b);
        meta.setLore(lore);
        item.setItemMeta(meta);
        return item;
    }



}
