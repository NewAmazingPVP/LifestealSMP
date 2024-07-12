package newamazingpvp.lifestealsmp.CorruptedMobsEvent.Utilitys;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.SkullMeta;
import org.bukkit.profile.PlayerProfile;

import java.util.ArrayList;
import java.util.List;

import static newamazingpvp.lifestealsmp.unused.endfight.custommobs.PublicMobMethods.getProfile;

public class CorruptedMobsItemStacks {

    public static ItemStack corruptedCoreT1 () {

        PlayerProfile profile = getProfile("https://textures.minecraft.net/texture/9e95293acbcd4f55faf5947bfc5135038b275a7ab81087341b9ec6e453e839");
        ItemStack montuHelm = new ItemStack(Material.PLAYER_HEAD);
        SkullMeta meta = (SkullMeta) montuHelm.getItemMeta();
        meta.setDisplayName(ChatColor.GOLD + "" + ChatColor.BOLD + "Corrupted Core" + ChatColor.AQUA + "" + ChatColor.ITALIC + "" + ChatColor.BOLD + " I");
        List<String> lore = new ArrayList<>();
        lore.add(" ");
        lore.add(ChatColor.DARK_PURPLE + "When you kill a mob you have a");
        lore.add(ChatColor.DARK_PURPLE + "chance to spawn a T1 corrupted mob!");
        meta.setLore(lore);
        meta.setOwnerProfile(profile);
        montuHelm.setItemMeta(meta);

        return montuHelm;
    }


    public static ItemStack corruptedCoreT2 () {

        PlayerProfile profile = getProfile("https://textures.minecraft.net/texture/14d844fee24d5f27ddb669438528d83b684d901b75a6889fe7488dfc4cf7a1c");
        ItemStack montuHelm = new ItemStack(Material.PLAYER_HEAD);
        SkullMeta meta = (SkullMeta) montuHelm.getItemMeta();
        meta.setDisplayName(ChatColor.GOLD + "" + ChatColor.BOLD + "Corrupted Core" + ChatColor.AQUA + "" + ChatColor.ITALIC + "" + ChatColor.BOLD + " II");
        List<String> lore = new ArrayList<>();
        lore.add(" ");
        lore.add(ChatColor.DARK_PURPLE + "When you kill a mob you have a");
        lore.add(ChatColor.DARK_PURPLE + "chance to spawn a T2 corrupted mob!");
        meta.setLore(lore);
        meta.setOwnerProfile(profile);
        montuHelm.setItemMeta(meta);

        return montuHelm;
    }

    public static ItemStack corruptedCoreT3 () {

        PlayerProfile profile = getProfile("https://textures.minecraft.net/texture/cbfb41f866e7e8e593659986c9d6e88cd37677b3f7bd44253e5871e66d1d424");
        ItemStack montuHelm = new ItemStack(Material.PLAYER_HEAD);
        SkullMeta meta = (SkullMeta) montuHelm.getItemMeta();
        meta.setDisplayName(ChatColor.GOLD + "" + ChatColor.BOLD + "Corrupted Core" + ChatColor.AQUA + "" + ChatColor.ITALIC + "" + ChatColor.BOLD + " III");
        List<String> lore = new ArrayList<>();
        lore.add(" ");
        lore.add(ChatColor.DARK_PURPLE + "When you kill a mob you have a");
        lore.add(ChatColor.DARK_PURPLE + "chance to spawn a T3 corrupted mob!");
        meta.setLore(lore);
        meta.setOwnerProfile(profile);
        montuHelm.setItemMeta(meta);

        return montuHelm;
    }

    public static ItemStack corruptedCoreT4 () {

        PlayerProfile profile = getProfile("https://textures.minecraft.net/texture/dc9365642c6eddcfedf5b5e14e2bc71257d9e4a3363d123c6f33c55cafbf6d");
        ItemStack montuHelm = new ItemStack(Material.PLAYER_HEAD);
        SkullMeta meta = (SkullMeta) montuHelm.getItemMeta();
        meta.setDisplayName(ChatColor.GOLD + "" + ChatColor.BOLD + "Corrupted Core" + ChatColor.AQUA + "" + ChatColor.ITALIC + "" + ChatColor.BOLD + " IV");
        List<String> lore = new ArrayList<>();
        lore.add(" ");
        lore.add(ChatColor.DARK_PURPLE + "When you kill a mob you have a");
        lore.add(ChatColor.DARK_PURPLE + "chance to spawn a T4 corrupted mob!");
        meta.setLore(lore);
        meta.setOwnerProfile(profile);
        montuHelm.setItemMeta(meta);

        return montuHelm;
    }

    public static ItemStack corruptedCoreT5 () {

        PlayerProfile profile = getProfile("https://textures.minecraft.net/texture/163bcaf6d2679d8d7d9bf6a474a48a77a8e91747a1084c09256ebc86cb74811");
        ItemStack montuHelm = new ItemStack(Material.PLAYER_HEAD);
        SkullMeta meta = (SkullMeta) montuHelm.getItemMeta();
        meta.setDisplayName(ChatColor.GOLD + "" + ChatColor.BOLD + "Corrupted Core" + ChatColor.AQUA + "" + ChatColor.ITALIC + "" + ChatColor.BOLD + " V");
        List<String> lore = new ArrayList<>();
        lore.add(" ");
        lore.add(ChatColor.DARK_PURPLE + "When you kill a mob you have a");
        lore.add(ChatColor.DARK_PURPLE + "chance to spawn a T5 corrupted mob!");
        meta.setLore(lore);
        meta.setOwnerProfile(profile);
        montuHelm.setItemMeta(meta);

        return montuHelm;
    }

}
