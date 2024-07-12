package newamazingpvp.lifestealsmp.blacklistener;

import org.bukkit.Material;
import org.bukkit.block.Bed;
import org.bukkit.block.data.type.RespawnAnchor;
import org.bukkit.entity.EnderCrystal;
import org.bukkit.entity.Minecart;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;

public class NerfOpItems implements Listener {
    @EventHandler
    public void crystalEvent(EntityDamageByEntityEvent e) {
        if (e.getEntity() instanceof Player) {
            Player p = (Player) e.getEntity();
            if (e.getDamager() instanceof EnderCrystal ||
                    e.getDamager() instanceof Bed ||
                    e.getDamager() instanceof RespawnAnchor ||
                    e.getDamager() instanceof Minecart) {
                e.setDamage(e.getDamage()*0.35);
            } else if(e.getDamager() instanceof Player){
                Player damage = (Player) e.getDamager();
                if(damage.getInventory().getItemInMainHand().getType().equals(Material.MACE)){
                    //double finalDmg = e.getFinalDamage()*0.25;
                    //p.damage(e.getFinalDamage()*0.25);
                    e.setDamage(e.getDamage()*0.35);
                    //p.setHealth(p.getHealth()-finalDmg);
                }
            }
        }
    }
}
