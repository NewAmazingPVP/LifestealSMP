package newamazingpvp.lifestealsmp.nextSmpBeta;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Sound;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static newamazingpvp.lifestealsmp.LifestealSMP.lifestealSmp;

public class pingWars implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (sender instanceof Player) {
            Player player = (Player) sender;

            List<Integer> pings = new ArrayList<>();

            List<Player> playersWithHighestPing = new ArrayList<>();

            Bukkit.broadcastMessage(ChatColor.AQUA + "" + ChatColor.BOLD + "" + "==========" + "" + ChatColor.DARK_PURPLE + "" + ChatColor.BOLD + "" + " [Ping Wars] " + "" + ChatColor.AQUA + "" + ChatColor.BOLD + "" + "==========");


            Bukkit.getScheduler().runTaskLater(lifestealSmp, () -> Bukkit.broadcastMessage(ChatColor.GRAY + "" + "Grabbing Info..."), 10);

            for (Player onlinePlayer : player.getServer().getOnlinePlayers()) {
                pings.add(onlinePlayer.getPing());
            }

            Bukkit.getScheduler().runTaskLater(lifestealSmp, () -> Bukkit.broadcastMessage(ChatColor.GRAY + "" + "Loading..."), 15);

            int highestPing = Collections.max(pings);


            for (Player onlinePlayer : player.getServer().getOnlinePlayers()) {
                if (onlinePlayer.getPing() == highestPing) {
                    playersWithHighestPing.add(onlinePlayer);
                }
            }



        }else{
                sender.sendMessage("This command can only be executed by a player.");
            }
            return true;
        }
    }

