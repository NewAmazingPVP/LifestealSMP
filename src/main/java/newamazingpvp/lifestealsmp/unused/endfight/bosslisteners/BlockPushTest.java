package newamazingpvp.lifestealsmp.unused.endfight.bosslisteners;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;

public class BlockPushTest implements Listener {

    @EventHandler
    public void playerPushBlock(PlayerMoveEvent e) {

        Player player = e.getPlayer();
        Location loc = player.getLocation();
        loc.setX(player.getX() + 1);
        if (loc.getBlock().getType() == Material.AMETHYST_BLOCK) {
            loc.setX(+1);
            Block block1 = loc.getBlock();
            if (block1.getType() == Material.AIR) {
                block1.setType(Material.AMETHYST_BLOCK);
                loc.setX(-1);
                Block block2 = loc.getBlock();
                block2.setType(Material.AIR);
            } else {
                loc.setX(-1);
            }

        }

        loc.setX(player.getX() - 1);
        loc.setX(player.getX() - 1);
        if (loc.getBlock().getType() == Material.AMETHYST_BLOCK) {
            loc.setX(-1);
            Block block3 = loc.getBlock();
            if (block3.getType() == Material.AIR) {
                block3.setType(Material.AMETHYST_BLOCK);
                loc.setX(+1);
                Block block4 = loc.getBlock();
                block4.setType(Material.AIR);
            } else {
                loc.setX(+1);
            }
        }

        loc.setX(player.getX() + 1);
        loc.setZ(player.getZ() + 1);
        if (loc.getBlock().getType() == Material.AMETHYST_BLOCK) {
            loc.setZ(+1);
            Block block5 = loc.getBlock();
            if (block5.getType() == Material.AIR) {
                block5.setType(Material.AMETHYST_BLOCK);
                loc.setZ(-1);
                Block block6 = loc.getBlock();
                block6.setType(Material.AIR);
            } else {
                loc.setZ(-1);
            }
        }

        loc.setZ(player.getZ() - 1);
        loc.setZ(player.getZ() - 1);
        if (loc.getBlock().getType() == Material.AMETHYST_BLOCK) {
            loc.setZ(-1);
            Block block7 = loc.getBlock();
            if (block7.getType() == Material.AIR) {
                block7.setType(Material.AMETHYST_BLOCK);
                loc.setZ(+1);
                Block block8 = loc.getBlock();
                block8.setType(Material.AIR);
            } else {
                loc.setZ(+1);
            }
        }
    }
}
