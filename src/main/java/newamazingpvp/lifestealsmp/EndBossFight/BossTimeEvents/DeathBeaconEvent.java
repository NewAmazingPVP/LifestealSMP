package newamazingpvp.lifestealsmp.EndBossFight.BossTimeEvents;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.scheduler.BukkitRunnable;

import static newamazingpvp.lifestealsmp.LifestealSMP.lifestealSmp;

public class DeathBeaconEvent implements Listener {


    private static BukkitRunnable timerRunnable;
    private static boolean isRunning = false;



    //TIMER CONTROLLER
    public static void runDeathBeaconTimer(Player player) {

        if (!isRunning) {

            isRunning = true;
            timerRunnable = new BukkitRunnable() {
                private int count = 30;

                @Override
                public void run() {
                    if (count <= 0) {
                        Bukkit.broadcastMessage(ChatColor.DARK_RED + "" + ChatColor.BOLD + "The death beacon has cracked (-1/2 your HP❤)");
                        cancelTimer();
                    } else {
                        if(count <= 10){
                            Bukkit.broadcastMessage(ChatColor.DARK_RED + "" + ChatColor.BOLD +  "The death beacon will crack in " + count +"sec!");
                        }else{
                            Bukkit.broadcastMessage(String.valueOf(count));
                        }

                    }
                }
            };
            timerRunnable.runTaskTimer(lifestealSmp, 0L, 20L); // Start immediately and repeat every second
        }else{
            player.sendMessage(ChatColor.RED + "There is already a death beacon out (only one at a time can be out)!");
        }
    }


    private static void cancelTimer() {

        if (timerRunnable != null && !timerRunnable.isCancelled()) {
            timerRunnable.cancel();
            timerRunnable = null;
            isRunning = false;

        }
    }




}
