package newamazingpvp.lifestealsmp.runes;

import org.bukkit.ChatColor;
import org.bukkit.entity.EntityType;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class JumpBoostRune extends AbstractRune {

    private static final String name = "&x&4&1&0&0&F&F&lJ&x&5&1&0&0&F&F&lu&x&6&1&0&0&F&F&lm&x&7&1&0&0&F&F&lp &x&8&1&0&0&F&F&lB&x&9&2&0&0&F&F&lo&x&A&2&0&0&F&F&lo&x&B&2&0&0&F&F&ls&x&C&2&0&0&F&F&lt &x&D&2&0&0&F&F&lR&x&E&2&0&0&F&F&lu&x&F&2&0&0&F&F&ln&x&F&2&0&0&F&F&le";
    private static final EntityType mob = EntityType.SLIME;
    private static final PotionEffect effect = new PotionEffect(PotionEffectType.JUMP_BOOST, 200, 0);
    private static final String lore = ChatColor.LIGHT_PURPLE + "Grants permanent " + formatEffectKey(effect.getType().getKey().getKey()) + " " + formatAmplifier(effect.getAmplifier());

    public JumpBoostRune() {
        super(name, mob, 1.0/500, lore, effect);
    }



}
