package newamazingpvp.lifestealsmp.runes;

import net.kyori.adventure.text.Component;
import org.bukkit.ChatColor;
import org.bukkit.entity.EntityType;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class HasteRune extends AbstractRune {

    private static final Component name = runeGradient("Haste Rune");
    private static final EntityType mob = EntityType.SILVERFISH;
    private static final PotionEffect effect = new PotionEffect(PotionEffectType.HASTE, 200, 0);
    private static final PotionEffect effectII = new PotionEffect(PotionEffectType.HASTE, 200, 1);

    private static final String lore = ChatColor.LIGHT_PURPLE + "Grants permanent " + formatEffectKey(effect.getType().getKey().getKey()) + " " + formatAmplifier(effect.getAmplifier());

    public HasteRune() {
        super(name,
                mob,
                1.0 / 500,
                lore,
                effect);
    }

    static class II extends AbstractRune {
        public II() {
            super(name.append(deserialize(" II")),
                    mob,
                    1.0 / 1000,
                    ChatColor.LIGHT_PURPLE + "Grants permanent " + formatEffectKey(effectII.getType().getKey().getKey()) + " " + formatAmplifier(effectII.getAmplifier()),
                    effectII);
        }
    }
}
