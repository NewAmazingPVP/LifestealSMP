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
import org.jetbrains.annotations.NotNull;

import java.util.HashMap;
import java.util.Map;

import static newamazingpvp.lifestealsmp.customitems.itemlisteners.FeatherSword.getString;

public class SomberCrystal implements Listener {

    private final Map<Player, Long> somberCooldowns = new HashMap<>();
    private final double somberMaxTime = 2.5;
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



    private boolean isTeleportCooldownExpired(Player player) {
        if (somberCooldowns.containsKey(player)) {
            long lastTeleportTime = somberCooldowns.get(player);
            long currentTime = System.currentTimeMillis();
            return currentTime - lastTeleportTime >= somberMaxTime;
        }
        return true;
    }


    private void setTeleportCooldown(Player player) {
        somberCooldowns.put(player, System.currentTimeMillis());
    }

    private String cooldownRemainingTime(Player player) {
        return getString(player, somberCooldowns, (long) somberMaxTime);
    }


}
