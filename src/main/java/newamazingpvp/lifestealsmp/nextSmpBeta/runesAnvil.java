package newamazingpvp.lifestealsmp.nextSmpBeta;

import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.PrepareAnvilEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class runesAnvil implements Listener{

    @EventHandler
    public void onPrepareAnvil(PrepareAnvilEvent event) {

        // Check if the first slot is a diamond and the second slot is an iron ingot
        ItemStack firstItem = event.getInventory().getItem(0);
        ItemStack secondItem = event.getInventory().getItem(1);

        if (firstItem != null && secondItem != null &&
                firstItem.getType() == Material.DIAMOND &&
                secondItem.getType() == Material.IRON_INGOT) {

            // Create a new item stack for the result
            ItemStack result = new ItemStack(Material.DIAMOND_SWORD);
            ItemMeta meta = result.getItemMeta();
            meta.setDisplayName("Custom Diamond Sword");
            result.setItemMeta(meta);

            // Set the result in the anvil
            event.setResult(result);
        }
    }

}

