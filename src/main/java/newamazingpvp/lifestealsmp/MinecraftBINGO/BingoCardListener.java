package newamazingpvp.lifestealsmp.MinecraftBINGO;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryInteractEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;
import java.util.List;

import static newamazingpvp.lifestealsmp.MinecraftBINGO.BingoCardGUI.BingoMainMenu;
import static newamazingpvp.lifestealsmp.MinecraftBINGO.BingoCardGUI.OpenTheBingoCardGUI;

public class BingoCardListener implements Listener {



    @EventHandler
    public void playerOpenBINOCard(PlayerInteractEvent e) {
        Player player = e.getPlayer();
        ItemMeta meta = e.getItem().getItemMeta();

        if ((e.getAction() == Action.RIGHT_CLICK_AIR || e.getAction() == Action.RIGHT_CLICK_BLOCK) &&
                e.hasItem() && e.getItem().getType() == Material.PAINTING) {

            if (meta.getLore() == null){
                return;
            }

            if (meta.getLore().toString().contains("Open Bingo Card")){

                e.setCancelled(true);

                player.playSound(player.getLocation(), Sound.BLOCK_NOTE_BLOCK_PLING, 1.0f, 1.0f);

                BingoMainMenu(player);


            }
        }
    }
}
