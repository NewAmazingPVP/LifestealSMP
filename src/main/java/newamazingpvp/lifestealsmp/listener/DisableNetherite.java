package newamazingpvp.lifestealsmp.listener;

import com.destroystokyo.paper.event.player.PlayerArmorChangeEvent;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.inventory.ItemStack;

import static newamazingpvp.lifestealsmp.LifestealSMP.lifestealSmp;

public class DisableNetherite implements Listener {
    @EventHandler
    public void onArmorChange(PlayerArmorChangeEvent event) {
        Player player = event.getPlayer();
        ItemStack newArmorPiece = event.getNewItem();

        if (newArmorPiece != null && isElytra(newArmorPiece)) {
            player.getInventory().setChestplate(null);
            Bukkit.getScheduler().runTaskLater(lifestealSmp, () -> player.getInventory().addItem(newArmorPiece), 20);
            player.sendMessage(ChatColor.RED + "Why did you try breaking a rule and wasting resources!? Do /rules");
        }
    }

    private boolean isElytra(ItemStack item) {
        return item.getType().toString().toLowerCase().contains("netherite");
    }
}
