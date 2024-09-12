package newamazingpvp.lifestealsmp.unused.visuals.toasts;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

import static newamazingpvp.lifestealsmp.unused.visuals.toasts.CreateCustomToast.Style.TASK;

public class PlayerJoinToast implements Listener {

    private static String displayMessage = ChatColor.DARK_RED + "[ERROR]";


    @EventHandler
    public void playerJoinEvent(PlayerJoinEvent e) {
        Player player = e.getPlayer();

        String name = player.getName();


        displayMessage = ChatColor.DARK_PURPLE + "" + ChatColor.BOLD + name + " Has Joined " + ChatColor.DARK_GREEN + ChatColor.BOLD + "[+]";

        final String materialName = "player_head";

        try {
            Material.valueOf(materialName.toUpperCase());

        } catch (final Throwable t) {

            return;
        }


        PlayerJoinToastCreate.displayTo(materialName, displayMessage, TASK, name);

    }


}
