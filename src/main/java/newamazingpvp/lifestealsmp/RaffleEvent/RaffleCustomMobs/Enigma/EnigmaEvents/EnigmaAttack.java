package newamazingpvp.lifestealsmp.RaffleEvent.RaffleCustomMobs.Enigma.EnigmaEvents;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Sound;
import org.bukkit.entity.Entity;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;

import java.util.Random;

public class EnigmaAttack implements Listener {

    @EventHandler
    public void whenPlayerHit(EntityDamageByEntityEvent e) {

        Entity attacker = e.getDamager();
        Entity damagedEntity = e.getEntity();
        Location loc = e.getEntity().getLocation();

        if (attacker instanceof LivingEntity) {

            if (attacker.hasMetadata("enigma_mob")) {

                damagedEntity.getWorld().strikeLightningEffect(loc);
                ((LivingEntity) damagedEntity).damage(2);
                for (Player onlinePlayer : Bukkit.getOnlinePlayers()) {
                    onlinePlayer.playSound(loc, Sound.ENTITY_ENDERMAN_TELEPORT, 2.0f, 1.0f);
                    onlinePlayer.playSound(loc, Sound.ENTITY_FIREWORK_ROCKET_TWINKLE, 2.0f, 2.0f);

                }

                Random random = new Random();
                int randomNumber1 = random.nextInt(91);
                int randomNumber2 = random.nextInt(91);

                damagedEntity.setRotation(randomNumber1, randomNumber2);


            }
        }
    }

}
