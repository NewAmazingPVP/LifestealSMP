package newamazingpvp.lifestealsmp.listener;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityPickupItemEvent;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryDragEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.scheduler.BukkitScheduler;

import static newamazingpvp.lifestealsmp.LifestealSMP.lifestealSmp;

public class TotemLimiter implements Listener {

    private static final Material TOTEM = Material.TOTEM_OF_UNDYING;
    private static final int MAX_TOTEMS = 5;
    private final BukkitScheduler scheduler = Bukkit.getScheduler();

    @EventHandler(ignoreCancelled = true)
    public void onPickup(EntityPickupItemEvent e) {
        if (!(e.getEntity() instanceof Player)) return;
        if (e.getItem().getItemStack().getType() != TOTEM) return;
        scheduler.runTask(lifestealSmp, () -> enforce((Player)e.getEntity()));
    }

    @EventHandler(ignoreCancelled = true)
    public void onClick(InventoryClickEvent e) {
        if (!(e.getWhoClicked() instanceof Player)) return;
        ItemStack cur = e.getCursor();
        if (cur != null && cur.getType() == TOTEM) {
            scheduler.runTask(lifestealSmp, () -> enforce((Player)e.getWhoClicked()));
        }
    }

    @EventHandler(ignoreCancelled = true)
    public void onDrag(InventoryDragEvent e) {
        if (!(e.getWhoClicked() instanceof Player)) return;
        if (e.getNewItems().values().stream().anyMatch(i -> i.getType() == TOTEM)) {
            scheduler.runTask(lifestealSmp, () -> enforce((Player)e.getWhoClicked()));
        }
    }

    private void enforce(Player p) {
        int total = p.getInventory()
                .all(TOTEM)
                .values()
                .stream()
                .mapToInt(ItemStack::getAmount)
                .sum();
        if (total <= MAX_TOTEMS) return;

        int extras = total - MAX_TOTEMS;
        p.sendMessage(ChatColor.RED +
                "Too many totems—removing " + extras + " extras.");
        p.getInventory().removeItem(new ItemStack(TOTEM, extras));

        World w = p.getWorld();
        Location loc = p.getLocation();
        for (int i = 0; i < extras; i++) {
            w.dropItemNaturally(loc, new ItemStack(TOTEM, 1));
        }
    }
}
