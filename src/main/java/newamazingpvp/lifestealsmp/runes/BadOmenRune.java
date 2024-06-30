package newamazingpvp.lifestealsmp.runes;

import org.bukkit.ChatColor;
import org.bukkit.entity.EntityType;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class BadOmenRune extends AbstractRune {

    public static final String name = "&x&4&1&0&0&F&F&lB&x&4&D&0&0&F&F&la&x&5&9&0&0&F&F&ld &x&7&1&0&0&F&F&lO&x&7&D&0&0&F&F&lm&x&8&A&0&0&F&F&le&x&9&6&0&0&F&F&ln &x&A&E&0&0&F&F&lR&x&B&A&0&0&F&F&lu&x&C&6&0&0&F&F&ln&x&D&2&0&0&F&F&le";
    public static final EntityType mob = EntityType.VINDICATOR;
    public static final PotionEffect effect = new PotionEffect(PotionEffectType.BAD_OMEN, 200, 0);
    public static final PotionEffect effectII = new PotionEffect(PotionEffectType.BAD_OMEN, 200, 1);
    public static final PotionEffect effectIII = new PotionEffect(PotionEffectType.BAD_OMEN, 200, 2);
    public static final PotionEffect effectIV = new PotionEffect(PotionEffectType.BAD_OMEN, 200, 3);
    public static final PotionEffect effectV = new PotionEffect(PotionEffectType.BAD_OMEN, 200, 4);

    private static final String lore = ChatColor.LIGHT_PURPLE + "Grants permanent " + formatEffectKey(effect.getType().getKey().getKey()) + " " + formatAmplifier(effect.getAmplifier());

    public BadOmenRune() {
        super(name, mob, 1.0 / 120, lore, effect);
    }

    static class II extends AbstractRune {
        public II() {
            super(name, mob, 1.0 / 240, lore, effect);
        }
    }
}
