package newamazingpvp.lifestealsmp.game;

import com.destroystokyo.paper.event.player.PlayerArmorChangeEvent;
import net.md_5.bungee.api.ChatMessageType;
import net.md_5.bungee.api.chat.TextComponent;
import newamazingpvp.lifestealsmp.utility.CooldownManager;
import org.bukkit.*;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityPotionEffectEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerKickEvent;
import org.bukkit.event.player.PlayerPortalEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.PlayerInventory;
import org.bukkit.inventory.meta.CompassMeta;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.scheduler.BukkitTask;

import java.util.HashMap;
import java.util.UUID;

import static newamazingpvp.lifestealsmp.LifestealSMP.lifestealSmp;
import static newamazingpvp.lifestealsmp.discord.DiscordListener.isVanished;
import static org.bukkit.Bukkit.getServer;

public class Compass implements CommandExecutor, Listener {

    private static final HashMap<UUID, UUID> trackingPlayers = new HashMap<>();
    private static final HashMap<UUID, Location> lastPortalLocations = new HashMap<>();
    private static final HashMap<UUID, Long> elytraTrackCooldown = new HashMap<>();
    private static final HashMap<UUID, CooldownManager> invisTrackCooldown = new HashMap<>();
    public static int trackingDist = 1000;
    private boolean logOffTracking;
    public static boolean noTrackingDay = false;
    public static double delayDuration = 45;
    public static BukkitTask compassTask;

    @EventHandler
    public void onPlayerPortalEvent(PlayerPortalEvent event) {
        lastPortalLocations.put(event.getPlayer().getUniqueId(), event.getFrom());
    }

    @EventHandler
    public void onPlayerQuit(PlayerQuitEvent event) {
        //log off tracking
        if(trackingDist == 1 || delayDuration <= 1) {
            trackingPlayers.remove(event.getPlayer().getUniqueId());
        }
    }

