package newamazingpvp.lifestealsmp.RaffleEvent.RaffleCustomMobs.Bomber.BomberEvents;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.entity.ArmorStand;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.inventory.ItemStack;
import org.bukkit.metadata.FixedMetadataValue;
import org.bukkit.metadata.MetadataValue;
import org.bukkit.util.Vector;

import static newamazingpvp.lifestealsmp.LifestealSMP.lifestealSmp;

public class thrownTNTEntityListener implements Listener {


    public static void spawnBomberThrowable(Entity entity, Location loc, Vector lookVector) {


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

        Vector velocity = new Vector(0, 1, 0);
        armorStand.setVelocity(velocity);
        armorStand.setVelocity(lookVector);


    }




}
