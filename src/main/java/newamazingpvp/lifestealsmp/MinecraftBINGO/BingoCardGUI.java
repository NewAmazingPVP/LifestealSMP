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

import static newamazingpvp.lifestealsmp.MinecraftBINGO.BingoGUIItems.*;

public class BingoCardGUI {


    //creates items for GUI





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

        bingoCardGUI.setItem(18,orangeGlassGUI());
        bingoCardGUI.setItem(19,noChallengeGenerated());
        bingoCardGUI.setItem(20,noChallengeGenerated());
        bingoCardGUI.setItem(21,noChallengeGenerated());
        bingoCardGUI.setItem(22,noChallengeGenerated());
        bingoCardGUI.setItem(23,orangeGlassGUI());
        bingoCardGUI.setItem(24,orangeGlassGUI());
        bingoCardGUI.setItem(25,orangeGlassGUI());
        bingoCardGUI.setItem(26,orangeGlassGUI());

        bingoCardGUI.setItem(27,orangeGlassGUI());
        bingoCardGUI.setItem(28,noChallengeGenerated());
        bingoCardGUI.setItem(29,noChallengeGenerated());
        bingoCardGUI.setItem(30,noChallengeGenerated());
        bingoCardGUI.setItem(31,noChallengeGenerated());
        bingoCardGUI.setItem(32,orangeGlassGUI());
        bingoCardGUI.setItem(33,orangeGlassGUI());
        bingoCardGUI.setItem(34,orangeGlassGUI());
        bingoCardGUI.setItem(35,orangeGlassGUI());

        bingoCardGUI.setItem(36,orangeGlassGUI());
        bingoCardGUI.setItem(37,noChallengeGenerated());
        bingoCardGUI.setItem(38,noChallengeGenerated());
        bingoCardGUI.setItem(39,noChallengeGenerated());
        bingoCardGUI.setItem(40,noChallengeGenerated());
        bingoCardGUI.setItem(41,orangeGlassGUI());
        bingoCardGUI.setItem(42,orangeGlassGUI());
        bingoCardGUI.setItem(43,orangeGlassGUI());
        bingoCardGUI.setItem(44,orangeGlassGUI());

        bingoCardGUI.setItem(45,orangeGlassGUI());
        bingoCardGUI.setItem(46,orangeGlassGUI());
        bingoCardGUI.setItem(47,orangeGlassGUI());
        bingoCardGUI.setItem(48,orangeGlassGUI());
        bingoCardGUI.setItem(49,orangeGlassGUI());
        bingoCardGUI.setItem(50,orangeGlassGUI());
        bingoCardGUI.setItem(51,orangeGlassGUI());
        bingoCardGUI.setItem(52,orangeGlassGUI());
        bingoCardGUI.setItem(53,orangeGlassGUI());


        player.openInventory(bingoCardGUI);

    }

    public static void BingoMainMenu(Player player){

        Inventory bingoMainGUI = Bukkit.createInventory(player, 27, ChatColor.GOLD + "" + ChatColor.BOLD + "Bingo");

        bingoMainGUI.setItem(0,orangeGlassGUI());
        bingoMainGUI.setItem(1,orangeGlassGUI());
        bingoMainGUI.setItem(2,orangeGlassGUI());
        bingoMainGUI.setItem(3,orangeGlassGUI());
        bingoMainGUI.setItem(4,orangeGlassGUI());
        bingoMainGUI.setItem(5,orangeGlassGUI());
        bingoMainGUI.setItem(6,orangeGlassGUI());
        bingoMainGUI.setItem(7,orangeGlassGUI());
        bingoMainGUI.setItem(8,orangeGlassGUI());

        bingoMainGUI.setItem(9,orangeGlassGUI());
        bingoMainGUI.setItem(10,orangeGlassGUI());
        bingoMainGUI.setItem(11,BingoInfo());
        bingoMainGUI.setItem(12,orangeGlassGUI());
        bingoMainGUI.setItem(13,openBingoCard());
        bingoMainGUI.setItem(14,orangeGlassGUI());
        bingoMainGUI.setItem(15,BingoPickaxeGUI());
        bingoMainGUI.setItem(16,orangeGlassGUI());
        bingoMainGUI.setItem(17,orangeGlassGUI());

        bingoMainGUI.setItem(18,orangeGlassGUI());
        bingoMainGUI.setItem(19,orangeGlassGUI());
        bingoMainGUI.setItem(20,orangeGlassGUI());
        bingoMainGUI.setItem(21,orangeGlassGUI());
        bingoMainGUI.setItem(22,orangeGlassGUI());
        bingoMainGUI.setItem(23,orangeGlassGUI());
        bingoMainGUI.setItem(24,orangeGlassGUI());
        bingoMainGUI.setItem(25,orangeGlassGUI());
        bingoMainGUI.setItem(26,orangeGlassGUI());




        player.openInventory(bingoMainGUI);

    }

}
