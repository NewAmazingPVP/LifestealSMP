package newamazingpvp.lifestealsmp.runes;

import org.bukkit.ChatColor;
import org.bukkit.Effect;
import org.bukkit.entity.Drowned;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.potion.Potion;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.potion.PotionEffectTypeCategory;

import java.util.ArrayList;
import java.util.List;

public class WaterRune extends AbstractRune {

    private static final String name = "Water Rune";
    private static final EntityType mob = EntityType.DROWNED;
    private static final PotionEffect effect = new PotionEffect(PotionEffectType.WATER_BREATHING, 100, 1);
    private static final String lore = ChatColor.LIGHT_PURPLE + "Grants permanent " + formatEffectKey(effect.getType().getKey().getKey()) + " " + effect.getAmplifier();
    public WaterRune() {
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
    public static String formatEffectKey(String effectKey) {
        String[] words = effectKey.split("_");
        StringBuilder formattedKey = new StringBuilder();

        for (String word : words) {
            if (word.length() > 0) {
                formattedKey.append(Character.toUpperCase(word.charAt(0)))
                        .append(word.substring(1).toLowerCase())
                        .append(" ");
            }
        }

        return formattedKey.toString().trim();
    }

}