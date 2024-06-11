package newamazingpvp.lifestealsmp.customitems.itemlisteners;

import org.bukkit.*;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class SomberCrystal implements Listener {

    @EventHandler
    public void playerHitPlayer(EntityDamageByEntityEvent e) {

        Entity damagedPlayer = e.getEntity();
        Location loc = e.getDamager().getLocation();

        if (e.getDamager() instanceof Player) {
            Player player = (Player) e.getDamager();
            ItemStack itemInHand = player.getItemInHand();
            ItemMeta meta = itemInHand.getItemMeta();
            if (meta != null && meta.getLore() != null && meta.getLore().toString().contains("disables totems of undying on someone for 5min")) {
                if (damagedPlayer instanceof Player) {

                    for (Player onlineplayer : Bukkit.getOnlinePlayers()) {
                        onlineplayer.playSound(loc, Sound.BLOCK_GLASS_BREAK, 2.0f, 1.0f);
                        onlineplayer.playSound(loc, Sound.BLOCK_SCULK_SHRIEKER_SHRIEK, 2.0f, 0.0f);


                    }

                }
            }
        }
    }


    @EventHandler
    public void playerMove(PlayerMoveEvent e){
        Player player = e.getPlayer();
        replaceTotems(player);
    }




    private static void replaceTotems(Player player){

        for (int i = 0; i < player.getInventory().getSize(); i++) {
            ItemStack item = player.getInventory().getItem(i);

            if (item!= null && item.getType() == Material.TOTEM_OF_UNDYING) {
                player.getInventory().setItem(i, new ItemStack(Material.BARRIER));
                break; // Stop checking once we've replaced the first Totem

            }
        }
    }





    }
