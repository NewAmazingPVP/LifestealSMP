package newamazingpvp.lifestealsmp.runes;

import org.bukkit.ChatColor;
import org.bukkit.entity.EntityType;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class HeroOfTheVillageRune extends AbstractRune {

    private static final String name = "&x&4&1&0&0&F&F&lH&x&5&1&0&0&F&F&le&x&6&1&0&0&F&F&lr&x&7&1&0&0&F&F&lo o&x&8&1&0&0&F&F&lf &x&9&2&0&0&F&F&lt&x&A&2&0&0&F&F&lh&x&B&2&0&0&F&F&le &x&C&2&0&0&F&F&lV&x&D&2&0&0&F&F&li&x&E&2&0&0&F&F&ll&x&F&2&0&0&F&F&la&x&F&2&0&0&F&F&lg&x&F&2&0&0&F&F&le &x&F&2&0&0&F&F&lR&x&F&2&0&0&F&F&lu&x&F&2&0&0&F&F&ln&x&F&2&0&0&F&F&le";
    private static final EntityType mob = EntityType.RAVAGER;
    private static final PotionEffect effect = new PotionEffect(PotionEffectType.HERO_OF_THE_VILLAGE, 200, 0);
    private static final PotionEffect effectII = new PotionEffect(PotionEffectType.HERO_OF_THE_VILLAGE, 200, 1);
    private static final PotionEffect effectIII = new PotionEffect(PotionEffectType.HERO_OF_THE_VILLAGE, 200, 2);
    private static final PotionEffect effectIV = new PotionEffect(PotionEffectType.HERO_OF_THE_VILLAGE, 200, 3);
    private static final PotionEffect effectV = new PotionEffect(PotionEffectType.HERO_OF_THE_VILLAGE, 200, 4);

    private static final String lore = ChatColor.LIGHT_PURPLE + "Grants permanent " + formatEffectKey(effect.getType().getKey().getKey()) + " " + formatAmplifier(effect.getAmplifier());

    public HeroOfTheVillageRune() {
        super(name, mob, 1.0 / 50, lore, effect);
    }


}
