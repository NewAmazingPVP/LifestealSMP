package newamazingpvp.lifestealsmp.NewOrbUpdateTest.OrbUpdateItems;

import org.bukkit.ChatColor;
import org.bukkit.Color;
import org.bukkit.Material;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.LeatherArmorMeta;

import java.util.ArrayList;
import java.util.List;

public class OrbUpdateArmor {

    public static ItemStack spacesuitITEM(){

        ItemStack chestplate = new ItemStack(Material.LEATHER_CHESTPLATE);
        LeatherArmorMeta chestplateMeta = (LeatherArmorMeta) chestplate.getItemMeta();
        chestplateMeta.setDisplayName(ChatColor.GOLD + "" + ChatColor.BOLD + "Spacesuit");
        chestplateMeta.setColor(Color.fromRGB(255, 85, 0));
        chestplateMeta.setUnbreakable(true);
        List<String> CHESTPLATELORE = new ArrayList<>();
        CHESTPLATELORE.add(ChatColor.AQUA + "Helps you breathe next to void mobs!");
        CHESTPLATELORE.add(ChatColor.AQUA + "Does Not Break!");
        chestplateMeta.setLore(CHESTPLATELORE);
        chestplateMeta.addItemFlags(ItemFlag.HIDE_DYE);
        chestplateMeta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
        chestplateMeta.addItemFlags(ItemFlag.HIDE_UNBREAKABLE);
        chestplate.setItemMeta(chestplateMeta);

        return chestplate;
    }


    public static ItemStack spacesuitLeggings(){

        ItemStack leggings = new ItemStack(Material.LEATHER_LEGGINGS);
        LeatherArmorMeta chestplateMeta = (LeatherArmorMeta) leggings.getItemMeta();
        chestplateMeta.setDisplayName(ChatColor.GOLD + "" + ChatColor.BOLD + "^");
        chestplateMeta.setColor(Color.fromRGB(255, 85, 0));
        chestplateMeta.setUnbreakable(true);
        List<String> CHESTPLATELORE = new ArrayList<>();
        CHESTPLATELORE.add(ChatColor.AQUA + " ");
        chestplateMeta.setLore(CHESTPLATELORE);
        chestplateMeta.addItemFlags(ItemFlag.HIDE_DYE);
        chestplateMeta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
        chestplateMeta.addItemFlags(ItemFlag.HIDE_UNBREAKABLE);
        leggings.setItemMeta(chestplateMeta);

        return leggings;

    }

    public static ItemStack spacesuitBoots(){

        ItemStack boots = new ItemStack(Material.LEATHER_BOOTS);
        LeatherArmorMeta chestplateMeta = (LeatherArmorMeta) boots.getItemMeta();
        chestplateMeta.setDisplayName(ChatColor.GOLD + "" + ChatColor.BOLD + "^");
        chestplateMeta.setColor(Color.fromRGB(255, 85, 0));
        chestplateMeta.setUnbreakable(true);
        List<String> CHESTPLATELORE = new ArrayList<>();
        CHESTPLATELORE.add(ChatColor.AQUA + " ");
        chestplateMeta.setLore(CHESTPLATELORE);
        chestplateMeta.addItemFlags(ItemFlag.HIDE_DYE);
        chestplateMeta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
        chestplateMeta.addItemFlags(ItemFlag.HIDE_UNBREAKABLE);
        boots.setItemMeta(chestplateMeta);

        return boots;

    }

}
