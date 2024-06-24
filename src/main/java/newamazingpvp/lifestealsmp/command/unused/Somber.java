package newamazingpvp.lifestealsmp.command.unused;

import org.bukkit.Sound;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import static newamazingpvp.lifestealsmp.customitems.item.SomberCrystal.setSomberTimer;

public class Somber implements CommandExecutor {


    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (sender instanceof Player) {
            Player player = (Player) sender;

            setSomberTimer((Player) player);

            player.playSound(player.getLocation(), Sound.BLOCK_GLASS_BREAK, 2.0f, 1.0f);
            player.playSound(player.getLocation(), Sound.BLOCK_SCULK_SHRIEKER_SHRIEK, 2.0f, 0.0f);


        }
        return true;
    }
}
