package newamazingpvp.lifestealsmp.customitems.itemlisteners;

import newamazingpvp.lifestealsmp.utility.CooldownManager;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.entity.ArmorStand;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
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
        Location spawnLoc = player.getLocation();
        Vector direction = player.getEyeLocation().getDirection();
        double range = 0;
        World world = player.getWorld();
        Location areaAbovePlayer = player.getLocation().add(0,10,0);

        if ((e.getAction() == Action.RIGHT_CLICK_AIR || e.getAction() == Action.RIGHT_CLICK_BLOCK) && e.hasItem() && e.hasItem() && e.getItem().getType() == Material.TRIDENT) {
            if (meta.getLore().toString().contains("Summons a comet that will fly into")){


                e.setCancelled(true);


                if(pitch < 0 ) {
                    pitch = Math.abs(pitch) + 90;
                }

                range = pitch -=100;

                for (double i = 0; i < range; i++) {
                    spawnLoc.add(direction);
                }

                spawnLoc.setY(player.getY()+10);

                EntityType entityType = EntityType.ARMOR_STAND;
                world.spawnEntity(spawnLoc, entityType);

                player.sendMessage("The player is looking up/down by " + pitch + " degrees.");
                player.sendMessage("Direction player is looking is" + direction);


                new ItemStack(Material.MACE);


            }
        }
    }
}
