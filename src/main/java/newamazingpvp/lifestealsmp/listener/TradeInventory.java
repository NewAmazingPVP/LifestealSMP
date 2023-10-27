package newamazingpvp.lifestealsmp.listener;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryInteractEvent;
import org.bukkit.event.inventory.InventoryMoveItemEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static newamazingpvp.lifestealsmp.command.TradeCommand.inv;

public class TradeInventory implements Listener {
    //List<ItemStack> p1 = new ArrayList<>();
    public static Map<String, List<ItemStack>> p1 = new HashMap<>();

    @EventHandler
    public static void invtest (InventoryClickEvent e){
        if(e.getClickedInventory() == inv) {
            Player p = (Player) e.getView();
            List<ItemStack> temp = p1.get(p.getName());
            temp.add(e.getCurrentItem());
            p1.put(p.getName(), temp);
        }
    }

    @EventHandler
    public static void invMove (InventoryMoveItemEvent e){
        if(e.getDestination() == inv) {
            Player p = (Player) e.getDestination().getViewers();
            List<ItemStack> temp = p1.get(p.getName());
            temp.add(e.getItem());
            p1.put(p.getName(), temp);
        }
        if(e.getSource() == inv) {
            Player p = (Player) e.getSource().getViewers();
            List<ItemStack> temp = p1.get(p.getName());
            temp.remove(e.getItem());
            p1.put(p.getName(), temp);
        }
    }

    public static void switchItems(Player p, Player target){
        List<ItemStack> temp = p1.get(p.getName());
        for(ItemStack t : temp){
            target.getInventory().addItem(t);
        }
        temp.clear();
        p1.put(p.getName(), temp);
    }
}
