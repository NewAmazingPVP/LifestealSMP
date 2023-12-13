package newamazingpvp.lifestealsmp.command;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Sound;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import static newamazingpvp.lifestealsmp.LifestealSMP.lifestealSmp;

public class RestartWithWarming implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        //Player playerSender = (Player) sender;
        //playerSender.sendMessage(ChatColor.RED + "" + ChatColor.BOLD + "Restarting Server!");
        //playerSender.playSound(playerSender.getLocation(), Sound.BLOCK_NOTE_BLOCK_PLING, 1.0f, 2.0f);

        for (Player player : Bukkit.getOnlinePlayers()) {

            player.sendMessage(ChatColor.RED + "" + ChatColor.BOLD + "WARNING" + ChatColor.YELLOW + " This server instance will be restarting in 1min!");

            player.sendTitle(ChatColor.RED + "" + ChatColor.BOLD + "Server Restart!", "", 0, 70, 20);

            player.playSound(player.getLocation(), Sound.BLOCK_NOTE_BLOCK_PLING, 1.0f, 2.0f);
            Bukkit.getScheduler().runTaskLater(lifestealSmp, () -> player.playSound(player.getLocation(), Sound.BLOCK_NOTE_BLOCK_PLING, 1.0f, 1.0f), 2);
            Bukkit.getScheduler().runTaskLater(lifestealSmp, () -> player.playSound(player.getLocation(), Sound.BLOCK_NOTE_BLOCK_PLING, 1.0f, 2.0f), 4);
            Bukkit.getScheduler().runTaskLater(lifestealSmp, () -> player.playSound(player.getLocation(), Sound.BLOCK_NOTE_BLOCK_PLING, 1.0f, 1.0f), 6);
            Bukkit.getScheduler().runTaskLater(lifestealSmp, () -> player.playSound(player.getLocation(), Sound.BLOCK_NOTE_BLOCK_PLING, 1.0f, 2.0f), 8);
            Bukkit.getScheduler().runTaskLater(lifestealSmp, () -> player.playSound(player.getLocation(), Sound.BLOCK_NOTE_BLOCK_PLING, 1.0f, 1.0f), 10);

            Bukkit.getScheduler().runTaskLater(lifestealSmp, () -> player.playSound(player.getLocation(), Sound.BLOCK_NOTE_BLOCK_PLING, 1.0f, 2.0f), 600);
            Bukkit.getScheduler().runTaskLater(lifestealSmp, () -> player.sendMessage(ChatColor.RED + "" + ChatColor.BOLD + "WARNING" + ChatColor.YELLOW + " This server instance will be restarting in 30sec!"), 600);

            Bukkit.getScheduler().runTaskLater(lifestealSmp, () -> player.playSound(player.getLocation(), Sound.BLOCK_NOTE_BLOCK_PLING, 1.0f, 2.0f), 1000);
            Bukkit.getScheduler().runTaskLater(lifestealSmp, () -> player.sendMessage(ChatColor.RED + "" + ChatColor.BOLD + "WARNING" + ChatColor.YELLOW + " This server instance will be restarting in 10!"), 1000);
            Bukkit.getScheduler().runTaskLater(lifestealSmp, () -> player.sendMessage(ChatColor.RED + "" + ChatColor.BOLD + "WARNING" + ChatColor.YELLOW + " This server instance will be restarting in 9!"), 1020);
            Bukkit.getScheduler().runTaskLater(lifestealSmp, () -> player.sendMessage(ChatColor.RED + "" + ChatColor.BOLD + "WARNING" + ChatColor.YELLOW + " This server instance will be restarting in 8!"), 1040);
            Bukkit.getScheduler().runTaskLater(lifestealSmp, () -> player.sendMessage(ChatColor.RED + "" + ChatColor.BOLD + "WARNING" + ChatColor.YELLOW + " This server instance will be restarting in 7!"), 1060);
            Bukkit.getScheduler().runTaskLater(lifestealSmp, () -> player.sendMessage(ChatColor.RED + "" + ChatColor.BOLD + "WARNING" + ChatColor.YELLOW + " This server instance will be restarting in 6!"), 1080);
            Bukkit.getScheduler().runTaskLater(lifestealSmp, () -> player.sendMessage(ChatColor.RED + "" + ChatColor.BOLD + "WARNING" + ChatColor.YELLOW + " This server instance will be restarting in 5!"), 1100);
            Bukkit.getScheduler().runTaskLater(lifestealSmp, () -> player.sendMessage(ChatColor.RED + "" + ChatColor.BOLD + "WARNING" + ChatColor.YELLOW + " This server instance will be restarting in 4!"), 1120);
            Bukkit.getScheduler().runTaskLater(lifestealSmp, () -> player.sendMessage(ChatColor.RED + "" + ChatColor.BOLD + "WARNING" + ChatColor.YELLOW + " This server instance will be restarting in 3!"), 1140);
            Bukkit.getScheduler().runTaskLater(lifestealSmp, () -> player.sendMessage(ChatColor.RED + "" + ChatColor.BOLD + "WARNING" + ChatColor.YELLOW + " This server instance will be restarting in 2!"), 1160);
            Bukkit.getScheduler().runTaskLater(lifestealSmp, () -> player.sendMessage(ChatColor.RED + "" + ChatColor.BOLD + "WARNING" + ChatColor.YELLOW + " This server instance will be restarting in 1!"), 1180);
        }
        Bukkit.getScheduler().runTaskLater(lifestealSmp, () -> Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "restart"), 1200);
        return true;
    }
}
