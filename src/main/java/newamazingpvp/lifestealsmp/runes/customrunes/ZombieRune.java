package newamazingpvp.lifestealsmp.runes.customrunes;

import newamazingpvp.lifestealsmp.runes.customrunes.RuneSample;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.EntityType;
import org.bukkit.event.entity.EntityDamageByEntityEvent;

import java.util.ArrayList;
import java.util.List;

public class ZombieRune extends RuneSample<EntityDamageByEntityEvent> {

    public ZombieRune() {
        super(
                ChatColor.LIGHT_PURPLE + "" + ChatColor.MAGIC + "E" + ChatColor.GOLD + ChatColor.BOLD + " Zombie Rune " + ChatColor.LIGHT_PURPLE + ChatColor.MAGIC + "E",
                getZombieRuneLore(),
                Material.NETHER_STAR,
                0.5,
                EntityType.ZOMBIE,
                EntityDamageByEntityEvent.class
        );
    }

    private static List<String> getZombieRuneLore() {
        List<String> lore = new ArrayList<>();
        lore.add(ChatColor.DARK_PURPLE + "[Item just needs to be in your inventory]");
        lore.add(ChatColor.YELLOW + "[Rare chance to drop from zombies]");
        lore.add(" ");
        lore.add(ChatColor.YELLOW + "" + ChatColor.BOLD + "ZOMBIE RUNE ABILITY:");
        lore.add(ChatColor.LIGHT_PURPLE + "Grants a special ability.");
        return lore;
    }

    @Override
    public void applyEffect(EntityDamageByEntityEvent event) {
        /*if (!(event.getDamager() instanceof Player)) return;
        Player attacker = (Player) event.getDamager();

        if (isRuneInInventory(attacker)) {
            addPotionEffect(attacker, new PotionEffect(PotionEffectType.INCREASE_DAMAGE, 100, 0));
        }*/
    }
}
