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
        bingoCardGUI.setItem(2,generatedChallenges.get(0));
        bingoCardGUI.setItem(3,generatedChallenges.get(0));
        bingoCardGUI.setItem(4,generatedChallenges.get(0));
        bingoCardGUI.setItem(5,generatedChallenges.get(0));
        bingoCardGUI.setItem(6,generatedChallenges.get(0));
        bingoCardGUI.setItem(7,orangeGlassGUI());
        bingoCardGUI.setItem(8,orangeGlassGUI());

        bingoCardGUI.setItem(9,orangeGlassGUI());
        bingoCardGUI.setItem(10,orangeGlassGUI());
        bingoCardGUI.setItem(11,generatedChallenges.get(0));
        bingoCardGUI.setItem(12,generatedChallenges.get(0));
        bingoCardGUI.setItem(13,generatedChallenges.get(0));
        bingoCardGUI.setItem(14,generatedChallenges.get(0));
        bingoCardGUI.setItem(15,generatedChallenges.get(0));
        bingoCardGUI.setItem(16,orangeGlassGUI());
        bingoCardGUI.setItem(17,orangeGlassGUI());

        bingoCardGUI.setItem(18,orangeGlassGUI());
        bingoCardGUI.setItem(19,orangeGlassGUI());
        bingoCardGUI.setItem(20,generatedChallenges.get(0));
        bingoCardGUI.setItem(21,generatedChallenges.get(0));
        bingoCardGUI.setItem(22,generatedChallenges.get(0));
        bingoCardGUI.setItem(23,generatedChallenges.get(0));
        bingoCardGUI.setItem(24,generatedChallenges.get(0));
        bingoCardGUI.setItem(25,orangeGlassGUI());
        bingoCardGUI.setItem(26,orangeGlassGUI());

        bingoCardGUI.setItem(27,orangeGlassGUI());
        bingoCardGUI.setItem(28,orangeGlassGUI());
        bingoCardGUI.setItem(29,generatedChallenges.get(0));
        bingoCardGUI.setItem(30,generatedChallenges.get(0));
        bingoCardGUI.setItem(31,generatedChallenges.get(0));
        bingoCardGUI.setItem(32,generatedChallenges.get(0));
        bingoCardGUI.setItem(33,generatedChallenges.get(0));
        bingoCardGUI.setItem(34,orangeGlassGUI());
        bingoCardGUI.setItem(35,orangeGlassGUI());

        bingoCardGUI.setItem(36,orangeGlassGUI());
        bingoCardGUI.setItem(37,orangeGlassGUI());
        bingoCardGUI.setItem(38,generatedChallenges.get(0));
        bingoCardGUI.setItem(39,generatedChallenges.get(0));
        bingoCardGUI.setItem(40,generatedChallenges.get(0));
        bingoCardGUI.setItem(41,generatedChallenges.get(0));
        bingoCardGUI.setItem(42,generatedChallenges.get(0));
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
