package newamazingpvp.lifestealsmp.command;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;

import static newamazingpvp.lifestealsmp.customitems.MagicStaffs.MagicStaffUtils.MagicStaffItemstacks.magicStaffAir;
import static newamazingpvp.lifestealsmp.customitems.MagicStaffs.MagicStaffUtils.MagicStaffItemstacks.magicStaffDefault;
import static newamazingpvp.lifestealsmp.wip.mcbingo.GenerateBingoCard.generatedChallenges;
import static newamazingpvp.lifestealsmp.wip.mcbingo.gui.BingoGUIItems.*;
import static newamazingpvp.lifestealsmp.wip.mcbingo.gui.BingoGUIItems.orangeGlassGUI;

public class OpenMagicStaffMenuADMIN implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (sender instanceof Player) {

            Player player = (Player) sender;

            Inventory bingoCardGUI = Bukkit.createInventory(player, 54, ChatColor.LIGHT_PURPLE + "" + ChatColor.BOLD + "Magic Wand Admin Menu");

            bingoCardGUI.setItem(0, orangeGlassGUI());
            bingoCardGUI.setItem(1, orangeGlassGUI());
            bingoCardGUI.setItem(2, orangeGlassGUI());
            bingoCardGUI.setItem(3, orangeGlassGUI());
            bingoCardGUI.setItem(4, orangeGlassGUI());
            bingoCardGUI.setItem(5, orangeGlassGUI());
            bingoCardGUI.setItem(6, orangeGlassGUI());
            bingoCardGUI.setItem(7, orangeGlassGUI());
            bingoCardGUI.setItem(8, orangeGlassGUI());

            bingoCardGUI.setItem(9, orangeGlassGUI());
            bingoCardGUI.setItem(10, magicStaffDefault());
            bingoCardGUI.setItem(11, magicStaffAir());
            //bingoCardGUI.setItem(12, generatedChallenges.get(6));
            //bingoCardGUI.setItem(13, generatedChallenges.get(7));
            //bingoCardGUI.setItem(14, generatedChallenges.get(8));
            //bingoCardGUI.setItem(15, generatedChallenges.get(9));
            //bingoCardGUI.setItem(16, orangeGlassGUI());
            bingoCardGUI.setItem(17, orangeGlassGUI());

            bingoCardGUI.setItem(18, orangeGlassGUI());
            //bingoCardGUI.setItem(19, orangeGlassGUI());
            //bingoCardGUI.setItem(20, generatedChallenges.get(10));
            //bingoCardGUI.setItem(21, generatedChallenges.get(11));
            //bingoCardGUI.setItem(22, generatedChallenges.get(12));
            //bingoCardGUI.setItem(23, generatedChallenges.get(13));
            //bingoCardGUI.setItem(24, generatedChallenges.get(14));
            //bingoCardGUI.setItem(25, orangeGlassGUI());
            bingoCardGUI.setItem(26, orangeGlassGUI());

            bingoCardGUI.setItem(27, orangeGlassGUI());
            //bingoCardGUI.setItem(28, orangeGlassGUI());
            //bingoCardGUI.setItem(29, generatedChallenges.get(15));
            //bingoCardGUI.setItem(30, generatedChallenges.get(16));
            //bingoCardGUI.setItem(31, generatedChallenges.get(17));
            //bingoCardGUI.setItem(32, generatedChallenges.get(18));
            //bingoCardGUI.setItem(33, generatedChallenges.get(19));
            //bingoCardGUI.setItem(34, orangeGlassGUI());
            bingoCardGUI.setItem(35, orangeGlassGUI());

            bingoCardGUI.setItem(36, orangeGlassGUI());
            //bingoCardGUI.setItem(37, orangeGlassGUI());
            //bingoCardGUI.setItem(38, generatedChallenges.get(20));
            //bingoCardGUI.setItem(39, generatedChallenges.get(21));
            //bingoCardGUI.setItem(40, generatedChallenges.get(22));
            //bingoCardGUI.setItem(41, generatedChallenges.get(23));
            //bingoCardGUI.setItem(42, generatedChallenges.get(24));
            //bingoCardGUI.setItem(43, orangeGlassGUI());
            bingoCardGUI.setItem(44, orangeGlassGUI());

            bingoCardGUI.setItem(45, orangeGlassGUI());
            bingoCardGUI.setItem(46, orangeGlassGUI());
            bingoCardGUI.setItem(47, orangeGlassGUI());
            bingoCardGUI.setItem(48, orangeGlassGUI());
            bingoCardGUI.setItem(49, orangeGlassGUI());
            bingoCardGUI.setItem(50, orangeGlassGUI());
            bingoCardGUI.setItem(51, orangeGlassGUI());
            bingoCardGUI.setItem(52, orangeGlassGUI());
            bingoCardGUI.setItem(53, orangeGlassGUI());


            player.openInventory(bingoCardGUI);




        }
        return true;
    }
}

