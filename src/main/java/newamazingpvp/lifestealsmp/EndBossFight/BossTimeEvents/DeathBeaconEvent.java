package newamazingpvp.lifestealsmp.EndBossFight.BossTimeEvents;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.scheduler.BukkitRunnable;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import static newamazingpvp.lifestealsmp.LifestealSMP.lifestealSmp;

public class DeathBeaconEvent implements Listener {

    private static final List<String> arenaSides = List.of("Red", "Yellow", "Green", "Blue");



    private static BukkitRunnable timerRunnable;
    private static boolean isRunning = false;

    private static Random rand = new Random();


    //TIMER CONTROLLER
    public static void runDeathBeaconTimer(Player player) {

        if (!isRunning) {

            isRunning = true;

            int randomSideIndex = rand.nextInt(arenaSides.size());
            String selectedSide = arenaSides.get(randomSideIndex);



            timerRunnable = new BukkitRunnable() {
                private int count = 30;

                @Override
                public void run() {
                    if (count <= 0) {
                        Bukkit.broadcastMessage(ChatColor.DARK_RED + "" + ChatColor.BOLD + "The death beacon has cracked (-1/2 your HP❤)");
                        cancelTimer();
                    } else {
                        count -=1;
                        if(count <= 10){
                            Bukkit.broadcastMessage(ChatColor.DARK_RED + "" + ChatColor.BOLD +  "The death beacon will crack in " + count +"sec! (in " + selectedSide + " quadrant!)");
                        }else{
                            //Bukkit.broadcastMessage(String.valueOf(count));
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


    public static void deathBeaconWarnTitle(){
        Bukkit.getOnlinePlayers().forEach(p -> p.sendTitle(ChatColor.DARK_PURPLE + "Death Beacon!", ChatColor.RED + "" + ChatColor.BOLD + "> 30sec To Break <", 10, 40, 5));
        Bukkit.getScheduler().runTaskLater(lifestealSmp, () -> Bukkit.getOnlinePlayers().forEach(p -> p.sendTitle(ChatColor.DARK_RED + "" + ChatColor.BOLD + "[Death Beacon!]", ChatColor.RED + "" + ChatColor.BOLD + ">30sec To Break<", 10, 40, 10)), 5);
        Bukkit.getScheduler().runTaskLater(lifestealSmp, () -> Bukkit.getOnlinePlayers().forEach(p -> p.sendTitle(ChatColor.DARK_PURPLE + "" + ChatColor.BOLD + "Death Beacon!", ChatColor.RED + "" + ChatColor.BOLD + "> 30sec To Break <", 10, 40, 10)), 5);
        Bukkit.getScheduler().runTaskLater(lifestealSmp, () -> Bukkit.getOnlinePlayers().forEach(p -> p.sendTitle(ChatColor.DARK_RED + "" + ChatColor.BOLD + "[Death Beacon!]", ChatColor.RED + "" + ChatColor.BOLD + ">30sec To Break<", 10, 40, 10)), 5);
        Bukkit.getScheduler().runTaskLater(lifestealSmp, () -> Bukkit.getOnlinePlayers().forEach(p -> p.sendTitle(ChatColor.DARK_PURPLE + "" + ChatColor.BOLD + "Death Beacon!", ChatColor.RED + "" + ChatColor.BOLD + "> 30sec To Break <", 10, 40, 10)), 5);
        Bukkit.getScheduler().runTaskLater(lifestealSmp, () -> Bukkit.getOnlinePlayers().forEach(p -> p.sendTitle(ChatColor.DARK_RED + "" + ChatColor.BOLD + "[Death Beacon!]", ChatColor.RED + "" + ChatColor.BOLD + ">30sec To Break<", 10, 40, 10)), 5);
    }

}

