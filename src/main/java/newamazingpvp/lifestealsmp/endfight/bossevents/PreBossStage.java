package newamazingpvp.lifestealsmp.endfight.bossevents;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;

import static newamazingpvp.lifestealsmp.LifestealSMP.lifestealSmp;
import static newamazingpvp.lifestealsmp.endfight.BossFightMainClass.bossRunning;
import static newamazingpvp.lifestealsmp.endfight.BossFightMainClass.preBoss;

public class PreBossStage {

    public static BukkitRunnable preBossTimerRunnable;

    public static void startPreBoss(Player player){

        if(!preBoss) {


            preBoss = true;
            player.sendMessage(ChatColor.GREEN + "" + ChatColor.BOLD + "Pre boss phase has started! (1min long)");
            Bukkit.broadcastMessage(ChatColor.DARK_PURPLE + "" + ChatColor.BOLD + "The Fight Will Start In 1min!");

            preBossTimerRunnable = new BukkitRunnable() {
                private int count = 30;

                @Override
                public void run() {
                    if (count <= 0) {
                        Bukkit.broadcastMessage(ChatColor.DARK_RED + "" + ChatColor.BOLD + "Fight Starting!");
                        preBoss = false;
                        bossRunning = true;
                        preBossCancelTimer();
                    } else {
                        count -= 1;
                        if (count <= 10) {
                            Bukkit.broadcastMessage(ChatColor.DARK_RED + "" + ChatColor.BOLD + "The Fight Will Start In " + count + "sec!");
                        } else {
                            Bukkit.broadcastMessage(String.valueOf(count));
                        }

                    }
                }
            };
            preBossTimerRunnable.runTaskTimer(lifestealSmp, 0L, 20L); // Start immediately and repeat every second




        }else{
            player.sendMessage(ChatColor.RED + "" + ChatColor.BOLD + "[Error] The pre boss phase has already started or the boss is already running!");
        }


    }




    public static void preBossCancelTimer() {

        if (preBossTimerRunnable != null && !preBossTimerRunnable.isCancelled()) {
            preBossTimerRunnable.cancel();
            preBossTimerRunnable = null;

        }
    }


}
