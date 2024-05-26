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


    //TODO: list of challenge ideas
    //kill end dragon
    //kill wither
    //kill a player who is standing on X block
    //kill a player in X armor
    //kill X amount of X mob
    //eat X amount of X food
    //travel 50,000 total blocks in the over world resets if u change dimencions
    //get 5 dif randomly decided potion effects
    //break a diamond chestplate
    //only use leather armor for 1h
    //break X amount of X block with bingo pick
    //break X amount of any block with bingo pick
    //eat 2 golden apples
    //craft X amount of something
    //break a elytra
    //breed X amount of X mod
    //get X amount of XP levels at the same time
    //kill a player in X armor with a crossbow
    //put a full set of curse of binding armor on
    //harvest X amount of X crop
    //use 10 totems of un dyeing
    //find X mob head
    //kill X amount of X mob in leather armor
    //kill ender dragon in X armor
    //craft X item


}
