package newamazingpvp.lifestealsmp.listener;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.damage.DamageSource;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.event.player.PlayerKickEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.event.player.PlayerRespawnEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.scheduler.BukkitRunnable;

import java.util.List;

import static newamazingpvp.lifestealsmp.LifestealSMP.lifestealSmp;
import static newamazingpvp.lifestealsmp.customitems.utils.ItemStacks.extraHeart;
import static newamazingpvp.lifestealsmp.game.CombatLog.*;
import static newamazingpvp.lifestealsmp.game.Compass.getPlaytime;
import static newamazingpvp.lifestealsmp.game.PlayerLifeManager.eliminatePlayer;
import static newamazingpvp.lifestealsmp.listener.CombatProtectionHandler.heartCooldownPlayers;
import static newamazingpvp.lifestealsmp.listener.CombatProtectionHandler.invincibilityPlayers;
import static newamazingpvp.lifestealsmp.utility.Utils.addItemOrDrop;
import static newamazingpvp.lifestealsmp.variables.Misc.maxHp;

public class CombatLogListener implements Listener {
    @EventHandler(priority = EventPriority.LOW)
    public void onPlayerKick(PlayerKickEvent e) {
        cancelCombatData(e.getPlayer());
        removeEnemies(e.getPlayer());
    }

    @EventHandler
    public void onPlayerDisconnect(PlayerQuitEvent e) {
        if (e.getReason() == PlayerQuitEvent.QuitReason.ERRONEOUS_STATE ||
                e.getReason() == PlayerQuitEvent.QuitReason.KICKED ||
                e.getReason() == PlayerQuitEvent.QuitReason.TIMED_OUT) {
            cancelCombatData(e.getPlayer());
            removeEnemies(e.getPlayer());
            return;
        }
        if (isInCombat(e.getPlayer())) {
            Player p = e.getPlayer();

            if (getCombatTimer(p) < 85) {
                if (!heartCooldownPlayers.contains(e.getPlayer().getName()) && getPlaytime(p) > 72000) {
                    if (areSameVersions(p, getEnemies(p).get(getEnemies(p).size() - 1))) {
                        if (!(p.getMaxHealth() <= 2)) {
                            p.setMaxHealth(p.getMaxHealth() - 2);
                            heartCooldownPlayers.add(p.getName());
                            new BukkitRunnable() {
                                @Override
                                public void run() {
                                    heartCooldownPlayers.remove(p.getName());
                                }
                            }.runTaskLater(lifestealSmp, 20 * 60 * 15);
                        } else {
                            eliminatePlayer(p);
                        }
                        Player winner = getEnemies(p).get(getEnemies(p).size() - 1);
                        if (!(winner.getMaxHealth() > maxHp)) {
                            winner.setMaxHealth(winner.getMaxHealth() + 2);
                        } else {
                            winner.sendMessage(ChatColor.DARK_PURPLE + "You were given heart item because you reached max health!");
                            addItemOrDrop(winner, extraHeart(), ChatColor.LIGHT_PURPLE + "Heart was dropped because your inventory was full");
                        }
                    }
                }
            }
            p.setHealth(0.0);


            ItemStack[] inventoryContents = p.getInventory().getContents();

            for (int i = 0; i < inventoryContents.length; i++) {
                if (inventoryContents[i] == null) {
                    inventoryContents[i] = new ItemStack(Material.AIR);
                }
            }

            String deathMessage = p.getName() + " was killed instantly due to logging out during combat!";
            PlayerDeathEvent deathEvent = new PlayerDeathEvent(p, (DamageSource) getEnemies(p).get(getEnemies(p).size() - 1), List.of(inventoryContents), 0, 0, 0, 0, deathMessage);
            Bukkit.getPluginManager().callEvent(deathEvent);
            invincibilityPlayers.add(p.getName());
            new BukkitRunnable() {
                @Override
                public void run() {
                    invincibilityPlayers.remove(p.getName());
                }
            }.runTaskLater(lifestealSmp, 20 * 60 * 15);

            cancelCombatData(e.getPlayer());
            removeEnemies(e.getPlayer());
        }
    }

    @EventHandler
    public void onPlayerRespawn(PlayerRespawnEvent e) {
        if (isInCombat(e.getPlayer())) {
            cancelCombatData(e.getPlayer());
        }
    }

    // just directly return true if you dont care about what versions
    public static boolean areSameVersions(Player p, Player p1) {
        return (p.getName().startsWith(".") && p1.getName().startsWith(".")) || (!p.getName().startsWith(".") && !p1.getName().startsWith("."));
    }
}
