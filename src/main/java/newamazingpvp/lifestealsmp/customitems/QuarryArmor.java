package newamazingpvp.lifestealsmp.customitems;

import com.destroystokyo.paper.event.player.PlayerArmorChangeEvent;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class QuarryArmor implements Listener {

    private static boolean isHelmetOn = false;
    private static boolean isChestplateOn = false;
    private static boolean isLeggingsOn = false;
    private static boolean isBootsOn = false;

    @EventHandler
    public void onArmorChange(PlayerArmorChangeEvent event) {

        Player player = event.getPlayer();

        ItemStack helmet = player.getInventory().getHelmet();
        ItemStack chestplate = player.getInventory().getChestplate();
        ItemStack leggings = player.getInventory().getLeggings();
        ItemStack boots = player.getInventory().getBoots();



/*        if (helmet!= null && helmet.getType() == Material.LEATHER_HELMET) {
            if (meta != null && meta.getLore() != null && meta.getLore().toString().contains("You will heal " + ChatColor.RED + "1❤")) {

        }




    }*/
    }
}









        /*private static boolean isHelmetOn(){

        }

        private static boolean isChestplateOn(){

        }

        private static boolean isLeggingsOn(){

        }

        private static boolean osBootsOn(){

        }





    }

}*/
