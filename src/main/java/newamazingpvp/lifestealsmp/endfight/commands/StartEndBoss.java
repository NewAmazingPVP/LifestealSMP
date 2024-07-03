package newamazingpvp.lifestealsmp.endfight.commands;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import static newamazingpvp.lifestealsmp.endfight.bossevents.PreBossStage.startPreBoss;

public class StartEndBoss implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if(sender instanceof Player){
            Player player = (Player) sender;
            startPreBoss(player);

        }

        return true;
    }

}
