package newamazingpvp.lifestealsmp.Visuals;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.attribute.Attribute;
import org.bukkit.attribute.AttributeInstance;
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
import org.bukkit.scheduler.BukkitRunnable;

import java.util.HashMap;
import java.util.UUID;

import static newamazingpvp.lifestealsmp.LifestealSMP.lifestealSmp;

public class HP_Bar implements Listener {


    @EventHandler
    public void entityDamaged(EntityDamageByEntityEvent e) {

        LivingEntity damagedEntity = (LivingEntity) e.getEntity();
        Entity attacker = e.getDamager();
        double damageAmount = e.getDamage();
        double maxHealth = damagedEntity.getAttribute(Attribute.GENERIC_MAX_HEALTH).getValue();
        double currentHealth = maxHealth - e.getFinalDamage();



        if(attacker instanceof Player){
            BossBar HPBar = Bukkit.createBossBar(" ", BarColor.RED, BarStyle.SEGMENTED_20);
            HPBar.addPlayer((Player) attacker);
            HPBar.setProgress(1.0);
            HPBar.setProgress(currentHealth/maxHealth);
            HPBar.setVisible(true);
            double hpPercent = currentHealth / maxHealth;
            if( hpPercent > 0.75 ){
                HPBar.setTitle(ChatColor.BOLD + "" + ChatColor.DARK_RED + currentHealth + " / " + maxHealth + ChatColor.DARK_RED + "❤");
            }else if( hpPercent <= 0.75 && hpPercent > 0.50){
                HPBar.setTitle(ChatColor.BOLD + "" + ChatColor.GOLD + currentHealth + " / " + maxHealth + ChatColor.GOLD + "❤");
            }else if( hpPercent <= 0.50 && hpPercent > 0.25){
                HPBar.setTitle(ChatColor.BOLD + "" + ChatColor.YELLOW + currentHealth + " / " + maxHealth + ChatColor.YELLOW + "❤");
            }else if( hpPercent <= 0.50 && hpPercent > 0){
                HPBar.setTitle(ChatColor.BOLD + "" + ChatColor.DARK_GREEN + currentHealth + " / " + maxHealth + ChatColor.DARK_GREEN + "❤");
            }else if(hpPercent <=0 ){
                HPBar.setVisible(false); 
            }


        }



    }




}
