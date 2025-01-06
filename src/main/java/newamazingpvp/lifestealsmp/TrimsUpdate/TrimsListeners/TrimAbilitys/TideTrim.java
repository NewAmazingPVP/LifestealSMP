package newamazingpvp.lifestealsmp.TrimsUpdate.TrimsListeners.TrimAbilitys;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.Event;

public class TideTrim {

    /*gives speed and damage buff when in water
    +.2 damage when in the nether */

    public void triggerTideTrim(Player attacker, Event e){

        Location loc = attacker.getLocation();
        Block b1 = loc.getBlock();
        loc.setY(loc.y()-1);
        Block b2 = loc.getBlock();
        if(b1.getBlockData().getMaterial().equals(Material.WATER) || b2.getBlockData().getMaterial().equals(Material.WATER)){



        }


    }


}
