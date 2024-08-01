package newamazingpvp.lifestealsmp.unused.events.corruptedmobs.mobs.bomber.events;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.block.Block;
import org.bukkit.block.BlockFace;
import org.bukkit.entity.ArmorStand;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.inventory.ItemStack;
import org.bukkit.metadata.FixedMetadataValue;
import org.bukkit.metadata.MetadataValue;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.util.Vector;

import static newamazingpvp.lifestealsmp.LifestealSMP.lifestealSmp;

public class TntThrown {

    public static BukkitRunnable despawnTntThrownRunnable;


    public static void spawnBomberThrowable(Entity entity, Location loc, Vector lookVector) {


        loc.setY(loc.getY() + 1);
        World world = Bukkit.getWorlds().get(0); // Get the first loaded world
        ArmorStand armorStand = (ArmorStand) entity.getWorld().spawnEntity(loc, EntityType.ARMOR_STAND);
        armorStand.setVisible(false);
        armorStand.setSmall(true);
        armorStand.setInvulnerable(true);
        armorStand.setGravity(true);
        armorStand.getEquipment().setHelmet(new ItemStack(Material.TNT));
        String customTag = "bomber_thrown_tnt";
        MetadataValue customTagValue = new FixedMetadataValue(lifestealSmp, customTag);
        armorStand.setMetadata(customTag, customTagValue);

        Vector velocity = new Vector(0, 2, 0);
        armorStand.setVelocity(velocity);
        armorStand.setVelocity(lookVector);


        despawnTntThrownRunnable = new BukkitRunnable() {
            @Override
            public void run() {

                if (armorStand.isDead()) {
                    this.cancel();
                    return;
                }

                Location loc = armorStand.getLocation();
                Block blockBelow = loc.getBlock().getRelative(BlockFace.DOWN);
                if (!blockBelow.getType().equals(Material.AIR)) {
                    armorStand.remove();
                }


            }
        };
        despawnTntThrownRunnable.runTaskTimer(lifestealSmp, 0L, 80L); // Start immediately and repeat every second


    }


}
