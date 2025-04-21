package newamazingpvp.lifestealsmp.blacklistener;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityToggleGlideEvent;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.inventory.ItemStack;

import static newamazingpvp.lifestealsmp.game.CombatLog.isInCombat;
import static newamazingpvp.lifestealsmp.utility.Utils.addItemOrDrop;

public class DisableItemsInCombat implements Listener {
    @EventHandler
    public void onPlayerMove(PlayerMoveEvent event) {
        Player player = event.getPlayer();
        if (isInCombat(player)) {
            if (event.getFrom().distanceSquared(event.getTo()) > 0) {
                ItemStack item = player.getInventory().getItemInMainHand();
                ItemStack offhandItem = player.getInventory().getItemInMainHand();
                if (item.getType() == Material.TRIDENT || offhandItem.getType() == Material.TRIDENT) {
                    if (player.isRiptiding()) {
                        event.setCancelled(true);
                    }
                }
                ItemStack chestplate = player.getInventory().getChestplate();
                if (chestplate != null && chestplate.getType() == Material.ELYTRA) {
                    if (player.isGliding()) {
                        player.setGliding(false);
                        player.getInventory().setChestplate(null);
                        addItemOrDrop(player, chestplate, ChatColor.RED + "Your elytra was dropped. DO NOT use during combat!");
                    }
                }
            }
        }
        //spawn prot removed
        /*if (isWithinSpawnRadius(player.getLocation())){
            if (Math.random() < 0.01){
                player.sendMessage(ChatColor.RED + "If you are stuck, do /spawn to get out");
            }
            if (Math.random() < 0.003){
                player.sendTitle(ChatColor.RED + "If you get stuck, do /spawn to get out", "/spawn");
            }
        }*/

    }

    @EventHandler
    public void onEntityToggleGlide(EntityToggleGlideEvent event) {
        if (event.getEntity() instanceof Player player) {
            if (isInCombat(player) && player.getInventory().getChestplate() != null && player.getInventory().getChestplate().getType() == Material.ELYTRA) {
                player.setGliding(false);
                event.setCancelled(true);
                ItemStack chestplate = player.getInventory().getChestplate();
                player.getInventory().setChestplate(null);
                addItemOrDrop(player, chestplate, ChatColor.RED + "Your elytra was dropped. DO NOT use during combat!");
            }
        }
    }


}
