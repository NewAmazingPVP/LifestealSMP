package newamazingpvp.lifestealsmp.MinecraftBINGO.BingoChallengeListeners;

import com.destroystokyo.paper.event.player.PlayerArmorChangeEvent;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerItemBreakEvent;

import static newamazingpvp.lifestealsmp.MinecraftBINGO.ToggleBingoListeners.toggleFullCurseOfBinding;

public class BingoFullCurseOfBindingListener implements Listener {



    @EventHandler
    public void itemBreak(PlayerArmorChangeEvent e) {


         Player player = e.getPlayer();




        if(toggleFullCurseOfBinding == true){




        }

    }


}
