package newamazingpvp.lifestealsmp.game;

import net.md_5.bungee.api.ChatMessageType;
import net.md_5.bungee.api.chat.TextComponent;
import org.bukkit.*;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.CompassMeta;
import org.bukkit.scheduler.BukkitRunnable;

import java.util.HashMap;
import java.util.UUID;

import static newamazingpvp.lifestealsmp.LifestealSMP.lifestealSmp;

public class Compass {
    public static HashMap<UUID, UUID> trackingPlayers = new HashMap<>();
    public static HashMap<UUID, Location> lastPortalLocations = new HashMap<>();

    public static void compassUpdate() {
        new BukkitRunnable() {
            public void run() {
                for (UUID playerUUID : trackingPlayers.keySet()) {
                    Player player = Bukkit.getPlayer(playerUUID);
                    if (player != null) {
                        Player target = Bukkit.getPlayer(trackingPlayers.get(playerUUID));
                        ItemStack compass = getCompassFromInventory(player);
                        if (compass != null) {
                            if (target != null) {
                                if (player.getWorld().getEnvironment() == World.Environment.NORMAL && target.getWorld().getEnvironment() == World.Environment.NORMAL) {
                                    setNormalCompass(compass);
                                    player.setCompassTarget(target.getLocation());
                                } else if (player.getWorld() == target.getWorld()) {
                                    setLodestoneCompass(compass, target.getLocation());
                                } else {
                                    Location portalLocation = lastPortalLocations.get(target.getUniqueId());
                                    if (portalLocation != null && player.getWorld() == portalLocation.getWorld()) {
                                        setLodestoneCompass(compass, portalLocation);
                                    }
                                }
                                int distance;
                                if (player.getWorld().getEnvironment() == target.getWorld().getEnvironment()) {
                                    distance = (int) player.getLocation().distance(target.getLocation());
                                } else {
                                    Location portalLocation = lastPortalLocations.get(target.getUniqueId());
                                    if (portalLocation != null && player.getWorld() == portalLocation.getWorld()) {
                                        distance = (int) player.getLocation().distance(portalLocation);
                                    } else {
                                        distance = -1;
                                    }
                                }
                                String message;
                                if (distance >= 0) {
                                    message = ChatColor.GREEN + "Tracking " + ChatColor.BOLD + target.getName() + " " + ChatColor.AQUA + distance + ChatColor.GREEN + " blocks away";
                                } else {
                                    message = ChatColor.RED + "Cannot measure the distance to the player because they are in a different dimension and haven't used a portal yet";
                                }
                                TextComponent textComponent = new TextComponent(message);
                                player.spigot().sendMessage(ChatMessageType.ACTION_BAR, textComponent);
                            } else {
                                setNormalCompass(compass);
                                player.setCompassTarget(generateRandomLocation(player));
                            }
                        }
                    }
                }
            }
        }.runTaskTimer(lifestealSmp, 0L, 0L); // Update interval for normal compasses

        new BukkitRunnable() {
            public void run() {
                for (UUID playerUUID : trackingPlayers.keySet()) {
                    Player player = Bukkit.getPlayer(playerUUID);
                    if (player != null) {
                        ItemStack compass = getCompassFromInventory(player);
                        if (compass != null) {
                            CompassMeta compassMeta = (CompassMeta) compass.getItemMeta();
                            assert compassMeta != null;
                            boolean isLodestone = compassMeta.isLodestoneTracked();
                            if (isLodestone) {
                                Player target = Bukkit.getPlayer(trackingPlayers.get(playerUUID));
                                if (target != null && player.getWorld() == target.getWorld()) {
                                    setLodestoneCompass(compass, target.getLocation());
                                }
                            }
                        }
                    }
                }
            }
        }.runTaskTimer(lifestealSmp, 0L, 20L);
    }


    public static Location generateRandomLocation(Player player) {
        int offsetX = (int) (Math.random() * 201) - 100;
        int offsetZ = (int) (Math.random() * 201) - 100;
        Location playerLocation = player.getLocation();
        int x = playerLocation.getBlockX() + offsetX;
        int z = playerLocation.getBlockZ() + offsetZ;
        return new Location(player.getWorld(), x, 64, z);
    }

    public static ItemStack getCompassFromInventory(Player player) {
        for (ItemStack item : player.getInventory().getContents()) {
            if (item != null && item.getType() == Material.COMPASS) {
                return item;
            }
        }
        return null;
    }

    public static void setNormalCompass(ItemStack compass) {
        CompassMeta compassMeta = (CompassMeta) compass.getItemMeta();
        assert compassMeta != null;
        if (compassMeta.isLodestoneTracked()) {
            compassMeta.setLodestone(null);
            compassMeta.setLodestoneTracked(false);
            compass.setItemMeta(compassMeta);
        }
    }

    public static void setLodestoneCompass(ItemStack compass, Location location) {
        CompassMeta compassMeta = (CompassMeta) compass.getItemMeta();
        assert compassMeta != null;
        compassMeta.setLodestone(location);
        compassMeta.setLodestoneTracked(true);
        compass.setItemMeta(compassMeta);
    }
}
