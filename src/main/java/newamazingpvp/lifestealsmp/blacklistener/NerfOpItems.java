package newamazingpvp.lifestealsmp.blacklistener;

import io.papermc.paper.event.player.PlayerBedFailEnterEvent;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.block.Block;
import org.bukkit.block.data.type.RespawnAnchor;
import org.bukkit.entity.*;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.EquipmentSlot;
import org.bukkit.potion.PotionType;

import java.util.List;

import static newamazingpvp.lifestealsmp.game.Compass.getPlaytime;
import static newamazingpvp.lifestealsmp.listener.CombatProtectionHandler.isGracePeriod;
import static newamazingpvp.lifestealsmp.listener.CombatProtectionHandler.newbieViolate;
import static newamazingpvp.lifestealsmp.listener.SpawnProtection.isWithinSpawnRadius;

public class NerfOpItems implements Listener {

    @EventHandler(priority = EventPriority.LOW)
    public void damageEvent(EntityDamageByEntityEvent event) {
        if (event.getEntity() instanceof Player player) {
            if (event.getDamager() instanceof EnderCrystal ||
                    event.getDamager() instanceof Minecart) {
                if (isGracePeriod() || (getPlaytime(player) < 12000 && !newbieViolate.contains(player.getName()))) {
                    event.setCancelled(true);
                    player.sendMessage(ChatColor.RED + "You were protected from explosive damage due to your newbie protection");
                    return;
                }
                /*if (invincibilityPlayers.contains(player.getName())) {
                    event.setCancelled(true);
                    player.sendMessage(ChatColor.RED + "You were protected from explosive damage due to your death protection");
                    return;
                }*/
                List<Entity> nearbyEntities = (List<Entity>) event.getDamager().getWorld().getNearbyEntities(event.getDamager().getLocation(), 14, 14, 14);

                int count = 0;
                for (Entity e : nearbyEntities) {
                    if (e instanceof Player) {
                        count++;
                    }
                }
                if (count <= 1) return;
                for (Entity e : nearbyEntities) {
                    if (e instanceof Player p) {
                        p.sendMessage(ChatColor.YELLOW + "Explosives other than TNT do not tag you for PVP");
                        if (!p.equals(player)) {
                            //check if same team or not
                            //tagPlayer(p, player);
                            //tagPlayer(player, p);
                        }
                    }
                }
                //event.setDamage(event.getDamage() * 0.15);
                event.setDamage(event.getDamage() * 0.30);
                player.sendMessage(ChatColor.YELLOW + "You were damaged by an overpowered explosive in PVP. These items are allowed on the server but are nerfed for balanced PvP. You should still be able to fight back.");
            } else if (event.getDamager() instanceof Player damager) {
//                if (damager.getInventory().getItemInMainHand().getType() == Material.MACE) {
//                    //double finalDmg = e.getFinalDamage()*0.25;
//                    //p.damage(e.getFinalDamage()*0.25);
//                    //event.setDamage(event.getDamage() * 0.30);
//                    event.setDamage(event.getDamage() * 0.75);
//                    // DONT USE THIS WONT WORK WELL WITH TOTEMS
//                    //p.setHealth(Math.max(0, p.getHealth()-finalDmg);
//                    player.sendMessage(ChatColor.YELLOW + "You were damaged by a mace. These items are allowed on the server but are nerfed for balanced PvP. You should still be able to fight back.");
//                    damager.sendMessage(ChatColor.AQUA + "You attacked another player with a mace. The mace is nerfed for balanced PvP on this server, so it won't give you a significant advantage.");
//                }
            } else if (event.getDamager() instanceof Arrow arrow) {
                if (isGracePeriod() || (getPlaytime(player) < 12000 && !newbieViolate.contains(player.getName()))) {
                    event.setCancelled(true);
                    player.sendMessage(ChatColor.RED + "You were protected from damage due to your newbie protection");
                    return;
                }
                if (arrow.getBasePotionType() == PotionType.INSTANT_DAMAGE) {
                    event.setCancelled(true);
                    if (isWithinSpawnRadius(player.getLocation())) {
                        return;
                    }
                    player.damage(1.0, event.getDamager());
                    arrow.remove();
                }
                if (arrow.getBasePotionType() == PotionType.STRONG_HARMING) {
                    event.setCancelled(true);
                    if (isWithinSpawnRadius(player.getLocation())) {
                        return;
                    }
                    player.damage(2.0, event.getDamager());
                    arrow.remove();
                }
            } else if (event.getDamager() instanceof ThrownPotion t) {
                if (isGracePeriod() || (getPlaytime(player) < 12000 && !newbieViolate.contains(player.getName()))) {
                    event.setCancelled(true);
                    player.sendMessage(ChatColor.RED + "You were protected from damage due to your newbie protection");
                    return;
                }
                if (t.getPotionMeta().getBasePotionType() == PotionType.INSTANT_DAMAGE) {
                    if (isWithinSpawnRadius(player.getLocation())) {
                        return;
                    }
                    event.setDamage(2);
                }
                if (t.getPotionMeta().getBasePotionType() == PotionType.STRONG_HARMING) {
                    if (isWithinSpawnRadius(player.getLocation())) {
                        return;
                    }
                    event.setDamage(4);
                }
            }
        }
    }

