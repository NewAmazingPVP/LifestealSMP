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

    private static final String name = "&x&4&1&0&0&F&F&lW&x&5&1&0&0&F&F&la&x&6&1&0&0&F&F&lt&x&7&1&0&0&F&F&le&x&8&1&0&0&F&F&lr &x&A&2&0&0&F&F&lR&x&B&2&0&0&F&F&lu&x&C&2&0&0&F&F&ln&x&D&2&0&0&F&F&le";
    private static final EntityType mob = EntityType.POLAR_BEAR;
    private static final PotionEffect effect = new PotionEffect(PotionEffectType.WATER_BREATHING, 200, 0);
    private static final String lore = ChatColor.LIGHT_PURPLE + "Grants permanent " + formatEffectKey(effect.getType().getKey().getKey()) + " " + formatAmplifier(effect.getAmplifier());
    public WaterRune() {
        super(name, mob, 1.0/10, lore, effect);
    }

}