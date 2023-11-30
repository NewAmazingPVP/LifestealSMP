package newamazingpvp.lifestealsmp.Sekhmet_Items;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;

public class testNoBlockBreak implements Listener {
    @EventHandler
    public void onPlayerBlockBreak(BlockBreakEvent e){
        e.setCancelled(true);
        Player player=e.getPlayer();
        player.banPlayer(ChatColor.DARK_RED+"You're fat as fuck");
    }
}