package newamazingpvp.lifestealsmp.blacklistener;

import com.destroystokyo.paper.event.player.PlayerTeleportEndGatewayEvent;
import org.bukkit.ChatColor;
import org.bukkit.World;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityPortalEvent;
import org.bukkit.event.player.PlayerChangedWorldEvent;
import org.bukkit.event.player.PlayerPortalEvent;

import java.time.Duration;
import java.time.ZoneId;
import java.time.ZonedDateTime;

import static newamazingpvp.lifestealsmp.utility.TimeManager.*;
import static newamazingpvp.lifestealsmp.variables.Loc.endPortalCenter;
import static newamazingpvp.lifestealsmp.variables.Misc.isEndFightEnabled;

public class AntiEnd implements Listener {
    @EventHandler
    public void portalLeave(PlayerPortalEvent e) {
        if(e.getTo().getWorld().getEnvironment() == World.Environment.THE_END && !isWeekPassed(2, getWeeksPassed(SEASON_START_TIME, ZonedDateTime.now(ZoneId.of("America/New_York"))))) {
            //Duration duration = Duration.between(ZonedDateTime.now(ZoneId.of("America/New_York"), )
               /* long days = duration.toDays();
                long hours = duration.toHours() % 24;
                long minutes = duration.toMinutes() % 60;
                long seconds = duration.getSeconds() % 60;

                return String.format("%d days, %d hours, %d minutes, %d seconds", days, hours, minutes, seconds);*/
            e.getPlayer().sendMessage(ChatColor.RED + "End is not open yet!");
            e.setCancelled(true);
        }
    }

    @EventHandler
    public void worldSwitch(PlayerChangedWorldEvent e) {
        if (isEndFightEnabled) {
            e.getPlayer().sendMessage(ChatColor.RED + "You cannot use portal during end fight!");
            e.getPlayer().teleport(endPortalCenter);
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
}
