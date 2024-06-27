package newamazingpvp.lifestealsmp.runes;

import org.bukkit.ChatColor;
import org.bukkit.entity.EntityType;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class BadOmenRune extends AbstractRune {

    private static final String name = "&x&4&1&0&0&F&F&lB&x&4&D&0&0&F&F&la&x&5&9&0&0&F&F&ld &x&7&1&0&0&F&F&lO&x&7&D&0&0&F&F&lm&x&8&A&0&0&F&F&le&x&9&6&0&0&F&F&ln &x&A&E&0&0&F&F&lR&x&B&A&0&0&F&F&lu&x&C&6&0&0&F&F&ln&x&D&2&0&0&F&F&le";
    private static final EntityType mob = EntityType.VEX;
    private static final PotionEffect effect = new PotionEffect(PotionEffectType.BAD_OMEN, 200, 0);
    private static final String lore = ChatColor.LIGHT_PURPLE + "Grants permanent " + formatEffectKey(effect.getType().getKey().getKey()) + " " + formatAmplifier(effect.getAmplifier());

    public BadOmenRune() {
        super(name, mob, 1.0/1, lore, effect);
    }


}
