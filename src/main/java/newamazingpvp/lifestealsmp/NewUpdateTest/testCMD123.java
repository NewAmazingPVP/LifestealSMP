package newamazingpvp.lifestealsmp.NewUpdateTest;

import org.bukkit.BanList;
import org.bukkit.Bukkit;
import org.bukkit.OfflinePlayer;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class testCMD123 implements CommandExecutor{
        @Override
        public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

            Player player = (Player) sender;

            player.sendMessage("testttttttttttttt");

            return true;
        }
    }

