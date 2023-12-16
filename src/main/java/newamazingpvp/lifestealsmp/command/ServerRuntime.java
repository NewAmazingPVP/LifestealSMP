package newamazingpvp.lifestealsmp.command;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

import java.time.Duration;
import java.time.LocalDateTime;

public class ServerRuntime implements CommandExecutor {
    private final LocalDateTime serverStartTime = LocalDateTime.of(2023, 12, 9, 11, 30);

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        LocalDateTime currentTime = LocalDateTime.now();
        Duration duration = Duration.between(serverStartTime, currentTime);
        long days = duration.toDays();
        long hours = duration.toHoursPart();
        long minutes = duration.toMinutesPart();

        String uptimeMessage = String.format(
                "The server started on" + ChatColor.AQUA + " 12/9/23 11:30am est" + ChatColor.WHITE + " and has been up for" + ChatColor.GOLD + " %d days, %d hours, and %d minutes.",
                days, hours, minutes
        );
        return true;
    }
}
