package newamazingpvp.lifestealsmp.runes;

import org.bukkit.ChatColor;
import org.bukkit.entity.EntityType;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class TrialOmenRune extends AbstractRune {

    private static final String name = "&x&4&1&0&0&F&F&lT&x&4&B&0&0&F&F&lr&x&5&6&0&0&F&F&li&x&6&0&0&0&F&F&la&x&6&A&0&0&F&F&ll &x&7&F&0&0&F&F&lO&x&8&A&0&0&F&F&lm&x&9&4&0&0&F&F&le&x&9&E&0&0&F&F&ln &x&B&3&0&0&F&F&lR&x&B&D&0&0&F&F&lu&x&C&8&0&0&F&F&ln&x&D&2&0&0&F&F&le";
    private static final EntityType mob = EntityType.ZOMBIFIED_PIGLIN;
    private static final PotionEffect effect = new PotionEffect(PotionEffectType.TRIAL_OMEN, 200, 0);
    private static final PotionEffect effectII = new PotionEffect(PotionEffectType.TRIAL_OMEN, 200, 1);
    private static final PotionEffect effectIII = new PotionEffect(PotionEffectType.TRIAL_OMEN, 200, 2);
    private static final PotionEffect effectIV = new PotionEffect(PotionEffectType.TRIAL_OMEN, 200, 3);
    private static final PotionEffect effectV = new PotionEffect(PotionEffectType.TRIAL_OMEN, 200, 4);

    private static final String lore = ChatColor.LIGHT_PURPLE + "Grants permanent " + formatEffectKey(effect.getType().getKey().getKey()) + " " + formatAmplifier(effect.getAmplifier());

    public TrialOmenRune() {
        super(name, mob, 1.0/150, lore, effect);
    }


}
