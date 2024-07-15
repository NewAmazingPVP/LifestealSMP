package newamazingpvp.lifestealsmp.unused.endfight.commands;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import static newamazingpvp.lifestealsmp.unused.endfight.BossFightMainClass.bossRunning;
import static newamazingpvp.lifestealsmp.unused.endfight.BossFightMainClass.preBoss;
import static newamazingpvp.lifestealsmp.unused.endfight.bossevents.PreBossStage.preBossCancelTimer;

public class StopEndBoss implements CommandExecutor {


    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if (sender instanceof Player player) {
            player.sendMessage(ChatColor.RED + "" + ChatColor.BOLD + "Stopped the boss fight!");

            bossRunning = false;
            preBoss = false;
            preBossCancelTimer();

        }

        return true;
    }

}
