package newamazingpvp.lifestealsmp.runes;

import org.bukkit.ChatColor;
import org.bukkit.entity.EntityType;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class HasteRune extends AbstractRune {

    private static final String name = "&x&4&1&0&0&F&F&lH&x&5&1&0&0&F&F&la&x&6&1&0&0&F&F&ls&x&7&1&0&0&F&F&lt&x&8&1&0&0&F&F&le &x&A&2&0&0&F&F&lR&x&B&2&0&0&F&F&lu&x&C&2&0&0&F&F&ln&x&D&2&0&0&F&F&le";
    private static final EntityType mob = EntityType.SILVERFISH;
    private static final PotionEffect effect = new PotionEffect(PotionEffectType.HASTE, 200, 1);
    private static final String lore = ChatColor.LIGHT_PURPLE + "Grants permanent " + formatEffectKey(effect.getType().getKey().getKey()) + " " + effect.getAmplifier();

    public HasteRune() {
        super(name, mob, 1.0/1, lore, effect);
    }

    @Override
    public PotionEffect getEffect() {
        return effect;
    }

    @Override
    public String getLore() {
        return lore;
    }

}
