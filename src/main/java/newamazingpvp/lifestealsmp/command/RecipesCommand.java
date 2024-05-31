package newamazingpvp.lifestealsmp.command;

import net.md_5.bungee.api.chat.ClickEvent;
import net.md_5.bungee.api.chat.TextComponent;
import newamazingpvp.lifestealsmp.game.CustomRecipe;
import org.bukkit.ChatColor;
import org.bukkit.Sound;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class RecipesCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (sender instanceof Player) {
            Player player = (Player) sender;

            TextComponent message = new TextComponent(ChatColor.GOLD + "**Recipes**");
            message.addExtra("\n");

            TextComponent extraHeartText = new TextComponent(ChatColor.GOLD + " - Extra Heart");
            addRecipeLink(extraHeartText, "https://i.imgur.com/6IWV6J4.png");
            message.addExtra(extraHeartText);
            message.addExtra("\n");

            TextComponent reviveBeaconText = new TextComponent(ChatColor.GOLD + " - Revive Beacon");
            addRecipeLink(reviveBeaconText, "https://i.imgur.com/XN1H5YF.png");
            message.addExtra(reviveBeaconText);
            message.addExtra("\n");

            TextComponent shulkerBoxText = new TextComponent(ChatColor.GOLD + " - Shulker Box");
            addRecipeLink(shulkerBoxText, "https://media.discordapp.net/attachments/1031334605200044112/1133885868642418810/image.png");
            message.addExtra(shulkerBoxText);
            message.addExtra("\n");

            TextComponent endstoneText = new TextComponent(ChatColor.GOLD + " - Endstone");
            addRecipeLink(endstoneText, "https://media.discordapp.net/attachments/1031334605200044112/1133886044547325962/image.png");
            message.addExtra(endstoneText);
            message.addExtra("\n");

            TextComponent purpurBlockText = new TextComponent(ChatColor.GOLD + " - Purpur Block");
            addRecipeLink(purpurBlockText, "https://media.discordapp.net/attachments/1112379346439655495/1133888846409519195/image.png");
            message.addExtra(purpurBlockText);
            message.addExtra("\n");

            TextComponent miningPickaxeText = new TextComponent(ChatColor.GOLD + " - Custom 3x3 Mining Pickaxe");
            addRecipeLink(miningPickaxeText, "https://i.imgur.com/xUBJPvd.png");
            message.addExtra(miningPickaxeText);
            message.addExtra("\n");

            TextComponent featherSwordText = new TextComponent(ChatColor.GOLD + " - Custom Feather sword - Gives speed while holding and allows to tp 5 blocks in front every minute");
            addRecipeLink(featherSwordText, "https://i.imgur.com/mZXrbDk.png");
            message.addExtra(featherSwordText);
            message.addExtra("\n");

            TextComponent teleportingBowText = new TextComponent(ChatColor.GOLD + " - Custom Teleporting bow");
            addRecipeLink(teleportingBowText, "https://i.imgur.com/Kn654zx.png");
            message.addExtra(teleportingBowText);
            message.addExtra("\n");

            TextComponent tntBowText = new TextComponent(ChatColor.GOLD + " - Custom TNT bow");
            addRecipeLink(tntBowText, "https://i.imgur.com/MO3tB8T.png");
            message.addExtra(tntBowText);
            message.addExtra("\n");

            TextComponent treeBreakdownAxeText = new TextComponent(ChatColor.GOLD + " - Custom Tree Cutter Axe");
            addRecipeLink(treeBreakdownAxeText, "https://i.imgur.com/Fd0rFjh.png");
            message.addExtra(treeBreakdownAxeText);

            TextComponent homingBowText = new TextComponent(ChatColor.GOLD + " - Custom Homing Bow");
            addRecipeLink(homingBowText, "https://i.imgur.com/gc7sjpZ.png");
            message.addExtra(homingBowText);
            message.addExtra("\n");


            player.spigot().sendMessage(message);
            CustomRecipe.openRecipesGUI(player);

            player.playSound(player.getLocation(), Sound.BLOCK_NOTE_BLOCK_PLING, 1.0f, 2.0f);
        }
        return true;
    }

    // Helper method to add a link to a TextComponent
    private void addRecipeLink(TextComponent textComponent, String link) {
        TextComponent linkText = new TextComponent(" [Link]");
        linkText.setClickEvent(new ClickEvent(ClickEvent.Action.OPEN_URL, link));
        textComponent.addExtra(linkText);
    }
}
