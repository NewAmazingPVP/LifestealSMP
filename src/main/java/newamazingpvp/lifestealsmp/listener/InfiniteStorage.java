package newamazingpvp.lifestealsmp.listener;

import org.bukkit.block.ShulkerBox;
import org.bukkit.entity.Entity;
import org.bukkit.entity.HumanEntity;
import org.bukkit.entity.Shulker;
import org.bukkit.entity.ShulkerBullet;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.*;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.scheduler.BukkitRunnable;

import java.util.Arrays;

import static newamazingpvp.lifestealsmp.LifestealSMP.lifestealSmp;
import static org.bukkit.Bukkit.getServer;

public class InfiniteStorage implements Listener {
    @EventHandler
    public void InventoryClickEvent(InventoryClickEvent event) {
        Inventory inv = event.getClickedInventory();
        Inventory inv2 = event.getInventory();
        ItemStack item = event.getCurrentItem();
        ItemStack itemHolding = event.getCursor();
        boolean shift = event.isShiftClick();

        if (inv == null || inv2 == null) return;

        if (inv.getType().toString().contains("SHULKER") && itemHolding.getType().toString().contains("SHULKER")) {

            event.setCancelled(true);
            if (item.getType().toString().equals("AIR")) {
                event.setCurrentItem(itemHolding);
                itemHolding.setAmount(0);
            } else {
                event.setCurrentItem(itemHolding);
                itemHolding.setAmount(0);
                event.setCursor(item);
            }
        }

        if (inv2.getType().toString().equals(item.getType().toString()) & shift) {
            if (inv == inv2) return;
            event.setCancelled(true);
            if (inv2.firstEmpty() != -1) {
                inv2.addItem(item);
                inv.removeItem(item);
            }
        }
    }

    @EventHandler
    public void onInventoryMoveItem(InventoryMoveItemEvent event) {
        if (event.getDestination().getType().toString().contains("SHULKER") && event.getItem().getType().toString().contains("SHULKER")) {

            new BukkitRunnable() {
                @Override
                public void run() {
                    event.getDestination().addItem(event.getItem());
                    event.getSource().removeItem(event.getItem());
                    event.setCancelled(true);
                }
            }.runTaskLater(lifestealSmp, 1);
        }
    }

    /*@EventHandler
    public void onInventoryOpen(InventoryOpenEvent event)
    {
        HumanEntity player = event.getPlayer();
        Inventory oldInv = event.getInventory();
        if (oldInv.getType() == InventoryType.ENDER_CHEST)
        {
            event.getPlayer().getEnderChest().close();
            Inventory newInv = getServer().createInventory(player, 54,
                    InventoryType.ENDER_CHEST.getDefaultTitle());
            if (lifestealSmp.getConfig().isSet("enderchests." + player.getName())) {
                newInv.setContents(
                        (ItemStack[])lifestealSmp.getConfig().getList("enderchests." + player.getName()).toArray(
                                new ItemStack[0]));
            } else {
                newInv.setContents(player.getEnderChest().getContents());
            }
            player.openInventory(newInv);
        }
    }

    @EventHandler
    public void onInventoryClose(InventoryCloseEvent event) {
        Inventory inventory = event.getInventory();
        if (inventory.getSize() == 54) {
            if (inventory.getType().getDefaultTitle().equals(InventoryType.ENDER_CHEST.getDefaultTitle())) {
                lifestealSmp.getConfig().set("enderchests." + event.getPlayer().getName(),
                        Arrays.asList(inventory.getContents()));
                lifestealSmp.saveConfig();
            }
        }
    }*/
}
