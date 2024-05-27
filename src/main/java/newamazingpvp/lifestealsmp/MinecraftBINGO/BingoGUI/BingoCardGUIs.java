package newamazingpvp.lifestealsmp.MinecraftBINGO.BingoGUI;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

import static newamazingpvp.lifestealsmp.MinecraftBINGO.BingoGUI.BingoGUIItems.*;
import static newamazingpvp.lifestealsmp.MinecraftBINGO.customBingoItems.BingoPickaxe;

public class BingoCardGUIs {


    //creates items for GUI





    //creates GUI and opens it
    public static void OpenTheBingoCardGUI(Player player){

        Inventory bingoCardGUI = Bukkit.createInventory(player, 54, ChatColor.GOLD + "" + ChatColor.BOLD + "Bingo Card");

        bingoCardGUI.setItem(0,orangeGlassGUI());
        bingoCardGUI.setItem(1,orangeGlassGUI());
        bingoCardGUI.setItem(2,noChallengeGenerated());
        bingoCardGUI.setItem(3,noChallengeGenerated());
        bingoCardGUI.setItem(4,noChallengeGenerated());
        bingoCardGUI.setItem(5,noChallengeGenerated());
        bingoCardGUI.setItem(6,noChallengeGenerated());
        bingoCardGUI.setItem(7,orangeGlassGUI());
        bingoCardGUI.setItem(8,orangeGlassGUI());

        bingoCardGUI.setItem(9,orangeGlassGUI());
        bingoCardGUI.setItem(10,orangeGlassGUI());
        bingoCardGUI.setItem(11,noChallengeGenerated());
        bingoCardGUI.setItem(12,noChallengeGenerated());
        bingoCardGUI.setItem(13,noChallengeGenerated());
        bingoCardGUI.setItem(14,noChallengeGenerated());
        bingoCardGUI.setItem(15,noChallengeGenerated());
        bingoCardGUI.setItem(16,orangeGlassGUI());
        bingoCardGUI.setItem(17,orangeGlassGUI());

        bingoCardGUI.setItem(18,orangeGlassGUI());
        bingoCardGUI.setItem(19,orangeGlassGUI());
        bingoCardGUI.setItem(20,noChallengeGenerated());
        bingoCardGUI.setItem(21,noChallengeGenerated());
        bingoCardGUI.setItem(22,noChallengeGenerated());
        bingoCardGUI.setItem(23,noChallengeGenerated());
        bingoCardGUI.setItem(24,noChallengeGenerated());
        bingoCardGUI.setItem(25,orangeGlassGUI());
        bingoCardGUI.setItem(26,orangeGlassGUI());

        bingoCardGUI.setItem(27,orangeGlassGUI());
        bingoCardGUI.setItem(28,orangeGlassGUI());
        bingoCardGUI.setItem(29,noChallengeGenerated());
        bingoCardGUI.setItem(30,noChallengeGenerated());
        bingoCardGUI.setItem(31,noChallengeGenerated());
        bingoCardGUI.setItem(32,noChallengeGenerated());
        bingoCardGUI.setItem(33,noChallengeGenerated());
        bingoCardGUI.setItem(34,orangeGlassGUI());
        bingoCardGUI.setItem(35,orangeGlassGUI());

        bingoCardGUI.setItem(36,orangeGlassGUI());
        bingoCardGUI.setItem(37,orangeGlassGUI());
        bingoCardGUI.setItem(38,noChallengeGenerated());
        bingoCardGUI.setItem(39,noChallengeGenerated());
        bingoCardGUI.setItem(40,noChallengeGenerated());
        bingoCardGUI.setItem(41,noChallengeGenerated());
        bingoCardGUI.setItem(42,noChallengeGenerated());
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
        bingoMainGUI.setItem(26,closeGUI());




        player.openInventory(bingoMainGUI);

    }


