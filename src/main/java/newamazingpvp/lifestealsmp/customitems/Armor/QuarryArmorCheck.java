package newamazingpvp.lifestealsmp.customitems.Armor;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import static newamazingpvp.lifestealsmp.customitems.Armor.QuarryArmor.*;

public class QuarryArmorCheck implements Listener {

    @EventHandler
    public void onArmorChange(PlayerMoveEvent event) {

        Player player = event.getPlayer();

        if(quarryIsHelmetOn && quarryIsChestplateOn && quarryIsLeggingsOn && quarryIsBootsOn){
            player.addPotionEffect(new PotionEffect(PotionEffectType.FAST_DIGGING, 100000, 2));
        }else{
            player.removePotionEffect(PotionEffectType.FAST_DIGGING);
        }

    }

}
