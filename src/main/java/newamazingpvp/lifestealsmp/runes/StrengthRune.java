package newamazingpvp.lifestealsmp.runes;

import org.bukkit.ChatColor;
import org.bukkit.entity.EntityType;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class StrengthRune extends AbstractRune {

    private static final String name = "&x&4&1&0&0&F&F&lS&x&5&1&0&0&F&F&ltr&x&6&1&0&0&F&F&le&x&7&1&0&0&F&F&ln&x&8&1&0&0&F&F&lg&x&A&2&0&0&F&F&lth &x&B&2&0&0&F&F&lR&x&C&2&0&0&F&F&lu&x&D&2&0&0&F&F&ln&x&E&2&0&0&F&F&le";
    private static final EntityType mob = EntityType.PIGLIN_BRUTE;
    private static final PotionEffect effect = new PotionEffect(PotionEffectType.STRENGTH, 200, 0);
    private static final String lore = ChatColor.LIGHT_PURPLE + "Grants permanent " + formatEffectKey(effect.getType().getKey().getKey()) + " " + formatAmplifier(effect.getAmplifier());

    public StrengthRune() {
        super(name, mob, 1.0/20, lore, effect);
    }

}
