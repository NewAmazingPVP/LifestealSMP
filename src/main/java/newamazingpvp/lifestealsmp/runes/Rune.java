package newamazingpvp.lifestealsmp.runes;

import net.kyori.adventure.text.Component;
import org.bukkit.entity.EntityType;
import org.bukkit.potion.PotionEffect;

public interface Rune {

    Component getName();

    EntityType getMob();

    double getDropRate();

    String getLore();

    PotionEffect getEffect();
}
