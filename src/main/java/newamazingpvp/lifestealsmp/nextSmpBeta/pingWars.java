package newamazingpvp.lifestealsmp.nextSmpBeta;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Sound;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import static newamazingpvp.lifestealsmp.LifestealSMP.lifestealSmp;

public class pingWars implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (sender instanceof Player) {

            //Variables and Lists
            Player player = (Player) sender;
            int highestPing = 0;
            String playerWithHighestPing = "";
            List<String> pings = new ArrayList<>();
            List<Player> players = new ArrayList<>(Bukkit.getOnlinePlayers());
            String first = null;
            String second = null;
            String third = null;
            int firstMS = 0;
            int secondMS = 0;
            int thirdMS = 0;

            pings.clear();

            //Ping Wars Announcement
            for (Player soundLOC1 : Bukkit.getServer().getOnlinePlayers()) {
                soundLOC1.playSound(soundLOC1.getLocation(), Sound.ENTITY_ENDER_DRAGON_GROWL, 1.0F, 1.0F);
            }

            Bukkit.broadcastMessage(ChatColor.AQUA + "" + ChatColor.BOLD + "" + "==========" + "" + ChatColor.DARK_PURPLE + "" + ChatColor.BOLD + "" + " [Ping Wars] " + "" + ChatColor.AQUA + "" + ChatColor.BOLD + "" + "==========");


            //Random BS to look "cool"
            Bukkit.getScheduler().runTaskLater(lifestealSmp, () -> Bukkit.broadcastMessage(ChatColor.GRAY + "" + "Grabbing Info..."), 10);
            Bukkit.getScheduler().runTaskLater(lifestealSmp, () -> Bukkit.broadcastMessage(ChatColor.GRAY + "" + "Loading..."), 15);

            //List of pings and top 3 lowest
            for (Player onlinePlayer : Bukkit.getOnlinePlayers()) {
                pings.add(onlinePlayer.getName() + ": " + onlinePlayer.getPing() + "ms");
            }

            players.sort(Comparator.comparingInt(Player::getPing));
            
            for (int i = 0; i < Math.min(3, players.size()); i++) {
                Player p = players.get(i);
                if(i==0){
                    first = p.getName();
                    firstMS = p.getPing();
                }else if(i == 1){
                    second = p.getName();
                    secondMS = p.getPing();
                }else {
                    third = p.getName();
                    thirdMS = p.getPing();
                }
            }




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
                Bukkit.getScheduler().runTaskLater(lifestealSmp, () -> soundLOC2.playSound(soundLOC2.getLocation(), Sound.ENTITY_PLAYER_LEVELUP, 1.0F, 0.0F), 40);
            }

            Bukkit.getScheduler().runTaskLater(lifestealSmp, () -> Bukkit.broadcastMessage(ChatColor.AQUA + "" + ChatColor.BOLD + "" + "==========" + "" + ChatColor.DARK_PURPLE + "" + ChatColor.BOLD + "" + " [Ping Wars] " + "" + ChatColor.AQUA + "" + ChatColor.BOLD + "" + "=========="), 40);
            Bukkit.getScheduler().runTaskLater(lifestealSmp, () -> Bukkit.broadcastMessage(" "), 40);

            String finalFirst = first;
            int finalFirstMS = firstMS;
            Bukkit.getScheduler().runTaskLater(lifestealSmp, () -> Bukkit.broadcastMessage(ChatColor.YELLOW + "" + ChatColor.BOLD + "" + "First : " + "" + ChatColor.GREEN + "" + ChatColor.BOLD + "" + finalFirst + "" + ChatColor.AQUA + "" + ChatColor.BOLD + "" + " : " + "" + finalFirstMS), 40);
            String finalSecond = second;
            int finalSecondMS = secondMS;
            Bukkit.getScheduler().runTaskLater(lifestealSmp, () -> Bukkit.broadcastMessage(ChatColor.YELLOW + "" + ChatColor.BOLD + "" + "second : " + "" +  ChatColor.GREEN + "" + ChatColor.BOLD + "" +finalSecond + "" + ChatColor.AQUA + "" + ChatColor.BOLD + "" + " : " + "" + finalSecondMS), 40);
            String finalThird = third;
            int finalThirdMS = thirdMS;
            Bukkit.getScheduler().runTaskLater(lifestealSmp, () -> Bukkit.broadcastMessage(ChatColor.YELLOW + "" + ChatColor.BOLD + "" + "third : " + "" + ChatColor.GREEN + "" + ChatColor.BOLD + "" +  finalThird + "" + ChatColor.AQUA + "" + ChatColor.BOLD + "" + " : " + "" + finalThirdMS), 40);

            Bukkit.getScheduler().runTaskLater(lifestealSmp, () -> Bukkit.broadcastMessage(" "), 40);

            Bukkit.getScheduler().runTaskLater(lifestealSmp, () -> Bukkit.broadcastMessage(ChatColor.DARK_RED + "" + ChatColor.BOLD + "" + "Player with highest ping: " + "" + finalPlayerWithHighestPing), 40);
            Bukkit.getScheduler().runTaskLater(lifestealSmp, () -> Bukkit.broadcastMessage(" "), 40);
            Bukkit.getScheduler().runTaskLater(lifestealSmp, () -> Bukkit.broadcastMessage(ChatColor.AQUA + "" + ChatColor.BOLD + "" + "==============================="), 40);











        } else {
            sender.sendMessage("This command can only be executed by a player.");
        }
        return true;
    }
}
