package newamazingpvp.lifestealsmp.customitems.utils;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.AnvilInventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class AntiAnvil implements Listener {


    @EventHandler
    public void onInventoryClick(InventoryClickEvent e) {

        ItemStack itemInHand = e.getCurrentItem();
        Player player = (Player) e.getWhoClicked();
        ItemMeta meta = itemInHand.getItemMeta();

        if (e.getClickedInventory() instanceof AnvilInventory) {
            if (itemInHand != null && itemInHand.getType() == Material.STICK && itemInHand.hasItemMeta()) {
                if (meta.hasLore() && meta.getLore().toString().contains(ChatColor.DARK_PURPLE + "Shoots a beam of power dealing " + ChatColor.RED + "1❤")) {
                    player.playSound(player.getLocation(), Sound.ENTITY_ENDERMAN_TELEPORT, 1.0f, 0.0f);
                    e.setCancelled(true);
                    player.sendMessage(ChatColor.RED + "This item can't be used in an anvil!");
                }
            }
        }



    }
}
