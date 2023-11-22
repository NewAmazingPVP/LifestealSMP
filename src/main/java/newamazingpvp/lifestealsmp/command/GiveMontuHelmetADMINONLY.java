package newamazingpvp.lifestealsmp.command;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.SkullMeta;

import java.util.UUID;

public class GiveMontuHelmetADMINONLY implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (sender instanceof Player) {
            Player player = (Player) sender;
            ItemStack MintyHelm = new ItemStack(Material.PLAYER_HEAD);
            SkullMeta meta = (SkullMeta) MintyHelm.getItemMeta();

            meta.setOwningPlayer(Bukkit.getOfflinePlayer(UUID.fromString("398d815c-684b-4814-9401-18b1d5b8bd1e")));
            meta.setDisplayName(ChatColor.GOLD + "" + ChatColor.BOLD + "Montu Helmet");

            MintyHelm.setItemMeta(meta);
            player.getInventory().addItem(MintyHelm);

            player.playSound(player.getLocation(), Sound.BLOCK_NOTE_BLOCK_PLING, 1.0f, 2.0f);
            player.sendMessage(ChatColor.GREEN + "Giving Item!");
            return true;
        }

        return false;
    }
}