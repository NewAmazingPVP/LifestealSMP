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




    public static void spawnArmorStandAroundShadow(Entity entity, Location location) {
        for (int i = 0; i < 4; i++) {
            ArmorStand armorStand = (ArmorStand) entity.getWorld().spawnEntity(location, EntityType.ARMOR_STAND);
            armorStand.setVisible(false);
            armorStand.setSmall(false);
            armorStand.getEquipment().setHelmet(shadowOuterHead());


            Location playerLoc = entity.getLocation();
            World world = armorStand.getWorld();



            int finalI = i;

                if (finalI == 0) {

                    Bukkit.getScheduler().runTaskTimer(lifestealSmp, () -> {
                        Location armorStandLoc = playerLoc.clone().add(1, 0, 1);
                        armorStandLoc.setY(playerLoc.getY());
                        armorStand.teleport(armorStandLoc);
                        world.spawnParticle(Particle.DUST, location, 0, new Particle.DustOptions(Color.PURPLE, 2.0f));
                    }, 20L, 5L);

                }

                if (finalI == 1) {



                    Bukkit.getScheduler().runTaskTimer(lifestealSmp, () -> {
                        Location armorStandLoc = playerLoc.clone().add(-1, 0, -1);
                        armorStandLoc.setY(playerLoc.getY());
                        armorStand.teleport(armorStandLoc);
                        world.spawnParticle(Particle.DUST, location, 0, new Particle.DustOptions(Color.PURPLE, 2.0f));
                    }, 20L, 5L);


                }

                if (finalI == 2) {


                    Bukkit.getScheduler().runTaskTimer(lifestealSmp, () -> {
                        Location armorStandLoc = playerLoc.clone().add(-1, 0, 1);
                        armorStandLoc.setY(playerLoc.getY());
                        armorStand.teleport(armorStandLoc);
                        world.spawnParticle(Particle.DUST, location, 0, new Particle.DustOptions(Color.PURPLE, 2.0f));
                    }, 20L, 5L);


                }

                if (finalI == 3) {


                    Bukkit.getScheduler().runTaskTimer(lifestealSmp, () -> {
                        Location armorStandLoc = playerLoc.clone().add(1, 0, -1);
                        armorStandLoc.setY(playerLoc.getY());
                        armorStand.teleport(armorStandLoc);
                        world.spawnParticle(Particle.DUST, location, 0, new Particle.DustOptions(Color.PURPLE, 2.0f));
                    }, 20L, 5L);

                }








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
