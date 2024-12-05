package newamazingpvp.lifestealsmp.runes;

import net.kyori.adventure.text.Component;
import org.bukkit.ChatColor;
import org.bukkit.entity.EntityType;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;


public class StrengthRune extends AbstractRune {

    private static final Component name = runeGradient("Strength Rune");
    private static final EntityType mob = EntityType.PIGLIN_BRUTE;
    private static final PotionEffect effect = new PotionEffect(PotionEffectType.STRENGTH, 200, 0);
    private static final PotionEffect effectII = new PotionEffect(PotionEffectType.STRENGTH, 200, 1);
    private static final String lore = ChatColor.LIGHT_PURPLE + "Grants permanent random duration " + formatEffectKey(effect.getType().getKey().getKey()) + " " + formatAmplifier(effect.getAmplifier());

    public StrengthRune() {
        super(name,
                mob,
                1.0 / 200,
                lore,
                effect);
    }

    static class II extends AbstractRune {
        public II() {
            super(name.append(deserialize(" II")),
                    mob,
                    1.0 / 400,
                    ChatColor.LIGHT_PURPLE + "Grants permanent random duration " + formatEffectKey(effectII.getType().getKey().getKey()) + " " + formatAmplifier(effectII.getAmplifier()),
                    effectII);
        }
    }
}
