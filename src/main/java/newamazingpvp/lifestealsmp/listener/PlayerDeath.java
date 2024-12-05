package newamazingpvp.lifestealsmp.listener;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;

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
        String worldName = Gamer.getLocation().getWorld().getName();

        worldName = switch (worldName) {
            case "world" -> "Overworld";
            case "world_nether" -> "Nether";
            case "world_the_end" -> "End";
            default -> worldName;
        };

        Gamer.sendMessage(ChatColor.BOLD + "" + ChatColor.GOLD + "You Died At:" + " X:" + pos[0] + " Y:" + pos[1] + " Z:" + pos[2] + " in " + worldName);
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
