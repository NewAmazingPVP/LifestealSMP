package newamazingpvp.lifestealsmp.blacklistener;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.event.Listener;
import org.bukkit.event.EventHandler;
import org.bukkit.event.entity.ProjectileLaunchEvent;
import org.bukkit.entity.Player;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.event.player.PlayerRiptideEvent;
import org.bukkit.inventory.ItemStack;

import static newamazingpvp.lifestealsmp.game.CombatLog.isInCombat;

public class DisableItemsInCombat implements Listener {
    @EventHandler
    public void onPlayerMove(PlayerMoveEvent event) {
        Player player =  event.getPlayer();
        if (isInCombat(player)) {
            if (event.getFrom().distanceSquared(event.getTo()) > 0) {
                ItemStack item = player.getInventory().getItemInMainHand();
                if(item.getType() == Material.TRIDENT) {
                    if(player.isRiptiding()){
                        event.setCancelled(true);
                    }
                }
                ItemStack chestplate = player.getInventory().getChestplate();
                if (chestplate != null && chestplate.getType() == Material.ELYTRA) {
                     if (player.isFlying() || player.isGliding()) {
                        event.setCancelled(true);
                    }
                }
            }
        }
    }
}
