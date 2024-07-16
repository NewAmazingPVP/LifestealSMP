package newamazingpvp.lifestealsmp.blacklistener;

import com.destroystokyo.paper.event.player.PlayerTeleportEndGatewayEvent;
import org.bukkit.ChatColor;
import org.bukkit.PortalType;
import org.bukkit.World;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityPortalEvent;
import org.bukkit.event.player.PlayerPortalEvent;

import java.time.Duration;
import java.time.ZoneId;
import java.time.ZonedDateTime;

import static newamazingpvp.lifestealsmp.events.TimeManager.*;

public class AntiEnd implements Listener {

    @EventHandler
    public void portalLeave(PlayerPortalEvent e) {
        if (e.getTo().getWorld().getEnvironment() == World.Environment.THE_END && !isEndEnabled()) {
            Duration duration = Duration.between(ZonedDateTime.now(ZoneId.of("America/New_York")), END_OPEN_TIME);
            e.getPlayer().sendMessage(ChatColor.RED + "End is not open yet! It will open in " + formatDuration(duration));
            e.setCancelled(true);
        }
    }

    /*@EventHandler
    public void worldSwitch(PlayerChangedWorldEvent e) {
        if (isEndFightEnabled) {
            e.getPlayer().sendMessage(ChatColor.RED + "You cannot use portal during end fight!");
            e.getPlayer().teleport(endPortalCenter);
        }
    }*/

    public static boolean isEndEnabled() {
        //return isWeekPassed(2, getWeeksPassed(SEASON_START_TIME, ZonedDateTime.now(ZoneId.of("America/New_York"))));
        return isTimePassed(END_OPEN_TIME);
    }

    @EventHandler
    public void entityPortal(EntityPortalEvent e) {
        if ((e.getPortalType() == PortalType.ENDER || e.getTo().getWorld().getEnvironment() == World.Environment.THE_END) && !isEndEnabled()) {
            e.setCancelled(true);
        }
    }

    @EventHandler
    public void portalLeave(PlayerTeleportEndGatewayEvent e) {
        if (!isEndEnabled()) {
            e.getPlayer().sendMessage(ChatColor.RED + "You cannot use portal if end is not enabled!");
            e.setCancelled(true);
        }
    }
}
