package newamazingpvp.lifestealsmp.runes;

import org.bukkit.ChatColor;
import org.bukkit.entity.EntityType;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class RaidOmenRune extends AbstractRune {

    private static final String name = "&x&4&1&0&0&F&F&lR&x&4&C&0&0&F&F&la&x&5&7&0&0&F&F&li&x&6&2&0&0&F&F&ld &x&7&9&0&0&F&F&lO&x&8&4&0&0&F&F&lm&x&8&F&0&0&F&F&le&x&9&A&0&0&F&F&ln &x&B&1&0&0&F&F&lR&x&B&C&0&0&F&F&lu&x&C&7&0&0&F&F&ln&x&D&2&0&0&F&F&le";
    private static final EntityType mob = EntityType.EVOKER;
    private static final PotionEffect effect = new PotionEffect(PotionEffectType.RAID_OMEN, 200, 0);
    private static final PotionEffect effectII = new PotionEffect(PotionEffectType.RAID_OMEN, 200, 1);
    private static final PotionEffect effectIII = new PotionEffect(PotionEffectType.RAID_OMEN, 200, 2);
    private static final PotionEffect effectIV = new PotionEffect(PotionEffectType.RAID_OMEN, 200, 3);
    private static final PotionEffect effectV = new PotionEffect(PotionEffectType.RAID_OMEN, 200, 4);
    private static final String lore = ChatColor.LIGHT_PURPLE + "Grants permanent " + formatEffectKey(effect.getType().getKey().getKey()) + " " + formatAmplifier(effect.getAmplifier());

    public RaidOmenRune() {
        super(name, mob, 1.0/100, lore, effect);
    }


}