    @EventHandler
    public void onPlayerKick(PlayerKickEvent event) {
        //log off tracking
        if(trackingDist == 1 || delayDuration <= 1) {
            trackingPlayers.remove(event.getPlayer().getUniqueId());
        }
    }

    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent e) {
        if (trackingPlayers.containsValue(e.getPlayer().getUniqueId())) {
            e.getPlayer().sendMessage(ChatColor.DARK_RED + "" + ChatColor.BOLD + "[WARNING] You are being tracked by unspecified amount of players!" + ChatColor.AQUA + " However logging off won't help, they will still be able to track when you are off");
        }

    }

    @EventHandler
    public void onPlayerEffect(EntityPotionEffectEvent event){
        if(event.getEntity() instanceof Player p){
            if(event.getNewEffect() != null && event.getNewEffect().getType() != null && event.getNewEffect().getType() == PotionEffectType.INVISIBILITY){
                invisTrackCooldown.put(p.getUniqueId(), new CooldownManager(90));
            }
        }
    }

    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (cmd.getName().equalsIgnoreCase("track")) {
            if (!(sender instanceof Player g)) {
                sender.sendMessage("This command can only be used by a player!");
                return true;
            }

            if (noTrackingDay) {
                sender.sendMessage(ChatColor.GOLD + "Today is the no tracking day event, check /discord announcements!");
                return true;
            }

            if (args.length == 0) {
                sender.sendMessage("Usage: /track <player>");
                return true;
            }

            /*if (getCompassFromInventory(player) == null) {
                sender.sendMessage(ChatColor.RED + "You need a compass in your inventory to use this command!");
                return true;
            }*/

            Player target = Bukkit.getPlayer(args[0]);

            if (target == null || isVanished(target)) {
                sender.sendMessage(ChatColor.RED + "Player not found!");
                return true;
            }

            /*if (!sender.getName().startsWith(".") && target.getName().startsWith(".")) {
                if (!(trackingPlayers.get(target.getUniqueId()) == ((Player) sender).getUniqueId())) {
                    sender.sendMessage(ChatColor.RED + "You cannot track this bedrock player because you are on java and they are not tracking you!");
                    return true;
                }
            }*/
            if ((isElytra(g))) {
                sender.sendMessage(ChatColor.RED + "You cannot track while having elytra!!!");
                return true;
            }

            if (isPlayerElytraCooldown(g)) {
                sender.sendMessage(ChatColor.RED + "You have used elytra in last 30 minutes so you cannot track!");
                return true;
            }

            if (isPlayerInvisCooldown(g)) {
                sender.sendMessage(ChatColor.RED + "You have used invisibility effect in past 90 seconds so you cannot track!");
                return true;
            }

            if (isPlayerInvisible(g) || isPlayerInvisible(target)) {
                sender.sendMessage(ChatColor.RED + "Either you or your target is invisible thus cannot be tracked");
                return true;
            }

            long targetPlaytime = getPlaytime(target);
            long requiredPlaytimeTicks = 2 * 60 * 60 * 20;

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

            trackingPlayers.put(g.getUniqueId(), target.getUniqueId());
            g.sendMessage(ChatColor.GREEN + "Tracking vicinity to " + target.getName() + " every " + delayDuration + " seconds");
            double expectedValue = 1.0 / 20;
            double epsilon = 1e-10;
            if (Math.abs(delayDuration - expectedValue) < epsilon) {
                Bukkit.broadcastMessage(ChatColor.BOLD + "" + ChatColor.DARK_RED + "Some player has started tracking /track. Be careful today is insane tracking day event so therefore players will find you very quickly. Keep an eye out by /track-ing everyone to see their distance");
            }
            //player.sendMessage(ChatColor.GREEN + "Tracking quadrant of " + target.getName() + " every " + delayDuration + " seconds");
            //player.sendMessage(ChatColor.GREEN + "Compass is now pointing towards " + target.getName());
            target.sendMessage(ChatColor.DARK_RED + "" + ChatColor.BOLD + "[WARNING] You are being tracked!");
            if(trackingDist == 1 || delayDuration <= 1){
                target.sendMessage( ChatColor.GREEN + " Logging off today will help since today is a tracking event, so log off tracking is disabled for balance");
            } else {
                target.sendMessage( ChatColor.AQUA + " However logging off won't help, they will still be able to track when you are off. Plus tracking is nerfed to just 1k vicinity making it impossible to pinpoint location.");
            }
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

    public static long getPlaytime(Player player) {
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
            elytraTrackCooldown.put(player.getUniqueId(), System.currentTimeMillis() + 1800000);
        }
    }


    private static boolean isPlayerElytraCooldown(Player p) {
        Long value = elytraTrackCooldown.get(p.getUniqueId());
        return value != null && value > System.currentTimeMillis();
    }

    private static boolean isPlayerInvisCooldown(Player p) {
        CooldownManager inst = invisTrackCooldown.get(p.getUniqueId());
        if (inst == null) {
            return false;
        }
        return inst.isOnCooldown();
    }



    private boolean isElytratest(ItemStack t) {
        return t.getType().toString().toLowerCase().contains("elytra");
    }

    private static boolean isElytra(Player p) {
        if (p.getInventory().getChestplate() == null) return false;
        return p.getInventory().getChestplate().getType().toString().toLowerCase().contains("elytra");
    }

    public static void resetCompass(){
        compassTask.cancel();
        compassTask = null;
    }

    public static void compassUpdate() {
        compassTask = new BukkitRunnable() {
            public void run() {
                for (UUID playerUUID : trackingPlayers.keySet()) {
                    Player player = Bukkit.getPlayer(playerUUID);

                    if (player == null) {
                        continue;
                    }

                    UUID targetUUID = trackingPlayers.get(playerUUID);
                    Player target = Bukkit.getPlayer(targetUUID);

                    //ItemStack compass = getCompassFromInventory(player);

                    //if (compass == null) {
                    //    continue;
                    //}
                    String msg;
                    int distance = 0;
                    if (target != null && !playerDiedRecently(target) && !isElytra(player) && !isPlayerElytraCooldown(player) && !noTrackingDay && !(isPlayerInvisible(player) || (isPlayerInvisible(target)))) {
                        if (player.getWorld().getEnvironment() == World.Environment.NORMAL && target.getWorld().getEnvironment() == World.Environment.NORMAL) {
                            //setNormalCompass(compass);
                            //player.setCompassTarget(target.getLocation());
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
                                //setLodestoneCompass(compass, targetLocation);
                                msg = ChatColor.GREEN + "Tracking " + ChatColor.BOLD + target.getName();
                                distance = (int) player.getLocation().distance(targetLocation);
                            } else {
                                msg = (player.getWorld().getEnvironment() != target.getWorld().getEnvironment())
                                        ? ChatColor.RED + "Cannot track player because they are in a different dimension and haven't used a portal yet"
                                        : ChatColor.GREEN + "Tracking " + ChatColor.BOLD + target.getName();
                            }
                        }
                        //String dis = calculateDistanceCategory(distance);
                        if (distance != 0) {
                            //msg += ChatColor.BOLD + " " + distance + " blocks";
                            msg += ChatColor.BOLD + " in vicinity of " + ((distance / trackingDist) + 1) * trackingDist + " blocks";
                        }

                        /*if (!msg.contains("Cannot")) {
                            msg += " coordinates ";
                            msg += (target.getLocation().x() < 0) ? "negative x" : "positive x";
                            msg += " and ";
                            msg += (target.getLocation().z() < 0) ? "negative z" : "positive z";
                        }*/
                        TextComponent textComponent = new TextComponent(msg);
                        player.spigot().sendMessage(ChatMessageType.ACTION_BAR, textComponent);
                        //boolean e = isMovingCloser(player, target);
                        //player.sendMessage("ur "+ e);
                    } else {
                        //setNormalCompass(compass);
                        //player.setCompassTarget(generateRandomLocation(player));
                    }
                }

            }
        }.runTaskTimer(lifestealSmp, 0L, (long)(20.0 * delayDuration));
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
        if (distance < 70) {
            return "1";
        } else if (distance < 200) {
            return "2";
        } else if (distance < 500) {
            return "3";
        } else if (distance < 1000) {
            return "4";
        } else if (distance < 2000) {
            return "5";
        } else if (distance < 3100) {
            return "6";
        } else if (distance < 4300) {
            return "7";
        } else if (distance < 5700) {
            return "8";
        } else if (distance < 7300) {
            return "9";
        } else if (distance < 9100) {
            return "10";
        } else if (distance < 11100) {
            return "11";
        } else if (distance < 14000) {
            return "12";
        }
        return "";
    }

    public static boolean isMovingCloser(Player movingPlayer, Player targetPlayer) {
        double velocityX = movingPlayer.getVelocity().getX();
        double velocityZ = movingPlayer.getVelocity().getZ();
        getServer().broadcastMessage(velocityX + " and y " + velocityZ);
        Location targetLoc = targetPlayer.getLocation();

        double distanceNow = movingPlayer.getLocation().distance(targetLoc);

        double distanceNextTickX = movingPlayer.getLocation().getX() + velocityX * 100;
        double distanceNextTickZ = movingPlayer.getLocation().getZ() + velocityZ * 100;

        Location locationNextTick = new Location(targetPlayer.getWorld(), distanceNextTickX, movingPlayer.getLocation().y(), distanceNextTickZ);

        double distanceNextTick = locationNextTick.distance(targetLoc);

        getServer().broadcastMessage(distanceNextTick + " and distance now " + distanceNow);
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

    public static boolean isPlayerInvisible(Player p) {
        return p.hasPotionEffect((PotionEffectType.INVISIBILITY));
    }

}
