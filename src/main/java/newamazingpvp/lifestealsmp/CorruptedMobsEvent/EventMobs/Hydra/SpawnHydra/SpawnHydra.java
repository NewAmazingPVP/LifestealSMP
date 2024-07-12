package newamazingpvp.lifestealsmp.CorruptedMobsEvent.EventMobs.Hydra.SpawnHydra;

import org.bukkit.ChatColor;
import org.bukkit.Color;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.attribute.Attributable;
import org.bukkit.attribute.Attribute;
import org.bukkit.attribute.AttributeInstance;
import org.bukkit.entity.*;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.LeatherArmorMeta;
import org.bukkit.inventory.meta.SkullMeta;
import org.bukkit.metadata.FixedMetadataValue;
import org.bukkit.metadata.MetadataValue;
import org.bukkit.profile.PlayerProfile;
import org.bukkit.scheduler.BukkitRunnable;

import static newamazingpvp.lifestealsmp.LifestealSMP.lifestealSmp;
import static newamazingpvp.lifestealsmp.unused.endfight.custommobs.PublicMobMethods.getProfile;

public class SpawnHydra {

    public static BukkitRunnable hydraMobAttackRate;

    // Add custom tag
    public static String customTag = "hydra_mob_charged";
    public static MetadataValue customTagValue = new FixedMetadataValue(lifestealSmp, customTag);


    String customTag2 = "hydra_mob";
    MetadataValue customTagValue2 = new FixedMetadataValue(lifestealSmp, customTag2);


    public SpawnHydra(Location location) {

        //Make zombie
        Zombie enigmaZombie = (Zombie) location.getWorld().spawnEntity(location, EntityType.ZOMBIE);

        //Set name
        enigmaZombie.setCustomName(ChatColor.DARK_BLUE + "" + ChatColor.ITALIC + "Hydra");
        enigmaZombie.setCustomNameVisible(true);
        enigmaZombie.setInvisible(false);
        enigmaZombie.setAdult();

        //What the mob has on / is holding
        enigmaZombie.getEquipment().setItemInMainHand((enigmaZombieHandItem()));
        enigmaZombie.getEquipment().setHelmet(enigmaZombieHead());
        enigmaZombie.getEquipment().setChestplate(chest());
        enigmaZombie.getEquipment().setLeggings(leg());
        enigmaZombie.getEquipment().setBoots(boot());

        //Attributes
        Attributable lightningZombieAttributes = enigmaZombie;

        AttributeInstance maxHealth = lightningZombieAttributes.getAttribute(Attribute.GENERIC_MAX_HEALTH);
        maxHealth.setBaseValue(500);
        enigmaZombie.setHealth(500);

        enigmaZombie.setMetadata(customTag, customTagValue);
        enigmaZombie.setMetadata(customTag2, customTagValue2);


        hydraMobAttackRate = new BukkitRunnable() {
            @Override
            public void run() {

                if (enigmaZombie.isDead()) {
                    this.cancel();
                    return;
                }


                enigmaZombie.getEquipment().setItemInMainHand((enigmaZombieHandItem()));
                enigmaZombie.setMetadata(customTag, customTagValue);


            }
        };
        hydraMobAttackRate.runTaskTimer(lifestealSmp, 0L, 140L); // Start immediately and repeat every second


    }


    //Item stacks for the mob

    private static ItemStack enigmaZombieHead() {

        PlayerProfile profile = getProfile("https://textures.minecraft.net/texture/b6a77689a73f39cd9c5f56c8e002ed7c76ea4a905c56a767adfd83cb2ea1f2c4");
        ItemStack montuHelm = new ItemStack(Material.PLAYER_HEAD);
        SkullMeta meta = (SkullMeta) montuHelm.getItemMeta();
        meta.setDisplayName(ChatColor.DARK_RED + "" + ChatColor.BOLD + "If you have this, Message Comet99 on Discord!");
        meta.setOwnerProfile(profile);
        montuHelm.setItemMeta(meta);

        return montuHelm;
    }

    private static ItemStack enigmaZombieHandItem() {

        PlayerProfile profile = getProfile("https://textures.minecraft.net/texture/a61b98d8934900a08ab7c0d60f3476c569bf7ff637196dce644e8cc4b7ba325a");
        ItemStack montuHelm = new ItemStack(Material.PLAYER_HEAD);
        SkullMeta meta = (SkullMeta) montuHelm.getItemMeta();
        meta.setDisplayName(ChatColor.DARK_PURPLE + "" + ChatColor.BOLD + "Water");
        meta.setOwnerProfile(profile);
        montuHelm.setItemMeta(meta);

        return montuHelm;
    }


    public static ItemStack NOTHING_ITEM = new ItemStack(Material.AIR);


    private static ItemStack chest() {
        ItemStack chestplate = new ItemStack(Material.LEATHER_CHESTPLATE);
        LeatherArmorMeta meta = (LeatherArmorMeta) chestplate.getItemMeta();
        meta.setUnbreakable(true);
        meta.setColor(Color.GREEN);
        chestplate.setItemMeta(meta);
        return chestplate;
    }

    private static ItemStack leg() {
        ItemStack chestplate = new ItemStack(Material.LEATHER_LEGGINGS);
        LeatherArmorMeta meta = (LeatherArmorMeta) chestplate.getItemMeta();
        meta.setUnbreakable(true);
        meta.setColor(Color.GREEN);
        chestplate.setItemMeta(meta);
        return chestplate;
    }

    private static ItemStack boot() {
        ItemStack chestplate = new ItemStack(Material.LEATHER_BOOTS);
        LeatherArmorMeta meta = (LeatherArmorMeta) chestplate.getItemMeta();
        meta.setUnbreakable(true);
        meta.setColor(Color.GREEN);
        chestplate.setItemMeta(meta);
        return chestplate;
    }

}
