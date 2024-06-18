package newamazingpvp.lifestealsmp.visualeffects;

import org.bukkit.Bukkit;
import org.bukkit.Color;
import org.bukkit.Location;
import org.bukkit.Particle;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;

public class DroppedItemParticles implements Listener {


















    public static void spawnParticlesOnItem(Entity itemEntity, Location location, Color color, Float size) {

        for (Player player : Bukkit.getOnlinePlayers()) {
            player.getWorld().spawnParticle(Particle.REDSTONE, location, 0, new Particle.DustOptions(color, size));

        }
    }





}




