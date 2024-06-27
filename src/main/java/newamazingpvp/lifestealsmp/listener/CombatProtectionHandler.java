package newamazingpvp.lifestealsmp.listener;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.*;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.scheduler.BukkitRunnable;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.Month;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.List;

import static newamazingpvp.lifestealsmp.LifestealSMP.lifestealSmp;
import static newamazingpvp.lifestealsmp.allyteams.TeamsManager.onSameTeam;
import static newamazingpvp.lifestealsmp.customitems.utils.ItemStacks.extraHeart;
import static newamazingpvp.lifestealsmp.game.CombatLog.*;
import static newamazingpvp.lifestealsmp.game.Compass.getPlaytime;
import static newamazingpvp.lifestealsmp.game.PlayerLifeManager.eliminatePlayer;
import static newamazingpvp.lifestealsmp.utility.Utils.addItemOrDrop;

public class CombatProtectionHandler implements Listener {
    public static List<String> heartCooldownPlayers = new ArrayList<>();
    public static List<String> invincibilityPlayers = new ArrayList<>();
    public List<String> newbieViolate = new ArrayList<>();

    @EventHandler
    public void onEntityDamageByEntity(EntityDamageByEntityEvent event) {
        if (event.getEntity() instanceof Player) {
            Player damaged = (Player) event.getEntity();
            if (event.getDamager() instanceof Player) {
                Player damager = (Player) event.getDamager();
                handlePlayerDamage(event, damager, damaged);
            } else if (event.getDamager() instanceof Arrow) {
                Arrow arrow = (Arrow) event.getDamager();
                if (arrow.getShooter() instanceof Player) {
                    Player shooter = (Player) arrow.getShooter();
                    handlePlayerDamage(event, shooter, damaged);
                }
            } else if (event.getDamager() instanceof TNTPrimed) {
                TNTPrimed tnt = (TNTPrimed) event.getDamager();
                if (tnt.getSource() instanceof Player) {
                    Player shooter = (Player) tnt.getSource();
                    handlePlayerDamage(event, shooter, damaged);
                }
            }
        } else if (event.getEntity() instanceof Villager && event.getDamager() instanceof Player) {
            handleVillagerDamage(event, (Player) event.getDamager());
        }
    }

    private void handlePlayerDamage(EntityDamageByEntityEvent event, Player damager, Player damaged) {
        if (damager == null || damaged == null) return;

        if (isGracePeriod()) {
            event.setCancelled(true);
            damager.sendMessage(ChatColor.RED + "You cannot damage players during the grace period!");
            return;
        }
        if (invincibilityPlayers.contains(damaged.getName())) {
            event.setCancelled(true);
            damager.sendMessage(ChatColor.RED + "This player was recently killed by a player and won't give heart if you kill them again.");
            damager.sendMessage(ChatColor.RED + "You cannot damage players during their death protection unless they attack you back!");
            damaged.sendMessage(ChatColor.RED + "Someone tried attacking you but was prevented because you died recently! If you attack them back they can attack you and are then allowed to kill you again SO BE CAREFUL");
            return;
        }
        if (invincibilityPlayers.contains(damager.getName())) {
            invincibilityPlayers.remove(damager.getName());
            damager.sendMessage(ChatColor.RED + "You have lost your death protection invincibility because you attacked another player.");
        }
        if (getPlaytime(damaged) < 216000 && !isInCombat(damaged) && !newbieViolate.contains(damaged.getName())) {
            event.setCancelled(true);
            long remainingSeconds = getPlaytime(damaged) / 20;
            long finalTime = 216000 - remainingSeconds;

            int remainingMinutes = (int) ((finalTime % 3600) / 60);
            int remainingSecondsLeft = (int) (finalTime % 60);

            damaged.sendMessage(ChatColor.RED + "Someone tried hitting you during your newbie protection! If you hit them back you will lose your protection temporarily and will be attacked!");
            damager.sendMessage(ChatColor.RED + "You cannot damage during their newbie protection for " + ChatColor.YELLOW + remainingMinutes + " minutes, " +
                    remainingSecondsLeft + " seconds. Either way they won't give hearts until they have 3 hour playtime, so why bother?");
            return;
        }
        if (getPlaytime(damaged) < 216000) {
            damaged.sendMessage(ChatColor.RED + "Since you don't have 3 hours of playtime, even if you die you won't lose any hearts");
            damager.sendMessage(ChatColor.RED + "The person you are trying to attack does not have 3 hours of playtime. Therefore they will not drop hearts when killed");
        }
        if (onSameTeam(damaged, damager)) {
            event.setCancelled(true);
            return;
        }
        if (!event.isCancelled()) {
            tagPlayer(damager, damaged);
            tagPlayer(damaged, damager);
        }
    }

