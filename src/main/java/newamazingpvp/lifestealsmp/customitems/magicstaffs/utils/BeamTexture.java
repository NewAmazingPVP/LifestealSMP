package newamazingpvp.lifestealsmp.customitems.magicstaffs.utils;

import org.bukkit.Bukkit;
import org.bukkit.Color;
import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.util.Vector;

public class BeamTexture {
    public static void beamTextureMaker(Player player, Location location, Vector attackerLookDir,Color color1, Float size1, Color color2, Float Size2) {

        for (double i = 0; i < 150; i++) {
            location.add(attackerLookDir);
            for (Player player2 : Bukkit.getOnlinePlayers()) {
                //player2.getWorld().spawnParticle(Particle.REDSTONE, location, 0, new Particle.DustOptions(color1, size1));
                //player2.getWorld().spawnParticle(Particle.REDSTONE, location, 0, new Particle.DustOptions(color2, Size2));


            }
        }
    }

}


