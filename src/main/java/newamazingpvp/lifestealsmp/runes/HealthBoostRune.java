package newamazingpvp.lifestealsmp.runes;

import org.bukkit.ChatColor;
import org.bukkit.entity.EntityType;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class HealthBoostRune extends AbstractRune {

    private static final String name = "&x&4&1&0&0&F&F&lH&x&5&1&0&0&F&F&le&x&6&1&0&0&F&F&la&x&7&1&0&0&F&F&ll&x&8&1&0&0&F&F&lt&x&A&2&0&0&F&F&lh &x&B&2&0&0&F&F&lB&x&C&2&0&0&F&F&lo&x&D&2&0&0&F&F&lo&x&E&2&0&0&F&F&ls&x&F&2&0&0&F&Ft &x&F&2&0&0&F&F&lR&x&F&2&0&0&F&F&lu&x&F&2&0&0&F&F&ln&x&F&2&0&0&F&F&le";
    private static final EntityType mob = EntityType.WITHER;
    private static final PotionEffect effect = new PotionEffect(PotionEffectType.HEALTH_BOOST, 200, 0);
    private static final String lore = ChatColor.LIGHT_PURPLE + "Grants permanent " + formatEffectKey(effect.getType().getKey().getKey()) + " " + formatAmplifier(effect.getAmplifier());

    public HealthBoostRune() {
        super(name, mob, 1.0 / 10, lore, effect);
    }


}
