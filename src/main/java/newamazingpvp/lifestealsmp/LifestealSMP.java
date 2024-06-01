package newamazingpvp.lifestealsmp;

import com.earth2me.essentials.Essentials;
import me.scarsz.jdaappender.ChannelLoggingHandler;
import newamazingpvp.lifestealsmp.MinecraftBINGO.BingoCommands.CommandNewBingoGame;
import newamazingpvp.lifestealsmp.MinecraftBINGO.BingoGUI.BingoCardGUIListeners;
import newamazingpvp.lifestealsmp.MinecraftBINGO.BingoCardListener;
import newamazingpvp.lifestealsmp.MinecraftBINGO.GiveBingoCardTEMP;
import newamazingpvp.lifestealsmp.MinecraftBINGO.testEvent;
import newamazingpvp.lifestealsmp.blacklistener.*;
import newamazingpvp.lifestealsmp.cometwip.GiveSekhmetSetSpeedAdmin;
import newamazingpvp.lifestealsmp.command.*;
import newamazingpvp.lifestealsmp.customitems.*;
import newamazingpvp.lifestealsmp.discord.DiscordListener;
import newamazingpvp.lifestealsmp.game.Compass;
import newamazingpvp.lifestealsmp.game.EndFightRestrictions;
import newamazingpvp.lifestealsmp.listener.*;
import newamazingpvp.lifestealsmp.nextsmpbeta.LockPlayer;
import newamazingpvp.lifestealsmp.nextsmpbeta.REMOVE_THIS_COMMAND_GIVE_ICE;
import newamazingpvp.lifestealsmp.nextsmphigh.IceCube;
import newamazingpvp.lifestealsmp.nextsmphigh.PingWars;
import newamazingpvp.lifestealsmp.runes.*;
import newamazingpvp.lifestealsmp.utility.Utils;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.plugin.messaging.PluginMessageListener;
import org.bukkit.scheduler.BukkitRunnable;
import org.jetbrains.annotations.NotNull;

import static newamazingpvp.lifestealsmp.MinecraftBINGO.BingoRecipes.registerBingoRecipes;
import static newamazingpvp.lifestealsmp.blacklistener.ChatFilter.initializeBlacklist;
import static newamazingpvp.lifestealsmp.discord.DiscordListener.isVanished;
import static newamazingpvp.lifestealsmp.game.AutoRestart.scheduleRestart;
import static newamazingpvp.lifestealsmp.game.BroadcastMessage.broadcastReportBugs;
import static newamazingpvp.lifestealsmp.game.BroadcastMessage.broadcastServerMessage;
import static newamazingpvp.lifestealsmp.game.Compass.compassUpdate;
import static newamazingpvp.lifestealsmp.game.CustomRecipe.registerCustomRecipes;
import static newamazingpvp.lifestealsmp.game.PlayerPing.monitorPlayerPings;
import static newamazingpvp.lifestealsmp.utility.AutoUpload.isAutoUploadEnabled;
import static newamazingpvp.lifestealsmp.utility.AutoUpload.startReleaseChecker;
import static newamazingpvp.lifestealsmp.utility.DiscordBot.*;
import static newamazingpvp.lifestealsmp.utility.LogAppender.consoleChannel;
import static newamazingpvp.lifestealsmp.utility.Utils.*;

public final class LifestealSMP extends JavaPlugin implements Listener, PluginMessageListener {
    public static LifestealSMP lifestealSmp;
    public static boolean silentMode = true;
    private FileConfiguration config;
    public static Essentials essentials;


