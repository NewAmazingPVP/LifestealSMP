package newamazingpvp.lifestealsmp.command;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.Arrays;

import static newamazingpvp.lifestealsmp.utility.DiscordBot.sendDiscordMessage;

public class SendDiscordMessage implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (!(sender instanceof Player)) {
            sendDiscordMessage(Arrays.toString(args), "1136353329488875531");
        }

        return true;
    }
}
