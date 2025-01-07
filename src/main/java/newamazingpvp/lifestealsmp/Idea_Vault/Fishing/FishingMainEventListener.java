package newamazingpvp.lifestealsmp.Idea_Vault.Fishing;

import org.bukkit.block.Biome;
import org.bukkit.entity.Item;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerFishEvent;

import static newamazingpvp.lifestealsmp.Idea_Vault.Fishing.FishingLootGen.generateFishingDrop;


public class FishingMainEventListener implements Listener {


    @EventHandler
    public void playerFishItem(PlayerFishEvent e){

        Player player = e.getPlayer();
        Biome b = player.getLocation().getBlock().getBiome();

        player.sendMessage("test1");

        if(e.getCaught() instanceof Item){
            player.sendMessage("test2");
            Item stack = (Item) e.getCaught();
            stack.setItemStack(generateFishingDrop(b,player));
            player.sendMessage("test3");


        }



    }


}
