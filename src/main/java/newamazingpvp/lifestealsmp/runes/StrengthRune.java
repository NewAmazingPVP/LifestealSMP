package newamazingpvp.lifestealsmp.runes;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Effect;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.EntityType;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.SkullMeta;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import java.util.ArrayList;
import java.util.List;

public class StrengthRune extends Rune implements Listener {
    public StrengthRune(){
        super("newamazingpvp", "Strength", EntityType.PIGLIN_BRUTE.toString(), "strength");
    }

    @EventHandler
    public void onPlayerMove(PlayerMoveEvent e){
        ItemStack[] items = e.getPlayer().getInventory().getContents();

        for (ItemStack item : items) {
            if (item != null) {
                if(item instanceof StrengthRune){
                    e.getPlayer().addPotionEffect(effect());
                    //Entity.
                }
            }
        }
    }

    @Override
    public PotionEffect effect(){
        return new PotionEffect(PotionEffectType.INCREASE_DAMAGE, Integer.MAX_VALUE, 1, true, false);
    }
}
