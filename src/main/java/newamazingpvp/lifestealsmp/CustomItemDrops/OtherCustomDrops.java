package newamazingpvp.lifestealsmp.CustomItemDrops;

import org.bukkit.Location;
import org.bukkit.entity.EnderDragon;
import org.bukkit.event.EventHandler;
import org.bukkit.event.entity.EntityDeathEvent;

import java.util.EventListener;

import static newamazingpvp.lifestealsmp.game.CustomRecipe.ancientSpellScroll;

public class OtherCustomDrops implements EventListener {

    @EventHandler
    public void onPlayerKill(EntityDeathEvent e) {

        Location loc = e.getEntity().getLocation();

        if (e.getEntity() instanceof EnderDragon) {
            e.getDrops().add(ancientSpellScroll());


        }
    }
}
