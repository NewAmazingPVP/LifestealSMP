package newamazingpvp.lifestealsmp.command;

import net.md_5.bungee.api.chat.ClickEvent;
import net.md_5.bungee.api.chat.TextComponent;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class ShopCommand implements CommandExecutor {
    private final String shopURL = "https://shop.nappixel.tk/"; // Replace with your actual shop URL

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (sender instanceof Player) {
            Player player = (Player) sender;

            // Create a clickable link
            TextComponent linkText = new TextComponent("https://shop.nappixel.tk/");
            linkText.setClickEvent(new ClickEvent(ClickEvent.Action.OPEN_URL, shopURL));

            // Send the clickable link to the player
            player.spigot().sendMessage(linkText);
        } else {
            sender.sendMessage("This command can only be executed by a player.");
        }
        return true;
    }
}
