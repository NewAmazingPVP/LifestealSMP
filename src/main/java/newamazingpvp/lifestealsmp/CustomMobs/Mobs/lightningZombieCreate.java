package newamazingpvp.lifestealsmp.CustomMobs.Mobs;

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

public class lightningZombieCreate {




    public lightningZombieCreate(Location location){

        //Make zombie
        Zombie lightningZombie = (Zombie) location.getWorld().spawnEntity(location, EntityType.ZOMBIE);

        //Set name
        lightningZombie.setCustomName(ChatColor.YELLOW + "" + ChatColor.BOLD + "Lightning Zombie");
        lightningZombie.setCustomNameVisible(true);

        //What the mob has on / is holding
        lightningZombie.getEquipment().setItemInMainHand(new ItemStack(Material.LIGHTNING_ROD,1));
        lightningZombie.getEquipment().setHelmet(new ItemStack(Material.YELLOW_CONCRETE,1));

        //Attributes
        Attributable lightningZombieAttributes = lightningZombie;

        AttributeInstance maxHealth = lightningZombieAttributes.getAttribute(Attribute.GENERIC_MAX_HEALTH);
        maxHealth.setBaseValue(20);
        lightningZombie.setHealth(20);




    }













}
