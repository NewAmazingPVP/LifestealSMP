package newamazingpvp.lifestealsmp.EndBossFight.custommobs.mobs.MiniShadow.SpawnMiniShadow;

import org.bukkit.ChatColor;
import org.bukkit.Color;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.attribute.Attributable;
import org.bukkit.attribute.Attribute;
import org.bukkit.attribute.AttributeInstance;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Zombie;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.LeatherArmorMeta;
import org.bukkit.inventory.meta.SkullMeta;
import org.bukkit.metadata.FixedMetadataValue;
import org.bukkit.metadata.MetadataValue;
import org.bukkit.profile.PlayerProfile;

import static newamazingpvp.lifestealsmp.EndBossFight.custommobs.PublicMobMethods.getProfile;
import static newamazingpvp.lifestealsmp.EndBossFight.custommobs.mobs.Shadow.SpawningShadow.ShadowMobEffects.spawnArmorStandAroundShadow;
import static newamazingpvp.lifestealsmp.LifestealSMP.lifestealSmp;

public class SpawnMiniShadow {



    public SpawnMiniShadow(Location location){

        //Make zombie
        Zombie Shadow = (Zombie) location.getWorld().spawnEntity(location, EntityType.HUSK);

        //Set name
        Shadow.setCustomName(ChatColor.DARK_PURPLE + "" + ChatColor.BOLD + "Mini Shadow");
        Shadow.setCustomNameVisible(true);
        Shadow.setBaby();



        //What the mob has on / is holding
        Shadow.getEquipment().setHelmet(shadowMobHead());
        Shadow.getEquipment().setChestplate(chest());
        Shadow.getEquipment().setLeggings(leg());
        Shadow.getEquipment().setBoots(boot());

        //Attributes
        Attributable ShadowAttributes = Shadow;

        AttributeInstance maxHealth = ShadowAttributes.getAttribute(Attribute.GENERIC_MAX_HEALTH);
        maxHealth.setBaseValue(30);
        Shadow.setHealth(30);

        AttributeInstance speed = ShadowAttributes.getAttribute(Attribute.GENERIC_MOVEMENT_SPEED);
        speed.setBaseValue(2);


        // Add custom tag
        String customTag = "mini_shadow";
        MetadataValue customTagValue = new FixedMetadataValue(lifestealSmp, customTag);
        Shadow.setMetadata(customTag, customTagValue);

        spawnArmorStandAroundShadow(Shadow, location);

    }

    //Itemstacks


    private static ItemStack shadowMobHead() {

        PlayerProfile profile = getProfile("https://textures.minecraft.net/texture/f8e53e9a34fd1eba83b4342e45745beea1673755f5ad4135d2eae97a4afe2b2d");
        ItemStack montuHelm = new ItemStack(Material.PLAYER_HEAD);
        SkullMeta meta = (SkullMeta) montuHelm.getItemMeta();
        meta.setDisplayName(ChatColor.DARK_RED + "" + ChatColor.BOLD + "If you have this, Message Comet99 on Discord!");
        meta.setOwnerProfile(profile);
        montuHelm.setItemMeta(meta);

        return montuHelm;
    }

    private static ItemStack chest() {
        ItemStack chestplate = new ItemStack(Material.LEATHER_CHESTPLATE);
        LeatherArmorMeta meta = (LeatherArmorMeta) chestplate.getItemMeta();
        meta.setUnbreakable(true);
        meta.setColor(Color.BLACK);
        chestplate.setItemMeta(meta);
        return chestplate;
    }

    private static ItemStack leg() {
        ItemStack chestplate = new ItemStack(Material.LEATHER_LEGGINGS);
        LeatherArmorMeta meta = (LeatherArmorMeta) chestplate.getItemMeta();
        meta.setUnbreakable(true);
        meta.setColor(Color.BLACK);
        chestplate.setItemMeta(meta);
        return chestplate;
    }

    private static ItemStack boot() {
        ItemStack chestplate = new ItemStack(Material.LEATHER_BOOTS);
        LeatherArmorMeta meta = (LeatherArmorMeta) chestplate.getItemMeta();
        meta.setUnbreakable(true);
        meta.setColor(Color.BLACK);
        chestplate.setItemMeta(meta);
        return chestplate;
    }

}
