package newamazingpvp.lifestealsmp.runes;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.damage.DamageType;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.entity.EntityDeathEvent;
import org.bukkit.event.player.PlayerItemDamageEvent;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

import static newamazingpvp.lifestealsmp.customitems.utils.ItemStacks.lifestealStick;
import static newamazingpvp.lifestealsmp.discord.DiscordBot.sendDiscordEmbedTitle;
import static newamazingpvp.lifestealsmp.utility.TimeManager.END_OPEN_TIME;
import static newamazingpvp.lifestealsmp.utility.TimeManager.isTimePassed;

public class DragonRune implements Listener {
    public boolean isFlagged = false;

    @EventHandler
    public void onDragonDeath(EntityDeathEvent event) {
        if (event.getEntity().getType() == EntityType.ENDER_DRAGON) {
            if (!isTimePassed(END_OPEN_TIME.plusHours(1)) && !isFlagged) {
                Bukkit.broadcastMessage(ChatColor.GOLD + "Lifesteal Stick has been dropped for defeating the Ender Dragon!");
                Bukkit.broadcastMessage(ChatColor.translateAlternateColorCodes('&', "&x&F&F&6&8&6&8&lT&x&F&F&6&9&6&7&lh&x&F&F&6&9&6&7&le &x&F&E&6&A&6&5&lo&x&F&E&6&B&6&5&ln&x&F&E&6&C&6&4&le &x&F&D&6&D&6&2&la&x&F&D&6&D&6&2&ln&x&F&D&6&E&6&1&ld &x&F&C&6&F&6&0&lo&x&F&C&7&0&5&F&ln&x&F&C&7&0&5&E&ll&x&F&C&7&1&5&E&ly &x&F&B&7&2&5&C&lD&x&F&B&7&3&5&B&lr&x&F&B&7&4&5&B&la&x&F&B&7&4&5&A&lg&x&F&A&7&5&5&9&lo&x&F&A&7&5&5&9&ln &x&F&A&7&7&5&7&lR&x&F&9&7&7&5&7&lu&x&F&9&7&8&5&6&ln&x&F&9&7&8&5&5&le &x&F&9&7&A&5&4&lh&x&F&8&7&A&5&3&la&x&F&8&7&B&5&2&ls &x&F&8&7&C&5&1&lb&x&F&7&7&D&5&0&le&x&F&7&7&D&5&0&le&x&F&7&7&E&4&F&ln &x&F&7&7&F&4&E&ld&x&F&6&8&0&4&D&lr&x&F&6&8&0&4&C&lo&x&F&6&8&1&4&B&lp&x&F&6&8&1&4&B&lp&x&F&5&8&2&4&A&le&x&F&5&8&3&4&9&ld &x&F&5&8&4&4&8&lf&x&F&4&8&4&4&7&lo&x&F&4&8&5&4&7&lr &x&F&4&8&6&4&5&ld&x&F&4&8&7&4&4&le&x&F&3&8&7&4&4&lf&x&F&3&8&8&4&3&le&x&F&3&8&9&4&2&la&x&F&3&8&9&4&2&lt&x&F&2&8&A&4&1&li&x&F&2&8&B&4&0&ln&x&F&2&8&B&4&0&lg &x&F&2&8&C&3&E&lt&x&F&1&8&D&3&D&lh&x&F&1&8&E&3&D&le &x&F&1&8&F&3&B&lE&x&F&0&8&F&3&B&ln&x&F&0&9&0&3&A&ld&x&F&0&9&1&3&9&le&x&F&0&9&1&3&9&lr &x&E&F&9&2&3&7&lD&x&E&F&9&3&3&6&lr&x&E&F&9&4&3&6&la&x&E&F&9&4&3&5&lg&x&E&E&9&5&3&4&lo&x&E&E&9&5&3&4&ln&x&E&E&9&6&3&3&l!"));
                event.getDrops().add(lifestealStick());
                event.getDrops().add(dragonRune());
                sendDiscordEmbedTitle("Lifesteal Stick has been dropped for defeating the Ender Dragon!", Color.GREEN, "");
                sendDiscordEmbedTitle("The one and only Dragon Rune has been dropped for defeating the Ender Dragon!", Color.MAGENTA, "");
                isFlagged = true;
            }
        }
    }

    @EventHandler
    public void onEntityDamage(EntityDamageEvent event) {
        if (!(event.getEntity() instanceof Player p)) return;
        if (event.getDamageSource().getDamageType() == DamageType.FALL) {
            if (p.getInventory().contains(dragonRune())) {
                event.setCancelled(true);
            }
        }
    }

    @EventHandler
    public void onElytraDamage(PlayerItemDamageEvent event) {
        if (event.getItem().getType() == Material.ELYTRA) {
            if (event.getPlayer().getInventory().contains(dragonRune())) {
                event.setCancelled(true);
            }
        }
    }

    public static ItemStack dragonRune() {
        ItemStack rune = new ItemStack(Material.AMETHYST_SHARD);
        ItemMeta meta = rune.getItemMeta();
        meta.addEnchant(Enchantment.UNBREAKING, 1, false);
        meta.addItemFlags(ItemFlag.HIDE_ENCHANTS, ItemFlag.HIDE_ATTRIBUTES, ItemFlag.HIDE_UNBREAKABLE);
        meta.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&x&F&B&0&8&7&4&lD&x&F&8&1&9&8&2&lr&x&F&5&2&9&8&F&la&x&F&3&3&A&9&D&lg&x&F&0&4&A&A&B&lo&x&E&D&5&B&B&9&ln &x&E&7&7&C&D&4&lR&x&E&5&8&C&E&2&lu&x&E&2&9&D&E&F&ln&x&D&F&A&D&F&D&le"));
        List<String> lore = new ArrayList<>();
        lore.add(ChatColor.translateAlternateColorCodes('&', "&x&C&6&0&8&F&BN&x&C&A&1&5&F&9o &x&D&3&2&E&F&5F&x&D&7&3&B&F&3a&x&D&B&4&7&F&1l&x&D&F&5&4&E&Fl &x&E&8&6&E&E&BD&x&E&C&7&A&E&9a&x&F&0&8&7&E&7m&x&F&5&9&4&E&5a&x&F&9&A&0&E&3g&x&F&D&A&D&E&1e"));
        lore.add(ChatColor.translateAlternateColorCodes('&', "&x&4&6&0&8&F&BI&x&4&D&0&F&F&Bn&x&5&4&1&5&F&Bf&x&5&B&1&C&F&Bi&x&6&2&2&2&F&Bn&x&6&9&2&9&F&Bi&x&7&0&3&0&F&Bt&x&7&7&3&6&F&Ce &x&8&5&4&3&F&CE&x&8&C&4&A&F&Cl&x&9&3&5&1&F&Cy&x&9&A&5&7&F&Ct&x&A&1&5&E&F&Cr&x&A&8&6&4&F&Ca &x&B&6&7&2&F&CD&x&B&D&7&8&F&Cu&x&C&4&7&F&F&Cr&x&C&B&8&5&F&Da&x&D&2&8&C&F&Db&x&D&9&9&3&F&Di&x&E&0&9&9&F&Dl&x&E&7&A&0&F&Di&x&E&E&A&6&F&Dt&x&F&5&A&D&F&Dy"));
        meta.setLore(lore);
        rune.setItemMeta(meta);
        return rune;
    }
}
