package newamazingpvp.lifestealsmp.blacklistener;

import com.destroystokyo.paper.event.player.PlayerArmorChangeEvent;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.ItemStack;

public class DisableNetherite implements Listener {
    @EventHandler
    public void onArmorChange(PlayerArmorChangeEvent event) {
        Player player = event.getPlayer();
        ItemStack newArmorPiece = event.getNewItem();
        ItemStack oldArmorPiece = event.getOldItem();

        if (isElytra(oldArmorPiece) || isElytra(newArmorPiece)) {
            if (player.getInventory().getHelmet() != null && player.getInventory().getHelmet().getType() == Material.NETHERITE_HELMET) {
                player.getInventory().setHelmet(null);
            }

            if (player.getInventory().getChestplate() != null && player.getInventory().getChestplate().getType() == Material.NETHERITE_CHESTPLATE) {
                player.getInventory().setChestplate(null);
            }

            if (player.getInventory().getLeggings() != null && player.getInventory().getLeggings().getType() == Material.NETHERITE_LEGGINGS) {
                player.getInventory().setLeggings(null);
            }

            if (player.getInventory().getBoots() != null && player.getInventory().getBoots().getType() == Material.NETHERITE_BOOTS) {
                player.getInventory().setBoots(null);
            }
            player.sendMessage(ChatColor.RED + "Why did you try breaking a rule and wasting resources!? Do /rules");
        }
    }

    @EventHandler
    public void onInventoryClick(InventoryClickEvent event) {
        if (event.getCurrentItem() != null && (event.getCurrentItem().getType() == Material.NETHERITE_CHESTPLATE
                || event.getCurrentItem().getType() == Material.NETHERITE_LEGGINGS ||
                event.getCurrentItem().getType() == Material.NETHERITE_HELMET ||
                event.getCurrentItem().getType() == Material.NETHERITE_BOOTS)) {
            event.setCancelled(true);
            event.getWhoClicked().sendMessage(ChatColor.RED + "Why did you try breaking a rule and wasting resources!? Do /rules");
        }
    }

    private boolean isElytra(ItemStack item) {
        return item.getType().toString().toLowerCase().contains("netherite");
    }
}
