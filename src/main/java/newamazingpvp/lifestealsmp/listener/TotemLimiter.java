package newamazingpvp.lifestealsmp.listener;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.scheduler.BukkitRunnable;

import static newamazingpvp.lifestealsmp.LifestealSMP.lifestealSmp;

public class TotemLimiter {

    public static void totemLimiter() {
        new BukkitRunnable() {
            @Override
            public void run() {
                for (Player player : Bukkit.getOnlinePlayers()) {
                    if (player.getInventory().all(Material.TOTEM_OF_UNDYING).size() > 5) {
                        player.sendMessage(ChatColor.RED + "You have too many totems in your inventory! The totems have been dropped!!.");
                        player.getInventory().removeItem(new ItemStack(Material.TOTEM_OF_UNDYING, 1));
                        player.getWorld().dropItemNaturally(player.getLocation(), new ItemStack(Material.TOTEM_OF_UNDYING, 1));
                    }
                }
            }
        }.runTaskTimer(lifestealSmp, 0L, 1L);
    }
}
