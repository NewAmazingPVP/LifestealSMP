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
}
