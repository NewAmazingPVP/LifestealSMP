package newamazingpvp.lifestealsmp.NewOrbUpdateTest.ItemFunctions;

import com.destroystokyo.paper.event.player.PlayerArmorChangeEvent;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

import static newamazingpvp.lifestealsmp.NewOrbUpdateTest.OrbUpdateItems.OrbUpdateArmor.spacesuitLeggings;

public class Spacesuit implements Listener {

    @EventHandler
    public void onPlayerRightClick(InventoryClickEvent e) {

        Player player = (Player) e.getWhoClicked();
        ItemStack chestplate = player.getInventory().getChestplate();


        if(chestplate!= null && chestplate.getItemMeta().getLore().toString().toLowerCase().contains("Helps you breathe next to void mobs!")){

            if(player.getInventory().getLeggings() != null){
                ItemStack saveLeggings = player.getInventory().getLeggings();
                player.getInventory().addItem(saveLeggings);
            }
            player.getEquipment().setLeggings(spacesuitLeggings());

            if(player.getInventory().getBoots() != null){
                ItemStack saveBoots = player.getInventory().getLeggings();
                player.getInventory().addItem(saveBoots);
            }

            player.getEquipment().setBoots(spacesuitLeggings());

        }

    }



}
