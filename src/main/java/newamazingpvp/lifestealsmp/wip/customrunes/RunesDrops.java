package newamazingpvp.lifestealsmp.wip.customrunes;

import org.bukkit.*;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDeathEvent;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;
import java.util.List;

import static newamazingpvp.lifestealsmp.LifestealSMP.lifestealSmp;

public class RunesDrops implements Listener {

    public static ItemStack witherRune() {
        ItemStack ITEM = new ItemStack(Material.WITHER_SKELETON_SKULL);
        ItemMeta meta = ITEM.getItemMeta();
        meta.addEnchant(Enchantment.UNBREAKING, 1, false);
        meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        meta.setDisplayName(ChatColor.LIGHT_PURPLE + "" + ChatColor.MAGIC + "E" + ChatColor.GOLD + ChatColor.BOLD + " Wither Rune " + ChatColor.LIGHT_PURPLE + ChatColor.MAGIC + "E");
        meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
        List<String> LORE = new ArrayList<>();
        LORE.add(ChatColor.DARK_PURPLE + "[Item just needs to be in your inventory]");
        LORE.add(ChatColor.YELLOW + "[Rare chance to drop from withers]");
        LORE.add(" ");
        LORE.add(ChatColor.YELLOW + "" + ChatColor.BOLD + "WITHER RUNE ABILITY:");
        LORE.add(ChatColor.LIGHT_PURPLE + "Will give wither effect to");
        LORE.add(ChatColor.LIGHT_PURPLE + "anything you damage! " + ChatColor.DARK_PURPLE + "5sec");
        meta.setLore(LORE);
        ITEM.setItemMeta(meta);
        return ITEM;
    }

    public static ItemStack aquaRune() {
        ItemStack ITEM = new ItemStack(Material.CYAN_DYE);
        ItemMeta meta = ITEM.getItemMeta();
        meta.addEnchant(Enchantment.UNBREAKING, 1, false);
        meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        meta.setDisplayName(ChatColor.LIGHT_PURPLE + "" + ChatColor.MAGIC + "E" + ChatColor.AQUA + ChatColor.BOLD + " Aqua Rune " + ChatColor.LIGHT_PURPLE + ChatColor.MAGIC + "E");
        meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
        List<String> LORE = new ArrayList<>();
        LORE.add(ChatColor.DARK_PURPLE + "[Item just needs to be in your inventory]");
        LORE.add(ChatColor.YELLOW + "[Vary rare chance from any mob]");
        LORE.add(" ");
        LORE.add(ChatColor.YELLOW + "" + ChatColor.BOLD + "AQUA RUNE ABILITY:");
        LORE.add(ChatColor.LIGHT_PURPLE + "Gain dolphins grace 5");
        LORE.add(ChatColor.LIGHT_PURPLE + "when in water!");
        meta.setLore(LORE);
        ITEM.setItemMeta(meta);
        return ITEM;
    }

    public static ItemStack hellRune() {
        ItemStack ITEM = new ItemStack(Material.RED_DYE);
        ItemMeta meta = ITEM.getItemMeta();
        meta.addEnchant(Enchantment.UNBREAKING, 1, false);
        meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        meta.setDisplayName(ChatColor.LIGHT_PURPLE + "" + ChatColor.MAGIC + "E" + ChatColor.DARK_RED + ChatColor.BOLD + " Hell Rune " + ChatColor.LIGHT_PURPLE + ChatColor.MAGIC + "E");
        meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
        List<String> LORE = new ArrayList<>();
        LORE.add(ChatColor.DARK_PURPLE + "[Item just needs to be in your inventory]");
        LORE.add(ChatColor.YELLOW + "[Rare chance to drop from a piglin brute]");
        LORE.add(" ");
        LORE.add(ChatColor.YELLOW + "" + ChatColor.BOLD + "HELL RUNE ABILITY:");
        LORE.add(ChatColor.LIGHT_PURPLE + "Gain strength 1 while ");
        LORE.add(ChatColor.LIGHT_PURPLE + "attacking in the nether!");
        meta.setLore(LORE);
        ITEM.setItemMeta(meta);
        return ITEM;
    }

    public static ItemStack trollRune() {
        ItemStack ITEM = new ItemStack(Material.BROWN_DYE);
        ItemMeta meta = ITEM.getItemMeta();
        meta.addEnchant(Enchantment.UNBREAKING, 1, false);
        meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        meta.setDisplayName(ChatColor.LIGHT_PURPLE + "" + ChatColor.MAGIC + "E" + ChatColor.DARK_AQUA + ChatColor.BOLD + " Troll Rune " + ChatColor.LIGHT_PURPLE + ChatColor.MAGIC + "E");
        meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
        List<String> LORE = new ArrayList<>();
        LORE.add(ChatColor.DARK_PURPLE + "[Item just needs to be in your inventory]");
        LORE.add(ChatColor.YELLOW + "[Obtained rarely from killing a villager]");
        LORE.add(" ");
        LORE.add(ChatColor.YELLOW + "" + ChatColor.BOLD + "TROLL RUNE ABILITY:");
        LORE.add(ChatColor.LIGHT_PURPLE + "When you have leather armor");
        LORE.add(ChatColor.LIGHT_PURPLE + "on, gain resistance 5.");
        meta.setLore(LORE);
        ITEM.setItemMeta(meta);
        return ITEM;
    }

