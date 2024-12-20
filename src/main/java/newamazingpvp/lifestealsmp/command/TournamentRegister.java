package newamazingpvp.lifestealsmp.command;

import net.md_5.bungee.api.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import static newamazingpvp.lifestealsmp.discord.DiscordBot.sendDiscordMessage;
import static newamazingpvp.lifestealsmp.events.TimeManager.SEASON_START_TIME;
import static newamazingpvp.lifestealsmp.events.TimeManager.isTimePassed;
import static newamazingpvp.lifestealsmp.events.TournamentEvent.isTournamentEvent;
import static newamazingpvp.lifestealsmp.events.TournamentEvent.registerPlayer;

public class TournamentRegister implements CommandExecutor {


    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (!isTournamentEvent) {
            if (isTimePassed(SEASON_START_TIME.plusDays(6).plusHours(14)) && !isTimePassed(SEASON_START_TIME.plusDays(7).plusHours(4))) {
                if (sender instanceof Player player) {
                    registerPlayer(player);
                    player.sendMessage("Registered for 1v1 tournament event!");
                    sendDiscordMessage(player.getName() + " has registered for the 1v1 tournament event!", "");
                    return true;
                }
            } else {
                sender.sendMessage(ChatColor.RED + "You can only register for the tournament event on the day of the event.");
            }
        } else {
            sender.sendMessage("Tournament event is already in progress! Next time register before the event.");
        }
        return false;
    }
}