package newamazingpvp.lifestealsmp.listener;

import org.bukkit.*;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDeathEvent;

import static newamazingpvp.lifestealsmp.LifestealSMP.lifestealSmp;
import static newamazingpvp.lifestealsmp.game.CustomRecipe.corruptedMobSoul;

public class MontuStaffDrops implements Listener {

    @EventHandler
    public void onPlayerKill(EntityDeathEvent e) {

        Player killer = e.getEntity().getKiller();
        Location loc = e.getEntity().getLocation();

        if (Math.random() >= 0.5) {
            e.getDrops().add(corruptedMobSoul());
            //e.getEntity().getWorld().dropItemNaturally(e.getEntity().getLocation(), new ItemStack(CorruptedMobSoul()));
            killer.sendMessage(ChatColor.GOLD + "" + ChatColor.BOLD + "RARE DROP!" + ChatColor.DARK_PURPLE + " Corrupted Mob Soul");
            Bukkit.getScheduler().runTaskLater(lifestealSmp, () -> killer.playSound(killer.getLocation(), Sound.BLOCK_NOTE_BLOCK_PLING, 1.0f, 0.0f), 3);
            Bukkit.getScheduler().runTaskLater(lifestealSmp, () -> killer.playSound(killer.getLocation(), Sound.BLOCK_NOTE_BLOCK_PLING, 1.0f, 1.0f), 6);
            Bukkit.getScheduler().runTaskLater(lifestealSmp, () -> killer.playSound(killer.getLocation(), Sound.BLOCK_NOTE_BLOCK_PLING, 1.0f, 3.0f), 9);
            e.getEntity().getWorld().spawnParticle(Particle.EXPLOSION_LARGE, loc, 100, 0, 0, 0, 0.1);
        }
    }
}
