package newamazingpvp.lifestealsmp.customitems.armor;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class QuarryArmor implements Listener {

    public static boolean quarryIsHelmetOn = false;
    public static boolean quarryIsChestplateOn = false;
    public static boolean quarryIsLeggingsOn = false;
    public static boolean quarryIsBootsOn = false;

    private static final boolean doubleOreDrops = false;

    @EventHandler
    public void onArmorChange(PlayerMoveEvent event) {

        Player player = event.getPlayer();

        ItemStack helmet = player.getInventory().getHelmet();
        ItemStack chestplate = player.getInventory().getChestplate();
        ItemStack leggings = player.getInventory().getLeggings();
        ItemStack boots = player.getInventory().getBoots();

        ItemMeta helmetMeta = helmet.getItemMeta();
        ItemMeta chestplateMeta = chestplate.getItemMeta();
        ItemMeta leggingMetas = leggings.getItemMeta();
        ItemMeta bootsMeta = boots.getItemMeta();


        quarryIsHelmetOn = helmet.getType() == Material.LEATHER_HELMET && helmetMeta != null && helmetMeta.getLore() != null && helmetMeta.getLore().toString().contains("You also have unlimited haste 3.");


        quarryIsChestplateOn = chestplate.getType() == Material.LEATHER_CHESTPLATE && chestplateMeta != null && chestplateMeta.getLore() != null && chestplateMeta.getLore().toString().contains("You also have unlimited haste 3.");


        quarryIsLeggingsOn = leggings.getType() == Material.LEATHER_LEGGINGS && leggingMetas != null && leggingMetas.getLore() != null && leggingMetas.getLore().toString().contains("You also have unlimited haste 3.");


        quarryIsBootsOn = boots.getType() == Material.LEATHER_BOOTS && bootsMeta != null && bootsMeta.getLore() != null && bootsMeta.getLore().toString().contains("You also have unlimited haste 3.");


        if (quarryIsHelmetOn && quarryIsChestplateOn && quarryIsLeggingsOn && quarryIsBootsOn) {
            player.addPotionEffect(new PotionEffect(PotionEffectType.FAST_DIGGING, 100000, 2));
        } else {
            player.removePotionEffect(PotionEffectType.FAST_DIGGING);
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
