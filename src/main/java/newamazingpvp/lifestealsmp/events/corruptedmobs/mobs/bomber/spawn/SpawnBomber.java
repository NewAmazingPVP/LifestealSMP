package newamazingpvp.lifestealsmp.events.corruptedmobs.mobs.bomber.spawn;

import org.bukkit.ChatColor;
import org.bukkit.Color;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.attribute.Attributable;
import org.bukkit.attribute.Attribute;
import org.bukkit.attribute.AttributeInstance;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Skeleton;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.LeatherArmorMeta;
import org.bukkit.inventory.meta.SkullMeta;
import org.bukkit.metadata.FixedMetadataValue;
import org.bukkit.metadata.MetadataValue;
import org.bukkit.profile.PlayerProfile;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.util.Vector;

import static newamazingpvp.lifestealsmp.LifestealSMP.lifestealSmp;
import static newamazingpvp.lifestealsmp.events.corruptedmobs.CorruptedMobsMain.isCustomMob;
import static newamazingpvp.lifestealsmp.events.corruptedmobs.CorruptedMobsMain.isCustomMobTag;
import static newamazingpvp.lifestealsmp.events.corruptedmobs.mobs.bomber.events.TntThrown.spawnBomberThrowable;
import static newamazingpvp.lifestealsmp.unused.endfight.custommobs.PublicMobMethods.getProfile;


public class SpawnBomber {

    public static BukkitRunnable bomberMobAttackRate;

    private static final double beamRange = 15;

    public SpawnBomber(Location location) {

        // Make zombie
        Skeleton mageZombie = (Skeleton) location.getWorld().spawnEntity(location, EntityType.SKELETON);

        // Set name
        mageZombie.setCustomName(ChatColor.DARK_RED + "" + ChatColor.BOLD + "Detonator");
        mageZombie.setCustomNameVisible(true);
        mageZombie.setInvisible(false);

        // What the mob has on / is holding
        mageZombie.getEquipment().setItemInMainHand(mageZombieHandItem());
        mageZombie.getEquipment().setHelmet(mageZombieHead());
        mageZombie.getEquipment().setChestplate(chest());
        mageZombie.getEquipment().setLeggings(leg());
        mageZombie.getEquipment().setBoots(boot());

        // Attributes
        Attributable lightningZombieAttributes = mageZombie;

        AttributeInstance maxHealth = lightningZombieAttributes.getAttribute(Attribute.GENERIC_MAX_HEALTH);
        maxHealth.setBaseValue(100);
        mageZombie.setHealth(100);

        // Add custom tag
        String customTag = "bomber_mob";
        MetadataValue customTagValue = new FixedMetadataValue(lifestealSmp, customTag);
        mageZombie.setMetadata(customTag, customTagValue);
        mageZombie.setMetadata(isCustomMobTag, isCustomMob);

        bomberMobAttackRate = new BukkitRunnable() {
            @Override
            public void run() {

                if (mageZombie.isDead()) {
                    this.cancel();
                    return;
                }

                Location bomberLoc = mageZombie.getLocation();


                Vector attackerLookDir = mageZombie.getLocation().getDirection().multiply(3);


                spawnBomberThrowable(mageZombie, bomberLoc, attackerLookDir);


            }
        };
        bomberMobAttackRate.runTaskTimer(lifestealSmp, 0L, 80L); // Start immediately and repeat every second
    }

    // Item stacks for the mob
    private static ItemStack mageZombieHead() {
        PlayerProfile profile = getProfile("https://textures.minecraft.net/texture/1464eb8e99e2878f343803a742ef57ceafacc2283e67b88edec16821316f9f");
        ItemStack montuHelm = new ItemStack(Material.PLAYER_HEAD);
        SkullMeta meta = (SkullMeta) montuHelm.getItemMeta();
        meta.setDisplayName(ChatColor.DARK_RED + "" + ChatColor.BOLD + "If you have this, Message Comet99 on Discord!");
        meta.setOwnerProfile(profile);
        montuHelm.setItemMeta(meta);
        return montuHelm;
    }

    private static ItemStack mageZombieHandItem() {
        ItemStack chestplate = new ItemStack(Material.TNT);
        ItemMeta meta = chestplate.getItemMeta();
        meta.setDisplayName(ChatColor.DARK_RED + "" + ChatColor.BOLD + "Bomb");
        chestplate.setItemMeta(meta);
        return chestplate;
    }

    private static ItemStack chest() {
        ItemStack chestplate = new ItemStack(Material.LEATHER_CHESTPLATE);
        LeatherArmorMeta meta = (LeatherArmorMeta) chestplate.getItemMeta();
        meta.setUnbreakable(true);
        meta.setColor(Color.RED);
        chestplate.setItemMeta(meta);
        return chestplate;
    }

    private static ItemStack leg() {
        ItemStack chestplate = new ItemStack(Material.LEATHER_LEGGINGS);
        LeatherArmorMeta meta = (LeatherArmorMeta) chestplate.getItemMeta();
        meta.setUnbreakable(true);
        meta.setColor(Color.RED);
        chestplate.setItemMeta(meta);
        return chestplate;
    }

    private static ItemStack boot() {
        ItemStack chestplate = new ItemStack(Material.LEATHER_BOOTS);
        LeatherArmorMeta meta = (LeatherArmorMeta) chestplate.getItemMeta();
        meta.setUnbreakable(true);
        meta.setColor(Color.RED);
        chestplate.setItemMeta(meta);
        return chestplate;
    }

    private Entity getTargetEntityAtLocation(Location location) {
        for (Entity target : location.getWorld().getEntities()) {
            if ((target.getLocation().getBlock().getX() == location.getBlock().getX()) &&
                    (target.getLocation().getBlock().getZ() == location.getBlock().getZ()) &&
                    (target.getLocation().getBlock().getY() >= location.getBlock().getY() - target.getHeight()) &&
                    (target.getLocation().getBlock().getY() <= location.getBlock().getY() + target.getHeight()) &&
                    (target instanceof LivingEntity)) {
                return target;
            }
        }
        return null;
    }


}
