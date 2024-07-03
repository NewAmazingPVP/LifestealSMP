package newamazingpvp.lifestealsmp.endfight.GeneralBossLieteners;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.scheduler.BukkitRunnable;

import static newamazingpvp.lifestealsmp.LifestealSMP.lifestealSmp;

public class MiningListeners implements Listener {

    @EventHandler
    public void playerBreakBlock(BlockBreakEvent e) {
        Player player = e.getPlayer();
        Block block = e.getBlock();
        Location loc = block.getLocation();


        if (block.getType() == Material.END_STONE) {

            if (Math.random() < 0.5) {
                block.setType(Material.CHEST);
            } else {
                block.setType(Material.BEDROCK);
            }

            new BukkitRunnable() {
                @Override
                public void run() {
                    block.setType(Material.END_STONE);
                }
            }.runTaskLater(lifestealSmp, 200);

            e.setCancelled(true);

        }



    }







}
