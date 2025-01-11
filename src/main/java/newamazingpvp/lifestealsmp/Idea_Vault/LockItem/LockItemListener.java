package newamazingpvp.lifestealsmp.Idea_Vault.LockItem;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerDropItemEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.List;

public class LockItemListener implements Listener {

    @EventHandler
    public void dropItem(PlayerDropItemEvent e){

        Player player = e.getPlayer();
        ItemStack item = e.getItemDrop().getItemStack();
        ItemMeta meta = item.getItemMeta();
        List<String> lore = meta.getLore();
        if(meta.getLore().toString().toLowerCase().contains("§\uD83D\uDD12")){

        }


    }


}
