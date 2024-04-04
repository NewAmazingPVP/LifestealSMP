package newamazingpvp.lifestealsmp.command;

import net.md_5.bungee.api.chat.ClickEvent;
import net.md_5.bungee.api.chat.TextComponent;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class DiscordLink implements CommandExecutor {
    private final String discordURL = "https://discord.gg/PN8egFY3ap";

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (sender instanceof Player) {
            Player player = (Player) sender;

            TextComponent linkText = new TextComponent(ChatColor.GOLD + "Here is our discord:" + ChatColor.AQUA + " https://discord.gg/PN8egFY3ap");
            linkText.setClickEvent(new ClickEvent(ClickEvent.Action.OPEN_URL, discordURL));

            player.spigot().sendMessage(linkText);
        } else {
            sender.sendMessage("This command can only be executed by a player.");
        }
        return true;
    }
}
