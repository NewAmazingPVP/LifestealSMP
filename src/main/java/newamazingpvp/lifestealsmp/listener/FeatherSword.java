package newamazingpvp.lifestealsmp.listener;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerItemHeldEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.util.Vector;

public class FeatherSword implements Listener {
    @EventHandler
    public void onPlayerItemHeld(PlayerItemHeldEvent event) {
        Player player = event.getPlayer();
        ItemStack heldItem = player.getInventory().getItem(event.getNewSlot());

        if (heldItem != null && heldItem.getType() == Material.DIAMOND_SWORD) {
            ItemMeta meta = heldItem.getItemMeta();
            if (meta.getLore().toString().contains("Permanent Speed 2")) {
                player.addPotionEffect(new PotionEffect(PotionEffectType.SPEED, 99999, 1));
            }
        }
    }

    @EventHandler
    public void onPlayerRightClick(PlayerInteractEvent event){
        if ((event.getAction() == Action.RIGHT_CLICK_AIR || event.getAction() == Action.RIGHT_CLICK_BLOCK) &&
                event.hasItem() && event.getItem().getType() == Material.DIAMOND_SWORD) {
            ItemMeta meta = event.getItem().getItemMeta();
            if (meta.getLore().toString().contains("Permanent Speed 2")) {
                Vector direction = event.getPlayer().getLocation().getDirection();

                direction.multiply(new Vector(5, 5, 5));
                event.getPlayer().teleport(event.getPlayer().getLocation().add(direction));
            }
        }
    }

}
