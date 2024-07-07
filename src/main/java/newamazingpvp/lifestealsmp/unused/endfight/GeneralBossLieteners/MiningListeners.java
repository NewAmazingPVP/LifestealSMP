package newamazingpvp.lifestealsmp.unused.endfight.GeneralBossLieteners;

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
        Location locSpawn = loc;
        locSpawn.setY(loc.getY() + 1);



        if (block.getType() == Material.END_STONE) {

            block.setType(Material.BEDROCK);


                new BukkitRunnable() {
                    @Override
                    public void run() {

                        if (block.getType() == Material.BEDROCK) {
                            block.setType(Material.END_STONE);
                        }


                    }
                }.runTaskLater(lifestealSmp, 200);





        }


    }
}
