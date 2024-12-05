package newamazingpvp.lifestealsmp.runes;

import net.kyori.adventure.text.Component;
import org.bukkit.ChatColor;
import org.bukkit.entity.EntityType;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class FireResistanceRune extends AbstractRune {

    private static final Component name = runeGradient("Fire Resistance Rune");
    private static final EntityType mob = EntityType.BLAZE;
    private static final PotionEffect effect = new PotionEffect(PotionEffectType.FIRE_RESISTANCE, 200, 0);
    private static final String lore = ChatColor.LIGHT_PURPLE + "Grants permanent random duration " + formatEffectKey(effect.getType().getKey().getKey()) + " " + formatAmplifier(effect.getAmplifier());

    public FireResistanceRune() {
        super(name, mob, 1.0 / 600, lore, effect);
    }


}
