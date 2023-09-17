package newamazingpvp.lifestealsmp.command;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.Statistic;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.PlayerInventory;

import static newamazingpvp.lifestealsmp.game.Compass.getCompassFromInventory;
import static newamazingpvp.lifestealsmp.game.Compass.trackingPlayers;

public class TrackCommand implements CommandExecutor {
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
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
            return true;
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

    private long getDeathTime(Player player) {
        return player.getStatistic(Statistic.TIME_SINCE_DEATH );
    }
}
