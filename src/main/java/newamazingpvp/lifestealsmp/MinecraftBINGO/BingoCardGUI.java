package newamazingpvp.lifestealsmp.MinecraftBINGO;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;

public class BingoCardGUI {

    public static void OpenTheBingoCardGUI(Player player){

        Inventory bingoCardGIU = Bukkit.createInventory(player, 54, ChatColor.GOLD + "" + ChatColor.BOLD + "Bingo Card");

        player.openInventory(bingoCardGIU);

    }

}
