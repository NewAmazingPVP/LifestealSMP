package newamazingpvp.lifestealsmp.RaffleEvent.RaffleCustomMobs.Enigma.EnigmaEvents;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Particle;
import org.bukkit.Sound;
import org.bukkit.damage.DamageSource;
import org.bukkit.entity.Entity;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.EntityDeathEvent;

import static newamazingpvp.lifestealsmp.RaffleEvent.RaffleCustomMobs.Enigma.EnigmaEvents.EnigmaGUI.startEnigmaMobPuzzle;

public class EnigmaDamagedAndKilled implements Listener {

    @EventHandler
    public void whenPlayerHit(EntityDamageByEntityEvent e) {


        Entity damagedEntity = e.getEntity();
        Location loc = damagedEntity.getLocation();


        if (damagedEntity.hasMetadata("enigma_mob")) {

            for (Player onlinePlayer : Bukkit.getOnlinePlayers()) {
                onlinePlayer.playSound(loc, Sound.ENTITY_IRON_GOLEM_DAMAGE, 2.0f, 0.0f);
                damagedEntity.getLocation().getWorld().spawnParticle(Particle.CLOUD, damagedEntity.getLocation(), 10);

            }
        }
    }

    @EventHandler
    public void whenPlayerHit(EntityDeathEvent e) {

        Entity damagedEntity = e.getEntity();

        if (damagedEntity.getLastDamageCause() instanceof EntityDamageByEntityEvent) {
            EntityDamageByEntityEvent damageEvent = (EntityDamageByEntityEvent) damagedEntity.getLastDamageCause();


            if (damageEvent.getDamager() instanceof Player) {
                Player killer = (Player) damageEvent.getDamager();

                if (damagedEntity.hasMetadata("enigma_mob")) {
                    killer.playSound(killer.getLocation(), Sound.ENTITY_ELDER_GUARDIAN_CURSE, 2.0f, 2.0f);
                    startEnigmaMobPuzzle(killer);
                }
            }
        }
    }




}
