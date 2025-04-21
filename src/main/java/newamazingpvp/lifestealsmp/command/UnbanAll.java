package newamazingpvp.lifestealsmp.command;

import io.papermc.paper.ban.BanListType;
import org.bukkit.Bukkit;
import org.bukkit.OfflinePlayer;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class UnbanAll implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        for (OfflinePlayer p : Bukkit.getOfflinePlayers()) {
            if (p.isBanned()) {
                Bukkit.getServer().getBanList(BanListType.PROFILE).pardon(Bukkit.getServer().createProfile(p.getUniqueId()));
            }
        }
        return true;
    }
}
