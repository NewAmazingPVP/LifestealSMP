package newamazingpvp.lifestealsmp.CustomMobs.Mobs.Shado;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Sound;
import org.bukkit.entity.Entity;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class ShadowMobListener implements Listener {

    @EventHandler
    public void whenPlayerHit(EntityDamageByEntityEvent e) {

        Entity attacker = e.getDamager();
        LivingEntity damagedEntity = (LivingEntity) e.getEntity();
        Location loc = e.getEntity().getLocation();

        if (attacker instanceof LivingEntity) {

            if (attacker.hasMetadata("shadow")) {


                damagedEntity.addPotionEffect(new PotionEffect(PotionEffectType.DARKNESS, 40, 2));
                damagedEntity.addPotionEffect(new PotionEffect(PotionEffectType.SLOW_DIGGING, 200, 5));



                for (Player onlinePlayer : Bukkit.getOnlinePlayers()) {
                    onlinePlayer.playSound(loc, Sound.ENTITY_ENDERMAN_TELEPORT, 1.0f, 0.0f);

                }
            }
        }
    }

}
