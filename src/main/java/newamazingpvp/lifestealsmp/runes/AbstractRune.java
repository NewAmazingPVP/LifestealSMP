package newamazingpvp.lifestealsmp.runes;

import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.potion.PotionEffect;

import java.util.List;

public abstract class AbstractRune implements Rune {
    private final String name;
    private final EntityType mob;
    private final double dropRate;
    private final String lore;
    private final PotionEffect effect;

    public AbstractRune(String name, EntityType mob, double dropRate, String lore, PotionEffect effect) {
        this.name = name;
        this.mob = mob;
        this.dropRate = dropRate;
        this.lore = lore;
        this.effect = effect;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public EntityType getMob() {
        return mob;
    }

    @Override
    public double getDropRate() {
        return dropRate;
    }

    @Override
    public String getLore(){
        return lore;
    }

    @Override
    public PotionEffect getEffect(){
        return effect;
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

    public static String formatAmplifier(int amplifier){
        switch (amplifier) {
            case (0):
                return "I";
            case (1):
                return "II";
            case (2):
                return "III";
            case (3):
                return "IV";
            case (4):
                return "V";
            case (5):
                return "VI";
        }
        return "";
    }
}
