package newamazingpvp.lifestealsmp.game;

import org.bukkit.Bukkit;
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
    private static List<Player> combaters = new ArrayList<>();
    private static Map<Player, PlayerCombatData> playerCombatDataMap = new HashMap<>();

    public static void tagPlayer(Player p) {
        PlayerCombatData existingData = playerCombatDataMap.remove(p);

        if (existingData != null) {
            // Player already has combat data, create a new BossBar and reset the timer
            existingData.getBossBar().removeAll();
        }

        combaters.add(p);

        BossBar bossBar = Bukkit.createBossBar("Combat Log Timer: 90 seconds left", BarColor.BLUE, BarStyle.SOLID);
        bossBar.addPlayer(p);

        PlayerCombatData combatData = new PlayerCombatData(bossBar, 90);
        playerCombatDataMap.put(p, combatData);

        double initialProgress = 1.0;
        double progressDecreasePerSecond = initialProgress / 90.0;

        new BukkitRunnable() {
            @Override
            public void run() {
                if (!combaters.contains(p) || !playerCombatDataMap.containsKey(p)) {
                    cancelCombatData(p);
                    this.cancel();
                    return;
                }

                combatData.updateBossBar();
                combatData.decreaseTimer();

                if (combatData.getTimer() <= 0) {
                    // Combat timer expired, create a new BossBar and reset the timer
                    cancelCombatData(p);

                    BossBar newBossBar = Bukkit.createBossBar("Combat Log Timer: 90 seconds left", BarColor.BLUE, BarStyle.SOLID);
                    newBossBar.addPlayer(p);

                    PlayerCombatData newData = new PlayerCombatData(newBossBar, 90);
                    playerCombatDataMap.put(p, newData);
                }
            }
        }.runTaskTimer(lifestealSmp, 0L, 20L);
    }

    private static void cancelCombatData(Player player) {
        PlayerCombatData combatData = playerCombatDataMap.remove(player);
        if (combatData != null) {
            combatData.getBossBar().removeAll();
            combaters.remove(player);
        }
    }

    private static class PlayerCombatData {
        private BossBar bossBar;
        private int timer;

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

        public void decreaseTimer() {
            timer--;
        }

        public void updateBossBar() {
            bossBar.setProgress((double) timer / 90.0);
            bossBar.setTitle("Combat Log Timer: " + timer + " seconds left");
        }
    }
}
