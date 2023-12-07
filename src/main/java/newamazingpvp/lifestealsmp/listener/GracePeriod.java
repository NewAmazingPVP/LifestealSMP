package newamazingpvp.lifestealsmp.listener;

import org.bukkit.ChatColor;
import org.bukkit.entity.Arrow;
import org.bukkit.entity.Entity;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.scheduler.BukkitRunnable;

import java.time.LocalDateTime;
import java.time.Month;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.List;

import static newamazingpvp.lifestealsmp.LifestealSMP.lifestealSmp;
import static newamazingpvp.lifestealsmp.game.CombatLog.*;
import static newamazingpvp.lifestealsmp.game.Compass.getPlaytime;
import static newamazingpvp.lifestealsmp.game.PlayerLifeManager.eliminatePlayer;

public class GracePeriod implements Listener {
    public List<String> names = new ArrayList<>();

    @EventHandler
    public void onEntityDamageByEntity(EntityDamageByEntityEvent event) {
        if (event.getEntity() instanceof Player) {
            Player damaged = (Player) event.getEntity();
            if (event.getDamager() instanceof Player || event.getDamager() instanceof Arrow) {
                if (event.getDamager() instanceof Player) {
                    Player damager = (Player) event.getDamager();
                    if (isGracePeriod()) {
                        event.setCancelled(true);
                        damager.sendMessage(ChatColor.RED + "You cannot damage players during the grace period!");
                    }
                    if (isPlayerDeathProt(damaged)) {
                        damager.sendMessage(ChatColor.RED + "This player was recently killed by a player and won't give heart if you kill them again");
                        //event.setCancelled(true);
                        //damager.sendMessage(ChatColor.RED + "You cannot damage players during their death protection unless they attack you back!");
                        //damaged.sendMessage(ChatColor.RED + "Someone tried attacking u but was prevented because u died recently! If you attack them back they can attack you and are then allowed to kill you again SO BE CAREFUL");
                    }
                    /*if(getPlaytime(damaged) < 216000 && !isInCombat(damaged)){
                        event.setCancelled(true);
                        damager.sendMessage(ChatColor.RED + "You cannot damage during their newbie protection!");
                    }*/
                    if(!event.isCancelled()) {
                        names.remove(damager.getName());
                        tagPlayer(damager, damaged);
                        tagPlayer(damaged, damager);
                    }
                } else if (event.getDamager() instanceof Arrow) {
                    Arrow arrow = (Arrow) event.getDamager();
                    if (arrow.getShooter() instanceof Player) {
                        Player shooter = (Player) arrow.getShooter();

                        if (isGracePeriod()) {
                            event.setCancelled(true);
                            shooter.sendMessage(ChatColor.RED + "You cannot shoot players during the grace period!");
                        }
                        if (isPlayerDeathProt(damaged)) {
                            //event.setCancelled(true);
                            //event.getDamager().sendMessage(ChatColor.RED + "You cannot shoot players during their death protection unless they attack you back!");
                            event.getDamager().sendMessage(ChatColor.RED + "This player was recently killed by a player and won't give heart if you kill them again");
                            //event.getEntity().sendMessage(ChatColor.RED + "Someone tried attacking u but was prevented because u died recently! If you attack them back they can attack you and are then allowed to kill you again SO BE CAREFUL");
                        }
                        /*if(getPlaytime(damaged) < 216000 && !isInCombat(damaged)){
                            event.setCancelled(true);
                            event.getDamager().sendMessage(ChatColor.RED + "You cannot damage during their newbie protection!");
                        }*/
                        if(!event.isCancelled()) {
                            names.remove(event.getDamager().getName());
                            tagPlayer((Player) event.getDamager(), damaged);
                            tagPlayer(damaged, (Player) event.getDamager());
                        }
                    }
                }
            }
        }
    }

    public boolean isGracePeriod() {
        LocalDateTime targetDateTime = LocalDateTime.of(2023, Month.NOVEMBER, 23, 10, 29);

        ZoneId estTimeZone = ZoneId.of("America/New_York");
        ZonedDateTime estTargetDateTime = ZonedDateTime.of(targetDateTime, estTimeZone);

        ZonedDateTime currentDateTime = ZonedDateTime.now(estTimeZone);

        return currentDateTime.isBefore(estTargetDateTime);
    }

    @EventHandler
    public void onDeath(PlayerDeathEvent event) {
        removeEnemies(event.getPlayer());
        LivingEntity killer = event.getEntity().getKiller();
        if(!(killer instanceof Player)){
            return;
        }
        Player p = event.getEntity();
        if(!names.contains(p.getName())){
            if(!(p.getMaxHealth() <= 2)) {
                p.setMaxHealth(p.getMaxHealth() - 2);
            } else {
                eliminatePlayer(p);
            }
            killer.setMaxHealth(killer.getMaxHealth() + 2);
        }
        String name = p.getName();
        names.add(name);
        new BukkitRunnable() {
            @Override
            public void run() {
                names.remove(name);
            }
        }.runTaskLater(lifestealSmp, 20 * 60 * 15);
    }

    public boolean isPlayerDeathProt(Player p) {
        return names.contains(p.getName());
    }
}
