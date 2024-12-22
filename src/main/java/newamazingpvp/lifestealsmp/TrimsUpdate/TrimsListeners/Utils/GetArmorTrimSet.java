package newamazingpvp.lifestealsmp.TrimsUpdate.TrimsListeners.Utils;

import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.PlayerInventory;
import org.bukkit.inventory.meta.ArmorMeta;
import org.bukkit.inventory.meta.trim.TrimPattern;

import java.util.Objects;

public class GetArmorTrimSet {

    public static boolean getArmorTrimSet(Player player, TrimPattern trimPattern){

        PlayerInventory inv = player.getInventory();

        player.sendMessage("test2");

        if(inv.getHelmet() == null || inv.getChestplate() == null || inv.getLeggings() == null || inv.getBoots() == null){
            player.sendMessage("test3FALSE");
            return false;
        }

        player.sendMessage("test3TRUE");

        ArmorMeta helmet = (ArmorMeta) inv.getHelmet().getItemMeta();
        ArmorMeta chestplate = (ArmorMeta) inv.getChestplate().getItemMeta();
        ArmorMeta leggings = (ArmorMeta) inv.getLeggings().getItemMeta();
        ArmorMeta boots = (ArmorMeta) inv.getBoots().getItemMeta();

        player.sendMessage("test4");

        return Objects.requireNonNull(helmet.getTrim()).getPattern().equals(trimPattern) && Objects.requireNonNull(chestplate.getTrim()).getPattern().equals(trimPattern) && Objects.requireNonNull(leggings.getTrim()).getPattern().equals(trimPattern) && Objects.requireNonNull(boots.getTrim()).getPattern().equals(trimPattern);
    }



}
