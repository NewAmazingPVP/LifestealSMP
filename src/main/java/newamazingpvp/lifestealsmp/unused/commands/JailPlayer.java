package newamazingpvp.lifestealsmp.unused.commands;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Color;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.LeatherArmorMeta;
import org.bukkit.scoreboard.Scoreboard;
import org.bukkit.scoreboard.ScoreboardManager;
import org.bukkit.scoreboard.Team;

import java.util.ArrayList;
import java.util.List;

public class JailPlayer implements CommandExecutor {

    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (args.length != 1) {
            sender.sendMessage("Usage: /set prisoner <player>");
            return true;
        }

        String playerName = args[0];
        Player player = Bukkit.getPlayerExact(playerName);
        if (player == null) {
            sender.sendMessage("Player not found.");
            return true;
        }

        ScoreboardManager scoreboardManager = Bukkit.getScoreboardManager();
        if (scoreboardManager == null) {
            sender.sendMessage("Scoreboard manager not available.");
            return true;
        }

        Scoreboard scoreboard = scoreboardManager.getMainScoreboard();
        Team team = scoreboard.getTeam("prisoner");
        if (team == null) {
            team = scoreboard.registerNewTeam("prisoner");
        }

        team.setColor(ChatColor.GOLD);
        team.setPrefix("[Hacker] ");
        team.addEntry(player.getName());

        sender.sendMessage(ChatColor.GOLD + playerName + " is now a prisoner!");

        if (player.getScoreboard().getEntryTeam(player.getName()).getName().equalsIgnoreCase("prisoner")) {

            ItemStack chestplate = new ItemStack(Material.LEATHER_CHESTPLATE);
            LeatherArmorMeta chestplateMeta = (LeatherArmorMeta) chestplate.getItemMeta();
            chestplateMeta.setDisplayName(ChatColor.GOLD + "" + ChatColor.BOLD + "Prisoner Uniform");
            chestplateMeta.setColor(Color.fromRGB(255, 85, 0));
            chestplateMeta.setUnbreakable(true);
            List<String> CHESTPLATELORE = new ArrayList<>();
            CHESTPLATELORE.add(ChatColor.DARK_RED + "Given to hackers");
            chestplateMeta.setLore(CHESTPLATELORE);
            chestplateMeta.addItemFlags(ItemFlag.HIDE_DYE);
            chestplateMeta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
            chestplateMeta.addItemFlags(ItemFlag.HIDE_UNBREAKABLE);
            chestplate.setItemMeta(chestplateMeta);

            ItemStack leggings = new ItemStack(Material.LEATHER_LEGGINGS);
            LeatherArmorMeta leggingsMeta = (LeatherArmorMeta) leggings.getItemMeta();
            leggingsMeta.setDisplayName(ChatColor.GOLD + "" + ChatColor.BOLD + "Prisoner Uniform");
            leggingsMeta.setColor(Color.fromRGB(255, 85, 0));
            leggingsMeta.setUnbreakable(true);
            List<String> LEGGINGSLORE = new ArrayList<>();
            CHESTPLATELORE.add(ChatColor.DARK_RED + "Given to hackers");
            leggingsMeta.setLore(LEGGINGSLORE);
            leggingsMeta.addItemFlags(ItemFlag.HIDE_DYE);
            leggingsMeta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
            leggingsMeta.addItemFlags(ItemFlag.HIDE_UNBREAKABLE);
            leggings.setItemMeta(leggingsMeta);

            ItemStack boots = new ItemStack(Material.LEATHER_BOOTS);
            LeatherArmorMeta bootsMeta = (LeatherArmorMeta) boots.getItemMeta();
            bootsMeta.setDisplayName(ChatColor.GOLD + "" + ChatColor.BOLD + "Prisoner Uniform");
            bootsMeta.setColor(Color.fromRGB(255, 85, 0));
            bootsMeta.setUnbreakable(true);
            List<String> BOOTSLORE = new ArrayList<>();
            CHESTPLATELORE.add(ChatColor.DARK_RED + "Given to hackers");
            bootsMeta.setLore(BOOTSLORE);
            bootsMeta.addItemFlags(ItemFlag.HIDE_DYE);
            bootsMeta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
            bootsMeta.addItemFlags(ItemFlag.HIDE_UNBREAKABLE);
            boots.setItemMeta(bootsMeta);


            player.getInventory().setHelmet(null);
            player.getInventory().setChestplate(chestplate);
            player.getInventory().setLeggings(leggings);
            player.getInventory().setBoots(boots);
            return true;
        }
        return false;
    }
}
