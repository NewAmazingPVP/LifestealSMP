package newamazingpvp.lifestealsmp.utility;

import org.bukkit.ChatColor;
import org.bukkit.World;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.*;

import static newamazingpvp.lifestealsmp.LifestealSMP.essentials;
import static org.bukkit.Bukkit.getServer;

public class Utils {
    private static final int MAX_SIZE = 14;
    private static List<Double> tpsList = new ArrayList<>();
    private static boolean isTriggered = false;

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

    public static boolean isRuneInInventory(Player p, String rune){
        ItemStack[] items = p.getInventory().getContents();

        for (ItemStack item : items) {
            if (item != null) {
                ItemMeta meta = item.getItemMeta();
                if (meta.hasLore()) {
                    if(meta.getLore().toString().toLowerCase().contains(rune.toLowerCase())){
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
        for(int i = 0; i < tpsList.size(); i++){
            total += tpsList.get(i);
        }
        return total / tpsList.size();
    }

    public static void adjustPerformance() {
        double averageTPS = getAverageTPS();

        if (averageTPS < 15.0) {
            isTriggered = true;
            getServer().dispatchCommand(getServer().getConsoleSender(), "vdt viewdistance 2 --duration 1");
            getServer().dispatchCommand(getServer().getConsoleSender(), "vdt simulationdistance 2 --duration 1");
        } else if (averageTPS < 16.0) {
            isTriggered = true;
            getServer().dispatchCommand(getServer().getConsoleSender(), "vdt viewdistance 3 --duration 1");
            getServer().dispatchCommand(getServer().getConsoleSender(), "vdt simulationdistance 2 --duration 1");
        } else if (isTriggered && averageTPS < 17.0) {
            getServer().dispatchCommand(getServer().getConsoleSender(), "vdt viewdistance 4 --duration 2");
            getServer().dispatchCommand(getServer().getConsoleSender(), "vdt simulationdistance 2 --duration 2");
        } else if (isTriggered && averageTPS < 18.0) {
            getServer().dispatchCommand(getServer().getConsoleSender(), "vdt viewdistance 5 --duration 2");
            getServer().dispatchCommand(getServer().getConsoleSender(), "vdt simulationdistance 2 --duration 2");
        } else if (isTriggered && averageTPS < 19.0) {
            getServer().dispatchCommand(getServer().getConsoleSender(), "vdt viewdistance 6 --duration 3");
            getServer().dispatchCommand(getServer().getConsoleSender(), "vdt simulationdistance 3 --duration 3");
        } else if (isTriggered && averageTPS < 19.5) {
            isTriggered = false;
            getServer().dispatchCommand(getServer().getConsoleSender(), "vdt viewdistance 8 --duration 4");
            getServer().dispatchCommand(getServer().getConsoleSender(), "vdt simulationdistance 3 --duration 4");
        }
    }


}
