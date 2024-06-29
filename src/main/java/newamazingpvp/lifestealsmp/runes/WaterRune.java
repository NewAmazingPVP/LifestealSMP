package newamazingpvp.lifestealsmp.runes;

import org.bukkit.ChatColor;
import org.bukkit.Effect;
import org.bukkit.entity.Drowned;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.potion.Potion;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.potion.PotionEffectTypeCategory;

import java.util.ArrayList;
import java.util.List;

public class WaterRune extends AbstractRune {

    private static final String name = "&x&4&1&0&0&F&F&lW&x&4&9&0&0&F&F&la&x&5&0&0&0&F&F&lt&x&5&8&0&0&F&F&le&x&6&0&0&0&F&F&lr &x&6&F&0&0&F&F&lB&x&7&6&0&0&F&F&lr&x&7&E&0&0&F&F&le&x&8&6&0&0&F&F&la&x&8&D&0&0&F&F&lt&x&9&5&0&0&F&F&lh&x&9&D&0&0&F&F&li&x&A&4&0&0&F&F&ln&x&A&C&0&0&F&F&lg &x&B&B&0&0&F&F&lR&x&C&3&0&0&F&F&lu&x&C&A&0&0&F&F&ln&x&D&2&0&0&F&F&le";
    private static final EntityType mob = EntityType.POLAR_BEAR;
    private static final PotionEffect effect = new PotionEffect(PotionEffectType.WATER_BREATHING, 200, 0);
    private static final String lore = ChatColor.LIGHT_PURPLE + "Grants permanent " + formatEffectKey(effect.getType().getKey().getKey()) + " " + formatAmplifier(effect.getAmplifier());
    public WaterRune() {
        super(name, mob, 1.0/50, lore, effect);
    }

}