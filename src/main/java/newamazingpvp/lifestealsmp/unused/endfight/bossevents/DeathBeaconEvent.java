package newamazingpvp.lifestealsmp.unused.endfight.bossevents;

import org.bukkit.*;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.scheduler.BukkitRunnable;

import java.util.List;
import java.util.Random;

import static newamazingpvp.lifestealsmp.LifestealSMP.lifestealSmp;

public class DeathBeaconEvent implements Listener {

    private static final List<String> arenaSides = List.of("Red", "Yellow", "Green", "Blue");


    private static BukkitRunnable timerRunnable;
    private static boolean isRunning = false;

    private static final Random rand = new Random();


    @EventHandler
    public void playerPunchDeathBeacon(PlayerInteractEvent e) {

        Player player = e.getPlayer();
        if (e.getAction() == Action.RIGHT_CLICK_BLOCK || e.getAction() == Action.LEFT_CLICK_BLOCK) {
            Block block = e.getClickedBlock();


            playerBreakDeathBeacon(player, block);

            if (block.getType() == Material.BEACON) {
                e.setCancelled(true);
            }


        }
    }


    private void playerBreakDeathBeacon(Player player, Block block) {


        if (block.getType() == Material.BEACON) {


            cancelTimer();
            block.getWorld().spawnParticle(Particle.CLOUD, block.getLocation(), 10);
            String name = player.getName();
            player.sendMessage(ChatColor.GOLD + "" + ChatColor.BOLD + "You Broke The Death Beacon!");
            player.playSound(player.getLocation(), Sound.ENTITY_PLAYER_LEVELUP, 2.0f, 2.0f);
            Bukkit.getOnlinePlayers().forEach(p -> p.sendTitle(ChatColor.GREEN + name + " Broke The Beacon!", " ", 10, 40, 5));
            Bukkit.broadcastMessage(ChatColor.DARK_GREEN + "" + ChatColor.BOLD + name + " Has Broken The Death Beacon!");

            for (Player onlinePlayer : Bukkit.getOnlinePlayers()) {
                onlinePlayer.playSound(onlinePlayer.getLocation(), Sound.ENTITY_PLAYER_LEVELUP, 2.0f, 2.0f);

            }

            block.setType(Material.AIR);


        }

    }


    public static void runDeathBeaconTimer(Player player) {

        if (!isRunning) {

            isRunning = true;


            int randomSideIndex = rand.nextInt(arenaSides.size());
            String selectedSide = arenaSides.get(randomSideIndex);




            /*if (selectedSide == "Red") {
                Block block = deathBeaconLocRED.getBlock();
                block.setType(Material.BEACON);

            } else if (selectedSide == "Yellow") {
                Block block = deathBeaconLocYellow.getBlock();
                block.setType(Material.BEACON);

            } else if (selectedSide == "Green") {
                Block block = deathBeaconLocGreen.getBlock();
                block.setType(Material.BEACON);

            } else if (selectedSide == "Blue") {
                Block block = deathBeaconLocBlue.getBlock();
                block.setType(Material.BEACON);

            }*/


            timerRunnable = new BukkitRunnable() {
                private int count = 30;

                @Override
                public void run() {
                    if (count <= 0) {
                        Bukkit.broadcastMessage(ChatColor.DARK_RED + "" + ChatColor.BOLD + "The death beacon has cracked (-1/2 your HP❤)");
                        cancelTimer();
                    } else {
                        count -= 1;
                        if (count <= 10) {
                            Bukkit.broadcastMessage(ChatColor.DARK_RED + "" + ChatColor.BOLD + "The death beacon will crack in " + count + "sec! (in " + selectedSide + " quadrant!)");
                        } else {
                            //Bukkit.broadcastMessage(String.valueOf(count));
                        }

                    }
                }
            };
            timerRunnable.runTaskTimer(lifestealSmp, 0L, 20L); // Start immediately and repeat every second
        } else {
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


    public static void deathBeaconWarnTitle() {
        Bukkit.getOnlinePlayers().forEach(p -> p.sendTitle(ChatColor.DARK_PURPLE + "Death Beacon!", ChatColor.RED + "" + ChatColor.BOLD + "> 30sec To Break <", 10, 40, 5));
        Bukkit.getScheduler().runTaskLater(lifestealSmp, () -> Bukkit.getOnlinePlayers().forEach(p -> p.sendTitle(ChatColor.DARK_PURPLE + "" + ChatColor.BOLD + "Death Beacon!", ChatColor.RED + "" + ChatColor.BOLD + ">30sec To Break<", 10, 40, 10)), 5);
        Bukkit.getScheduler().runTaskLater(lifestealSmp, () -> Bukkit.getOnlinePlayers().forEach(p -> p.sendTitle(ChatColor.DARK_PURPLE + "" + ChatColor.BOLD + "Death Beacon!", ChatColor.RED + "" + ChatColor.BOLD + "> 30sec To Break <", 10, 40, 10)), 10);
        Bukkit.getScheduler().runTaskLater(lifestealSmp, () -> Bukkit.getOnlinePlayers().forEach(p -> p.sendTitle(ChatColor.DARK_PURPLE + "" + ChatColor.BOLD + "Death Beacon!", ChatColor.RED + "" + ChatColor.BOLD + ">30sec To Break<", 10, 40, 10)), 15);
        Bukkit.getScheduler().runTaskLater(lifestealSmp, () -> Bukkit.getOnlinePlayers().forEach(p -> p.sendTitle(ChatColor.DARK_PURPLE + "" + ChatColor.BOLD + "Death Beacon!", ChatColor.RED + "" + ChatColor.BOLD + "> 30sec To Break <", 10, 40, 10)), 20);
        Bukkit.getScheduler().runTaskLater(lifestealSmp, () -> Bukkit.getOnlinePlayers().forEach(p -> p.sendTitle(ChatColor.DARK_PURPLE + "" + ChatColor.BOLD + "Death Beacon!", ChatColor.RED + "" + ChatColor.BOLD + ">30sec To Break<", 10, 40, 10)), 25);
    }

}

