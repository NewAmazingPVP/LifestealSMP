package newamazingpvp.lifestealsmp.listener;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.PrepareAnvilEvent;
import org.bukkit.inventory.AnvilInventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.view.AnvilView;

import static newamazingpvp.lifestealsmp.LifestealSMP.lifestealSmp;
import static newamazingpvp.lifestealsmp.blacklistener.ChatFilter.*;
import static newamazingpvp.lifestealsmp.discord.DiscordBot.sendDiscordMessage;

public class OneExpRename implements Listener {
    @EventHandler
    public void onAnvilPrepare(PrepareAnvilEvent event) {
        AnvilView anvilView = event.getView();

        String renameText = anvilView.getRenameText();


        if (renameText != null && !renameText.isEmpty()) {
            anvilView.setRepairCost(1);
            ItemStack item = event.getInventory().getFirstItem();
            ItemMeta meta = item.getItemMeta();

            String originalMessage = renameText;
            Player player = (Player) event.getView().getPlayer();

            String censoredMessage = censorBlacklistedWords(originalMessage);
            if (shouldBeWarned(originalMessage)) {
                sendDiscordMessage(player.getName() + " possibly tried renaming something bad in anvil. Here is the flagged language " + originalMessage, "1339042765425610803");
            }
            if (!originalMessage.equals(censoredMessage)) {
                meta.setDisplayName(censoredMessage);
                item.setItemMeta(meta);
                player.sendMessage(ChatColor.RED + "Some words or links in your rename were inappropriate and have been censored.");
                player.playSound(player.getLocation(), Sound.BLOCK_NOTE_BLOCK_PLING, 1.0f, 2.0f);
                sendDiscordMessage(player.getName() + " renamed something bad in anvil. Here is the moderated language **" + originalMessage + "**", "1019965981025652738");
                event.setResult(item);
            }
            if (isFlaggedByModeration(originalMessage)) {
                meta.setDisplayName("Message Blocked");
                item.setItemMeta(meta);
                //dont need scheduler
                Bukkit.getScheduler().runTask(lifestealSmp, () -> {
                    event.setResult(item);
                    player.sendMessage(ChatColor.RED + "Your rename was blocked.");
                    player.playSound(player.getLocation(), Sound.BLOCK_NOTE_BLOCK_PLING, 1.0f, 2.0f);
                    sendDiscordMessage(player.getName() + " renamed something bad in anvil. Here is the moderated language **" + originalMessage + "**", "1019965981025652738");
                });
            }

        }
    }
}
