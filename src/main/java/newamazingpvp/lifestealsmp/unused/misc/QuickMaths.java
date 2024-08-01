package newamazingpvp.lifestealsmp.unused.misc;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Sound;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.concurrent.atomic.AtomicBoolean;

import static newamazingpvp.lifestealsmp.LifestealSMP.lifestealSmp;

public class QuickMaths implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (sender instanceof Player player) {

            //Quick Maths Command


            //Bukkit.broadcastMessage(ChatColor.DARK_RED + "Good Luck. If you fail YOU WILL DIE! =D");


            AtomicBoolean canAnswer = new AtomicBoolean(false);

            int mathType = 0;

            int num1 = 0;
            int num2 = 0;
            int num3 = 0;

            int ans = 0;


            Bukkit.broadcastMessage(ChatColor.GRAY + "Loading...");

            //generates prob type
            mathType = (int) (Math.random() * 10);

            //generates numbers for problem
            num1 = (int) (Math.random() * 101);
            num2 = (int) (Math.random() * 101);
            num3 = (int) (Math.random() * 101);

            for (Player soundLOC1 : Bukkit.getServer().getOnlinePlayers()) {
                soundLOC1.playSound(soundLOC1.getLocation(), Sound.ENTITY_EXPERIENCE_ORB_PICKUP, 1.0F, 0.0F);
            }

            Bukkit.broadcastMessage(ChatColor.LIGHT_PURPLE + "" + ChatColor.BOLD + "QUICK MATHS:");


            switch (mathType) {
                case 1:
                    ans = num1 + num2 + num3;
                    Bukkit.broadcastMessage(ChatColor.YELLOW + "" + num1 + " + " + num2 + " + " + num3);
                    break;
                case 2:
                    ans = num1 - num2 + num3;
                    Bukkit.broadcastMessage(ChatColor.YELLOW + "" + num1 + " - " + num2 + " + " + num3);
                    break;
                case 3:
                    ans = num1 + num2 - num3;
                    Bukkit.broadcastMessage(ChatColor.YELLOW + "" + num1 + " + " + num2 + " - " + num3);
                    break;
                case 4:
                    ans = num1 / num2 + num3;
                    Bukkit.broadcastMessage(ChatColor.YELLOW + "" + num1 + " / " + num2 + " + " + num3);
                    break;
                case 5:
                    ans = num1 / num2 / num3;
                    Bukkit.broadcastMessage(ChatColor.YELLOW + "" + num1 + " / " + num2 + " / " + num3);
                    break;
                case 6:
                    ans = num1 * num2 * num3;
                    Bukkit.broadcastMessage(ChatColor.YELLOW + "" + num1 + " * " + num2 + " * " + num3);
                    break;
                case 7:
                    ans = num1 * num2 / num3;
                    Bukkit.broadcastMessage(ChatColor.YELLOW + "" + num1 + " * " + num2 + " / " + num3);
                    break;
                case 8:
                    ans = num1 - num2 - num3;
                    Bukkit.broadcastMessage(ChatColor.YELLOW + "" + num1 + " - " + num2 + " - " + num3);
                    break;
                case 9:
                    ans = num1 + num2 * num3;
                    Bukkit.broadcastMessage(ChatColor.YELLOW + "" + num1 + " + " + num2 + " * " + num3);
                    break;
                default:
                    Bukkit.broadcastMessage(ChatColor.RED + "error");
            }


            canAnswer.set(true);

            Bukkit.getScheduler().runTaskLater(lifestealSmp, () -> canAnswer.set(false), 20 * 20);
            Bukkit.getScheduler().runTaskLater(lifestealSmp, () -> Bukkit.broadcastMessage(ChatColor.RED + "Time Up!"), 20 * 20);
            int finalAns = ans;
            Bukkit.getScheduler().runTaskLater(lifestealSmp, () -> Bukkit.broadcastMessage(ChatColor.GREEN + "" + finalAns), 20 * 20);

            for (Player soundLOC1 : Bukkit.getServer().getOnlinePlayers()) {
                soundLOC1.playSound(soundLOC1.getLocation(), Sound.ENTITY_VILLAGER_AMBIENT, 1.0F, 2.0F);
            }


        } else {
            sender.sendMessage("This command can only be executed by a player.");
        }
        return true;
    }

}
