package newamazingpvp.lifestealsmp.blacklistener;

import com.destroystokyo.paper.event.player.PlayerArmorChangeEvent;
import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.ItemStack;

public class DisableNetherite implements Listener {
    @EventHandler
    /*public void onArmorChange(PlayerArmorChangeEvent event) {
        Player player = event.getPlayer();
        ItemStack newArmorPiece = event.getNewItem();

        if (newArmorPiece != null && isElytra(newArmorPiece)) {
            player.getInventory().setChestplate(null);
            Bukkit.getScheduler().runTaskLater(lifestealSmp, () -> player.getInventory().addItem(newArmorPiece), 20);
            player.sendMessage(ChatColor.RED + "Why did you try breaking a rule and wasting resources!? Do /rules");
        }
    }*/

    public void onInventoryClick(InventoryClickEvent event){
        if (event.getCurrentItem() != null && (event.getCurrentItem().getType() == Material.NETHERITE_CHESTPLATE
        || event.getCurrentItem().getType() == Material.NETHERITE_LEGGINGS ||
                event.getCurrentItem().getType() == Material.NETHERITE_HELMET ||
                event.getCurrentItem().getType() == Material.NETHERITE_BOOTS)) {
            event.setCancelled(true);
        }
    }

    private boolean isElytra(ItemStack item) {
        return item.getType().toString().toLowerCase().contains("netherite");
    }
}
