package newamazingpvp.lifestealsmp.runes;

import com.destroystokyo.paper.event.player.PlayerJumpEvent;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class AirRune implements Listener {

    public boolean isPlayerOnGround(Player player) {
        Block blockBelow = player.getLocation().subtract(0, 1, 0).getBlock();
        return blockBelow.getType() != Material.AIR;
    }

    @EventHandler
    public void jump(PlayerJumpEvent e) {

        Player player = e.getPlayer();
        ItemStack[] items = player.getInventory().getContents();

        Block blockBelow = player.getLocation().subtract(0, 1, 0).getBlock();
        boolean isOnGround = blockBelow.getType() != Material.AIR;


        for (ItemStack item : items) {
            if (item != null) {
                ItemMeta meta = item.getItemMeta();
                if (meta.hasDisplayName() && meta.getDisplayName().equals(ChatColor.LIGHT_PURPLE + "" + ChatColor.MAGIC + "E" + ChatColor.WHITE + ChatColor.BOLD + " Air Rune " + ChatColor.LIGHT_PURPLE + ChatColor.MAGIC + "E")) {
                    if (isOnGround == true) {

                    }
                }
            }
        }
    }
}

