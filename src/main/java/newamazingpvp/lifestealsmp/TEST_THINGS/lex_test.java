package newamazingpvp.lifestealsmp.TEST_THINGS;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityPickupItemEvent;
import org.bukkit.event.player.PlayerItemHeldEvent;
import org.bukkit.event.player.PlayerSwapHandItemsEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import java.util.ArrayList;
import java.util.List;

import static newamazingpvp.lifestealsmp.customitems.utils.ItemStacks.gradient;

public class lex_test implements Listener {

    public static ItemStack fireGemTest() {
        ItemStack ITEM = new ItemStack(Material.NETHERITE_SHOVEL);
        ItemMeta meta = ITEM.getItemMeta();
        meta.displayName(gradient("FIRE GEM TEST"));
        List<String> lore = new ArrayList<>();
        lore.add(ChatColor.GOLD + "" + ChatColor.BOLD + "Special Ability:");
        lore.add(ChatColor.DARK_PURPLE + "test fire gem 111");


        meta.setLore(lore);
        ITEM.setItemMeta(meta);
        return ITEM;
    }



}
