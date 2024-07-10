package newamazingpvp.lifestealsmp.runes;

import net.kyori.adventure.text.Component;
import org.bukkit.ChatColor;
import org.bukkit.entity.EntityType;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class HealthBoostRune extends AbstractRune {

    private static final Component name = runeGradient("Health Boost Rune");
    private static final EntityType mob = EntityType.WITHER;
    private static final PotionEffect effect = new PotionEffect(PotionEffectType.HEALTH_BOOST, 200, 0);
    private static final String lore = ChatColor.LIGHT_PURPLE + "Grants permanent " + formatEffectKey(effect.getType().getKey().getKey()) + " " + formatAmplifier(effect.getAmplifier());

    public HealthBoostRune() {
        super(name, mob, 1.0 / 10, lore, effect);
    }


}
