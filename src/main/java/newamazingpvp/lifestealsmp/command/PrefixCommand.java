package newamazingpvp.lifestealsmp.command;

import org.bukkit.ChatColor;
import org.bukkit.Sound;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.regex.Pattern;

import static newamazingpvp.lifestealsmp.blacklistener.ChatFilter.censorBlacklistedWords;
import static newamazingpvp.lifestealsmp.utility.Utils.getPrefix;
import static newamazingpvp.lifestealsmp.utility.Utils.setPrefix;

public class PrefixCommand implements CommandExecutor {
    private static final Pattern HEX_REGEX = Pattern.compile("&#([0-9A-F])([0-9A-F])([0-9A-F])([0-9A-F])([0-9A-F])([0-9A-F])", Pattern.CASE_INSENSITIVE);
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (sender instanceof Player) {
            if (args.length == 1) {
                String originalMessage = args[0];
                Player player = (Player) sender;

                String censoredMessage = censorBlacklistedWords(originalMessage);

                if (!originalMessage.equals(censoredMessage)) {
                    originalMessage = censoredMessage;
                    player.sendMessage(ChatColor.RED + "Some words/phrases in your prefix were inappropriate and have been censored.");
                    player.playSound(player.getLocation(), Sound.BLOCK_NOTE_BLOCK_PLING, 1.0f, 2.0f);
                }
                originalMessage = replace(originalMessage);
                originalMessage = originalMessage.replace("§", "&");
                setPrefix(player, originalMessage);
                player.sendMessage(ChatColor.GREEN + "You successfully updated your prefix \n" + ChatColor.RESET + getPrefix(player));
            }
        }
        return true;
    }

    public String replace(String s) {
        return HEX_REGEX.matcher(s).replaceAll("&x&$1&$2&$3&$4&$5&$6");
    }
}