    public static void BingoPickaxeRecipeGUI(Player player){

        Inventory BingoPickaxeRecipeGUI = Bukkit.createInventory(player, 45, ChatColor.GOLD + "" + ChatColor.BOLD + "Bingo Pickaxe Recipe");

        BingoPickaxeRecipeGUI.setItem(0,orangeGlassGUI());
        BingoPickaxeRecipeGUI.setItem(1,orangeGlassGUI());
        BingoPickaxeRecipeGUI.setItem(2,orangeGlassGUI());
        BingoPickaxeRecipeGUI.setItem(3,orangeGlassGUI());
        BingoPickaxeRecipeGUI.setItem(4,orangeGlassGUI());
        BingoPickaxeRecipeGUI.setItem(5,orangeGlassGUI());
        BingoPickaxeRecipeGUI.setItem(6,orangeGlassGUI());
        BingoPickaxeRecipeGUI.setItem(7,orangeGlassGUI());
        BingoPickaxeRecipeGUI.setItem(8,orangeGlassGUI());

        BingoPickaxeRecipeGUI.setItem(9,orangeGlassGUI());
        BingoPickaxeRecipeGUI.setItem(10,orangeGlassGUI());
        BingoPickaxeRecipeGUI.setItem(11,CopperIngotGUI());
        BingoPickaxeRecipeGUI.setItem(12,CopperIngotGUI());
        BingoPickaxeRecipeGUI.setItem(13,CopperIngotGUI());
        BingoPickaxeRecipeGUI.setItem(14,orangeGlassGUI());
        BingoPickaxeRecipeGUI.setItem(15,orangeGlassGUI());
        BingoPickaxeRecipeGUI.setItem(16,orangeGlassGUI());
        BingoPickaxeRecipeGUI.setItem(17,orangeGlassGUI());

        BingoPickaxeRecipeGUI.setItem(18,orangeGlassGUI());
        BingoPickaxeRecipeGUI.setItem(19,orangeGlassGUI());
        //BingoPickaxeRecipeGUI.setItem(20,orangeGlassGUI());
        BingoPickaxeRecipeGUI.setItem(21,StickGUI());
        //BingoPickaxeRecipeGUI.setItem(22,orangeGlassGUI());
        BingoPickaxeRecipeGUI.setItem(23,orangeGlassGUI());
        BingoPickaxeRecipeGUI.setItem(24,BingoPickaxe());
        BingoPickaxeRecipeGUI.setItem(25,orangeGlassGUI());
        BingoPickaxeRecipeGUI.setItem(26,orangeGlassGUI());

        BingoPickaxeRecipeGUI.setItem(27,orangeGlassGUI());
        BingoPickaxeRecipeGUI.setItem(28,orangeGlassGUI());
        //BingoPickaxeRecipeGUI.setItem(29,orangeGlassGUI());
        BingoPickaxeRecipeGUI.setItem(30,StickGUI());
        //BingoPickaxeRecipeGUI.setItem(31,orangeGlassGUI());
        BingoPickaxeRecipeGUI.setItem(32,orangeGlassGUI());
        BingoPickaxeRecipeGUI.setItem(33,orangeGlassGUI());
        BingoPickaxeRecipeGUI.setItem(34,orangeGlassGUI());
        BingoPickaxeRecipeGUI.setItem(35,orangeGlassGUI());

        BingoPickaxeRecipeGUI.setItem(36,backGUI());
        BingoPickaxeRecipeGUI.setItem(37,orangeGlassGUI());
        BingoPickaxeRecipeGUI.setItem(38,orangeGlassGUI());
        BingoPickaxeRecipeGUI.setItem(39,orangeGlassGUI());
        BingoPickaxeRecipeGUI.setItem(40,orangeGlassGUI());
        BingoPickaxeRecipeGUI.setItem(41,orangeGlassGUI());
        BingoPickaxeRecipeGUI.setItem(42,orangeGlassGUI());
        BingoPickaxeRecipeGUI.setItem(43,orangeGlassGUI());
        BingoPickaxeRecipeGUI.setItem(44,closeGUI());



        player.openInventory(BingoPickaxeRecipeGUI);

    }

}
