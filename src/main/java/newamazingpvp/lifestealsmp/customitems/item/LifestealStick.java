package newamazingpvp.lifestealsmp.customitems.item;

import newamazingpvp.lifestealsmp.utility.CooldownManager;
import org.bukkit.ChatColor;
import org.bukkit.Sound;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.HashMap;
import java.util.Map;

import static newamazingpvp.lifestealsmp.LifestealSMP.lifestealSmp;
import static org.bukkit.Bukkit.getServer;

public class LifestealStick implements Listener {

    private final Map<Player, CooldownManager> stickCooldowns = new HashMap<>();
    private final int lifeStealStickCooldown = 2;

    @EventHandler
    public void onPlayerHit(EntityDamageByEntityEvent event) {
        Entity damagedEntity = event.getEntity();

        if (event.getDamager() instanceof Player damager) {
            ItemStack itemInMainHand = damager.getInventory().getItemInMainHand();
            ItemMeta meta = itemInMainHand.getItemMeta();

            if (isLifeStealStick(meta)) {
                if (damagedEntity instanceof Player damagedPlayer) {
                    handleLifeSteal(damager, damagedPlayer);
                }
            }
        }
    }

    private boolean isLifeStealStick(ItemMeta meta) {
        return meta != null && meta.hasLore() && meta.getLore().toString().contains("You will heal " + ChatColor.RED + "1❤");
    }

    private void handleLifeSteal(Player damager, Player damagedPlayer) {
        CooldownManager cooldown = stickCooldowns.getOrDefault(damager, new CooldownManager());

        if (!cooldown.isOnCooldown()) {
            double newHealth = Math.min(damager.getHealth() + 2, damager.getAttribute(org.bukkit.attribute.Attribute.GENERIC_MAX_HEALTH).getValue());
            damager.setHealth(newHealth);
            damager.playSound(damager.getLocation(), Sound.ENTITY_ELDER_GUARDIAN_AMBIENT, 2.0f, 2.0f);
            cooldown.setCooldown(lifeStealStickCooldown);
            getServer().getScheduler().runTaskLater(lifestealSmp, () -> damager.setCooldown(damager.getInventory().getItemInMainHand().getType(), lifeStealStickCooldown * 20), 1);
            stickCooldowns.put(damager, cooldown);
        } else {
            damager.sendMessage(ChatColor.RED + "You must wait " + cooldown.getRemainingSeconds() + " seconds before using the Lifesteal Stick again.");
        }
    }
}
