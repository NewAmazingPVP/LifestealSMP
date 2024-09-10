package newamazingpvp.lifestealsmp.command;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Sound;
import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.HashMap;

import static newamazingpvp.lifestealsmp.customitems.utils.ItemStacks.extraHeart;

public class LSwithdraw implements CommandExecutor {

    private static final HashMap<String, Long> cooldowns = new HashMap<>();
    private static final long COOLDOWN_TIME = 6 * 60 * 60 * 1000; // 6 hours in milliseconds

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (!(sender instanceof Player player)) {
            sender.sendMessage(ChatColor.RED + "This command can only be executed by players.");
            return true;
        }

        if (player.getWorld().getName().equals("world") && player.getLocation().distance(Bukkit.getWorld("world").getSpawnLocation()) < 500) {
            player.sendMessage(ChatColor.RED + "You are not allowed to withdraw hearts in vicinity of spawn");
            return true;
        }

        /*
        if(getPlaytime(player) < 216000){
            player.sendMessage(ChatColor.RED + "You are not allowed to withdraw hearts with less than 3 hours of playtime");
            return true;
        }*/

        if (hasCooldown(player)) {
            long timeRemaining = getCooldownTime(player);
            player.sendMessage(ChatColor.RED + "You must wait " + formatTime(timeRemaining) + " before using this command again.");
            return true;
        }

        if (player.getMaxHealth() <= 2) {
            player.sendMessage(ChatColor.RED + "If you withdraw any more you will die...");
        } else {
            setCooldown(player);
            player.setMaxHealth(player.getMaxHealth() - 2);
            player.sendMessage(ChatColor.RED + "" + ChatColor.BOLD + "-1 Heart!");
            //player.sendMessage(ChatColor.GRAY + "(Boosting using this command will result in you being banned)");

            if (player.getInventory().firstEmpty() != -1) {
                player.getInventory().addItem(extraHeart());
            } else {
                World world = player.getWorld();
                world.dropItem(player.getLocation(), extraHeart());
                player.sendMessage(ChatColor.GRAY + "Heart was dropped because your inventory was full");
            }

            player.playSound(player.getLocation(), Sound.BLOCK_PORTAL_TRIGGER, 1.0f, 2.0f);
            player.playSound(player.getLocation(), Sound.BLOCK_NOTE_BLOCK_PLING, 1.0f, 2.0f);
            return true;
        }

        return true;
    }

    private boolean hasCooldown(Player player) {
        return cooldowns.containsKey(player.getName()) && System.currentTimeMillis() - cooldowns.get(player.getName()) < COOLDOWN_TIME;
    }

    private long getCooldownTime(Player player) {
        return COOLDOWN_TIME - (System.currentTimeMillis() - cooldowns.get(player.getName()));
    }

    public static void setCooldown(Player player) {
        cooldowns.put(player.getName(), System.currentTimeMillis());
    }

    private String formatTime(long milliseconds) {
        long minutes = (milliseconds / (1000 * 60)) % 60;
        long seconds = (milliseconds / 1000) % 60;
        return String.format("%02d:%02d", minutes, seconds);
    }
}
