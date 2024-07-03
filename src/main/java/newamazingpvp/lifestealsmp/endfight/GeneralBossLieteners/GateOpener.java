package newamazingpvp.lifestealsmp.endfight.GeneralBossLieteners;

import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEvent;

public class GateOpener implements Listener {


    @EventHandler
    public void playerInteract(PlayerInteractEvent e){
        Player player = e.getPlayer();
        Block block = e.getClickedBlock();
        if(block.getType()== Material.END_PORTAL_FRAME){

        }

    }


}
