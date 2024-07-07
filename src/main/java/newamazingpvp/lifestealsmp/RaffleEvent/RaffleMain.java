package newamazingpvp.lifestealsmp.RaffleEvent;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Sound;
import org.bukkit.boss.BarColor;
import org.bukkit.boss.BarStyle;
import org.bukkit.boss.BossBar;
import org.bukkit.entity.Player;

import java.util.HashMap;
import java.util.Random;
import java.util.UUID;

public class RaffleMain {


    public static boolean isRaffleEventRunning = false;

    public static UUID currentRaffleEventID;


    public static int totalNumOfRaffleTicketsAdded = 0;

    public static HashMap<Player, Integer> numOfTicketsAddedByAPlayer = new HashMap<>();



    static Random random = new Random();


    static BossBar raffleTimberBossBar = Bukkit.createBossBar("Raffle Event", BarColor.BLUE, BarStyle.SOLID);

    public static void startRaffleEvent(Player player) {

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



        raffleTimberBossBar.setVisible(true);

        for (Player onlinePlayer : Bukkit.getOnlinePlayers()) {
            onlinePlayer.playSound(onlinePlayer.getLocation(), Sound.ENTITY_ENDER_DRAGON_GROWL, 5.0f, 1.0f);

             onlinePlayer = Bukkit.getPlayer("playerName");

            if (player != null) {
                // Add the player to the boss bar
                raffleTimberBossBar.addPlayer(player);
            }

        }


        }




        public static void killRaffleBossBar(){

            raffleTimberBossBar.setVisible(false); // Makes the boss bar invisible

            for (Player player : Bukkit.getOnlinePlayers()) {
                raffleTimberBossBar.removePlayer(player);
            }

            raffleTimberBossBar = null;

        }



    }

