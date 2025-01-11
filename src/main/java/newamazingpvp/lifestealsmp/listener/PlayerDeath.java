package newamazingpvp.lifestealsmp.listener;

import com.destroystokyo.paper.profile.PlayerProfile;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.SkullMeta;

import java.net.URL;
import java.util.UUID;

import static newamazingpvp.lifestealsmp.utility.Utils.addItemOrDrop;

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
        Player p = e.getEntity();
        int[] pos = {p.getLocation().getBlockX(), p.getLocation().getBlockY(), p.getLocation().getBlockZ()};
        String worldName = p.getLocation().getWorld().getName();

        worldName = switch (worldName) {
            case "world" -> "Overworld";
            case "world_nether" -> "Nether";
            case "world_the_end" -> "End";
            default -> worldName;
        };

        p.sendMessage(ChatColor.BOLD + "" + ChatColor.GOLD + "You Died At:" + " X:" + pos[0] + " Y:" + pos[1] + " Z:" + pos[2] + " in " + worldName);

        if (player.getKiller() != null) {
            Player killer = player.getKiller();
            ItemStack skull = createHead(player.getUniqueId());
            SkullMeta skullMeta = (SkullMeta) skull.getItemMeta();
            skullMeta.setDisplayName(ChatColor.RED + player.getName() + "'s Head");
            skull.setItemMeta(skullMeta);
            addItemOrDrop(killer, skull, ChatColor.AQUA + "Player head was dropped because your inventory was full.");
        }
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


    public static ItemStack createHead(UUID uuid) {
        PlayerProfile profile = Bukkit.createProfile(uuid);
        ItemStack head = new ItemStack(Material.PLAYER_HEAD);
        SkullMeta skullMeta = (SkullMeta) head.getItemMeta();
        skullMeta.setPlayerProfile(profile);
        return head;
    }
}
