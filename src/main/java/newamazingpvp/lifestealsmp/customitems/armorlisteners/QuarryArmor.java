package newamazingpvp.lifestealsmp.customitems.armorlisteners;

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

    @EventHandler
    public void onArmorChange(PlayerMoveEvent event) {
        Player player = event.getPlayer();

        ItemStack helmet = player.getInventory().getHelmet();
        ItemStack chestplate = player.getInventory().getChestplate();
        ItemStack leggings = player.getInventory().getLeggings();
        ItemStack boots = player.getInventory().getBoots();

        boolean quarryIsHelmetOn = isQuarryArmorPieceOn(helmet, Material.LEATHER_HELMET);
        boolean quarryIsChestplateOn = isQuarryArmorPieceOn(chestplate, Material.LEATHER_CHESTPLATE);
        boolean quarryIsLeggingsOn = isQuarryArmorPieceOn(leggings, Material.LEATHER_LEGGINGS);
        boolean quarryIsBootsOn = isQuarryArmorPieceOn(boots, Material.LEATHER_BOOTS);

        if (quarryIsHelmetOn && quarryIsChestplateOn && quarryIsLeggingsOn && quarryIsBootsOn) {
            player.addPotionEffect(new PotionEffect(PotionEffectType.FAST_DIGGING, 100000, 2));
        } else {
            player.removePotionEffect(PotionEffectType.FAST_DIGGING);
        }
    }

    private boolean isQuarryArmorPieceOn(ItemStack item, Material requiredMaterial) {
        if (item == null || item.getType() != requiredMaterial) {
            return false;
        }
        ItemMeta meta = item.getItemMeta();
        return meta != null && meta.getLore() != null && meta.getLore().toString().contains("You also have unlimited haste 3.");
    }
}
