package newamazingpvp.lifestealsmp.nextSmpBeta;

import org.bukkit.*;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.event.entity.EntityDeathEvent;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.LeatherArmorMeta;

import java.util.ArrayList;
import java.util.List;

import static newamazingpvp.lifestealsmp.LifestealSMP.lifestealSmp;
import static newamazingpvp.lifestealsmp.game.CustomRecipe.corruptedMobSoul;

public class runesDrops implements Listener {

    public static ItemStack witherRune () {
        ItemStack ITEM = new ItemStack(Material.WITHER_SKELETON_SKULL);
        ItemMeta meta = ITEM.getItemMeta();
        meta.addEnchant(Enchantment.DURABILITY, 1, false);
        meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        meta.setDisplayName(ChatColor.LIGHT_PURPLE + "" + ChatColor.MAGIC + "E" + "" + ChatColor.GOLD + "" + ChatColor.BOLD + " Wither Rune " + ChatColor.LIGHT_PURPLE + "" + ChatColor.MAGIC + "E" );
        meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
        List<String> LORE = new ArrayList<>();
        LORE.add(ChatColor.DARK_PURPLE + "" + "[Can be combined to any weapon]");
        LORE.add(" ");
        LORE.add(ChatColor.YELLOW + "" + ChatColor.BOLD + "RUNE ABILITY:");
        LORE.add(ChatColor.LIGHT_PURPLE + "Will give wither effect to");
        LORE.add(ChatColor.LIGHT_PURPLE + "anything you damage! " + ChatColor.DARK_PURPLE + "5sec");
        meta.setLore(LORE);
        ITEM.setItemMeta(meta);
        return ITEM;
    }

    public static ItemStack aquaRune () {
        ItemStack ITEM = new ItemStack(Material.CYAN_DYE);
        ItemMeta meta = ITEM.getItemMeta();
        meta.addEnchant(Enchantment.DURABILITY, 1, false);
        meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        meta.setDisplayName(ChatColor.LIGHT_PURPLE + "" + ChatColor.MAGIC + "E" + "" + ChatColor.AQUA + "" + ChatColor.BOLD + " Aqua Rune " + ChatColor.LIGHT_PURPLE + "" + ChatColor.MAGIC + "E" );
        meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
        List<String> LORE = new ArrayList<>();
        LORE.add(ChatColor.DARK_PURPLE + "" + "[Can be combined to any sword or axe]");
        LORE.add(" ");
        LORE.add(ChatColor.YELLOW + "" + ChatColor.BOLD + "RUNE ABILITY:");
        LORE.add(ChatColor.LIGHT_PURPLE + "Gain dolphins grace");
        LORE.add(ChatColor.LIGHT_PURPLE + "when in water!");
        meta.setLore(LORE);
        ITEM.setItemMeta(meta);
        return ITEM;
    }

    public static ItemStack hellRune () {
        ItemStack ITEM = new ItemStack(Material.RED_DYE);
        ItemMeta meta = ITEM.getItemMeta();
        meta.addEnchant(Enchantment.DURABILITY, 1, false);
        meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        meta.setDisplayName(ChatColor.LIGHT_PURPLE + "" + ChatColor.MAGIC + "E" + "" + ChatColor.DARK_RED + "" + ChatColor.BOLD + " Hell Rune " + ChatColor.LIGHT_PURPLE + "" + ChatColor.MAGIC + "E" );
        meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
        List<String> LORE = new ArrayList<>();
        LORE.add(ChatColor.DARK_PURPLE + "" + "[Can be combined to any sword or axe]");
        LORE.add(" ");
        LORE.add(ChatColor.YELLOW + "" + ChatColor.BOLD + "RUNE ABILITY:");
        LORE.add(ChatColor.LIGHT_PURPLE + "Gain strength 1");
        LORE.add(ChatColor.LIGHT_PURPLE + "when in the nether!");
        meta.setLore(LORE);
        ITEM.setItemMeta(meta);
        return ITEM;
    }

    public static ItemStack trollRune () {
        ItemStack ITEM = new ItemStack(Material.BROWN_DYE);
        ItemMeta meta = ITEM.getItemMeta();
        meta.addEnchant(Enchantment.DURABILITY, 1, false);
        meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        meta.setDisplayName(ChatColor.LIGHT_PURPLE + "" + ChatColor.MAGIC + "E" + "" + ChatColor.DARK_AQUA + "" + ChatColor.BOLD + " Troll Rune " + ChatColor.LIGHT_PURPLE + "" + ChatColor.MAGIC + "E" );
        meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
        List<String> LORE = new ArrayList<>();
        LORE.add(ChatColor.DARK_PURPLE + "" + "[Can be combined leather armor]");
        LORE.add(" ");
        LORE.add(ChatColor.YELLOW + "" + ChatColor.BOLD + "RUNE ABILITY:");
        LORE.add(ChatColor.LIGHT_PURPLE + "When you have leather armor");
        LORE.add(ChatColor.LIGHT_PURPLE + "on, gain resistance 5");
        meta.setLore(LORE);
        ITEM.setItemMeta(meta);
        return ITEM;
    }

