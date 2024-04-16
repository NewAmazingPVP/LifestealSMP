package newamazingpvp.lifestealsmp.runes;

import org.bukkit.ChatColor;
import org.bukkit.World;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.EntityDeathEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class BloodRune implements Listener {


    @EventHandler
    public void playerAttack(EntityDeathEvent e) {

        Player killer = e.getEntity().getKiller();
        ItemStack[] items = killer.getInventory().getContents();
        PotionEffect effect = new PotionEffect(PotionEffectType.INCREASE_DAMAGE, 20*5, 4); //change if needed

        for (ItemStack item : items) {
            if (item != null) {
                ItemMeta meta = item.getItemMeta();
                if (meta.hasDisplayName() && meta.getDisplayName().equals(ChatColor.LIGHT_PURPLE + "" + ChatColor.MAGIC + "E" + ChatColor.DARK_RED + ChatColor.BOLD + " Hell Rune " + ChatColor.LIGHT_PURPLE + ChatColor.MAGIC + "E")) {
                        killer.addPotionEffect(effect);
                    }
                }
            }
        }
    }

