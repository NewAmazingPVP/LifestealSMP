package newamazingpvp.lifestealsmp.blacklistener;

import newamazingpvp.lifestealsmp.customitems.utils.GUI;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerItemConsumeEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import static newamazingpvp.lifestealsmp.LifestealSMP.lifestealSmp;
import static newamazingpvp.lifestealsmp.customitems.utils.GUI.openRecipesGUI;
import static newamazingpvp.lifestealsmp.utility.Utils.updateLore;
import static org.bukkit.Bukkit.getServer;

public class AntiUseListener implements Listener {

    @EventHandler
    public void onPlayerInteract(PlayerInteractEvent event) {
        if (event.getAction() == Action.RIGHT_CLICK_AIR || event.getAction() == Action.RIGHT_CLICK_BLOCK) {
            ItemStack item = event.getItem();
            if (item != null && item.getType() == Material.BEETROOT && item.hasItemMeta() && item.getItemMeta().hasDisplayName() && item.getItemMeta().getDisplayName().equals(ChatColor.DARK_RED + "" + ChatColor.BOLD + "Severed Mob Heart")) {
                event.setCancelled(true);
            }
            if (item != null && item.getType() == Material.ENDER_PEARL) {
                if (event.getPlayer().getCooldown(Material.ENDER_PEARL) == 0) {
                    getServer().getScheduler().runTaskLater(lifestealSmp, () -> event.getPlayer().setCooldown(Material.ENDER_PEARL, 100), 1);
                }
            }
        }

        //updateLore(event.getPlayer());
    }


    @EventHandler
    public void onInventoryClick(InventoryClickEvent event) {
        if (event.getView().getTitle().startsWith(ChatColor.GOLD + "Custom Recipes")) {
            event.setCancelled(true);

            if (event.getCurrentItem() == null || event.getCurrentItem().getType() == Material.AIR) return;

            Player player = (Player) event.getWhoClicked();
            ItemStack clickedItem = event.getCurrentItem();
            GUI.openRecipeDetailGUI(player, clickedItem);
        }
        if (event.getView().getTitle().startsWith(ChatColor.GOLD + "Recipe for ")) {
            event.setCancelled(true);
            if (event.getCurrentItem() == null || event.getCurrentItem().getType() == Material.AIR) return;

            Player player = (Player) event.getWhoClicked();
            ItemStack clickedItem = event.getCurrentItem();

            if (clickedItem.getDisplayName().startsWith(ChatColor.YELLOW + "Back Button")) {
                openRecipesGUI(player);
            }
        }
        if (event.getCurrentItem() != null && event.getCurrentItem().getType() == Material.DRAGON_EGG) {
            event.setCancelled(true);
        }
    }

    @EventHandler
    public void onPlayerConsume(PlayerItemConsumeEvent event) {
        ItemStack item = event.getItem();
        if (item.getType() == Material.BEETROOT && item.hasItemMeta() && item.getItemMeta().hasDisplayName() && item.getItemMeta().getLore().contains("Severed")) {

            event.setCancelled(true);
            PotionEffect potion = new PotionEffect(PotionEffectType.POISON, 10, 1, false);
            event.getPlayer().addPotionEffect(potion);

        }
    }
}
