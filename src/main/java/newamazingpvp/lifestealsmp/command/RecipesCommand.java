package newamazingpvp.lifestealsmp.command;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import net.md_5.bungee.api.chat.ClickEvent;
import net.md_5.bungee.api.chat.TextComponent;

public class RecipesCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (sender instanceof Player) {
            Player player = (Player) sender;

            TextComponent message = new TextComponent(ChatColor.GOLD + "**Recipes**");
            message.addExtra("\n");

            TextComponent extraHeartText = new TextComponent(ChatColor.GOLD + " - Extra Heart");
            TextComponent extraHeartLinkText = new TextComponent(" [Link]");
            //extraHeartLinkText.setColor(ChatColor.WHITE);
            extraHeartLinkText.setClickEvent(new ClickEvent(ClickEvent.Action.OPEN_URL, "https://imgur.com/gHqMsFl"));
            extraHeartText.addExtra(extraHeartLinkText);
            message.addExtra(extraHeartText);
            message.addExtra("\n");

            TextComponent reviveBeaconText = new TextComponent(ChatColor.GOLD + " - Revive Beacon");
            TextComponent reviveBeaconLinkText = new TextComponent(" [Link]");
            //reviveBeaconLinkText.setColor(ChatColor.WHITE);
            reviveBeaconLinkText.setClickEvent(new ClickEvent(ClickEvent.Action.OPEN_URL, "https://imgur.com/9LGQ06M"));
            reviveBeaconText.addExtra(reviveBeaconLinkText);
            message.addExtra(reviveBeaconText);
            message.addExtra("\n");

            TextComponent shulkerBoxText = new TextComponent(ChatColor.GOLD + " - Shulker Box");
            TextComponent shulkerBoxLinkText = new TextComponent(" [Link]");
            //shulkerBoxLinkText.setColor(ChatColor.WHITE);
            shulkerBoxLinkText.setClickEvent(new ClickEvent(ClickEvent.Action.OPEN_URL, "https://media.discordapp.net/attachments/1031334605200044112/1133885868642418810/image.png"));
            shulkerBoxText.addExtra(shulkerBoxLinkText);
            message.addExtra(shulkerBoxText);
            message.addExtra("\n");

            TextComponent endstoneText = new TextComponent(ChatColor.GOLD + " - Endstone");
            TextComponent endstoneLinkText = new TextComponent(" [Link]");
            //endstoneLinkText.setColor(ChatColor.WHITE);
            endstoneLinkText.setClickEvent(new ClickEvent(ClickEvent.Action.OPEN_URL, "https://media.discordapp.net/attachments/1031334605200044112/1133886044547325962/image.png"));
            endstoneText.addExtra(endstoneLinkText);
            message.addExtra(endstoneText);
            message.addExtra("\n");

            TextComponent purpurBlockText = new TextComponent(ChatColor.GOLD + " - Purpur Block");
            TextComponent purpurBlockLinkText = new TextComponent(" [Link]");
            //purpurBlockLinkText.setColor(ChatColor.WHITE);
            purpurBlockLinkText.setClickEvent(new ClickEvent(ClickEvent.Action.OPEN_URL, "https://media.discordapp.net/attachments/1112379346439655495/1133888846409519195/image.png"));
            purpurBlockText.addExtra(purpurBlockLinkText);
            message.addExtra(purpurBlockText);
            message.addExtra("\n");

            TextComponent miningPickaxeText = new TextComponent(ChatColor.GOLD + " - Custom 3x3 Mining Pickaxe");
            TextComponent miningPickaxeLinkText = new TextComponent(" [Link]");
            //miningPickaxeLinkText.setColor(ChatColor.WHITE);
            miningPickaxeLinkText.setClickEvent(new ClickEvent(ClickEvent.Action.OPEN_URL, "https://i.imgur.com/EJCm12d.png"));
            miningPickaxeText.addExtra(miningPickaxeLinkText);
            message.addExtra(miningPickaxeText);
            message.addExtra("\n");

            TextComponent featherSwordText = new TextComponent(ChatColor.GOLD + " - Custom Feather sword - Gives speed while holding and allows to tp 5 blocks in front every minute");
            TextComponent featherSwordLinkText = new TextComponent(" [Link]");
            //featherSwordLinkText.setColor(ChatColor.WHITE);
            featherSwordLinkText.setClickEvent(new ClickEvent(ClickEvent.Action.OPEN_URL, "https://i.imgur.com/UfQYd3Y.png"));
            featherSwordText.addExtra(featherSwordLinkText);
            message.addExtra(featherSwordText);
            message.addExtra("\n");

            TextComponent teleportingBowText = new TextComponent(ChatColor.GOLD + " - Custom Teleporting bow");
            TextComponent teleportingBowLinkText = new TextComponent(" [Link]");
            //teleportingBowLinkText.setColor(ChatColor.WHITE);
            teleportingBowLinkText.setClickEvent(new ClickEvent(ClickEvent.Action.OPEN_URL, "https://i.imgur.com/qWzpp3b.png"));
            teleportingBowText.addExtra(teleportingBowLinkText);
            message.addExtra(teleportingBowText);
            message.addExtra("\n");

            TextComponent tntBowText = new TextComponent(ChatColor.GOLD + " - Custom TNT bow");
            TextComponent tntBowLinkText = new TextComponent(" [Link]");
            //tntBowLinkText.setColor(ChatColor.WHITE);
            tntBowLinkText.setClickEvent(new ClickEvent(ClickEvent.Action.OPEN_URL, "https://i.imgur.com/m3YVrj7.png"));
            tntBowText.addExtra(tntBowLinkText);
            message.addExtra(tntBowText);

            // Send the message to the player
            player.spigot().sendMessage(message);
        }
        return true;
    }
}
