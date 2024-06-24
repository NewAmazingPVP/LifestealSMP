package newamazingpvp.lifestealsmp.custommobs.mobs.shadow;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.entity.ArmorStand;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.plugin.Plugin;

import java.util.HashMap;
import java.util.UUID;

import static newamazingpvp.lifestealsmp.LifestealSMP.lifestealSmp;

public class ShadowMobEffects {


    private static final HashMap<Entity, ArmorStand> armorStands = new HashMap<>();

    public static void spawnArmorStandAroundShadow(Entity entity, Location location) {
        for (int i = 0; i < 4; i++) {
            World world = Bukkit.getWorlds().get(0); // Get the first loaded world
            ArmorStand armorStand = (ArmorStand) entity.getWorld().spawnEntity(location, EntityType.ARMOR_STAND);
            armorStand.setVisible(true);
            armorStand.setSmall(false);

            armorStands.put(entity, armorStand);



            if(i==0) {
                Bukkit.getScheduler().runTaskTimer(lifestealSmp, () -> {
                    Entity centerEntity = entity;

                    Location playerLoc = entity.getLocation();
                    Location armorStandLoc = playerLoc.clone().add(1, 0, 1); // Adjust the distance as needed
                    armorStandLoc.setY(playerLoc.getY()); // Keep the ArmorStand at the same height as the player
                    armorStand.teleport(armorStandLoc);

                }, 20L, 5L); // Adjust the interval as needed
            }

            if(i==1) {
                Bukkit.getScheduler().runTaskTimer(lifestealSmp, () -> {
                    Entity centerEntity = entity;

                    Location playerLoc = entity.getLocation();
                    Location armorStandLoc = playerLoc.clone().add(-1, 0, -1); // Adjust the distance as needed
                    armorStandLoc.setY(playerLoc.getY()); // Keep the ArmorStand at the same height as the player
                    armorStand.teleport(armorStandLoc);

                }, 20L, 5L); // Adjust the interval as needed
            }

            if(i==2) {
                Bukkit.getScheduler().runTaskTimer(lifestealSmp, () -> {
                    Entity centerEntity = entity;

                    Location playerLoc = entity.getLocation();
                    Location armorStandLoc = playerLoc.clone().add(-1, 0, 1); // Adjust the distance as needed
                    armorStandLoc.setY(playerLoc.getY()); // Keep the ArmorStand at the same height as the player
                    armorStand.teleport(armorStandLoc);

                }, 20L, 5L); // Adjust the interval as needed
            }

            if(i==3) {
                Bukkit.getScheduler().runTaskTimer(lifestealSmp, () -> {
                    Entity centerEntity = entity;

                    Location playerLoc = entity.getLocation();
                    Location armorStandLoc = playerLoc.clone().add(1, 0, -1); // Adjust the distance as needed
                    armorStandLoc.setY(playerLoc.getY()); // Keep the ArmorStand at the same height as the player
                    armorStand.teleport(armorStandLoc);

                }, 20L, 5L); // Adjust the interval as needed
            }


        }

    }








    /*private void spawnAndAttachArmorStand(Entity entity, World world, Location spawnLoc) {
        // Create and spawn the ArmorStand
        ArmorStand armorStand = (ArmorStand) entity.getWorld().spawnEntity(spawnLoc, EntityType.ARMOR_STAND);
        armorStand.setVisible(true); // Make the ArmorStand visible
        armorStand.setSmall(true); // Optional: Makes the ArmorStand smaller

        // Attach the ArmorStand to the player
        armorStand.setPassenger(entity);

        // Schedule the ArmorStand to spin around the player
        Bukkit.getScheduler().runTaskTimer((Plugin) this, () -> {
            double radius = 1; // Distance from the player
            Location playerLoc = entity.getLocation();
            Location armorStandLoc = playerLoc.clone().add(radius, 0, radius);
            armorStand.setRotation(armorStandLoc.getYaw(), armorStandLoc.getPitch());
        }, 20L, 1L); // Adjust the interval as needed
    }*/

}
