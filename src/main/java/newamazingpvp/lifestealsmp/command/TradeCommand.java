package newamazingpvp.lifestealsmp.command;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.scheduler.BukkitRunnable;

import java.util.Arrays;

import static newamazingpvp.lifestealsmp.LifestealSMP.lifestealSmp;
import static newamazingpvp.lifestealsmp.listener.TradeInventory.switchItems;

public class TradeCommand implements CommandExecutor {
    public static Inventory inv = Bukkit.getServer().createInventory(null, 54, "Trade");

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (!(sender instanceof Player)) {
            sender.sendMessage("This command can only be used by a player!");
            return true;
        }
        if (args.length == 1) {
            Player target = Bukkit.getPlayer(Arrays.toString(args));
            Player p = (Player) sender;
            target.sendMessage(p.getName() + " send you a trade request! Type /td accept to accept!");

            p.openInventory(inv);
            target.openInventory(inv);
            new BukkitRunnable() {
                @Override
                public void run() {
                    p.closeInventory();
                    target.closeInventory();
                    switchItems(p, target);
                    switchItems(target, p);
                }
            }.runTaskLater(lifestealSmp, 20 * 30);
        }
        return true;
    }
}
