package newamazingpvp.lifestealsmp;

import com.earth2me.essentials.Essentials;
import com.google.common.io.ByteArrayDataInput;
import com.google.common.io.ByteStreams;
import me.scarsz.jdaappender.ChannelLoggingHandler;
import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.format.NamedTextColor;
import newamazingpvp.lifestealsmp.allyteams.AlliesManager;
import newamazingpvp.lifestealsmp.allyteams.AllyCommand;
import newamazingpvp.lifestealsmp.allyteams.TeamCommand;
import newamazingpvp.lifestealsmp.allyteams.TeamListener;
import newamazingpvp.lifestealsmp.blacklistener.*;
import newamazingpvp.lifestealsmp.command.*;
import newamazingpvp.lifestealsmp.customitems.item.*;
import newamazingpvp.lifestealsmp.customitems.utils.AntiAnvil;
import newamazingpvp.lifestealsmp.customitems.utils.Drops;
import newamazingpvp.lifestealsmp.discord.DiscordListener;
import newamazingpvp.lifestealsmp.events.EventsHandler;
import newamazingpvp.lifestealsmp.events.TimeManager;
import newamazingpvp.lifestealsmp.game.*;
import newamazingpvp.lifestealsmp.listener.*;
import newamazingpvp.lifestealsmp.runes.DragonRune;
import newamazingpvp.lifestealsmp.runes.RuneHandler;
import newamazingpvp.lifestealsmp.unused.commands.JailPlayer;
import newamazingpvp.lifestealsmp.unused.commands.ReadBlockAndItemInfo;
import newamazingpvp.lifestealsmp.unused.customitems.QuarryArmor;
import newamazingpvp.lifestealsmp.unused.endfight.bosscommands.BeaconTestCMD;
import newamazingpvp.lifestealsmp.unused.endfight.bosscommands.NPCTestCommand;
import newamazingpvp.lifestealsmp.unused.endfight.bossevents.DeathBeaconEvent;
import newamazingpvp.lifestealsmp.unused.endfight.bosslisteners.LaunchPads;
import newamazingpvp.lifestealsmp.unused.endfight.bosslisteners.MiningListeners;
import newamazingpvp.lifestealsmp.unused.endfight.commands.BossQuickStart;
import newamazingpvp.lifestealsmp.unused.endfight.commands.StartEndBoss;
import newamazingpvp.lifestealsmp.unused.endfight.commands.StopEndBoss;
import newamazingpvp.lifestealsmp.unused.endfight.custommobs.mobs.deadminer.DeadMinerListener;
import newamazingpvp.lifestealsmp.unused.endfight.custommobs.mobs.lightningzombie.LightningZombieListener;
import newamazingpvp.lifestealsmp.unused.endfight.custommobs.mobs.minishadow.listeners.MiniShadowAttackPlayer;
import newamazingpvp.lifestealsmp.unused.endfight.custommobs.mobs.minishadow.listeners.MiniShadowAttackedByPlayer;
import newamazingpvp.lifestealsmp.unused.endfight.custommobs.mobs.shadow.listeners.ShadowAttackPlayer;
import newamazingpvp.lifestealsmp.unused.endfight.custommobs.mobs.shadow.listeners.ShadowAttackedByPlayer;
import newamazingpvp.lifestealsmp.unused.events.corruptedmobs.commands.SpawnCmd;
import newamazingpvp.lifestealsmp.unused.events.corruptedmobs.mobs.engima.events.EnigmaAttack;
import newamazingpvp.lifestealsmp.unused.events.corruptedmobs.mobs.engima.events.EnigmaDamagedAndKilled;
import newamazingpvp.lifestealsmp.unused.events.corruptedmobs.mobs.engima.events.EnigmaGUI;
import newamazingpvp.lifestealsmp.unused.events.corruptedmobs.mobs.hydra.events.HydraAttack;
import newamazingpvp.lifestealsmp.unused.events.corruptedmobs.mobs.hydra.events.HydraDamagedOrKilled;
import newamazingpvp.lifestealsmp.unused.events.corruptedmobs.mobs.mage.events.MageHitAndKilled;
import newamazingpvp.lifestealsmp.unused.events.corruptedmobs.utilities.AntiItemUse;
import newamazingpvp.lifestealsmp.unused.events.raffle.commands.StartRaffleEvent;
import newamazingpvp.lifestealsmp.unused.events.raffle.commands.StopRaffleEvent;
import newamazingpvp.lifestealsmp.unused.events.raffle.events.ClearOldBingoTags;
import newamazingpvp.lifestealsmp.unused.events.raffle.events.Mining;
import newamazingpvp.lifestealsmp.unused.events.raffle.events.PlayerBossBar;
import newamazingpvp.lifestealsmp.unused.events.raffle.events.SubmitTicket;
import newamazingpvp.lifestealsmp.unused.magicstaffs.abilities.Default;
import newamazingpvp.lifestealsmp.unused.magicstaffs.utils.GUI;
import newamazingpvp.lifestealsmp.unused.mcbingo.gui.BingoCardGUIListeners;
import newamazingpvp.lifestealsmp.unused.visualeffects.DroppedItemParticles;
import newamazingpvp.lifestealsmp.utility.Metrics;
import newamazingpvp.lifestealsmp.utility.Utils;
import newamazingpvp.lifestealsmp.visuals.CustomToasts.LoginToast;
import newamazingpvp.lifestealsmp.visuals.HpBar;
import newamazingpvp.lifestealsmp.visuals.HpNameTag;
import org.bukkit.Bukkit;
import org.bukkit.World;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.plugin.messaging.PluginMessageListener;
import org.bukkit.scheduler.BukkitRunnable;

