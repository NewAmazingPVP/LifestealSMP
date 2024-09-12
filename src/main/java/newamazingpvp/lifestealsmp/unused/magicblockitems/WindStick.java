package newamazingpvp.lifestealsmp.unused.magicblockitems;

import newamazingpvp.lifestealsmp.utility.CooldownManager;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.util.Vector;

import java.util.HashMap;
import java.util.Map;

import static newamazingpvp.lifestealsmp.LifestealSMP.lifestealSmp;
import static org.bukkit.Bukkit.getServer;

public class WindStick implements Listener {

    private final Map<Player, CooldownManager> WindStickCooldowns = new HashMap<>();
    private final int WindStickCooldown = 3;

    @EventHandler
    public void playerInteract(PlayerInteractEvent event) {

        Player attacker = event.getPlayer();

        if ((event.getAction() == Action.LEFT_CLICK_AIR || event.getAction() == Action.LEFT_CLICK_BLOCK) && event.hasItem() && event.getItem().getType() == Material.NETHERITE_SHOVEL) {
            ItemMeta meta = event.getItem().getItemMeta();
            ItemStack itemInMainHand = attacker.getInventory().getItemInMainHand();
            CooldownManager cooldown = WindStickCooldowns.getOrDefault(attacker, new CooldownManager());
            if (!cooldown.isOnCooldown()) {

                cooldown.setCooldown(WindStickCooldown);
                WindStickCooldowns.put(attacker, cooldown);
                getServer().getScheduler().runTaskLater(lifestealSmp, () -> event.getPlayer().setCooldown(itemInMainHand.getType(), WindStickCooldown * 20), 1);

                if (meta.getLore() == null) return;

                if (meta.getLore().toString().contains("and scrambles your opponent!")) {


                }
            }
        }
    }


    private static void windScramblePlayer(Player attacker, Player victom) {

        Location playerLoc = victom.getLocation();

        double maxHeight = playerLoc.getWorld().getMaxHeight() - playerLoc.getY();
        Vector upwardVector = new Vector(0, 10, 0);
        victom.setVelocity(upwardVector.multiply(maxHeight / 2));

        victom.damage(5, attacker);

    }


}
