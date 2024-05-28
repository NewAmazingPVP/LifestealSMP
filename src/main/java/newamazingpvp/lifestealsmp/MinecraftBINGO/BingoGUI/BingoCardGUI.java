package newamazingpvp.lifestealsmp.MinecraftBINGO.BingoGUI;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;

import static newamazingpvp.lifestealsmp.MinecraftBINGO.BingoGUI.BingoGUIItems.*;
import static newamazingpvp.lifestealsmp.MinecraftBINGO.GenerateBingoCard.*;

public class BingoCardGUI {

    public static void OpenTheBingoCardGUI(Player player){

        Inventory bingoCardGUI = Bukkit.createInventory(player, 54, ChatColor.GOLD + "" + ChatColor.BOLD + "Bingo Card");

        bingoCardGUI.setItem(0,orangeGlassGUI());
        bingoCardGUI.setItem(1,orangeGlassGUI());
        bingoCardGUI.setItem(2,bingo1);
        bingoCardGUI.setItem(3,bingo2);
        bingoCardGUI.setItem(4,bingo3);
        bingoCardGUI.setItem(5,bingo4);
        bingoCardGUI.setItem(6,bingo5);
        bingoCardGUI.setItem(7,orangeGlassGUI());
        bingoCardGUI.setItem(8,orangeGlassGUI());

        bingoCardGUI.setItem(9,orangeGlassGUI());
        bingoCardGUI.setItem(10,orangeGlassGUI());
        bingoCardGUI.setItem(11,bingo6);
        bingoCardGUI.setItem(12,bingo7);
        bingoCardGUI.setItem(13,bingo8);
        bingoCardGUI.setItem(14,bingo9);
        bingoCardGUI.setItem(15,bingo10);
        bingoCardGUI.setItem(16,orangeGlassGUI());
        bingoCardGUI.setItem(17,orangeGlassGUI());

        bingoCardGUI.setItem(18,orangeGlassGUI());
        bingoCardGUI.setItem(19,orangeGlassGUI());
        bingoCardGUI.setItem(20,bingo11);
        bingoCardGUI.setItem(21,bingo12);
        bingoCardGUI.setItem(22,bingo13);
        bingoCardGUI.setItem(23,bingo14);
        bingoCardGUI.setItem(24,bingo15);
        bingoCardGUI.setItem(25,orangeGlassGUI());
        bingoCardGUI.setItem(26,orangeGlassGUI());

        bingoCardGUI.setItem(27,orangeGlassGUI());
        bingoCardGUI.setItem(28,orangeGlassGUI());
        bingoCardGUI.setItem(29,bingo16);
        bingoCardGUI.setItem(30,bingo17);
        bingoCardGUI.setItem(31,bingo18);
        bingoCardGUI.setItem(32,bingo19);
        bingoCardGUI.setItem(33,bingo20);
        bingoCardGUI.setItem(34,orangeGlassGUI());
        bingoCardGUI.setItem(35,orangeGlassGUI());

        bingoCardGUI.setItem(36,orangeGlassGUI());
        bingoCardGUI.setItem(37,orangeGlassGUI());
        bingoCardGUI.setItem(38,bingo21);
        bingoCardGUI.setItem(39,bingo22);
        bingoCardGUI.setItem(40,bingo23);
        bingoCardGUI.setItem(41,bingo24);
        bingoCardGUI.setItem(42,bingo25);
        bingoCardGUI.setItem(43,orangeGlassGUI());
        bingoCardGUI.setItem(44,orangeGlassGUI());

        bingoCardGUI.setItem(45,backGUI());
        bingoCardGUI.setItem(46,orangeGlassGUI());
        bingoCardGUI.setItem(47,orangeGlassGUI());
        bingoCardGUI.setItem(48,orangeGlassGUI());
        bingoCardGUI.setItem(49,orangeGlassGUI());
        bingoCardGUI.setItem(50,orangeGlassGUI());
        bingoCardGUI.setItem(51,orangeGlassGUI());
        bingoCardGUI.setItem(52,orangeGlassGUI());
        bingoCardGUI.setItem(53,closeGUI());


        player.openInventory(bingoCardGUI);

    }

}