    @Override
    public void onEnable() {
        //this.getServer().getMessenger().registerOutgoingPluginChannel(this, "BungeeCord");
        //this.getServer().getMessenger().registerIncomingPluginChannel(this, "BungeeCord", this);
        saveDefaultConfig();
        config = getConfig();
        lifestealSmp = this;
        new BukkitRunnable() {
            @Override
            public void run() {
                intializeBot();
                webHookClient();
            }
        }.runTaskLaterAsynchronously(this, 0L);
        startReleaseChecker();
        initializeBlacklist();
        Bukkit.getServer().getPluginManager().registerEvents(this, this);
        getCommand("rules").setExecutor(new RulesCommand());
        getCommand("setview").setExecutor(new CustomDistance());
        getCommand("recipes").setExecutor(new RecipesCommand());
        //getCommand("track").setExecutor(new Compass());
        getCommand("GiveSekhmetSet").setExecutor(new GiveSekhmetSetSpeedAdmin());
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
        getCommand("discord").setExecutor(new DiscordLink());
        getCommand("help").setExecutor(new HelpCommand());
        getCommand("guide").setExecutor(new GuideCommand());
        getCommand("givecustomitem").setExecutor(new GiveCustomItem());
        getCommand("givecustomitem").setTabCompleter(new GiveCustomItem());
        getCommand("serverruntime").setExecutor(new ServerRuntime());
        getCommand("team").setExecutor(new TeamCommand());
        getCommand("team").setTabCompleter(new TeamCommand());
        getCommand("ally").setExecutor(new AllyCommand());
        getCommand("ally").setTabCompleter(new AllyCommand());
        getCommand("prefix").setExecutor(new PrefixCommand());
        getCommand("pingWars").setExecutor(new PingWars());
        getServer().getPluginManager().registerEvents(new DisableElytra(), this);
        getServer().getPluginManager().registerEvents(new OneExpRename(), this);
        getServer().getPluginManager().registerEvents(new PlayerLagMsg(), this);
        getServer().getPluginManager().registerEvents(new SpawnProtection(), this);
        getServer().getPluginManager().registerEvents(new TeleportBow(), this);
        getServer().getPluginManager().registerEvents(new PlayerDeath(), this);
        getServer().getPluginManager().registerEvents(new EndCrystalWarning(), this);
        //getServer().getPluginManager().registerEvents(new Compass(), this);
        getServer().getPluginManager().registerEvents(new TntBow(), this);
        getServer().getPluginManager().registerEvents(new FeatherSword(), this);
        getServer().getPluginManager().registerEvents(new OpPickaxe(), this);
        getServer().getPluginManager().registerEvents(new TreeChopAxe(), this);
        getServer().getPluginManager().registerEvents(new PlayerInCombat(), this);
        getServer().getPluginManager().registerEvents(new CustomHeartItems(), this);
        getServer().getPluginManager().registerEvents(new AnvilMenuListener(), this);
        getServer().getPluginManager().registerEvents(new EndFightRestrictions(), this);
        getServer().getPluginManager().registerEvents(new AntiUseListener(), this);
        getServer().getPluginManager().registerEvents(new PlayerJoiningServer(), this);
        getServer().getPluginManager().registerEvents(new ChatFilter(), this);
        getServer().getPluginManager().registerEvents(new HomingBow(), this);
        getServer().getPluginManager().registerEvents(new GracePeriod(), this);
        getServer().getPluginManager().registerEvents(new ReviveBeacon(), this);
        getServer().getPluginManager().registerEvents(new CombatLogListener(), this);
        getServer().getPluginManager().registerEvents(new DisableNetherite(), this);
        getServer().getPluginManager().registerEvents(new BeaconInvis(), this);
        getServer().getPluginManager().registerEvents(new TeamListener(), this);
        getServer().getPluginManager().registerEvents(new DiscordListener(), this);
        getServer().getPluginManager().registerEvents(new NewbieProgression(), this);
        //getServer().getPluginManager().registerEvents(new AntiPieRay(), this);
        //getServer().getPluginManager().registerEvents(new DisableEnderDragonEgg(), this);
        //getServer().getPluginManager().registerEvents(new TpsEvent(), this);
        startTPSTracking();
        getServer().getScheduler().runTaskTimer(this, Utils::adjustPerformance, 120, 1);
        //TODO: Use this for beta things
        if (isAutoUploadEnabled()) {
            getCommand("gibIce").setExecutor(new REMOVE_THIS_COMMAND_GIVE_ICE());
            getCommand("lockPlayer").setExecutor(new LockPlayer());
            getCommand("givebingocardtemp").setExecutor(new GiveBingoCardTEMP());
            getCommand("generatenewbingogame").setExecutor(new CommandNewBingoGame());

            //getCommand("quickMaths").setExecutor(new QuickMaths());
            getServer().getPluginManager().registerEvents(new IceCube(), this);
            getServer().getPluginManager().registerEvents(new RunesDrops(), this);
            getServer().getPluginManager().registerEvents(new AquaRune(), this);
            getServer().getPluginManager().registerEvents(new LightningRune(), this);
            getServer().getPluginManager().registerEvents(new HellRune(), this);
            getServer().getPluginManager().registerEvents(new BloodRune(), this);
            getServer().getPluginManager().registerEvents(new AirRune(), this);
            getServer().getPluginManager().registerEvents(new BingoCardListener(), this);
            getServer().getPluginManager().registerEvents(new BingoCardGUIListeners(), this);
            getServer().getPluginManager().registerEvents(new testEvent(), this); //TODO:THIS IS A TEST EVENT REMOVE THIS <<<<<<<<<<<<<<<<<<<<<<<<<<

            //THESE ARE THE BINGO EVENTS TO DETECT IF A PLAYER DID A PART OF IT



            registerBingoRecipes();
            //getServer().getPluginManager().registerEvents(new BingoInvintoryProt(), this);
            //registerCustomRecipesRunes();

            //getServer().getPluginManager().registerEvents(new OtherCustomDrops(), this);
            //getServer().getPluginManager().registerEvents(new VoidWalkerHelm(), this);
            //getServer().getPluginManager().registerEvents(new VoidWalkerHelmEffects(), this);
            //getServer().getPluginManager().registerEvents(new SekhmetStaffDrops(), this);
            //getServer().getPluginManager().registerEvents(new MontuStaffLeft(), this);
            //getServer().getPluginManager().registerEvents(new MontuStaffRight(), this);
            //getServer().getPluginManager().registerEvents(new MontuStaffShiftLeft(), this);
            //getServer().getPluginManager().registerEvents(new MontuStaffShiftRight(), this);
        }
        getServer().getScheduler().runTaskTimer(this, () -> broadcastServerMessage(), 0, 7200 * 20);
        getServer().getScheduler().runTaskTimer(this, () -> getServer().dispatchCommand(getServer().getConsoleSender(), "sudo ** help"), 0, 30 * 60 * 20);
        getServer().getScheduler().runTaskTimer(this, () -> broadcastReportBugs(), 0, 3600 * 20);
        registerCustomRecipes();
        getServer().getScheduler().runTaskTimer(this, () -> monitorPlayerPings(), 0L, 20L);
        scheduleRestart();
        compassUpdate();
        //checkTps();
        new BukkitRunnable() {
            @Override
            public void run() {
                getServer().dispatchCommand(getServer().getConsoleSender(), "chunky continue");
                ChannelLoggingHandler handler = new ChannelLoggingHandler(() -> jda.getTextChannelById(consoleChannel), config -> {
                    config.setColored(true);
                    config.setSplitCodeBlockForLinks(false);
                    config.setAllowLinkEmbeds(true);
                    config.mapLoggerName("net.dv8tion.jda", "JDA");
                    config.mapLoggerName("net.minecraft.server.MinecraftServer", "Server");
                    config.mapLoggerNameFriendly("net.minecraft.server", s -> "Server/" + s);
                    config.mapLoggerNameFriendly("net.minecraft", s -> "Minecraft/" + s);
                    config.mapLoggerName("github.scarsz.discordsrv.dependencies.jda", s -> "DiscordSRV/JDA/" + s);
                }).attachLog4jLogging().schedule();
                handler.schedule();
            }
        }.runTaskLater(this, 120L);
        essentials = (Essentials) getServer().getPluginManager().getPlugin("Essentials");

        if (essentials == null) {
            getLogger().severe("EssentialsX is not installed on this server.");
            //getServer().getPluginManager().disablePlugin(this);
        }


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
        if (player.getName().equals("NewAmazingPVP") && isVanished(player) && silentMode) {
            event.setQuitMessage("");
        }
    }

    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent event) {
        Player player = event.getPlayer();
        player.sendMessage("Welcome! \n/help\n/guide\n/rules\n/prefix\n/color\n/recipes\n/trade ");
        getServer().dispatchCommand(getServer().getConsoleSender(), "sudo " + player.getName() + " help");
        player.sendMessage(ChatColor.RED + "Report any rule breakers on /discord and beware of people tricking you into taking your hearts away. Report them immediately");
        if (player.getName().equals("NewAmazingPVP") && silentMode) {
            event.setJoinMessage("");
            getServer().dispatchCommand(getServer().getConsoleSender(), "vanish NewAmazingPVP");
        }

        BukkitRunnable prefix = new BukkitRunnable() {
            @Override
            public void run() {
                if (essentials.getUser(player.getUniqueId()).getNickname() != null && essentials.getUser(player.getUniqueId()).getNickname().equals(player.getName())) {
                    setPrefix(player, ChatColor.DARK_GRAY + "[" + ChatColor.AQUA + "Player" + ChatColor.DARK_GRAY + "]" + ChatColor.YELLOW);
                }
            }
        };
        prefix.runTaskTimer(this, 0, 0L);
        if (!player.hasPlayedBefore()) {
            player.setInvulnerable(true);
            getServer().getScheduler().runTaskLater(this, () -> player.setInvulnerable(false), 200);
            setPrefix(player, ChatColor.DARK_GRAY + "[" + ChatColor.AQUA + "Player" + ChatColor.DARK_GRAY + "]" + ChatColor.YELLOW);
            getServer().getScheduler().runTaskLater(this, () -> setPrefix(player, ChatColor.DARK_GRAY + "[" + ChatColor.AQUA + "Player" + ChatColor.DARK_GRAY + "]" + ChatColor.YELLOW), 60);
            getServer().getScheduler().runTaskLater(this, () -> setPrefix(player, ChatColor.DARK_GRAY + "[" + ChatColor.AQUA + "Player" + ChatColor.DARK_GRAY + "]" + ChatColor.YELLOW), 120);
            getServer().getScheduler().runTaskLater(this, prefix::cancel, 200);
            getServer().dispatchCommand(player, "guide");
            //player.teleport(lobby);
        } else {
            if (player.getName().startsWith(".")) {
                player.setInvulnerable(true);
                BukkitRunnable bedrockInit = new BukkitRunnable() {
                    @Override
                    public void run() {
                        player.setInvulnerable(false);
                        prefix.cancel();
                    }
                };
                bedrockInit.runTaskLater(this, 120);
            } else {
                player.setInvulnerable(true);
                BukkitRunnable javaInit = new BukkitRunnable() {
                    @Override
                    public void run() {
                        player.setInvulnerable(false);
                        prefix.cancel();
                    }
                };
                javaInit.runTaskLater(this, 60);
            }
        }
    }

    @Override
    public void onPluginMessageReceived(@NotNull String s, @NotNull Player player, @NotNull byte[] bytes) {

    }

}
