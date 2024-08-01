package newamazingpvp.lifestealsmp.unused.customitems;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;
import java.util.List;

public class ItemStackHelperClass {

    //idk what i was doing this will def not work 100%

    public static ItemStack makeNewItemStack(Material itemType, String itemName, String abilityTriggerType, String abilityDescriptionLine1, String abilityDescriptionLine2, Boolean Glowing, Boolean unbreakable, Boolean hideAttributes) {

        ItemStack ITEM = new ItemStack(itemType);
        ItemMeta META = ITEM.getItemMeta();

        META.setDisplayName(ChatColor.GOLD + "" + ChatColor.BOLD + itemName);

        List<String> LORE = new ArrayList<>();
        LORE.add(ChatColor.GOLD + "" + ChatColor.BOLD + abilityTriggerType + ":");
        LORE.add(ChatColor.DARK_PURPLE + abilityDescriptionLine1);
        LORE.add(ChatColor.DARK_PURPLE + abilityDescriptionLine2);
        META.setLore(LORE);

        if (Glowing) {
            META.addEnchant(Enchantment.UNBREAKING, 1, false);
            META.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        }

        if (unbreakable) {
            META.setUnbreakable(true);
            META.addItemFlags(ItemFlag.HIDE_UNBREAKABLE);
        }

        if (hideAttributes) {
            META.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
        }

        ITEM.setItemMeta(META);


        return ITEM;
    }


}


