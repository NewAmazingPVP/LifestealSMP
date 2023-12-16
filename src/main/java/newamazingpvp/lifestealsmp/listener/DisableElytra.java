package newamazingpvp.lifestealsmp.listener;

import com.destroystokyo.paper.event.player.PlayerArmorChangeEvent;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityToggleGlideEvent;
import org.bukkit.inventory.ItemStack;

import static newamazingpvp.lifestealsmp.game.CombatLog.isInCombat;

public class DisableElytra implements Listener {
    @EventHandler
    public void onArmorChange(PlayerArmorChangeEvent event) {
        /*Player player = event.getPlayer();
        ItemStack newArmorPiece = event.getNewItem();

        // Check if the new armor piece is an elytra
        if (newArmorPiece != null && isElytra(newArmorPiece)) {
            player.getInventory().setChestplate(null);
            player.getInventory().addItem(new ItemStack(Material.ELYTRA));
            player.sendMessage(ChatColor.RED + "You cannot equip an elytra!");
        }*/
    }

    private boolean isElytra(ItemStack item) {
        return item.getType().toString().toLowerCase().contains("elytra");
    }

    @EventHandler
    public void onEntityToggleGlide(EntityToggleGlideEvent event) {
        if (event.getEntity() instanceof Player) {
            if (isInCombat((Player) event.getEntity())) {
                event.setCancelled(true);
            }
        }
    }
}
