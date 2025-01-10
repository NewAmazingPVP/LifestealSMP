package newamazingpvp.lifestealsmp.blacklistener;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.scheduler.BukkitRunnable;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

import static newamazingpvp.lifestealsmp.LifestealSMP.lifestealSmp;
import static newamazingpvp.lifestealsmp.game.Compass.getPlaytime;
import static newamazingpvp.lifestealsmp.listener.CombatProtectionHandler.newbieViolate;

public class AntiLavaDamage implements Listener {

    private final HashMap<Location, UUID> playerPlacedLava = new HashMap<>();

    @EventHandler
    public void onPlayerInteract(PlayerInteractEvent event) {
        Player player = event.getPlayer();
        if (event.getAction() == Action.RIGHT_CLICK_BLOCK) {
            ItemStack item = player.getInventory().getItemInMainHand();
            if (item.getType() == Material.LAVA_BUCKET) {
                Block clickedBlock = event.getClickedBlock();
                if (clickedBlock != null) {
                    Block placedBlock = clickedBlock.getRelative(event.getBlockFace());
                    playerPlacedLava.put(placedBlock.getLocation(), player.getUniqueId());
                }
            }
        }
    }

    @EventHandler
    public void onEntityDamage(EntityDamageEvent event) {
        if (!(event.getEntity() instanceof Player player)) {
            return;
        }

        if (event.getCause() != EntityDamageEvent.DamageCause.LAVA) {
            return;
        }

        long playtime = getPlaytime(player);
        if (playtime < 77000 && !newbieViolate.contains(player.getName())) {
            Location damageLocation = player.getLocation();
            double radius = 7.0;
            for (Location placedLavaLoc : playerPlacedLava.keySet()) {
                if (playerPlacedLava.get(placedLavaLoc).equals(player.getUniqueId())) {
                    continue;
                }
                if (placedLavaLoc.getWorld().equals(damageLocation.getWorld()) && placedLavaLoc.distance(damageLocation) <= radius) {
                    event.setCancelled(true);
                    player.sendMessage(ChatColor.RED + "You were protected from player placed lava due to newbie protection.");
                    new BukkitRunnable() {
                        @Override
                        public void run() {
                            player.setFireTicks(0);
                        }
                    }.runTaskLater(lifestealSmp, 1L);

                    break;
                }
            }
        }
    }
}
