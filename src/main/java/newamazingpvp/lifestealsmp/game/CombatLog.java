package newamazingpvp.lifestealsmp.game;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.boss.BarColor;
import org.bukkit.boss.BarStyle;
import org.bukkit.boss.BossBar;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;
import org.bukkit.scheduler.BukkitRunnable;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static newamazingpvp.lifestealsmp.LifestealSMP.lifestealSmp;

public class CombatLog {
    public static List<Player> combaters = new ArrayList<>();
    private static Map<Player, PlayerCombatData> playerCombatDataMap = new HashMap<>();

    public static void tagPlayer(Player p, Player enemy) {
        if (playerCombatDataMap.get(p) != null) {
            playerCombatDataMap.get(p).setTimer(90);
            playerCombatDataMap.get(p).addEnemy(enemy);
        } else {
            combaters.add(p);

            BossBar bossBar = Bukkit.createBossBar(ChatColor.RED + "Combat Log Timer: 90 seconds left", BarColor.YELLOW, BarStyle.SOLID);
            bossBar.addPlayer(p);

            PlayerCombatData combatData = new PlayerCombatData(bossBar, 90);
            playerCombatDataMap.put(p, combatData);
            playerCombatDataMap.get(p).addEnemy(enemy);
        }
        new BukkitRunnable() {
            @Override
            public void run() {
                if (!combaters.contains(p) || !playerCombatDataMap.containsKey(p)) {
                    cancelCombatData(p);
                    this.cancel();
                    return;
                }

                playerCombatDataMap.get(p).updateBossBar();
                playerCombatDataMap.get(p).decreaseTimer();

                if (playerCombatDataMap.get(p).getTimer() <= -1) {
                    cancelCombatData(p);
                }
            }
        }.runTaskTimer(lifestealSmp, 0L, 20L);
    }

    public static void cancelCombatData(Player player) {
        PlayerCombatData combatData = playerCombatDataMap.remove(player);
        if (combatData != null) {
            combatData.getBossBar().removeAll();
            combaters.remove(player);
        }
    }

    public static void removeEnemies(Player player){
        PlayerCombatData combatData = playerCombatDataMap.get(player);
        if (combatData != null) {
            for(Player p : combatData.getEnemies()) {
                cancelCombatData(p);
            }
        }
    }

    public static boolean isPlayerInCombat(Player player) {
        return combaters.contains(player);
    }

    private static class PlayerCombatData {
        private BossBar bossBar;
        private int timer;
        private final List<Player> enemies = new ArrayList<>();

        public PlayerCombatData(BossBar bossBar, int timer) {
            this.bossBar = bossBar;
            this.timer = timer;
        }

        public BossBar getBossBar() {
            return bossBar;
        }

        public int getTimer() {
            return timer;
        }

        public void setTimer(int time) {
            timer = time;
        }

        public void addEnemy(Player enemy) {
            if (!enemies.contains(enemy)) {
                enemies.add(enemy);
            }
        }

        public void removeEnemy(Player enemy) {
            enemies.remove(enemy);
        }

        public List<Player> getEnemies() {
            return enemies;
        }

        public void decreaseTimer() {
            timer--;
        }

        public void updateBossBar() {
            bossBar.setProgress((double) timer / 90.0);
            bossBar.setTitle(ChatColor.RED + "Combat Log Timer: " + timer + " seconds left");
        }
    }
}
