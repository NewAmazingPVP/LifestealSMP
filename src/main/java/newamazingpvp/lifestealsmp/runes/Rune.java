package newamazingpvp.lifestealsmp.runes;

import org.bukkit.entity.EntityType;
import org.bukkit.potion.PotionEffect;

public interface Rune {

    String getName();

    EntityType getMob();

    double getDropRate();

    String getLore();

    PotionEffect getEffect();
}
