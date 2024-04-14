package newamazingpvp.lifestealsmp.nextSmpBeta;



import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.EntityDeathEvent;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import java.util.EventListener;

import static newamazingpvp.lifestealsmp.LifestealSMP.lifestealSmp;

public class runesEvents implements Listener {

    @EventHandler
    public void playerMove(PlayerMoveEvent e) {


        //AQUA RUNE
        PotionEffect effect = new PotionEffect(PotionEffectType.DOLPHINS_GRACE, 100, 4); //change if needed

        Player player = e.getPlayer();
        ItemStack[] items = player.getInventory().getContents();


        for (ItemStack item : items) {
            if (item != null) {
                ItemMeta meta = item.getItemMeta();
                if (meta.hasDisplayName() && meta.getDisplayName().equals(ChatColor.LIGHT_PURPLE + "" + ChatColor.MAGIC + "E" + "" + ChatColor.AQUA + "" + ChatColor.BOLD + " Aqua Rune " + ChatColor.LIGHT_PURPLE + "" + ChatColor.MAGIC + "E")) {
                    if (e.getPlayer().getLocation().getBlock().getType() == Material.WATER) {
                        player.addPotionEffect(effect);
                    }
                }
            }
        }
    }


    @EventHandler
    public void playerAttack(EntityDamageByEntityEvent e) {

        Player attacker = (Player) e.getDamager();
        Player victim = (Player) e.getEntity();
        ItemStack[] items = attacker.getInventory().getContents();

        for (ItemStack item : items) {
            if (item != null) {
                ItemMeta meta = item.getItemMeta();
                if (meta.hasDisplayName() && meta.getDisplayName().equals(ChatColor.LIGHT_PURPLE + "" + ChatColor.MAGIC + "E" + "" + ChatColor.YELLOW + "" + ChatColor.BOLD + " Lightning Rune " + ChatColor.LIGHT_PURPLE + "" + ChatColor.MAGIC + "E")) {
                    if (Math.random() <= 0.5) {
                        victim.getWorld().strikeLightningEffect(victim.getLocation());
                        victim.playSound(victim.getLocation(), Sound.BLOCK_GLASS_BREAK, 5.0f, 0.0f);
                        victim.sendMessage(ChatColor.DARK_RED + "-5 (True Damage)");


                        attacker.playSound(attacker.getLocation(), Sound.BLOCK_NOTE_BLOCK_PLING, 5.0f, 2.0f);
                        attacker.sendMessage(ChatColor.GREEN + "True Damage Activated!");

                        for (Player soundLOC1 : Bukkit.getServer().getOnlinePlayers()) {
                            soundLOC1.playSound(victim.getLocation(), Sound.ENTITY_LIGHTNING_BOLT_THUNDER, 2.0f, 2.0f);

                        }
                    }
                }
            }
        }
    }





}
