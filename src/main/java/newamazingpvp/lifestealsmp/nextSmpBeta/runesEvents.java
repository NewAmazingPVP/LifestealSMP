package newamazingpvp.lifestealsmp.nextSmpBeta;



import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDeathEvent;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import java.util.EventListener;

public class runesEvents implements Listener {

    public void playerMove(PlayerMoveEvent e) {

        //AQUA RUNE
        PotionEffect effect = new PotionEffect(PotionEffectType.DOLPHINS_GRACE, 100, 1); //change if needed

        Player player = e.getPlayer();
        ItemStack[] items = player.getInventory().getContents();

        for (ItemStack item : items) {
            if (item != null) {
                ItemMeta meta = item.getItemMeta();
                if (meta.hasDisplayName() && meta.getDisplayName().equals(ChatColor.LIGHT_PURPLE + "" + ChatColor.MAGIC + "E" + "" + ChatColor.AQUA + "" + ChatColor.BOLD + " Aqua Rune " + ChatColor.LIGHT_PURPLE + "" + ChatColor.MAGIC + "E")) {
                    player.sendMessage("test_item");
                    if (e.getPlayer().getLocation().getBlock().getType() == Material.WATER) {
                        player.sendMessage("effect_test");
                        player.addPotionEffect(effect);
                    }
                }
            }
        }
    }
}
