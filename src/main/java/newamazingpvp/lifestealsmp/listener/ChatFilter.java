package newamazingpvp.lifestealsmp.listener;

import org.bukkit.ChatColor;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

import java.io.File;
import java.util.*;
import java.util.regex.Pattern;
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
        String originalMessage = event.getMessage();
        Player player = event.getPlayer();

        String censoredMessage = censorBlacklistedWords(originalMessage);

        if (!originalMessage.equals(censoredMessage)) {
            event.setMessage(censoredMessage);
            player.sendMessage(ChatColor.RED + "Some words in your message were inappropriate and have been censored.");
            player.playSound(player.getLocation(), Sound.BLOCK_NOTE_BLOCK_PLING, 1.0f, 2.0f);
        }
    }

    private String censorBlacklistedWords(String message) {
        String messageWithoutSpaces = message.replaceAll(" ", "");

        for (String word : blacklistWords) {
            String regex = "(?i)" + Pattern.quote(word);
            String replacement = "*".repeat(word.length());
            messageWithoutSpaces = messageWithoutSpaces.replaceAll(regex, replacement);
        }

        StringBuilder censoredMessage = new StringBuilder();
        int spaceIndex = 0;
        for (char c : message.toCharArray()) {
            if (c == ' ') {
                censoredMessage.append(c);
            } else {
                // Ensure spaceIndex does not exceed the length of messageWithoutSpaces
                if (spaceIndex < messageWithoutSpaces.length()) {
                    censoredMessage.append(messageWithoutSpaces.charAt(spaceIndex));
                }
                spaceIndex++;
            }
        }

        return censoredMessage.toString();
    }

}