    public static ItemStack lightningRune() {
        ItemStack ITEM = new ItemStack(Material.YELLOW_DYE);
        ItemMeta meta = ITEM.getItemMeta();
        meta.addEnchant(Enchantment.UNBREAKING, 1, false);
        meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        meta.setDisplayName(ChatColor.LIGHT_PURPLE + "" + ChatColor.MAGIC + "E" + ChatColor.YELLOW + ChatColor.BOLD + " Lightning Rune " + ChatColor.LIGHT_PURPLE + ChatColor.MAGIC + "E");
        meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
        List<String> LORE = new ArrayList<>();
        LORE.add(ChatColor.DARK_PURPLE + "[Item just needs to be in your inventory]");
        LORE.add(ChatColor.YELLOW + "[Obtained from killing a charged creeper]");
        LORE.add(" ");
        LORE.add(ChatColor.YELLOW + "" + ChatColor.BOLD + "LIGHTNING RUNE ABILITY:");
        LORE.add(ChatColor.LIGHT_PURPLE + "Gain a small chance to");
        LORE.add(ChatColor.LIGHT_PURPLE + "strike a player with lightning");
        LORE.add(ChatColor.LIGHT_PURPLE + "dealing" + ChatColor.DARK_RED + " TRUE DAMAGE! 5HP");
        meta.setLore(LORE);
        ITEM.setItemMeta(meta);
        return ITEM;
    }

    public static ItemStack darkRune() {
        ItemStack ITEM = new ItemStack(Material.AMETHYST_CLUSTER);
        ItemMeta meta = ITEM.getItemMeta();
        meta.addEnchant(Enchantment.UNBREAKING, 1, false);
        meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        meta.setDisplayName(ChatColor.LIGHT_PURPLE + "" + ChatColor.MAGIC + "E" + ChatColor.BLACK + ChatColor.BOLD + " Dark Rune " + ChatColor.LIGHT_PURPLE + ChatColor.MAGIC + "E");
        meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
        List<String> LORE = new ArrayList<>();
        LORE.add(ChatColor.DARK_PURPLE + "[Item just needs to be in your inventory]");
        LORE.add(ChatColor.YELLOW + "[1% chance to drop from the warden]");
        LORE.add(" ");
        LORE.add(ChatColor.YELLOW + "" + ChatColor.BOLD + "DARK RUNE ABILITY:");
        LORE.add(ChatColor.LIGHT_PURPLE + "Gain a small chance to");
        LORE.add(ChatColor.LIGHT_PURPLE + "strike a player with lightning");
        LORE.add(ChatColor.LIGHT_PURPLE + "dealing" + ChatColor.DARK_RED + " TRUE DAMAGE! 5HP");
        meta.setLore(LORE);
        ITEM.setItemMeta(meta);
        return ITEM;
    }

    public static ItemStack bloodRune() {
        ItemStack ITEM = new ItemStack(Material.BEETROOT_SOUP);
        ItemMeta meta = ITEM.getItemMeta();
        meta.addEnchant(Enchantment.UNBREAKING, 1, false);
        meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        meta.setDisplayName(ChatColor.LIGHT_PURPLE + "" + ChatColor.MAGIC + "E" + ChatColor.DARK_RED + ChatColor.BOLD + " Blood Rune " + ChatColor.LIGHT_PURPLE + ChatColor.MAGIC + "E");
        meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
        List<String> LORE = new ArrayList<>();
        LORE.add(ChatColor.DARK_PURPLE + "[Item just needs to be in your inventory]");
        LORE.add(ChatColor.YELLOW + "[Can drop from elder guardians]");
        LORE.add(" ");
        LORE.add(ChatColor.YELLOW + "" + ChatColor.BOLD + "BLOOD RUNE ABILITY:");
        LORE.add(ChatColor.LIGHT_PURPLE + "When you kill any mob,");
        LORE.add(ChatColor.LIGHT_PURPLE + "you gain strength 5 for 5 sec! ");
        meta.setLore(LORE);
        ITEM.setItemMeta(meta);
        return ITEM;
    }

