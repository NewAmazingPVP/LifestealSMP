package newamazingpvp.lifestealsmp.visuals.CustomToasts;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;


import static newamazingpvp.lifestealsmp.visuals.CustomToasts.ToastWarn.displayToastWarn;

public class ToastWarnCMD implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if (!(sender instanceof Player)) {
            sender.sendMessage(ChatColor.RED + "Only players can use this command!");

        }


        displayToastWarn("test111111111111");

        return true;


    }


}

