package newamazingpvp.lifestealsmp.blacklistener;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerItemConsumeEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class AntiUseListener implements Listener {

    @EventHandler
    public void onPlayerInteract(PlayerInteractEvent event) {


        if (event.getAction() == Action.RIGHT_CLICK_AIR || event.getAction() == Action.RIGHT_CLICK_BLOCK) {
            ItemStack item = event.getItem();
            if (item != null && item.getType() == Material.BEETROOT && item.hasItemMeta() && item.getItemMeta().hasDisplayName() && item.getItemMeta().getDisplayName().equals(ChatColor.DARK_RED + "" + ChatColor.BOLD + "Severed Mob Heart")) {

                event.setCancelled(true);

            }
        }
    }

    @EventHandler
    public void onPlayerConsume(PlayerItemConsumeEvent event) {
        ItemStack item = event.getItem();
        if (item.getType() == Material.BEETROOT && item.hasItemMeta() && item.getItemMeta().hasDisplayName() && item.getItemMeta().getLore().contains("Severed")) {

            event.setCancelled(true);
            PotionEffect potion = new PotionEffect(PotionEffectType.POISON, 10, 1, false);
            event.getPlayer().addPotionEffect(potion);

        }
    }
}
