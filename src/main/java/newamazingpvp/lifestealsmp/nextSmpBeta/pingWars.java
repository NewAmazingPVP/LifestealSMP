package newamazingpvp.lifestealsmp.nextSmpBeta;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Sound;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import static newamazingpvp.lifestealsmp.LifestealSMP.lifestealSmp;

public class pingWars implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (sender instanceof Player) {

            //Variables and Lists
            Player player = (Player) sender;
            int highestPing = 0;
            String playerWithHighestPing = "";


            //Ping Wars Announcement
            for (Player soundLOC1 : Bukkit.getServer().getOnlinePlayers()) {
                soundLOC1.playSound(soundLOC1.getLocation(), Sound.ENTITY_ENDER_DRAGON_GROWL, 1.0F, 1.0F);
            }

                Bukkit.broadcastMessage(ChatColor.AQUA + "" + ChatColor.BOLD + "" + "==========" + "" + ChatColor.DARK_PURPLE + "" + ChatColor.BOLD + "" + " [Ping Wars] " + "" + ChatColor.AQUA + "" + ChatColor.BOLD + "" + "==========");


                //Random BS to look "cool"
                Bukkit.getScheduler().runTaskLater(lifestealSmp, () -> Bukkit.broadcastMessage(ChatColor.GRAY + "" + "Grabbing Info..."), 10);
                Bukkit.getScheduler().runTaskLater(lifestealSmp, () -> Bukkit.broadcastMessage(ChatColor.GRAY + "" + "Loading..."), 15);


                //Highest Ping
                for (Player onlinePlayer : player.getServer().getOnlinePlayers()) {
                    int currentPing = onlinePlayer.getPing();
                    if (currentPing > highestPing) {
                        highestPing = currentPing;
                        playerWithHighestPing = onlinePlayer.getName();
                    }
                }
                String finalPlayerWithHighestPing = playerWithHighestPing;


                //Final results display
                for (Player soundLOC2 : Bukkit.getServer().getOnlinePlayers()) {
                    soundLOC2.playSound(soundLOC2.getLocation(), Sound.ENTITY_PLAYER_LEVELUP, 1.0F, 0.0F);
                }

                    Bukkit.getScheduler().runTaskLater(lifestealSmp, () -> Bukkit.broadcastMessage(ChatColor.AQUA + "" + ChatColor.BOLD + "" + "==========" + "" + ChatColor.DARK_PURPLE + "" + ChatColor.BOLD + "" + " [Ping Wars] " + "" + ChatColor.AQUA + "" + ChatColor.BOLD + "" + "=========="), 30);
                    Bukkit.getScheduler().runTaskLater(lifestealSmp, () -> Bukkit.broadcastMessage(" "), 30);
                    Bukkit.getScheduler().runTaskLater(lifestealSmp, () -> Bukkit.broadcastMessage(ChatColor.DARK_RED + "" + ChatColor.BOLD + "" + "Player with highest ping: " + "" + finalPlayerWithHighestPing), 30);


                }else{
                    sender.sendMessage("This command can only be executed by a player.");
                }
                return true;
            }
        }

