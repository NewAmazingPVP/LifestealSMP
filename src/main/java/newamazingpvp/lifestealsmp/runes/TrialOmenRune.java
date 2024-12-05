package newamazingpvp.lifestealsmp.runes;

import net.kyori.adventure.text.Component;
import org.bukkit.ChatColor;
import org.bukkit.entity.EntityType;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class TrialOmenRune extends AbstractRune {

    private static final Component name = runeGradient("Trial Omen Rune");
    private static final EntityType mob = EntityType.ZOMBIFIED_PIGLIN;
    private static final PotionEffect effect = new PotionEffect(PotionEffectType.TRIAL_OMEN, 200, 0);
    private static final PotionEffect effectII = new PotionEffect(PotionEffectType.TRIAL_OMEN, 200, 1);
    private static final PotionEffect effectIII = new PotionEffect(PotionEffectType.TRIAL_OMEN, 200, 2);
    private static final PotionEffect effectIV = new PotionEffect(PotionEffectType.TRIAL_OMEN, 200, 3);
    private static final PotionEffect effectV = new PotionEffect(PotionEffectType.TRIAL_OMEN, 200, 4);

    public TrialOmenRune() {
        super(name,
                mob,
                1.0 / 150,
                ChatColor.LIGHT_PURPLE + "Grants permanent random duration " + formatEffectKey(effect.getType().getKey().getKey()) + " " + formatAmplifier(effect.getAmplifier()), effect);
    }

    static class II extends AbstractRune {
        public II() {
            super(name.append(deserialize(" II")),
                    mob,
                    1.0 / 300,
                    ChatColor.LIGHT_PURPLE + "Grants permanent random duration " + formatEffectKey(effectII.getType().getKey().getKey()) + " " + formatAmplifier(effectII.getAmplifier()), effectII);
        }
    }

    static class III extends AbstractRune {
        public III() {
            super(name.append(deserialize(" III")),
                    mob,
                    1.0 / 450,
                    ChatColor.LIGHT_PURPLE + "Grants permanent random duration " + formatEffectKey(effectIII.getType().getKey().getKey()) + " " + formatAmplifier(effectIII.getAmplifier()), effectIII);
        }
    }

    static class IV extends AbstractRune {
        public IV() {
            super(name.append(deserialize(" IV")),
                    mob,
                    1.0 / 600,
                    ChatColor.LIGHT_PURPLE + "Grants permanent random duration " + formatEffectKey(effectIV.getType().getKey().getKey()) + " " + formatAmplifier(effectIV.getAmplifier()), effectIV);
        }
    }

    static class V extends AbstractRune {
        public V() {
            super(name.append(deserialize(" V")),
                    mob,
                    1.0 / 750,
                    ChatColor.LIGHT_PURPLE + "Grants permanent random duration " + formatEffectKey(effectV.getType().getKey().getKey()) + " " + formatAmplifier(effectV.getAmplifier()), effectV);
        }
    }
}
