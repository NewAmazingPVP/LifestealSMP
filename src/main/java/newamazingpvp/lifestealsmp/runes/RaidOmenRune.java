package newamazingpvp.lifestealsmp.runes;

import net.kyori.adventure.text.Component;
import org.bukkit.ChatColor;
import org.bukkit.entity.EntityType;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class RaidOmenRune extends AbstractRune {

    private static final Component name = runeGradient("Raid Omen Rune");
    private static final EntityType mob = EntityType.EVOKER;
    private static final PotionEffect effect = new PotionEffect(PotionEffectType.RAID_OMEN, 200, 0);
    private static final PotionEffect effectII = new PotionEffect(PotionEffectType.RAID_OMEN, 200, 1);
    private static final PotionEffect effectIII = new PotionEffect(PotionEffectType.RAID_OMEN, 200, 2);
    private static final PotionEffect effectIV = new PotionEffect(PotionEffectType.RAID_OMEN, 200, 3);
    private static final PotionEffect effectV = new PotionEffect(PotionEffectType.RAID_OMEN, 200, 4);

    private static final String lore = ChatColor.LIGHT_PURPLE + "Grants permanent " + formatEffectKey(effect.getType().getKey().getKey()) + " " + formatAmplifier(effect.getAmplifier());

    public RaidOmenRune() {
        super(name,
                mob,
                1.0 / 100,
                lore,
                effect);
    }

    static class II extends AbstractRune {
        public II() {
            super(name.append(deserialize(" II")),
                    mob,
                    1.0 / 200,
                    ChatColor.LIGHT_PURPLE + "Grants permanent " + formatEffectKey(effectII.getType().getKey().getKey()) + " " + formatAmplifier(effectII.getAmplifier()),
                    effectII);
        }
    }

    static class III extends AbstractRune {
        public III() {
            super(name.append(deserialize(" III")),
                    mob,
                    1.0 / 300,
                    ChatColor.LIGHT_PURPLE + "Grants permanent " + formatEffectKey(effectIII.getType().getKey().getKey()) + " " + formatAmplifier(effectIII.getAmplifier()),
                    effectIII);
        }
    }

    static class IV extends AbstractRune {
        public IV() {
            super(name.append(deserialize(" IV")),
                    mob,
                    1.0 / 400,
                    ChatColor.LIGHT_PURPLE + "Grants permanent " + formatEffectKey(effectIV.getType().getKey().getKey()) + " " + formatAmplifier(effectIV.getAmplifier()),
                    effectIV);
        }
    }

    static class V extends AbstractRune {
        public V() {
            super(name.append(deserialize(" V")),
                    mob,
                    1.0 / 500,
                    ChatColor.LIGHT_PURPLE + "Grants permanent " + formatEffectKey(effectV.getType().getKey().getKey()) + " " + formatAmplifier(effectV.getAmplifier()),
                    effectV);
        }
    }
}
