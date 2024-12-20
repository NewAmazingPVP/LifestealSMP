package newamazingpvp.lifestealsmp.listener;

import org.bukkit.Location;
import org.bukkit.Particle;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;

public class SpawnSnow {

    private final Plugin plugin;

    public SpawnSnow(Plugin plugin) {
        this.plugin = plugin;
    }

    public void startRegionalSnow() {
        int xMin = -100, xMax = 100;
        int zMin = -100, zMax = 100;

        /*new BukkitRunnable() {
            @Override
            public void run() {
                for (Player player : Bukkit.getOnlinePlayers()) {
                    Location loc = player.getLocation();

                    if (isInRegion(loc, xMin, xMax, zMin, zMax)) {
                        spawnSnowParticles(loc);
                        playSnowSound(player);
                    }
                }
            }
        }.runTaskTimer(plugin, 0L, 10L);*/
    }

    private boolean isInRegion(Location loc, int xMin, int xMax, int zMin, int zMax) {
        return loc.getX() >= xMin && loc.getX() <= xMax &&
                loc.getZ() >= zMin && loc.getZ() <= zMax;
    }

    private void spawnSnowParticles(Location loc) {
        Location particleLoc = loc.clone().add(0, 5, 0);
        for (int i = 0; i < 50; i++) {
            double offsetX = Math.random() * 10 - 5;
            double offsetY = Math.random() * 10;
            double offsetZ = Math.random() * 10 - 5;
            particleLoc.add(offsetX, 0, offsetZ);
            loc.getWorld().spawnParticle(Particle.SNOWFLAKE, particleLoc, 1, 0, -1, 0, 0.1);
            particleLoc.subtract(offsetX, 0, offsetZ);
        }
    }

    private void playSnowSound(Player player) {
        player.playSound(player.getLocation(), Sound.WEATHER_RAIN, 0.5f, 0.7f);
    }
}
