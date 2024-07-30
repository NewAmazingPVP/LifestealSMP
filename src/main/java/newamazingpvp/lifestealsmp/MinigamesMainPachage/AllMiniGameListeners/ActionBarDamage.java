package newamazingpvp.lifestealsmp.MinigamesMainPachage.AllMiniGameListeners;

import org.bukkit.ChatColor;
import org.bukkit.attribute.Attribute;
import org.bukkit.entity.Entity;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;

import java.text.DecimalFormat;
import java.util.UUID;

import static newamazingpvp.lifestealsmp.utility.Utils.returnPlayerDamager;

public class ActionBarDamage implements Listener {

    @EventHandler
    public void entityDamaged(EntityDamageByEntityEvent e) {
        if (!(e.getEntity() instanceof LivingEntity damagedEntity)) {
            return;
        }

        Player attacker = returnPlayerDamager(e.getDamager());

        if (attacker == null) {
            return;
        }

        Entity entity = e.getEntity();
        String name = entity.getName();





        double maxHealth = damagedEntity.getAttribute(Attribute.GENERIC_MAX_HEALTH).getValue();
        double currentHealth = Math.max(damagedEntity.getHealth() - e.getFinalDamage(), 0);
        DecimalFormat df = new DecimalFormat("0.0");
        DecimalFormat df2 = new DecimalFormat("0");



        String actionbarVisual = ChatColor.GOLD + name + " - ";


        actionbarVisual += ChatColor.RED + "";

        for(int i = 0; i < currentHealth ; i++) {
            actionbarVisual += "❤";
        }

        actionbarVisual+=ChatColor.GRAY;

        double missingHP = maxHealth - currentHealth;

        for(int i = 0; i < missingHP ; i++) {
            actionbarVisual += "❤";
        }

        attacker.sendActionBar(actionbarVisual);



    }



}
