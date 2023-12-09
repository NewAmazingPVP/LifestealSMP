package newamazingpvp.lifestealsmp;

import newamazingpvp.lifestealsmp.command.*;
import newamazingpvp.lifestealsmp.customitemdrops.CustomHeartItems;
import newamazingpvp.lifestealsmp.customitemdrops.OtherCustomDrops;
import newamazingpvp.lifestealsmp.customitemdrops.SekhmetStaffDrops;
import newamazingpvp.lifestealsmp.game.Compass;
import newamazingpvp.lifestealsmp.game.EndFightRestrictions;
import newamazingpvp.lifestealsmp.legacymontustaff.*;
import newamazingpvp.lifestealsmp.listener.*;
import newamazingpvp.lifestealsmp.sekhmetitems.GiveSekhmetSetSpeedADMINONLY;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scheduler.BukkitRunnable;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

import static newamazingpvp.lifestealsmp.game.AutoRestart.scheduleRestart;
import static newamazingpvp.lifestealsmp.game.BroadcastMessage.broadcastServerMessage;
import static newamazingpvp.lifestealsmp.game.Compass.compassUpdate;
import static newamazingpvp.lifestealsmp.game.CustomRecipe.registerCustomRecipes;
import static newamazingpvp.lifestealsmp.game.PlayerPing.monitorPlayerPings;
import static newamazingpvp.lifestealsmp.listener.ChatFilter.initializeBlacklist;
import static newamazingpvp.lifestealsmp.utility.AutoUpload.startReleaseChecker;
import static newamazingpvp.lifestealsmp.utility.DiscordBot.*;
import static newamazingpvp.lifestealsmp.variables.Loc.lobby;

public final class LifestealSMP extends JavaPlugin implements Listener {
    public static LifestealSMP lifestealSmp;
    private FileConfiguration config;



    @Override
    public void onEnable() {
        saveDefaultConfig();
        config = getConfig();
        lifestealSmp = this;
        startReleaseChecker();
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
        getCommand("customprefix").setExecutor(new CustomPrefixAdmin());
        getCommand("vision").setExecutor(new NightVision());
        getCommand("senddiscordmessage").setExecutor(new SendDiscordMessage());
        getCommand("shop").setExecutor(new ShopCommand());
        getServer().getPluginManager().registerEvents(new DisableElytra(), this);
        getServer().getPluginManager().registerEvents(new OneExpRename(), this);
        getServer().getPluginManager().registerEvents(new PlayerLagMsg(), this);
        //getServer().getPluginManager().registerEvents(new SpawnProtection(), this);
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
        compassUpdate();
    }

    @Override
    public void onDisable() {
        if (jda != null) {
            jda.shutdownNow();
        }
    }


    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent event) {
        Player player = event.getPlayer();

        player.setInvulnerable(true);
        getServer().getScheduler().runTaskLater(this, () -> player.setInvulnerable(false), 60);

        if (!player.hasPlayedBefore()) {
            getServer().dispatchCommand(getServer().getConsoleSender(), "ep user " + player.getName() + " setgroup default");

            player.sendMessage("Welcome! \n/rules\n/prefix\n/color\n/recipes ");
            giveClickableItem(player);

            player.teleport(lobby);
        }
    }

    @EventHandler
    public void onPlayerClick(PlayerInteractEvent event) {
        Player player = event.getPlayer();
        ItemStack item = player.getInventory().getItemInMainHand();

        if (item != null && item.getType() == Material.GREEN_TERRACOTTA && item.hasItemMeta()) {
            ItemMeta meta = item.getItemMeta();

            if (meta.hasDisplayName() && meta.getLore().contains("playing")) {
                player.teleport(player.getWorld().getSpawnLocation());
            }
        }
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
