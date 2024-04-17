package newamazingpvp.lifestealsmp.runes;

import org.bukkit.ChatColor;
import org.bukkit.Effect;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.SkullMeta;
import org.bukkit.potion.PotionEffect;

import java.util.ArrayList;
import java.util.List;

public class Rune extends ItemStack {

    public Rune(String player, String name, String mob, String ability){
        super(Material.PLAYER_HEAD);
        SkullMeta skullMeta = (SkullMeta) getItemMeta();
        skullMeta.setOwner(player);
        setItemMeta(skullMeta);
        addEnchant(Enchantment.DURABILITY, 1, false);
        addItemFlags(ItemFlag.HIDE_ENCHANTS);
        setDisplayName(ChatColor.LIGHT_PURPLE + "" + ChatColor.MAGIC + "E" + ChatColor.WHITE + ChatColor.BOLD + " " + name + " Rune " + ChatColor.LIGHT_PURPLE + ChatColor.MAGIC + "E");
        addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
        List<String> lore = new ArrayList<>();
        lore.add(ChatColor.DARK_PURPLE + "[Item just needs to be in your inventory]");
        lore.add(ChatColor.YELLOW + "[Very rare chance to drop from " + mob + "]");
        lore.add(" ");
        lore.add(ChatColor.YELLOW + "" + ChatColor.BOLD + name.toUpperCase() + " RUNE ABILITY:");
        lore.add(ChatColor.LIGHT_PURPLE + ability);
        setLore(lore);
    }

    public PotionEffect effect(){
        return null;
    }

}
