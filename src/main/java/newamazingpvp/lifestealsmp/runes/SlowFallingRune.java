package newamazingpvp.lifestealsmp.runes;

import org.bukkit.ChatColor;
import org.bukkit.entity.EntityType;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class SlowFallingRune extends AbstractRune {

    private static final String name = "&x&4&1&0&0&F&F&lS&x&5&1&0&0&F&F&ll&x&6&1&0&0&F&F&lo&x&7&1&0&0&F&F&lw &x&8&1&0&0&F&F&lF&x&9&2&0&0&F&F&la&x&A&2&0&0&F&F&ll&x&B&2&0&0&F&F&li&x&C&2&0&0&F&F&ln&x&D&2&0&0&F&F&lg &x&E&2&0&0&F&F&lR&x&F&2&0&0&F&F&lu&x&F&2&0&0&F&F&ln&x&F&2&0&0&F&F&le";
    private static final EntityType mob = EntityType.PHANTOM;
    private static final PotionEffect effect = new PotionEffect(PotionEffectType.SLOW_FALLING, 200, 0);
    private static final String lore = ChatColor.LIGHT_PURPLE + "Grants permanent " + formatEffectKey(effect.getType().getKey().getKey()) + " " + formatAmplifier(effect.getAmplifier());

    public SlowFallingRune() {
        super(name, mob, 1.0/20, lore, effect);
    }


}
