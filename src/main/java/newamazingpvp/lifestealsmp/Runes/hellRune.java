package newamazingpvp.lifestealsmp.Runes;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Sound;
import org.bukkit.World;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class hellRune implements Listener {

    @EventHandler
    public void playerAttack(EntityDamageByEntityEvent e) {

        Player attacker = (Player) e.getDamager();
        ItemStack[] items = attacker.getInventory().getContents();
        World world = attacker.getWorld();
        PotionEffect effect = new PotionEffect(PotionEffectType.DOLPHINS_GRACE, 100, 0); //change if needed

        for (ItemStack item : items) {
            if (item != null) {
                ItemMeta meta = item.getItemMeta();
                if (meta.hasDisplayName() && meta.getDisplayName().equals(ChatColor.LIGHT_PURPLE + "" + ChatColor.MAGIC + "E" + "" + ChatColor.DARK_RED + "" + ChatColor.BOLD + " Hell Rune " + ChatColor.LIGHT_PURPLE + "" + ChatColor.MAGIC + "E")) {
                    if (world.getEnvironment() == World.Environment.NETHER) {
                        attacker.addPotionEffect(effect);
                    }
                }
            }
        }
    }
}

