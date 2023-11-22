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

            meta.setOwningPlayer(Bukkit.getOfflinePlayer(UUID.fromString("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvMzA3MGZhZDRkYTQzMGZjMjQxNDE1NDI5MThjYTE4NDgwM2Q3ZjUwYThhOGUyNjNkMDMzMWUzZmQ2MjAyOTMzNiJ9fX0")));
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