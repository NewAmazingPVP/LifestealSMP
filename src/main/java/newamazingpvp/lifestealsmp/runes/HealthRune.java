package newamazingpvp.lifestealsmp.runes;

import org.bukkit.ChatColor;
import org.bukkit.entity.EntityType;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
public class HealthRune extends AbstractRune {

    private static final String name = "&x&4&1&0&0&F&F&lH&x&5&1&0&0&F&F&le&x&6&1&0&0&F&F&la&x&7&1&0&0&F&F&ll&x&8&1&0&0&F&F&lt&x&A&2&0&0&F&F&lh &x&B&2&0&0&F&F&lR&x&C&2&0&0&F&F&lu&x&D&2&0&0&F&F&ln&x&E&2&0&0&F&F&le";
    private static final EntityType mob = EntityType.WITCH;
    private static final PotionEffect effect = new PotionEffect(PotionEffectType.INSTANT_HEALTH, 1, 0);
    private static final PotionEffect effectII = new PotionEffect(PotionEffectType.INSTANT_HEALTH, 1, 1);

    private static final String lore = ChatColor.LIGHT_PURPLE + "Grants permanent " + formatEffectKey(effect.getType().getKey().getKey()) + " " + formatAmplifier(effect.getAmplifier());

    public HealthRune() {
        super(name,
                mob,
                1.0 / 250,
                lore,
                effect);
    }

    static class II extends AbstractRune {
        public II() {
            super(name + " II",
                    mob,
                    1.0 / 500,
                    ChatColor.LIGHT_PURPLE + "Grants permanent " + formatEffectKey(effectII.getType().getKey().getKey()) + " " + formatAmplifier(effectII.getAmplifier()),
                    effectII);
        }
    }
}
