package newamazingpvp.lifestealsmp.MinecraftBINGO;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;
import java.util.List;

public class BingoCardGUI {


    //creates items for GUI

    public static ItemStack orangeGlassGUI(){
        ItemStack ITEM = new ItemStack(Material.PINK_STAINED_GLASS_PANE);
        ItemMeta META = ITEM.getItemMeta();
        META.setDisplayName(" ");
        ITEM.setItemMeta(META);
        return ITEM;
    }

    public static ItemStack noChallengeGenerated(){
        ItemStack ITEM = new ItemStack(Material.PINK_STAINED_GLASS_PANE);
        ItemMeta META = ITEM.getItemMeta();
        META.setDisplayName(ChatColor.DARK_RED + "" + ChatColor.BOLD + "No Challenge Generated!");
        ITEM.setItemMeta(META);
        return ITEM;
    }




    //creates GUI and opens it
    public static void OpenTheBingoCardGUI(Player player){

        Inventory bingoCardGUI = Bukkit.createInventory(player, 54, ChatColor.GOLD + "" + ChatColor.BOLD + "Bingo Card");

        bingoCardGUI.setItem(0,orangeGlassGUI());
        bingoCardGUI.setItem(1,orangeGlassGUI());
        bingoCardGUI.setItem(2,orangeGlassGUI());
        bingoCardGUI.setItem(3,orangeGlassGUI());
        bingoCardGUI.setItem(4,orangeGlassGUI());
        bingoCardGUI.setItem(5,orangeGlassGUI());
        bingoCardGUI.setItem(6,orangeGlassGUI());
        bingoCardGUI.setItem(7,orangeGlassGUI());
        bingoCardGUI.setItem(8,orangeGlassGUI());

        bingoCardGUI.setItem(9,orangeGlassGUI());
        bingoCardGUI.setItem(10,noChallengeGenerated());
        bingoCardGUI.setItem(11,noChallengeGenerated());
        bingoCardGUI.setItem(12,noChallengeGenerated());
        bingoCardGUI.setItem(13,noChallengeGenerated());
        bingoCardGUI.setItem(14,orangeGlassGUI());
        bingoCardGUI.setItem(15,orangeGlassGUI());
        bingoCardGUI.setItem(16,orangeGlassGUI());
        bingoCardGUI.setItem(17,orangeGlassGUI());


        player.openInventory(bingoCardGUI);

    }

}
