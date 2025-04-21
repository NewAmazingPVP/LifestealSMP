package newamazingpvp.lifestealsmp.TrimsUpdate.TrimsListeners.Utils;

import org.bukkit.Bukkit;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Item;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.player.PlayerFishEvent;
import org.bukkit.inventory.meta.trim.TrimPattern;

import static newamazingpvp.lifestealsmp.Idea_Vault.Fishing.FishingLootGen.generateFishingDrop;
import static newamazingpvp.lifestealsmp.TrimsUpdate.TrimsListeners.Utils.GetArmorTrimSet.GetArmorTrimSet.getArmorTrimSet;

public class TrimListenersEntityDamageEntity implements Listener {





    @EventHandler
    public void onEntityDamage(EntityDamageByEntityEvent event) {
        Entity damager = event.getDamager();

        if (damager instanceof Player attacker) {

            if (getArmorTrimSet(attacker, TrimPattern.SENTRY)) {
                attacker.sendMessage("SENTRY Trigger");
            }
//            if (getArmorTrimSet(attacker, TrimPattern.BOLT)) {
//                attacker.sendMessage("BOLT Trigger");
//            }
            if (getArmorTrimSet(attacker, TrimPattern.EYE)) {
                attacker.sendMessage("EYE Trigger");
            }
            if (getArmorTrimSet(attacker, TrimPattern.DUNE)) {
                attacker.sendMessage("DUNE Trigger");
            }
            if (getArmorTrimSet(attacker, TrimPattern.RIB)) {
                attacker.sendMessage("RIB Trigger");
            }
            if (getArmorTrimSet(attacker, TrimPattern.COAST)) {
                attacker.sendMessage("COAST Trigger");
            }
//            if (getArmorTrimSet(attacker, TrimPattern.FLOW)) {
//                attacker.sendMessage("FLOW Trigger");
//            }
            if (getArmorTrimSet(attacker, TrimPattern.HOST)) {
                attacker.sendMessage("HOST Trigger");
            }
            if (getArmorTrimSet(attacker, TrimPattern.RAISER)) {
                attacker.sendMessage("RAISER Trigger");
            }
            if (getArmorTrimSet(attacker, TrimPattern.SHAPER)) {
                attacker.sendMessage("SHAPER Trigger");
            }
            if (getArmorTrimSet(attacker, TrimPattern.SILENCE)) {
                attacker.sendMessage("SILENCE Trigger");
            }
            if (getArmorTrimSet(attacker, TrimPattern.SNOUT)) {
                attacker.sendMessage("SNOUT Trigger");
            }
            if (getArmorTrimSet(attacker, TrimPattern.SPIRE)) {
                attacker.sendMessage("SPIRE Trigger");
            }
            if (getArmorTrimSet(attacker, TrimPattern.TIDE)) {
                attacker.sendMessage("TIDE Trigger");
            }
            if (getArmorTrimSet(attacker, TrimPattern.VEX)) {
                attacker.sendMessage("VEX Trigger");
            }
            if (getArmorTrimSet(attacker, TrimPattern.WARD)) {
                attacker.sendMessage("WARD Trigger");
            }
            if (getArmorTrimSet(attacker, TrimPattern.WAYFINDER)) {
                attacker.sendMessage("WAYFINDER Trigger");
            }
            if (getArmorTrimSet(attacker, TrimPattern.WILD)) {
                attacker.sendMessage("WILD Trigger");
            }


        }
    }


}
