package newamazingpvp.lifestealsmp.command;

import org.bukkit.ChatColor;
import org.bukkit.Sound;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import static newamazingpvp.lifestealsmp.game.CustomRecipe.extraHeart;

public class LSwithdraw implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (!(sender instanceof Player)) {
            sender.sendMessage(ChatColor.RED + "This command can only be executed by players.");
            return true;
        }

        Player player = (Player) sender;
        player.setMaxHealth(player.getMaxHealth() - 2);
        player.sendMessage(ChatColor.RED + "" + ChatColor.BOLD + "-1 Heart!");
        player.sendMessage(ChatColor.GRAY + "(Boosting using this command will result in you being banned)");
        player.getInventory().addItem(extraHeart());
        player.playSound(player.getLocation(), Sound.BLOCK_PORTAL_TRIGGER, 1.0f, 2.0f);

        return true;

    }

}
