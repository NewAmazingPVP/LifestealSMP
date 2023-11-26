package newamazingpvp.lifestealsmp.listener;

import com.destroystokyo.paper.event.player.PlayerArmorChangeEvent;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryInteractEvent;
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

        player.sendMessage("Armor Change Detected");

        if (helmet.getType().equals(Material.PLAYER_HEAD)) {
            if (meta.getDisplayName().equals(ChatColor.LIGHT_PURPLE + "" + ChatColor.MAGIC + "LL " + ChatColor.DARK_RED + "" + ChatColor.BOLD + "Void Walker Helmet" + ChatColor.LIGHT_PURPLE + "" + ChatColor.MAGIC + " LL")) {
                player.addScoreboardTag("voidwalker");
                player.sendMessage("added");
            } else {
                player.removeScoreboardTag("voidwalker");
                player.sendMessage("removed1");
            }
        } else {
            player.removeScoreboardTag("voidwalker");
            player.sendMessage("removed2");
        }
    }

    @EventHandler
    public void onPlayerInteract(InventoryClickEvent event) {
        Player player = (Player) event.getWhoClicked();
        ItemStack helmet = player.getInventory().getHelmet();
        ItemMeta meta = helmet.getItemMeta();

        player.sendMessage("Armor Change Detected");

        if (helmet.getType().equals(Material.PLAYER_HEAD)) {
            if (meta.getDisplayName().equals(ChatColor.LIGHT_PURPLE + "" + ChatColor.MAGIC + "LL " + ChatColor.DARK_RED + "" + ChatColor.BOLD + "Void Walker Helmet" + ChatColor.LIGHT_PURPLE + "" + ChatColor.MAGIC + " LL")) {
                player.addScoreboardTag("voidwalker");
                player.sendMessage("added11");
            } else {
                player.removeScoreboardTag("voidwalker");
                player.sendMessage("removed111");
            }
        } else {
            player.removeScoreboardTag("voidwalker");
            player.sendMessage("removed222");
        }
    }

    @EventHandler
    public void onPlayerInteract(PlayerMoveEvent event) {
        Player player = event.getPlayer();

        if (player.getScoreboardTags().contains("voidwalker")) {
            event.setCancelled(true);
        }
    }

    @EventHandler
    public void onPlayerInteract(BlockPlaceEvent event) {
        Player player = event.getPlayer();

        player.removeScoreboardTag("voidwalker");

    }
}

