package newamazingpvp.lifestealsmp.EndBossFight.custommobs.mobs.lightningzombie;

import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.attribute.Attributable;
import org.bukkit.attribute.Attribute;
import org.bukkit.attribute.AttributeInstance;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Zombie;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.SkullMeta;
import org.bukkit.metadata.FixedMetadataValue;
import org.bukkit.metadata.MetadataValue;
import org.bukkit.profile.PlayerProfile;

import static newamazingpvp.lifestealsmp.EndBossFight.custommobs.PublicMobMethods.getProfile;
import static newamazingpvp.lifestealsmp.LifestealSMP.lifestealSmp;

public class SpawnLightningZombie {




    public SpawnLightningZombie(Location location){

        //Make zombie
        Zombie lightningZombie = (Zombie) location.getWorld().spawnEntity(location, EntityType.ZOMBIE);

        //Set name
        lightningZombie.setCustomName(ChatColor.YELLOW + "" + ChatColor.BOLD + "Electric Zombie");
        lightningZombie.setCustomNameVisible(true);

        //What the mob has on / is holding
        lightningZombie.getEquipment().setItemInMainHand(lightningZombieHandItem());
        lightningZombie.getEquipment().setHelmet(lightningZombieHead());
        lightningZombie.getEquipment().setChestplate(new ItemStack(Material.GOLDEN_CHESTPLATE,1));
        lightningZombie.getEquipment().setLeggings(new ItemStack(Material.GOLDEN_LEGGINGS,1));
        lightningZombie.getEquipment().setBoots(new ItemStack(Material.GOLDEN_BOOTS,1));

        //Attributes
        Attributable lightningZombieAttributes = lightningZombie;

        AttributeInstance maxHealth = lightningZombieAttributes.getAttribute(Attribute.GENERIC_MAX_HEALTH);
        maxHealth.setBaseValue(20);
        lightningZombie.setHealth(20);

        // Add custom tag
        String customTag = "electric_zombie";
        MetadataValue customTagValue = new FixedMetadataValue(lifestealSmp, customTag);
        lightningZombie.setMetadata(customTag, customTagValue);

        //lightningZombie.setMetadata("custom_tag", customTagValue);


    }


    //Item stacks for the mob

    private static ItemStack lightningZombieHead() {

        PlayerProfile profile = getProfile("https://textures.minecraft.net/texture/baf353cae0d2d00dd0ffca299c654a06c7a5a4ed54a65477b7b4529e5dc19476");
        ItemStack montuHelm = new ItemStack(Material.PLAYER_HEAD);
        SkullMeta meta = (SkullMeta) montuHelm.getItemMeta();
        meta.setDisplayName(ChatColor.DARK_RED + "" + ChatColor.BOLD + "If you have this, Message Comet99 on Discord!");
        meta.setOwnerProfile(profile);
        montuHelm.setItemMeta(meta);

        return montuHelm;
    }

    private static ItemStack lightningZombieHandItem() {

        PlayerProfile profile = getProfile("https://textures.minecraft.net/texture/9ac52419b99025828c89fa825945e6948e45bb5a22e4425a59e9096e4c1ac38");
        ItemStack montuHelm = new ItemStack(Material.PLAYER_HEAD);
        SkullMeta meta = (SkullMeta) montuHelm.getItemMeta();
        meta.setDisplayName(ChatColor.YELLOW + "" + ChatColor.BOLD + "Lightning");
        meta.setOwnerProfile(profile);
        montuHelm.setItemMeta(meta);

        return montuHelm;
    }












}
