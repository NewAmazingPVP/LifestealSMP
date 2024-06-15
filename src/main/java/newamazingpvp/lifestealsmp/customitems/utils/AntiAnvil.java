package newamazingpvp.lifestealsmp.customitems.utils;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.ItemStack;

public class AntiAnvil implements Listener {


    @EventHandler
    public void onInventoryClick(InventoryClickEvent e) {

        ItemStack itemInHand = e.getCurrentItem();
        Player player = (Player) e.getWhoClicked();

        if (itemInHand != null && itemInHand.getType() == Material.STICK && itemInHand.hasItemMeta()) {
            player.playSound(player.getLocation(), Sound.BLOCK_SCULK_SHRIEKER_SHRIEK, 1.0f, 2.0f);
            e.setCancelled(true);
            player.sendMessage(ChatColor.RED + "Disabled for " + cooldownRemainingTime(player)+".");
        }

    }


}