import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.io.IOException;

import static newamazingpvp.lifestealsmp.blacklistener.ChatFilter.initializeBlacklist;
import static newamazingpvp.lifestealsmp.customitems.utils.DevRecipes.registerCustomRecipesDev;
import static newamazingpvp.lifestealsmp.customitems.utils.Recipes.registerBasicRecipes;
import static newamazingpvp.lifestealsmp.customitems.utils.Recipes.registerCustomRecipes;
import static newamazingpvp.lifestealsmp.discord.DiscordBot.*;
import static newamazingpvp.lifestealsmp.discord.LogAppender.consoleChannel;
import static newamazingpvp.lifestealsmp.events.TimeManager.doEvents;
import static newamazingpvp.lifestealsmp.game.AutoRestart.scheduleRestart;
import static newamazingpvp.lifestealsmp.game.CombatLog.cancelCombatData;
import static newamazingpvp.lifestealsmp.game.CombatLog.removeEnemies;
import static newamazingpvp.lifestealsmp.game.Compass.compassUpdate;
import static newamazingpvp.lifestealsmp.utility.Utils.startTPSTracking;

public final class LifestealSMP extends JavaPlugin implements Listener, PluginMessageListener {
    public static LifestealSMP lifestealSmp;
    public static boolean silentMode = true;
    public static boolean unbanChunkBan = false;
    private FileConfiguration config;
    public static Essentials essentials;
    public static boolean isSmp = true;

    public static World SMPworld = Bukkit.getWorld("world");
    public static final String PLUGIN_WATERMARK = "© 2024 [NewAmazingPVP & Comet99] - [LifestealSMP]";


