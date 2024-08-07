package newamazingpvp.lifestealsmp.unused.events.raffle;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class ItemStacks {

    public static ItemStack raffleTicket(UUID eventNum) {
        ItemStack raffleTicket = new ItemStack(Material.PAPER);
        ItemMeta meta = raffleTicket.getItemMeta();
        meta.setDisplayName(ChatColor.GOLD + "" + ChatColor.BOLD + "Raffle Ticket");
        List<String> lore = new ArrayList<>();
        lore.add(ChatColor.DARK_PURPLE + "Right click within 150 blocks");
        lore.add(ChatColor.DARK_PURPLE + "of spawn to submit!");
        lore.add(" ");
        lore.add(ChatColor.DARK_GRAY + "E " + eventNum);
        meta.setLore(lore);
        raffleTicket.setItemMeta(meta);
        return raffleTicket;
    }

    public static ItemStack rafflePickaxe() {
        ItemStack raffleTicket = new ItemStack(Material.IRON_PICKAXE);
        ItemMeta meta = raffleTicket.getItemMeta();
        meta.setDisplayName(ChatColor.GOLD + "" + ChatColor.BOLD + "Raffle Pickaxe");
        List<String> lore = new ArrayList<>();
        lore.add(ChatColor.DARK_PURPLE + "Has a chance to randomly spawn");
        lore.add(ChatColor.DARK_PURPLE + "in special mobs when a block in broken");
        lore.add(ChatColor.DARK_PURPLE + "during a raffle event!");
        meta.setLore(lore);
        raffleTicket.setItemMeta(meta);
        return raffleTicket;
    }


}
