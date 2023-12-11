package newamazingpvp.lifestealsmp.listener;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.event.player.PlayerKickEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.event.player.PlayerRespawnEvent;
import org.bukkit.inventory.ItemStack;

import java.util.List;

import static newamazingpvp.lifestealsmp.game.CombatLog.*;
import static newamazingpvp.lifestealsmp.game.CustomRecipe.extraHeart;

public class CombatLogListener implements Listener {
    @EventHandler
    public void onPlayerKick(PlayerKickEvent e){
        cancelCombatData(e.getPlayer());
        removeEnemies(e.getPlayer());
    }

    @EventHandler
    public void onPlayerDisconnect(PlayerQuitEvent e){
        if(isInCombat(e.getPlayer())) {
            Player p = e.getPlayer();
            p.setMaxHealth(p.getMaxHealth() - 2);
            if(getCombatTimer(p) <= 85){
                Player winner = getEnemies(p).get(getEnemies(p).size()-1);
                if(!(winner.getMaxHealth() > 38)) {
                    winner.setMaxHealth(winner.getMaxHealth() + 2);
                }  else {
                    if (winner.getInventory().firstEmpty() != -1) {
                        winner.getInventory().addItem(extraHeart());
                        winner.sendMessage(ChatColor.DARK_PURPLE + "You were given heart item because you reached max health!");
                    } else {
                        World world = winner.getWorld();
                        world.dropItem(winner.getLocation(), extraHeart());
                        winner.sendMessage(ChatColor.LIGHT_PURPLE + "Heart was dropped because your inventory was full");
                    }
                }
                }
            p.setHealth(0.0);


            ItemStack[] inventoryContents = p.getInventory().getContents();

            for (int i = 0; i < inventoryContents.length; i++) {
                if (inventoryContents[i] == null) {
                    inventoryContents[i] = new ItemStack(Material.AIR);
                }
            }

            String deathMessage = p.getName() + " was killed instantly due to logging out during combat!";
            PlayerDeathEvent deathEvent = new PlayerDeathEvent(p, List.of(inventoryContents), 0, 0, 0, 0, deathMessage);
            Bukkit.getPluginManager().callEvent(deathEvent);

            cancelCombatData(e.getPlayer());
            removeEnemies(e.getPlayer());
        }
    }

    @EventHandler
    public void onPlayerRespawn(PlayerRespawnEvent e) {
        if(isInCombat(e.getPlayer())){
            cancelCombatData(e.getPlayer());
        }
    }
}
