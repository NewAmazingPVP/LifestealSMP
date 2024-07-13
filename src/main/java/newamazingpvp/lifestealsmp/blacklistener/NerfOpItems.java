package newamazingpvp.lifestealsmp.blacklistener;

import org.bukkit.ChatColor;
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
    public void damageEvent(EntityDamageByEntityEvent event) {
        if (event.getEntity() instanceof Player) {
            Player player = (Player) event.getEntity();

            if (event.getDamager() instanceof EnderCrystal ||
                    event.getDamager() instanceof Bed ||
                    event.getDamager() instanceof RespawnAnchor ||
                    event.getDamager() instanceof Minecart) {

                event.setDamage(event.getDamage() * 0.20);
                player.sendMessage(ChatColor.YELLOW + "You were damaged by an overpowered explosive. These items are allowed on the server but are nerfed for balanced PvP. You should still be able to fight back.");
            }
            else if (event.getDamager() instanceof Player) {
                Player damager = (Player) event.getDamager();
                if (damager.getInventory().getItemInMainHand().getType() == Material.MACE) {
                    //double finalDmg = e.getFinalDamage()*0.25;
                    //p.damage(e.getFinalDamage()*0.25);
                    event.setDamage(event.getDamage() * 0.20);
                    //p.setHealth(p.getHealth()-finalDmg);
                    player.sendMessage(ChatColor.YELLOW + "You were damaged by a mace. These items are allowed on the server but are nerfed for balanced PvP. You should still be able to fight back.");
                    damager.sendMessage(ChatColor.AQUA + "You attacked another player with a mace. The mace is nerfed for balanced PvP on this server, so it won't give you a significant advantage.");
                }
            }
        }
    }
}
