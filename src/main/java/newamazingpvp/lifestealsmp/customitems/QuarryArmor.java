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
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

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

        ItemMeta helmetMeta = helmet.getItemMeta();
        ItemMeta chestplateMeta = chestplate.getItemMeta();
        ItemMeta leggingMetas = leggings.getItemMeta();
        ItemMeta bootsMeta = boots.getItemMeta();


        if (helmet != null && helmet.getType() == Material.LEATHER_HELMET && helmetMeta != null && helmetMeta.getLore() != null && helmetMeta.getLore().toString().contains("You will heal " + ChatColor.RED + "1❤")) {
            isHelmetOn=true;
        }else{
            isHelmetOn=false;
        }


        if (chestplate != null && chestplate.getType() == Material.LEATHER_CHESTPLATE && chestplateMeta != null && chestplateMeta.getLore() != null && chestplateMeta.getLore().toString().contains("You will heal " + ChatColor.RED + "1❤")) {
            isChestplateOn=true;
        }else{
            isChestplateOn=false;
        }


        if (leggings != null && leggings.getType() == Material.LEATHER_LEGGINGS && leggingMetas != null && leggingMetas.getLore() != null && leggingMetas.getLore().toString().contains("You will heal " + ChatColor.RED + "1❤")) {
            isLeggingsOn=true;
        }else{
            isLeggingsOn=false;
        }


        if (boots != null && boots.getType() == Material.LEATHER_BOOTS && bootsMeta != null && bootsMeta.getLore() != null && bootsMeta.getLore().toString().contains("You will heal " + ChatColor.RED + "1❤")) {
            isBootsOn=true;
        }else{
            isBootsOn=false;
        }


        if(isHelmetOn==true && isChestplateOn==true && isLeggingsOn==true && isBootsOn==true){
            player.sendMessage(ChatColor.GREEN + "armor ability on test");
        }else{
            player.sendMessage(ChatColor.RED + "armor ability off test");
        }



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
