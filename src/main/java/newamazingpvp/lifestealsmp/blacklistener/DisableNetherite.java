package newamazingpvp.lifestealsmp.blacklistener;

import com.destroystokyo.paper.event.player.PlayerArmorChangeEvent;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.ItemStack;

import static newamazingpvp.lifestealsmp.LifestealSMP.lifestealSmp;
import static newamazingpvp.lifestealsmp.utility.Utils.addItemOrDrop;

public class DisableNetherite implements Listener {
    @EventHandler
    public void onArmorChange(PlayerArmorChangeEvent event) {
        Player player = event.getPlayer();
        ItemStack newArmorPiece = event.getNewItem();

        if (newArmorPiece != null && isElytra(newArmorPiece)) {
            player.getInventory().setChestplate(null);
            Bukkit.getScheduler().runTaskLater(lifestealSmp, () -> addItemOrDrop(player, newArmorPiece, "Your inventory was full, item dropped"), 20);
            player.sendMessage(ChatColor.RED + "Why did you try breaking a rule and wasting resources!? Do /rules");
        }
    }
    @EventHandler
    public void onInventoryClick(InventoryClickEvent event){
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
