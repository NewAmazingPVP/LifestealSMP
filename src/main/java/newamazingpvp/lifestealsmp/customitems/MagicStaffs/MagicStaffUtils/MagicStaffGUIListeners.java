package newamazingpvp.lifestealsmp.customitems.MagicStaffs.MagicStaffUtils;

import newamazingpvp.lifestealsmp.customitems.MagicStaffs.MajicStaffAbilitys.MagicStaffDefault;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import static newamazingpvp.lifestealsmp.customitems.MagicStaffs.MagicStaffUtils.MagicStaffItemstacks.magicStaffAir;
import static newamazingpvp.lifestealsmp.customitems.MagicStaffs.MagicStaffUtils.MagicStaffItemstacks.magicStaffDefault;

public class MagicStaffGUIListeners implements Listener {

    @EventHandler
    public void onMenuClick(InventoryClickEvent event) {

        ItemStack itemInHand = event.getCurrentItem();
        ItemMeta meta = itemInHand.getItemMeta();
        Player player = (Player) event.getWhoClicked();

        if (event.getView().getTitle().equalsIgnoreCase(ChatColor.GOLD + "" + ChatColor.BOLD + "Music Box")) {

            if (itemInHand != null && itemInHand.getType() == Material.STICK && itemInHand.hasItemMeta() && itemInHand.getItemMeta().hasDisplayName() && itemInHand.getItemMeta().getDisplayName().equals(ChatColor.GRAY + "" + ChatColor.BOLD + "Magic Staff")) {
                player.playSound(player.getLocation(), Sound.BLOCK_NOTE_BLOCK_PLING, 1.0f, 2.0f);
                player.getInventory().addItem(magicStaffDefault());
            }

            if (itemInHand != null && itemInHand.getType() == Material.STICK && itemInHand.hasItemMeta() && itemInHand.getItemMeta().hasDisplayName() && itemInHand.getItemMeta().getDisplayName().equals(ChatColor.WHITE + "" + ChatColor.BOLD + "Air Magic Staff")) {
                player.playSound(player.getLocation(), Sound.BLOCK_NOTE_BLOCK_PLING, 1.0f, 2.0f);
                player.getInventory().addItem(magicStaffAir());
            }
            
        }
    }
}
