package newamazingpvp.lifestealsmp.customitems.item;

import newamazingpvp.lifestealsmp.utility.CooldownManager;
import org.bukkit.*;
import org.bukkit.entity.Player;
import org.bukkit.event.Cancellable;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.PlayerDropItemEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.event.server.PluginDisableEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.scheduler.BukkitRunnable;

import java.util.HashMap;
import java.util.Map;

import static newamazingpvp.lifestealsmp.LifestealSMP.lifestealSmp;

public class SomberCrystal implements Listener {

    private static final Map<String, CooldownManager> somberCooldowns = new HashMap<>();
    private static final double SOMBER_MAX_TIME_SECONDS = 120;

    public SomberCrystal() {
        new BukkitRunnable() {
            @Override
            public void run() {
                for (Player player : Bukkit.getOnlinePlayers()) {
                    if (isCooldownExpired(player)) {
                        addTotems(player);
                    } else {
                        removeTotems(player);
                    }
                }
            }
        }.runTaskTimer(lifestealSmp, 0L, 20L);
    }

    @EventHandler
    public void playerHitPlayer(EntityDamageByEntityEvent e) {
        if (!(e.getDamager() instanceof Player) || !(e.getEntity() instanceof Player)) return;

        Player player = (Player) e.getDamager();
        Player damagedPlayer = (Player) e.getEntity();
        ItemStack itemInHand = player.getInventory().getItemInMainHand();
        ItemMeta meta = itemInHand.getItemMeta();

        if (meta != null && meta.hasLore() && meta.getLore().toString().contains("Disables totems of undying on someone for 2min")) {
            setSomberTimer(damagedPlayer);
            Location loc = player.getLocation();
            for (Player onlinePlayer : Bukkit.getOnlinePlayers()) {
                onlinePlayer.playSound(loc, Sound.BLOCK_GLASS_BREAK, 2.0f, 1.0f);
                onlinePlayer.playSound(loc, Sound.BLOCK_SCULK_SHRIEKER_SHRIEK, 2.0f, 0.0f);
            }

            itemInHand.setAmount(itemInHand.getAmount() - 1);
            player.getInventory().setItemInMainHand(itemInHand.getAmount() > 0 ? itemInHand : null);
        }
    }

    @EventHandler
    public void onPlayerRightClick(PlayerInteractEvent e) {
        handleDisabledItemInteraction(e.getPlayer(), e.getItem(), e);
    }

    @EventHandler
    public void onPlayerDropItem(PlayerDropItemEvent e) {
        handleDisabledItemInteraction(e.getPlayer(), e.getItemDrop().getItemStack(), e);
    }

    @EventHandler
    public void onInventoryClick(InventoryClickEvent e) {
        handleDisabledItemInteraction((Player) e.getWhoClicked(), e.getCurrentItem(), e);
    }

    @EventHandler
    public void onPlayerQuit(PlayerQuitEvent e) {
        Player player = e.getPlayer();
        if (!isCooldownExpired(player)) {
            removeTotems(player);
        }
    }

    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent e) {
        Player player = e.getPlayer();
        if (!isCooldownExpired(player)) {
            removeTotems(player);
        } else {
            addTotems(player);
        }
    }

    @EventHandler
    public void onPluginDisable(PluginDisableEvent e) {
        for (Player player : Bukkit.getOnlinePlayers()) {
            if (!isCooldownExpired(player)) {
                removeTotems(player);
            }
        }
        somberCooldowns.clear();
    }

    private void handleDisabledItemInteraction(Player player, ItemStack itemInHand, Cancellable e) {
        if (itemInHand != null && itemInHand.getType() == Material.BARRIER && somberCooldowns.get(player.getName()) != null && somberCooldowns.get(player.getName()).isOnCooldown()) {
            player.playSound(player.getLocation(), Sound.BLOCK_SCULK_SHRIEKER_SHRIEK, 1.0f, 2.0f);
            e.setCancelled(true);
            player.sendMessage(ChatColor.RED + "Totem disabled for " + getRemainingCooldownTime(player) + " seconds.");
        }
    }

    private void removeTotems(Player player) {
        updateInventoryItems(player, Material.TOTEM_OF_UNDYING, new ItemStack(Material.BARRIER));
    }

    private void addTotems(Player player) {
        updateInventoryItems(player, Material.BARRIER, new ItemStack(Material.TOTEM_OF_UNDYING));
    }

    private void updateInventoryItems(Player player, Material targetMaterial, ItemStack replacementItem) {
        for (int i = 0; i < player.getInventory().getSize(); i++) {
            ItemStack item = player.getInventory().getItem(i);
            if (item != null && item.getType() == targetMaterial) {
                player.getInventory().setItem(i, replacementItem);
                //this is to prevent too much performance loss
                break;
            }
        }
    }

    private boolean isCooldownExpired(Player player) {
        CooldownManager cooldownManager = somberCooldowns.get(player.getName());
        return cooldownManager == null || !cooldownManager.isOnCooldown();
    }

    public static void setSomberTimer(Player player) {
        CooldownManager cooldownManager = new CooldownManager(SOMBER_MAX_TIME_SECONDS);
        somberCooldowns.put(player.getName(), cooldownManager);
    }

    private int getRemainingCooldownTime(Player player) {
        CooldownManager cooldownManager = somberCooldowns.get(player.getName());
        return cooldownManager != null ? cooldownManager.getRemainingSeconds() : 0;
    }

    private static ItemStack totemDisabledItem() {
        ItemStack item = new ItemStack(Material.BARRIER);
        //this is to prevent too much performance loss
        /*ItemMeta meta = item.getItemMeta();
        if (meta != null) {
            meta.addEnchant(Enchantment.UNBREAKING, 1, false);
            meta.addItemFlags(ItemFlag.HIDE_ENCHANTS, ItemFlag.HIDE_ATTRIBUTES, ItemFlag.HIDE_UNBREAKABLE);
            meta.setDisplayName(ChatColor.DARK_RED + "" + ChatColor.BOLD + "Disabled For 2min");
            item.setItemMeta(meta);
        }*/
        return item;
    }
}
