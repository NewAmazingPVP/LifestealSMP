package newamazingpvp.lifestealsmp.customitems.item;

import org.bukkit.*;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.entity.EntityDeathEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;

import static newamazingpvp.lifestealsmp.LifestealSMP.lifestealSmp;
import static newamazingpvp.lifestealsmp.customitems.utils.ItemStacks.corruptedMobSoul;
import static newamazingpvp.lifestealsmp.customitems.utils.ItemStacks.severedMobHeart;
import static newamazingpvp.lifestealsmp.utility.Utils.addItemOrDrop;
import static newamazingpvp.lifestealsmp.variables.Misc.maxHp;

public class HeartItems implements Listener {

    public static double heartMultipliers = 1;

    @EventHandler
    public void onPlayerKill(EntityDeathEvent e) {

        Player killer = e.getEntity().getKiller();
        Location loc = e.getEntity().getLocation();

        if (killer == null) return;

        ItemStack mainHandItem = killer.getInventory().getItemInMainHand();

        int lootingLevel = mainHandItem.getEnchantmentLevel(Enchantment.LOOTING);
        //TODO: Next season chances
        //0.002
        if (Math.random() <= (0.001 * (1 + 0.10 * lootingLevel)) * heartMultipliers) {
            //e.getDrops().add(corruptedMobSoul());
            addItemOrDrop(killer, corruptedMobSoul(), ChatColor.RED + "Mob soul was dropped because your inventory was full");
            //e.getEntity().getWorld().dropItemNaturally(e.getEntity().getLocation(), new ItemStack(CorruptedMobSoul()));
            killer.sendMessage(ChatColor.GOLD + "" + ChatColor.BOLD + "RARE DROP!" + ChatColor.DARK_PURPLE + " Corrupted Mob Soul");
            killer.sendMessage(ChatColor.LIGHT_PURPLE + "" + ChatColor.BOLD + "Used to craft hearts!");
            killer.sendMessage(ChatColor.DARK_PURPLE + "" + ChatColor.BOLD + "Be careful, this is a extremely rare drop so people might try to scam you for it");
            Bukkit.getScheduler().runTaskLater(lifestealSmp, () -> killer.playSound(killer.getLocation(), Sound.BLOCK_NOTE_BLOCK_PLING, 1.0f, 0.0f), 3);
            Bukkit.getScheduler().runTaskLater(lifestealSmp, () -> killer.playSound(killer.getLocation(), Sound.BLOCK_NOTE_BLOCK_PLING, 1.0f, 1.0f), 6);
            Bukkit.getScheduler().runTaskLater(lifestealSmp, () -> killer.playSound(killer.getLocation(), Sound.BLOCK_NOTE_BLOCK_PLING, 1.0f, 3.0f), 9);
            e.getEntity().getWorld().spawnParticle(Particle.EXPLOSION, loc, 100, 0, 0, 0, 0.1);
        }
        //0.001
        if (Math.random() <= (0.0005 * (1 + 0.10 * lootingLevel)) * heartMultipliers) {
            //e.getDrops().add(severedMobHeart());
            addItemOrDrop(killer, severedMobHeart(), ChatColor.RED + "Mob soul was dropped because your inventory was full");
            //e.getEntity().getWorld().dropItemNaturally(e.getEntity().getLocation(), new ItemStack(severedMobHeart()));
            killer.sendMessage(ChatColor.GOLD + "" + ChatColor.BOLD + "RARE DROP!" + ChatColor.DARK_PURPLE + " Severed Mob Heart");
            killer.sendMessage(ChatColor.LIGHT_PURPLE + "" + ChatColor.BOLD + "Used to craft hearts!");
            killer.sendMessage(ChatColor.DARK_PURPLE + "" + ChatColor.BOLD + "Be careful, this is a extremely rare drop so people might try to scam you for it");
            Bukkit.getScheduler().runTaskLater(lifestealSmp, () -> killer.playSound(killer.getLocation(), Sound.BLOCK_NOTE_BLOCK_PLING, 1.0f, 0.0f), 3);
            Bukkit.getScheduler().runTaskLater(lifestealSmp, () -> killer.playSound(killer.getLocation(), Sound.BLOCK_NOTE_BLOCK_PLING, 1.0f, 1.0f), 6);
            Bukkit.getScheduler().runTaskLater(lifestealSmp, () -> killer.playSound(killer.getLocation(), Sound.BLOCK_NOTE_BLOCK_PLING, 1.0f, 3.0f), 9);
            e.getEntity().getWorld().spawnParticle(Particle.EXPLOSION, loc, 100, 0, 0, 0, 0.1);

        }
    }

    @EventHandler
    public void onPlayerConsumeHeart(PlayerInteractEvent e) {

        Player player = e.getPlayer();
        ItemStack item = player.getInventory().getItemInMainHand();

        if (e.getAction() == Action.RIGHT_CLICK_AIR || e.getAction() == Action.RIGHT_CLICK_BLOCK) {
            if (item.getType() == Material.RED_DYE && item.hasItemMeta() && item.getItemMeta().hasDisplayName() && item.hasLore() && item.getLore().toString().toLowerCase().contains("max 20 hearts")) {
                if (e.getPlayer().getMaxHealth() > maxHp) {
                    player.sendMessage(ChatColor.RED + "You have the max hearts allowed! (20)");
                    e.setCancelled(true);

                } else {
                    player.playSound(player.getLocation(), Sound.ENTITY_EXPERIENCE_ORB_PICKUP, 1.0f, 2.0f);
                    player.playSound(player.getLocation(), Sound.ENTITY_EXPERIENCE_ORB_PICKUP, 1.0f, 2.0f);
                    player.playSound(player.getLocation(), Sound.ENTITY_EXPERIENCE_ORB_PICKUP, 1.0f, 2.0f);
                    player.playSound(player.getLocation(), Sound.ENTITY_ENDER_DRAGON_GROWL, 1.0f, 1.0f);
                    player.sendMessage(ChatColor.GOLD + "" + ChatColor.BOLD + "+1 Heart!");
                    player.sendTitle(ChatColor.GOLD + "+1", "", 0, 70, 20);
                    player.setMaxHealth(player.getMaxHealth() + 2);
                    if (item.getAmount() > 1) {
                        item.setAmount(item.getAmount() - 1);
                        player.getInventory().setItemInMainHand(item);
                    } else {
                        player.getInventory().setItemInMainHand(null);
                    }
                }
            }
        }
    }
}

