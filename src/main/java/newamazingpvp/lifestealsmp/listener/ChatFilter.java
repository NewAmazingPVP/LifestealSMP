package newamazingpvp.lifestealsmp.listener;

import org.bukkit.ChatColor;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

import static newamazingpvp.lifestealsmp.LifestealSMP.lifestealSmp;
import static org.bukkit.Bukkit.getServer;

public class ChatFilter implements Listener {
    public static final ArrayList<String> blacklistWords = new ArrayList<>();

    public static void initializeBlacklist() {
        try {
            Scanner input = new Scanner(new File(lifestealSmp.getDataFolder().getAbsolutePath() + File.separator + "blacklist.csv"));
            while (input.hasNextLine()) {
                String[] temp = input.nextLine().split(",");
                List<String> words = Arrays.asList(temp);
                words = words.stream()
                        .map(word -> word.replaceAll("[,\\s]", ""))
                        .collect(Collectors.toList());

                blacklistWords.addAll(words);
            }
            input.close();
        } catch (Exception e) {
            System.out.println("Error reading or parsing blacklist.csv");
        }
    }


    @EventHandler
    public void onPlayerChat(AsyncPlayerChatEvent event) {
        String message = event.getMessage();
        Player player = event.getPlayer();

        if (containsBlacklistedWord(message)) {
            event.setCancelled(true);
            player.sendMessage(ChatColor.RED + "Don't say inappropriate / offensive words in chat!");
            player.playSound(player.getLocation(), Sound.BLOCK_NOTE_BLOCK_PLING, 1.0f, 2.0f);
        }
    }

    private boolean containsBlacklistedWord(String message) {
        for (String word : blacklistWords) {
            if (message.toLowerCase().contains(word.toLowerCase())) {
                return true;
            }
        }
        return false;
    }
}
