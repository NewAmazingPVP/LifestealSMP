package newamazingpvp.lifestealsmp.runes;

import org.bukkit.*;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDeathEvent;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.potion.PotionEffect;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import static newamazingpvp.lifestealsmp.LifestealSMP.lifestealSmp;

public abstract class Rune<T extends org.bukkit.event.Event> implements Listener {

    private final ItemStack item;
    private final double dropChance;
    private final EntityType dropFromMob;
    private final Class<T> eventType;

    public Rune(String displayName, List<String> lore, Material material, double dropChance, EntityType dropFromMob, Class<T> eventType) {
        this.item = createRune(displayName, lore, material);
        this.dropChance = dropChance;
        this.dropFromMob = dropFromMob;
        this.eventType = eventType;
    }

    private ItemStack createRune(String displayName, List<String> lore, Material material) {
        ItemStack item = new ItemStack(material);
        ItemMeta meta = item.getItemMeta();
        if (meta == null) return item;

        meta.addEnchant(Enchantment.DURABILITY, 1, false);
        meta.addItemFlags(ItemFlag.HIDE_ENCHANTS, ItemFlag.HIDE_ATTRIBUTES);
        meta.setDisplayName(displayName);
        meta.setLore(lore);

        item.setItemMeta(meta);
        return item;
    }

    public ItemStack getItem() {
        return item;
    }

    public double getDropChance() {
        return dropChance;
    }

    public EntityType getDropFromMob() {
        return dropFromMob;
    }

    public Class<T> getEventType() {
        return eventType;
    }

    @EventHandler
    public void onEntityDeath(EntityDeathEvent event) {
        Player killer = event.getEntity().getKiller();
        if (killer == null || event.getEntity().getType() != dropFromMob) return;

        if (new Random().nextDouble() <= dropChance) {
            event.getDrops().add(item);
            killer.sendMessage(ChatColor.LIGHT_PURPLE + "" + ChatColor.BOLD + "RUNE DROP!" + ChatColor.GOLD + " " + item.getItemMeta().getDisplayName());

            for (int i = 0; i < 5; i++) {
                Bukkit.getScheduler().runTaskLater(lifestealSmp, () -> killer.playSound(killer.getLocation(), Sound.BLOCK_AMETHYST_CLUSTER_BREAK, 5.0f, 0.0f), 3 * i);
            }
            event.getEntity().getWorld().spawnParticle(Particle.EXPLOSION_LARGE, event.getEntity().getLocation(), 100, 0, 0, 0, 0.1);
        }
    }

    @EventHandler
    public abstract void applyEffect(T event);

    protected void addPotionEffect(Player player, PotionEffect effect) {
        player.addPotionEffect(effect);
    }

    protected boolean isRuneInInventory(Player player) {
        for (ItemStack item : player.getInventory().getContents()) {
            if (item == null) continue;
            ItemMeta meta = item.getItemMeta();
            if (meta == null || !meta.hasDisplayName()) continue;

            if (meta.getDisplayName().equals(this.item.getItemMeta().getDisplayName())) {
                return true;
            }
        }
        return false;
    }
}
