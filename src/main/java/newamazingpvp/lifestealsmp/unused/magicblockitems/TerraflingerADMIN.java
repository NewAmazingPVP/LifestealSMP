package newamazingpvp.lifestealsmp.unused.magicblockitems;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.block.Block;
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

import static newamazingpvp.lifestealsmp.LifestealSMP.lifestealSmp;

public class TerraflingerADMIN implements Listener {


    @EventHandler
    public void playerInteract(PlayerInteractEvent event) {

        Player attacker = event.getPlayer();

        if ((event.getAction() == Action.RIGHT_CLICK_AIR || event.getAction() == Action.RIGHT_CLICK_BLOCK) && event.hasItem() && event.getItem().getType() == Material.NETHERITE_SHOVEL) {
            ItemMeta meta = event.getItem().getItemMeta();

            if (meta.getLore() == null) return;

            if (meta.getLore().toString().contains("Same thing but no cooldown and soft body physics and collisions")) {

                Location attackerLocation = attacker.getLocation();
                Location landingLocation = null;
                float pitch = attacker.getLocation().getPitch();
                float distance = 0;

                //Location loc = attacker.getLocation();
                //loc.setY(attacker.getY() - 1);

                for (Player onlinePlayer : Bukkit.getOnlinePlayers()) {
                    onlinePlayer.playSound(attackerLocation, Sound.ENTITY_ZOMBIE_BREAK_WOODEN_DOOR, 1.0f, 0.0f);
                }

                //attacker.sendMessage("start LOC" + attackerLocation);
                //attacker.sendMessage("Pitch MODIFYED" + attackerLocation);

                for (int i = 0; i < 40; i++) {

                    attackerLocation.setY(attacker.getY());
                    attackerLocation.setX(attacker.getX());
                    attackerLocation.setZ(attacker.getZ());

                    //attacker.sendMessage("MODIFYED LOC" + attackerLocation + " " + i);

                    if (i == 0) {
                        attackerLocation.setY(attackerLocation.getY() - 1);
                        Block block = attackerLocation.getBlock();
                        Material mat = block.getType();
                        makeTaraflingerBlock(attackerLocation, pitch, distance, i, attacker, attackerLocation);
                    } else if (i == 1) {
                        attackerLocation.setY(attackerLocation.getY() - 1);
                        attackerLocation.setX(attackerLocation.getX() + 1);
                        Block block = attackerLocation.getBlock();
                        Material mat = block.getType();
                        makeTaraflingerBlock(attackerLocation, pitch, distance, i, attacker, attackerLocation);
                    } else if (i == 2) {
                        attackerLocation.setY(attackerLocation.getY() - 1);
                        attackerLocation.setX(attackerLocation.getX() + 2);
                        Block block = attackerLocation.getBlock();
                        Material mat = block.getType();
                        makeTaraflingerBlock(attackerLocation, pitch, distance, i, attacker, attackerLocation);
                    } else if (i == 3) {
                        attackerLocation.setY(attackerLocation.getY() - 1);
                        attackerLocation.setX(attackerLocation.getX() - 1);
                        Block block = attackerLocation.getBlock();
                        Material mat = block.getType();
                        makeTaraflingerBlock(attackerLocation, pitch, distance, i, attacker, attackerLocation);
                    } else if (i == 4) {
                        attackerLocation.setY(attackerLocation.getY() - 1);
                        attackerLocation.setX(attackerLocation.getX() - 2);
                        Block block = attackerLocation.getBlock();
                        Material mat = block.getType();
                        makeTaraflingerBlock(attackerLocation, pitch, distance, i, attacker, attackerLocation);
                    } else if (i == 5) {
                        attackerLocation.setY(attackerLocation.getY() - 1);
                        attackerLocation.setX(attackerLocation.getX() - 3);
                        makeTaraflingerBlock(attackerLocation, pitch, distance, i, attacker, attackerLocation);
                    } else if (i == 6) {
                        attackerLocation.setY(attackerLocation.getY() - 1);
                        attackerLocation.setZ(attackerLocation.getZ() + 1);
                        Block block = attackerLocation.getBlock();
                        Material mat = block.getType();
                        makeTaraflingerBlock(attackerLocation, pitch, distance, i, attacker, attackerLocation);
                    } else if (i == 7) {
                        attackerLocation.setY(attackerLocation.getY() - 1);
                        attackerLocation.setX(attackerLocation.getX() + 1);
                        attackerLocation.setZ(attackerLocation.getZ() + 1);
                        Block block = attackerLocation.getBlock();
                        Material mat = block.getType();
                        makeTaraflingerBlock(attackerLocation, pitch, distance, i, attacker, attackerLocation);
                    } else if (i == 8) {
                        attackerLocation.setY(attackerLocation.getY() - 1);
                        attackerLocation.setX(attackerLocation.getX() - 1);
                        attackerLocation.setZ(attackerLocation.getZ() + 1);
                        Block block = attackerLocation.getBlock();
                        Material mat = block.getType();
                        makeTaraflingerBlock(attackerLocation, pitch, distance, i, attacker, attackerLocation);
                    } else if (i == 9) {
                        attackerLocation.setY(attackerLocation.getY() - 1);
                        attackerLocation.setX(attackerLocation.getX() - 2);
                        attackerLocation.setZ(attackerLocation.getZ() + 1);
                        Block block = attackerLocation.getBlock();
                        Material mat = block.getType();
                        makeTaraflingerBlock(attackerLocation, pitch, distance, i, attacker, attackerLocation);
                    } else if (i == 10) {
                        attackerLocation.setY(attackerLocation.getY() - 1);
                        attackerLocation.setZ(attackerLocation.getZ() + 2);
                        Block block = attackerLocation.getBlock();
                        Material mat = block.getType();
                        makeTaraflingerBlock(attackerLocation, pitch, distance, i, attacker, attackerLocation);
                    } else if (i == 11) {
                        attackerLocation.setY(attackerLocation.getY() - 1);
                        attackerLocation.setX(attackerLocation.getX() - 1);
                        attackerLocation.setZ(attackerLocation.getZ() + 2);
                        Block block = attackerLocation.getBlock();
                        Material mat = block.getType();
                        makeTaraflingerBlock(attackerLocation, pitch, distance, i, attacker, attackerLocation);
                    } else if (i == 12) {

                        //////////////////////new
                        attackerLocation.setY(attackerLocation.getY() - 1);
                        attackerLocation.setZ(attackerLocation.getZ() - 1);
                        Block block = attackerLocation.getBlock();
                        Material mat = block.getType();
                        makeTaraflingerBlock(attackerLocation, pitch, distance, i, attacker, attackerLocation);
                    } else if (i == 13) {

                        attackerLocation.setY(attackerLocation.getY() - 1);
                        attackerLocation.setX(attackerLocation.getX() + 1);
                        attackerLocation.setZ(attackerLocation.getZ() - 1);
                        Block block = attackerLocation.getBlock();
                        Material mat = block.getType();
                        makeTaraflingerBlock(attackerLocation, pitch, distance, i, attacker, attackerLocation);
                    } else if (i == 14) {

                        attackerLocation.setY(attackerLocation.getY() - 1);
                        attackerLocation.setX(attackerLocation.getX() + 2);
                        attackerLocation.setZ(attackerLocation.getZ() - 1);
                        Block block = attackerLocation.getBlock();
                        Material mat = block.getType();
                        makeTaraflingerBlock(attackerLocation, pitch, distance, i, attacker, attackerLocation);
                    } else if (i == 15) {

                        attackerLocation.setY(attackerLocation.getY() - 1);
                        attackerLocation.setX(attackerLocation.getX() - 1);
                        attackerLocation.setZ(attackerLocation.getZ() - 1);
                        Block block = attackerLocation.getBlock();
                        Material mat = block.getType();
                        makeTaraflingerBlock(attackerLocation, pitch, distance, i, attacker, attackerLocation);
                    } else if (i == 16) {

                        attackerLocation.setY(attackerLocation.getY() - 1);
                        attackerLocation.setX(attackerLocation.getX() - 2);
                        attackerLocation.setZ(attackerLocation.getZ() - 1);
                        Block block = attackerLocation.getBlock();
                        Material mat = block.getType();
                        makeTaraflingerBlock(attackerLocation, pitch, distance, i, attacker, attackerLocation);
                    } else if (i == 17) {

                        attackerLocation.setY(attackerLocation.getY() - 1);
                        attackerLocation.setX(attackerLocation.getX() - 3);
                        attackerLocation.setZ(attackerLocation.getZ() - 1);
                        Block block = attackerLocation.getBlock();
                        Material mat = block.getType();
                        makeTaraflingerBlock(attackerLocation, pitch, distance, i, attacker, attackerLocation);
                    } else if (i == 18) {

                        attackerLocation.setY(attackerLocation.getY() - 1);
                        attackerLocation.setX(attackerLocation.getX() + 1);
                        attackerLocation.setZ(attackerLocation.getZ() - 2);
                        Block block = attackerLocation.getBlock();
                        Material mat = block.getType();
                        makeTaraflingerBlock(attackerLocation, pitch, distance, i, attacker, attackerLocation);
                    } else if (i == 19) {

                        attackerLocation.setY(attackerLocation.getY() - 1);
                        attackerLocation.setZ(attackerLocation.getZ() - 2);
                        Block block = attackerLocation.getBlock();
                        Material mat = block.getType();
                        makeTaraflingerBlock(attackerLocation, pitch, distance, i, attacker, attackerLocation);
                    } else if (i == 20) {

                        attackerLocation.setY(attackerLocation.getY() - 1);
                        attackerLocation.setX(attackerLocation.getX() - 1);
                        attackerLocation.setZ(attackerLocation.getZ() - 2);
                        Block block = attackerLocation.getBlock();
                        Material mat = block.getType();
                        makeTaraflingerBlock(attackerLocation, pitch, distance, i, attacker, attackerLocation);
                    } else if (i == 21) {

                        attackerLocation.setY(attackerLocation.getY() - 1);
                        attackerLocation.setX(attackerLocation.getX() - 2);
                        attackerLocation.setZ(attackerLocation.getZ() - 2);
                        Block block = attackerLocation.getBlock();
                        Material mat = block.getType();
                        makeTaraflingerBlock(attackerLocation, pitch, distance, i, attacker, attackerLocation);
                    } else if (i == 22) {

                        attackerLocation.setY(attackerLocation.getY() - 1);
                        attackerLocation.setZ(attackerLocation.getZ() - 3);
                        Block block = attackerLocation.getBlock();
                        Material mat = block.getType();
                        makeTaraflingerBlock(attackerLocation, pitch, distance, i, attacker, attackerLocation);
                    } else if (i == 23) {

                        attackerLocation.setY(attackerLocation.getY() - 1);
                        attackerLocation.setX(attackerLocation.getX() - 1);
                        attackerLocation.setZ(attackerLocation.getZ() - 3);
                        Block block = attackerLocation.getBlock();
                        Material mat = block.getType();
                        makeTaraflingerBlock(attackerLocation, pitch, distance, i, attacker, attackerLocation);
                    } else if (i == 24) {

                        attackerLocation.setY(attackerLocation.getY() - 2);
                        attackerLocation.setZ(attackerLocation.getZ() + 1);
                        Block block = attackerLocation.getBlock();
                        Material mat = block.getType();
                        makeTaraflingerBlock(attackerLocation, pitch, distance, i, attacker, attackerLocation);
                    } else if (i == 25) {

                        attackerLocation.setY(attackerLocation.getY() - 2);
                        attackerLocation.setX(attackerLocation.getX() - 1);
                        attackerLocation.setZ(attackerLocation.getZ() + 1);
                        Block block = attackerLocation.getBlock();
                        Material mat = block.getType();
                        makeTaraflingerBlock(attackerLocation, pitch, distance, i, attacker, attackerLocation);
                    } else if (i == 26) {

                        attackerLocation.setY(attackerLocation.getY() - 2);
                        attackerLocation.setX(attackerLocation.getX() + 1);
                        Block block = attackerLocation.getBlock();
                        Material mat = block.getType();
                        makeTaraflingerBlock(attackerLocation, pitch, distance, i, attacker, attackerLocation);
                    } else if (i == 27) {

                        attackerLocation.setY(attackerLocation.getY() - 2);
                        Block block = attackerLocation.getBlock();
                        Material mat = block.getType();
                        makeTaraflingerBlock(attackerLocation, pitch, distance, i, attacker, attackerLocation);
                    } else if (i == 28) {

                        attackerLocation.setY(attackerLocation.getY() - 2);
                        attackerLocation.setX(attackerLocation.getX() - 1);
                        Block block = attackerLocation.getBlock();
                        Material mat = block.getType();
                        makeTaraflingerBlock(attackerLocation, pitch, distance, i, attacker, attackerLocation);
                    } else if (i == 29) {

                        attackerLocation.setY(attackerLocation.getY() - 2);
                        attackerLocation.setX(attackerLocation.getX() - 2);
                        Block block = attackerLocation.getBlock();
                        Material mat = block.getType();
                        makeTaraflingerBlock(attackerLocation, pitch, distance, i, attacker, attackerLocation);
                    } else if (i == 30) {

                        attackerLocation.setY(attackerLocation.getY() - 2);
                        attackerLocation.setX(attackerLocation.getX() + 1);
                        attackerLocation.setZ(attackerLocation.getZ() - 1);
                        Block block = attackerLocation.getBlock();
                        Material mat = block.getType();
                        makeTaraflingerBlock(attackerLocation, pitch, distance, i, attacker, attackerLocation);
                    } else if (i == 31) {

                        attackerLocation.setY(attackerLocation.getY() - 2);
                        attackerLocation.setZ(attackerLocation.getZ() - 1);
                        Block block = attackerLocation.getBlock();
                        Material mat = block.getType();
                        makeTaraflingerBlock(attackerLocation, pitch, distance, i, attacker, attackerLocation);
                    } else if (i == 32) {

                        attackerLocation.setY(attackerLocation.getY() - 2);
                        attackerLocation.setX(attackerLocation.getX() - 1);
                        attackerLocation.setZ(attackerLocation.getZ() - 1);
                        Block block = attackerLocation.getBlock();
                        Material mat = block.getType();
                        makeTaraflingerBlock(attackerLocation, pitch, distance, i, attacker, attackerLocation);
                    } else if (i == 33) {

                        attackerLocation.setY(attackerLocation.getY() - 2);
                        attackerLocation.setX(attackerLocation.getX() - 2);
                        attackerLocation.setZ(attackerLocation.getZ() - 1);
                        Block block = attackerLocation.getBlock();
                        Material mat = block.getType();
                        makeTaraflingerBlock(attackerLocation, pitch, distance, i, attacker, attackerLocation);
                    } else if (i == 34) {

                        attackerLocation.setY(attackerLocation.getY() - 2);
                        attackerLocation.setZ(attackerLocation.getZ() - 2);
                        Block block = attackerLocation.getBlock();
                        Material mat = block.getType();
                        makeTaraflingerBlock(attackerLocation, pitch, distance, i, attacker, attackerLocation);
                    } else if (i == 35) {

                        attackerLocation.setY(attackerLocation.getY() - 2);
                        attackerLocation.setX(attackerLocation.getX() - 1);
                        attackerLocation.setZ(attackerLocation.getZ() - 2);
                        Block block = attackerLocation.getBlock();
                        Material mat = block.getType();
                        makeTaraflingerBlock(attackerLocation, pitch, distance, i, attacker, attackerLocation);
                    } else if (i == 36) {

                        attackerLocation.setY(attackerLocation.getY() - 3);
                        Block block = attackerLocation.getBlock();
                        Material mat = block.getType();
                        makeTaraflingerBlock(attackerLocation, pitch, distance, i, attacker, attackerLocation);
                    } else if (i == 37) {

                        attackerLocation.setY(attackerLocation.getY() - 3);
                        attackerLocation.setX(attackerLocation.getX() - 1);
                        Block block = attackerLocation.getBlock();
                        Material mat = block.getType();
                        makeTaraflingerBlock(attackerLocation, pitch, distance, i, attacker, attackerLocation);
                    } else if (i == 38) {

                        attackerLocation.setY(attackerLocation.getY() - 3);
                        attackerLocation.setZ(attackerLocation.getZ() - 1);
                        Block block = attackerLocation.getBlock();
                        Material mat = block.getType();
                        makeTaraflingerBlock(attackerLocation, pitch, distance, i, attacker, attackerLocation);
                    } else if (i == 39) {

                        attackerLocation.setY(attackerLocation.getY() - 3);
                        attackerLocation.setZ(attackerLocation.getZ() - 1);
                        attackerLocation.setX(attackerLocation.getX() - 1);
                        Block block = attackerLocation.getBlock();
                        Material mat = block.getType();
                        makeTaraflingerBlock(attackerLocation, pitch, distance, i, attacker, attackerLocation);
                    }


                }


            }
        }
    }


    private static void makeTaraflingerBlock(Location attackerLocation, double pitch, double distance, int i, Player attacker, Location loc) {

        Block block = loc.getBlock();
        Material mat = block.getType();


        attackerLocation.setY(attackerLocation.getY() + 3);


        FallingBlock fb = attacker.getWorld().spawnFallingBlock(attackerLocation, Material.BLACK_CONCRETE, (byte) 0);
        fb.setDropItem(false);
        fb.setCancelDrop(true);

        if (i == 0) {
            String customTag = "tarraFallingBlock";
            MetadataValue customTagValue = new FixedMetadataValue(lifestealSmp, customTag);
            fb.setMetadata(customTag, customTagValue);
        }

        //if(mat == Material.AIR){
        //    fb.setBlockData(Material.MAGMA_BLOCK.createBlockData());
        fb.setBlockData(mat.createBlockData());


        if (pitch < 0) {
            pitch = Math.abs(pitch) + 100;
        }

        distance = pitch / 100;


        Vector velocity = attacker.getLocation().getDirection().multiply(distance);
        fb.setVelocity(velocity);

    }


}