    @Override
    public void onEnable() {
        getLogger().info("Starting " + PLUGIN_WATERMARK);
        getLogger().info("This plugin was developed by NewAmazingPVP and Comet99. Please provide attribution if you use it and abide by the licenses. You are not allowed to use this if you are not an active contributor");
        new Metrics(this, 22552);
        getServer().getMessenger().registerIncomingPluginChannel(this, "nappixel:lifesteal", this);
        getServer().getMessenger().registerOutgoingPluginChannel(this, "nappixel:lifesteal");
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
        //startReleaseChecker();
        initializeBlacklist();
        Bukkit.getServer().getPluginManager().registerEvents(this, this);
        getCommand("rules").setExecutor(new RulesCommand());
        getCommand("setview").setExecutor(new CustomDistance());
        getCommand("recipes").setExecutor(new RecipesCommand());
        getCommand("track").setExecutor(new Compass());
        getCommand("restart_with_warning").setExecutor(new RestartWithWarming());
        getCommand("remHP").setExecutor(new RemoveHP());
        getCommand("addHP").setExecutor(new AddHP());
        getCommand("LSwithdraw").setExecutor(new LSwithdraw());
        getCommand("startEndFight").setExecutor(new StartEndFight());
        getCommand("stopEndFight").setExecutor(new StopEndFight());
        getCommand("reviveplayer").setExecutor(new RevivePlayer());
        getCommand("vision").setExecutor(new NightVision());
        getCommand("senddiscordmessage").setExecutor(new SendDiscordMessage());
        getCommand("discord").setExecutor(new DiscordLink());
        getCommand("help").setExecutor(new HelpCommand());
        getCommand("guide").setExecutor(new GuideCommand());
        getCommand("givecustomitem").setExecutor(new GiveCustomItem());
        getCommand("givecustomitem").setTabCompleter(new GiveCustomItem());
        getCommand("serverruntime").setExecutor(new ServerRuntime());
        getCommand("team").setExecutor(new TeamCommand());
        getCommand("team").setTabCompleter(new TeamCommand());
        AlliesManager.loadAllyData();
        getCommand("ally").setExecutor(new AllyCommand());
        getCommand("ally").setTabCompleter(new AllyCommand());
        getCommand("prefix").setExecutor(new PrefixCommand());
        getCommand("pingWars").setExecutor(new PingWars());
        getCommand("jailplayer").setExecutor(new JailPlayer());
        getCommand("betterban").setExecutor(new BetterBan());
        getCommand("unbanall").setExecutor(new UnbanAll());
        getCommand("rune").setExecutor(new RunesCommand());
        getCommand("adminrune").setExecutor(new AdminRunes());
        getCommand("stat").setExecutor(new StatisticManager());
        getCommand("worldteleport").setExecutor(new WorldTeleport());
        getCommand("tpuhc").setExecutor(new UhcTeleport());
        getCommand("spawn").setExecutor(new SpawnCommand());
        getCommand("getitemorblockdata").setExecutor(new ReadBlockAndItemInfo());
        getCommand("nonvanillamechanics").setExecutor(new NonVanillaMechanics());
        getServer().getPluginManager().registerEvents(new OneExpRename(), this);
        getServer().getPluginManager().registerEvents(new AntiBurn(), this);
        getServer().getPluginManager().registerEvents(new PlayerMsg(), this);
        getServer().getPluginManager().registerEvents(new PlayerDeath(), this);
        getServer().getPluginManager().registerEvents(new EndCrystalWarning(), this);
        getServer().getPluginManager().registerEvents(new DisableMace(), this);
        getServer().getPluginManager().registerEvents(new Compass(), this);
        getServer().getPluginManager().registerEvents(new HeartItems(), this);
        getServer().getPluginManager().registerEvents(new AnvilMenuListener(), this);
        getServer().getPluginManager().registerEvents(new EndFightRestrictions(), this);
        getServer().getPluginManager().registerEvents(new AntiUseListener(), this);
        getServer().getPluginManager().registerEvents(new JoinLeave(), this);
        getServer().getPluginManager().registerEvents(new ChatFilter(), this);
        //getServer().getPluginManager().registerEvents(new HomingBow(), this);
        //getServer().getPluginManager().registerEvents(new TntBow(), this);
        //getServer().getPluginManager().registerEvents(new FeatherSword(), this);
        //getServer().getPluginManager().registerEvents(new OpPickaxe(), this);
        //getServer().getPluginManager().registerEvents(new TreeChopAxe(), this);
        //getServer().getPluginManager().registerEvents(new TeleportBow(), this);
        //getServer().getPluginManager().registerEvents(new DragonEggPerk(), this);
        //getServer().getPluginManager().registerEvents(new LightFeather(), this);
        //getServer().getPluginManager().registerEvents(new InstaboomTNT(), this);
        //getServer().getPluginManager().registerEvents(new Drops(), this);
        //getServer().getPluginManager().registerEvents(new LifestealStick(), this);
        //getServer().getPluginManager().registerEvents(new SomberCrystal(), this);
        //getServer().getPluginManager().registerEvents(new MusicBox(), this);
        getServer().getPluginManager().registerEvents(new CombatProtectionHandler(), this);
        getServer().getPluginManager().registerEvents(new ReviveBeacon(), this);
        getServer().getPluginManager().registerEvents(new CombatLogListener(), this);
        getServer().getPluginManager().registerEvents(new TeamListener(), this);
        getServer().getPluginManager().registerEvents(new DiscordListener(), this);
        //getServer().getPluginManager().registerEvents(new DisableNetherite(), this);
        getServer().getPluginManager().registerEvents(new NewbieProgression(), this);
        getServer().getPluginManager().registerEvents(new AntiEnd(), this);
        getServer().getPluginManager().registerEvents(new ServerOpening(), this);
        getServer().getPluginManager().registerEvents(new PlayerBan(), this);
        getServer().getPluginManager().registerEvents(new InfiniteStorage(), this);
        getServer().getPluginManager().registerEvents(new EventsHandler(), this);
        getServer().getPluginManager().registerEvents(new NerfOpItems(), this);
        getServer().getPluginManager().registerEvents(new DisableCustomItems(), this);
        getServer().getPluginManager().registerEvents(new Disenchant(), this);
        getServer().getPluginManager().registerEvents(new AntiChunkBan(), this);
        startTPSTracking();
        getServer().getScheduler().runTaskTimer(this, Utils::adjustPerformance, 120, 1);
        getCommand("trade").setExecutor(new Trade());
        getServer().getPluginManager().registerEvents(new TradeListener(), this);
        registerBasicRecipes();
        registerCustomItemsAndRunes();
        if (config.get("Discord.Smp") != null) {
            isSmp = config.getBoolean("Discord.Smp");
        }
        if (isSmp) {
            getServer().getPluginManager().registerEvents(new SpawnProtection(), this);
        }
        doEvents();
        Bukkit.getScheduler().runTaskTimer(this, TimeManager::timeBasedEvents, 20, 20);

        //TODO: Use this for beta things
        if (!isSmp) {
            //getCommand("gibIce").setExecutor(new REMOVE_THIS_COMMAND_GIVE_ICE());
            //getCommand("lockPlayer").setExecutor(new LockPlayer());
            //getCommand("givebingocardtemp").setExecutor(new GiveBingoCardTEMP());
            //getCommand("generatenewbingogame").setExecutor(new CommandNewBingoGame());
            //lil

            //getCommand("quickMaths").setExecutor(new QuickMaths());
            //getServer().getPluginManager().registerEvents(new IceCube(), this);
            //getServer().getPluginManager().registerEvents(new RunesDrops(), this);
            //getServer().getPluginManager().registerEvents(new AquaRune(), this);
            //getServer().getPluginManager().registerEvents(new LightningRune(), this);
            //getServer().getPluginManager().registerEvents(new HellRune(), this);
            //getServer().getPluginManager().registerEvents(new BloodRune(), this);
            //getServer().getPluginManager().registerEvents(new AirRune(), this);
            //getServer().getPluginManager().registerEvents(new BingoCardListener(), this);
            getServer().getPluginManager().registerEvents(new BingoCardGUIListeners(), this);
            //New Custom Items


            getServer().getPluginManager().registerEvents(new QuarryArmor(), this);

            getServer().getPluginManager().registerEvents(new AntiAnvil(), this);
            //getServer().getPluginManager().registerEvents(new MagicStaffAir(), this);

            //magic staffs
            getServer().getPluginManager().registerEvents(new GUI(), this);
            getServer().getPluginManager().registerEvents(new Default(), this);
            getCommand("openmagicstaffmenu").setExecutor(new MagicStaffMenu());
            getCommand("createtestnpc").setExecutor(new NPCTestCommand());


            getServer().getPluginManager().registerEvents(new LoginToast(), this);
            getCommand("showcustomtoast").setExecutor(new ShowCustomToastCMD());


            //Comet Trident
            getServer().getPluginManager().registerEvents(new CometTrident(), this);


            //test
            getServer().getPluginManager().registerEvents(new DroppedItemParticles(), this);


            //Mob test
            getServer().getPluginManager().registerEvents(new LightningZombieListener(), this);

            getServer().getPluginManager().registerEvents(new DeadMinerListener(), this);

            getServer().getPluginManager().registerEvents(new ShadowAttackPlayer(), this);
            getServer().getPluginManager().registerEvents(new ShadowAttackedByPlayer(), this);

            getServer().getPluginManager().registerEvents(new MiniShadowAttackPlayer(), this);
            getServer().getPluginManager().registerEvents(new MiniShadowAttackedByPlayer(), this);
            getServer().getPluginManager().registerEvents(new DeathBeaconEvent(), this);
            getServer().getPluginManager().registerEvents(new MiningListeners(), this);
            getServer().getPluginManager().registerEvents(new LaunchPads(), this);
            //getServer().getPluginManager().registerEvents(new BlockPushTest(), this);

            registerCustomRecipesDev();

            getCommand("deathbeacontest").setExecutor(new BeaconTestCMD());

            getCommand("bossstart").setExecutor(new StartEndBoss());
            getCommand("bossstop").setExecutor(new StopEndBoss());
            getCommand("bossquickstart").setExecutor(new BossQuickStart());

            //getServer().getPluginManager().registerEvents(new DamageIndicator(), this);
            getServer().getPluginManager().registerEvents(new HpBar(), this);
            getServer().getPluginManager().registerEvents(new HpNameTag(), this);

            //===================== Raffle Event Listeners =======================
            getServer().getPluginManager().registerEvents(new Mining(), this);
            getServer().getPluginManager().registerEvents(new ClearOldBingoTags(), this);
            getServer().getPluginManager().registerEvents(new SubmitTicket(), this);
            getServer().getPluginManager().registerEvents(new PlayerBossBar(), this);
            getServer().getPluginManager().registerEvents(new EnigmaGUI(), this);
            getServer().getPluginManager().registerEvents(new EnigmaAttack(), this);
            getServer().getPluginManager().registerEvents(new EnigmaDamagedAndKilled(), this);
            getServer().getPluginManager().registerEvents(new MageHitAndKilled(), this);
            getServer().getPluginManager().registerEvents(new AntiItemUse(), this);
            getServer().getPluginManager().registerEvents(new HydraAttack(), this);
            getServer().getPluginManager().registerEvents(new HydraDamagedOrKilled(), this);
            //getServer().getPluginManager().registerEvents(new BlockPlaceTracker(), this);
            getCommand("raffleeventstart").setExecutor(new StartRaffleEvent());
            getCommand("raffleeventstop").setExecutor(new StopRaffleEvent());
            getCommand("spawncustommob").setExecutor(new SpawnCmd());


            //getCommand("trade").setExecutor(new Trade());
            //getServer().getPluginManager().registerEvents(new TradeListener(), this);

            //THESE ARE THE BINGO EVENTS TO DETECT IF A PLAYER DID A PART OF IT

            //registerBingoRecipes();
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
        getServer().getScheduler().runTaskTimer(this, BroadcastMessage::broadcastServerMessage, 0, 7200 * 20);
        getServer().getScheduler().runTaskTimer(this, () -> getServer().dispatchCommand(getServer().getConsoleSender(), "sudo ** help"), 0, 30 * 60 * 20);
        getServer().getScheduler().runTaskTimer(this, () -> getServer().dispatchCommand(getServer().getConsoleSender(), "sudo ** nonvanillamechanics"), 0, 27 * 60 * 20);
        getServer().getScheduler().runTaskTimer(this, () -> getServer().dispatchCommand(getServer().getConsoleSender(), "sudo ** discord"), 0, 22 * 60 * 20);
        getServer().getScheduler().runTaskTimer(this, () ->
                        getServer().dispatchCommand(getServer().getConsoleSender(),
                                "broadcast &b[Tip] &fStruggling with low hearts or gear? You don't have to rely solely on PvP for hearts! &bYou can craft hearts &fand keep progressing from rare mob drops (do /recipes), even if you're not ready to fight. &bCheck out /recipes &ffor the Heart Equalizer – a custom item that balances PvP damage based on heart ratios, so you're never at a disadvantage. &fAnother strategy? Build a mob farm! Collect mob drops and craft your way to more hearts with custom items!"),
                0, 22 * 60 * 20);
        getServer().getScheduler().runTaskTimer(this, BroadcastMessage::broadcastReportBugs, 0, 3600 * 20);
        getServer().getScheduler().runTaskTimer(this, PlayerPing::monitorPlayerPings, 0L, 20L);
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
                    if (isSmp) {
                        config.addFilter(logItem -> {
                            String message = logItem.getMessage();
                            return message.contains("not pass event");
                        });
                    }
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
        AlliesManager.saveAllyData();
    }

    @Override
    public void onPluginMessageReceived(String channel, Player player, byte[] message) {
        if (!channel.equals("nappixel:lifesteal")) {
            return;
        }
        ByteArrayDataInput in = ByteStreams.newDataInput(message);
        String subchannel = in.readUTF();
        if (subchannel.equals("forceRestart")) {
            short len = in.readShort();
            byte[] msgbytes = new byte[len];
            in.readFully(msgbytes);

            DataInputStream msgIn = new DataInputStream(new ByteArrayInputStream(msgbytes));
            try {
                String secretMessage = msgIn.readUTF();
                if (secretMessage.equals("forceRestartLOL")) {
                    for (Player p : Bukkit.getOnlinePlayers()) {
                        cancelCombatData(p);
                        removeEnemies(p);
                        p.kick(Component.text("Proxy is restarting.... Please reconnect").color(NamedTextColor.DARK_RED));
                    }
                }

            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            try {
                short meaningofLife = msgIn.readShort();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }


        /*ByteArrayDataInput in = ByteStreams.newDataInput(message);
        String subchannel = in.readUTF();
        if (subchannel.equals("forceRestart")) {
            for (Player p : Bukkit.getOnlinePlayers()) {
                cancelCombatData(p);
                removeEnemies(p);
                p.kick(Component.text("Proxy is restarting.... Please reconnect").color(NamedTextColor.DARK_RED));
            }
        }*/
        /*
        ByteArrayDataInput dataInput = ByteStreams.newDataInput(bytes);

        try {
            String receivedMessage = dataInput.readUTF();
            System.out.println(receivedMessage);
            if ("forceRestart".equals(receivedMessage)) {
                for (Player p : Bukkit.getOnlinePlayers()) {
                    cancelCombatData(p);
                    removeEnemies(p);
                    p.kick(Component.text("Proxy is restarting.... Please reconnect").color(NamedTextColor.DARK_RED));
                }
            }
        } catch (Exception e) {
            Bukkit.getLogger().severe("An error occurred while processing plugin message: " + e.getMessage());
            e.printStackTrace();
        }*/
    }


    public static void registerCustomItemsAndRunes() {
        registerCustomRecipes();
        Bukkit.getPluginManager().registerEvents(new DragonRune(), lifestealSmp);
        Bukkit.getPluginManager().registerEvents(new RuneHandler(), lifestealSmp);
        Bukkit.getPluginManager().registerEvents(new HomingBow(), lifestealSmp);
        Bukkit.getPluginManager().registerEvents(new TntBow(), lifestealSmp);
        Bukkit.getPluginManager().registerEvents(new FeatherSword(), lifestealSmp);
        Bukkit.getPluginManager().registerEvents(new OpPickaxe(), lifestealSmp);
        Bukkit.getPluginManager().registerEvents(new TreeChopAxe(), lifestealSmp);
        Bukkit.getPluginManager().registerEvents(new TeleportBow(), lifestealSmp);
        Bukkit.getPluginManager().registerEvents(new DragonEggPerk(), lifestealSmp);
        Bukkit.getPluginManager().registerEvents(new LightFeather(), lifestealSmp);
        Bukkit.getPluginManager().registerEvents(new InstaboomTnt(), lifestealSmp);
        Bukkit.getPluginManager().registerEvents(new Drops(), lifestealSmp);
        Bukkit.getPluginManager().registerEvents(new LifestealStick(), lifestealSmp);
        Bukkit.getPluginManager().registerEvents(new SomberCrystal(), lifestealSmp);
        Bukkit.getPluginManager().registerEvents(new MusicBox(), lifestealSmp);
        Bukkit.getPluginManager().registerEvents(new HeartEqualizer(), lifestealSmp);
    }


}
