package newamazingpvp.lifestealsmp.game;

import net.md_5.bungee.api.chat.ClickEvent;
import net.md_5.bungee.api.chat.TextComponent;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;

public class BroadcastMessage {
    public static void broadcastServerMessage() {
        String discordLink = "https://discord.gg/PN8egFY3ap";
        String planetMinecraftLink = "https://www.planetminecraft.com/server/nappixel-lifesteal-smp-server-new-season-starts-today/vote/";
        String minecraftServersLink = "https://minecraftservers.org/vote/653407";

        TextComponent message = new TextComponent(ChatColor.GOLD + "Make sure you have joined the Discord server and voted for outreach to more players!\n");

        TextComponent discordText = new TextComponent(ChatColor.BLUE + "Discord: ");
        TextComponent discordLinkText = new TextComponent("Click here");
        discordLinkText.setClickEvent(new ClickEvent(ClickEvent.Action.OPEN_URL, discordLink));
        discordText.addExtra(discordLinkText);
        message.addExtra(discordText);
        message.addExtra("\n");

        TextComponent planetMinecraftText = new TextComponent(ChatColor.BLUE + "Planet Minecraft: ");
        TextComponent planetMinecraftLinkText = new TextComponent("Click here");
        planetMinecraftLinkText.setClickEvent(new ClickEvent(ClickEvent.Action.OPEN_URL, planetMinecraftLink));
        planetMinecraftText.addExtra(planetMinecraftLinkText);
        message.addExtra(planetMinecraftText);
        message.addExtra("\n");

        TextComponent minecraftServersText = new TextComponent(ChatColor.BLUE + "Minecraft Servers: ");
        TextComponent minecraftServersLinkText = new TextComponent("Click here");
        minecraftServersLinkText.setClickEvent(new ClickEvent(ClickEvent.Action.OPEN_URL, minecraftServersLink));
        minecraftServersText.addExtra(minecraftServersLinkText);
        message.addExtra(minecraftServersText);

        Bukkit.spigot().broadcast(message);
    }
    public static void broadcastWarningMessage() {
        String discordLink = "https://discord.gg/PN8egFY3ap";
        String warningMessage = "**WARNING** The server is going private, so make sure to join the Discord server to be able to play next season! ";

        TextComponent message = new TextComponent(ChatColor.RED + warningMessage);

        TextComponent discordText = new TextComponent(ChatColor.BLUE + "Click here: https://discord.gg/PN8egFY3ap");
        discordText.setClickEvent(new ClickEvent(ClickEvent.Action.OPEN_URL, discordLink));
        message.addExtra(discordText);

        Bukkit.spigot().broadcast(message);
    }
}
