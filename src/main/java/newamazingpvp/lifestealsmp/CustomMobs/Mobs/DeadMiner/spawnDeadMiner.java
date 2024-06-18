package newamazingpvp.lifestealsmp.CustomMobs.Mobs.DeadMiner;

import org.bukkit.Bukkit;
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
import org.bukkit.profile.PlayerProfile;
import org.bukkit.profile.PlayerTextures;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import static newamazingpvp.lifestealsmp.CustomMobs.PublicMobMethods.getProfile;
import static newamazingpvp.lifestealsmp.customitems.utils.ItemStacks.*;

public class spawnDeadMiner {



    public spawnDeadMiner(Location location){

        //Make zombie
        Zombie DeadMiner = (Zombie) location.getWorld().spawnEntity(location, EntityType.ZOMBIE);

        //Set name
        DeadMiner.setCustomName(ChatColor.RED + "" + ChatColor.BOLD + "Dead Miner");
        DeadMiner.setCustomNameVisible(true);

        //What the mob has on / is holding
        DeadMiner.getEquipment().setItemInMainHand(new ItemStack(Material.STONE_PICKAXE,1));
        DeadMiner.getEquipment().setHelmet(deadMinerHelm());
        DeadMiner.getEquipment().setChestplate(QuarryArmor_CP());
        DeadMiner.getEquipment().setLeggings(QuarryArmor_LEGS());
        DeadMiner.getEquipment().setBoots(QuarryArmor_BOOTS());

        //Attributes
        Attributable DeadMinerAttributes = DeadMiner;

        AttributeInstance maxHealth = DeadMinerAttributes.getAttribute(Attribute.GENERIC_MAX_HEALTH);
        maxHealth.setBaseValue(5);
        DeadMiner.setHealth(5);


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


}
