package newamazingpvp.lifestealsmp.command;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Sound;
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
            player.sendMessage(ChatColor.GREEN + "+" + amount + "hp");
            player.playSound(player.getLocation(), Sound.BLOCK_NOTE_BLOCK_PLING, 1.0f, 2.0f);

        } else if (args.length == 2){
            int amount = Integer.parseInt(args[1]);

            Player player = Bukkit.getPlayer(args[0]);
            if(player == null) return false;
            player.setMaxHealth(player.getMaxHealth() + amount);
            //player.sendMessage(ChatColor.GREEN + "+" + amount + "hp");
            //player.playSound(player.getLocation(), Sound.BLOCK_NOTE_BLOCK_PLING, 1.0f, 2.0f);
        }

        return true;
    }

}
