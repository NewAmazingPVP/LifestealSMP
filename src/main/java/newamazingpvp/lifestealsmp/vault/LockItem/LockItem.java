package newamazingpvp.lifestealsmp.vault.LockItem;

import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.List;

public class LockItem implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        Player player = (Player) sender;

        ItemStack item = player.getInventory().getItemInMainHand();

        if (item.getType().equals(Material.AIR)) {
            sender.sendMessage("§cYou can't lock air!");
            return false;
        }

        ItemMeta meta = item.getItemMeta();

        List<String> lore = meta.getLore();
        assert lore != null;
        lore.add("§\uD83D\uDD12");
        meta.setLore(lore);

        sender.sendMessage("§aSuccessfully locked " + meta.getDisplayName());

        return true;
    }

}
