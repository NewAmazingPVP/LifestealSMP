package newamazingpvp.lifestealsmp.RaffleEvent.RaffleCustomMobs.Mage.SpawnMage;

import org.bukkit.*;
import org.bukkit.attribute.Attributable;
import org.bukkit.attribute.Attribute;
import org.bukkit.attribute.AttributeInstance;
import org.bukkit.entity.*;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDeathEvent;
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
import static newamazingpvp.lifestealsmp.unused.endfight.custommobs.PublicMobMethods.getProfile;
import static newamazingpvp.lifestealsmp.unused.magicstaffs.utils.BeamTexture.beamTextureMaker;
import static newamazingpvp.lifestealsmp.unused.magicstaffs.utils.StaffSound.playMagicStaffSound;

public class SpawnMage {

    public static BukkitRunnable mageMobAttackRate;

    private static final double beamRange = 15;

    public SpawnMage(Location location) {

        // Make zombie
        Stray mageZombie = (Stray) location.getWorld().spawnEntity(location, EntityType.STRAY);

        // Set name
        mageZombie.setCustomName(ChatColor.DARK_PURPLE + "" + ChatColor.BOLD + "Mage");
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
        maxHealth.setBaseValue(150);
        mageZombie.setHealth(150);

        // Add custom tag
        String customTag = "mage_mob";
        MetadataValue customTagValue = new FixedMetadataValue(lifestealSmp, customTag);
        mageZombie.setMetadata(customTag, customTagValue);

        mageMobAttackRate = new BukkitRunnable() {
            @Override
            public void run() {

                if (mageZombie.isDead()) {
                    this.cancel();
                    return;
                }

                Location location = mageZombie.getEyeLocation().add(0, 0.2, 0);
                Vector attackerLookDir = mageZombie.getLocation().getDirection().multiply(0.1);
                Vector direction = mageZombie.getEyeLocation().getDirection();
                Location targetLocation = mageZombie.getEyeLocation().clone();

                beamTextureMaker(mageZombie, location, attackerLookDir, Color.PURPLE, 3.0F, Color.BLACK, 2.0F);

                for (int i = 0; i < beamRange; i++) {
                    targetLocation.add(direction);

                    Entity target = getTargetEntityAtLocation(targetLocation);
                    if (target != null) {
                        if (target instanceof Entity) {
                            ((LivingEntity) target).damage(5);
                        }
                        break;
                    }
                    // Target location is obstructed by a block
                    if (targetLocation.getBlock().getType().isSolid()) {
                        break;
                    }
                }
            }
        };
        mageMobAttackRate.runTaskTimer(lifestealSmp, 0L, 20L); // Start immediately and repeat every second
    }

    // Item stacks for the mob
    private static ItemStack mageZombieHead() {
        PlayerProfile profile = getProfile("https://textures.minecraft.net/texture/42047a0cbd19c0d65cec385352bc6936d5c29b4b47e86039dc27763a91c5883d");
        ItemStack montuHelm = new ItemStack(Material.PLAYER_HEAD);
        SkullMeta meta = (SkullMeta) montuHelm.getItemMeta();
        meta.setDisplayName(ChatColor.DARK_RED + "" + ChatColor.BOLD + "If you have this, Message Comet99 on Discord!");
        meta.setOwnerProfile(profile);
        montuHelm.setItemMeta(meta);
        return montuHelm;
    }

    private static ItemStack mageZombieHandItem() {
        ItemStack chestplate = new ItemStack(Material.STICK);
        ItemMeta meta = chestplate.getItemMeta();
        meta.setDisplayName(ChatColor.DARK_PURPLE + "" + ChatColor.BOLD + "Magic");
        chestplate.setItemMeta(meta);
        return chestplate;
    }

    private static ItemStack chest() {
        ItemStack chestplate = new ItemStack(Material.LEATHER_CHESTPLATE);
        LeatherArmorMeta meta = (LeatherArmorMeta) chestplate.getItemMeta();
        meta.setUnbreakable(true);
        meta.setColor(Color.PURPLE);
        chestplate.setItemMeta(meta);
        return chestplate;
    }

    private static ItemStack leg() {
        ItemStack chestplate = new ItemStack(Material.LEATHER_LEGGINGS);
        LeatherArmorMeta meta = (LeatherArmorMeta) chestplate.getItemMeta();
        meta.setUnbreakable(true);
        meta.setColor(Color.PURPLE);
        chestplate.setItemMeta(meta);
        return chestplate;
    }

    private static ItemStack boot() {
        ItemStack chestplate = new ItemStack(Material.LEATHER_BOOTS);
        LeatherArmorMeta meta = (LeatherArmorMeta) chestplate.getItemMeta();
        meta.setUnbreakable(true);
        meta.setColor(Color.PURPLE);
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
