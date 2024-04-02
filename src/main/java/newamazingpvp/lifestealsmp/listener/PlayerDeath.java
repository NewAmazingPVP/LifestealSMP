package newamazingpvp.lifestealsmp.listener;

import com.google.common.collect.Iterables;
import com.google.common.io.ByteArrayDataOutput;
import com.google.common.io.ByteStreams;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.json.simple.JSONObject;

import static newamazingpvp.lifestealsmp.LifestealSMP.lifestealSmp;

public class PlayerDeath implements Listener {
    @EventHandler
    public void onDeath(PlayerDeathEvent e) {
        Player player = e.getEntity();
        /*ICombatLogX plugin = getAPI();
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
        }*/
        Player Gamer = e.getEntity();
        int[] pos = {Gamer.getLocation().getBlockX(), Gamer.getLocation().getBlockY(), Gamer.getLocation().getBlockZ()};
        Gamer.sendMessage(ChatColor.BOLD + "" + ChatColor.GOLD +
                "You Died At:" +
                "  X:" + pos[0] +
                "  Y:" + pos[1] +
                "  Z:" + pos[2] + " in " + Gamer.getLocation().getWorld().toString());
        /*ByteArrayDataOutput out = ByteStreams.newDataOutput();
        out.writeUTF("Server");

        JSONObject dataObject = new JSONObject();
        dataObject.put("message", e.getDeathMessage());
        dataObject.put("category", "death");
        dataObject.put("playerName", e.getPlayer().getName());

        out.writeUTF(dataObject.toJSONString());

        Player pl = Iterables.getFirst(Bukkit.getOnlinePlayers(), null);

        if (pl != null) {
            pl.sendPluginMessage(lifestealSmp, "BungeeCord", out.toByteArray());
        }*/
    }
}
