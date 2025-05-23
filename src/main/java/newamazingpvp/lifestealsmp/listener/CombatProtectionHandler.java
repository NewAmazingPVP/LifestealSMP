package newamazingpvp.lifestealsmp.listener;

import org.bukkit.ChatColor;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.entity.Villager;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.scheduler.BukkitRunnable;

import java.util.ArrayList;
import java.util.List;

import static newamazingpvp.lifestealsmp.LifestealSMP.lifestealSmp;
import static newamazingpvp.lifestealsmp.allyteams.TeamsManager.onSameTeam;
import static newamazingpvp.lifestealsmp.customitems.utils.ItemStacks.extraHeart;
import static newamazingpvp.lifestealsmp.events.TimeManager.SEASON_START_TIME;
import static newamazingpvp.lifestealsmp.events.TimeManager.isTimePassed;
import static newamazingpvp.lifestealsmp.game.CombatLog.*;
import static newamazingpvp.lifestealsmp.game.Compass.getPlaytime;
import static newamazingpvp.lifestealsmp.game.PlayerLifeManager.eliminatePlayer;
import static newamazingpvp.lifestealsmp.listener.CombatLogListener.areSameVersions;
import static newamazingpvp.lifestealsmp.utility.Utils.addItemOrDrop;
import static newamazingpvp.lifestealsmp.utility.Utils.returnPlayerDamager;
import static newamazingpvp.lifestealsmp.variables.Misc.isEndFightEnabled;
import static newamazingpvp.lifestealsmp.variables.Misc.maxHp;

public class CombatProtectionHandler implements Listener {
    public static List<String> heartCooldownPlayers = new ArrayList<>();
    public static List<String> invincibilityPlayers = new ArrayList<>();
    public static List<String> newbieViolate = new ArrayList<>();

    @EventHandler
    public void onEntityDamageByEntity(EntityDamageByEntityEvent event) {
        if (event.getEntity() instanceof Player damaged) {
            Player damager = returnPlayerDamager(event.getDamager());
            if (damager == null) return;
            handlePlayerDamage(event, damager, damaged);
        } else if (event.getEntity() instanceof Villager && event.getDamager() instanceof Player) {
            handleVillagerDamage(event, (Player) event.getDamager());
        }
    }

    private void handlePlayerDamage(EntityDamageByEntityEvent event, Player damager, Player damaged) {
        if (damager == null || damaged == null) return;
        //if(CitizensAPI.getNPCRegistry().isNPC(damaged) || CitizensAPI.getNPCRegistry().isNPC(damager)) return;
        if (isGracePeriod()) {
            event.setCancelled(true);
            damager.sendMessage(ChatColor.RED + "You cannot damage players during the grace period!");
            return;
        }
        if (!isEndFightEnabled && !damaged.getWorld().getName().equals("end_fight_world") && !damaged.getWorld().getName().equals("tournament_world")) {
            /*if (invincibilityPlayers.contains(damaged.getName())) {
                event.setCancelled(true);
                damager.sendMessage(ChatColor.RED + "This player was recently killed by a player and won't give heart if you kill them again.");
                damager.sendMessage(ChatColor.RED + "You cannot damage players during their death protection unless they attack you back!");
                damaged.sendMessage(ChatColor.RED + "Someone tried attacking you but was prevented because you died recently! If you attack them back they can attack you and are then allowed to kill you again SO BE CAREFUL");
                return;
            }*/
            /*if (invincibilityPlayers.contains(damager.getName())) {
                invincibilityPlayers.remove(damager.getName());
                damager.sendMessage(ChatColor.RED + "You have lost your death protection invincibility because you attacked another player.");
            }*/
            //nerfed from 216000 (3 hours) to 144000 (2 hours) to 72000 (1 hour) to 12000 (10 minutes)
            if (getPlaytime(damaged) < 12000 && !isInCombat(damaged) && !newbieViolate.contains(damaged.getName())) {
                event.setCancelled(true);
                long remainingTicks = 12000 - getPlaytime(damaged);
                long remainingSeconds = remainingTicks / 20;
                int remainingMinutes = (int) ((remainingSeconds / 60) % 60);
                int remainingSecondsLeft = (int) (remainingSeconds % 60);

                damaged.sendMessage(ChatColor.RED + "Someone tried hitting you during your newbie protection! If you hit them back you will lose your protection temporarily and will be attacked!");
                damager.sendMessage(ChatColor.RED + "You cannot damage during their newbie protection for " + ChatColor.YELLOW + remainingMinutes + " minutes, " +
                        remainingSecondsLeft + " seconds. Either way they won't give hearts until they have 1 hour heart protection, so why bother?");
                return;
            }
            if (getPlaytime(damaged) < 72000) {
                damaged.sendMessage(ChatColor.RED + "Since you don't have a hour of playtime, even if you die you won't lose any hearts");
                damager.sendMessage(ChatColor.RED + "The person you are trying to attack does not have a hour of playtime. Therefore they will not drop hearts when killed");
            }
            if (onSameTeam(damaged, damager)) {
                event.setCancelled(true);
                return;
            }
        }
        if (!event.isCancelled()) {
            if (damaged.equals(damager)) return;
            tagPlayer(damager, damaged);
            tagPlayer(damaged, damager);
        }
    }

