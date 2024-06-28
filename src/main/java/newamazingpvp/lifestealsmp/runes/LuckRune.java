package newamazingpvp.lifestealsmp.runes;

import org.bukkit.ChatColor;
import org.bukkit.entity.EntityType;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class LuckRune extends AbstractRune {

    private static final String name = "&x&4&1&0&0&F&F&lL&x&5&1&0&0&F&F&lu&x&6&1&0&0&F&F&lc&x&7&1&0&0&F&F&lk &x&8&1&0&0&F&F&lR&x&9&2&0&0&F&F&lu&x&A&2&0&0&F&F&ln&x&B&2&0&0&F&F&le";
    private static final EntityType mob = EntityType.EVOKER;
    private static final PotionEffect effect = new PotionEffect(PotionEffectType.LUCK, 200, 0);
    private static final String lore = ChatColor.LIGHT_PURPLE + "Grants permanent " + formatEffectKey(effect.getType().getKey().getKey()) + " " + formatAmplifier(effect.getAmplifier());

    public LuckRune() {
        super(name, mob, 1.0/6, lore, effect);
    }



}
