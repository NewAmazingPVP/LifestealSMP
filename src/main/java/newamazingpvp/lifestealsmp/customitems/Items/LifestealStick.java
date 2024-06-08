package newamazingpvp.lifestealsmp.customitems.Items;

import org.bukkit.ChatColor;
import org.bukkit.Sound;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.jetbrains.annotations.NotNull;

import java.util.HashMap;
import java.util.Map;

public class LifestealStick implements Listener {

    private final Map<Player, Long> stickCooldowns = new HashMap<>();
    private final int lifeStealStickCooldown = 1;

    @EventHandler
    public void playerHitPlayer(EntityDamageByEntityEvent e) {

        Entity damagedPlayer = e.getEntity();

        if (e.getDamager() instanceof Player) {
            Player player = (Player) e.getDamager();
            ItemStack itemInHand = player.getItemInHand();
            ItemMeta meta = itemInHand.getItemMeta();
            if (meta != null && meta.getLore() != null && meta.getLore().toString().contains("You will heal " + ChatColor.RED + "1❤")) {
                if(damagedPlayer instanceof Player){

                    if (isTeleportCooldownExpired(player)) {

                        player.setHealth(player.getHealth() + 1);
                        player.playSound(player.getLocation(), Sound.ENTITY_ELDER_GUARDIAN_AMBIENT, 2.0f, 2.0f);
                        setTeleportCooldown(player);

                    }
                }
            }
        }
    }

    private boolean isTeleportCooldownExpired(Player player) {
        if (stickCooldowns.containsKey(player)) {
            long lastTeleportTime = stickCooldowns.get(player);
            long currentTime = System.currentTimeMillis();
            return currentTime - lastTeleportTime >= lifeStealStickCooldown;
        }
        return true;
    }




    private void setTeleportCooldown(Player player) {
        stickCooldowns.put(player, System.currentTimeMillis());
    }


}


