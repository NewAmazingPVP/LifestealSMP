package newamazingpvp.lifestealsmp.listener;

import org.bukkit.ChatColor;
import org.bukkit.entity.*;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.PlayerDeathEvent;
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
import static newamazingpvp.lifestealsmp.game.CustomRecipe.extraHeart;
import static newamazingpvp.lifestealsmp.game.PlayerLifeManager.eliminatePlayer;
import static newamazingpvp.lifestealsmp.game.TeamsManager.onSameTeam;
import static newamazingpvp.lifestealsmp.utility.Utils.addItemOrDrop;

public class GracePeriod implements Listener {
    public static List<String> names = new ArrayList<>();
    public List<String> newbieViolate = new ArrayList<>();

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
                    if (getPlaytime(damaged) < 216000 && !isInCombat(damaged) && !newbieViolate.contains(damaged.getName())) {
                        event.setCancelled(true);

                        long remainingSeconds = getPlaytime(damaged) / 20;
                        long finalTime = 216000 - remainingSeconds;

                        int remainingMinutes = (int) ((finalTime % 3600) / 60);
                        int remainingSecondsLeft = (int) (finalTime % 60);

                        damaged.sendMessage(ChatColor.RED + "Someone tried hitting you during your newbie protection! If you hit them back you will lose your protection temporarily and will be attacked!");
                        damager.sendMessage(ChatColor.RED + "You cannot damage during their newbie protection for " + ChatColor.YELLOW + remainingMinutes + " minutes, " +
                                remainingSecondsLeft + " seconds.");
                    }
                    if (onSameTeam(damaged, damager)) {
                        event.setCancelled(true);
                    }
                    if (!event.isCancelled()) {
                        //names.remove(damager.getName());
                        tagPlayer(damager, damaged);
                        tagPlayer(damaged, damager);
                    }
                } else if (event.getDamager() instanceof Arrow) {
                    Arrow arrow = (Arrow) event.getDamager();
                    if (arrow.getShooter() instanceof Player) {
                        Player shooter = (Player) arrow.getShooter();
                        if (event.getDamager().equals(shooter)) event.setCancelled(true);
                        if (isGracePeriod()) {
                            event.setCancelled(true);
                            shooter.sendMessage(ChatColor.RED + "You cannot shoot players during the grace period!");
                        }
                        if (isPlayerDeathProt(damaged)) {
                            //event.setCancelled(true);
                            //event.getDamager().sendMessage(ChatColor.RED + "You cannot shoot players during their death protection unless they attack you back!");
                            shooter.sendMessage(ChatColor.RED + "This player was recently killed by a player and won't give heart if you kill them again");
                            //event.getEntity().sendMessage(ChatColor.RED + "Someone tried attacking u but was prevented because u died recently! If you attack them back they can attack you and are then allowed to kill you again SO BE CAREFUL");
                        }
                        if (getPlaytime(damaged) < 216000 && !isInCombat(damaged) && !newbieViolate.contains(damaged.getName())) {
                            event.setCancelled(true);
                            long remainingSeconds = getPlaytime(damaged) / 20;
                            long finalTime = 216000 - remainingSeconds;

                            int remainingMinutes = (int) ((finalTime % 3600) / 60);
                            int remainingSecondsLeft = (int) (finalTime % 60);

                            damaged.sendMessage(ChatColor.RED + "Someone tried hitting you during your newbie protection! If you hit them back you will lose your protection temporarily and will be attacked!");
                            shooter.sendMessage(ChatColor.RED + "You cannot damage during their newbie protection for " + ChatColor.YELLOW + remainingMinutes + " minutes, " +
                                    remainingSecondsLeft + " seconds.");
                        }
                        if (onSameTeam(damaged, shooter)) {
                            event.setCancelled(true);
                        }
                        if (!event.isCancelled()) {
                            //names.remove(event.getDamager().getName());
                            tagPlayer(shooter, damaged);
                            tagPlayer(damaged, shooter);
                        }
                    }
                } else if (event.getDamager() instanceof TNTPrimed) {
                    TNTPrimed arrow = (TNTPrimed) event.getDamager();
                    if (arrow.getSource() instanceof Player) {
                        Player shooter = (Player) arrow.getSource();

                        if (isGracePeriod()) {
                            event.setCancelled(true);
                            shooter.sendMessage(ChatColor.RED + "You cannot tnt players during the grace period!");
                        }
                        if (isPlayerDeathProt(damaged)) {
                            event.getDamager().sendMessage(ChatColor.RED + "This player was recently killed by a player and won't give heart if you kill them again");
                        }
                        if (getPlaytime(damaged) < 216000 && !isInCombat(damaged) && !newbieViolate.contains(damaged.getName())) {
                            event.setCancelled(true);
                            long remainingSeconds = getPlaytime(damaged) / 20;
                            long finalTime = 216000 - remainingSeconds;

                            int remainingMinutes = (int) ((finalTime % 3600) / 60);
                            int remainingSecondsLeft = (int) (finalTime % 60);

                            damaged.sendMessage(ChatColor.RED + "Someone tried hitting you during your newbie protection! If you hit them back you will lose your protection temporarily and will be attacked!");
                            event.getDamager().sendMessage(ChatColor.RED + "You cannot damage during their newbie protection for " + ChatColor.YELLOW + remainingMinutes + " minutes, " +
                                    remainingSecondsLeft + " seconds.");
                        }
                        if (!event.isCancelled()) {
                            tagPlayer((Player) event.getDamager(), damaged);
                            tagPlayer(damaged, (Player) event.getDamager());
                        }
                    }
                }
            }
        } else {
            if (event.getEntity() instanceof Villager) {
                if (event.getDamager() instanceof Player) {
                    Player p = (Player) event.getDamager();
                    if (getPlaytime(p) < 216000 && !newbieViolate.contains(p.getName())) {
                        newbieViolate.add(p.getName());
                        event.setCancelled(true);
                        lifestealSmp.getServer().broadcastMessage(p.getName() + " has lost their newbie protection for 5 minutes because of potentially breaking the no griefing rule during newbie protection");
                        new BukkitRunnable() {
                            @Override
                            public void run() {
                                newbieViolate.remove(p.getName());
                            }
                        }.runTaskLater(lifestealSmp, 20 * 60 * 5);
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
        if (!(killer instanceof Player)) {
            return;
        }
        Player p = event.getEntity();
        Player slainer = (Player) killer;
        if (!names.contains(p.getName())) {
            if (!(p.getMaxHealth() <= 2)) {
                p.setMaxHealth(p.getMaxHealth() - 2);
            } else {
                eliminatePlayer(p);
            }
            if (!(killer.getMaxHealth() > 38)) {
                killer.setMaxHealth(killer.getMaxHealth() + 2);
            } else {
                addItemOrDrop(slainer, extraHeart(), "Heart was dropped because your inventory was full");
            }
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
