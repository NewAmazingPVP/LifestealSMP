package newamazingpvp.lifestealsmp.customitems.itemlisteners;

import newamazingpvp.lifestealsmp.utility.CooldownManager;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.Entity;
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

public class CometTrident implements Listener {

    private final Map<Player, Entity> linkPlayerWithComet = new HashMap<>();
    private final Map<Player, CooldownManager> wandCooldowns = new HashMap<>();


    @EventHandler
    public void onPlayerRightClick(PlayerInteractEvent e) {
        Player player = e.getPlayer();
        ItemStack itemInMainHand = player.getInventory().getItemInMainHand();
        ItemMeta meta = itemInMainHand.getItemMeta();
        float pitch = player.getLocation().getPitch();
        Location spawnLoc = null;
        Vector direction = player.getEyeLocation().getDirection();

        if ((e.getAction() == Action.RIGHT_CLICK_AIR || e.getAction() == Action.RIGHT_CLICK_BLOCK) && e.hasItem() && e.hasItem() && e.getItem().getType() == Material.TRIDENT) {
            if (meta.getLore().toString().contains("Summons a comet that will fly into")){


                e.setCancelled(true);


                if(pitch < 0 ){
                    pitch = Math.abs(pitch) + 90;
                }

                spawnLoc = player.getLocation();
                spawnLoc.add(0, 10, 0);


                player.sendMessage("The player is looking up/down by " + pitch + " degrees.");
                player.sendMessage("Direction player is looking is" + direction);





            }
        }
    }
}