    public static ItemStack airRune() {
        ItemStack ITEM = new ItemStack(Material.END_PORTAL_FRAME);
        ItemMeta meta = ITEM.getItemMeta();
        meta.addEnchant(Enchantment.UNBREAKING, 1, false);
        meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        meta.setDisplayName(ChatColor.LIGHT_PURPLE + "" + ChatColor.MAGIC + "E" + ChatColor.WHITE + ChatColor.BOLD + " Air Rune " + ChatColor.LIGHT_PURPLE + ChatColor.MAGIC + "E");
        meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
        List<String> LORE = new ArrayList<>();
        LORE.add(ChatColor.DARK_PURPLE + "[Item just needs to be in your inventory]");
        LORE.add(ChatColor.YELLOW + "[Very rare chance to drop from shulkers]");
        LORE.add(" ");
        LORE.add(ChatColor.YELLOW + "" + ChatColor.BOLD + "AIR RUNE ABILITY:");
        LORE.add(ChatColor.LIGHT_PURPLE + "Lets you double jump!");
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
            //e.getEntity().getWorld().spawnParticle(Particle.EXPLOSION_LARGE, loc, 100, 0, 0, 0, 0.1);
        }

        if (Math.random() <= 1) {
            e.getDrops().add(aquaRune());
            killer.sendMessage(ChatColor.LIGHT_PURPLE + "" + ChatColor.BOLD + "RUNE DROP!" + ChatColor.GOLD + " Aqua Rune");
            for (int i = 0; i < 5; i++) {
                Bukkit.getScheduler().runTaskLater(lifestealSmp, () -> killer.playSound(killer.getLocation(), Sound.BLOCK_AMETHYST_CLUSTER_BREAK, 5.0f, 0.0f), 3);
            }
            //e.getEntity().getWorld().spawnParticle(Particle.EXPLOSION_LARGE, loc, 100, 0, 0, 0, 0.1);
        }

        if (Math.random() <= 1) {
            e.getDrops().add(hellRune());
            killer.sendMessage(ChatColor.LIGHT_PURPLE + "" + ChatColor.BOLD + "RUNE DROP!" + ChatColor.GOLD + " Hell Rune");
            for (int i = 0; i < 5; i++) {
                Bukkit.getScheduler().runTaskLater(lifestealSmp, () -> killer.playSound(killer.getLocation(), Sound.BLOCK_AMETHYST_CLUSTER_BREAK, 5.0f, 0.0f), 3);
            }
            //e.getEntity().getWorld().spawnParticle(Particle.EXPLOSION_LARGE, loc, 100, 0, 0, 0, 0.1);
        }

        if (Math.random() <= 1) {
            e.getDrops().add(trollRune());
            killer.sendMessage(ChatColor.LIGHT_PURPLE + "" + ChatColor.BOLD + "RUNE DROP!" + ChatColor.GOLD + " Troll Rune");
            for (int i = 0; i < 5; i++) {
                Bukkit.getScheduler().runTaskLater(lifestealSmp, () -> killer.playSound(killer.getLocation(), Sound.BLOCK_AMETHYST_CLUSTER_BREAK, 5.0f, 0.0f), 3);
            }
            //e.getEntity().getWorld().spawnParticle(Particle.EXPLOSION_LARGE, loc, 100, 0, 0, 0, 0.1);
        }

        if (Math.random() <= 1) {
            e.getDrops().add(lightningRune());
            killer.sendMessage(ChatColor.LIGHT_PURPLE + "" + ChatColor.BOLD + "RUNE DROP!" + ChatColor.GOLD + " Lightning Rune");
            for (int i = 0; i < 5; i++) {
                Bukkit.getScheduler().runTaskLater(lifestealSmp, () -> killer.playSound(killer.getLocation(), Sound.BLOCK_AMETHYST_CLUSTER_BREAK, 5.0f, 0.0f), 3);
            }
            //e.getEntity().getWorld().spawnParticle(Particle.EXPLOSION_LARGE, loc, 100, 0, 0, 0, 0.1);
        }

        if (Math.random() <= 1) {
            e.getDrops().add(bloodRune());
            killer.sendMessage(ChatColor.LIGHT_PURPLE + "" + ChatColor.BOLD + "RUNE DROP!" + ChatColor.GOLD + " Blood Rune");
            for (int i = 0; i < 5; i++) {
                Bukkit.getScheduler().runTaskLater(lifestealSmp, () -> killer.playSound(killer.getLocation(), Sound.BLOCK_AMETHYST_CLUSTER_BREAK, 5.0f, 0.0f), 3);
            }
            //e.getEntity().getWorld().spawnParticle(Particle.EXPLOSION_LARGE, loc, 100, 0, 0, 0, 0.1);
        }

        if (Math.random() <= 1) {
            e.getDrops().add(airRune());
            killer.sendMessage(ChatColor.LIGHT_PURPLE + "" + ChatColor.BOLD + "RUNE DROP!" + ChatColor.GOLD + " Air Rune");
            for (int i = 0; i < 5; i++) {
                Bukkit.getScheduler().runTaskLater(lifestealSmp, () -> killer.playSound(killer.getLocation(), Sound.BLOCK_AMETHYST_CLUSTER_BREAK, 5.0f, 0.0f), 3);
            }
            //e.getEntity().getWorld().spawnParticle(Particle.EXPLOSION_LARGE, loc, 100, 0, 0, 0, 0.1);
        }
    }
}

