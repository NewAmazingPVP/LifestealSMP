package newamazingpvp.lifestealsmp.runes;

import org.bukkit.ChatColor;
import org.bukkit.entity.EntityType;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class ResistanceRune extends AbstractRune {

    private static final String name = "&x&4&1&0&0&F&F&lR&x&5&1&0&0&F&F&le&x&6&1&0&0&F&F&ls&x&7&1&0&0&F&F&li&x&8&1&0&0&F&F&ls&x&9&2&0&0&F&F&lt&x&A&2&0&0&F&F&la&x&B&2&0&0&F&F&ln&x&C&2&0&0&F&F&lc&x&D&2&0&0&F&F&le &x&E&2&0&0&F&F&lR&x&F&2&0&0&F&F&lu&x&F&2&0&0&F&F&ln&x&F&2&0&0&F&F&le";
    private static final EntityType mob = EntityType.WITHER_SKELETON;
    private static final PotionEffect effect = new PotionEffect(PotionEffectType.RESISTANCE, 200, 0);
    //dont added lvl 2 too op
    private static final String lore = ChatColor.LIGHT_PURPLE + "Grants permanent " + formatEffectKey(effect.getType().getKey().getKey()) + " " + formatAmplifier(effect.getAmplifier());

    public ResistanceRune() {
        super(name, mob, 1.0 / 1000, lore, effect);
    }


}
