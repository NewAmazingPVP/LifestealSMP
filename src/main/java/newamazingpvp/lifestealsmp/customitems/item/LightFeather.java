package newamazingpvp.lifestealsmp.customitems.item;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class LightFeather implements Listener {

    @EventHandler
    public void onPlayerRightClick(PlayerInteractEvent event) {
        Player player = event.getPlayer();
        if (!event.hasItem()) return;
        if (!event.getItem().hasItemMeta()) return;
        ItemMeta meta = event.getItem().getItemMeta();
        ItemStack item = player.getInventory().getItemInMainHand();

        if ((event.getAction() == Action.RIGHT_CLICK_AIR || event.getAction() == Action.RIGHT_CLICK_BLOCK) &&
                event.hasItem() && event.getItem().getType() == Material.FEATHER) {
            if (item.hasItemMeta() && item.getItemMeta().hasDisplayName() && ChatColor.stripColor(item.getItemMeta().getDisplayName()).equals("Light Feather")) {
                if (meta.getLore() == null) return;


                player.playSound(player.getLocation(), Sound.ENTITY_BLAZE_SHOOT, 1.0f, 2.0f);
                player.playSound(player.getLocation(), Sound.ENTITY_EXPERIENCE_ORB_PICKUP, 1.0f, 2.0f);
                player.addPotionEffect(new PotionEffect(PotionEffectType.SPEED, 80, 2));
                player.addPotionEffect(new PotionEffect(PotionEffectType.JUMP, 80, 2));
                if (item.getAmount() > 1) {
                    item.setAmount(item.getAmount() - 1);
                    player.getInventory().setItemInMainHand(item);
                } else {
                    player.getInventory().setItemInMainHand(null);
                }

            }
        }
    }
}
