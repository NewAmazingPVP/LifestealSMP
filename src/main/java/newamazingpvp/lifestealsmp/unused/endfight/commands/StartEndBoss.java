package newamazingpvp.lifestealsmp.unused.endfight.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import static newamazingpvp.lifestealsmp.unused.endfight.bossevents.PreBossStage.startPreBoss;

public class StartEndBoss implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if (sender instanceof Player player) {
            startPreBoss(player);

        }

        return true;
    }

}
