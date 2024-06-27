package newamazingpvp.lifestealsmp.runes;

import org.bukkit.ChatColor;
import org.bukkit.entity.EntityType;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class BadOmenRune extends AbstractRune {

    private static final String name = "&x&4&1&0&0&F&F&lB&x&5&1&0&0&F&F&la&x&6&1&0&0&F&F&ld &x&7&1&0&0&F&F&O&x&8&1&0&0&F&F&ml&x&9&2&0&0&F&F&mi&x&A&2&0&0&F&F&mm &x&B&2&0&0&F&F&ml &x&C&2&0&0&F&F&mr &x&D&2&0&0&F&F&mo &x&E&2&0&0&F&F&me &x&F&2&0&0&F&F&mn &x&F&2&0&0&F&F&mt &x&F&2&0&0&F&F&mo";
    private static final EntityType mob = EntityType.VEX;
    private static final PotionEffect effect = new PotionEffect(PotionEffectType.BAD_OMEN, 200, 1);
    private static final String lore = ChatColor.LIGHT_PURPLE + "Grants permanent " + formatEffectKey(effect.getType().getKey().getKey()) + " " + effect.getAmplifier();

    public BadOmenRune() {
        super(name, mob, 1.0/1, lore, effect);
    }


}
