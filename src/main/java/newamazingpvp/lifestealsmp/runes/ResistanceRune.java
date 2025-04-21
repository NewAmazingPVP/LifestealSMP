package newamazingpvp.lifestealsmp.runes;

import net.kyori.adventure.text.Component;
import org.bukkit.ChatColor;
import org.bukkit.entity.EntityType;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class ResistanceRune extends AbstractRune {

    private static final Component name = runeGradient("Resistance Rune");
    private static final EntityType mob = EntityType.WITHER_SKELETON;
    private static final PotionEffect effect = new PotionEffect(PotionEffectType.DAMAGE_RESISTANCE, 80, 0);
    //dont added lvl 2 too op
    private static final String lore = ChatColor.LIGHT_PURPLE + "Grants permanent random duration " + formatEffectKey(effect.getType().getKey().getKey()) + " " + formatAmplifier(effect.getAmplifier());

    public ResistanceRune() {
        super(name, mob, 1.0 / 1000, lore, effect);
    }


}
