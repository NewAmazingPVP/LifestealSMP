package newamazingpvp.lifestealsmp.customitems.MagicStaffs.MajicStaffAbilitys;


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

public class MagicStaffDefault implements Listener {

    private final Map<Player, CooldownManager> defaultMagicStaffCooldowns = new HashMap<>();
    private final double defaultMagicStaffCooldown = 3;


    @EventHandler
    public void onPlayerInteract(PlayerInteractEvent event) {
        Player attacker = event.getPlayer();
        ItemStack itemInHand = attacker.getInventory().getItemInMainHand();
        ItemMeta meta = itemInHand.getItemMeta();
        if (event.getAction().name().contains("LEFT_CLICK") && event.getItem() != null) {
            if (itemInHand != null && itemInHand.hasItemMeta()) {
                if (meta.hasLore() && meta.getLore().toString().contains(ChatColor.DARK_PURPLE + "Shoots a beam of power dealing " + ChatColor.RED + "1❤")) {

                    if (event.getAction() == Action.LEFT_CLICK_AIR || event.getAction() == Action.LEFT_CLICK_BLOCK) {

                        CooldownManager cooldown = defaultMagicStaffCooldowns.getOrDefault(attacker, new CooldownManager());
                        if (!cooldown.isOnCooldown()) {

                            cooldown.setCooldown(defaultMagicStaffCooldown);
                            defaultMagicStaffCooldowns.put(attacker, cooldown);


                            Location location = attacker.getEyeLocation().add(0, 0.2, 0);
                            Vector attackerLookDir = attacker.getLocation().getDirection().multiply(0.1);

                            for (Player onlinePlayer : Bukkit.getOnlinePlayers()) {
                                attacker.playSound(attacker.getLocation(), Sound.BLOCK_BEACON_POWER_SELECT, 1.0f, 2.0f);
                                attacker.playSound(attacker.getLocation(), Sound.ENTITY_FIREWORK_ROCKET_TWINKLE, 1.0f, 2.0f);
                            }

                            beamTextureMaker(attacker, location, attackerLookDir, Color.GRAY, 2.0F, Color.GRAY, 2.0F);


                            Vector direction = attacker.getEyeLocation().getDirection();
                            double range = 15;
                            Location targetLocation = attacker.getEyeLocation().clone();

                            for (int i = 0; i < range; i++) {
                                targetLocation.add(direction);

                                Entity target = getTargetEntityAtLocation(targetLocation);
                                if (target != null) {
                                    if (target instanceof Entity) {
                                        if (event.getItem().getType() == Material.STICK) {
                                            ((LivingEntity) target).damage(1);
                                        }
                                    }
                                    break;
                                }

                                // Target location is obstructed by a block
                                if (targetLocation.getBlock().getType().isSolid()) {
                                    break;
                                }
                            }

                        } else {
                            attacker.sendActionBar(ChatColor.RED + "" + ChatColor.BOLD + "Cooldown Active For " + cooldown.getRemainingSeconds());
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

