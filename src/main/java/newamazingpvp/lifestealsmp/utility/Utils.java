package newamazingpvp.lifestealsmp.utility;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.*;

import static newamazingpvp.lifestealsmp.LifestealSMP.essentials;
import static newamazingpvp.lifestealsmp.blacklistener.AntiEnd.isEndEnabled;
import static org.bukkit.Bukkit.getServer;

public class Utils {
    private static final int MAX_SIZE = 30;
    private static final List<Double> tpsList = new ArrayList<>();
    private static boolean isTriggered = false;
    private static CooldownManager tpsCooldown = new CooldownManager();

    public static void addItemOrDrop(Player player, ItemStack itemStack, String fullInventoryMessage) {
        if (player.getInventory().firstEmpty() != -1) {
            player.getInventory().addItem(itemStack);
        } else {
            World world = player.getWorld();
            world.dropItem(player.getLocation(), itemStack);
            player.sendMessage(ChatColor.GRAY + fullInventoryMessage);
        }
    }

    public static void setPrefix(Player p, String s) {
        essentials.getUser(p.getUniqueId()).setNickname(ChatColor.translateAlternateColorCodes('&', s) + " " + p.getName());
    }

    public static String getPrefix(Player p) {
        return essentials.getUser(p.getUniqueId()).getNickname();
    }

    public static boolean isRuneInInventory(Player p, String rune) {
        ItemStack[] items = p.getInventory().getContents();

        for (ItemStack item : items) {
            if (item != null) {
                ItemMeta meta = item.getItemMeta();
                if (meta.hasLore()) {
                    if (meta.getLore().toString().toLowerCase().contains(rune.toLowerCase())) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public static void startTPSTracking() {
        Timer timer = new Timer();
        timer.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                double currentTPS = getCurrentTPS();
                addTPS(currentTPS);
            }
        }, 0, 1000);
    }

    public static double getCurrentTPS() {
        OptionalDouble tpsTest = Arrays.stream(getServer().getTPS()).findFirst();
        double tps = tpsTest.orElse(20.0);
        return Math.min(tps, 20.0);
    }

    public static void addTPS(double tps) {
        if (tpsList.size() >= MAX_SIZE) {
            tpsList.remove(0);
        }
        tpsList.add(tps);
    }

    public static double getAverageTPS() {
        double total = 0.0;
        for (Double aDouble : tpsList) {
            total += aDouble;
        }
        return total / tpsList.size();
    }

    public static void adjustPerformance() {
        double averageTPS = getAverageTPS();
        if (tpsCooldown.isOnCooldown()) return;

        if (averageTPS < 15.0) {
            triggerActions("setview 2 2");
        } else if (averageTPS < 16.0) {
            triggerActions("setview 3 2");
        } else if (isTriggered) {
            if (averageTPS < 17.0) {
                triggerActions("setview 4 2");
            } else if (averageTPS < 18.0) {
                triggerActions("setview 5 2");
            } else if (averageTPS < 19.0) {
                triggerActions("setview 6 2");
            } else if (averageTPS < 19.5) {
                triggerActions("setview 7 2", "chunky continue");
            } else if (averageTPS > 19.5) {
                resetActions();
            }
        }
    }

    private static void triggerActions(String... commands) {
        isTriggered = true;
        for (String command : commands) {
            getServer().dispatchCommand(getServer().getConsoleSender(), command);
        }
        if (!isEndEnabled()) {
            getServer().dispatchCommand(getServer().getConsoleSender(), "setview 2 2 world_the_end");
        }
        tpsCooldown.setCooldown(MAX_SIZE);
    }

    private static void resetActions() {
        int onlinePlayers = Bukkit.getOnlinePlayers().size();
        if(onlinePlayers > 24){
            triggerActions("setview 5 2", "chunky continue");
        } else if (onlinePlayers > 19) {
            triggerActions("setview 7 2", "chunky continue");
        } else if (onlinePlayers > 14) {
            triggerActions("setview 8 3", "chunky continue");
        } else {
            triggerActions("setview 10 6", "chunky continue");
        }
        isTriggered = false;
    }

    public static void updateLore(Player player) {
        for (ItemStack item : player.getInventory().getContents()) {
            if (item == null) continue;
            if (item.getType() == Material.DRAGON_EGG) {
                ItemMeta meta = item.getItemMeta();
                List<String> lore = new ArrayList<>(List.of(ChatColor.DARK_PURPLE + "Have in inventory for " + ChatColor.GOLD + "10%" + ChatColor.DARK_PURPLE + " less damage!"));
                meta.setLore(lore);
                item.setItemMeta(meta);
                continue;
            }
            if (item.hasItemMeta()) {
                ItemMeta meta = item.getItemMeta();
                if (meta != null && meta.hasLore()) {
                    List<String> lore = meta.getLore();
                    if (lore != null && lore.get(0).contains("Use To Craft Extra Hearts!")) {
                        lore.clear();
                        meta.setDisplayName(ChatColor.GOLD + "" + ChatColor.BOLD + "Severed Mob Heart");
                        lore.add(ChatColor.DARK_PURPLE + "Use To Craft Extra Hearts!");
                        meta.setLore(lore);
                        item.setItemMeta(meta);
                    } else if (lore != null && lore.get(0).contains("U$e To Cr")) {
                        lore.clear();
                        meta.setDisplayName(ChatColor.GOLD + "" + ChatColor.MAGIC + "LL" + ChatColor.GOLD + ChatColor.BOLD + "Corrupted Mob Soul" + ChatColor.GOLD + ChatColor.MAGIC + "LL");
                        lore.add(ChatColor.DARK_PURPLE + "U$e To Cr" + ChatColor.MAGIC + "a" + ChatColor.DARK_PURPLE + "ft Extra Hearts!" + ChatColor.MAGIC + "L");
                        meta.setLore(lore);
                        item.setItemMeta(meta);
                    }
                }
            }
        }
    }
}
