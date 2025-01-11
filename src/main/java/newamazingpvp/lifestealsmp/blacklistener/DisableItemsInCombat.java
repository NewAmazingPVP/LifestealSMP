package newamazingpvp.lifestealsmp.blacklistener;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.inventory.ItemStack;

import static newamazingpvp.lifestealsmp.game.CombatLog.isInCombat;
import static newamazingpvp.lifestealsmp.listener.SpawnProtection.isWithinSpawnRadius;

public class DisableItemsInCombat implements Listener {
    @EventHandler
    public void onPlayerMove(PlayerMoveEvent event) {
        Player player = event.getPlayer();
        if (isInCombat(player)) {
            if (event.getFrom().distanceSquared(event.getTo()) > 0) {
                ItemStack item = player.getInventory().getItemInMainHand();
                if (item.getType() == Material.TRIDENT) {
                    if (player.isRiptiding()) {
                        event.setCancelled(true);
                    }
                }
                ItemStack chestplate = player.getInventory().getChestplate();
                if (chestplate != null && chestplate.getType() == Material.ELYTRA) {
                    if (player.isGliding()) {
                        player.setGliding(false);
                    }
                }
            }
        }
        if (isWithinSpawnRadius(player.getLocation())){
            if (Math.random() < 0.01){
                player.sendMessage(ChatColor.RED + "If you are stuck, do /spawn to get out");
            }
            if (Math.random() < 0.003){
                player.sendTitle(ChatColor.RED + "If you get stuck, do /spawn to get out", "/spawn");
            }
        }

    }
}
