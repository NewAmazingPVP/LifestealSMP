package newamazingpvp.lifestealsmp.listener;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.scheduler.BukkitRunnable;

import static newamazingpvp.lifestealsmp.LifestealSMP.lifestealSmp;

public class TotemLimiter {

    private static final ItemStack TOTEM_ITEM = new ItemStack(Material.TOTEM_OF_UNDYING, 1);

    public static void totemLimiter() {
        new BukkitRunnable() {
            @Override
            public void run() {
                for (Player player : Bukkit.getOnlinePlayers()) {
                    // this works but rlly ineffcient player.getInventory().all(Material.TOTEM_OF_UNDYING).size() > 5
                    int totemCount = 0;
                    for (ItemStack item : player.getInventory().getContents()) {
                        if (item != null && item.getType() == Material.TOTEM_OF_UNDYING) {
                            totemCount++;
                            if (totemCount > 5) {
                                break;
                            }
                        }
                    }
                    if (totemCount > 5) {
                        player.sendMessage(ChatColor.RED + "You have too many totems in your inventory! The totems have been dropped!!.");
                        player.getInventory().removeItem(TOTEM_ITEM);
                        player.getWorld().dropItemNaturally(player.getLocation(), TOTEM_ITEM);
                    }
                }
            }
        }.runTaskTimer(lifestealSmp, 0L, 10L);
    }
}