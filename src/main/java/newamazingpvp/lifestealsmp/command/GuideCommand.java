package newamazingpvp.lifestealsmp.command;

import newamazingpvp.lifestealsmp.utility.CooldownManager;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.BookMeta;

import java.util.HashMap;
import java.util.UUID;

public class GuideCommand implements CommandExecutor {

    private final HashMap<UUID, CooldownManager> playerCooldowns = new HashMap<>();

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (sender instanceof Player p) {
            UUID playerId = p.getUniqueId();
            CooldownManager cooldown = playerCooldowns.getOrDefault(playerId, new CooldownManager());

            if (cooldown.isOnCooldown()) {
                p.sendMessage("You must wait " + cooldown.getRemainingSeconds() + " seconds before using this command again.");
                return true;
            }

            cooldown.setCooldown(10);
            playerCooldowns.put(playerId, cooldown);

            p.getInventory().addItem(createTutorialBook());
            p.sendMessage("You were given the server tutorial book!");
        }
        return true;
    }

    private ItemStack createTutorialBook() {
        ItemStack book = new ItemStack(Material.WRITTEN_BOOK);
        BookMeta meta = (BookMeta) book.getItemMeta();

        meta.setTitle("Lifesteal SMP Guide");
        meta.setAuthor("NapPixel Admins");

        meta.addPage("Welcome to Lifesteal SMP!\n\nThis guide will help you understand the mechanics of lifesteal in our server");
        meta.addPage("In this Lifesteal SMP players get more hearts by killing or crafting and lose hearts by getting killed");
        meta.addPage("We also have twists such as tracking and custom items to spice it up! /recipes");
        meta.addPage("Why not learn everything about this by joining /discord ??");
        meta.addPage("Forms teams make alliances fight and eliminate opponents!");
        meta.addPage("Its only fun if you get involved with the discord community!");
        meta.addPage("We ensure fair and fun gameplay for players on any platform and have balances to make sure nobody abuses");
        meta.addPage("Learn more about this by /help and by joining /discord");

        book.setItemMeta(meta);
        return book;
    }
}
