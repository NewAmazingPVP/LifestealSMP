package newamazingpvp.lifestealsmp.runes;

import org.bukkit.ChatColor;
import org.bukkit.entity.EntityType;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class InvisibilityRune extends AbstractRune {

    private static final String name = "&x&4&1&0&0&F&F&lI&x&5&1&0&0&F&F&ln&x&6&1&0&0&F&F&lv&x&7&1&0&0&F&F&li&x&8&1&0&0&F&F&ls&x&9&2&0&0&F&F&li&x&A&2&0&0&F&F&lb&x&B&2&0&0&F&F&li&x&C&2&0&0&F&F&ll&x&D&2&0&0&F&F&li&x&E&2&0&0&F&F&lt&x&F&2&0&0&F&F&ly &x&F&2&0&0&F&F&lR&x&F&2&0&0&F&F&lu&x&F&2&0&0&F&F&ln&x&F&2&0&0&F&F&le";
    private static final EntityType mob = EntityType.ENDERMAN;
    private static final PotionEffect effect = new PotionEffect(PotionEffectType.INVISIBILITY, 200, 0);
    private static final String lore = ChatColor.LIGHT_PURPLE + "Grants permanent " + formatEffectKey(effect.getType().getKey().getKey()) + " " + formatAmplifier(effect.getAmplifier());

    public InvisibilityRune() {
        super(name, mob, 1.0/1, lore, effect);
    }



}
