package newamazingpvp.lifestealsmp.command;

import org.bukkit.Bukkit;
import org.bukkit.OfflinePlayer;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import static newamazingpvp.lifestealsmp.game.PlayerLifeManager.revivePlayer;

public class RevivePlayer implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (args.length == 1) {
            OfflinePlayer player = Bukkit.getOfflinePlayer(args[0]);

            revivePlayer(player, (Player) sender);
        }

        return true;
    }
}
