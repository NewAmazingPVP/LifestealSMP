package newamazingpvp.lifestealsmp.unused.misc;

import org.bukkit.ChatColor;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class VoidWalkerHelmEffects implements Listener {


    @EventHandler
    public void onEntityDamage(EntityDamageByEntityEvent e) {

        Entity damager = e.getDamager();
        Entity damageTaker = e.getEntity();

        if (e.getEntity() instanceof Player player) {
            ItemStack helmet = player.getInventory().getHelmet();
            if (helmet != null) {
                ItemMeta meta = helmet.getItemMeta();
                if (meta.hasDisplayName() && meta.getDisplayName().equals(ChatColor.LIGHT_PURPLE + "" + ChatColor.MAGIC + "LL " + ChatColor.DARK_RED + ChatColor.BOLD + "Void Walker Helmet" + ChatColor.LIGHT_PURPLE + ChatColor.MAGIC + " LL")) {
                    if (damageTaker instanceof Player) {

                        player.addPotionEffect(new PotionEffect(PotionEffectType.INCREASE_DAMAGE, 40, 0));
                        player.sendMessage("Detected");


                    }
                }
            }
        }
    }
}