    private void handleVillagerDamage(EntityDamageByEntityEvent event, Player damager) {
        if (damager == null) return;

        if (getPlaytime(damager) < 12000 && !newbieViolate.contains(damager.getName())) {
            newbieViolate.add(damager.getName());
            event.setCancelled(true);
            //lifestealSmp.getServer().broadcastMessage(ChatColor.YELLOW + damager.getName() + " has lost their newbie protection for 5 minutes because of potentially breaking the no griefing rule during newbie protection");
            new BukkitRunnable() {
                @Override
                public void run() {
                    newbieViolate.remove(damager.getName());
                }
            }.runTaskLater(lifestealSmp, 20 * 60 * 5);
        }
        /*if (invincibilityPlayers.contains(damager.getName())) {
            event.setCancelled(true);
            invincibilityPlayers.remove(damager.getName());
            lifestealSmp.getServer().broadcastMessage(damager.getName() + ChatColor.YELLOW + " has lost their death protection for hearts & invincibility for potentially breaking the no griefing rule during death protection");
        }*/
    }

    @EventHandler
    public void onDeath(PlayerDeathEvent event) {
        Player p = event.getEntity();
        if (p == null) return;

        Player slainer = null;
        LivingEntity killer = p.getKiller();
        if (!(killer instanceof Player)) {
            if (isInCombat(p)) {
                if (getEnemies(p).isEmpty()) {
                    return;
                }
                killer = getEnemies(p).get(getEnemies(p).size() - 1);
            } else {
                return;
            }
        } else {
            slainer = (Player) killer;
        }
        if (slainer == null) return;
        if (slainer.equals(p)) return;
        removeEnemies(p);
        if (!heartCooldownPlayers.contains(p.getName()) && getPlaytime(p) > 72000) {
            if (areSameVersions(p, slainer)) {
                if (!(p.getMaxHealth() <= 2)) {
                    p.setMaxHealth(p.getMaxHealth() - 2);
                    heartCooldownPlayers.add(p.getName());

                    //p.sendMessage("You have heart cooldown for 15 minutes. You also have death protection invincibility for up to 15 minutes but you will lose it if you attack another player.");
                    //p.sendTitle(ChatColor.GOLD + "You have Death Protection", ChatColor.DARK_PURPLE + "If you attack anybody you will lose invincibility (Read chat)", 1, 100, 1);
                    new BukkitRunnable() {
                        @Override
                        public void run() {
                            heartCooldownPlayers.remove(p.getName());
                        }
                    }.runTaskLater(lifestealSmp, 20 * 60 * 15);
                } else {
                    eliminatePlayer(p);
                }
                if (!(killer.getMaxHealth() > maxHp)) {
                    killer.setMaxHealth(killer.getMaxHealth() + 2);
                } else {
                    addItemOrDrop(slainer, extraHeart(), "Heart was dropped because your inventory was full");
                }
            } else {
                slainer.sendMessage(ChatColor.RED + "You can't get hearts by killing other versions' players (so java/bedrock)");
                p.sendMessage(ChatColor.RED + "You didn't lose hearts since you were killed by other versions' players (so java/bedrock)");
            }
        }
        invincibilityPlayers.add(p.getName());
        new BukkitRunnable() {
            @Override
            public void run() {
                invincibilityPlayers.remove(p.getName());
            }
        }.runTaskLater(lifestealSmp, 20 * 60 * 15);
    }

    public static boolean isGracePeriod() {
        return !isTimePassed(SEASON_START_TIME.plusHours(1));
    }
}
