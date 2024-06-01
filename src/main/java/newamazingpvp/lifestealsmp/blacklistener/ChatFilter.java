package newamazingpvp.lifestealsmp.blacklistener;

import org.bukkit.ChatColor;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

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
                        .map(word -> word.replaceAll("[,\\s]", ""))
                        .collect(Collectors.toList());

                blacklistWords.addAll(words);
            }
            input.close();
        } catch (Exception e) {
            System.out.println("Error reading or parsing blacklist.csv");
        }
    }


    @EventHandler(priority = EventPriority.LOWEST)
    public void onPlayerChat(AsyncPlayerChatEvent event) {
        String originalMessage = event.getMessage();
        Player player = event.getPlayer();

        String censoredMessage = censorBlacklistedWords(originalMessage);

        if (!originalMessage.equals(censoredMessage)) {
            event.setMessage(censoredMessage);
            player.sendMessage(ChatColor.RED + "Some words or links in your message were inappropriate and have been censored.");
            player.playSound(player.getLocation(), Sound.BLOCK_NOTE_BLOCK_PLING, 1.0f, 2.0f);
        }
    }

    public static String censorBlacklistedWords(String message) {
        // Block URLs
        message = message.replaceAll("(?i)\\b((?:https?|ftp|file)://[-A-Z0-9+&@#/%?=~_|!:,.;]*[-A-Z0-9+&@#/%=~_|])\\b", "*URL_BLOCKED*");

        StringBuilder messageWithoutSpecialChars = new StringBuilder();
        StringBuilder specialChars = new StringBuilder();

        for (char c : message.toCharArray()) {
            if (!Character.isLetterOrDigit(c)) {
                specialChars.append(c);
            } else {
                messageWithoutSpecialChars.append(c);
            }
        }

        String messageWithoutSpecialCharsStr = messageWithoutSpecialChars.toString();

        for (String word : blacklistWords) {
            String regex = "(?i)(?:" + Pattern.quote(word) + ")(?=[^a-zA-Z0-9]|$)";
            String replacement = "*".repeat(word.length());
            messageWithoutSpecialCharsStr = messageWithoutSpecialCharsStr.replaceAll(regex, replacement);
        }

        StringBuilder censoredMessage = new StringBuilder();
        int charIndex = 0;
        for (char c : message.toCharArray()) {
            if (!Character.isLetterOrDigit(c)) {
                censoredMessage.append(specialChars.charAt(0));
                specialChars.deleteCharAt(0);
            } else {
                if (charIndex < messageWithoutSpecialCharsStr.length()) {
                    censoredMessage.append(messageWithoutSpecialCharsStr.charAt(charIndex));
                }
                charIndex++;
            }
        }

        return censoredMessage.toString();
    }
}
