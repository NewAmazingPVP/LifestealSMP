package newamazingpvp.lifestealsmp.command;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

import java.time.Duration;
import java.time.LocalDateTime;

import static newamazingpvp.lifestealsmp.utility.TimeManager.SEASON_START_TIME;

public class ServerRuntime implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        LocalDateTime currentTime = LocalDateTime.now();
        Duration duration = Duration.between(SEASON_START_TIME, currentTime);
        long days = duration.toDays();
        long hours = duration.toHoursPart();
        long minutes = duration.toMinutesPart();

        String uptimeMessage = String.format(
                "This season has been up for" + ChatColor.GOLD + " %d days, %d hours, and %d minutes.",
                days, hours, minutes
        );
        sender.sendMessage(uptimeMessage);
        return true;
    }
}
