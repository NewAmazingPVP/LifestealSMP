package newamazingpvp.lifestealsmp.runes;

import net.kyori.adventure.text.Component;
import org.bukkit.ChatColor;
import org.bukkit.entity.EntityType;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class SaturationRune extends AbstractRune {

    private static final Component name = runeGradient("Saturation Rune");
    private static final EntityType mob = EntityType.HOGLIN;
    private static final PotionEffect effect = new PotionEffect(PotionEffectType.SATURATION, 1, 0);
    private static final String lore = ChatColor.LIGHT_PURPLE + "Grants permanent random duration " + formatEffectKey(effect.getType().getKey().getKey()) + " " + formatAmplifier(effect.getAmplifier());

    public SaturationRune() {
        super(name, mob, 1.0 / 300, lore, effect);
    }


}
