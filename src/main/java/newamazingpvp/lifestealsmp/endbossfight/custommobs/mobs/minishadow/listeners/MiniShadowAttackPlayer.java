package newamazingpvp.lifestealsmp.endbossfight.custommobs.mobs.minishadow.listeners;

import org.bukkit.Location;
import org.bukkit.entity.Entity;
import org.bukkit.entity.LivingEntity;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;

public class MiniShadowAttackPlayer implements Listener {

    @EventHandler
    public void whenPlayerHit(EntityDamageByEntityEvent e) {

        Entity attacker = e.getDamager();
        LivingEntity damagedEntity = (LivingEntity) e.getEntity();
        Location loc = e.getEntity().getLocation();

        if (attacker instanceof LivingEntity) {

            if (attacker.hasMetadata("shadow")) {


                /*damagedEntity.addPotionEffect(new PotionEffect(PotionEffectType.DARKNESS, 40, 2));
                damagedEntity.addPotionEffect(new PotionEffect(PotionEffectType.MINING_FATIGUE, 200, 5));



                for (Player onlinePlayer : Bukkit.getOnlinePlayers()) {
                    onlinePlayer.playSound(loc, Sound.ENTITY_ENDERMAN_TELEPORT, 1.0f, 0.0f);

                }*/
            }
        }
    }

}
