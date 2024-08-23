package newamazingpvp.lifestealsmp.visuals.CustomToasts;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class PlayerJoinToast implements Listener {


    @EventHandler
    public void playerJoinEvent(PlayerJoinEvent e){
        Player player = e.getPlayer();

        /*public static void displayTo(Player player, String icon, String message, CreateCustomToast.Style style) {
            new CreateCustomToast(icon, message, style).start(player);
        }*/

    }



}
