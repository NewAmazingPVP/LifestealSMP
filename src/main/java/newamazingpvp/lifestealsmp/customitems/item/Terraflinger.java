package newamazingpvp.lifestealsmp.customitems.item;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.block.Block;
import org.bukkit.entity.*;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.metadata.FixedMetadataValue;
import org.bukkit.metadata.MetadataValue;
import org.bukkit.util.Vector;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

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
                float pitch = attacker.getLocation().getPitch();
                float distance = 0;

                Location loc = attacker.getLocation();
                loc.setY(attacker.getY() - 1);
                Block block = loc.getBlock();
                Material mat = block.getType();

                for (Player onlinePlayer : Bukkit.getOnlinePlayers()) {
                    onlinePlayer.playSound(attackerLocation, Sound.ENTITY_ZOMBIE_BREAK_WOODEN_DOOR, 1.0f, 0.0f);
                }

                for(int i =0; i<3; i++){

                    attackerLocation.setY(attacker.getY());
                    attackerLocation.setX(attacker.getX());
                    attackerLocation.setZ(attacker.getZ());

                    if(i==0){
                        attackerLocation.setY(attackerLocation.getY()-1);
                        makeTaraflingerBlock(attackerLocation,pitch,distance, i, attacker, mat);
                    }else if(i==1) {
                        attackerLocation.setY(attackerLocation.getY() - 1);
                        attackerLocation.setY(attackerLocation.getY() + 1);
                        makeTaraflingerBlock(attackerLocation, pitch, distance, i, attacker, mat);
                    }else if(i==2) {
                        attackerLocation.setY(attackerLocation.getY() - 1);
                        attackerLocation.setY(attackerLocation.getY() + 2);
                        makeTaraflingerBlock(attackerLocation, pitch, distance, i, attacker, mat);
                    }



                }




            }
        }
    }



    private static void makeTaraflingerBlock(Location attackerLocation, double pitch, double distance, int i, Player attacker, Material mat){


        FallingBlock fb = attacker.getWorld().spawnFallingBlock(attackerLocation, Material.BLACK_CONCRETE, (byte) 0);
        fb.setDropItem(false);
        fb.setCancelDrop(true);

        if(i==0) {
            String customTag = "tarraFallingBlock";
            MetadataValue customTagValue = new FixedMetadataValue(lifestealSmp, customTag);
            fb.setMetadata(customTag, customTagValue);
        }

        if(mat == Material.AIR){
            fb.setBlockData(Material.MAGMA_BLOCK.createBlockData());
        }else{
            fb.setBlockData(mat.createBlockData());
        }


        if(pitch < 0 ) {
            pitch = Math.abs(pitch) + 100;
        }

        distance = pitch/100;



        Vector velocity = attacker.getLocation().getDirection().multiply(distance);
        fb.setVelocity(velocity);

    }








}
