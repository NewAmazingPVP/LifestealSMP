package newamazingpvp.lifestealsmp.runes;

import org.bukkit.ChatColor;
import org.bukkit.entity.EntityType;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class DolphinsGraceRune extends AbstractRune {

    private static final String name = "&x&4&1&0&0&F&F&lD&x&5&1&0&0&F&F&lo&x&6&1&0&0&F&F&ll&x&7&1&0&0&F&F&lp&x&8&1&0&0&F&F&lh&x&9&2&0&0&F&F&li&x&A&2&0&0&F&F&ln&x&B&2&0&0&F&F&ls &x&C&2&0&0&F&F&lG&x&D&2&0&0&F&F&lr&x&E&2&0&0&F&F&la&x&F&2&0&0&F&F&lc&x&F&2&0&0&F&F&le &x&F&2&0&0&F&F&lR&x&F&2&0&0&F&F&lu&x&F&2&0&0&F&F&ln&x&F&2&0&0&F&F&le";
    private static final EntityType mob = EntityType.GUARDIAN;
    private static final PotionEffect effect = new PotionEffect(PotionEffectType.DOLPHINS_GRACE, 200, 0);
    private static final String lore = ChatColor.LIGHT_PURPLE + "Grants permanent " + formatEffectKey(effect.getType().getKey().getKey()) + " " + formatAmplifier(effect.getAmplifier());

    public DolphinsGraceRune() {
        super(name, mob, 1.0 / 50, lore, effect);
    }


}
