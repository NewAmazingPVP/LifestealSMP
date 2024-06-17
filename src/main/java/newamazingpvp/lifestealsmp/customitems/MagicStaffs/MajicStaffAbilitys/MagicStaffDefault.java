package newamazingpvp.lifestealsmp.customitems.MagicStaffs.MajicStaffAbilitys;


import newamazingpvp.lifestealsmp.utility.CooldownManager;
import org.bukkit.*;
import org.bukkit.entity.Entity;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.util.Vector;

import java.util.HashMap;


import java.util.Map;

import static newamazingpvp.lifestealsmp.customitems.MagicStaffs.MagicStaffUtils.staffBeamTexture.beamTextureMaker;
import static newamazingpvp.lifestealsmp.customitems.MagicStaffs.MagicStaffUtils.staffSound.playMagicStaffSound;

public class MagicStaffDefault implements Listener {


    public static void defaultStaffAbility(Player attacker, ItemMeta meta, Location location, Vector attackerLookDir, Entity target) {

        if (meta.hasLore() && meta.getLore().toString().contains(ChatColor.DARK_PURPLE + "Shoots a beam of power dealing " + ChatColor.RED + "1❤")) {

            beamTextureMaker(attacker, location, attackerLookDir, Color.GRAY, 2.0F, Color.GRAY, 2.0F);
            playMagicStaffSound(attacker, Sound.BLOCK_BEACON_POWER_SELECT, 2.0f, Sound.ENTITY_FIREWORK_ROCKET_TWINKLE, 2.0f);
            ((LivingEntity) target).damage(1);


        }
    }
}
