    /*@EventHandler
    public void onBedEnter(final PlayerBedEnterEvent event) {
        event.setUseBed(Event.Result.ALLOW);
    }(/*/

    @EventHandler
    public void onBedEnterFail(final PlayerBedFailEnterEvent event) {
        if (event.getBed().getLocation().getWorld().getEnvironment() == World.Environment.NORMAL) return;
        Location bedLocation = event.getBed().getLocation();

        List<Entity> nearbyEntities = (List<Entity>) bedLocation.getWorld().getNearbyEntities(bedLocation, 14, 14, 14);

        int count = 0;
        for (Entity e : nearbyEntities) {
            if (e instanceof Player) {
                count++;
            }
        }
        if (count <= 1) return;
        for (Entity e : nearbyEntities) {
            if (e instanceof Player p) {
                p.sendMessage(ChatColor.YELLOW + "Explosives other than TNT do not tag you for PVP");
                if (!p.equals(event.getPlayer())) {
                    //tagPlayer(p, event.getPlayer());
                    //tagPlayer(event.getPlayer(), p);
                }
            }
        }
        event.setWillExplode(false);
        event.getBed().breakNaturally();
        event.getPlayer().sendMessage("You attacked another player with a bed. The bed damage is nerfed for balanced PvP on this server, so it won't give you a significant advantage.");
        //bedLocation.getWorld().createExplosion(bedLocation, 2.0F, true, true);
        bedLocation.getWorld().createExplosion(bedLocation, 3.0F, true, true);
    }

    @EventHandler
    public void onAnchorInteract(final PlayerInteractEvent event) {
        if (event.getClickedBlock() == null) return;
        if (event.getClickedBlock().getLocation().getWorld().getEnvironment() == World.Environment.NETHER) return;
        final Player player = event.getPlayer();

        final Block block = event.getClickedBlock();
        if (event.getAction() != Action.RIGHT_CLICK_BLOCK
                || event.getHand() != EquipmentSlot.HAND
                || block == null
                || block.getType() != Material.RESPAWN_ANCHOR
                || !(block.getBlockData() instanceof RespawnAnchor anchor)) {
            return;
        }

        List<Entity> nearbyEntities = (List<Entity>) event.getClickedBlock().getLocation().getWorld().getNearbyEntities(event.getClickedBlock().getLocation(), 14, 14, 14);

        int count = 0;
        for (Entity e : nearbyEntities) {
            if (e instanceof Player) {
                count++;
            }
        }
        if (count <= 1) return;
        for (Entity e : nearbyEntities) {
            if (e instanceof Player p) {
                p.sendMessage(ChatColor.YELLOW + "Explosives other than TNT do not tag you for PVP");
                if (!p.equals(event.getPlayer())) {
                    //does it tg properly?????? in range?????
                    //tagPlayer(p, event.getPlayer());
                    //tagPlayer(event.getPlayer(), p);
                }
            }
        }
        if (willExplode(anchor, event.getMaterial())) {
            event.setCancelled(true);
            player.sendMessage("You attacked another player with a respawn anchor. The anchor damage is nerfed for balanced PvP on this server, so it won't give you a significant advantage.");
            Location anchorLocation = event.getClickedBlock().getLocation();
            event.getClickedBlock().breakNaturally();
            //anchorLocation.getWorld().createExplosion(anchorLocation, 3.0F, true, true);
            anchorLocation.getWorld().createExplosion(anchorLocation, 3.0F, true, true);
        }
    }


    private boolean willExplode(final RespawnAnchor anchor, final Material heldMaterial) {
        return (heldMaterial == Material.GLOWSTONE && anchor.getCharges() >= anchor.getMaximumCharges())
                || (heldMaterial != Material.GLOWSTONE && anchor.getCharges() > 0);
    }

}
