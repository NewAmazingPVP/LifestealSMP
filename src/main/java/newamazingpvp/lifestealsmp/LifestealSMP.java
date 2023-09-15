package newamazingpvp.lifestealsmp;

import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import newamazingpvp.lifestealsmp.command.CustomDistance;
import newamazingpvp.lifestealsmp.command.RulesCommand;
import newamazingpvp.lifestealsmp.command.TrackCommand;
import newamazingpvp.lifestealsmp.game.PlayerPing;
import newamazingpvp.lifestealsmp.listener.*;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scheduler.BukkitRunnable;

import javax.security.auth.login.LoginException;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.logging.Level;

import static newamazingpvp.lifestealsmp.game.BroadcastMessage.broadcastServerMessage;
import static newamazingpvp.lifestealsmp.game.CustomRecipe.registerCustomRecipes;

public final class LifestealSMP extends JavaPlugin implements Listener {
    public static LifestealSMP lifestealSmp;

    private JDA jda;
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
        Bukkit.getServer().getPluginManager().registerEvents(this, this);
        getCommand("rules").setExecutor(new RulesCommand());
        getCommand("setview").setExecutor(new CustomDistance());
        getCommand("track").setExecutor(new TrackCommand());
        lifestealSmp = this;
        getServer().getPluginManager().registerEvents(new DisableElytra(), this);
        getServer().getPluginManager().registerEvents(new OneExpRename(), this);
        getServer().getPluginManager().registerEvents(new PlayerLagMsg(), this);
        getServer().getPluginManager().registerEvents(new SpawnProtection(), this);
        getServer().getPluginManager().registerEvents(new TeleportBow(), this);
        getServer().getPluginManager().registerEvents(new ServerAge(), this);
        getServer().getPluginManager().registerEvents(new PlayerDeath(), this);
        getServer().getPluginManager().registerEvents(new EndCrystalWarning(), this);
        getServer().getPluginManager().registerEvents(new CompassListener(), this);
        int repeatDelayTicks = 7200 * 20;
        BukkitRunnable broadcastTask = new BukkitRunnable() {
            @Override
            public void run() {
                broadcastServerMessage();
            }
        };
        broadcastTask.runTaskTimer(this, 0, repeatDelayTicks);
        registerCustomRecipes();
        try {
            jda = JDABuilder.createDefault("MTAwMDk0MzMxMzE0ODQ1Mjg2NA.GPdpcR.en1IKs-w4SeOSAKF5ERkmE7OS7g6zvGs5Otjoo").build();
        } catch (LoginException e) {
            getLogger().log(Level.SEVERE, "Failed to initialize Discord bot!", e);
            return;
        }
        Bukkit.getScheduler().runTaskTimer(lifestealSmp, PlayerPing::monitorPlayerPings, 0L, 20L);
    }
    @Override
    public void onDisable() {
        // Shutdown the Discord bot on plugin disable
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

        // Make the player invulnerable for 2 seconds
        player.setInvulnerable(true);
        getServer().getScheduler().runTaskLater(this, () -> player.setInvulnerable(false), 60);
        if(!event.getPlayer().hasPlayedBefore()){
            getServer().dispatchCommand(getServer().getConsoleSender(), "ep user " + event.getPlayer().getName() + " setgroup " + randomGroup());
        }
    }
}
