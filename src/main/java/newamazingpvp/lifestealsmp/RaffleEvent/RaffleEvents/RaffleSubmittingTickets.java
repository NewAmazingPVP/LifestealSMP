package newamazingpvp.lifestealsmp.RaffleEvent.RaffleEvents;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import static newamazingpvp.lifestealsmp.RaffleEvent.RaffleMain.numOfTicketsAddedByAPlayer;
import static newamazingpvp.lifestealsmp.RaffleEvent.RaffleMain.totalNumOfRaffleTicketsAdded;

public class RaffleSubmittingTickets implements Listener {

    @EventHandler
    public void playerRightClick(PlayerInteractEvent e){

        Player player = e.getPlayer();
        ItemStack item = e.getItem();

        if ((e.getAction() == Action.RIGHT_CLICK_AIR || e.getAction() == Action.RIGHT_CLICK_BLOCK)){

            if (e.getItem().getItemMeta() != null){
                ItemMeta meta = e.getItem().getItemMeta();

                if (meta.getLore().toString().contains("Right click within 150 blocks")){

                    if (item.getAmount() > 1) {
                        item.setAmount(item.getAmount() - 1);
                        player.getInventory().setItemInMainHand(item);
                    } else {
                        player.getInventory().setItemInMainHand(null);
                    }



                    numOfTicketsAddedByAPlayer.put(player, numOfTicketsAddedByAPlayer.getOrDefault(player, 0) + 1);

                    totalNumOfRaffleTicketsAdded += 1;

                    player.sendMessage(" "+ numOfTicketsAddedByAPlayer);

                    player.sendMessage("Total"+ totalNumOfRaffleTicketsAdded);

                }
            }
        }
    }
}
