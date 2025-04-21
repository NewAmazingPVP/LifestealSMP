package newamazingpvp.lifestealsmp.vault.Fishing;

import org.bukkit.Bukkit;
import org.bukkit.entity.Item;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerFishEvent;
import org.bukkit.event.player.PlayerMoveEvent;

import static newamazingpvp.lifestealsmp.vault.Fishing.FishingLootGen.generateFishingDrop;


public class FishingMainEventListener implements Listener {


    @EventHandler
    public void playerFishItem(PlayerFishEvent e) {

        Player player = e.getPlayer();
        //Biome b = player.getLocation().getBlock().getBiome();

        Bukkit.getServer().broadcastMessage("test");

        if (e.getState().equals(PlayerFishEvent.State.CAUGHT_ENTITY)) {
            if (e.getCaught() instanceof Item stack) {
                stack.setItemStack(generateFishingDrop(player));

            }
        }


    }


    @EventHandler
    public void onPlayerJoin(PlayerMoveEvent e) {
        e.getPlayer().sendMessage("Hello!");
        Bukkit.getServer().broadcastMessage("welcome test");
    }

}
