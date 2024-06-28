package newamazingpvp.lifestealsmp.runes;

import org.bukkit.ChatColor;
import org.bukkit.entity.EntityType;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class RegenerationRune extends AbstractRune {

    private static final String name = "&x&4&1&0&0&F&F&lR&x&5&1&0&0&F&F&le&x&6&1&0&0&F&F&lg&x&7&1&0&0&F&F&le&x&8&1&0&0&F&F&ln&x&9&2&0&0&F&F&le&x&A&2&0&0&F&F&lr&x&B&2&0&0&F&F&la&x&C&2&0&0&F&F&lt&x&D&2&0&0&F&F&li&x&E&2&0&0&F&F&lo&x&F&2&0&0&F&F&ln &x&F&2&0&0&F&F&lR&x&F&2&0&0&F&F&lu&x&F&2&0&0&F&F&ln&x&F&2&0&0&F&F&le";
    private static final EntityType mob = EntityType.GHAST;
    private static final PotionEffect effect = new PotionEffect(PotionEffectType.REGENERATION, 200, 0);
    private static final String lore = ChatColor.LIGHT_PURPLE + "Grants permanent " + formatEffectKey(effect.getType().getKey().getKey()) + " " + formatAmplifier(effect.getAmplifier());

    public RegenerationRune() {
        super(name, mob, 1.0/15, lore, effect);
    }

}
