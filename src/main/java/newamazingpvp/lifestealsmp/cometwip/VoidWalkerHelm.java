package newamazingpvp.lifestealsmp.cometwip;

import com.destroystokyo.paper.event.player.PlayerArmorChangeEvent;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.event.inventory.InventoryInteractEvent;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class VoidWalkerHelm implements Listener {

    @EventHandler
    public void onPlayerInteract(PlayerArmorChangeEvent event) {
        Player player = event.getPlayer();
        ItemStack helmet = player.getInventory().getHelmet();
        ItemMeta meta = helmet.getItemMeta();


        if (helmet.getType().equals(Material.PLAYER_HEAD)) {
            if (meta.getDisplayName().equals(ChatColor.LIGHT_PURPLE + "" + ChatColor.MAGIC + "LL " + ChatColor.DARK_RED + ChatColor.BOLD + "Void Walker Helmet" + ChatColor.LIGHT_PURPLE + ChatColor.MAGIC + " LL")) {
                player.addScoreboardTag("voidwalker");
                player.sendMessage("added because armor chaned");
            } else {
                player.removeScoreboardTag("voidwalker");
                player.sendMessage("removed because armor changed not named correct");
            }
        } else {
            player.removeScoreboardTag("voidwalker");
            player.sendMessage("removed because armor changed not correct item");
        }
    }

    @EventHandler
    public void onPlayerInteract(InventoryInteractEvent event) {
        Player player = (Player) event.getWhoClicked();
        ItemStack helmet = player.getInventory().getHelmet();
        ItemMeta meta = helmet.getItemMeta();

        player.sendMessage("test1111111111111");

        if (helmet.getType().equals(Material.PLAYER_HEAD)) {
            if (meta.getDisplayName().equals(ChatColor.LIGHT_PURPLE + "" + ChatColor.MAGIC + "LL " + ChatColor.DARK_RED + ChatColor.BOLD + "Void Walker Helmet" + ChatColor.LIGHT_PURPLE + ChatColor.MAGIC + " LL")) {
                player.addScoreboardTag("voidwalker");
                player.sendMessage("added because invintory click");
            } else {
                player.removeScoreboardTag("voidwalker");
                player.sendMessage("removed because invintory click not correct name");
            }
        } else {
            player.removeScoreboardTag("voidwalker");
            player.sendMessage("removed because invintory click not correct item");
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

