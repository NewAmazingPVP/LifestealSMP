package newamazingpvp.lifestealsmp.game;

import com.destroystokyo.paper.event.player.PlayerTeleportEndGatewayEvent;
import org.bukkit.*;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityPortalEvent;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.event.player.PlayerChangedWorldEvent;
import org.bukkit.event.player.PlayerLoginEvent;
import org.bukkit.event.player.PlayerPortalEvent;
import org.bukkit.event.player.PlayerRespawnEvent;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.util.Vector;

import java.awt.Color;

import static newamazingpvp.lifestealsmp.LifestealSMP.lifestealSmp;
import static newamazingpvp.lifestealsmp.discord.DiscordBot.sendDiscordEmbedPlayer;
import static newamazingpvp.lifestealsmp.discord.DiscordBot.sendDiscordNewsEmbedPlayer;
import static newamazingpvp.lifestealsmp.variables.Misc.isEndFightEnabled;
import static org.bukkit.Bukkit.getServer;

public class EndFightRestrictions implements Listener {
    @EventHandler
    public void portalLeave(PlayerPortalEvent e) {
        if (isEndFightEnabled) {
            e.getPlayer().sendMessage(ChatColor.RED + "You cannot use portal during end fight!");
            e.setCancelled(true);
        }
    }

    @EventHandler
    public void worldSwitch(PlayerChangedWorldEvent e) {
        if (isEndFightEnabled) {
            e.getPlayer().sendMessage(ChatColor.RED + "You cannot use portal during end fight!");
            e.getPlayer().teleportAsync(new Location(Bukkit.getWorld("end_fight_world"), 0, 70.0, 0));
        }
    }

    @EventHandler
    public void entityPortal(EntityPortalEvent e) {
        if (isEndFightEnabled) {
            e.setCancelled(true);
        }
    }

    @EventHandler
    public void portalLeave(PlayerTeleportEndGatewayEvent e) {
        if (isEndFightEnabled) {
            e.getPlayer().sendMessage(ChatColor.RED + "You cannot use portal during end fight!");
            e.setCancelled(true);
        }
    }

    @EventHandler
    public void playerJoin(PlayerLoginEvent e) {
        if (isEndFightEnabled) {
            OfflinePlayer f = e.getPlayer();
            /*if (!(endFightParticipants.contains(e.getPlayer().getName()) || lifestealSmp.getServer().getWhitelistedPlayers().contains(f))) {
                e.disallow(PlayerLoginEvent.Result.KICK_OTHER, "Sorry you cannot join during end fight!");
                lifestealSmp.getServer().broadcastMessage(e.getPlayer().getName() + " tried during end fight but isn't whitelisted");
            }*/
            //!(endFightParticipants.contains(e.getPlayer().getName()))
            new BukkitRunnable() {
                @Override
                public void run() {
                    if (!e.getPlayer().getWorld().getName().equals("end_fight_world")) {
                        e.getPlayer().teleportAsync(new Location(Bukkit.getWorld("end_fight_world"), 0, 70.0, 0));
                        e.getPlayer().sendMessage(ChatColor.AQUA + "You joined during the server final end fight and were teleported right to it!");
                        //teleport player to end spawn for fight
                    }
                }
            }.runTaskLater(lifestealSmp, 20L);
        }
    }

    /*@EventHandler
    public void playerDamage(EntityDamageByEntityEvent e) {
        if (isEndFightEnabled && e.getEntity() instanceof Player && (e.getDamager() instanceof Player || e.getDamager() instanceof Arrow)) {
            Player p = (Player) e.getEntity();
            double totalHP = p.getMaxHealth() - e.getFinalDamage();
            if (totalHP < 1.0) {
                p.banPlayer(ChatColor.RED + "You were eliminated! GF!");
                sendDiscordEmbedPlayer(p.getName() + " was eliminated from end fight! GF!", Color.YELLOW, "", p.getName());
                lifestealSmp.getServer().broadcastMessage(ChatColor.GOLD + p.getName() + " was eliminated GF!");
                return;
            }
            //p.setMaxHealth(p.getMaxHealth() - e.getFinalDamage());
        }
    }*/

    @EventHandler
    public void onPlayerDeath(PlayerDeathEvent e) {
        if (isEndFightEnabled) {
            Player p = e.getEntity();
            p.sendMessage(ChatColor.RED + "You were eliminated GF!");
            sendDiscordEmbedPlayer(p.getName() + " was eliminated from end fight GF!", Color.YELLOW, "", p.getName());
            lifestealSmp.getServer().broadcastMessage(ChatColor.GOLD + p.getName() + " was eliminated GF!");
        }
    }

    @EventHandler
    public void onPlayerRespawn(PlayerRespawnEvent e) {
        if (isEndFightEnabled) {
            if (e.getRespawnReason() == PlayerRespawnEvent.RespawnReason.END_PORTAL) {
                e.setRespawnLocation(new Location(Bukkit.getWorld("end_fight_world"), 0, 70.0, 0));
                //Bukkit.getScheduler().runTaskLater(lifestealSmp, () -> e.getPlayer().teleport(endPortalCenter), 20);
                return;
            }
            Player p = e.getPlayer();
            p.setGameMode(GameMode.SPECTATOR);
            p.teleportAsync(new Location(Bukkit.getWorld("end_fight_world"), 25.0, 80.0, 25.0));
            int survivors = 0;
            Player survivor = null;
            for (Player player : Bukkit.getOnlinePlayers()) {
                if (player.getGameMode().equals(GameMode.SURVIVAL)) {
                    survivors++;
                    survivor = player;
                }
            }
            if (survivors == 1) {
                lifestealSmp.getServer().broadcastMessage(ChatColor.GOLD + "" + ChatColor.BOLD + survivor.getName() + " has won the end fight!");
                survivor.setInvulnerable(true);
                survivor.getWorld().strikeLightningEffect(survivor.getLocation());
                World w = survivor.getWorld();
                int diameter = 10;
                for (int i = 0; i < 15; i++) {
                    Location newLocation = survivor.getLocation().add(new Vector(Math.random() - 0.5, 0, Math.random() - 0.5).multiply(diameter));
                    w.spawnEntity(newLocation, EntityType.FIREWORK_ROCKET);
                }
                survivor.setInvulnerable(false);
                for (Player player : Bukkit.getOnlinePlayers()) {
                    player.sendTitle(ChatColor.GOLD + survivor.getName() + ChatColor.DARK_PURPLE + " has won the end fight!", ChatColor.AQUA + "GGs " + survivor.getName());
                    player.clearActivePotionEffects();
                    player.setGameMode(GameMode.CREATIVE);
                }
                sendDiscordEmbedPlayer(survivor.getName() + " has won the end fight!", Color.BLUE, "", survivor.getName());
                sendDiscordNewsEmbedPlayer(survivor.getName() + " has won the end fight!", Color.BLUE, "1032411739351941120", survivor.getName());
                getServer().dispatchCommand(getServer().getConsoleSender(), "stopendfight");
            }
        }
    }

    /*@EventHandler
    public void onPlayerMove(PlayerMoveEvent e) {
        if (isEndFightEnabled) {
            e.setCancelled(true);
            e.getPlayer().sendMessage(ChatColor.YELLOW + "You cannot go outside the border!");
        }
    }*/

    /*@EventHandler
    public void onPlayerTeleport(PlayerTeleportEvent e) {
        if (isEndFightEnabled && e.getTo().distance(endSpawn) > 110) {
            e.setCancelled(true);
            e.getPlayer().sendMessage(ChatColor.YELLOW + "You cannot go outside the border!");
        }
    }*/
}
