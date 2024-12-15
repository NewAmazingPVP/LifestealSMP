package newamazingpvp.lifestealsmp.NewOrbUpdateTest.OrbUpdateItems;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;
import java.util.List;

import static newamazingpvp.lifestealsmp.customitems.utils.ItemStacks.gradient;

public class OrbUpdateItems {

    public static ItemStack gameBreaker() {
        ItemStack items = new ItemStack(Material.TNT);
        ItemMeta meta = items.getItemMeta();
        meta.displayName(gradient("Game Breaker"));
        List<String> lore = new ArrayList<>();
        lore.add(ChatColor.GOLD + "" + ChatColor.BOLD + "Given to players who report bugs");
        lore.add(ChatColor.GRAY + "Can't be placed");
        meta.setLore(lore);
        items.setItemMeta(meta);
        return items;
    }


}
