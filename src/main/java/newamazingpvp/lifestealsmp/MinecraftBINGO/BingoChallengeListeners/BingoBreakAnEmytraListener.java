package newamazingpvp.lifestealsmp.MinecraftBINGO.BingoChallengeListeners;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDeathEvent;
import org.bukkit.event.player.PlayerItemBreakEvent;
import org.bukkit.inventory.ItemStack;

import static newamazingpvp.lifestealsmp.MinecraftBINGO.ToggleBingoListeners.toggleBreakAnElytra;

public class BingoBreakAnEmytraListener implements Listener {

    @EventHandler
    public void itemBreak(PlayerItemBreakEvent e) {

        Player player = e.getPlayer();
        ItemStack brokenItem = e.getBrokenItem();

        if(toggleBreakAnElytra == true){
            if (brokenItem!= null && brokenItem.getType() == Material.ELYTRA){

                //TODO: <<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<


            }
        }
    }
}
