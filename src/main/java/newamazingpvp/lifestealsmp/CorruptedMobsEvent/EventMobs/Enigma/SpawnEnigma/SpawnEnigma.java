package newamazingpvp.lifestealsmp.CorruptedMobsEvent.EventMobs.Enigma.SpawnEnigma;

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

import static newamazingpvp.lifestealsmp.CorruptedMobsEvent.CorruptedMobsMain.isCustomMob;
import static newamazingpvp.lifestealsmp.CorruptedMobsEvent.CorruptedMobsMain.isCustomMobTag;
import static newamazingpvp.lifestealsmp.LifestealSMP.lifestealSmp;
import static newamazingpvp.lifestealsmp.unused.endfight.custommobs.PublicMobMethods.getProfile;

public class SpawnEnigma {

    public SpawnEnigma(Location location) {

        //Make zombie
        Zombie enigmaZombie = (Zombie) location.getWorld().spawnEntity(location, EntityType.ZOMBIE);

        //Set name
        enigmaZombie.setCustomName(ChatColor.DARK_PURPLE + "" + ChatColor.MAGIC + "E" + ChatColor.DARK_PURPLE + " Enigma " + ChatColor.MAGIC + "E");
        enigmaZombie.setCustomNameVisible(true);
        enigmaZombie.setInvisible(false);
        enigmaZombie.setAdult();

        //What the mob has on / is holding
        enigmaZombie.getEquipment().setItemInMainHand(enigmaZombieHandItem());
        enigmaZombie.getEquipment().setHelmet(enigmaZombieHead());
        enigmaZombie.getEquipment().setChestplate(chest());
        enigmaZombie.getEquipment().setLeggings(leg());
        enigmaZombie.getEquipment().setBoots(boot());

        //Attributes
        Attributable lightningZombieAttributes = enigmaZombie;

        AttributeInstance maxHealth = lightningZombieAttributes.getAttribute(Attribute.GENERIC_MAX_HEALTH);
        maxHealth.setBaseValue(100);
        enigmaZombie.setHealth(100);

        // Add custom tag
        String customTag = "enigma_mob";
        MetadataValue customTagValue = new FixedMetadataValue(lifestealSmp, customTag);
        enigmaZombie.setMetadata(customTag, customTagValue);
        enigmaZombie.setMetadata(isCustomMobTag,isCustomMob);


    }


    //Item stacks for the mob

    private static ItemStack enigmaZombieHead() {

        PlayerProfile profile = getProfile("https://textures.minecraft.net/texture/3da50fb328fcbd244b26c6c768eaa03485dc763ae4635540d8b8c7bc8333dc0c");
        ItemStack montuHelm = new ItemStack(Material.PLAYER_HEAD);
        SkullMeta meta = (SkullMeta) montuHelm.getItemMeta();
        meta.setDisplayName(ChatColor.DARK_RED + "" + ChatColor.BOLD + "If you have this, Message Comet99 on Discord!");
        meta.setOwnerProfile(profile);
        montuHelm.setItemMeta(meta);

        return montuHelm;
    }

    private static ItemStack enigmaZombieHandItem() {

        PlayerProfile profile = getProfile("https://textures.minecraft.net/texture/e8fe897e214ee1ce7850514fc81a12ef2a3fe5bcdf3971dd7213e5423c4f");
        ItemStack montuHelm = new ItemStack(Material.PLAYER_HEAD);
        SkullMeta meta = (SkullMeta) montuHelm.getItemMeta();
        meta.setDisplayName(ChatColor.DARK_PURPLE + "" + ChatColor.BOLD + "Confusion");
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