    public static ItemStack lightningRune () {
        ItemStack ITEM = new ItemStack(Material.YELLOW_DYE);
        ItemMeta meta = ITEM.getItemMeta();
        meta.addEnchant(Enchantment.DURABILITY, 1, false);
        meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        meta.setDisplayName(ChatColor.LIGHT_PURPLE + "" + ChatColor.MAGIC + "E" + "" + ChatColor.YELLOW + "" + ChatColor.BOLD + " Lightning Rune " + ChatColor.LIGHT_PURPLE + "" + ChatColor.MAGIC + "E" );
        meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
        List<String> LORE = new ArrayList<>();
        LORE.add(ChatColor.DARK_PURPLE + "" + "[Can be combined to any weapon]");
        LORE.add(" ");
        LORE.add(ChatColor.YELLOW + "" + ChatColor.BOLD + "RUNE ABILITY:");
        LORE.add(ChatColor.LIGHT_PURPLE + "Gain a small chance to");
        LORE.add(ChatColor.LIGHT_PURPLE + "strike a player with lightning");
        LORE.add(ChatColor.LIGHT_PURPLE + "dealing" + ChatColor.DARK_RED + " TRUE DAMAGE! 5HP");
        meta.setLore(LORE);
        ITEM.setItemMeta(meta);
        return ITEM;
    }



    @EventHandler
    public void playerKillMob(EntityDeathEvent e) {

        //var
        Player killer = e.getEntity().getKiller();
        Location loc = e.getEntity().getLocation();

        if (killer == null) return;

        if (Math.random() <= 1) {
            e.getDrops().add(witherRune());
            killer.sendMessage(ChatColor.LIGHT_PURPLE + "" + ChatColor.BOLD + "RUNE DROP!" + ChatColor.GOLD + " Wither Rune");
            for (int i = 0; i < 5; i++) {
                Bukkit.getScheduler().runTaskLater(lifestealSmp, () -> killer.playSound(killer.getLocation(), Sound.BLOCK_AMETHYST_CLUSTER_BREAK, 5.0f, 0.0f), 3);
            }
            e.getEntity().getWorld().spawnParticle(Particle.EXPLOSION_LARGE, loc, 100, 0, 0, 0, 0.1);
        }

        if (Math.random() <= 1) {
            e.getDrops().add(aquaRune());
            killer.sendMessage(ChatColor.LIGHT_PURPLE + "" + ChatColor.BOLD + "RUNE DROP!" + ChatColor.GOLD + " Aqua Rune");
            for (int i = 0; i < 5; i++) {
                Bukkit.getScheduler().runTaskLater(lifestealSmp, () -> killer.playSound(killer.getLocation(), Sound.BLOCK_AMETHYST_CLUSTER_BREAK, 5.0f, 0.0f), 3);
            }
            e.getEntity().getWorld().spawnParticle(Particle.EXPLOSION_LARGE, loc, 100, 0, 0, 0, 0.1);
        }

        if (Math.random() <= 1) {
            e.getDrops().add(hellRune());
            killer.sendMessage(ChatColor.LIGHT_PURPLE + "" + ChatColor.BOLD + "RUNE DROP!" + ChatColor.GOLD + " Hell Rune");
            for (int i = 0; i < 5; i++) {
                Bukkit.getScheduler().runTaskLater(lifestealSmp, () -> killer.playSound(killer.getLocation(), Sound.BLOCK_AMETHYST_CLUSTER_BREAK, 5.0f, 0.0f), 3);
            }
            e.getEntity().getWorld().spawnParticle(Particle.EXPLOSION_LARGE, loc, 100, 0, 0, 0, 0.1);
        }

        if (Math.random() <= 1) {
            e.getDrops().add(trollRune());
            killer.sendMessage(ChatColor.LIGHT_PURPLE + "" + ChatColor.BOLD + "RUNE DROP!" + ChatColor.GOLD + " Troll Rune");
            for (int i = 0; i < 5; i++) {
                Bukkit.getScheduler().runTaskLater(lifestealSmp, () -> killer.playSound(killer.getLocation(), Sound.BLOCK_AMETHYST_CLUSTER_BREAK, 5.0f, 0.0f), 3);
            }
            e.getEntity().getWorld().spawnParticle(Particle.EXPLOSION_LARGE, loc, 100, 0, 0, 0, 0.1);
        }

        if (Math.random() <= 1) {
            e.getDrops().add(lightningRune());
            killer.sendMessage(ChatColor.LIGHT_PURPLE + "" + ChatColor.BOLD + "RUNE DROP!" + ChatColor.GOLD + " Lightning Rune");
            for (int i = 0; i < 5; i++) {
                Bukkit.getScheduler().runTaskLater(lifestealSmp, () -> killer.playSound(killer.getLocation(), Sound.BLOCK_AMETHYST_CLUSTER_BREAK, 5.0f, 0.0f), 3);
            }
            e.getEntity().getWorld().spawnParticle(Particle.EXPLOSION_LARGE, loc, 100, 0, 0, 0, 0.1);
        }
    }
}
