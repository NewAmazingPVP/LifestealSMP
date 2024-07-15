package newamazingpvp.lifestealsmp.visuals;

import org.bukkit.ChatColor;
import org.bukkit.attribute.Attribute;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.EntitySpawnEvent;

import java.text.DecimalFormat;

public class HpNameTag implements Listener {

    @EventHandler
    public void entitySpawn(EntitySpawnEvent e) {

        LivingEntity entity = (LivingEntity) e.getEntity();

        if (!(entity instanceof Player)) {

            if (!entity.hasMetadata("isCustomMob")) {

                double maxHealth = entity.getAttribute(Attribute.GENERIC_MAX_HEALTH).getValue();

                entity.setCustomName(ChatColor.DARK_RED + "" + ChatColor.BOLD + maxHealth + ChatColor.DARK_RED + "❤");


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

            damagedEntity.setCustomName(ChatColor.DARK_RED + "" + ChatColor.BOLD + df.format(currentHealth) + " / " + df.format(maxHealth) + ChatColor.DARK_RED + "❤");

        }

    }


}
