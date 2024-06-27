package newamazingpvp.lifestealsmp.runes;

import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.potion.PotionEffect;

import java.util.List;

public interface Rune {

    String getName();

    EntityType getMob();

    double getDropRate();

    String getLore();

    PotionEffect getEffect();
}
