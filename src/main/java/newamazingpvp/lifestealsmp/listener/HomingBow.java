package newamazingpvp.lifestealsmp.listener;

import org.bukkit.FluidCollisionMode;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.Particle;
import org.bukkit.entity.*;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.ProjectileLaunchEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.util.RayTraceResult;
import org.bukkit.util.Vector;

import java.util.*;
import java.util.stream.Collectors;

import static newamazingpvp.lifestealsmp.LifestealSMP.lifestealSmp;

public class HomingBow implements Listener {

    private final Map<AbstractArrow, LivingEntity> arrowList = new HashMap<>();
    private final Set<AbstractArrow> invalidsInList = new HashSet<>();

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
        new BukkitRunnable() {
            @Override
            public void run() {
                updateVelocity(arrow);
                if (arrow.getTicksLived() >= 400) {
                    arrow.remove();
                    cancel();
                }
            }
        }.runTaskTimer(lifestealSmp, 0L, 1L);
    }

    private boolean isHomingBow(ItemStack item) {
        ItemMeta meta = item.getItemMeta();
        return item.getType() == Material.BOW && meta.getLore() != null && meta.getLore().toString().contains("Homing Arrows!");
    }

    private void updateVelocity(AbstractArrow arrow) {
        if (!isValid(arrow)) {
            this.invalidsInList.add(arrow);
            return;
        }
        LivingEntity target = this.arrowList.get(arrow);
        if (target != null && isSeparatedByWall(arrow, target))
            target = null;
        if (target == null)
            for (LivingEntity currentEntity : getPotentialTargets(arrow)) {
                if (!isSeparatedByWall(arrow, currentEntity)) {
                    target = currentEntity;
                    break;
                }
            }
        if (target == null)
            return;
        arrow.setVelocity(generateNewVelocity(arrow, target));
        arrow.getWorld().spawnParticle(Particle.DRIP_LAVA, arrow.getLocation(), 50, 0, 0, 0);
    }

    private List<LivingEntity> getPotentialTargets(final AbstractArrow arrow) {
        int range = 50;
        Collection<Entity> entities = arrow.getWorld().getNearbyEntities(arrow.getLocation(), range, range, range);
        List<LivingEntity> aliveInFront = entities.stream()
                .filter(e -> (e instanceof LivingEntity && ((LivingEntity) e).getEyeLocation().subtract(arrow.getLocation()).toVector().dot(arrow.getVelocity().normalize()) > 0.0D && !e.equals(arrow.getShooter())))
                .map(e -> (LivingEntity) e)
                .collect(Collectors.toList());

        aliveInFront.sort(Comparator.comparingDouble(o -> angle(o.getEyeLocation().subtract(arrow.getLocation()).toVector(), arrow.getVelocity())));

        return aliveInFront;
    }

    double angle(Vector a, Vector b) {
        return Math.acos(a.normalize().dot(b.normalize()));
    }

    private boolean isValid(AbstractArrow arrow) {
        return arrow.isValid() && !(arrow.getVelocity().length() <= 0.0D) && !arrow.isInWater();
    }

    private boolean isSeparatedByWall(Entity source, LivingEntity end) {
        if (source == null || !source.isValid())
            return true;
        if (end == null || !end.isValid())
            return true;
        Location sourceLoc = source.getLocation();
        Location endLoc = end.getEyeLocation();
        if (!sourceLoc.getWorld().equals(endLoc.getWorld()))
            return true;
        Vector sourceToEnd = endLoc.subtract(sourceLoc).toVector();
        RayTraceResult rayTraceResult = endLoc.getWorld().rayTraceBlocks(sourceLoc, sourceToEnd, sourceToEnd.length(), FluidCollisionMode.SOURCE_ONLY, true);
        return rayTraceResult != null;
    }

    private Vector generateNewVelocity(AbstractArrow arrow, LivingEntity target) {
        Vector arrowToTarget = target.getEyeLocation().subtract(arrow.getLocation()).toVector();
        Vector arrowPathUnitVec = arrow.getVelocity().normalize();
        Vector projectedVec = arrowPathUnitVec.multiply(arrowToTarget.dot(arrowPathUnitVec));
        Vector vectorUpwards = arrowToTarget.subtract(projectedVec);
        Double speed = Double.valueOf(arrow.getVelocity().length());
        return arrow.getVelocity().clone().add(vectorUpwards.multiply(0.04)).normalize().multiply(speed.doubleValue());
    }
}
