package newamazingpvp.lifestealsmp.Visuals;

import org.bukkit.ChatColor;
import org.bukkit.attribute.Attribute;
import org.bukkit.entity.Entity;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.EntitySpawnEvent;

import java.text.DecimalFormat;

public class nameTagHPMobs implements Listener {

    @EventHandler
    public void entitySpawn(EntitySpawnEvent e) {

        LivingEntity entity = (LivingEntity) e.getEntity();

        if (!(entity instanceof Player)) {

            if (!entity.hasMetadata("isCustomMob")) {

                double maxHealth = entity.getAttribute(Attribute.GENERIC_MAX_HEALTH).getValue();

                if (isMobHostile(entity)) {
                    entity.setCustomName(ChatColor.DARK_RED + "" + ChatColor.BOLD + maxHealth + ChatColor.DARK_RED + "❤");
                } else {
                    entity.setCustomName(ChatColor.DARK_GREEN + "" + ChatColor.BOLD + maxHealth + ChatColor.DARK_GREEN + "❤");
                }


                entity.setCustomNameVisible(true);

            }
        }

    }

    @EventHandler
    public void entityDamaged(EntityDamageByEntityEvent e) {



        LivingEntity damagedEntity = (LivingEntity) e.getEntity();
        double maxHealth = damagedEntity.getAttribute(Attribute.GENERIC_MAX_HEALTH).getValue();
        double currentHealth = maxHealth - e.getFinalDamage();
        DecimalFormat df = new DecimalFormat("0.0");

        if (!damagedEntity.hasMetadata("isCustomMob")) {

            if (isMobHostile(damagedEntity)) {
                damagedEntity.setCustomName(ChatColor.DARK_RED + "" + ChatColor.BOLD + df.format(maxHealth) + " / " + df.format(currentHealth) + ChatColor.DARK_RED + "❤");
            } else {
                damagedEntity.setCustomName(ChatColor.DARK_GREEN + "" + ChatColor.BOLD + df.format(maxHealth) + " / " + df.format(currentHealth) + ChatColor.DARK_GREEN + "❤");
            }
        }

    }




    public boolean isMobHostile(LivingEntity mob) {
        // Check if the mob has a target
        if (mob.getTargetEntity(100) != null) {
            // Cast the target to an Entity to allow further checks
            Entity target = mob.getTargetEntity(100);

            // Check if the target is a player or another mob
            if (target instanceof Player || target instanceof LivingEntity) {
                return true; // The mob is considered hostile
            }
        }

        return false; // The mob is not hostile
    }

}
