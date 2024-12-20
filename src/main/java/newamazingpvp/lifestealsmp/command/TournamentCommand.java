package newamazingpvp.lifestealsmp.command;

import newamazingpvp.lifestealsmp.events.TournamentEvent;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.time.ZonedDateTime;

import static newamazingpvp.lifestealsmp.LifestealSMP.lifestealSmp;

public class TournamentCommand implements CommandExecutor {
    private TournamentEvent tournamentEvent;

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (args.length == 0) {
            sender.sendMessage(ChatColor.RED + "Usage: /tournament <start|register|end>");
            return true;
        }

        if (args[0].equalsIgnoreCase("start")) {
            if (tournamentEvent == null) {
                tournamentEvent = new TournamentEvent(ZonedDateTime.now());
                Bukkit.getPluginManager().registerEvents(tournamentEvent, lifestealSmp);
                Bukkit.getScheduler().runTaskLater(lifestealSmp, () -> {
                    tournamentEvent.onEventStart();
                    sender.sendMessage(ChatColor.GREEN + "Tournament event started!!");
                }, 100L);
            } else {
                sender.sendMessage(ChatColor.RED + "Tournament event is already running!");
            }
        } else if (args[0].equalsIgnoreCase("register")) {
            if (sender instanceof Player player) {
                TournamentEvent.registerPlayer(player);
            } else {
                sender.sendMessage(ChatColor.RED + "Only players can register for the tournament!");
            }
        } else if (args[0].equalsIgnoreCase("end")) {
            if (tournamentEvent != null) {
                tournamentEvent.onEventEnd();
                tournamentEvent = null;
                sender.sendMessage(ChatColor.GREEN + "Tournament event ended!");
            } else {
                sender.sendMessage(ChatColor.RED + "No tournament event is running!");
            }
        } else {
            sender.sendMessage(ChatColor.RED + "Unknown command. Usage: /tournament <start|register|end>");
        }

        return true;
    }
}