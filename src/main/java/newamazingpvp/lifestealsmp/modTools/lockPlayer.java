package newamazingpvp.lifestealsmp.modTools;

import com.destroystokyo.paper.event.player.PlayerJumpEvent;
import org.bukkit.*;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.LeatherArmorMeta;
import org.bukkit.scoreboard.Scoreboard;
import org.bukkit.scoreboard.ScoreboardManager;
import org.bukkit.scoreboard.Team;

import java.util.ArrayList;
import java.util.List;

public class lockPlayer implements CommandExecutor {

    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (args.length != 1) {
            sender.sendMessage("Usage: /lock <player>");
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
        Team team = scoreboard.getTeam("locked");
        if (team == null) {
            team = scoreboard.registerNewTeam("locked");
        }

        team.setColor(ChatColor.BLUE);
        team.setPrefix("[Locked]");

        sender.sendMessage(ChatColor.DARK_RED + playerName + " is now locked!");

        if (player.getScoreboard().getEntryTeam(player.getName()).getName().equalsIgnoreCase("locked")) {

            player.removeScoreboardTag("locked");
            sender.sendMessage(ChatColor.DARK_GREEN + playerName + " is no longer locked!");

            return true;
        }else {
            team.addEntry(player.getName());
            sender.sendMessage(ChatColor.DARK_RED + playerName + " is now locked!");
        }
        return false;
    }

    /*@EventHandler
    public void onPlayerMove(PlayerMoveEvent event) {
        Player player = event.getPlayer();
        if (player.getScoreboard().getEntryTeam(player.getName()).getName().equalsIgnoreCase("locked")) {
            event.setCancelled(true);
        }
    }
    @EventHandler
    public void onPlayerJump(PlayerJumpEvent event) {
        Player player = event.getPlayer();
        if (player.getScoreboard().getEntryTeam(player.getName()).getName().equalsIgnoreCase("locked")) {
            event.setCancelled(true);
        }
    }*/

    @EventHandler
    public void onPlayerHit(BlockPlaceEvent event) {
        Player player = event.getPlayer();
        if (player.getScoreboard().getEntryTeam(player.getName()).getName().equalsIgnoreCase("locked")) {
            event.setCancelled(true);
        }
    }

    @EventHandler
    public void onPlayerPlace(BlockBreakEvent event) {
        Player player = event.getPlayer();
        if (player.getScoreboard().getEntryTeam(player.getName()).getName().equalsIgnoreCase("locked")) {
            event.setCancelled(true);
        }
    }

    @EventHandler
    public void onPlayerInteract(PlayerInteractEvent event) {
        Player player = event.getPlayer();
        if (player.getScoreboard().getEntryTeam(player.getName()).getName().equalsIgnoreCase("locked")) {
            event.setCancelled(true);
        }
    }

    @EventHandler
    public void onPlayerInteract2(EntityDamageByEntityEvent event) {
        Player player = (Player) event.getDamager();
        if (player.getScoreboard().getEntryTeam(player.getName()).getName().equalsIgnoreCase("locked")) {
            event.setCancelled(true);
        }
    }

    @EventHandler
    public void onMenuClick(InventoryClickEvent event) {
        Player player = (Player) event.getWhoClicked();
        if (player.getScoreboard().getEntryTeam(player.getName()).getName().equalsIgnoreCase("locked")) {
            event.setCancelled(true);
        }
    }
}

