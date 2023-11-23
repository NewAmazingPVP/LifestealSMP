package newamazingpvp.lifestealsmp.StaffListeners;

import com.destroystokyo.paper.event.player.PlayerArmorChangeEvent;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class DetectArmorSetBonus2 implements Listener {

    @EventHandler
    public void onPlayerChangeInvintory(PlayerArmorChangeEvent event) {

        Player player = event.getPlayer();

        ItemStack helmet = player.getInventory().getHelmet();
        ItemMeta metaH = helmet.getItemMeta();

        ItemStack chestplate = player.getInventory().getChestplate();
        ItemStack leggings = player.getInventory().getLeggings();
        ItemStack boots = player.getInventory().getBoots();

        ItemMeta meta = chestplate.getItemMeta();
        ItemMeta meta2 = leggings.getItemMeta();
        ItemMeta meta3 = boots.getItemMeta();

        if (helmet != null && helmet.getType().equals(Material.PLAYER_HEAD)) {
            if (metaH != null && metaH.getDisplayName().equals(ChatColor.GOLD + "" + ChatColor.BOLD + "Sekhmet's Helmet")) {

                if (chestplate != null && chestplate.getType().equals(Material.GOLDEN_CHESTPLATE)) {
                    if (meta != null && meta.getDisplayName().equals(ChatColor.GOLD + "" + ChatColor.BOLD + "Sekhmet's Chestplate")) {
                        if (leggings != null && leggings.getType().equals(Material.GOLDEN_LEGGINGS)) {
                            if (meta2 != null && meta2.getDisplayName().equals(ChatColor.GOLD + "" + ChatColor.BOLD + "Sekhmet's Leggings")) {
                                if (boots != null && boots.getType().equals(Material.GOLDEN_BOOTS)) {
                                    if (meta3 != null && meta3.getDisplayName().equals(ChatColor.GOLD + "" + ChatColor.BOLD + "Sekhmet's Boots")) {

                                        player.sendMessage("test2");

                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}
