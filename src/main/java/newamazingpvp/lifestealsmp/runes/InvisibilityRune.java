package newamazingpvp.lifestealsmp.runes;

import net.kyori.adventure.text.Component;
import org.bukkit.ChatColor;
import org.bukkit.entity.EntityType;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class InvisibilityRune extends AbstractRune {

    private static final Component name = runeGradient("Invisibility Rune");
    private static final EntityType mob = EntityType.ENDERMAN;
    private static final PotionEffect effect = new PotionEffect(PotionEffectType.INVISIBILITY, 200, 0);
    private static final String lore = ChatColor.LIGHT_PURPLE + "Grants permanent " + formatEffectKey(effect.getType().getKey().getKey()) + " " + formatAmplifier(effect.getAmplifier());

    public InvisibilityRune() {
        super(name, mob, 1.0 / 500, lore, effect);
    }


}
