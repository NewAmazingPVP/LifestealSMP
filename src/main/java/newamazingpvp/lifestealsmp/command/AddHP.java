package newamazingpvp.lifestealsmp.command;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class AddHP implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if (args.length == 1) {
            int amount = Integer.parseInt(args[0]);
            Player player = (Player) sender;
            player.setMaxHealth(player.getMaxHealth() + amount);

        } else if (args.length == 2) {
            int amount = Integer.parseInt(args[1]);
            Player player = Bukkit.getPlayer(args[0]);
            if (player == null) return false;
            player.setMaxHealth(player.getMaxHealth() + amount);
        }

        return true;
    }

}
