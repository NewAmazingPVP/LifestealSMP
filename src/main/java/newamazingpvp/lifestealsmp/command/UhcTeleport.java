package newamazingpvp.lifestealsmp.command;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import static newamazingpvp.lifestealsmp.events.UHCPvPEvent.*;
import static newamazingpvp.lifestealsmp.game.CombatLog.isInCombat;

public class UhcTeleport implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (sender instanceof Player player) {
            if (isUhcEvent) {
                if (isInCombat(player)) {
                    player.sendMessage("You cannot teleport during combat");
                    return true;
                }
                if (args.length > 0 && args[0].equalsIgnoreCase("back")) {
                    teleportBack(player);
                } else {
                    teleportToPvPWorld(player);
                }
                return true;
            } else {
                player.sendMessage("No UHC PvP event is currently running.");
                return true;
            }
        } else {
            sender.sendMessage("Only players can use this command.");
            return true;
        }
    }
}
