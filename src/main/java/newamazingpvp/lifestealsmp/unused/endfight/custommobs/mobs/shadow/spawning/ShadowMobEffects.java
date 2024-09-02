package newamazingpvp.lifestealsmp.unused.endfight.custommobs.mobs.shadow.spawning;

import org.bukkit.*;
import org.bukkit.entity.ArmorStand;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.LivingEntity;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.SkullMeta;
import org.bukkit.metadata.FixedMetadataValue;
import org.bukkit.metadata.MetadataValue;
import org.bukkit.profile.PlayerProfile;

import static newamazingpvp.lifestealsmp.LifestealSMP.lifestealSmp;
import static newamazingpvp.lifestealsmp.unused.endfight.custommobs.PublicMobMethods.getProfile;

public class ShadowMobEffects {


    public static void spawnArmorStandAroundShadow(Entity entity, Location location) {
        for (int i = 0; i < 4; i++) {
            World world = Bukkit.getWorlds().get(0); // Get the first loaded world
            ArmorStand armorStand = (ArmorStand) entity.getWorld().spawnEntity(location, EntityType.ARMOR_STAND);
            armorStand.setVisible(true);
            armorStand.setSmall(false);
            armorStand.setInvulnerable(true);
            armorStand.setGravity(true);
            String customTag = "tarrathrowerArmorstand";
            MetadataValue customTagValue = new FixedMetadataValue(lifestealSmp, customTag);
            armorStand.setMetadata(customTag, customTagValue);


            int finalI = i;
            Bukkit.getScheduler().runTaskTimer(lifestealSmp, () -> {


                if (finalI == 0) {


                    Location playerLoc = entity.getLocation();
                    Location armorStandLoc = playerLoc.clone().add(1, 0, 1);
                    armorStandLoc.setY(playerLoc.getY() + 0.2);
                    armorStand.teleport(armorStandLoc);

                    playerLoc.getWorld().spawnParticle(Particle.CLOUD, playerLoc, 0, new Particle.DustOptions(Color.PURPLE, 2.0f));


                    if (((LivingEntity) entity).getHealth() <= 1) {
                        armorStand.remove();
                    } else {
                        armorStand.getWorld().spawnParticle(Particle.DUST, armorStandLoc, 0, new Particle.DustOptions(Color.PURPLE, 2.0f));
                    }

                }


                if (finalI == 1) {


                    Location playerLoc = entity.getLocation();
                    Location armorStandLoc = playerLoc.clone().add(-1, 0, -1);
                    armorStandLoc.setY(playerLoc.getY() + 0.2);
                    armorStand.teleport(armorStandLoc);

                    if (((LivingEntity) entity).getHealth() <= 1) {
                        armorStand.remove();
                    } else {
                        armorStand.getWorld().spawnParticle(Particle.DUST, armorStandLoc, 0, new Particle.DustOptions(Color.PURPLE, 2.0f));
                    }

                }

                if (finalI == 2) {


                    Location playerLoc = entity.getLocation();
                    Location armorStandLoc = playerLoc.clone().add(-1, 0, 1);
                    armorStandLoc.setY(playerLoc.getY() + 0.2);
                    armorStand.teleport(armorStandLoc);

                    if (((LivingEntity) entity).getHealth() <= 1) {
                        armorStand.remove();
                    } else {
                        armorStand.getWorld().spawnParticle(Particle.DUST, armorStandLoc, 0, new Particle.DustOptions(Color.PURPLE, 2.0f));
                    }

                }

                if (finalI == 3) {

                    Location playerLoc = entity.getLocation();
                    Location armorStandLoc = playerLoc.clone().add(1, 0, -1);
                    armorStandLoc.setY(playerLoc.getY() + 0.2);
                    armorStand.teleport(armorStandLoc);


                    if (((LivingEntity) entity).getHealth() <= 1) {
                        armorStand.remove();
                    } else {
                        armorStand.getWorld().spawnParticle(Particle.DUST, armorStandLoc, 0, new Particle.DustOptions(Color.PURPLE, 2.0f));
                    }

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
