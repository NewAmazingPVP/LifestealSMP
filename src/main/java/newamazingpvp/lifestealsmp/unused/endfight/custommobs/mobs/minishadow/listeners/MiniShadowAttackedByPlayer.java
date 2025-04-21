package newamazingpvp.lifestealsmp.unused.endfight.custommobs.mobs.minishadow.listeners;

import org.bukkit.*;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;

public class MiniShadowAttackedByPlayer implements Listener {

    @EventHandler
    public void damage(EntityDamageByEntityEvent e) {

        Entity attacker = e.getDamager();
        Entity damagedEntity = e.getEntity();
        Location loc = e.getEntity().getLocation();

        if (damagedEntity.hasMetadata("mini_shadow")) {

            for (Player onlinePlayer : Bukkit.getOnlinePlayers()) {
                onlinePlayer.playSound(loc, Sound.ENTITY_GUARDIAN_AMBIENT_LAND, 1.0f, 1.0f);

            }
            attacker.getWorld().spawnParticle(Particle.REDSTONE, loc, 0, new Particle.DustOptions(Color.BLACK, 5.0f));

        }

    }
}
