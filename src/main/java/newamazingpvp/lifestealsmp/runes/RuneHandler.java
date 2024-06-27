package newamazingpvp.lifestealsmp.runes;

import newamazingpvp.lifestealsmp.runes.Rune;
import newamazingpvp.lifestealsmp.runes.WaterRune;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDeathEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class RuneHandler implements Listener {
    private final List<Rune> runes;

    public RuneHandler() {
        runes = new ArrayList<>();
        runes.add(new WaterRune());

    }

    @EventHandler
    public void onMobDeath(EntityDeathEvent event) {
        Entity entity = event.getEntity();
        if(event.getEntity().getKiller() == null) return;
        Player player = event.getEntity().getKiller();
        Random random = new Random();

        for (Rune rune : runes) {
            if(entity.getType() == rune.getMob()) {
                if (random.nextDouble() < rune.getDropRate()) {
                    ItemStack runeItem = new ItemStack(Material.PAPER);
                    ItemMeta meta = runeItem.getItemMeta();
                    meta.setDisplayName(rune.getName());
                    List<String> lore = new ArrayList<>();
                    lore.add(ChatColor.DARK_PURPLE + "[Item just needs to be in your inventory]");
                    lore.add(ChatColor.YELLOW + "[Rare chance to drop from " + rune.getMob().toString() + "]");
                    lore.add(" ");
                    lore.add(ChatColor.YELLOW + "" + ChatColor.BOLD + rune.getMob().toString() + " RUNE ABILITY:");
                    lore.add(rune.getLore());
                    meta.setLore(lore);
                    runeItem.setItemMeta(meta);
                    entity.getWorld().dropItemNaturally(entity.getLocation(), runeItem);
                    player.sendMessage(ChatColor.LIGHT_PURPLE + "" + ChatColor.BOLD + "RUNE DROP!" + ChatColor.GOLD + " " + rune.getName());
                }
            }
        }
    }
}
