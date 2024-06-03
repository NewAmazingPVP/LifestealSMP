package newamazingpvp.lifestealsmp.command.unused;

import net.md_5.bungee.api.chat.ClickEvent;
import net.md_5.bungee.api.chat.TextComponent;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class ShopCommand implements CommandExecutor {
    private final String shopURL = "https://shop.nappixel.tk/";

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (sender instanceof Player) {
            Player player = (Player) sender;
            /*if(player.getDisplayName().equals(player.getName())) {
                player.setDisplayName(ChatColor.DARK_GRAY + "[" + ChatColor.AQUA + "Player" + ChatColor.DARK_GRAY + "] " + ChatColor.YELLOW + player.getDisplayName());
                player.sendMessage(player.getDisplayName());
            }*/

            TextComponent linkText = new TextComponent(ChatColor.GOLD + "Here is our shop:" + ChatColor.AQUA + " https://shop.nappixel.tk/");
            linkText.setClickEvent(new ClickEvent(ClickEvent.Action.OPEN_URL, shopURL));

            player.spigot().sendMessage(linkText);
        } else {
            sender.sendMessage("This command can only be executed by a player.");
        }
        return true;
    }
}
