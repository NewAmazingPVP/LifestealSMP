package newamazingpvp.lifestealsmp;

import newamazingpvp.lifestealsmp.blacklistener.*;
import newamazingpvp.lifestealsmp.command.*;
import newamazingpvp.lifestealsmp.customitems.*;
import newamazingpvp.lifestealsmp.discord.DiscordListener;
import newamazingpvp.lifestealsmp.game.Compass;
import newamazingpvp.lifestealsmp.game.EndFightRestrictions;
import newamazingpvp.lifestealsmp.listener.*;
import newamazingpvp.lifestealsmp.cometwip.GiveSekhmetSetSpeedADMINONLY;
import newamazingpvp.lifestealsmp.utility.LogAppender;
import org.apache.logging.log4j.LogManager;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.scheduler.BukkitRunnable;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

import static newamazingpvp.lifestealsmp.game.AutoRestart.scheduleRestart;
import static newamazingpvp.lifestealsmp.game.BroadcastMessage.*;
import static newamazingpvp.lifestealsmp.game.Compass.compassUpdate;
import static newamazingpvp.lifestealsmp.game.CustomRecipe.registerCustomRecipes;
import static newamazingpvp.lifestealsmp.game.PlayerPing.monitorPlayerPings;
import static newamazingpvp.lifestealsmp.blacklistener.ChatFilter.initializeBlacklist;
import static newamazingpvp.lifestealsmp.utility.DiscordBot.*;

public final class LifestealSMP extends JavaPlugin implements Listener {
    public static LifestealSMP lifestealSmp;
    private FileConfiguration config;


    @Override
    public void onEnable() {
        //sendDiscordMessage("The server has started✅", "");
        saveDefaultConfig();
        config = getConfig();
        lifestealSmp = this;
        //startReleaseChecker();
        initializeBlacklist();
        Bukkit.getServer().getPluginManager().registerEvents(this, this);
        getCommand("rules").setExecutor(new RulesCommand());
        getCommand("setview").setExecutor(new CustomDistance());
        getCommand("recipes").setExecutor(new RecipesCommand());
        getCommand("track").setExecutor(new Compass());
        getCommand("GiveSekhmetSet").setExecutor(new GiveSekhmetSetSpeedADMINONLY());
        getCommand("restart_with_warning").setExecutor(new RestartWithWarming());
        getCommand("remHP").setExecutor(new RemoveHP());
        getCommand("addHP").setExecutor(new AddHP());
        getCommand("LSwithdraw").setExecutor(new LSwithdraw());
        getCommand("startEndFight").setExecutor(new StartEndFight());
        getCommand("stopEndFight").setExecutor(new StopEndFight());
        getCommand("jailplayer").setExecutor(new JailPlayer());
        getCommand("reviveplayer").setExecutor(new RevivePlayer());
        getCommand("vision").setExecutor(new NightVision());
        getCommand("senddiscordmessage").setExecutor(new SendDiscordMessage());
        getCommand("shop").setExecutor(new ShopCommand());
        getCommand("help").setExecutor(new HelpCommand());
        getCommand("guide").setExecutor(new GuideCommand());
        getCommand("givecustomitem").setExecutor(new GiveCustomItem());
        getCommand("givecustomitem").setTabCompleter(new GiveCustomItem());
        getCommand("serverruntime").setExecutor(new ServerRuntime());
        //getCommand("team").setExecutor(new TeamCommand());
        //getCommand("team").setTabCompleter(new TeamCommand());
        getServer().getPluginManager().registerEvents(new DisableElytra(), this);
        getServer().getPluginManager().registerEvents(new OneExpRename(), this);
        getServer().getPluginManager().registerEvents(new PlayerLagMsg(), this);
        //getServer().getPluginManager().registerEvents(new SpawnProtection(), this);
        getServer().getPluginManager().registerEvents(new TeleportBow(), this);
        //getServer().getPluginManager().registerEvents(new ServerAge(), this);
        getServer().getPluginManager().registerEvents(new PlayerDeath(), this);
        getServer().getPluginManager().registerEvents(new EndCrystalWarning(), this);
        getServer().getPluginManager().registerEvents(new Compass(), this);
        getServer().getPluginManager().registerEvents(new TntBow(), this);
        getServer().getPluginManager().registerEvents(new FeatherSword(), this);
        getServer().getPluginManager().registerEvents(new OpPickaxe(), this);
        getServer().getPluginManager().registerEvents(new TreeChopAxe(), this);
        getServer().getPluginManager().registerEvents(new PlayerInCombat(), this);
        getServer().getPluginManager().registerEvents(new CustomHeartItems(), this);
        //getServer().getPluginManager().registerEvents(new MontuStaffLeft(), this);
        //getServer().getPluginManager().registerEvents(new MontuStaffRight(), this);
        //getServer().getPluginManager().registerEvents(new MontuStaffShiftLeft(), this);
        //getServer().getPluginManager().registerEvents(new MontuStaffShiftRight(), this);
        getServer().getPluginManager().registerEvents(new AnvilMenuListener(), this);
        getServer().getPluginManager().registerEvents(new EndFightRestrictions(), this);
        getServer().getPluginManager().registerEvents(new AntiUseListener(), this);
        //getServer().getPluginManager().registerEvents(new SekhmetStaffDrops(), this);
        getServer().getPluginManager().registerEvents(new PlayerJoiningServer(), this);
        getServer().getPluginManager().registerEvents(new ChatFilter(), this);
        getServer().getPluginManager().registerEvents(new HomingBow(), this);
        //getServer().getPluginManager().registerEvents(new OtherCustomDrops(), this);
        //getServer().getPluginManager().registerEvents(new VoidWalkerHelm(), this);
        //getServer().getPluginManager().registerEvents(new VoidWalkerHelmEffects(), this);
        getServer().getPluginManager().registerEvents(new GracePeriod(), this);
        getServer().getPluginManager().registerEvents(new ReviveBeacon(), this);
        getServer().getPluginManager().registerEvents(new CombatLogListener(), this);
        getServer().getPluginManager().registerEvents(new DisableNetherite(), this);
        getServer().getPluginManager().registerEvents(new BeaconInvis(), this);
        //getServer().getPluginManager().registerEvents(new TeamListener(), this);
        //getServer().getPluginManager().registerEvents(new DiscordListener(), this);
        //getServer().getPluginManager().registerEvents(new TpsEvent(), this);
        BukkitRunnable broadcastTask = new BukkitRunnable() {
            @Override
            public void run() {
                broadcastServerMessage();
            }
        };
        broadcastTask.runTaskTimer(this, 0, 7200 * 20);
        BukkitRunnable broadcastShopTask = new BukkitRunnable() {
            @Override
            public void run() {
                broadcastReportBugs();
                broadcastShop();
            }
        };
        broadcastShopTask.runTaskTimer(this, 0, 3600 * 20);
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
        webHookClient();
        new BukkitRunnable() {
            @Override
            public void run() {
                sendDiscordEmbedTitle("Bot intialized", Color.MAGENTA, "");
            }
        }.runTaskLater(this, 120);
        compassUpdate();
        //checkTps();
        /*LogAppender appender = new LogAppender();
        org.apache.logging.log4j.core.Logger logger = (org.apache.logging.log4j.core.Logger) LogManager.getRootLogger();
        logger.addAppender(appender);*/
    }

