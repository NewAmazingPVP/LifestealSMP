package newamazingpvp.lifestealsmp.command;

import org.bukkit.ChatColor;
import org.bukkit.Sound;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class AddHPADMINONLY implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (!(sender instanceof Player)) {
            sender.sendMessage(ChatColor.RED + "This command can only be executed by players.");
            return true;
        }

        if (args.length == 1) {
            try {
                int amount = Integer.parseInt(args[0]);

                Player player = (Player) sender;
                player.setMaxHealth(player.getMaxHealth() + amount);
                player.sendMessage(ChatColor.GREEN + "+" + amount + "hp");
                player.playSound(player.getLocation(), Sound.BLOCK_NOTE_BLOCK_PLING, 1.0f, 2.0f);

            } catch (NumberFormatException e) {
                Player player = (Player) sender;
                player.setMaxHealth(player.getMaxHealth() + 1);
                player.sendMessage(ChatColor.GREEN + "+1hp");
                player.playSound(player.getLocation(), Sound.BLOCK_NOTE_BLOCK_PLING, 1.0f, 2.0f);
            }
        } else {
            Player player = (Player) sender;
            player.setMaxHealth(player.getMaxHealth() + 1);
            player.sendMessage(ChatColor.GREEN + "+1hp");
            player.playSound(player.getLocation(), Sound.BLOCK_NOTE_BLOCK_PLING, 1.0f, 2.0f);
        }

        return true;
    }

}
