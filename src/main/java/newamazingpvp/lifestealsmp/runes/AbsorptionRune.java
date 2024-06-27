package newamazingpvp.lifestealsmp.runes;

import org.bukkit.ChatColor;
import org.bukkit.entity.EntityType;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import static newamazingpvp.lifestealsmp.runes.AbsorptionRune.effectII;
import static newamazingpvp.lifestealsmp.runes.AbstractRune.formatEffectKey;

public class AbsorptionRune extends AbstractRune {

    private static final PotionEffect effect = new PotionEffect(PotionEffectType.ABSORPTION, 200, 0);
    public static final PotionEffect effectII = new PotionEffect(PotionEffectType.ABSORPTION, 200, 1);
    public static final PotionEffect effectIII = new PotionEffect(PotionEffectType.ABSORPTION, 200, 1);
    public static final PotionEffect effectIV = new PotionEffect(PotionEffectType.ABSORPTION, 200, 1);


    public AbsorptionRune() {
        super("&x&4&1&0&0&F&F&lA&x&5&1&0&0&F&F&lb&x&6&1&0&0&F&F&ls&x&7&1&0&0&F&F&lo&x&8&1&0&0&F&F&lr&x&9&2&0&0&F&F&lp&x&A&2&0&0&F&F&lt&x&B&2&0&0&F&F&li&x&C&2&0&0&F&F&lo&x&D&2&0&0&F&F&ln I &x&E&2&0&0&F&F&lR&x&F&2&0&0&F&F&lu&x&F&2&0&0&F&F&ln&x&F&2&0&0&F&F&le",
                EntityType.ELDER_GUARDIAN,
                1.0/1,
                ChatColor.LIGHT_PURPLE + "Grants permanent " + formatEffectKey(effect.getType().getKey().getKey()) + " " + formatAmplifier(effect.getAmplifier()),
                effect);
    }
     static class II extends AbstractRune {
        public II() {
            super("&x&4&1&0&0&F&F&lA&x&5&1&0&0&F&F&lb&x&6&1&0&0&F&F&ls&x&7&1&0&0&F&F&lo&x&8&1&0&0&F&F&lr&x&9&2&0&0&F&F&lp&x&A&2&0&0&F&F&lt&x&B&2&0&0&F&F&li&x&C&2&0&0&F&F&lo&x&D&2&0&0&F&F&ln II &x&E&2&0&0&F&F&lR&x&F&2&0&0&F&F&lu&x&F&2&0&0&F&F&ln&x&F&2&0&0&F&F&le",
                    EntityType.ELDER_GUARDIAN,
                    1.0/1,
                    ChatColor.LIGHT_PURPLE + "Grants permanent " + formatEffectKey(effectII.getType().getKey().getKey()) + " " + formatAmplifier(effectII.getAmplifier()),
                    effectII);
        }
    }


}

