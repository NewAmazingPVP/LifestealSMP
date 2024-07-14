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
import org.bukkit.event.player.PlayerJoinEvent;

import java.util.HashMap;
import java.util.UUID;


public class HP_Bar implements Listener {


    private static HashMap<UUID, BossBar> linkHPBossBarToPlayer = new HashMap<>();

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









    @EventHandler
    public void entityDamaged(EntityDamageByEntityEvent e) {


        LivingEntity damagedEntity = (LivingEntity) e.getEntity();
        Entity attackedMob = e.getEntity();
        Entity attacker = e.getDamager();
        double damageAmount = e.getDamage();
        double maxHealth = damagedEntity.getAttribute(Attribute.GENERIC_MAX_HEALTH).getValue();
        double currentHealth = maxHealth - e.getFinalDamage();



        if(attacker instanceof Player){
            UUID testUUID= attacker.getUniqueId();
            BossBar HPBar = linkHPBossBarToPlayer.get(testUUID);

            HPBar.addPlayer((Player) attacker);
            HPBar.setProgress(1.0);
            HPBar.setProgress(currentHealth/maxHealth);
            HPBar.setVisible(true);
            double hpPercent = currentHealth / maxHealth;
            if( hpPercent > 0.75 ){
                HPBar.setTitle(ChatColor.DARK_RED + "" + ChatColor.BOLD + currentHealth + " / " + maxHealth + " | -" + damageAmount + ChatColor.DARK_RED + "❤");
            }else if( hpPercent <= 0.75 && hpPercent > 0.50){
                HPBar.setTitle(ChatColor.GOLD + "" + ChatColor.BOLD + currentHealth + " / " + maxHealth + " | -" + damageAmount + ChatColor.GOLD + "❤");
            }else if( hpPercent <= 0.50 && hpPercent > 0.25){
                HPBar.setTitle(ChatColor.YELLOW + "" + ChatColor.BOLD + currentHealth + " / " + maxHealth + " | -" + damageAmount + ChatColor.YELLOW + "❤");
            }else if( hpPercent <= 0.50 && hpPercent > 0){
                HPBar.setTitle(ChatColor.DARK_GREEN + "" + ChatColor.BOLD + currentHealth + " / " + maxHealth + " | -" + damageAmount + ChatColor.DARK_GREEN + "❤");
            }else if(attackedMob.isDead()){
                HPBar.setVisible(false);
            }


        }



    }




}
