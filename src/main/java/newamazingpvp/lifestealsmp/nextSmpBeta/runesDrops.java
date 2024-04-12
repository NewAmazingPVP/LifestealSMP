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
        meta.setDisplayName(ChatColor.LIGHT_PURPLE + "" + ChatColor.MAGIC + "E" + "" + ChatColor.GOLD + "" + ChatColor.BOLD + "Wither Rune" + ChatColor.LIGHT_PURPLE + "" + ChatColor.MAGIC + "E" );
        meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
        List<String> LORE = new ArrayList<>();
        LORE.add(ChatColor.DARK_PURPLE + "" + "[Can be combined to any weapon]");
        LORE.add(" ");
        LORE.add(ChatColor.YELLOW + "" + ChatColor.BOLD + "RUNE ABILITY:");
        LORE.add(ChatColor.LIGHT_PURPLE + "Will give with affect to");
        LORE.add(ChatColor.LIGHT_PURPLE + "anything you damage " + ChatColor.DARK_PURPLE + "5sec");
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

        if (Math.random() <= 0.5) {
            e.getDrops().add(witherRune());
            //e.getEntity().getWorld().dropItemNaturally(e.getEntity().getLocation(), new ItemStack(CorruptedMobSoul()));
            killer.sendMessage(ChatColor.LIGHT_PURPLE + "" + ChatColor.BOLD + "RUNE DROP!" + ChatColor.GOLD + " Wither Rune");
            Bukkit.getScheduler().runTaskLater(lifestealSmp, () -> killer.playSound(killer.getLocation(), Sound.BLOCK_NOTE_BLOCK_PLING, 1.0f, 0.0f), 3);
            Bukkit.getScheduler().runTaskLater(lifestealSmp, () -> killer.playSound(killer.getLocation(), Sound.BLOCK_NOTE_BLOCK_PLING, 1.0f, 1.0f), 6);
            Bukkit.getScheduler().runTaskLater(lifestealSmp, () -> killer.playSound(killer.getLocation(), Sound.BLOCK_NOTE_BLOCK_PLING, 1.0f, 3.0f), 9);
            e.getEntity().getWorld().spawnParticle(Particle.EXPLOSION_LARGE, loc, 100, 0, 0, 0, 0.1);
        }
    }
}
