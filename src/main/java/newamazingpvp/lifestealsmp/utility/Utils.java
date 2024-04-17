package newamazingpvp.lifestealsmp.utility;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import static newamazingpvp.lifestealsmp.LifestealSMP.essentials;

public class Utils {

    public static void addItemOrDrop(Player player, ItemStack itemStack, String fullInventoryMessage) {
        if (player.getInventory().firstEmpty() != -1) {
            player.getInventory().addItem(itemStack);
        } else {
            World world = player.getWorld();
            world.dropItem(player.getLocation(), itemStack);
            player.sendMessage(ChatColor.GRAY + fullInventoryMessage);
        }
    }

    public static void setPrefix(Player p, String s) {
        essentials.getUser(p.getUniqueId()).setNickname(ChatColor.translateAlternateColorCodes('&', s) + " " + p.getName());
    }

    public static String getPrefix(Player p) {
        return essentials.getUser(p.getUniqueId()).getNickname();
    }

    public static boolean isRuneInInventory(Player p, String rune){
        ItemStack[] items = p.getInventory().getContents();

        for (ItemStack item : items) {
            if (item != null) {
                ItemMeta meta = item.getItemMeta();
                if (meta.hasLore()) {
                    return meta.getLore().toString().toLowerCase().contains(rune.toLowerCase());
                }
            }
        }
        return false;
    }

}
