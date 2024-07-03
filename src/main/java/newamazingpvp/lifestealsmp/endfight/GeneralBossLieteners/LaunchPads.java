package newamazingpvp.lifestealsmp.endfight.GeneralBossLieteners;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.util.Vector;

public class LaunchPads implements Listener {


    @EventHandler
    public void playerOnLaunchPad(PlayerMoveEvent e){

        Player player = e.getPlayer();
        Location loc = player.getLocation();
        loc.setY(player.getY()-1);
        Block block = loc.getBlock();

        if(block.getType() == Material.SLIME_BLOCK){
            Vector velocity = player.getLocation().getDirection().multiply(3);
            player.setVelocity(velocity);

            for (Player onlinePlayer : Bukkit.getOnlinePlayers()) {
                onlinePlayer.playSound(loc, Sound.ENTITY_FIREWORK_ROCKET_SHOOT, 1.0f, 1.0f);
            }
        }

    }

}