    @Override
    public void onDisable() {
        if (jda != null) {
            jda.shutdownNow();
        }
        sendDiscordMessage("The server has stopped🛑", "");
    }

    @EventHandler
    public void onPlayerQuit(PlayerQuitEvent event) {
        Player player = event.getPlayer();
        if (player.getName().equals("NewAmazingPVP") && player.hasPotionEffect(PotionEffectType.INVISIBILITY)) {
            event.setQuitMessage("");
        }
    }

    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent event) {
        Player player = event.getPlayer();
        if (player.getName().equals("NewAmazingPVP")) {
            event.setJoinMessage("");
        }

        if (!player.hasPlayedBefore()) {
            player.setInvulnerable(true);
            getServer().getScheduler().runTaskLater(this, () -> player.setInvulnerable(false), 200);
            getServer().dispatchCommand(getServer().getConsoleSender(), "ep user " + player.getName() + " setgroup default");

            player.sendMessage("Welcome! \n/help\n/guide\n/rules\n/prefix\n/color\n/recipes\n/trade ");
            //giveClickableItem(player);

            //player.teleport(lobby);
        } else {
            if(player.getName().startsWith(".")){
                player.setInvulnerable(true);
                getServer().getScheduler().runTaskLater(this, () -> player.setInvulnerable(false), 120);
            } else {
                player.setInvulnerable(true);
                getServer().getScheduler().runTaskLater(this, () -> player.setInvulnerable(false), 60);
            }
        }
    }

    @EventHandler
    public void onPlayerClick(PlayerInteractEvent event) {
        Player player = event.getPlayer();
        ItemStack item = player.getInventory().getItemInMainHand();

        if (isTpBlock(item)) {
            event.setCancelled(true);
            player.teleport(player.getWorld().getSpawnLocation());
            item.setAmount(0);
        }

    }

    private boolean isTpBlock(ItemStack item) {
        ItemMeta meta = item.getItemMeta();
        return item.getType() == Material.GREEN_TERRACOTTA && meta.getLore() != null && meta.getLore().toString().contains("Click to start");
    }

    private void giveClickableItem(Player player) {
        ItemStack item = new ItemStack(Material.GREEN_TERRACOTTA);
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName(ChatColor.GREEN + "CLICK TO PLAY");
        List<String> DEFL = new ArrayList<>();
        DEFL.add(ChatColor.GOLD + "Click to start playing the Lifesteal SMP!");
        meta.setLore(DEFL);
        item.setItemMeta(meta);

        player.getInventory().setItemInMainHand(item);
    }
}
