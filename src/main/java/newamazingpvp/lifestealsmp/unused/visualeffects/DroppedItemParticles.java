package newamazingpvp.lifestealsmp.unused.visualeffects;

import io.papermc.paper.event.entity.EntityMoveEvent;
import org.bukkit.Bukkit;
import org.bukkit.Color;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Item;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.inventory.ItemStack;


public class DroppedItemParticles implements Listener {


    @EventHandler
    public void entityMove(EntityMoveEvent event) {

        Entity e = event.getEntity();
        if (e instanceof Item) {
            Item item = (Item) e;
            ItemStack itemStack = item.getItemStack();
            Material itemType = itemStack.getType();
            Location entityLocation = e.getLocation();


            if (itemType == Material.EMERALD) {
                spawnParticlesOnItem(e, entityLocation, Color.GREEN, 2.0f);
            }


        }

    }


    public static void spawnParticlesOnItem(Entity itemEntity, Location location, Color color, Float size) {

        for (Player player : Bukkit.getOnlinePlayers()) {
            //player.getWorld().spawnParticle(Particle.REDSTONE, location, 0, new Particle.DustOptions(color, size));

        }
    }


}




