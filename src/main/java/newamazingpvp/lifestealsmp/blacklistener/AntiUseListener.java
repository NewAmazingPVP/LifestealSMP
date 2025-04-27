package newamazingpvp.lifestealsmp.blacklistener;

import newamazingpvp.lifestealsmp.customitems.utils.GUI;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerItemConsumeEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import static newamazingpvp.lifestealsmp.LifestealSMP.lifestealSmp;
import static newamazingpvp.lifestealsmp.customitems.utils.GUI.openRecipesGUI;
import static org.bukkit.Bukkit.getServer;

public class AntiUseListener implements Listener {

    @EventHandler
    public void onPlayerInteract(PlayerInteractEvent event) {
        if (event.getAction() == Action.RIGHT_CLICK_AIR || event.getAction() == Action.RIGHT_CLICK_BLOCK) {
            ItemStack item = event.getItem();
            if (item == null || item.getType() == Material.AIR) return;

            if (item.getType() == Material.BEETROOT && item.hasItemMeta()) {
                ItemMeta meta = item.getItemMeta();
                if (meta != null && meta.hasDisplayName() && (ChatColor.DARK_RED.toString() + ChatColor.BOLD + "Severed Mob Heart").equals(meta.getDisplayName())) {
                    event.setCancelled(true);
                    return;
                }
            }

            if (item.getType() == Material.ENDER_PEARL && event.getPlayer().getCooldown(Material.ENDER_PEARL) == 0) {
                getServer().getScheduler().runTaskLater(lifestealSmp, () -> event.getPlayer().setCooldown(Material.ENDER_PEARL, 100), 1L);
            }
        }
    }

    @EventHandler
    public void onInventoryClick(InventoryClickEvent event) {
        if (event.getView().getTitle().startsWith(ChatColor.GOLD + "Custom Recipes")) {
            event.setCancelled(true);
            ItemStack clicked = event.getCurrentItem();
            if (clicked == null || clicked.getType() == Material.AIR) return;
            GUI.openRecipeDetailGUI((Player) event.getWhoClicked(), clicked);
            return;
        }

        if (event.getView().getTitle().startsWith(ChatColor.GOLD + "Recipe for ")) {
            event.setCancelled(true);
            ItemStack clicked = event.getCurrentItem();
            if (clicked == null || clicked.getType() == Material.AIR) return;
            ItemMeta meta = clicked.getItemMeta();
            if (meta != null && meta.hasDisplayName() && meta.getDisplayName().startsWith(ChatColor.YELLOW + "Back Button")) {
                openRecipesGUI((Player) event.getWhoClicked());
            }
            return;
        }

        if ((event.getCurrentItem() != null && event.getCurrentItem().getType() == Material.DRAGON_EGG) || event.getView().getTitle().contains("Rune")) {
            event.setCancelled(true);
        }
    }

    @EventHandler
    public void onPlayerConsume(PlayerItemConsumeEvent event) {
        ItemStack item = event.getItem();
        if (item.getType() != Material.BEETROOT || !item.hasItemMeta()) return;

        ItemMeta meta = item.getItemMeta();
        if (meta != null && meta.hasLore()) {
            boolean containsSevered = meta.getLore().stream().anyMatch(line -> line != null && line.contains("Severed"));
            if (containsSevered) {
                event.setCancelled(true);
                event.getPlayer().addPotionEffect(new PotionEffect(PotionEffectType.POISON, 10, 1, false));
            }
        }
    }

    @EventHandler
    public void onBarrierPlace(BlockPlaceEvent event) {
        if (event.getBlockPlaced().getType() == Material.BARRIER) {
            event.setCancelled(true);
            event.getPlayer().sendMessage(ChatColor.RED + "You cannot place this item!");
        }
    }
}
