package newamazingpvp.lifestealsmp.listener;

import org.bukkit.ChatColor;
import org.bukkit.entity.Arrow;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.scheduler.BukkitRunnable;

import java.util.Arrays;
import java.util.List;

public class GracePeriod implements Listener {
    private final long gracePeriod = 1697913000L;
    public List<String> names = Arrays.asList();

    @EventHandler
    public void onEntityDamageByEntity(EntityDamageByEntityEvent event) {
        if (event.getEntity() instanceof Player) {
            Player damaged = (Player) event.getEntity();

            if (event.getDamager() instanceof Player || event.getDamager() instanceof Arrow) {
                if (event.getDamager() instanceof Player) {
                    Player damager = (Player) event.getDamager();

                    if (isGracePeriod()) {
                        event.setCancelled(true);
                        damager.sendMessage(ChatColor.RED + "You cannot damage players during the grace period!");
                    }
                    if(isPlayerDeathProt(damaged)){
                        event.setCancelled(true);
                        damager.sendMessage(ChatColor.RED + "You cannot damage players during their death protection unless they attack you back!");
                    }
                    names.remove(damager.getName());
                } else if (event.getDamager() instanceof Arrow) {
                    Arrow arrow = (Arrow) event.getDamager();
                    if (arrow.getShooter() instanceof Player) {
                        Player shooter = (Player) arrow.getShooter();

                        if (isGracePeriod()) {
                            event.setCancelled(true);
                            shooter.sendMessage(ChatColor.RED + "You cannot shoot players during the grace period!");
                        }
                        if(isPlayerDeathProt(damaged)){
                            event.setCancelled(true);
                            event.getDamager().sendMessage(ChatColor.RED + "You cannot shoot players during their death protection unless they attack you back!");
                        }
                        names.remove(event.getDamager().getName());
                    }
                }
            }
        }
    }

    public boolean isGracePeriod(){
        Long lol = System.currentTimeMillis();
        return lol < gracePeriod;
    }

    @EventHandler
    public void onDeath(PlayerDeathEvent event){
        names.add(event.getPlayer().getName());
        new BukkitRunnable() {
            @Override
            public void run() {
                names.remove(event.getPlayer().getName())
            }
        })0, 1)
    }

    public boolean isPlayerDeathProt(Player p){
        return names.contains(p.getName());
    }
}
