package newamazingpvp.lifestealsmp.customitems.itemlisteners;

import org.bukkit.*;
import org.bukkit.entity.Entity;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.event.Event;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.util.RayTraceResult;
import org.bukkit.util.Vector;

import java.util.HashMap;
import java.util.UUID;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;


public class MagicStaff implements Listener {




    @EventHandler
    public void onPlayerInteract(PlayerInteractEvent event) {
        Player attacker = event.getPlayer();
        ItemStack itemInHand = attacker.getInventory().getItemInMainHand();
        ItemMeta meta = itemInHand.getItemMeta();
        if (event.getAction().name().contains("LEFT_CLICK") && event.getItem() != null) {
            if (itemInHand != null && itemInHand.hasItemMeta()) {
                if (meta.hasLore() && meta.getLore().toString().contains(ChatColor.DARK_PURPLE + "Shoots a beam of power dealing " + ChatColor.RED + "2❤")) {

                    if (event.getAction() == Action.LEFT_CLICK_AIR || event.getAction() == Action.LEFT_CLICK_BLOCK) {
                        attacker.sendActionBar(ChatColor.DARK_PURPLE + "You Used Beam!");




                        Location location = attacker.getEyeLocation().add(0, 0.2, 0);
                        Vector attackerLookDir = attacker.getLocation().getDirection();

                        for (Player onlinePlayer : Bukkit.getOnlinePlayers()) {
                            attacker.playSound(attacker.getLocation(), Sound.BLOCK_BEACON_POWER_SELECT, 1.0f, 2.0f);
                            attacker.playSound(attacker.getLocation(), Sound.ENTITY_FIREWORK_ROCKET_TWINKLE, 1.0f, 2.0f);
                        }

                        defaultBeam(attacker,location,attackerLookDir);







                    }
                }
            }
        }
    }



    private static void defaultBeam(Player player, Location location, Vector attackerLookDir) {

        for (int i = 0; i < 15; i++) {
            location.add(attackerLookDir);
            for (Player player2 : Bukkit.getOnlinePlayers()) {
                player2.getWorld().spawnParticle(Particle.REDSTONE, location, 0, new Particle.DustOptions(Color.GRAY, 2.0F));
                player2.getWorld().spawnParticle(Particle.REDSTONE, location, 0, new Particle.DustOptions(Color.GRAY, 3.0F));

                
                }
            }
        }
    }



                /*Vector direction2 = player.getLocation().getDirection();
                double range = 15;
                for (Entity entity : player.getNearbyEntities(range, range, range)) {
                    Vector entityVector = entity.getLocation().subtract(player.getLocation()).toVector();
                    if (entityVector.normalize().equals(direction2.normalize())) {
                                    entity.setLastDamage(2);
                                    entity.setLastDamager(player);
                        Event event2 = new EntityDamageByEntityEvent(entity, player, EntityDamageEvent.DamageCause.ENTITY_ATTACK, 2);
                        Bukkit.getServer().getPluginManager().callEvent(event2);


                    }
                }
            }*/





    }


