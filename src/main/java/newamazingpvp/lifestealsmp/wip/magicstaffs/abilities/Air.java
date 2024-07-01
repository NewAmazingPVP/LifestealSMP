package newamazingpvp.lifestealsmp.wip.magicstaffs.abilities;

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

import static newamazingpvp.lifestealsmp.wip.magicstaffs.utils.BeamTexture.beamTextureMaker;
import static newamazingpvp.lifestealsmp.wip.magicstaffs.utils.StaffSound.playMagicStaffSound;

public class Air implements Listener {

    private final Map<Player, CooldownManager> defaultMagicStaffCooldowns = new HashMap<>();
    private final double defaultMagicStaffCooldown = 0.5;


    @EventHandler
    public void onPlayerInteract(PlayerInteractEvent event) {
        Player attacker = event.getPlayer();
        ItemStack itemInHand = attacker.getInventory().getItemInMainHand();
        ItemMeta meta = itemInHand.getItemMeta();
        if (event.getAction().name().contains("LEFT_CLICK") && event.getItem() != null) {
            if (itemInHand != null && itemInHand.hasItemMeta()) {
                if (meta.hasLore() && meta.getLore().toString().contains(ChatColor.DARK_PURPLE + "Shoots a beam of power pushing a player")) {

                    if (event.getAction() == Action.LEFT_CLICK_AIR || event.getAction() == Action.LEFT_CLICK_BLOCK) {

                        CooldownManager cooldown = defaultMagicStaffCooldowns.getOrDefault(attacker, new CooldownManager());
                        if (!cooldown.isOnCooldown()) {

                            cooldown.setCooldown(defaultMagicStaffCooldown);
                            defaultMagicStaffCooldowns.put(attacker, cooldown);


                            Location location = attacker.getEyeLocation().add(0, 0.2, 0);
                            Vector attackerLookDir = attacker.getLocation().getDirection();
                            Vector direction = attacker.getEyeLocation().getDirection();
                            Location targetLocation = attacker.getEyeLocation().clone();
                            double range = 15;


                            playMagicStaffSound(attacker, Sound.BLOCK_BEACON_POWER_SELECT, 2.0f, Sound.ENTITY_FIREWORK_ROCKET_TWINKLE, 2.0f);
                            beamTextureMaker(attacker, location, attackerLookDir, Color.GRAY, 2.0F, Color.GRAY, 2.0F);


                            for (int i = 0; i < range; i++) {
                                targetLocation.add(direction);

                                Entity target = getTargetEntityAtLocation(targetLocation);
                                if (target != null) {
                                    if (target instanceof Entity) {
                                        if (event.getItem().getType() == Material.STICK) {


                                            Vector velocity = attacker.getLocation().getDirection().multiply(3);
                                            double maxHeight = 2.0;
                                            if (velocity.getY() > maxHeight) {
                                                velocity.setY(maxHeight);
                                            }
                                            target.setVelocity(velocity);


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
