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

    private static ItemStack corruptedCoreT1 () {

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


    private static ItemStack corruptedCoreT2 () {

        PlayerProfile profile = getProfile("https://textures.minecraft.net/texture/b6a77689a73f39cd9c5f56c8e002ed7c76ea4a905c56a767adfd83cb2ea1f2c4");
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

    private static ItemStack corruptedCoreT3 () {

        PlayerProfile profile = getProfile("https://textures.minecraft.net/texture/b6a77689a73f39cd9c5f56c8e002ed7c76ea4a905c56a767adfd83cb2ea1f2c4");
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

    private static ItemStack corruptedCoreT4 () {

        PlayerProfile profile = getProfile("https://textures.minecraft.net/texture/b6a77689a73f39cd9c5f56c8e002ed7c76ea4a905c56a767adfd83cb2ea1f2c4");
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

    private static ItemStack corruptedCoreT5 () {

        PlayerProfile profile = getProfile("https://textures.minecraft.net/texture/b6a77689a73f39cd9c5f56c8e002ed7c76ea4a905c56a767adfd83cb2ea1f2c4");
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
