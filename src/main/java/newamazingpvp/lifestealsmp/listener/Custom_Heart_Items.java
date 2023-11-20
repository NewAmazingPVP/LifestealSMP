package newamazingpvp.lifestealsmp.listener;

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

public class Custom_Heart_Items implements Listener {

    @EventHandler
    public void onPlayerKill(EntityDeathEvent e) {

        Player killer = e.getEntity().getKiller();
        Location loc = e.getEntity().getLocation();

        ItemStack CorruptedMobSoul = new ItemStack(Material.ECHO_SHARD);
        ItemMeta heartM = CorruptedMobSoul.getItemMeta();
        heartM.addEnchant(Enchantment.DURABILITY, 1, false);
        heartM.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        heartM.setDisplayName(ChatColor.LIGHT_PURPLE + "" + ChatColor.MAGIC + "LL" + ChatColor.DARK_PURPLE + "" + ChatColor.BOLD + "Corrupted Mob Soul" + ChatColor.LIGHT_PURPLE + "" + ChatColor.MAGIC + "LL");
        heartM.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
        List<String> heartL = new ArrayList<>();
        heartL.add(ChatColor.AQUA + "U$e To Cr" + ChatColor.MAGIC + "a" + ChatColor.AQUA + "ft Extra Hearts!" + ChatColor.MAGIC + "L");
        heartM.setLore(heartL);
        CorruptedMobSoul.setItemMeta(heartM);

        if (Math.random() <= 1.0 / 2) {
            e.getEntity().getWorld().dropItemNaturally(e.getEntity().getLocation(), new ItemStack(CorruptedMobSoul));
            killer.sendMessage(ChatColor.GOLD + "" + ChatColor.BOLD + "Rare Drop!" + ChatColor.DARK_PURPLE + "" + ChatColor.BOLD + " Corrupted Mob Soul");
            Bukkit.getScheduler().runTaskLater(lifestealSmp, () -> killer.playSound(killer.getLocation(), Sound.BLOCK_NOTE_BLOCK_BIT, 1.0f, 0.0f), 1);
            Bukkit.getScheduler().runTaskLater(lifestealSmp, () -> killer.playSound(killer.getLocation(), Sound.BLOCK_NOTE_BLOCK_BIT, 1.0f, 1.0f), 11);
            Bukkit.getScheduler().runTaskLater(lifestealSmp, () -> killer.playSound(killer.getLocation(), Sound.BLOCK_NOTE_BLOCK_BIT, 1.0f, 3.0f), 21);
        }
    }
}

