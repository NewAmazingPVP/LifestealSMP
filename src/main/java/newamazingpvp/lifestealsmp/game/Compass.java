package newamazingpvp.lifestealsmp.game;

import com.destroystokyo.paper.event.player.PlayerArmorChangeEvent;
import net.md_5.bungee.api.ChatMessageType;
import net.md_5.bungee.api.chat.TextComponent;
import org.bukkit.*;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerPortalEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.PlayerInventory;
import org.bukkit.inventory.meta.CompassMeta;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.util.Vector;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import static newamazingpvp.lifestealsmp.LifestealSMP.lifestealSmp;

public class Compass implements CommandExecutor, Listener {

    private static final HashMap<UUID, UUID> trackingPlayers = new HashMap<>();
    private static final HashMap<UUID, Location> lastPortalLocations = new HashMap<>();
    private static final HashMap<UUID, Long> elytraTrackCooldown = new HashMap<>();
    private boolean logOffTracking;

    @EventHandler
    public void onPlayerPortalEvent(PlayerPortalEvent event) {
        lastPortalLocations.put(event.getPlayer().getUniqueId(), event.getFrom());
    }

    @EventHandler
    public void onPlayerQuit(PlayerQuitEvent event) {
        trackingPlayers.remove(event.getPlayer().getUniqueId());
    }

    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent e) {
        if (trackingPlayers.containsValue(e.getPlayer().getUniqueId())) {
            e.getPlayer().sendMessage(ChatColor.DARK_RED + "" + ChatColor.BOLD + "[WARNING] You are being tracked by unspecified amount of players!");
        }

    }


    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (cmd.getName().equalsIgnoreCase("track")) {
            if (!(sender instanceof Player)) {
                sender.sendMessage("This command can only be used by a player!");
                return true;
            }

            Player player = (Player) sender;

            if (args.length == 0) {
                sender.sendMessage("Usage: /track <player>");
                return true;
            }

            if (getCompassFromInventory(player) == null) {
                sender.sendMessage(ChatColor.RED + "You need a compass in your inventory to use this command!");
                return true;
            }

            Player target = Bukkit.getPlayer(args[0]);

            if (target == null) {
                sender.sendMessage(ChatColor.RED + "Player not found!");
                return true;
            }

            /*if (!sender.getName().startsWith(".") && target.getName().startsWith(".")) {
                if (!(trackingPlayers.get(target.getUniqueId()) == ((Player) sender).getUniqueId())) {
                    sender.sendMessage(ChatColor.RED + "You cannot track this bedrock player because you are on java and they are not tracking you!");
                    return true;
                }
            }*/
            Player g = (Player) sender;
            if ((isElytra(g))) {
                sender.sendMessage(ChatColor.RED + "You cannot track while having elytra!!!");
                return true;
            }

            if (isPlayerElytraCooldown(g)) {
                sender.sendMessage(ChatColor.RED + "You have used elytra in last two hours so you cannot track!");
                return true;
            }

            long targetPlaytime = getPlaytime(target);
            long requiredPlaytimeTicks = 3 * 60 * 60 * 20;

            if (targetPlaytime < requiredPlaytimeTicks) {
                long remainingTicks = requiredPlaytimeTicks - targetPlaytime;
                long remainingSeconds = remainingTicks / 20;

                int remainingHours = (int) (remainingSeconds / 3600);
                int remainingMinutes = (int) ((remainingSeconds % 3600) / 60);
                int remainingSecondsLeft = (int) (remainingSeconds % 60);

                String remainingTimeMessage = ChatColor.RED + "Cannot track player because they have newbie protection for " +
                        ChatColor.YELLOW + remainingHours + " hours, " +
                        remainingMinutes + " minutes, " +
                        remainingSecondsLeft + " seconds.";

                sender.sendMessage(remainingTimeMessage);
                return true;
            }

            long targetDeathTime = getDeathTime(target);
            long requiredDeathTime = 15 * 60 * 20;

            if (targetDeathTime < requiredDeathTime) {
                long remainingTicks = requiredDeathTime - targetDeathTime;
                long remainingSeconds = remainingTicks / 20;

                int remainingMinutes = (int) ((remainingSeconds % 3600) / 60);
                int remainingSecondsLeft = (int) (remainingSeconds % 60);

                String remainingTimeMessage = ChatColor.RED + "Cannot track because they died recently and have death protection for " +
                        ChatColor.YELLOW + remainingMinutes + " minutes, " +
                        remainingSecondsLeft + " seconds.";

                sender.sendMessage(remainingTimeMessage);
                return true;
            }

            /*if(diamondBlockCount(player) > 0){
                ItemStack block = new ItemStack(Material.DIAMOND_BLOCK, 1);
                player.getInventory().removeItem(block);
                sender.sendMessage(ChatColor.GREEN + "1 diamond block taken to track player");
            } else {
                sender.sendMessage(ChatColor.RED + "You need a diamond block to track player");
                return true;
            }*/

            trackingPlayers.put(player.getUniqueId(), target.getUniqueId());
            player.sendMessage(ChatColor.GREEN + "Compass is now pointing towards " + target.getName());
            target.sendMessage(ChatColor.DARK_RED + "" + ChatColor.BOLD + "[WARNING] You are being tracked!");
            return true;
        }

        return false;
    }

    public static int diamondBlockCount(Player player) {
        int diamondCount = 0;
        PlayerInventory inventory = player.getInventory();

        for (ItemStack item : inventory.getContents()) {
            if (item != null && item.getType() == Material.DIAMOND_BLOCK) {
                diamondCount += item.getAmount();
            }
        }

        return diamondCount;
    }

    private long getPlaytime(Player player) {
        return player.getStatistic(Statistic.PLAY_ONE_MINUTE);
    }

    private static long getDeathTime(Player player) {
        return player.getStatistic(Statistic.TIME_SINCE_DEATH);
    }

    private static boolean playerDiedRecently(Player target) {
        long targetDeathTime = getDeathTime(target);
        long requiredDeathTime = 15 * 60 * 20;

        return targetDeathTime < requiredDeathTime;
    }

    /*@EventHandler
    private void onPlayerDeath(PlayerDeathEvent e){
        Player player = e.getEntity();
        trackingPlayers.remove(player.getUniqueId());
    }*/

    @EventHandler
    public void onArmorChange(PlayerArmorChangeEvent event) {
        Player player = event.getPlayer();
        ItemStack newArmorPiece = event.getOldItem();

        if (isElytratest(newArmorPiece)) {
            elytraTrackCooldown.remove(player.getUniqueId());
            elytraTrackCooldown.put(player.getUniqueId(), System.currentTimeMillis() + 7200000);
        }
    }

    private static boolean isPlayerElytraCooldown(Player p) {
        Long value = elytraTrackCooldown.get(p.getUniqueId());
        return value != null && value > System.currentTimeMillis();
    }

    private boolean isElytratest(ItemStack t) {
        return t.getType().toString().toLowerCase().contains("elytra");
    }

    private static boolean isElytra(Player p) {
        if (p.getInventory().getChestplate() == null) return false;
        return p.getInventory().getChestplate().getType().toString().toLowerCase().contains("elytra");
    }

    public static void compassUpdate() {
        new BukkitRunnable() {
            public void run() {
                for (UUID playerUUID : trackingPlayers.keySet()) {
                    Player player = Bukkit.getPlayer(playerUUID);

                    if (player == null) {
                        continue;
                    }

                    UUID targetUUID = trackingPlayers.get(playerUUID);
                    Player target = Bukkit.getPlayer(targetUUID);

                    ItemStack compass = getCompassFromInventory(player);

                    if (compass == null) {
                        continue;
                    }
                    String msg;
                    int distance = 0;
                    if (target != null && !playerDiedRecently(target) && !isElytra(player) && !isPlayerElytraCooldown(player)) {
                        if (player.getWorld().getEnvironment() == World.Environment.NORMAL && target.getWorld().getEnvironment() == World.Environment.NORMAL) {
                            setNormalCompass(compass);
                            player.setCompassTarget(target.getLocation());
                            msg = ChatColor.GREEN + "Tracking " + ChatColor.BOLD + target.getName();
                            distance = (int) player.getLocation().distance(target.getLocation());
                        } else {
                            Location targetLocation;
                            if (player.getWorld() == target.getWorld()) {
                                targetLocation = target.getLocation();
                            } else {
                                Location portalLocation = lastPortalLocations.get(target.getUniqueId());
                                targetLocation = (portalLocation != null && player.getWorld() == portalLocation.getWorld()) ? portalLocation : null;
                            }

                            if (targetLocation != null) {
                                setLodestoneCompass(compass, targetLocation);
                                msg = ChatColor.GREEN + "Tracking " + ChatColor.BOLD + target.getName();
                                distance = (int) player.getLocation().distance(targetLocation);
                            } else {
                                msg = (player.getWorld().getEnvironment() != target.getWorld().getEnvironment())
                                        ? ChatColor.RED + "Cannot track player because they are in a different dimension and haven't used a portal yet"
                                        : ChatColor.GREEN + "Tracking " + ChatColor.BOLD + target.getName();
                            }
                        }
                        String dis = calculateDistanceCategory(distance);
                        msg += " \"\"" + dis + "\"\" ";
                        TextComponent textComponent = new TextComponent(msg);
                        player.spigot().sendMessage(ChatMessageType.ACTION_BAR, textComponent);
                        boolean e = isMovingCloser(player, target);
                        player.sendMessage("ur "+ e);
                    } else {
                        setNormalCompass(compass);
                        player.setCompassTarget(generateRandomLocation(player));
                    }
                }

            }
        }.runTaskTimer(lifestealSmp, 0L, 0L); // Update interval for normal compasses
    }


    private static Location generateRandomLocation(Player player) {
        int offsetX = (int) (Math.random() * 201) - 100;
        int offsetZ = (int) (Math.random() * 201) - 100;
        Location playerLocation = player.getLocation();
        int x = playerLocation.getBlockX() + offsetX;
        int z = playerLocation.getBlockZ() + offsetZ;
        return new Location(player.getWorld(), x, 64, z);
    }

    public static String calculateDistanceCategory(double distance) {
        if(distance == 0){
            return "";
        } else if (distance < 100) {
            return "Very close";
        } else if (distance < 300) {
            return "Close";
        } else if (distance < 700) {
            return "Near";
        } else if (distance < 1300) {
            return "Moderate";
        } else if (distance < 2100) {
            return "Far";
        } else if (distance < 3100) {
            return "Distant";
        } else if (distance < 4300) {
            return "Very far";
        } else if (distance < 5700) {
            return "Extremely far";
        } else if (distance < 7300) {
            return "Exceptionally far";
        } else if (distance < 9100) {
            return "Incredibly far";
        } else if (distance < 11100) {
            return "Unreachable";
        } else if (distance < 14000) {
            return "Astronomical";
        }
        return "";
    }
    public static boolean isMovingCloser(Player movingPlayer, Player targetPlayer) {
        Vector velocity = movingPlayer.getVelocity();
        Location targetLoc = targetPlayer.getLocation();

        double distanceNow = movingPlayer.getLocation().distance(targetLoc);

        Vector velocityAdjusted = velocity.clone().multiply(5);
        double distanceNextTick = movingPlayer.getLocation().add(velocityAdjusted).distance(targetLoc);

        return distanceNextTick < distanceNow;
    }
    private static ItemStack getCompassFromInventory(Player player) {
        for (ItemStack item : player.getInventory().getContents()) {
            if (item != null && item.getType() == Material.COMPASS) {
                return item;
            }
        }
        return null;
    }

    private static void setNormalCompass(ItemStack compass) {
        CompassMeta compassMeta = (CompassMeta) compass.getItemMeta();
        assert compassMeta != null;
        if (compassMeta.isLodestoneTracked()) {
            compassMeta.setLodestone(null);
            compassMeta.setLodestoneTracked(false);
            compass.setItemMeta(compassMeta);
        }
    }

    private static void setLodestoneCompass(ItemStack compass, Location location) {
        CompassMeta compassMeta = (CompassMeta) compass.getItemMeta();
        assert compassMeta != null;
        compassMeta.setLodestone(location);
        compassMeta.setLodestoneTracked(true);
        compass.setItemMeta(compassMeta);
    }

}
