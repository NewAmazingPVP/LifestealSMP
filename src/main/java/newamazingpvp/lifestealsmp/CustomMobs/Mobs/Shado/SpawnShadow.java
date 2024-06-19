package newamazingpvp.lifestealsmp.CustomMobs.Mobs.Shado;

import org.bukkit.ChatColor;
import org.bukkit.Color;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.attribute.Attributable;
import org.bukkit.attribute.Attribute;
import org.bukkit.attribute.AttributeInstance;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Zombie;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.LeatherArmorMeta;
import org.bukkit.metadata.FixedMetadataValue;
import org.bukkit.metadata.MetadataValue;

import java.util.ArrayList;
import java.util.List;

import static newamazingpvp.lifestealsmp.LifestealSMP.lifestealSmp;
import static newamazingpvp.lifestealsmp.customitems.utils.ItemStacks.*;

public class SpawnShadow {



    public SpawnShadow(Location location){

        //Make zombie
        Zombie DeadMiner = (Zombie) location.getWorld().spawnEntity(location, EntityType.HUSK);

        //Set name
        DeadMiner.setCustomName(ChatColor.BLACK + "" + ChatColor.BOLD + "Shadow");
        DeadMiner.setCustomNameVisible(true);

        //What the mob has on / is holding
        DeadMiner.getEquipment().setHelmet(new ItemStack(Material.BLACK_CONCRETE,1));
        DeadMiner.getEquipment().setChestplate(chest());
        DeadMiner.getEquipment().setLeggings(leg());
        DeadMiner.getEquipment().setBoots(boot());

        //Attributes
        Attributable DeadMinerAttributes = DeadMiner;

        AttributeInstance maxHealth = DeadMinerAttributes.getAttribute(Attribute.GENERIC_MAX_HEALTH);
        maxHealth.setBaseValue(60);
        DeadMiner.setHealth(60);

        AttributeInstance attackSpeed = DeadMinerAttributes.getAttribute(Attribute.GENERIC_ATTACK_SPEED);
        attackSpeed.setBaseValue(10);

        // Add custom tag
        String customTag = "shadow";
        MetadataValue customTagValue = new FixedMetadataValue(lifestealSmp, customTag);
        DeadMiner.setMetadata(customTag, customTagValue);

    }

    //Itemstacks

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
