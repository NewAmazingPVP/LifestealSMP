package newamazingpvp.lifestealsmp.Visuals;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.boss.BarColor;
import org.bukkit.boss.BarStyle;
import org.bukkit.boss.BossBar;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.scheduler.BukkitRunnable;

import java.util.HashMap;
import java.util.UUID;

import static newamazingpvp.lifestealsmp.LifestealSMP.lifestealSmp;

public class HP_Bar implements Listener {

    private static HashMap<UUID, BossBar> linkHPBossBarToPlayer = new HashMap<>();

    public static BukkitRunnable removeBossBarHP;

    @EventHandler
    public void entityDamaged(EntityDamageByEntityEvent e) {

        Entity entity = e.getEntity();
        Entity attacker = e.getDamager();
        double damageAmount = e.getDamage();

        if (attacker instanceof Player) {
            UUID testUUID= attacker.getUniqueId();

            BossBar curentBossbar = linkHPBossBarToPlayer.get(testUUID);

            curentBossbar.setTitle(ChatColor.BOLD + "" + ChatColor.RED + "test");

            curentBossbar.setVisible(true);

            removeBossBarHP = new BukkitRunnable() {
                @Override
                public void run() {

                    int removeTime = 5;

                    if (removeTime <= 0) {
                        curentBossbar.setVisible(false);
                    } else {
                        removeTime -= 1;

                    }
                }
            };
            removeBossBarHP.runTaskTimer(lifestealSmp, 0L, 20L); // Start immediately and repeat every second

        }







        }









    @EventHandler
    public void playerJoin(PlayerJoinEvent e){

        Player player = e.getPlayer();
        UUID uuid = player.getUniqueId();

        if (!isPlayerInHashMap(uuid)) {
            addBossBar(player);
        }


    }


    private static boolean isPlayerInHashMap(UUID uuid) {
        return linkHPBossBarToPlayer.containsKey(uuid);
    }




    private static void addBossBar(Player player) {
        BossBar bossBar = Bukkit.createBossBar("HP TEST", BarColor.RED, BarStyle.SEGMENTED_20);
        linkHPBossBarToPlayer.put(player.getUniqueId(), bossBar);
        bossBar.setVisible(false);
        bossBar.addPlayer(player);
    }




}
