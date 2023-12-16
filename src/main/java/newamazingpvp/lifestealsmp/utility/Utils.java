package newamazingpvp.lifestealsmp.utility;

import org.bukkit.ChatColor;
import org.bukkit.World;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

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
}
