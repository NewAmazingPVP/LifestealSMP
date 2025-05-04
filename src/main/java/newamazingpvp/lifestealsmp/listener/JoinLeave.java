package newamazingpvp.lifestealsmp.listener;

import newamazingpvp.lifestealsmp.command.DiscordLink;
import newamazingpvp.lifestealsmp.command.HelpCommand;
import newamazingpvp.lifestealsmp.command.NonVanillaMechanics;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.scheduler.BukkitRunnable;

import static newamazingpvp.lifestealsmp.LifestealSMP.*;
import static newamazingpvp.lifestealsmp.discord.DiscordListener.isVanished;
import static newamazingpvp.lifestealsmp.game.PlayerLifeManager.isEliminated;
import static newamazingpvp.lifestealsmp.utility.Admin.admins;
import static newamazingpvp.lifestealsmp.utility.Utils.addItemOrDrop;
import static newamazingpvp.lifestealsmp.utility.Utils.setPrefix;
import static org.bukkit.Bukkit.getServer;

public class JoinLeave implements Listener {

    @EventHandler
    public void onJoin(PlayerJoinEvent event) {
        Player player = event.getPlayer();
        if (isEliminated(player)) {
            player.kickPlayer(ChatColor.RED + "You were eliminated! Ask someone to use a revive beacon to revive you!");
            return;
        }
        player.sendTitle(ChatColor.DARK_GREEN + "Welcome!", "", 0, 70, 20);
        player.sendMessage("Welcome! \n/help\n/guide\n/rules\n/prefix\n/color\n/recipes\n/trade ");
        player.sendMessage(ChatColor.DARK_PURPLE + "" + ChatColor.BOLD + "=============== [Welcome] ===============");
        player.sendMessage(ChatColor.AQUA + "Use" + ChatColor.RED + " /guide" + ChatColor.AQUA + " For info book.");
        //player.sendMessage(ChatColor.AQUA + "Use" + ChatColor.RED + " /IPHelp" + ChatColor.AQUA + " For info on how to get more then one account on the same IP.");
        player.sendMessage(ChatColor.AQUA + "Use" + ChatColor.RED + " /recipes" + ChatColor.AQUA + " For recipe info.");
        player.sendMessage(ChatColor.AQUA + "Use" + ChatColor.RED + " /discord" + ChatColor.AQUA + " For the discord link.");
        player.sendMessage(ChatColor.GRAY + "(also how you send appeals and reports)");
        //player.sendMessage(ChatColor.AQUA + "Use" + ChatColor.RED + " /easyprefix" + ChatColor.AQUA + " To change your name prefix");
        player.sendMessage(ChatColor.DARK_PURPLE + "" + ChatColor.BOLD + "=========================================");

        player.playSound(player.getLocation(), Sound.ENTITY_PLAYER_LEVELUP, 1.0f, 1.0f);

//        getServer().dispatchCommand(getServer().getConsoleSender(), "sudo " + player.getName() + " nonvanillamechanics");
//        getServer().dispatchCommand(getServer().getConsoleSender(), "sudo " + player.getName() + " help");
//        getServer().dispatchCommand(getServer().getConsoleSender(), "sudo " + player.getName() + " discord");

        getServer().getScheduler().runTask(lifestealSmp, () -> {
            NonVanillaMechanics.nonVanillaMechanics(player);
            HelpCommand.help(player);
            DiscordLink.discordURL(player);
        });

        getServer().getScheduler().runTaskLater(lifestealSmp, () -> player.sendMessage(ChatColor.RED + "Report any rule breakers on /discord and beware of people tricking you into taking your hearts away. Make your base safe locations such as underground to prevent it from being griefed."), 200);
        if ((player.getName().equals("NewAmazingPVP") || admins.contains(player.getName())) && silentMode) {
            event.setJoinMessage("");
            getServer().dispatchCommand(getServer().getConsoleSender(), "vanish " + player.getName());
        } else {
            if (essentials.getUser(event.getPlayer()).getNickname() != null) {
                event.setJoinMessage(essentials.getUser(event.getPlayer()).getNickname() + ChatColor.GOLD + " joined the game!");
            }
        }

        BukkitRunnable prefix = new BukkitRunnable() {
            @Override
            public void run() {
                if (essentials.getUser(player.getUniqueId()).getNickname() != null && essentials.getUser(player.getUniqueId()).getNickname().equals(player.getName())) {
                    setPrefix(player, ChatColor.DARK_GRAY + "[" + ChatColor.AQUA + "Player" + ChatColor.DARK_GRAY + "]" + ChatColor.YELLOW);
                }
                if (essentials.getUser(player.getUniqueId()).getNickname() != null && !essentials.getUser(player.getUniqueId()).getNickname().equals(player.getName())) {
                    if (!essentials.getUser(player.getUniqueId()).getNickname().contains(player.getName())) {
                        setPrefix(player, ChatColor.DARK_GRAY + "[" + ChatColor.AQUA + "Player" + ChatColor.DARK_GRAY + "]" + ChatColor.YELLOW);
                    }
                }
            }
        };
        prefix.runTaskTimer(lifestealSmp, 0, 0L);
        if (!player.hasPlayedBefore()) {
            player.setInvulnerable(true);
            getServer().getScheduler().runTaskLater(lifestealSmp, () -> player.setInvulnerable(false), 200);
            setPrefix(player, ChatColor.DARK_GRAY + "[" + ChatColor.AQUA + "Player" + ChatColor.DARK_GRAY + "]" + ChatColor.YELLOW);
            getServer().getScheduler().runTaskLater(lifestealSmp, () -> setPrefix(player, ChatColor.DARK_GRAY + "[" + ChatColor.AQUA + "Player" + ChatColor.DARK_GRAY + "]" + ChatColor.YELLOW), 60);
            getServer().getScheduler().runTaskLater(lifestealSmp, () -> setPrefix(player, ChatColor.DARK_GRAY + "[" + ChatColor.AQUA + "Player" + ChatColor.DARK_GRAY + "]" + ChatColor.YELLOW), 120);
            getServer().getScheduler().runTaskLater(lifestealSmp, prefix::cancel, 200);
            getServer().dispatchCommand(player, "guide");
            //below is new season stuff
            addItemOrDrop(player, new ItemStack(Material.DARK_OAK_LOG, 16), "");
            addItemOrDrop(player, new ItemStack(Material.COOKED_BEEF, 16), "");
            addItemOrDrop(player, new ItemStack(Material.DARK_OAK_BOAT, 1), "");
            addItemOrDrop(player, new ItemStack(Material.ENDER_PEARL, 1), "");
            //player.teleport(lobby);
            //player.teleport(new Location(Bukkit.getWorld("world"), 6, 75, -26));
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
                bedrockInit.runTaskLater(lifestealSmp, 120);
            } else {
                player.setInvulnerable(true);
                BukkitRunnable javaInit = new BukkitRunnable() {
                    @Override
                    public void run() {
                        player.setInvulnerable(false);
                        prefix.cancel();
                    }
                };
                javaInit.runTaskLater(lifestealSmp, 60);
            }
        }
    }

    @EventHandler
    public void onPlayerQuit(PlayerQuitEvent event) {
        Player player = event.getPlayer();
        if ((player.getName().equals("NewAmazingPVP") || admins.contains(player.getName())) && isVanished(player) && silentMode) {
            event.setQuitMessage("");
        }
    }

}
