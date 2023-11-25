package newamazingpvp.lifestealsmp.listener;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.*;
import org.bukkit.event.Listener;
import org.bukkit.event.EventHandler;
import org.bukkit.event.entity.ProjectileLaunchEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.util.Vector;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;

import static newamazingpvp.lifestealsmp.LifestealSMP.lifestealSmp;
import static org.bukkit.Bukkit.getServer;

public class HomingBow implements Listener {
    @EventHandler
    public void onProjectileLaunch(ProjectileLaunchEvent event) {
        if (event.getEntity() instanceof Arrow) {
            Arrow arrow = (Arrow) event.getEntity();
            if (arrow.getShooter() instanceof Player) {
                Player shooter = (Player) arrow.getShooter();
                if (isHomingBow(shooter.getItemInHand())) {
                    startHoming(arrow, shooter);
                }
            }
        }
    }

    private void startHoming(Arrow arrow, Player shooter) {
        new HomingArrowRunnable(arrow, shooter).runTaskTimer(lifestealSmp, 0L, 1L);
    }

    private boolean isHomingBow(ItemStack item) {
        ItemMeta meta = item.getItemMeta();
        return item.getType() == Material.BOW && meta.getLore() != null && meta.getLore().toString().contains("Homing Arrows!");
    }
}

class HomingArrowRunnable extends BukkitRunnable {

    private final Arrow arrow;
    private Entity target;
    private final Player shooter;

    public HomingArrowRunnable(Arrow arrow, Player shooter) {
        this.arrow = arrow;
        this.shooter = shooter;
    }

    @Override
    public void run() {
        if (target == null || target.isDead()) {
            setTarget();
        }

        if (arrow.isDead() || target == null || target.isDead()) {
            cancel();
            return;
        }

        Vector newVector = target.getBoundingBox().getCenter().subtract(arrow.getLocation().toVector()).normalize();
        arrow.setVelocity(newVector);
    }

    private void setTarget() {
        List<Entity> nearbyEntities = arrow.getNearbyEntities(100, 100, 100);

        if (nearbyEntities.isEmpty()) {
            cancel();
            return;
        }

        Optional<Entity> optionalEntity = nearbyEntities.stream()
                //entity instanceof Player &&
                .filter(entity -> !entity.equals(shooter) && (entity instanceof Mob || entity instanceof Player))
                .min(Comparator.comparing(entity -> entity.getLocation().distanceSquared(arrow.getLocation())));

        target = optionalEntity.orElse(null);

        if (target == null) {
            cancel();
        }
    }
}
