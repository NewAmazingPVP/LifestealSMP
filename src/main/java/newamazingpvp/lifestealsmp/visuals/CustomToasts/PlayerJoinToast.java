package newamazingpvp.lifestealsmp.visuals.CustomToasts;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

import static newamazingpvp.lifestealsmp.visuals.CustomToasts.CreateCustomToast.Style.TASK;

public class PlayerJoinToast implements Listener {

    private static String displayMessage = ChatColor.DARK_RED + "[ERROR]";


    @EventHandler
    public void playerJoinEvent(PlayerJoinEvent e){
        Player player = e.getPlayer();

        String name = player.getName();

        if(name == "Comet99" || name == "Newamazingpvp"){
            displayMessage = ChatColor.DARK_RED + "" + ChatColor.BOLD + name + "Has Joined " + ChatColor.DARK_GREEN + "" + ChatColor.BOLD + "[+]";
        }else{
            displayMessage = ChatColor.BLUE + "" + ChatColor.BOLD + name + "Has Joined " + ChatColor.DARK_GREEN + "" + ChatColor.BOLD + "[+]";
        }

        final String materialName = "dirt";

        try {
            Material.valueOf(materialName.toUpperCase());

        } catch (final Throwable t) {

            return;
        }


        

        CreateCustomToast.displayTo(materialName, displayMessage, TASK);

    }



}
