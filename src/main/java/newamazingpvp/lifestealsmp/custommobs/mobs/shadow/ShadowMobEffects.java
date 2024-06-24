package newamazingpvp.lifestealsmp.custommobs.mobs.shadow;

import org.bukkit.*;
import org.bukkit.entity.ArmorStand;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.SkullMeta;
import org.bukkit.plugin.Plugin;
import org.bukkit.profile.PlayerProfile;

import java.util.HashMap;
import java.util.UUID;

import static newamazingpvp.lifestealsmp.LifestealSMP.lifestealSmp;
import static newamazingpvp.lifestealsmp.custommobs.PublicMobMethods.getProfile;

public class ShadowMobEffects {


    private static final HashMap<Entity, ArmorStand> armorStands = new HashMap<>();

    public static void spawnArmorStandAroundShadow(Entity entity, Location location) {
        for (int i = 0; i < 4; i++) {
            World world = Bukkit.getWorlds().get(0); // Get the first loaded world
            ArmorStand armorStand = (ArmorStand) entity.getWorld().spawnEntity(location, EntityType.ARMOR_STAND);
            armorStand.setVisible(false);
            armorStand.setSmall(false);
            armorStand.getEquipment().setHelmet(shadowOuterHead());

            //armorStands.put(entity, armorStand);


            int finalI = i;
            Bukkit.getScheduler().runTaskTimer(lifestealSmp, () -> {
                if (finalI == 0) {


                    Location playerLoc = entity.getLocation();
                    Location armorStandLoc = playerLoc.clone().add(1, 0, 1); // Adjust the distance as needed
                    armorStandLoc.setY(playerLoc.getY()); // Keep the ArmorStand at the same height as the player
                    armorStand.teleport(armorStandLoc);


                }

                if (finalI == 1) {


                    Location playerLoc = entity.getLocation();
                    Location armorStandLoc = playerLoc.clone().add(-1, 0, -1); // Adjust the distance as needed
                    armorStandLoc.setY(playerLoc.getY()); // Keep the ArmorStand at the same height as the player
                    armorStand.teleport(armorStandLoc);


                }

                if (finalI == 2) {


                    Location playerLoc = entity.getLocation();
                    Location armorStandLoc = playerLoc.clone().add(-1, 0, 1); // Adjust the distance as needed
                    armorStandLoc.setY(playerLoc.getY()); // Keep the ArmorStand at the same height as the player
                    armorStand.teleport(armorStandLoc);


                }

                if (finalI == 3) {

                    Location playerLoc = entity.getLocation();
                    Location armorStandLoc = playerLoc.clone().add(1, 0, -1); // Adjust the distance as needed
                    armorStandLoc.setY(playerLoc.getY()); // Keep the ArmorStand at the same height as the player
                    armorStand.teleport(armorStandLoc);

                }






            }, 20L, 5L); // Adjust the interval as needed

        }

    }

    //Item Stacks

    private static ItemStack shadowOuterHead() {

        PlayerProfile profile = getProfile("https://textures.minecraft.net/texture/f8e53e9a34fd1eba83b4342e45745beea1673755f5ad4135d2eae97a4afe2b2d");
        ItemStack montuHelm = new ItemStack(Material.PLAYER_HEAD);
        SkullMeta meta = (SkullMeta) montuHelm.getItemMeta();
        meta.setDisplayName(ChatColor.DARK_RED + "" + ChatColor.BOLD + "If you have this, Message Comet99 on Discord!");
        meta.setOwnerProfile(profile);
        montuHelm.setItemMeta(meta);

        return montuHelm;
    }

}
