package newamazingpvp.lifestealsmp.blacklistener;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import org.bukkit.event.player.PlayerChatEvent;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Pattern;

import static newamazingpvp.lifestealsmp.LifestealSMP.lifestealSmp;

public class ChatFilter implements Listener {
    public static final ArrayList<String> blacklistWords = new ArrayList<>();

    public static void initializeBlacklist() {
        try {
            Scanner input = new Scanner(new File(lifestealSmp.getDataFolder().getAbsolutePath() + File.separator + "blacklist.csv"));
            while (input.hasNextLine()) {
                String[] temp = input.nextLine().split(",");
                List<String> words = Arrays.asList(temp);
                words = words.stream()
                        .map(word -> word.replace(" ", ""))
                        .toList();

                blacklistWords.addAll(words);
            }
            input.close();

            blacklistWords.sort((a, b) -> Integer.compare(b.length(), a.length()));
        } catch (Exception e) {
            System.out.println("Error reading or parsing blacklist.csv");
        }
    }



    @EventHandler(priority = EventPriority.LOWEST)
    public void onPlayerChatLowest(AsyncPlayerChatEvent event) {
        checkMessage(event);
    }

    @EventHandler(priority = EventPriority.HIGHEST)
    public void onPlayerChatHighest(AsyncPlayerChatEvent event) {
        checkMessage(event);
    }

    @EventHandler
    public void onPlayerChatNormal(AsyncPlayerChatEvent event) {
        checkMessage(event);
    }

    @EventHandler(priority = EventPriority.LOW)
    public void onPlayerChatLow(AsyncPlayerChatEvent event) {
        checkMessage(event);
    }

    @EventHandler(priority = EventPriority.HIGH)
    public void onPlayerChatHigh(AsyncPlayerChatEvent event) {
        checkMessage(event);
    }

    private void checkMessage(AsyncPlayerChatEvent event) {
        Bukkit.getScheduler().runTask(lifestealSmp, () -> {
            String originalMessage = event.getMessage();
            Player player = event.getPlayer();

            String censoredMessage = censorBlacklistedWords(originalMessage);

            if (!originalMessage.equals(censoredMessage)) {
                event.setMessage(censoredMessage);
                player.sendMessage(ChatColor.RED + "Some words or links in your message were inappropriate and have been censored.");
                player.playSound(player.getLocation(), Sound.BLOCK_NOTE_BLOCK_PLING, 1.0f, 2.0f);
            }
        });
    }

    @EventHandler
    public void onPlayerChatSync(PlayerChatEvent event) {
        String originalMessage = event.getMessage();
        Player player = event.getPlayer();

        String censoredMessage = censorBlacklistedWords(originalMessage);

        if (!originalMessage.equals(censoredMessage)) {
            event.setMessage(censoredMessage);
            player.sendMessage(ChatColor.RED + "Some words or links in your message were inappropriate and have been censored.");
            player.playSound(player.getLocation(), Sound.BLOCK_NOTE_BLOCK_PLING, 1.0f, 2.0f);
        }
    }

    @EventHandler(priority = EventPriority.MONITOR)
    public void onPlayerChatMonitor(AsyncPlayerChatEvent event) {
        checkMessage(event);
    }

    public static String censorBlacklistedWords(String message) {
        if (!message.toLowerCase().contains("textures.minecraft.net")) {
            message = message.replaceAll("(?i)\\b((?:https?|ftp|file)://[-A-Z0-9+&@#/%?=~_|!:,.;]*[-A-Z0-9+&@#/%=~_|])\\b", "*URL_BLOCKED*");
        }

        for (String word : blacklistWords) {
            if (message.toLowerCase().contains(word.toLowerCase())) {
                message = message.replaceAll("(?i)" + Pattern.quote(word), "*".repeat(word.length()));
            }

            String cleanedMessage = filterBypasses(message);
            String cleanedWord = filterBypasses(word);

            if (cleanedMessage.contains(cleanedWord)) {
                StringBuilder sb = new StringBuilder("(?i)");
                for (int i = 0; i < word.length(); i++) {
                    sb.append(Pattern.quote(String.valueOf(word.charAt(i))));
                    if (i < word.length() - 1) {
                        sb.append("[^a-zA-Z0-9]*");
                    }
                }
                String regex = sb.toString();
                message = message.replaceAll(regex  , "*".repeat(word.length()));
            }
        }

        return message;
    }

    private static String filterBypasses(String input) {
        input = input.replaceAll("[^a-zA-Z0-9]", "");
        input = input.toLowerCase();

        StringBuilder sb = new StringBuilder();
        char last = '\0';
        for (char c : input.toCharArray()) {
            if (c != last) {
                sb.append(c);
                last = c;
            }
        }
        return sb.toString();
    }


}
