package newamazingpvp.lifestealsmp;

import newamazingpvp.lifestealsmp.MontuStaff.MontuStaffLeft;
import newamazingpvp.lifestealsmp.MontuStaff.MontuStaffRight;
import newamazingpvp.lifestealsmp.MontuStaff.MontuStaffShiftLeft;
import newamazingpvp.lifestealsmp.MontuStaff.MontuStaffShiftRight;
import newamazingpvp.lifestealsmp.command.*;
import newamazingpvp.lifestealsmp.game.Compass;
import newamazingpvp.lifestealsmp.listener.*;
import org.bukkit.Bukkit;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scheduler.BukkitRunnable;

import java.awt.*;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

import static newamazingpvp.lifestealsmp.game.AutoRestart.scheduleRestart;
import static newamazingpvp.lifestealsmp.game.BroadcastMessage.broadcastServerMessage;
import static newamazingpvp.lifestealsmp.game.CustomRecipe.registerCustomRecipes;
import static newamazingpvp.lifestealsmp.game.PlayerPing.monitorPlayerPings;
import static newamazingpvp.lifestealsmp.utility.AutoUpload.startReleaseChecker;
import static newamazingpvp.lifestealsmp.utility.DiscordBot.*;

public final class LifestealSMP extends JavaPlugin implements Listener {
    public static LifestealSMP lifestealSmp;
    private FileConfiguration config;

    public static final List<String> groupNames = Arrays.asList(
            "Supporter", "Build_Team", "Build_Team+", "Premium", "Mojang",
            "Helper", "PIG+++", "Events", "Mcp", "Youtube", "NAP",
            "Ender", "Furious", "ASH", "Vip", "Vip+", "Mvp", "Mvp+",
            "Mvp++", "GameMaster", "Female", "Male", "Non-Binary",
            "Eboy", "Egirl", "Sexy", "Pro", "Ace", "Sweaty",
            "Unbeatable", "simp", "Europe", "Blood", "Test",
            "2P6ldu1teo45", "Niko", "Regar", "Duck"
    );


    @Override
    public void onEnable() {
        saveDefaultConfig();
        config = getConfig();
        lifestealSmp = this;
        startReleaseChecker();
        Bukkit.getServer().getPluginManager().registerEvents(this, this);
        getCommand("rules").setExecutor(new RulesCommand());
        getCommand("setview").setExecutor(new CustomDistance());
        getCommand("recipes").setExecutor(new RecipesCommand());
        getCommand("track").setExecutor(new Compass());
        getCommand("GMS").setExecutor(new GiveMontuStaffSetADMINONLY());
        getCommand("restart_with_warning").setExecutor(new RestartWithWarmingADMINONLY());
        getCommand("remHP").setExecutor(new RemHPADMINONLY());
        getServer().getPluginManager().registerEvents(new DisableElytra(), this);
        getServer().getPluginManager().registerEvents(new OneExpRename(), this);
        getServer().getPluginManager().registerEvents(new PlayerLagMsg(), this);
        getServer().getPluginManager().registerEvents(new SpawnProtection(), this);
        getServer().getPluginManager().registerEvents(new TeleportBow(), this);
        getServer().getPluginManager().registerEvents(new ServerAge(), this);
        getServer().getPluginManager().registerEvents(new PlayerDeath(), this);
        getServer().getPluginManager().registerEvents(new EndCrystalWarning(), this);
        getServer().getPluginManager().registerEvents(new Compass(), this);
        getServer().getPluginManager().registerEvents(new TntBow(), this);
        getServer().getPluginManager().registerEvents(new FeatherSword(), this);
        getServer().getPluginManager().registerEvents(new OpPickaxe(), this);
        getServer().getPluginManager().registerEvents(new TreeChopAxe(), this);
        getServer().getPluginManager().registerEvents(new PlayerInCombat(), this);
        getServer().getPluginManager().registerEvents(new CustomHeartItems(), this);
        getServer().getPluginManager().registerEvents(new MontuStaffLeft(), this);
        getServer().getPluginManager().registerEvents(new MontuStaffRight(), this);
        getServer().getPluginManager().registerEvents(new MontuStaffShiftLeft(), this);
        getServer().getPluginManager().registerEvents(new MontuStaffShiftRight(), this);
        //getServer().getPluginManager().registerEvents(new GracePeriod(), this);
        int repeatDelayTicks = 7200 * 20;
        BukkitRunnable broadcastTask = new BukkitRunnable() {
            @Override
            public void run() {
                broadcastServerMessage();
            }
        };
        broadcastTask.runTaskTimer(this, 0, repeatDelayTicks);
        registerCustomRecipes();
        //Bukkit.getScheduler().runTaskTimer(this, PlayerPing::monitorPlayerPings, 0L, 20L);
        new BukkitRunnable() {
            @Override
            public void run() {
                monitorPlayerPings();
            }
        }.runTaskTimer(this, 0L, 20L);
        scheduleRestart();
        intializeBot();
        new BukkitRunnable() {
            @Override
            public void run() {
                sendDiscordEmbedTitle("Bot intialized", Color.MAGENTA, "");
            }
        }.runTaskLater(this, 120);

    }

    @Override
    public void onDisable() {
        if (jda != null) {
            jda.shutdownNow();
        }
    }

    public static String randomGroup() {
        if (groupNames.isEmpty()) {
            return null;
        }

        Random random = new Random();
        int randomIndex = random.nextInt(groupNames.size());

        return groupNames.get(randomIndex);
    }


    @EventHandler
    public void playerInvunerable(PlayerJoinEvent event) {
        Player player = event.getPlayer();

        player.setInvulnerable(true);
        getServer().getScheduler().runTaskLater(this, () -> player.setInvulnerable(false), 60);
        if (!event.getPlayer().hasPlayedBefore()) {
            getServer().dispatchCommand(getServer().getConsoleSender(), "ep user " + event.getPlayer().getName() + " setgroup " + randomGroup());
            player.sendMessage("Welcome! \n/rules\n/prefix\n/color\n/recipes ");
        }
    }
}
