package newamazingpvp.lifestealsmp.command;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

import static newamazingpvp.lifestealsmp.utility.DiscordBot.sendDiscordMessage;

public class SendDiscordMessage implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if(args.length == 1){
            sendDiscordMessage(args[0], "0000");
        } else if (args.length == 2){
            sendDiscordMessage(args[0], args[0]);
        }
        return true;
    }
}
