package newamazingpvp.lifestealsmp.RaffleEvent;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Sound;
import org.bukkit.boss.BarColor;
import org.bukkit.boss.BarStyle;
import org.bukkit.boss.BossBar;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;

import java.util.HashMap;
import java.util.Random;
import java.util.UUID;

import static newamazingpvp.lifestealsmp.LifestealSMP.lifestealSmp;
import static newamazingpvp.lifestealsmp.unused.endfight.BossFightMainClass.bossRunning;
import static newamazingpvp.lifestealsmp.unused.endfight.BossFightMainClass.preBoss;

public class RaffleMain {


    public static boolean isRaffleEventRunning = false;

    public static UUID currentRaffleEventID;


    public static int totalNumOfRaffleTicketsAdded = 0;

    public static HashMap<Player, Integer> numOfTicketsAddedByAPlayer = new HashMap<>();

    public static BukkitRunnable raffleMainTimerRunnable;

    public static int raffleTimerCount = 0;

    public static BossBar raffleTimerBossBar = Bukkit.createBossBar(ChatColor.DARK_GREEN + "" + ChatColor.BOLD + "Raffle Event: " + raffleTimerCount, BarColor.BLUE, BarStyle.SEGMENTED_20);

    public static void startRaffleEvent(Player player) {

        raffleTimerBossBar.setVisible(true);

        raffleTimerCount = 60;  //3600
        raffleTimerBossBar.setProgress(raffleTimerCount);

        raffleMainTimerRunnable = new BukkitRunnable() {


            @Override
            public void run() {
                if (raffleTimerCount <= 0) {
                    endRaffleMainTimerRunnable();
                    endRaffleEvent();
                } else {
                    raffleTimerCount -= 1;
                    raffleTimerBossBar.setTitle(ChatColor.DARK_GREEN + "" + ChatColor.BOLD + "Raffle Event: " + raffleTimerCount);
                    raffleTimerBossBar.setProgress(raffleTimerCount);
                    if (raffleTimerCount <= 10) {
                        Bukkit.broadcastMessage(ChatColor.DARK_RED + "" + ChatColor.BOLD + "The Event Will End In " + raffleTimerCount + "sec!");
                    } else {

                    }

                }
            }
        };
        raffleMainTimerRunnable.runTaskTimer(lifestealSmp, 0L, 20L); // Start immediately and repeat every second


        totalNumOfRaffleTicketsAdded = 0;

        numOfTicketsAddedByAPlayer.clear();

        UUID uuid = UUID.randomUUID();

        currentRaffleEventID = uuid;

        isRaffleEventRunning = true;

        Bukkit.getOnlinePlayers().forEach(p -> p.sendTitle(ChatColor.GOLD + "" + ChatColor.BOLD + "Event Starting!", " ", 10, 40, 5));


        Bukkit.broadcastMessage(ChatColor.DARK_PURPLE + "" + ChatColor.BOLD + "======= Raffle Event =========");
        Bukkit.broadcastMessage(ChatColor.GOLD + "Break blocks and kill mobs / players to get");
        Bukkit.broadcastMessage(ChatColor.GOLD + "raffle tickets! Submit tickets by going within");
        Bukkit.broadcastMessage(ChatColor.GOLD + "150 blocks of spawn and right clicking them!");
        Bukkit.broadcastMessage(ChatColor.GOLD + "The more raffle tickets you have in your inventory");
        Bukkit.broadcastMessage(ChatColor.GOLD + "the higher the chance" + ChatColor.DARK_RED + " special mobs will spawn!");
        Bukkit.broadcastMessage(ChatColor.GREEN + ("(Could be a good thing)"));
        Bukkit.broadcastMessage(ChatColor.GOLD + "There will be 3 winners." + ChatColor.STRIKETHROUGH + " Have Fun!");
        Bukkit.broadcastMessage(ChatColor.DARK_PURPLE + "" + ChatColor.BOLD + "============================");
        Bukkit.broadcastMessage(ChatColor.DARK_GRAY + "This event ID: " + currentRaffleEventID);
        Bukkit.broadcastMessage(ChatColor.DARK_GRAY + "(for moderation)");


        for (Player onlinePlayer : Bukkit.getOnlinePlayers()) {
            onlinePlayer.playSound(onlinePlayer.getLocation(), Sound.ENTITY_ENDER_DRAGON_GROWL, 5.0f, 1.0f);

            onlinePlayer = Bukkit.getPlayer("playerName");

            if (player != null) {
                // Add the player to the boss bar
                raffleTimerBossBar.addPlayer(player);
            }
        }
    }


    private static void endRaffleMainTimerRunnable() {
        if (raffleMainTimerRunnable != null && !raffleMainTimerRunnable.isCancelled()) {
            raffleMainTimerRunnable.cancel();
            raffleMainTimerRunnable = null;


        }
    }


    public static void endRaffleEvent() {
        isRaffleEventRunning = false;
        raffleTimerBossBar.setVisible(false);

        for (Player onlinePlayer : Bukkit.getOnlinePlayers()) {
            onlinePlayer.playSound(onlinePlayer.getLocation(), Sound.ENTITY_PLAYER_LEVELUP, 5.0f, 0.0f);

        }


    }





}


