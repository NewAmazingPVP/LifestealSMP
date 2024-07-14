package newamazingpvp.lifestealsmp.Visuals;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.attribute.Attribute;
import org.bukkit.boss.BarColor;
import org.bukkit.boss.BarStyle;
import org.bukkit.boss.BossBar;
import org.bukkit.entity.Entity;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.player.PlayerJoinEvent;

import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.UUID;

import static newamazingpvp.lifestealsmp.utility.Utils.returnPlayerDamager;

public class HP_Bar implements Listener {

    private static final HashMap<UUID, BossBar> linkHPBossBarToPlayer = new HashMap<>();

    @EventHandler
    public void playerJoin(PlayerJoinEvent e) {
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

    @EventHandler
    public void entityDamaged(EntityDamageByEntityEvent e) {
        if (!(e.getEntity() instanceof LivingEntity)) {
            return;
        }

        LivingEntity damagedEntity = (LivingEntity) e.getEntity();
        Player attacker = returnPlayerDamager(e.getDamager());

        if (attacker == null) {
            return;
        }

        UUID attackerUUID = attacker.getUniqueId();

        BossBar HPBar = linkHPBossBarToPlayer.get(attackerUUID);
        if (HPBar == null) {
            addBossBar(attacker);
            HPBar = linkHPBossBarToPlayer.get(attackerUUID);
        }

        double maxHealth = damagedEntity.getAttribute(Attribute.GENERIC_MAX_HEALTH).getValue();
        double currentHealth = Math.max(damagedEntity.getHealth() - e.getFinalDamage(), 0);
        DecimalFormat df = new DecimalFormat("0.0");
        double hpPercent = currentHealth / maxHealth;

        HPBar.setProgress(hpPercent);
        HPBar.setVisible(true);

        if (hpPercent > 0.75) {
            HPBar.setTitle(ChatColor.DARK_RED + "" + ChatColor.BOLD + df.format(currentHealth) + " / " + df.format(maxHealth) + " | -" + df.format(e.getDamage()) + ChatColor.DARK_RED + "❤");
        } else if (hpPercent > 0.50) {
            HPBar.setTitle(ChatColor.GOLD + "" + ChatColor.BOLD + df.format(currentHealth) + " / " + df.format(maxHealth) + " | -" + df.format(e.getDamage()) + ChatColor.GOLD + "❤");
        } else if (hpPercent > 0.25) {
            HPBar.setTitle(ChatColor.YELLOW + "" + ChatColor.BOLD + df.format(currentHealth) + " / " + df.format(maxHealth) + " | -" + df.format(e.getDamage()) + ChatColor.YELLOW + "❤");
        } else if (hpPercent > 0) {
            HPBar.setTitle(ChatColor.DARK_GREEN + "" + ChatColor.BOLD + df.format(currentHealth) + " / " + df.format(maxHealth) + " | -" + df.format(e.getDamage()) + ChatColor.DARK_GREEN + "❤");
        } else {
            HPBar.setVisible(false);
        }
    }
}
