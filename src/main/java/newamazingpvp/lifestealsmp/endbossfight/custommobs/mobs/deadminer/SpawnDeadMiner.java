package newamazingpvp.lifestealsmp.endbossfight.custommobs.mobs.deadminer;

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

import static newamazingpvp.lifestealsmp.LifestealSMP.lifestealSmp;
import static newamazingpvp.lifestealsmp.endbossfight.custommobs.PublicMobMethods.getProfile;

public class SpawnDeadMiner {


    public SpawnDeadMiner(Location location) {

        //Make zombie
        Zombie DeadMiner = (Zombie) location.getWorld().spawnEntity(location, EntityType.ZOMBIE);

        //Set name
        DeadMiner.setCustomName(ChatColor.RED + "" + ChatColor.BOLD + "Dead Miner");
        DeadMiner.setCustomNameVisible(true);

        //What the mob has on / is holding
        DeadMiner.getEquipment().setItemInMainHand(new ItemStack(Material.STONE_PICKAXE, 1));
        DeadMiner.getEquipment().setHelmet(deadMinerHelm());
        DeadMiner.getEquipment().setChestplate(chest());
        DeadMiner.getEquipment().setLeggings(leg());
        DeadMiner.getEquipment().setBoots(boot());

        //Attributes
        Attributable DeadMinerAttributes = DeadMiner;

        AttributeInstance maxHealth = DeadMinerAttributes.getAttribute(Attribute.GENERIC_MAX_HEALTH);
        maxHealth.setBaseValue(40);
        DeadMiner.setHealth(40);

        //AttributeInstance speed = DeadMinerAttributes.getAttribute(Attribute.GENERIC_MOVEMENT_SPEED);
        //speed.setBaseValue(10);

        // Add custom tag
        String customTag = "dead_miner";
        MetadataValue customTagValue = new FixedMetadataValue(lifestealSmp, customTag);
        DeadMiner.setMetadata(customTag, customTagValue);

    }


    //Item stacks for the mob

    private static ItemStack deadMinerHelm() {

        PlayerProfile profile = getProfile("https://textures.minecraft.net/texture/5f36e53f395593eddc81e511878456d7724e53337a3f5b1d324ffb9e160f64c");
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
        meta.setColor(Color.BLUE);
        chestplate.setItemMeta(meta);
        return chestplate;
    }

    private static ItemStack leg() {
        ItemStack chestplate = new ItemStack(Material.LEATHER_LEGGINGS);
        LeatherArmorMeta meta = (LeatherArmorMeta) chestplate.getItemMeta();
        meta.setUnbreakable(true);
        meta.setColor(Color.BLUE);
        chestplate.setItemMeta(meta);
        return chestplate;
    }

    private static ItemStack boot() {
        ItemStack chestplate = new ItemStack(Material.LEATHER_BOOTS);
        LeatherArmorMeta meta = (LeatherArmorMeta) chestplate.getItemMeta();
        meta.setUnbreakable(true);
        meta.setColor(Color.BLUE);
        chestplate.setItemMeta(meta);
        return chestplate;
    }


}
