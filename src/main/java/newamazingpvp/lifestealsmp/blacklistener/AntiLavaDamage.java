package newamazingpvp.lifestealsmp.blacklistener;

import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByBlockEvent;
import org.bukkit.event.player.PlayerBucketEmptyEvent;
import org.bukkit.inventory.ItemStack;

import java.util.HashSet;
import java.util.Set;

import static newamazingpvp.lifestealsmp.game.Compass.getPlaytime;
import static newamazingpvp.lifestealsmp.listener.CombatProtectionHandler.newbieViolate;

public class AntiLavaDamage implements Listener {

    private final Set<Location> playerPlacedLava = new HashSet<>();

    @EventHandler
    public void onPlayerPlaceLava(PlayerBucketEmptyEvent event) {
        ItemStack bucket = event.getItemStack();
        if (bucket != null && bucket.getType() == Material.LAVA_BUCKET) {
            Block block = event.getBlock();
            playerPlacedLava.add(block.getLocation());
        }
    }

    @EventHandler
    public void onEntityDamageByBlock(EntityDamageByBlockEvent event) {
        if (event.getEntity() instanceof Player player) {
            // get invinciblities for death prot
            if (getPlaytime(player) < 144000 && !newbieViolate.contains(player.getName())) {
                Block block = event.getDamager();
                if (block != null && block.getType() == Material.LAVA) {
                    Location blockLocation = block.getLocation();
                    for (Location lavaLoc : playerPlacedLava) {
                        double radius = 3.0;
                        if (lavaLoc.getWorld().equals(blockLocation.getWorld()) && lavaLoc.distance(blockLocation) <= radius) {
                            event.setCancelled(true);
                            player.sendMessage(ChatColor.RED + "You were protected from lava damage placed by other player due to your newbie protection");
                            break;
                        }
                    }
                }
            }

        }
    }
}
