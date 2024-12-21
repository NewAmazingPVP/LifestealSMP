package newamazingpvp.lifestealsmp.TrimsUpdate;

import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.minimessage.MiniMessage;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;
import java.util.List;

import static newamazingpvp.lifestealsmp.customitems.utils.ItemStacks.gradient;

public class TrimsItemstacks {

    //utils

    public static Component gradient(String itemName) {
        var mm = MiniMessage.miniMessage();
        return mm.deserialize("<bold><gradient:#0045FF:#ADE6FD>" + itemName + "</gradient></bold>");
    }



    //itemstacks
    public static ItemStack sentryTrimArmor() {
        ItemStack homingBow = new ItemStack(Material.SENTRY_ARMOR_TRIM_SMITHING_TEMPLATE);
        ItemMeta meta = homingBow.getItemMeta();
        meta.displayName(gradient("Sentry Armor Trim"));
        List<String> lore = new ArrayList<>();
        lore.add(" ");
        lore.add(ChatColor.GOLD + "" + ChatColor.BOLD + "Special Ability:");
        lore.add(ChatColor.DARK_PURPLE + "does something... idk");
        meta.setLore(lore);
        homingBow.setItemMeta(meta);
        return homingBow;
    }


}
