package newamazingpvp.lifestealsmp.endfight.commands;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import static newamazingpvp.lifestealsmp.endfight.BossFightMainClass.bossRunning;
import static newamazingpvp.lifestealsmp.endfight.BossFightMainClass.preBoss;
import static newamazingpvp.lifestealsmp.endfight.bossevents.PreBossStage.preBossCancelTimer;

public class BossQuickStart implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if(!bossRunning && !preBoss) {
            if (sender instanceof Player) {
                Player player = (Player) sender;
                player.sendMessage(ChatColor.GREEN + "" + ChatColor.BOLD + "Quick Started the boss");
                Bukkit.broadcastMessage(ChatColor.DARK_RED + "" + ChatColor.BOLD + "Fight Starting!");

                bossRunning = true;

                preBossCancelTimer();

            }else{
                sender.sendMessage(ChatColor.RED + "" + ChatColor.BOLD + "[Error] The pre boss phase has already started or the boss is already running!");
            }
        }

        return true;
    }

}
