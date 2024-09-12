package newamazingpvp.lifestealsmp.command;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerChatEvent;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ScrambleWordGame implements Listener, CommandExecutor {

    private static boolean isScrambleGameRunning = false;

    private static String word = null;

    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        Player player = (Player) sender;

        if (args.length > 1) {

            player.sendMessage(ChatColor.RED + "plz add a message to do the game with...");

            return false;
        }

        word = args[0];


        List<Character> characters = new ArrayList<>();
        for (char c : word.toCharArray()) {
            characters.add(c);
        }
        Collections.shuffle(characters);

        StringBuilder shuffledString = new StringBuilder();
        for (char c : characters) {
            shuffledString.append(c);
        }


        Bukkit.broadcastMessage(ChatColor.AQUA + "" + ChatColor.BOLD + "==========" + ChatColor.DARK_PURPLE + ChatColor.BOLD + " [Word Scramble] " + ChatColor.AQUA + ChatColor.BOLD + "==========");
        Bukkit.broadcastMessage(" ");
        Bukkit.broadcastMessage(ChatColor.DARK_PURPLE + "Unscramble " + ChatColor.AQUA + ChatColor.BOLD + shuffledString);
        Bukkit.broadcastMessage(ChatColor.DARK_PURPLE + "and say it in chat and win absolutely nothing!");
        Bukkit.broadcastMessage(" ");
        Bukkit.broadcastMessage(ChatColor.AQUA + "" + ChatColor.BOLD + "===============================");


        isScrambleGameRunning = true;

        return true;
    }


    @EventHandler
    public void playerChatEvent(PlayerChatEvent e) {

        if (isScrambleGameRunning) {
            Player player = e.getPlayer();
            String chatMessage = e.getMessage();

            if (chatMessage.equals(word)) {
                isScrambleGameRunning = false;
                String name = player.getName();
                Bukkit.broadcastMessage(ChatColor.GOLD + "" + ChatColor.BOLD + name + " Has guessed it correct!");
                Bukkit.broadcastMessage(ChatColor.AQUA + "" + ChatColor.BOLD + "The word was " + "[" + word + "]");
            }
        }
    }


}