    private void handleVillagerDamage(EntityDamageByEntityEvent event, Player damager) {
        if (damager == null) return;

        if (getPlaytime(damager) < 216000 && !newbieViolate.contains(damager.getName())) {
            newbieViolate.add(damager.getName());
            event.setCancelled(true);
            lifestealSmp.getServer().broadcastMessage(ChatColor.YELLOW + damager.getName() + " has lost their newbie protection for 5 minutes because of potentially breaking the no griefing rule during newbie protection");
            new BukkitRunnable() {
                @Override
                public void run() {
                    newbieViolate.remove(damager.getName());
                }
            }.runTaskLater(lifestealSmp, 20 * 60 * 5);
        }
        if (invincibilityPlayers.contains(damager.getName())) {
            event.setCancelled(true);
            invincibilityPlayers.remove(damager.getName());
            lifestealSmp.getServer().broadcastMessage(damager.getName() + ChatColor.YELLOW + " has lost their death protection for hearts & invincibility for potentially breaking the no griefing rule during death protection");
        }
    }

    @EventHandler
    public void onDeath(PlayerDeathEvent event) throws IOException {
        Player p = event.getEntity();
        if (p == null) return;

        Player slainer = null;
        LivingEntity killer = p.getKiller();
        if (!(killer instanceof Player)) {
            if(isInCombat(p)){
                if(getEnemies(p).isEmpty()){
                    return;
                }
                killer = getEnemies(p).get(getEnemies(p).size()-1);
            } else {
                return;
            }
        } else {
            slainer = (Player) killer;
        }
        if(slainer == null) return;
        removeEnemies(p);
        if (!heartCooldownPlayers.contains(p.getName()) && getPlaytime(p) > 216000) {
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
        heartCooldownPlayers.add(p.getName());
        invincibilityPlayers.add(p.getName());

        p.sendMessage("You have heart cooldown for 15 minutes. You also have death protection invincibility for up to 15 minutes but you will lose it if you attack another player.");
        p.sendTitle(ChatColor.GOLD + "You have Death Protection", ChatColor.DARK_PURPLE + "If you attack anybody you will lose invincibility (Read chat)", 1, 100, 1);
        new BukkitRunnable() {
            @Override
            public void run() {
                heartCooldownPlayers.remove(p.getName());
            }
        }.runTaskLater(lifestealSmp, 20 * 60 * 15);
        new BukkitRunnable() {
            @Override
            public void run() {
                invincibilityPlayers.remove(p.getName());
            }
        }.runTaskLater(lifestealSmp, 20 * 60 * 15);
    }

    public boolean isGracePeriod() {
        LocalDateTime targetDateTime = LocalDateTime.of(2023, Month.NOVEMBER, 23, 10, 29);

        ZoneId estTimeZone = ZoneId.of("America/New_York");
        ZonedDateTime estTargetDateTime = ZonedDateTime.of(targetDateTime, estTimeZone);

        ZonedDateTime currentDateTime = ZonedDateTime.now(estTimeZone);

        return currentDateTime.isBefore(estTargetDateTime);
    }
}
