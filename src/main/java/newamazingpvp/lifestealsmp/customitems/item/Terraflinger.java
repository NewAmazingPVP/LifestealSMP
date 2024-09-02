package newamazingpvp.lifestealsmp.customitems.item;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.ArmorStand;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.FallingBlock;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.metadata.FixedMetadataValue;
import org.bukkit.metadata.MetadataValue;
import org.bukkit.util.Vector;

import static newamazingpvp.lifestealsmp.LifestealSMP.SMPworld;
import static newamazingpvp.lifestealsmp.LifestealSMP.lifestealSmp;

public class Terraflinger implements Listener {

    @EventHandler
    public void playerInteract(PlayerInteractEvent event){

        Player attacker = event.getPlayer();

        if ((event.getAction() == Action.RIGHT_CLICK_AIR || event.getAction() == Action.RIGHT_CLICK_BLOCK) && event.hasItem() && event.getItem().getType() == Material.NETHERITE_SHOVEL) {
            ItemMeta meta = event.getItem().getItemMeta();

            if (meta.getLore() == null) return;

            if (meta.getLore().toString().contains("Right click to throw the land")) {

                Location attackerLocation = attacker.getLocation();
                Location landingLocation = null;

                FallingBlock fb = (FallingBlock) attacker.getWorld().spawnEntity(attackerLocation, EntityType.FALLING_BLOCK);
                /*armorStand.setVisible(true);
                armorStand.setSmall(false);
                armorStand.setInvulnerable(true);
                armorStand.setGravity(true);
                String customTag = "tarrathrowerArmorstand";
                MetadataValue customTagValue = new FixedMetadataValue(lifestealSmp, customTag);
                armorStand.setMetadata(customTag, customTagValue);*/


                // Set the block state to diamond block
                fb.setBlockData(org.bukkit.block.data.type.BlockData.create(Material.DIAMOND_BLOCK));


                for (Player onlinePlayer : Bukkit.getOnlinePlayers()) {
                    onlinePlayer.playSound(attackerLocation, Sound.ENTITY_ZOMBIE_BREAK_WOODEN_DOOR, 1.0f, 0.0f);
                }



                Vector velocity = attacker.getLocation().getDirection().multiply(3);
                fb.setVelocity(velocity);



            }
        }
    }








}
