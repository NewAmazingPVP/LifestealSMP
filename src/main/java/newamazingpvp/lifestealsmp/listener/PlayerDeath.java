package newamazingpvp.lifestealsmp.listener;

import com.github.sirblobman.combatlogx.api.ICombatLogX;
import com.github.sirblobman.combatlogx.api.manager.IDeathManager;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.PluginManager;

import java.util.List;

import static org.bukkit.Bukkit.getServer;

public class PlayerDeath implements Listener {
    public ICombatLogX getAPI() {
        PluginManager pluginManager = Bukkit.getPluginManager();
        Plugin plugin = pluginManager.getPlugin("CombatLogX");
        return (ICombatLogX) plugin;
    }

    @EventHandler
    public void onDeath(PlayerDeathEvent e) {
        Player player = e.getEntity();
        ICombatLogX plugin = getAPI();
        IDeathManager deathManager = plugin.getDeathManager();

        if (deathManager.wasPunishKilled(player)) {
            double amount = player.getMaxHealth();
            player.setMaxHealth(amount - 2);
            List<Entity> trackedEnemies = deathManager.getTrackedEnemies(player);
            for (Entity p : trackedEnemies) {
                if (p instanceof Player) {
                    Player pl = (Player) p;
                    double addAmount = pl.getMaxHealth();
                    if (addAmount <= 18) {
                        pl.setMaxHealth(addAmount + 2);
                    } else {
                        getServer().dispatchCommand(getServer().getConsoleSender(), "lsgive heart_item 1 " + pl.getName());
                        pl.sendMessage(ChatColor.DARK_GREEN + "You were given a heart item because you have max health");
                    }
                }
            }
        }
        Player Gamer = e.getEntity();
        int[] pos = {Gamer.getLocation().getBlockX(), Gamer.getLocation().getBlockY(), Gamer.getLocation().getBlockZ()};
        Gamer.sendMessage(ChatColor.BOLD + "" + ChatColor.GOLD +
                "You Died At:" +
                "  X:" + pos[0] +
                "  Y:" + pos[1] +
                "  Z:" + pos[2] + " in " + Gamer.getLocation().getWorld().toString());
    }
}
