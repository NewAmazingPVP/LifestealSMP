package newamazingpvp.lifestealsmp.nextSmpHIGH;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Sound;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class quickMaths implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (sender instanceof Player) {
            Player player = (Player) sender;

            boolean canAnswer = false;

            int mathType = 0;

            for (Player soundLOC1 : Bukkit.getServer().getOnlinePlayers()) {
                soundLOC1.playSound(soundLOC1.getLocation(), Sound.ENTITY_EXPERIENCE_ORB_PICKUP, 1.0F, 0.0F);
            }

            Bukkit.broadcastMessage(ChatColor.GRAY + "Loading...");

            if


            Bukkit.broadcastMessage(ChatColor.LIGHT_PURPLE + "" + ChatColor.BOLD + "QUICK MATHS:");
            Bukkit.broadcastMessage(ChatColor.YELLOW + "QUICK MATHS:");
            canAnswer = true;





        } else {
            sender.sendMessage("This command can only be executed by a player.");
        }
        return true;
    }

}
