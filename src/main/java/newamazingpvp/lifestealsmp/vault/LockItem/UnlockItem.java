package newamazingpvp.lifestealsmp.vault.LockItem;

import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.List;

public class UnlockItem implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        Player player = (Player) sender;

        ItemStack item = player.getInventory().getItemInMainHand();

        if (item.getType().equals(Material.AIR)) {
            sender.sendMessage("§cYou can't unlock air!");
            return false;
        }

        ItemMeta meta = item.getItemMeta();

        List<String> lore = meta.getLore();
        assert lore != null;

        for (int i = 0; i < lore.size(); i++) {
            if (lore.get(i).contains("§\uD83D\uDD12")) {
                lore.remove(i);
            }
        }

        meta.setLore(lore);

        sender.sendMessage("§aUnlocked " + meta.getDisplayName());

        return true;
    }

}
