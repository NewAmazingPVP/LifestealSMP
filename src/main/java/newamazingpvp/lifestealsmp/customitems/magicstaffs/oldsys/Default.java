package newamazingpvp.lifestealsmp.customitems.magicstaffs.oldsys;


import newamazingpvp.lifestealsmp.utility.CooldownManager;
import org.bukkit.*;
import org.bukkit.entity.Entity;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.util.Vector;

import java.util.HashMap;


import java.util.Map;

import static newamazingpvp.lifestealsmp.customitems.magicstaffs.utils.BeamTexture.beamTextureMaker;
import static newamazingpvp.lifestealsmp.customitems.magicstaffs.utils.StaffSound.playMagicStaffSound;

public class Default implements Listener {


    private static final Map<Player, CooldownManager> MagicStaffCooldowns = new HashMap<>();
    private static final double MagicStaffCooldown = 3;


    public static void defaultStaffAbility(Player attacker, ItemMeta meta, Location location, Vector attackerLookDir, Entity target) {

        CooldownManager cooldown = MagicStaffCooldowns.getOrDefault(attacker, new CooldownManager());

        if (!cooldown.isOnCooldown()) {

            cooldown.setCooldown(MagicStaffCooldown);
            MagicStaffCooldowns.put(attacker, cooldown);

            if (meta.hasLore() && meta.getLore().toString().contains(ChatColor.DARK_PURPLE + "Shoots a beam of power dealing " + ChatColor.RED + "1❤")) {

                beamTextureMaker(attacker, location, attackerLookDir, Color.GRAY, 2.0F, Color.GRAY, 2.0F);
                playMagicStaffSound(attacker, Sound.BLOCK_BEACON_POWER_SELECT, 2.0f, Sound.ENTITY_FIREWORK_ROCKET_TWINKLE, 2.0f);
                ((LivingEntity) target).damage(1);
            }
        }else {
            attacker.sendActionBar(ChatColor.RED + "" + ChatColor.BOLD + "Cooldown Active For " + cooldown.getRemainingSeconds());
        }
    }
}
























