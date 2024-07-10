package newamazingpvp.lifestealsmp.runes;

import net.kyori.adventure.text.Component;
import org.bukkit.ChatColor;
import org.bukkit.entity.EntityType;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class DolphinsGraceRune extends AbstractRune {

    private static final Component name = runeGradient("Dolphins Grace Rune");
    private static final EntityType mob = EntityType.GUARDIAN;
    private static final PotionEffect effect = new PotionEffect(PotionEffectType.DOLPHINS_GRACE, 80, 0);
    private static final String lore = ChatColor.LIGHT_PURPLE + "Grants permanent " + formatEffectKey(effect.getType().getKey().getKey()) + " " + formatAmplifier(effect.getAmplifier());

    public DolphinsGraceRune() {
        super(name, mob, 1.0 / 50, lore, effect);
    }


}
