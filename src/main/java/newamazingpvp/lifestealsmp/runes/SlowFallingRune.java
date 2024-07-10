package newamazingpvp.lifestealsmp.runes;

import net.kyori.adventure.text.Component;
import org.bukkit.ChatColor;
import org.bukkit.entity.EntityType;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class SlowFallingRune extends AbstractRune {

    private static final Component name = runeGradient("Slow Falling Rune");
    private static final EntityType mob = EntityType.PHANTOM;
    private static final PotionEffect effect = new PotionEffect(PotionEffectType.SLOW_FALLING, 200, 0);
    private static final String lore = ChatColor.LIGHT_PURPLE + "Grants permanent " + formatEffectKey(effect.getType().getKey().getKey()) + " " + formatAmplifier(effect.getAmplifier());

    public SlowFallingRune() {
        super(name, mob, 1.0 / 75, lore, effect);
    }


}
