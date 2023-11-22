package newamazingpvp.lifestealsmp.game;

import com.destroystokyo.paper.event.player.PlayerTeleportEndGatewayEvent;
import net.kyori.adventure.text.TextComponent;
import org.bukkit.ChatColor;
import org.bukkit.OfflinePlayer;
import org.bukkit.entity.Player;
import org.bukkit.event.Event;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.event.player.*;

import java.awt.*;

import static newamazingpvp.lifestealsmp.LifestealSMP.lifestealSmp;
import static newamazingpvp.lifestealsmp.utility.DiscordBot.sendDiscordEmbedPlayer;
import static newamazingpvp.lifestealsmp.variables.Loc.endSpawn;
import static newamazingpvp.lifestealsmp.variables.Misc.endFightParticipants;
import static newamazingpvp.lifestealsmp.variables.Misc.isEndFightEnabled;

public class EndFightRestrictions implements Listener {
    @EventHandler
    public void portalLeave(PlayerPortalEvent e){
        if(isEndFightEnabled){
            e.getPlayer().sendMessage(ChatColor.RED + "You cannot use portal during end fight!");
            e.setCancelled(true);
        }
    }

    @EventHandler
    public void portalLeave(PlayerTeleportEndGatewayEvent e){
        if(isEndFightEnabled){
            e.getPlayer().sendMessage(ChatColor.RED + "You cannot use portal during end fight!");
            e.setCancelled(true);
        }
    }

    @EventHandler
    public void playerJoin(PlayerLoginEvent e){
        if(isEndFightEnabled){
            OfflinePlayer f = e.getPlayer();
            if(!(endFightParticipants.contains(e.getPlayer().getName()) || lifestealSmp.getServer().getWhitelistedPlayers().contains(f))){
                e.disallow(PlayerLoginEvent.Result.KICK_OTHER, "Sorry you cannot join during end fight!");
            }
        }
    }

    @EventHandler
    public void playerDamage(EntityDamageByEntityEvent e){
        if(isEndFightEnabled && e.getEntity() instanceof Player && e.getDamager() instanceof Player){
            Player p = (Player) e.getEntity();
            double totalHP = p.getMaxHealth() - e.getFinalDamage();
            if(totalHP < 1.0){
                p.banPlayer(ChatColor.RED + "You were eliminated! GF!");
                sendDiscordEmbedPlayer(p.getName() + " was eliminated from end fight! GF!", Color.YELLOW, "", p.getName());
                return;
            }
            p.setMaxHealth(p.getMaxHealth() - e.getFinalDamage());
        }
    }

    @EventHandler
    public void onPlayerDeath(PlayerDeathEvent e){
        if(isEndFightEnabled){
            Player p = e.getEntity();
            p.banPlayer(ChatColor.RED + "You were eliminated! GF!");
            sendDiscordEmbedPlayer(p.getName() + " was eliminated from end fight! GF!", Color.YELLOW, "", p.getName());
        }
    }

    @EventHandler
    public void onPlayerMove(PlayerMoveEvent e){
        if(isEndFightEnabled && e.getTo().distance(endSpawn) > 110){
            e.setCancelled(true);
        }
    }

    @EventHandler
    public void onPlayerTeleport(PlayerTeleportEvent e){
        if(isEndFightEnabled && e.getTo().distance(endSpawn) > 110){
            e.setCancelled(true);
        }
    }
}
