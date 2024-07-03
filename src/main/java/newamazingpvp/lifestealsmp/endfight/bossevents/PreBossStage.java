package newamazingpvp.lifestealsmp.endfight.bossevents;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;

import static newamazingpvp.lifestealsmp.endfight.BossFightMainClass.preBoss;

public class PreBossStage {

    private static BukkitRunnable timerRunnable;

    public static void startPreBoss(Player player){

        if(!preBoss){


            preBoss=true;
            player.sendMessage(ChatColor.GREEN + "" + ChatColor.BOLD + "Pre boss phase has started! (1min long)");
            Bukkit.broadcastMessage(ChatColor.DARK_PURPLE + "" + ChatColor.BOLD + "The Fight Will Start In 1min!");





        }else{
            player.sendMessage(ChatColor.RED + "" + ChatColor.BOLD + "[Error] The pre boss phase has already started or the boss is already running!");
        }


    }


}
