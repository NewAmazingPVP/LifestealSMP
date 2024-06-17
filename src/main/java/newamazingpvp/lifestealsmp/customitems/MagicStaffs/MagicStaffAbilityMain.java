package newamazingpvp.lifestealsmp.customitems.MagicStaffs;

import newamazingpvp.lifestealsmp.utility.CooldownManager;
import org.bukkit.*;
import org.bukkit.entity.Entity;
import org.bukkit.entity.LivingEntity;
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

import static newamazingpvp.lifestealsmp.customitems.MagicStaffs.MagicStaffUtils.staffBeamTexture.beamTextureMaker;
import static newamazingpvp.lifestealsmp.customitems.MagicStaffs.MajicStaffAbilitys.MagicStaffDefault.defaultStaffAbility;

public class MagicStaffAbilityMain implements Listener {




    @EventHandler
    public void onPlayerInteract(PlayerInteractEvent event) {
        Player attacker = event.getPlayer();
        ItemStack itemInHand = attacker.getInventory().getItemInMainHand();
        ItemMeta meta = itemInHand.getItemMeta();
        if (event.getAction().name().contains("LEFT_CLICK") && event.getItem() != null) {
            if (itemInHand != null && itemInHand.hasItemMeta()) {

                    if (event.getAction() == Action.LEFT_CLICK_AIR || event.getAction() == Action.LEFT_CLICK_BLOCK) {


                            Location location = attacker.getEyeLocation().add(0, 0.2, 0);
                            Vector attackerLookDir = attacker.getLocation().getDirection().multiply(0.1);


                            Vector direction = attacker.getEyeLocation().getDirection();
                            double range = 15;
                            Location targetLocation = attacker.getEyeLocation().clone();

                            for (int i = 0; i < range; i++) {
                                targetLocation.add(direction);

                                Entity target = getTargetEntityAtLocation(targetLocation);
                                if (target != null) {
                                    if (target instanceof Entity) {
                                        if (event.getItem().getType() == Material.STICK) {

                                            //Methods for each staff ability

                                            defaultStaffAbility(attacker, meta, location, attackerLookDir, target);






                                        }
                                    }
                                    break;
                                }

                                // Target location is obstructed by a block
                                if (targetLocation.getBlock().getType().isSolid()) {
                                    break;
                                }
                            }
                        }
                    }
                }
            }


    private Entity getTargetEntityAtLocation(Location location) {
        for (Entity target : location.getWorld().getEntities()) {
            if ((target.getLocation().getBlock().getX() == location.getBlock().getX()) &&
                    (target.getLocation().getBlock().getZ() == location.getBlock().getZ()) &&
                    (target.getLocation().getBlock().getY() >= location.getBlock().getY() - target.getHeight()) &&
                    (target.getLocation().getBlock().getY() <= location.getBlock().getY() + target.getHeight()) &&
                    (target instanceof LivingEntity)) {
                return target;
            }
        }
        return null;
    }

}
