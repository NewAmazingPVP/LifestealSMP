package newamazingpvp.lifestealsmp.unused.mcbingo.commands;

import org.bukkit.ChatColor;
import org.bukkit.Sound;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import static newamazingpvp.lifestealsmp.unused.mcbingo.GenerateBingoCard.genBingoCard;

public class CommandNewBingoGame implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (!(sender instanceof Player player)) {
            sender.sendMessage(ChatColor.RED + "This command can only be executed by players.");
            return true;
        }


        player.sendMessage(ChatColor.RED + "" + ChatColor.BOLD + "Generating New Bingo Game!");

        player.playSound(player.getLocation(), Sound.BLOCK_NOTE_BLOCK_PLING, 2.0f, 0.0f);

        genBingoCard(player);


        return true;
    }
}


