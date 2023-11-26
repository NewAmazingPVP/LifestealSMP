package newamazingpvp.lifestealsmp.listener;

import com.destroystokyo.paper.event.player.PlayerArmorChangeEvent;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.scheduler.BukkitRunnable;

import java.util.EventListener;

import static newamazingpvp.lifestealsmp.LifestealSMP.lifestealSmp;

public class VoidWalkerHelm implements Listener {

    @EventHandler
    public void onPlayerInteract(PlayerArmorChangeEvent event) {
        Player player = event.getPlayer();
        ItemStack helmet = player.getInventory().getHelmet();
        ItemMeta meta = helmet.getItemMeta();

        player.removeScoreboardTag("void-walker");

        if (helmet != null && helmet.getType().equals(Material.PLAYER_HEAD)) {
            if (meta != null && meta.getDisplayName().equals(ChatColor.LIGHT_PURPLE + "" + ChatColor.MAGIC + "LL " + ChatColor.DARK_RED + "" + ChatColor.BOLD + "Void Walker Helmet" + ChatColor.LIGHT_PURPLE + "" + ChatColor.MAGIC + " LL")) {
                player.addScoreboardTag("void-walker");
                player.sendMessage("added");
            }
        }
    }

    @EventHandler
    public void onPlayerInteract(PlayerMoveEvent event) {
        Player player = event.getPlayer();

        if (player.getScoreboardTags().contains("void-walker")) {
            event.setCancelled(true);
        }
    }

    @EventHandler
    public void onPlayerInteract(BlockPlaceEvent event) {
        Player player = event.getPlayer();

        player.removeScoreboardTag("void-walker");

    }
}

