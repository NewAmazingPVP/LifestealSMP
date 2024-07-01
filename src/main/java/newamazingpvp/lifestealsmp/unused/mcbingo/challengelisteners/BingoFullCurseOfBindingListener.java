package newamazingpvp.lifestealsmp.unused.mcbingo.challengelisteners;

import com.destroystokyo.paper.event.player.PlayerArmorChangeEvent;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;

import static newamazingpvp.lifestealsmp.unused.mcbingo.ToggleBingoListeners.toggleFullCurseOfBinding;

public class BingoFullCurseOfBindingListener implements Listener {


    @EventHandler
    public void itemBreak(PlayerArmorChangeEvent e) {


        Player player = e.getPlayer();


        if (toggleFullCurseOfBinding) {


        }

    }


}
